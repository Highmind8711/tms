
var table;
var domainid = 1;

function setDomainTable(){
	table = $('#domainTable').DataTable( {
		ajax: {
			url:'../domain',
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
            	data: "domain_name" ,
            	title: "区域名称"
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
	        	var html = "<button type='button' class='btn btn-success btn-xs' data-toggle='modal' data-target='#domainEdit' onclick='editDomain("+ row_ + ")'><i class='lnr lnr-pencil'></i></button>"
	        		 + "&nbsp;<button type='button' class='btn btn-danger btn-xs' onclick='delDomain("+ id_ + ")'><i class='lnr lnr-trash'></i></button>"
		 
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

function deldomain(domainID){
	if(confirm("确认删除该区域？") == true){
		$.ajax({
	        type: "delete",
	        url: "../domains/"+domainID,	        
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

function editdomain(_domain){
	
	console.log(_domain);
	$("input[name='nameEdit']").val(_domain.name);	
	$("input[name='remarkEdit']").val(_domain.remark);	
	
}

$(document).ready(function() {
	/*页面初始化*/
	navbar();
	
	/*数据初始化*/
	setDomainTable();

	/*操作*/
	$("#createDomainBtn").click(function(){
		createDomain();
	})
	
});

function navbar(){
	 $(".navHeader").load("../sys/navbar.html");
}
