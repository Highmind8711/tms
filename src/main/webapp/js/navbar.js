
var nemuList = "";

function getToken(){
	
	var str = sessionStorage.token;
	/*console.log(str);*/
}


function getMenuList(){
	
	$.ajax({
        type: "get",
        url: "../token",
        headers: {'domainid': domainid},
        success: function (data) {
        	if(data.status == 1){		        		
        		
        	}
        	else{
        		console.log(data.error);
        	}
        	
        },
        error: function (message) {
            console.log(message);
        }
    });
}


function editPassword(){
	
	
	
	
	
}


$().ready(function(){
	/*页面初始化*/
	getMenuHidden()
	getMenuList()
	
	/*数据初始化*/
	getToken()
	
	/*操作*/
	
	
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












