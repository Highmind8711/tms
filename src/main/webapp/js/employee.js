/**
 * 
 */

var table;

function setEmployeeTable(){
	table = $('#employeeTable').DataTable( {
		ajax: {
			url:'../employees',
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
            	title: "员工姓名"
            },{ 
            	data: "domainId" ,
            	title: "所属区域"
            },{
            	// 缺省值
				defaultContent:"",
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
        	"targets" : 6,
        	"data" : null,
        	"render" : function(data, type, row) {
        		var id_ = '"' + row.id + '"';
        		var row_ = JSON.stringify(row);
	        	var html = "<button type='button' class='btn btn-info btn-xs' data-toggle='modal' data-target='#employeeInfo' onclick='getEmployee("+ row_ + ")'><i class='lnr lnr-magnifier'></i></button>" 
	        		 + "&nbsp;<button type='button' class='btn btn-success btn-xs' data-toggle='modal' data-target='#employeeEdit' onclick='editEmployee("+ row_ + ")'><i class='lnr lnr-pencil'></i></button>"
	        		 + "&nbsp;<button type='button' class='btn btn-warning btn-xs' data-toggle='modal' data-target='#employeeRules' onclick='rulesInit()'><i class='lnr lnr-bookmark'></i></button>"
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

function domainInit(){
	 var str;
	 str += "<option value='"+10+"'>" 
		+ "区域一"
		+ "</option>";	
	 $("#domainArea").html(str);
}

function departmentNamesInit(){
	var str="";
	$.get("../departmentnames", function(data) {
		$.each(data.data,function(i,v){
			str += "<option value='"+v.id+"'>" 
				+ v.name
				+ "</option>";			
		});
		$("#departmentArea_children").html(str);
	});
}

function rulesInit(){
	var str="";
	$.get("../rulesnames", function(data) {
		var _rules = data.data;
		$.each(_rules,function(i,v){
			str += "<label class='fancy-checkbox'><input type='checkbox' id="+ v.id +"><span>"
				+ v.rulename
				+ "</span></label>"
		});
		$("#employeeRules_Init").html(str);
	});
}

function createEmployee(){
	var employee = new FormData();
	employee.append("name",$("input[name='nameArea']").val());
	employee.append("department_id",$("#departmentArea_children option:selected").val());
	employee.append("domainId",$("#domainArea option:selected").val());
	employee.append("email",$("input[name='emailArea']").val());
	employee.append("qq",$("input[name='qqArea']").val());
	employee.append("tel",$("input[name='telArea']").val());
	employee.append("sex",$('input:radio[name="sex"]:checked').val());
	//做个判断，没有就不要发数据过来，有的再加参数
	/*employee.append("birthday",null);*/
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
		+ _employee.domainId
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

function editEmployee(_employee){
	
	console.log(_employee);
	
	$("input[name='nameEdit']").val(_employee.name);	
	$("input[name='sexEdit'][value='"+ _employee.sex +"']").attr("checked",true); 
	$("input[name='telEdit']").val(_employee.tel);	
	$("input[name='qqEdit']").val(_employee.qq);	
	$("input[name='emailEdit']").val(_employee.email);		
	$("input[name='loginIdEdit']").val(_employee.loginId);	
	if(_employee.isLoginEnabled == 1){
		$("input:checkbox[anme='isLoginEnabledEdit']").attr('checked','true');
	}else{
		$("input:checkbox[anme='isLoginEnabledEdit']").attr('checked','false');
	}
	
}

$(document).ready(function() {
	/*页面初始化*/
	navbar();
	
	/*数据初始花*/
	domainInit();
	departmentNamesInit();
	setEmployeeTable();

	$("#createEmployeeBtn").click(function(){
		createEmployee();
	})
	
});

function navbar(){
	 $(".navHeader").load("../sys/navbar.html");
}




