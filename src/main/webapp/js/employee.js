

var table;
var domainid = 1;
var rulesList = {};

function setEmployeeTable(){
	table = $('#employeeTable').DataTable( {
		ajax: {
			url:'../employees',
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
            	data: "name" ,
            	title: "员工姓名"
            },{
            	data: "department.name" ,
            	title: "所属部门"
            },{
            	data: "loginId",
            	title: "员工账号"
            },{ 
            	data: "isLoginEnabled" ,
            	title: "允许登录"
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
	        	var html = "<button type='button' class='btn btn-info btn-xs' data-toggle='modal' data-target='#employeeInfo' onclick='getEmployee("+ row_ + ")'><i class='lnr lnr-magnifier'></i></button>" 
	        		 + "&nbsp;<button type='button' class='btn btn-success btn-xs' data-toggle='modal' data-target='#employeeEdit' onclick='editEmployeeInit("+ row_ + ")'><i class='lnr lnr-pencil'></i></button>"
	        		 + "&nbsp;<button type='button' class='btn btn-warning btn-xs' data-toggle='modal' data-target='#employeeRulesEdit' onclick='getEmployeeRules("+ row_ + ")'><i class='lnr lnr-bookmark'></i></button>"
	        		 + "&nbsp;<button type='button' class='btn btn-danger btn-xs' onclick='delEmployee("+ id_ + ")'><i class='lnr lnr-trash'></i></button>"
        			 
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

function createEmployee(){
	var employee = new FormData();
	employee.append("name",$("input[name='nameArea']").val());
	employee.append("department_id",$("input[name='departmentIdArea']").val());
	employee.append("domainid",domainid);
	employee.append("email",$("input[name='emailArea']").val());
	employee.append("qq",$("input[name='qqArea']").val());
	employee.append("tel",$("input[name='telArea']").val());
	employee.append("sex",$('input:radio[name="sex"]:checked').val());
	if($("input[name='birthdayArea']").val() != null){
		employee.append("birthday",$("input[name='birthdayArea']").val());
	}
	
	employee.append("photo",null);
	employee.append("loginId ",$("input[name='loginIdArea']").val());
	employee.append("password", $("input[name='passwordArea']").val());
	employee.append("seller ", $("input[name='isSeller']").prop('checked'));

	if($("input[name='isLoginEnabled']").prop('checked')) {
		employee.append("isLoginEnabled ", "1");
	}else{
		employee.append("isLoginEnabled ", "0");
	}
	
	$.ajax({
        type: "POST",
        url: "../employees",
        data: employee,
		contentType:false,
		processData:false,
        success: function (data) {
        	if(data.status == 1){
    			alert("添加成功！");   			
    			table.ajax.reload();
    			$('#employeeCreate').modal('hide');
    			
    		}else{
    			alert("添加失败！");
    		}
        },
        error: function (message) {
            console.log(message);
        }
    });
}

function delEmployee(employeeID){
	if(confirm("确认删除？") == true){
		$.ajax({
	        type: "delete",
	        url: "../employees/"+employeeID,	        
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

function getEmployee(_employee){
	var str="";
	str = "<div class='profile-info'><h4 class='heading'>个人信息</h4><ul class='list-unstyled list-justify'><li>姓名 <span>"
		+ _employee.name 
		+ "</span></li><li>所属区域 <span>" 
		+ domainid
		+ "</span></li><li>所属部门 <span>" 
		+ _employee.department.name
		+ "</span></li><li>性别 <span>" 
		
	if( _employee.sex == 1){
		str += "男";
	}else{
		str += "女";
	}
	     
	str += "</span></li><li>出生年月 <span>" 
		+ _employee.birthday
		+ "</span></li><li>联系方式 <span>" 
		+ _employee.tel
		+ "</span></li><li>QQ <span>" 
		+ _employee.qq
		+ "</span></li><li>邮箱 <span>" 
		+ _employee.email 
		+ "</span></li></ul></div>" 
		+ "<div class='profile-info'><h4 class='heading'>账号信息</h4><ul class='list-unstyled list-justify'><li>登录账号 <span>" 
		+ _employee.loginId
		+ "</span></li><li>是否允许登录 <span>" 
		
	if( _employee.isLoginEnabled == 1){
		str += "是";
	}else{
		str += "否";
	}	
	
	str += "</span></li><li>是否售票员 <span>" 
	
	if( _employee.seller == true){
		str += "是";
	}else{
		str += "否";
	}
	
	str	+= "</span></li></ul></div><div class='profile-info'><h4 class='heading'>角色分配</h4>" 
	
	if(_employee.rules.length != 0){
		$.each(_employee.rules,function(i,v){
			str += "<p>" 
				+ v.rulename
				+ "</p>";   						   			
		});            	
	}else{
		str += "<p>暂无</p>";
	}
	
	str	+= "</div>" ;
	
	$("#employeeInfo_detail").html(str);	
}

function editEmployeeInit(_employee){
	
	var departmentIdEdit_ = _employee.department.id;
	var birthdayEdit_ = _employee.birthday;	
	employeeVm.geteEditEmployeeInit(departmentIdEdit_,birthdayEdit_);
		
	$("input[name='employeeIdEdit']").val(_employee.id);
	$("input[name='nameEdit']").val(_employee.name);	
	$("input[name='sexEdit'][value='"+ _employee.sex +"']").attr("checked",true); 
	$("input[name='departmentIdEdit']").val(_employee.department.id);	
	$("input[name='birthdayEdit']").val(_employee.birthday);			
	$("input[name='telEdit']").val(_employee.tel);	
	$("input[name='qqEdit']").val(_employee.qq);	
	$("input[name='emailEdit']").val(_employee.email);		
	$("input[name='loginIdEdit']").val(_employee.loginId);	
	if(_employee.isLoginEnabled == "1"){
		$("input:checkbox[name='isLoginEnabledEdit']").prop('checked','true');
	}else{
		$("input:checkbox[name='isLoginEnabledEdit']").prop('checked','false');
	}	
	$("input:checkbox[name='isSellerEdit']").prop('checked',_employee.seller);
	
}

function editEmployee(){
	
	var _employee = {};

	_employee["domainid"] = domainid;
	_employee["id"] = $("input[name='employeeIdEdit']").val();	
	_employee["name"] = $("input[name='nameEdit']").val();
	_employee["sex"] =$("input[name='sexEdit']:checked").val(); 
	_employee["department_id"] =$("input[name='departmentIdEdit']").val();	
	_employee["birthday"] =$("input[name='birthdayEdit']").val();
	_employee["tel"] =$("input[name='telEdit']").val();
	_employee["qq"] =$("input[name='qqEdit']").val();	
	_employee["email"] =$("input[name='emailEdit']").val();		
	_employee["loginId"] =$("input[name='loginIdEdit']").val();
	_employee["seller"] =  $("input[name='isSellerEdit']").prop('checked');
	_employee["photo"] = null;
	
	if($("input[name='isLoginEnabled']").prop('checked')) {
		_employee["isLoginEnabled"] = 1;
	}else{
		_employee["isLoginEnabled"] = 0;
	}

	console.log(_employee);
	
	$.ajax({
		type: "put",
        url: "../employees",
        data: _employee,
        success:function(data){
        	if(data.status == 1){
        		alert("修改成功！");
        		table.ajax.reload();
        		$('#employeeEdit').modal('hide');
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

function employeeRulesInit(){
	$.get("../rulesnames", function(data) {
		if(data.status == 1){
			rulesList = data.data;
		}else{
			console.log(data.error);
		}
	});
}

function getEmployeeRules(_employee){
	
	var str="";
	var emRulesList=[];	
	$("#employeeRules_Init").html("");
	$("input[name='employeeRulesId']").val(_employee.id);
	
	if(_employee.rules.length != 0){
		$.each(_employee.rules,function(i,v){
			emRulesList.push({"id":v.id,"name":v.rulename});
		});		
	}
	
	$.each(rulesList,function(i,v){	
		str += "<label class='fancy-checkbox' ><input type='checkbox' name='emRlues' value="+ v.id +"><span>"
		+ v.rulename
		+ "</span></label>"			
	});		
	$("#employeeRules_Init").html(str);
	
	$.each(rulesList,function(i,v){	
		$.each(emRulesList,function(j,w){
			if(w.id == v.id){
				$("input[type=checkbox][name='emRlues'][value='"+w.id+"']").prop('checked', true);
			}
		})			
	});		
}

function editEmployeeRules(){
	
	var emRules = [];
	var emRulesChecked = $("input[name='emRlues']:checked");
		
	$.each(emRulesChecked,function(i,v){	
		emRules.push({
			"domainid":domainid,
			"employee_id":$("input[name='employeeRulesId']").val(),
			"rule_id":this.value
		})			
	});

	
	$.ajax({
		type: "put",
        url: "../ruleemployees",
        data: JSON.stringify(emRules),
        success:function(data){
        	if(data.status == 1){
        		alert("员工角色分配成功！");
        		table.ajax.reload();
        		$('#employeeRulesEdit').modal('hide');
        	}else{
        		alert("员工角色分配失败！");
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
	setEmployeeTable();
	employeeRulesInit();	

	/*操作*/
	$("#createEmployeeBtn").click(function(){
		createEmployee();
	})
	$("#editEmployeeBtn").click(function(){
		editEmployee();
	})
	$("#editEmployeeRulesBtn").click(function(){
		editEmployeeRules();
	})
	
});

function navbar(){
	 $(".navHeader").load("../sys/navbar.html");
}

var employeeVm = new Vue({
	el:"#employeeVm",
	data() {
		return {
			departmentList: [],
			defaultProps: {
				children: 'departments',
				label: 'name',
				value: 'id'
			},
			birthdayDate:'',
			departmentIdEdit_:[],
			birthdayEdit_:''
		};
    },
    created:function (){
    	var _data = this;
    	
    	$.ajax({
	        type: "get",
	        url: "../departments",
	        headers: {'domainid': domainid},
	        success: function (data) {
	        	if(data.status == 1){		        		
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
        departmentChange(deVal) {
          console.log(deVal[1]);
          $("input[name='departmentIdArea']").val(deVal[1])
        },
        departmentEditChange(deVal) {
            console.log(deVal[1]);
            $("input[name='departmentIdEdit']").val(deVal[1])
          },
        birthdayChange(dateVal) {
        	this.birthdayDate = dateVal;
        	console.log(dateVal);
            $("input[name='birthdayArea']").val(dateVal);
        },  
        birthdayEditChange(dateVal) {
        	this.birthdayDate = dateVal;
        	console.log(dateVal);
            $("input[name='birthdayEdit']").val(dateVal);
        },  
        geteEditEmployeeInit:function(deId,birDate){
        	
        	var _data = this;
        	_data.departmentIdEdit_ = [];
        	
        	$.get("../departments/" + deId, function(data) {
        		if(data.status == 1){
        			if(data.data.ml_parent != 0){
        				_data.departmentIdEdit_.push(data.data.ml_parent);
        				_data.departmentIdEdit_.push(deId);
        			}else{
        				_data.departmentIdEdit_.push(deId);
        			}	
        		}else{
        			console.log(data.error);
        		}
        	});

        	this.birthdayEdit_ = birDate;
        }
        
    }
})









