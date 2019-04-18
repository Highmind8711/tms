
function signin(){
	
	var signin = new FormData();
	signin.append("loginid",$("input[name='signin-loginId']").val());
	signin.append("password",$("input[name='signin-password']").val());
	signin.append("domainid",10);
	$.ajax({
        type: "POST",
        url: "../login",
        data: signin,
		contentType:false,
		processData:false,
        success: function (data) {
        	if(data.status == 1){ 	
        		sessionStorage.setItem("token",data.token);		
        		window.location.href = "sys_employee.html";	
        		console.log(data.data.token)
    		}else{
    			alert("用户名或密码错误！");
    		}
        },
        error: function (message) {
            console.log(message);
        }
    });
	
/*	sessionStorage.setItem("token","token11111111");
	window.location.href = "sys_employee.html";	*/
}


$().ready(function(){
	/*操作*/
	$("#loginBtn").click(function(){
		signin();
	})
	
})
	