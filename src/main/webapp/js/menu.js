
var table;

function setMenuTable(){
	table = $('#menuTable').DataTable( {
		ajax: {
			url:'../menus',
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
            	data: "url" ,
            	title: "链接地址"
            },{
            	title:"操作",
            	orderable:false,
            }
        ], 
        "columnDefs" : [{
        	"targets" : 4,
        	"data" : null,
        	"render" : function(data, type, row) {
        		var id_ = '"' + row.id + '"';
        		var row_ = JSON.stringify(row);
	        	var html = "<button type='button' class='btn btn-info btn-xs' data-toggle='modal' data-target='#menuInfo' onclick='getMenu("+ row_ + ")'><i class='lnr lnr-magnifier'></i></button>" 
	        		 + "&nbsp;<button type='button' class='btn btn-success btn-xs' data-toggle='modal' data-target='#menuEdit' onclick='editPermission("+ row_ + ")'><i class='lnr lnr-pencil'></i></button>"
	        		 + "&nbsp;<button type='button' class='btn btn-danger btn-xs' onclick='delMenu("+ id_ + ")'><i class='lnr lnr-trash'></i></button>"
	        			 
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

function createMenu(){
	var menu = new FormData();
	menu.append("name",$("input[name='nameArea']").val());	
	menu.append("domainid",$("#domainArea option:selected").val());
	
	$.ajax({
        type: "POST",
        url: "../menus",
        data: menu,
		contentType:false,
		processData:false,
        success: function (data) {
        	if(data.status == 1){
    			alert("添加成功！");   			
    			table.ajax.reload();
    			$('#menuCreate').modal('hide');
    			
    		}else{
    			alert("添加失败！");
    		}
        },
        error: function (message) {
            console.log(message);
        }
    });	
}

function delMenu(menuID){
	if(confirm("确认删除该菜单？") == true){
		$.ajax({
	        type: "delete",
	        url: "../menus/"+menuID,	        
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

function getMenu(_menu){
	var str="";
	console.log(_menu);
	str = "<div class='profile-info'><h4 class='heading'>菜单信息</h4><ul class='list-unstyled list-justify'><li>菜单名称 <span>"
		+ _menu.name 
		+ "</span></li><li>所属区域 <span>" 
		+ _menu.domainid
		+ "</span></li><li>菜单链接地址 <span>" 
		+ _menu.url	
	
	str	+= "</span></li></ul></div>" 
		
	$("#menuInfo_detail").html(str);	
}

function editMenu(_menu){
	
}

$(document).ready(function() {

	/*页面初始化*/
	navbar();
	
	/*数据初始化*/
	setMenuTable();
	
	$("#createMenuBtn").click(function(){
		createMenu();
	})

});

function navbar(){
	 $(".navHeader").load("../resource/page/navbar.html");
}


