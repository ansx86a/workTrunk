<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>test</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/angular.1.5.8.min.js"></script>
</head>
<style>
.sky {
	background-color: aqua;
}

.sky2 {
	background-color: gray;
}
</style>	
<body>

	<div ng-app="myApp" ng-controller="myCtrl">
	
			 <div style="position: fixed; top: 10px; left: 800px; width: 1200px;background-color: lightblue;z-index:99">
			 <span >count=${count },<a href="${pageContext.request.contextPath}/ex001.mvc">重新整理</a></span>
		 			<div style="overflow-y: scroll; height:180px;width:1200px;">	 	
						<div  ng-repeat="x in doms" >
							<span ng-mousedown="doAction(x.exid,'-1',x)">放棄下載</span>
							<span ng-mousedown="doAction(x.exid,'1',x)">註記已查詢</span>
							<span>{{x.done}}</span>
							<span ng-mousedown="openTab(x.url);x.myclass='sky';" ng-class="x.myclass" >{{x.title1}}</span>
						</div>
				    </div>		 
		     </div>	    
					<iframe id="framePage" width="1000px" height="1000px" style="transform:scale(1.4,1.4);position: fixed; top: -200px; left: 150px;" scrolling="yes"	 src="http://www.w3schools.com/cssref/pr_pos_z-index.asp">
						<p>Your browser does not support iframes.</p>
					</iframe>


	</div>
	<script>
		var app = angular.module("myApp", []);
		app.controller("myCtrl", function($scope) {//這裡的$scope不能亂改變數名字
			$scope.doms = ${test};
			$scope.doAction=function(exid,action,x){
				var url = "${pageContext.request.contextPath}/ex002.mvc";
					$.ajax({
						method : "post",//
						url : url,
						async : false,
						data : {
							"exid" : exid,
							"action" : action
						}
					}).done(function(data) {
						//alert("done-success->" + JSON.stringify(data));
						x.done="ok";
					});
			};
			$scope.openTab=function(url){
				//window.open(url,'_blank');
				$("#framePage").attr("src",url);
				//alert(url);
			};
			$scope.keydown=function(){
				alert("keydown");
			};			
			
		});
	</script>
</body>
</html>