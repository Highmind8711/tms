
var table;
var domainid = sessionStorage.domainid;
var domainName = sessionStorage.domainName;

function setPermissionTable(){
	table = $('#permissionTable').DataTable( {
		ajax: {
			url:'../permissions',
			dataSrc: 'data',	
			headers: {
				"domainid":domainid
			}
		},
		columns: [           
			{
				"data" : null, 
				"title" : "编号",
				"render" : function(data, type, full, meta){  
					return meta.row + 1 + meta.settings._iDisplayStart;  
				}
			},{ 
            	data: "name" ,
            	title: "权限名称"
            },{ 
            	data: "grouping" ,
            	title: "权限模块"
            },{ 
            	data: "type" ,
            	title: "权限类型"
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
	        	var html = "<button type='button' class='btn btn-info btn-xs' data-toggle='modal' data-target='#permissionInfo' onclick='getPermission("+ row_ + ")' title='权限详细信息查看'><i class='lnr lnr-magnifier'></i></button>" 
	        		 + "&nbsp;<button type='button' class='btn btn-success btn-xs' data-toggle='modal' data-target='#permissionEdit' onclick='editPermissionInit("+ row_ + ")' title='权限信息编辑'><i class='lnr lnr-pencil'></i></button>"
	        		 + "&nbsp;<button type='button' class='btn btn-danger btn-xs' onclick='delPermission("+ id_ + ")' title='删除权限'><i class='lnr lnr-trash'></i></button>"
	        			 
	        	return html;
        	}
        },{
        	"targets" : 3,        	
        	"render" : function(data, type, row) {
        		if(row.type == "1"){
        			return "菜单权限"      			
        		}else{
        			return "暂无"
        		}
        		
        	}
        }],
        "order": [[0, 'asc']],
		"iDisplayLength":100,
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
	permission.append("domainid",domainid);
	permission.append("grouping",$("#groupingArea option:selected").val());
	permission.append("type",$("#typeArea option:selected").val());
	permission.append("menu.id",$("input[name='menuIdArea']").val());
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
    			$("input[name='nameArea']").val("");
    			$("textarea[name='remarkArea']").val("")
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
		+ "</span></li><li>所属公司 <span>" 
		+ domainName
		+ "</span></li><li>权限模块<span>" 
		+ _permission.grouping
		+ "</span></li><li>权限类型<span>" 
		
	if(_permission.type == "1"){
		str += "菜单权限"
	}else{
		str += "暂无"
	}
 
	str += "</span></li><li>备注 <span>" 
		+ _permission.remark
				
	str	+= "</span></li></ul></div><div class='profile-info'><h4 class='heading'>菜单权限</h4>" 
			
	if(_permission.menu != null){
		str += "<p>" 
			+ _permission.menu.name
			+ "</p>"	          	
	}else{
		str += "<p>暂无</p>";
	}
	
	str	+= "</div>" ;
				
	$("#permissionInfo_detail").html(str);	
}

function editPermissionInit(_permission){
	
	console.log(_permission);
	
	var menuIdEdit_ = ""
	if(_permission.menu != null){
		menuIdEdit_ = _permission.menu.id;	
	}
		
	permissionVm.getEditPermissionInit(menuIdEdit_);
		
	$("input[name='permissionIdEdit']").val(_permission.id);
	$("input[name='nameEdit']").val(_permission.name);	
	$("#groupingEdit").val(_permission.grouping);	
	$("#typeEdit option:selected").val(_permission.type);
	$("input[name='menuIdEdit']").val(menuIdEdit_);	
	$("textarea[name='remarkEdit']").val(_permission.remark);	
	
}

function editPermission(){
	
	var _permission = {};

	_permission["domainid"] = domainid;
	_permission["id"] = $("input[name='permissionIdEdit']").val();	
	_permission["name"] = $("input[name='nameEdit']").val();
	_permission["menu_id"] = $("input[name='menuIdEdit']").val();	
	_permission["type"] =  $("#typeEdit option:selected").val();
	_permission["grouping"] = $("#groupingEdit option:selected").val();
	_permission["remark"] = $("textarea[name='remarkEdit']").val();	
	
	console.log(_permission);
	
	$.ajax({
		type: "put",
        url: "../permission",
        data: _permission,
        success:function(data){
        	if(data.status == 1){
        		alert("修改成功！");
        		table.ajax.reload();
        		$('#permissionEdit').modal('hide');
        	}else{
        		/*console.log(data.error);*/
        		alert("修改失败！");
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
	setPermissionTable();
	
	/*操作*/
	$("#createPermissionBtn").click(function(){
		createPermission();
	})
	$("#editPermissionBtn").click(function(){
		editPermission();
	})

});

function navbar(){
	 $(".navHeader").load("../sys/navbar.html");
}

var permissionVm = new Vue({
	el:"#permissionVm",
	data() {
		return {
			menuList: [],
			defaultProps: {
				children: 'menus',
				label: 'name',
				value: 'id'
			},
			menuIdEdit_:[]
		};
    },
    created:function (){
    	var _data = this;
    	
    	$.ajax({
	        type: "get",
	        url: "../menus",
	        headers: {'domainid': domainid},
	        success: function (data) {
	        	if(data.status == 1){		        		
	        		$.each(data.data,function(i,v){	  			
	        			if(v.parent_id == 0){
		        			_data.menuList.push( {"id":v.id,"name":v.name,"url":v.url,"menus":[]});
	        			}
	        		})
	        		$.each(data.data,function(i,v){	 
	        			$.each(_data.menuList,function(j,n){	
	        				if(v.parent_id == n.id){
	        					n.menus.push({"id":v.id,"name":v.name,"url":v.url});	        					
	        				}	        				
		        		})
	        		})
	        	}
	        	else{
	        		console.log(data.data);
	        	}	        	
	        },
	        error: function (message) {
	            console.log(message);
	        }
	    });
    },
    methods: {
        menuChange(menuVal) {
           if(menuVal.length > 1){
        	  $("input[name='menuIdArea']").val(menuVal[1])
           }else{
        	  $("input[name='menuIdArea']").val(menuVal[0])
           }          
        },
        menuEditChange(menuEditVal) {
	       if(menuEditVal.length > 1){
	      	  $("input[name='menuIdEdit']").val(menuEditVal[1])
	       }else{
	      	  $("input[name='menuIdEdit']").val(menuEditVal[0])
	       }
        },
        getEditPermissionInit:function(menuId){
        	console.log(menuId)
        	var _data = this;
        	_data.menuIdEdit_ = [];
        	
        	$.get("../menus/" + menuId, function(data) {
        		if(data.status == 1){
        			if(data.data.parent_id != 0){
        				_data.menuIdEdit_.push(data.data.parent_id);
        				_data.menuIdEdit_.push(menuId);
        			}else{
        				_data.menuIdEdit_.push(menuId);
        			}	
        		}else{
        			console.log(data.error);
        		}
        	});
        }
        
    }
})

