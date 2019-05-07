
var domainid = sessionStorage.domainid;

var loginlogVm = new Vue({
	el: "#loginlogVm",
	data(){
		return{
			loginlogTable: [],
			pageInit:{
				"total":0,
				"pageNum":1,
				"pageSize":10,
			},
			searchList:[],						
			userName:"",
			userLoginid:"",
			userEnterdate:[]
		}
	},
	created:function(){
		var _this = this;
		
    	$.ajax({
	        type: "post",
	        url: "../loginlogbypage",
	        contentType : 'application/json;charset=utf-8',
	        headers: {'domainid': domainid},
	        data: JSON.stringify({
	        	pageNum:_this.pageInit.pageNum,
	        	pageSize:_this.pageInit.pageSize,
	        }),
	        success: function (data) {
	        	if(data.status == 1){		        		
	        		console.log(data)
	        		_this.loginlogTable = data.data
	        		_this.pageInit.total = data.total
	        	}
	        	else{
	        		console.log(data.data);
	        	} 	
	        },
	        error: function (message) {
	            console.log(message);
	        }
	    });
    	
    	document.onkeydown = function(e) {
    	var key = window.event.keyCode;
	    	if (key == 13) {
	    		_this.searchClick();
	    	}
    	}
	},
	methods:{
		handleSizeChange(val) {
	        this.pageInit.pageSize = val
	        this.tableReload();
		},		
		handleCurrentChange(val) {
			this.pageInit.pageNum = val
	        this.tableReload();
		},
		handleDateChange(val){
			console.log(val)
		},	
		searchClick(){
			this.searchList = [];
			
			if(this.userName != ""){
				this.searchList.push({"operation":"like","name":"name","data":this.userName})
			}
			if(this.userLoginid != ""){
				this.searchList.push({"operation":"like","name":"loginId","data":this.userLoginid})
			}
			if(this.userEnterdate != null){
				if(this.userEnterdate.length > 0){
					this.searchList.push({"operation":"between","name":"enterdate","data":this.userEnterdate[0]})	
					
					/*var date = this.userEnterdate[1]
					date.setDate(date.getDate()+1)*/
					this.searchList.push({"operation":"and","name":"enterdate","data":this.userEnterdate[1]})	
				}	
			}
			
		
			console.log(this.userEnterdate);
			
			
			this.tableReload()
			// 格式
			/*let arr=[];
			let handle1=new Object();
			handle1.operation= "and";
			handle1.name= "123";
			handle1.data="123";
			let handle2=new Object();
			handle2.operation= "or";
			handle2.name= "123";
			handle2.data="123";
			arr.push(handle1);
			arr.push(handle2);*/

		},
		tableReload(){
			var _this = this;  
			
			$.ajax({
		        type: "post",
		        url: "../loginlogbypage",
		        contentType : 'application/json;charset=utf-8',
		        headers: {'domainid': domainid},
		        data:JSON.stringify({
		        	pageNum:_this.pageInit.pageNum,
		        	pageSize:_this.pageInit.pageSize,
		        	handles:_this.searchList
		        }),
		        success: function (data) {
		        	if(data.status == 1){		        		
		        		console.log(data)
		        		_this.loginlogTable = data.data
		        		_this.pageInit.total = data.total
		        	}
		        	else{
		        		console.log(data);
		        	} 	
		        },
		        error: function (message) {
		            console.log(message);
		        }
		    });
		},
		add0(m){
			return m<10?'0'+m:m 
		},
		formatDate(row, column, cellValue, index) { 
			const daterc = row[column.property]
			var time = new Date(daterc);
			var year = time.getFullYear();
			var month = time.getMonth()+1;
			var date = time.getDate();
			var hours = time.getHours();
			var minutes = time.getMinutes();
			var seconds = time.getSeconds();
			return year+'-'+ this.add0(month)+'-'+ this.add0(date)+' '+ this.add0(hours)+':'+ this.add0(minutes)+':'+ this.add0(seconds);
		},	
	}
})

 

$(document).ready(function() {
	/*页面初始化*/
	navbar();

});

function navbar(){
	 $(".navHeader").load("../sys/navbar.html");
}
