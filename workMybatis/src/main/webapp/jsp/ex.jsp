<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>test</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/angular.1.5.8.min.js"></script>
</head>
<body>

	<div ng-app="myApp" ng-controller="myCtrl">
	 <span >count=${count },<a href="${pageContext.request.contextPath}/ex001.mvc">重新整理</a></span>
	 			<div style="overflow-y: scroll; height:120px;width:1200px;">	 	
				<div  ng-repeat="x in doms">
		
						<span ng-mousedown="doAction(x.exid,'-1',x)">放棄下載</span>
					<span ng-mousedown="doAction(x.exid,'1',x)">註記已查詢</span>
					<span>{{x.done}}</span>
					<span ng-mousedown="openTab(x.url)">{{x.title1}}</span>
		
				</div>
			</div>		 
	 
				<iframe id="framePage" width="1000px" height="100%" scrolling="yes"	>
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
			
			
		});
	</script>
</body>
</html>