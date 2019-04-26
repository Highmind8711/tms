
var nemuList = "";
var domainid = "";
var token = "";

function getBaseInfo(){
	
	$.ajax({
        type: "get",
        url: "../getInfo",
        headers: {'domainid': domainid},
        data:{"token": token},
        success: function (data) {
        	if(data.status == 1){	
        		console.log(data)
        		$("#userName").html(data.data.name)
        		$("#userLoginId").html(data.data.loginId)        		
        	}
        	else{
        		alert(data.error);
        	}	
        },
        error: function (message) {
        	console.log(message);
        }
    });
	
}


function getSidebarList(){
	
	$.ajax({
        type: "get",
        url: "../menurecursion",
        data:{"token": token},
        success: function (data) {
        	if(data.status == 1){		        		
        		console.log(data)
        	}
        	else{
        		alert(data.error);
        	}	
        },
        error: function (message) {
        	console.log(message);
        }
    });
}


function editPassword(){
	
	var psw = $("input[name='psdEdit']").val();
	
	$.ajax({
        type: "get",
        url: "../getInfo",
        headers: {'domainid': domainid},
        data:{"token": token},
        success: function (data) {
        	
        	if(data.status == 1){
        		var _data = data.data;
           		if(psw == _data.password){
           			pswChange(_data.id);
           		}else{
           			alert("原密码输入错误！")
           		}       		
        	}
        	else{
        		alert(data.error);
        	}	
        },
        error: function (message) {
        	console.log(message);
        }
    });	
}


function pswChange(userId){
	
	var _user = {}
	_user["id"] = userId;
	_user["password"] = $("input[name='psdNewEdit']").val();

	$.ajax({
        type: "put",
        url: "../employees",
        headers: {'domainid': domainid},
        data: _user,
        success: function (data) {
        	if(data.status == 1){		        		
        		alert("修改成功！");
        		$('#passwordEdit').modal('hide');
        		$("input[name='psdEdit']").val("");
        		$("input[name='psdNewEdit']").val("");
        	}
        	else{
        		alert("修改失败！")
        		console.log(data.error);
        	}	
        },
        error: function (message) {
        	alert("修改失败！");
        	console.log(message);
        }
    });
}

function loginOut(){
	if(confirm("是否退出当前账号？") == true){
		sessionStorage.clear();
		window.location.href = "login.html";	
	}else{
		
	}
}


$().ready(function(){
	
	if(sessionStorage.getItem("token") != null){
		
		console.log(sessionStorage)
		domainid = sessionStorage.domainid;
		token = sessionStorage.token;
		
		/*页面初始化*/
		getMenuHidden();

		/*数据初始化*/
		getBaseInfo();
		getSidebarList();
		
		/*操作*/
		$("#editPassowordBtn").click(function(){
			editPassword();
		})
		
	}else{
		if(confirm("用户信息已失效，请重新登录！") == true){
			window.location.href = "login.html";	
		}		
	}
})
	
/*控制左侧菜单显示隐藏*/
function getMenuHidden(){
	$("#menubtn").click(function(){
		var _width = $(document.body).outerWidth(true);
		if(_width > 1024){
			if($("body").hasClass("layout-fullwidth")){
				$("body").removeClass("layout-fullwidth");
				$("#menubtn i").removeClass("lnr-arrow-right-circle").addClass("lnr-arrow-left-circle");
			}else{
				$("body").addClass("layout-fullwidth");
				$("#menubtn i").removeClass("lnr-arrow-left-circle").addClass("lnr-arrow-right-circle");
			}
		}else{
			if($("body").hasClass("layout-fullwidth offcanvas-active")){
				$("body").removeClass("layout-fullwidth offcanvas-active");
				$("#menubtn i").removeClass("lnr-arrow-right-circle").addClass("lnr-arrow-left-circle");
				
			}else{
				$("body").addClass("layout-fullwidth offcanvas-active");
				$("#menubtn i").removeClass("lnr-arrow-left-circle").addClass("lnr-arrow-right-circle");
			}
		}
		/*console.log(_width);*/
	})
}

/*控制菜单按钮高亮*/
function getMenuActive(){
	
	
}












