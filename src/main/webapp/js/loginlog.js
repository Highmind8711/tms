
var domainid = sessionStorage.domainid;

var loginlogVm = new Vue({
	el: "#loginlogVm",
	data(){
		return{
			loginlogTable: [],
			searchList:[{
				"operation":" = ",
				"name":"",
				"data":""				
			}],
			pageInitList:{
				"pageNum":"",
				"pageSize":""
			},
			userName:"",
			userLoginid:"",
			userEnterdate:[]
		}
	},
	created:function(){
		var _data = this;
		// 格式
		let arr=[];
		let handle1=new Object();
		handle1.operation= "and";
		handle1.name= "123";
		handle1.data="123";
		let handle2=new Object();
		handle2.operation= "or";
		handle2.name= "123";
		handle2.data="123";
		arr.push(handle1);
		arr.push(handle2);
    	$.ajax({
	        type: "post",
	        url: "../loginlogbypage",
	        contentType : 'application/json;charset=utf-8',
	        headers: {'domainid': domainid},
	        data: JSON.stringify({
	        	pageNum:"1",
	        	pageSize:"20",
	        	handles:arr
	        }),//将对象序列化成JSON字符串 
	        success: function (data) {
	        	if(data.status == 1){		        		
	        		console.log(data.data)
	        		$.each(data.data, function(){
	        			
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
	methods:{
		searchClick(){
			var _this = this;  
			this.searchList = [];
			
			if(this.userName != ""){
				this.searchList.push({"operation":"%","name":"name","data":_this.userName})
			}
			if(this.userLoginid != ""){
				this.searchList.push({"operation":"%","name":"loginid","data":_this.userLoginid})
			}
			if(this.userEnterdate.length > 0){
				_this.searchList.push({"operation":"between","name":"enterdata","data":_this.userEnterdate})				
			}
			
			console.log(this.searchList);
					
	    	$.ajax({
		        type: "post",
		        url: "../loginlogbypage",
		        headers: {'domainid': domainid},
		        data:{
		        	"pageNum":"1",
		        	"pageSize":"20",
		        	/*"handles":_data.searchList*/
		        },
		        
		        success: function (data) {
		        	if(data.status == 1){		        		
		        		console.log(data.data)		
		        	}
		        	else{
		        		console.log(data.data);
		        	} 	
		        },
		        error: function (message) {
		            console.log(message);
		        }
		    });
		}		
	}

})


function add0(m){return m<10?'0'+m:m }

function formatDate(timestamp) { 	
	var time = new Date(timestamp);
	var year = time.getFullYear();
	var month = time.getMonth()+1;
	var date = time.getDate();
	var hours = time.getHours();
	var minutes = time.getMinutes();
	var seconds = time.getSeconds();
	return year+'-'+add0(month)+'-'+add0(date)+' '+add0(hours)+':'+add0(minutes)+':'+add0(seconds);
} 

$(document).ready(function() {
	/*页面初始化*/
	navbar();

});

function navbar(){
	 $(".navHeader").load("../sys/navbar.html");
}
