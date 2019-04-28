
var table;
var domainid = 2;

function setLoginlogTable(){
	table = $('#loginlogTable').DataTable( {
		ajax: {
			url:'../loginlog',
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
            	data: "employees.name" ,
            	title: "员工姓名"
            },{ 
            	data: "enterdate" ,
            	title: "登录时间"
            }
        ],         
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


$(document).ready(function() {
	/*页面初始化*/
	navbar();
	
	/*数据初始化*/
	setLoginlogTable();

});

function navbar(){
	 $(".navHeader").load("../sys/navbar.html");
}
