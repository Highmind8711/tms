
var table;

function setRuleTable(){
	table = $('#ruleTable').DataTable( {
		ajax: {
			url:'../rulesnames',
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
            	data: "rulename" ,
            	title: "角色名称"
            },{ 
            	data: "domainid" ,
            	title: "所属区域"
            },{ 
            	data: "remark" ,
            	title: "标记"
            },{
            	title:"操作",
            	orderable:false,
            }
        ], 
        "columnDefs" : [{
        	"targets" : 4,
        	"data" : null,
        	"render" : function(data, type, row) {
        		var id = '"' + row.id + '"';
	        	var html = "<button type='button' class='btn btn-info btn-xs' data-toggle='modal' data-target='#ruleInfo' onclick='getRule("+ id + ")'><i class='lnr lnr-magnifier'></i></button>" 
	        		 + "&nbsp;<button type='button' class='btn btn-success btn-xs' data-toggle='modal' data-target='#ruleEdit' onclick='editRule("+ id + ")'><i class='lnr lnr-pencil'></i></button>"
	        		 + "&nbsp;<button type='button' class='btn btn-warning btn-xs' data-toggle='modal' data-target='#rulePermissions' onclick='permissionsInit()'><i class='lnr lnr-bookmark'></i></button>"
	        		 + "&nbsp;<button type='button' class='btn btn-danger btn-xs' onclick='delRule("+ id + ")'><i class='lnr lnr-trash'></i></button>"
	        			 
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

function permissionsInit(){
	var str="";
	$.get("../rulesnames", function(data) {
		var _rules = data.data;
		console.log(_rules);
		$.each(_rules,function(i,v){
			str += "<label class='fancy-checkbox'><input type='checkbox' id="+ v.id +"><span>"
				+ v.rulename
				+ "</span></label>"
		});
		$("#rulePermission_Init").html(str);
	});
}


function createRule(){
	var rule = new FormData();
	rule.append("rulename",$("input[name='rulenameArea']").val());	
	rule.append("domainid",$("#domainArea option:selected").val());
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
			contentType:'json',			
	        success: function (data) {
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

function getRule(ruleID){
	
}

function editRule(ruleID){
	
}

$(document).ready(function() {

	setRuleTable();
	

	$("#createRuleBtn").click(function(){
		createRule();
	})

});


