
function signin(){
	
	var signin = new FormData();
	var domainid = $("input[name='signin-domainid']").val();
	
	signin.append("loginid",$("input[name='signin-loginId']").val());
	signin.append("password",$("input[name='signin-password']").val());
	signin.append("domainid",domainid);
	$.ajax({
        type: "POST",
        url: "../login",
        data: signin,
		contentType:false,
		processData:false,
        success: function (data) {
        	if(data.status == 1){ 	
        		sessionStorage.setItem("token",data.data.token);	
        		sessionStorage.setItem("domainid",domainid);	
        		window.location.href = "sys_employee.html";	
    		}else{
    			alert("登录失败！请查看登录信息是否正确");
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
	
	console.log(sessionStorage)
	
})
	