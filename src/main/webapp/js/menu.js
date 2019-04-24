
var domainid = 1;

var menuVm = new Vue({
	el:"#menuVm",
	data() {
		return {
			menuList: [],
			defaultProps: {
				children: 'menus',
				label: 'name'
			},			
			_menu:{},
			menuItemList:[],
		};
    },
    created:function(){
    	var _data = this;
    	
    	$.ajax({
	        type: "get",
	        url: "../menus",
	        headers: {'domainid': domainid},
	        success: function (data) {
	        	if(data.status == 1){		        		
	        		console.log(data.data)
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
    	menuNodeClick(data) {
    		
    		var _data = this;
    		
    		_data._menu = data;
    		_data.menuItemList = [];
    		
    		_data.menuItemList.push({
				"id":data.id,
				"name":data.name,
				"url":data.url,        	        				
			});  		
    		
    	},
    	menuEdit:function(){    		
 
    		if(this._menu.id == undefined){
    			alert("请先在菜单数列中选择菜单项！")		
    		}else{
    			$("input[name='idEdit']").val(this._menu.id);	
        		$("input[name='nameEdit']").val(this._menu.name);	
        		$("input[name='urlEdit']").val(this._menu.url);	   
    		}	
    	},
    	menuDelete:function(){    	
    		
    		if(confirm("确认删除该菜单？") == true){
    			$.ajax({
        			type: "delete",
        	        url: "../menus/"+this._menu.id,
        	        headers: {'domainid': domainid},
        	        success:function(data){
        	        	if(data.status == 1){
        	        		alert("删除成功！");
        	        		window.location.reload();
        	        	}else{
        	        		alert("删除失败！");
        	        	} 	
        	        },
        	        error: function (message) {
        	            console.log(message);
        	        }  
        		})  
    		}	   			
    	},
    	menuRefresh:function(){
    		window.location.reload();
    	}
    }   
})

function createMenu(){
	var menu = new FormData();
		
	if($("#menuSelect option:selected").val() == 1){
		menu.append("name",$("input[name='rootNameArea']").val());		
		menu.append("parent_id","0");	
		
	}else if($("#menuSelect option:selected").val() == 2){
		menu.append("name",$("input[name='subNameArea']").val());	
		menu.append("parent_id",$("#parent_idArea option:selected").val());		
	}
	
	menu.append("domainid",domainid);
	menu.append("url",$("input[name='urlArea']").val());

	$.ajax({
        type: "POST",
        url: "../menus",
        data: menu,
		contentType:false,
		processData:false,
        success: function (data) {
        	if(data.status == 1){
    			alert("添加成功！");   	
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

function editMenuSave(){
	
	var _menu = {};
	
	_menu["id"]=$("input[name='idEdit']").val();
	_menu["name"]=$("input[name='nameEdit']").val();
	_menu["url"]=$("input[name='urlEdit']").val();
	
	$.ajax({
		type: "put",
        url: "../menus",
        data: _menu,
        headers: {'domainid': domainid},
        success:function(data){
        	if(data.status == 1){
        		alert("修改成功！");
        		$('#menuEdit').modal('hide');
        	}else{
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
	deSelectInit();
	
	/*操作*/
	$("#createMenuBtn").click(function(){
		createMenu();
	})
	$("#editMenuBtn").click(function(){
		editMenuSave();
	})
	
	
});

function navbar(){
	$(".navHeader").load("../sys/navbar.html");
}

function deSelectInit(){
	$('#menuSelect').change(function(){ 
		var deSelect = $(this).children('option:selected').val();		
		if(deSelect == 1){	
			$("#root-menuArea").css("display","block");
			$("#sub-menuArea").css("display","none");			
		}else if(deSelect == 2){
			$("#sub-menuArea").css("display","block");
			$("#root-menuArea").css("display","none");
		}		
	});
}







