
var domainid = sessionStorage.domainid;

var deprtmentVm = new Vue({
	el:"#departmentVm",
	data() {
		return {
			departmentList: [],
			defaultProps: {
				children: 'departments',
				label: 'name'
			},
			deEmployeeList:[],
			_department:{}
		};
    },
    created:function(){
    	var _data = this;
    	
    	$.ajax({
	        type: "get",
	        url: "../departments",
	        headers: {'domainid': domainid},
	        success: function (data) {
	        	if(data.status == 1){		        		
	        		/*console.log(data.data)*/
	        		$.each(data.data,function(i,v){	  			
	        			if(v.ml_parent == 0){
		        			_data.departmentList.push( {"id":v.id,"name":v.name,"remark":v.remark,"departments":[]});
	        			}
	        		})
	        		$.each(data.data,function(i,v){	 
	        			$.each(_data.departmentList,function(j,n){	
	        				if(v.ml_parent == n.id){
	        					n.departments.push({"id":v.id,"name":v.name,"remark":v.remark});	        					
	        				}	        				
		        		})
	        		})
	        		console.log(_data.rootDepartments);
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
    	departmentNodeClick(data) {
    		
    		var _data = this;
    		
    		_data._department = data;
    		_data.deEmployeeList = [];
    		
        	$.ajax({
    			type: "get",
    	        url: "../departments/" + _data._department.id,
    	        headers: {'domainid': domainid},
    	        success:function(data){
    	        	if(data.status == 1){
    	        		if(data.data.employees.length > 0){
        	        		$.each(data.data.employees,function(i,v){
        	        			_data.deEmployeeList.push({
        	        				"id":v.id,
        	        				"name":v.name,
        	        				"loginId":v.loginId,
        	        				"seller":v.seller,
        	        				"isLoginEnabled":v.isLoginEnabled,
        	        				"sex":v.sex,
        	        			});
            	        	})
        	        	}	
    	        	}else{
    	        		console.log(data.error);
    	        	}
    	        	
    	        },
    	        error: function (message) {
    	            console.log(message);
    	        }  
    		})
    	},
    	departmentEdit:function(){    		
 
    		$("input[name='idEdit']").val(this._department.id);	
    		$("input[name='nameEdit']").val(this._department.name);	
    		$("textarea[name='remarkEdit']").val(this._department.remark);	   			
    	},
    	departmentDelete:function(){    	
    		
    		if(confirm("确认删除该部门？") == true){
    			$.ajax({
        			type: "delete",
        	        url: "../departments/"+this._department.id,
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
    	departmentRefresh:function(){
    		window.location.reload();
    	}
    }   
})

function createDepartment(){
	var department = new FormData();
		
	if($("#deSelect option:selected").val() == 1){
		department.append("name",$("input[name='rootNameArea']").val());		
		department.append("ml_parent","0");	
		
	}else if($("#deSelect option:selected").val() == 2){
		department.append("name",$("input[name='subNameArea']").val());	
		department.append("ml_parent",$("#ml_parentArea option:selected").val());		
	}
	
	department.append("domainid",domainid);
	department.append("remark",$("textarea[name='remarkArea']").val());

	$.ajax({
        type: "POST",
        url: "../departments",
        data: department,
		contentType:false,
		processData:false,
        success: function (data) {
        	if(data.status == 1){
    			alert("添加成功！");   	
    			$('#departmentCreate').modal('hide');
    			
    		}else{
    			alert("添加失败！");
    		}
        },
        error: function (message) {
            console.log(message);
        }
    });	
}

function editDepartment(){
	
	var _department = {};
	
	_department["id"]=$("input[name='idEdit']").val();
	_department["name"]=$("input[name='nameEdit']").val();
	_department["remark"]=$("textarea[name='remarkEdit']").val();
	
	console.log(_department);
	
	$.ajax({
		type: "put",
        url: "../departments",
        data: _department,
        headers: {'domainid': domainid},
        success:function(data){
        	if(data.status == 1){
        		alert("修改成功！");
        		$('#departmentEdit').modal('hide');
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
	$("#createDepartmentBtn").click(function(){
		createDepartment();
	})
	$("#editDepartmentBtn").click(function(){
		editDepartment();
	})
	
	
});

function navbar(){
	$(".navHeader").load("../sys/navbar.html");
}

function deSelectInit(){
	$('#deSelect').change(function(){ 
		var deSelect = $(this).children('option:selected').val();		
		if(deSelect == 1){	
			$("#root-deArea").css("display","block");
			$("#sub-deArea").css("display","none");			
		}else if(deSelect == 2){
			$("#sub-deArea").css("display","block");
			$("#root-deArea").css("display","none");
		}		
	});
}







