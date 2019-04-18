
var table;

function setOperationTable(){
	table = $('#operationTable').DataTable( {
		ajax: {
			url:'../operations',
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
            	title: "操作名称"
            },{ 
            	data: "botton_id" ,
            	title: "操作按钮ID"
            },{ 
            	data: "domainid" ,
            	title: "所属区域"
            },{ 
            	data: "remark" ,
            	title: "备注"
            },{
            	title:"操作",
            	orderable:false,
            }
        ], 
        "columnDefs" : [{
        	"targets" : 5,
        	"data" : null,
        	"render" : function(data, type, row) {
        		var id_ = '"' + row.id + '"';
        		var row_ = JSON.stringify(row);
	        	var html = "<button type='button' class='btn btn-info btn-xs' data-toggle='modal' data-target='#operationInfo' onclick='getOperation("+ row_ + ")'><i class='lnr lnr-magnifier'></i></button>" 
	        		 + "&nbsp;<button type='button' class='btn btn-success btn-xs' data-toggle='modal' data-target='#operationEdit' onclick='editOperation("+ row_ + ")'><i class='lnr lnr-pencil'></i></button>"
	        		 + "&nbsp;<button type='button' class='btn btn-danger btn-xs' onclick='delOperation("+ id_ + ")'><i class='lnr lnr-trash'></i></button>"	        			 
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


function createOperation(){
	var operation = new FormData();
	operation.append("name",$("input[name='nameArea']").val());	
	operation.append("domainid",$("#domainArea option:selected").val());
	operation.append("botton_id",$("input[name='buttonidArea']").val());	
	operation.append("remark",$("textarea[name='remarkArea']").val());

	$.ajax({
        type: "POST",
        url: "../operations",
        data: operation,
		contentType:false,
		processData:false,
        success: function (data) {
        	if(data.status == 1){
    			alert("添加成功！");   			
    			table.ajax.reload();
    			$('#operationCreate').modal('hide');
    			
    		}else{
    			alert("添加失败！");
    		}
        },
        error: function (message) {
            console.log(message);
        }
    });	
}

function delOperation(operationID){
	if(confirm("确认删除该操作？") == true){
		$.ajax({
	        type: "delete",
	        url: "../operations/"+operationID,	        
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

function getOperation(_operation){
	var str="";
	console.log(_operation);
	str = "<div class='profile-info'><h4 class='heading'>操作信息</h4><ul class='list-unstyled list-justify'><li>操作名称 <span>"
		+ _operation.name 
		+ "</span></li><li>操作按钮ID<span>" 
		+ _operation.botton_id
		+ "</span></li><li>所属区域 <span>" 
		+ _operation.domainid
		+ "</span></li><li>备注 <span>" 
		+ _operation.remark
				
	str	+= "</span></li></ul></div>" 

	
	$("#operationInfo_detail").html(str);	
}

function editOperation(_operation){
	
}

$(document).ready(function() {

	setOperationTable();
	

	$("#createOperationBtn").click(function(){
		createOperation();
	})

});


