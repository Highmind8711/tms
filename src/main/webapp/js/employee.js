/**
 * 
 */

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
            	data: "name" ,
            	title: "员工姓名"
            },{ 
            	data: "domainId" ,
            	title: "所属区域"
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
	        	
	        	var html = "<button type='button' class='btn btn-info btn-xs' data-toggle='modal' data-target='#employeeInfo'><i class='lnr lnr-magnifier'></i></button>" 
	        			 + "&nbsp;<button type='button' class='btn btn-success btn-xs' data-toggle='modal' data-target='#employeeEdit'><i class='lnr lnr-pencil'></i></button>"
	        			 + "&nbsp;<button type='button' class='btn btn-warning btn-xs' data-toggle='modal' data-target='#employeeRule'><i class='lnr lnr-bookmark'></i></button>"
	        			 + "&nbsp;<button type='button' class='btn btn-danger btn-xs'><i class='lnr lnr-trash'></i></button>"
	        			 
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
        "searching": false,
        "lengthChange": false,
       
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
			console.log(v.name);
		});
		$("#departmentArea_children").html(str);
	});
}

function createEmployee(){
	let employee  = {};
	
	employee.name = $("#nameArea").val();
	
	employee.department_id =  $("#departmentArea_children option:selected").val();
	employee.domainId =  $("#domainArea option:selected").val();
	employee.email = $("input[name='emailArea']").val();
	employee.qq = $("input[name='qqArea']").val();
	employee.tel = $("input[name='telArea']").val();
	employee.sex = $('input:radio[name="sex"]:checked').val();
	employee.birthday = null;
	employee.photo = null;
	employee.loginId = $("input[name='loginIdArea']").val();
	employee.password = $("input[name='passwordArea']").val();
	

	employee.seller = $("input[name='isSeller']").prop('checked');
	if($("input[name='isLoginEnabled']").prop('checked')) {
		employee.isLoginEnabled = 1;
	}else{
		employee.isLoginEnabled = 0;
	}
	
	console.log(employee);
	/*employee.birthday =  new Date();*/

	$.ajax({
        type: "POST",
        url: "../employees",
        contentType: "text/json; charset=utf-8",
        data: employee,
        dataType: "json",
        success: function (data) {
        	if(data.status == 1){
    			alert("添加成功！");
    		}else{
    			alert("添加失败！");
    		}
        },
        error: function (message) {
            console.log(message);
        }
    });
}


function rulesInit(){
	var str="";
	$.get("../rules", function(data) {
		$.each(data.data,function(i,v){
			str += "<option value='"+v.id+"'>" 
				+ v.rulename
				+ "</option>";			
		});
		$("#rulesArea").html(str);
	});
}




$(document).ready(function() {
	domainInit();
	departmentNamesInit();
	setEmployeeTable();

	$("#createEmployeeBtn").click(function(){
		createEmployee();
	})
	
});

function isFocus(){
	$("#nameArea").focus();
}








