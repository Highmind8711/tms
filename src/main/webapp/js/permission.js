
var table;

function setPermissionTable(){
	table = $('#permissionTable').DataTable( {
		ajax: {
			url:'../permissions',
			dataSrc: 'data',	
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
            	data: "name" ,
            	title: "权限名称"
            },{ 
            	data: "domainid" ,
            	title: "所属区域"
            },{ 
            	data: "grouping" ,
            	title: "权限分组"
            },{ 
            	data: "type" ,
            	title: "权限类型"
            },{ 
            	data: "remark" ,
            	title: "标记"
            },{
            	title:"操作",
            	orderable:false,
            }
        ], 
        "columnDefs" : [{
        	"targets" : 6,
        	"data" : null,
        	"render" : function(data, type, row) {
        		var id_ = '"' + row.id + '"';
        		var row_ = JSON.stringify(row);
	        	var html = "<button type='button' class='btn btn-info btn-xs' data-toggle='modal' data-target='#permissionInfo' onclick='getPermission("+ row_ + ")'><i class='lnr lnr-magnifier'></i></button>" 
	        		 + "&nbsp;<button type='button' class='btn btn-success btn-xs' data-toggle='modal' data-target='#permissionEdit' onclick='editPermission("+ row_ + ")'><i class='lnr lnr-pencil'></i></button>"
	        		 + "&nbsp;<button type='button' class='btn btn-danger btn-xs' onclick='delPermission("+ id_ + ")'><i class='lnr lnr-trash'></i></button>"
	        			 
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

function createPermission(){
	var permission = new FormData();
	permission.append("name",$("input[name='nameArea']").val());	
	permission.append("domainid",$("#domainArea option:selected").val());
	permission.append("grouping",$("#groupingArea option:selected").val());
	permission.append("type",$("#typeArea option:selected").val());
	permission.append("remark",$("textarea[name='remarkArea']").val());

	$.ajax({
        type: "POST",
        url: "../permissions",
        data: permission,
		contentType:false,
		processData:false,
        success: function (data) {
        	if(data.status == 1){
    			alert("添加成功！");   			
    			table.ajax.reload();
    			$('#permissionCreate').modal('hide');
    			
    		}else{
    			alert("添加失败！");
    		}
        },
        error: function (message) {
            console.log(message);
        }
    });	
}

function delPermission(PermissionID){
	if(confirm("确认删除该权限？") == true){
		$.ajax({
	        type: "delete",
	        url: "../permissions/"+PermissionID,	        
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

function getPermission(_permission){
	var str="";
	console.log(_permission);
	str = "<div class='profile-info'><h4 class='heading'>权限信息</h4><ul class='list-unstyled list-justify'><li>权限名称 <span>"
		+ _permission.name 
		+ "</span></li><li>所属区域 <span>" 
		+ _permission.domainid
		+ "</span></li><li>权限分组<span>" 
		+ _permission.grouping
		+ "</span></li><li>权限类型<span>" 
		+ _permission.type
		+ "</span></li><li>备注 <span>" 
		+ _permission.remark
				
	str	+= "</span></li></ul></div><div class='profile-info'><h4 class='heading'>权限类型</h4>" 
			
	/*if(_employee.rules.length != 0){
		$.each(_employee.rules,function(i,v){
			str += "<p>" 
				+ v.rulename
				+ "</p>";   						   			
		});            	
	}else{
		str += "<p>暂无</p>";
	}*/
	
	str	+= "</div>" ;
				
	$("#permissionInfo_detail").html(str);	
}

function editPermission(PermissionID){
	
}

$(document).ready(function() {
	/*页面初始化*/
	navbar();
	
	/*数据初始化*/
	setPermissionTable();
	
	/*操作*/
	$("#createPermissionBtn").click(function(){
		createPermission();
	})

});

function navbar(){
	 $(".navHeader").load("../sys/navbar.html");
}

