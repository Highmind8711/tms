
var table;
var domainid = 1;


var deprtmentVm = new Vue({
	el:"#departmentVm",
	data() {
		return {
			departmentList: [],
			defaultProps: {
				children: 'departments',
				label: 'name'
			},
			deEmployeeList:[]
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
		        			_data.departmentList.push( {"id":v.id,"name":v.name,"departments":[]});
	        			}
	        		})
	        		$.each(data.data,function(i,v){	 
	        			$.each(_data.departmentList,function(j,n){	
	        				if(v.ml_parent == n.id){
	        					n.departments.push({"id":v.id,"name":v.name});	        					
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
    		var departmentId = "";
    		
    		departmentId = data.id;
    		_data.deEmployeeList = [];
    		
        	$.ajax({
    			type: "get",
    	        url: "../departments/" + departmentId,
    	        headers: {'domainid': domainid},
    	        success:function(data){
    	        	console.log(data.data);
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
    	        	console.log(_data.deEmployeeList);
    	        },
    	        error: function (message) {
    	            console.log(message);
    	        }  
    		})
    	},
    	deleteRow(index, rows) {
            rows.splice(index, 1);
        },
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
    			deprtmentVm.created();
    			
    			
    		}else{
    			alert("添加失败！");
    		}
        },
        error: function (message) {
            console.log(message);
        }
    });	
}

function delDepartment(){
	
}

$(document).ready(function() {
	/*页面初始化*/
	navbar();
	deSelectInit();
	
	/*操作*/
	$("#createDepartmentBtn").click(function(){
		createDepartment();
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







