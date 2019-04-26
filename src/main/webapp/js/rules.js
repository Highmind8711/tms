
var table;
var domainid = 2;
var permissionsList = {};

function setRuleTable(){
	table = $('#ruleTable').DataTable( {
		ajax: {
			url:'../rules',
			dataSrc: 'data',	
			header: {
				"domainid":domainid
			}
		},
		columns: [
            /*{
	            "class":'details-control',
	            orderable:false,
	            data:null,
	            defaultContent: ''
	        },*/
			{ 
            	data: "id" ,
            	title: "id"
            },{ 
            	data: "rulename" ,
            	title: "角色名称"
            },{ 
            	data: "remark" ,
            	title: "备注"
            },{
            	title:"操作",
            	orderable:false,
            }
        ], 
        "columnDefs" : [{
        	"targets" : 3,
        	"data" : null,
        	"render" : function(data, type, row) {
        		var id_ = '"' + row.id + '"';
        		var row_ = JSON.stringify(row);
	        	var html = "<button type='button' class='btn btn-info btn-xs' data-toggle='modal' data-target='#ruleInfo' onclick='getRule("+ row_ + ")'><i class='lnr lnr-magnifier'></i></button>" 
	        		 + "&nbsp;<button type='button' class='btn btn-success btn-xs' data-toggle='modal' data-target='#ruleEdit' onclick='editRuleInit("+ row_ + ")'><i class='lnr lnr-pencil'></i></button>"
	        		 + "&nbsp;<button type='button' class='btn btn-warning btn-xs' data-toggle='modal' data-target='#rulePermissionsEdit' onclick='getRulePermissions("+ row_ + ")'><i class='lnr lnr-bookmark'></i></button>"
	        		 + "&nbsp;<button type='button' class='btn btn-danger btn-xs' onclick='delRule("+ id_ + ")'><i class='lnr lnr-trash'></i></button>"
	        			 
	        	return html;
        	}
        }],
        "order": [[0, 'asc']],
		"iDisplayLength":10,
        "bAutoWidth" : true,
        "oLanguage": {         
        	"sProcessing" : "正在查询中，请稍后...",               
        	"sLengthMenu" : "显示 _MENU_ 条",               
        	"sZeroRecords" : "没有您要搜索的内容",               
        	"sInfo" : "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",               
        	"sInfoEmpty" : "记录数为0",               
        	"sInfoFiltered" : "(全部记录数 _MAX_ 条)",               
        	"sInfoPostFix" : "",               
        	"sSearch" : "检索内容：",               
        	"sUrl" : "",               
        	"oPaginate": {                   
        		"sFirst" : "第一页",                   
        		"sPrevious" : "上一页",                   
        		"sNext" : "下一页",                    
        		"sLast" : "最后一页"               
        	}
        },
        "searching": true,
        "lengthChange": true,      
    });	
}

function createRule(){
	var rule = new FormData();
	rule.append("rulename",$("input[name='rulenameArea']").val());	
	rule.append("domainid",domainid);
	rule.append("remark",$("textarea[name='remarkArea']").val());

	$.ajax({
        type: "POST",
        url: "../rules",
        data: rule,
		contentType:false,
		processData:false,
        success: function (data) {
        	if(data.status == 1){
    			alert("添加成功！");   			
    			table.ajax.reload();
    			$('#ruleCreate').modal('hide');
    			
    		}else{
    			alert("添加失败！");
    		}
        },
        error: function (message) {
            console.log(message);
        }
    });	
}

function delRule(ruleID){
	if(confirm("确认删除该角色？") == true){
		$.ajax({
	        type: "delete",
	        url: "../rules/"+ruleID,	
	        headers: {'domainid': domainid},
			contentType:'json',			
	        success: function (data) {
	        	console.log(data);
	        	if(data.status == 1){
	    			alert("删除成功！");
	    			table.ajax.reload();
	    		}else{
	    			alert("删除失败！");
	    		}
	        },
	        error: function (message) {
	            console.log(message);
	        }
	    });
	}
}

function getRule(_rule){
	var str="";
	console.log(_rule);
	str = "<div class='profile-info'><h4 class='heading'>角色信息</h4><ul class='list-unstyled list-justify'><li>角色名称 <span>"
		+ _rule.rulename 
		+ "</span></li><li>所属区域 <span>" 
		+ _rule.domainid
		+ "</span></li><li>备注 <span>" 
		+ _rule.remark
				
	str	+= "</span></li></ul></div><div class='profile-info'><h4 class='heading'>权限分配</h4>" 
	
	if(_rule.permissions != null){
		if(_rule.permissions.length != 0 ){
			$.each(_rule.permissions,function(i,v){
				str += "<p>" 
					+ v.name
					+ "</p>";   						   			
			});            	
		}else{
			str += "<p>暂无</p>";
		}
	}else{
		str += "<p>暂无</p>";
	}
	
	
	str	+= "</div>" ;
			
	$("#ruleInfo_detail").html(str);	
}

function editRuleInit(_rule){
	
	$("input[name='ruleIdEdit']").val(_rule.id)
	$("input[name='rulenameEdit']").val(_rule.rulename);
	$("textarea[name='remarkEdit']").val(_rule.remark);
	
}

function editRule(){
	
	var _rules = {};
	
	_rules["id"]=$("input[name='ruleIdEdit']").val();
	_rules["rulename"]=$("input[name='rulenameEdit']").val();
	_rules["remark"]=$("textarea[name='remarkEdit']").val();
	
	$.ajax({
		type: "put",
        url: "../rules",
        data: _rules,
        success:function(data){
        	if(data.status == 1){
        		alert("修改成功！");
        		table.ajax.reload();
        		$('#ruleEdit').modal('hide');
        	}else{
        		alert("修改失败！");
        	} 	
        },
        error: function (message) {
            console.log(message);
        }  
	})	
}

function rulePermissionsInit(){
	$.get("../permissions", function(data) {
		if(data.status == 1){
			permissionsList = data.data;
		}else{
			console.log(data.error);
		}
	});
}

function getRulePermissions(_rule){
	
	var str="";
	var ruPermissionsList=[];	
	$("#rulePermissions_Init").html("");
	$("input[name='rulePermissionsId']").val(_rule.id);
	
	if(_rule.permissions != null){
		if(_rule.permission.length != 0){
			$.each(_rule.permission,function(i,v){
				ruPermissionsList.push({"id":v.id,"name":v.name});
			});		
		}
	}
		
	$.each(permissionsList,function(i,v){	
		str += "<label class='fancy-checkbox' ><input type='checkbox' name='ruPermissions' value="+ v.id +"><span>"
		+ v.name
		+ "</span></label>"			
	});		
	$("#rulePermissions_Init").html(str);
	
	$.each(permissionsList,function(i,v){	
		$.each(ruPermissionsList,function(j,w){
			if(w.id == v.id){
				$("input[type=checkbox][name='ruPermissions'][value='"+w.id+"']").prop('checked', true);
			}
		})			
	});		
}

function editRulePermissions(){
	
	var ruPermissions = [];
	var ruPermissionsChecked = $("input[name='ruPermissions']:checked");
		
	$.each(ruPermissionsChecked,function(i,v){	
		ruPermissions.push({
			"domainid":domainid,
			"rule_id":$("input[name='rulePermissionsId']").val(),
			"permission_id":this.value
		})			
	});
	
	console.log(ruPermissions);
	
	$.ajax({
		type: "post",
        url: "../rulepermissions",
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify(ruPermissions),
        success:function(data){
        	if(data.status == 1){
        		alert("角色权限分配成功！");
        		table.ajax.reload();
        		$('#rulePermissionsEdit').modal('hide');
        	}else{
        		alert("角色权限分配失败！");
        	} 	
        },
        error: function (message) {
            console.log(message);
        }  
	})
		
}

$(document).ready(function() {
	
	/*页面初始化*/
	navbar();
	
	/*数据初始化*/
	setRuleTable();
	rulePermissionsInit();

	/*操作*/
	$("#createRuleBtn").click(function(){
		createRule();
	})
	$("#editRuleBtn").click(function(){
		editRule();
	})
	$("#editRulePermissionsBtn").click(function(){
		editRulePermissions();
	})

});

function navbar(){
	 $(".navHeader").load("../sys/navbar.html");
}
