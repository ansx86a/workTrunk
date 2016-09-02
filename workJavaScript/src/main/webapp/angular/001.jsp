<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>angular測試1</title>
</head>
<body>

	<div style="position: fixed; bottom: 10px; right: 10px; width: 50px; border: 3px solid #73AD21;">
		<a href="#div0">回開頭</a>
	</div>


	<div id="div0" align="center">
		<p>菜鳥教程(抄w3c)：http://www.runoob.com/</p>
		<pre>一些網站
http://ithelp.ithome.com.tw/articles/10132196
https://www.gitbook.com/book/114000/angularjs-chinese-api/details
https://114000.gitbooks.io/angularjs-chinese-api/content/index.html
</pre>
		<p>
			<a href="#id1">表示式</a>
		</p>
		<p>
			<a href="#id2">Modules、model</a>
		</p>

		<p>
			<a href="#id3">Directives指令 templete(待補完)</a>
		</p>
		<p>
			<a href="#id4">Directives指令 dom</a>
		</p>
		<p>
			<a href="#id5">Validate </a>
		</p>
		<p>
			<a href="#id6">Filters(雷管處理DOM資料)</a>
		</p>
		<p>
			<a href="#id7">Services($location,$timeout,$interval)，自定service、filter</a>
		</p>
		<p>
			<a href="#id8">http</a>
		</p>
		<p>
			<a href="#id9">event</a>
		</p>
		<p>
			<a href="#id10">api</a>
		</p>
		<p>
			<a href="#id11">動畫(太高深了，等css3讀完再補吧)</a>
		</p>
		<p>
			<a href="#id12">route</a>
		</p>
		<p>
			<a href="#id13"></a>
		</p>
		<p>
			<a href="#id14"></a>
		</p>
		<p>
			<a href="#id15"></a>
		</p>

		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id1').value );">測試1</button>
		<br>
		<textarea id="id1" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		 <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
		 <script type="text/javascript" src="angular.1.5.8.min.js"></script>
		 <div ng-app="" ng-init="myCol='lightblue';quantity=3;cost=5;person={firstName:'John',lastName:'Doe'}";>
		  	<p>初始化參數:ng-init="myCol='lightblue';quantity=3;cost=5;person={firstName:'John',lastName:'Doe'}"</p>
 			<p>第一個表示式 ：{ { quantity * cost }}: {{ quantity * cost }} </p>
 			<p>表示式ng-bind(單向)的寫法：span ng-bind="quantity * cost" ：<span ng-bind="quantity * cost" />
				</p>
			<p>表示式加工 ：{ {"什麼鬼=" + quantity * cost }}: {{"什麼鬼="+ quantity * cost }} </p>
			<p>表示式可以用Object方式存取 { { person.lastName }}： {{ person.lastName }}</p>
 			<p>
 					input style="background-color:{ {myCol}}" ng-model="myCol" value="{ {myCol}}"<br>
					雙向綁定value值和style，ie看不到，用chrome測：<input style="background-color: {{myCol" ng-model="myCol" value="{{myCol}}">
 			</p>
 			
		 </div>
<script>
	
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id2').value );">測試2</button>
		<br>
		<textarea id="id2" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		 <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
		 <script type="text/javascript" src="angular.1.5.8.min.js"></script>
		 <div ng-app="myApp">
		 <div ng-controller="myCtrl">
		 		<p>ng-app下應該可以有多個ng-controller，但是我覺得就在同一層1:1就好了，沒必要1對多</p>
				<p>$scope變數宣告{ {lastName}}={{lastName}}</p>
				<p>可以用script匯入讓畫面乾淨，但我不會這麼用，script src="myApp.js">/script</p>
				<p>雙向(input)input ng-model="lastName"：<input ng-model="lastName" />
				</p>
				<p>單向(p span div...)span ng-bind="lastName" <span ng-bind="lastName" />	
				</p>
				<p>測試測用一個model可不可以雙bind[可以]<input ng-model="easyTest" />
				<button id="easyTest">測試</button>
				</p>
				<p>測rootScope in ctrl1，自已有color={{color}}</p>
		 </div>
	 	<div ng-controller="myCtrl2">
				<p>證明兩個control的socpe不影嚮{ {lastName}}={{lastName}}</p>
				<p>測rootScope in ctrl2，自已沒有color={{color}}</p>
		 </div>
		 	<p>測rootScope in root，沒有control仍可使用={{color}}</p>
		</div>
<script>
	var scope;
	var app = angular.module("myApp", []);

	app.controller("myCtrl", function($scope) {//這裡的$scope不能亂改變數名字
		$scope.firstName = "John";
		$scope.lastName = "Doe";
		$scope.color = "blue1";
		scope = $scope;
	});
	app.controller("myCtrl2", function($scope) {//這裡的$scope不能亂改變數名字
		$scope.firstName = "John2";
		$scope.lastName = "Doe2";
		//$scope.color = "blue2";
	});
	app.run(function($rootScope) {
		$rootScope.color = 'blue0';
	});
	$(document).ready(function() {
		$("#easyTest").on("click", function() {
			alert(scope.easyTest);
			scope.easyTest += "z";
			scope.$apply();
		});
	});
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id3').value );">測試3</button>
		<br>
		<textarea id="id3" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		 <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
		 <script type="text/javascript" src="angular.1.5.8.min.js"></script>		
		 <div ng-app="myApp">
		 <p>
E for Element name<br>
A for Attribute<br>
C for Class<br>
M for Comment<br>
<!-- directive: template -->
		 </p>
		 <p>發現測試，A比較好用，E第二個就不管用了(大小寫要對應-才會生效)，M要把replace改成true，template要tag開頭</p>
		 <p>晚點補完->https://www.sitepoint.com/practical-guide-angularjs-directives/  </p>
		 <p 我的-測試-樣板></p>
 		<p 你的-測試-樣板></p>
 		 <p class='my-class'></p>
 		 <p class='your-class'></p>
 		 <!-- directive: my-comment -->
 		 <!-- directive: w3-test-directive -->
		 <hello-everyone />
		 <hello-world />
		 
			</div>
<script>
	var app = angular.module("myApp", []);
	app.directive("我的測試樣板", function() {
		return {
			restrict : "A",
			template : "我的template成功"
		};
	});
	app.directive("你的測試樣板", function() {
		return {
			restrict : "A",
			template : "你的template成功"
		};
	});
	app.directive("myClass", function() {
		return {
			restrict : "C",
			template : "我的Class"
		};
	});
	app.directive("yourClass", function() {
		return {
			restrict : "C",
			template : "你的Class"
		};
	});
	app.directive("w3TestDirective", function() {
		return {
			restrict : "M",
			replace : true,
			template : "<h1>我的註解</h1>"
		};
	});
	app.directive("myComment", function() {
		return {
			restrict : "M",
			replace : true,
			template : "<h1>我的註解2</h1>"
		};
	});
	app.directive('helloEveryone', function() {
		return {
			restrict : 'E',
			template : 'helloEveryone!!什麼鬼啊'
		};
	});
	app.directive('helloWorld', function() {
		return {
			restrict : 'E',
			template : 'helloWorld!!什麼鬼啊'
		};
	});
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id4').value );">測試4</button>
		<br>
		<textarea id="id4" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		 <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
		 <script type="text/javascript" src="angular.1.5.8.min.js"></script>		
<style>
table, th, td {
	border: 1px solid grey;
	border-collapse: collapse;
	padding: 5px;
}

table tr:nth-child(odd) {
	background-color: #f1f1f1;
}

table tr:nth-child(even) {
	background-color: #ffffff;
}
</style>		 	
		 <div ng-app="myApp" ng-controller="myCtrl">
		 <p>
		 ng-repeat的用法：<span ng-repeat="x in names">	我是{{ x.name }}住{{x.country}}，</span>
		 </p>
		 <div>
				<table>
  				<tr ng-repeat="x in names">
  						<td>{{ $index + 1 }}</td>
    					<td>{{ x.name }}</td>
    					<td>{{ x.country| uppercase  }}</td>
    					<td ng-if="$odd">if is odd = {{$odd}}</td>
    					<td ng-if="$even">if is even = {{$even}}</td>
  				</tr>
			</table>
			一般的select綁定(default null option)：	<select ng-model="s1" ng-options="x.name for x in names"></select>
			<br>y.name for (x,y) in names->x變成陣列索引，y變成物件
				<select ng-model="s2" ng-options="y.name for (x,y) in names"></select>
					<br>x for (x,y) in cars物件來說，x是key，y是值
				<select ng-model="s3" ng-options="x for (x,y) in cars"></select>
					<br>用repeat做掉option(default select first option):<select>
						<option ng-repeat="x in names" value="{{x.name}}">{{x.name}}</option>
				</select>
				<p>select的值:{{s1}},{{s2}},{{s3}}，第4個要用jquery來取值</p>
		 </div>
		 <div>
		 		<input type="checkbox" ng-model="myBoolean">boolean設定</input>
		 		myBoolean={{myBoolean}}
		 		<button ng-disabled="myBoolean">禁用ng-disabled</button>
		 		<p ng-show="myBoolean">顯示ng-show</p>
		 		<p ng-hide="myBoolean">顯示ng-hide</p>
		 		<input type="radio" ng-model="myVar" value="dogs">Dogs
				<input type="radio" ng-model="myVar" value="tuts">Tutorials
				<input type="radio" ng-model="myVar" value="cars">Cars
		 		<p>radio的值:{{myVar}}</p>
		 </div>
		 <div ng-include="'${pageContext.request.contextPath}/test.jsp'">不能跨網域啦</div>
  		 <div ng-include="'http://www.w3schools.com/angular/customers.php'">設白名單就能跨網域啦，但是要加localhost進去不然本來的會掛掉</div>
				
		 </div>
<script>
	var app = angular.module("myApp", []);
	app.controller("myCtrl", function($scope) {//這裡的$scope不能亂改變數名字
		$scope.names = [ {
			name : 'Jani',
			country : 'Norway'
		}, {
			name : 'Hege',
			country : 'Sweden'
		}, {
			name : 'Kai',
			country : 'Denmark'
		} ];
		$scope.cars = {
			car01 : "Ford",
			car02 : "Fiat",
			car03 : "Volvo"
		};
	});
	//設白名單
	app.config(function($sceDelegateProvider) {
		$sceDelegateProvider.resourceUrlWhitelist([ 'http://www.w3schools.com/**', 'http://localhost:8080/**' ]);
	});
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id5').value );">測試5</button>
		<br>
		<textarea id="id5" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		 <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
		 <script type="text/javascript" src="angular.1.5.8.min.js"></script>	
		 <style>
input.ng-touched {
	background-color: pink;
}

input.ng-invalid {
	background-color: lightblue;
}

input.ng-valid {
	background-color: lightgreen;
}

form.ng-valid {
	background-color: lightgreen;
}

form.ng-invalid {
	background-color: lightblue;
}
</style>		
		  <div ng-app="myApp" ng-controller="myCtrl">
		       <form name="myForm">
		       <p>css的設定，下面的會蓋掉上面的</p>
    			    Email:<input type="email" name="myAddress" ng-model="text">
					<!-- 這裡的ng-model是？？？ -->
					<span ng-show="myForm.myAddress.$error.email">Not a valid e-mail address</span>
					Email2:<input type="email" name="myAddress2" ng-model="myText" required>
					<p>欄位=======================================</p>
					<p>Valid: {{myForm.myAddress2.$valid}} (if true, the value meets all criteria，符不符合驗証).
					<br>invalid: {{myForm.myAddress2.$invalid}}和上面相反
					<br>Dirty: {{myForm.myAddress2.$dirty}} (if true, the value has been changed，有沒有改過值).
					<br />	pristine:{{myForm.myAddress2.$pristine}}和上面相反
					<br />Touched: {{myForm.myAddress2.$touched}} (if true, the field has been in focus，有進入焦點後(false)離開為true).
					<br />untouched : {{myForm.myAddress2.$untouched }}和上面相反 
					</p>
					<p>form=======================================</p>
					<p>Valid: {{myForm.$valid}} (if true, the value meets all criteria，符不符合驗証).
					<br />invalid: {{myForm.$invalid}}和上面相反
					<br />Dirty: {{myForm.$dirty}} (if true, the value has been changed，有沒有改過值).
					<br />pristine:{{myForm.$pristine}}和上面相反
					<br />submitted :{{myForm.$submitted }}看起來沒什麼屁用</p>			
		       </form>
		       <form name="myForm2">
		      		 <input name="myInput" ng-model="myInput" required my-validate>
		      		  <span style="color: red" ng-show="myForm2.myInput.$invalid">
  							要輸入e才能過
  						</span>
		       </form>
		  </div>
		  <pre>css input
ng-untouched The field has not been touched yet
ng-touched The field has been touched
ng-pristine The field has not been  modified yet
ng-dirty The field has been modified
ng-valid The field content is valid
ng-invalid The field content is not valid
ng-valid-key One key for each validation. Example: ng-valid-required, useful when there are more than one thing that must be validated
ng-invalid-key Example: ng-invalid-required
css form
ng-pristine No fields has not been modified yet
ng-dirty One or more fields has been modified
ng-valid The form content is valid
ng-invalid The form content is not valid
ng-valid-key One key for each validation. Example: ng-valid-required, useful when there are more than one thing that must be validated
ng-invalid-key Example: ng-invalid-required

		  </pre>
<script>
	var app = angular.module("myApp", []);
	app.controller("myCtrl", function($scope) {//這裡的$scope不能亂改變數名字

	});
	//自定驗証
	app.directive('myValidate', function() {
		return {
			require : 'ngModel',
			link : function(scope, element, attr, mCtrl) {
				function myValidation(value) {
					if (value.indexOf("e") > -1) {
						mCtrl.$setValidity('charE', true);
					} else {
						mCtrl.$setValidity('charE', false);
					}
					return value;
				}
				mCtrl.$parsers.push(myValidation);
			}
		};
	});
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id6').value );">測試6</button>
		<br>
		<textarea id="id6" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		 <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
		 <script type="text/javascript" src="angular.1.5.8.min.js"></script>	
		  <div ng-app="myApp" ng-controller="myCtrl">
		  <p>轉小寫： {{ lastName | lowercase }}</p>
		  <p>轉大寫： {{ lastName | uppercase }}</p>
		  <p>轉金額會有3位逗號和小數點： {{ price | currency }}-{{ price | currency:"NT$" }}</p>
		  <p>
		  排序<span ng-repeat="x in names | orderBy:'name'">{{ x.name + ', '  }}</span>
		  </p>
		  <p>
		  排序倒序<span ng-repeat="x in names | orderBy:'name':true">{{ x.name+'-'+x.country + ', '  }}</span>
		  </p>
		  <p>
		  過濾no字串，隨1屬性符合即可不分大小寫<span ng-repeat="x in names | filter :'no'">{{ x.name+'-'+x.country + ', '  }}</span>
		  </p>		  
		  <p>
		  過濾<input ng-model="aaa">
					<span ng-repeat="x in names | filter :aaa">{{ x.name+'-'+x.country + ', '  }}</span>
		  <br>只比name：<span ng-repeat="x in names | filter :{name:aaa}">{{ x.name+'-'+x.country + ', '  }}</span>
		  <br>單字大小寫全同(可空白間隔單字)：<span ng-repeat="x in names | filter :aaa:true">{{ x.name+'-'+x.country + ', '  }}</span>
		  </p>	
		  
		  
		  </div>
<pre>
currency Format a number to a currency format.
date Format a date to a specified format.
filter Select a subset of items from an array.
json Format an object to a JSON string.
limitTo Limits an array/string, into a specified number of elements/characters.
lowercase Format a string to lower case.
number Format a number to a string.
orderBy Orders an array by an expression.
uppercase Format a string to upper case.
</pre>		  
		  
<script>
	var app = angular.module("myApp", []);
	app.controller("myCtrl", function($scope) {//這裡的$scope不能亂改變數名字
		$scope.lastName = "myLastName";
		$scope.price = 58123;
		$scope.names = [ {
			name : 'Jani',
			country : 'Norway'
		}, {
			name : 'Carl',
			country : 'Sweden'
		}, {
			name : 'Margareth',
			country : 'England'
		}, {
			name : 'Hege',
			country : 'Norway'
		} ];

	});
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id7').value );">測試7</button>
		<br>
		<textarea id="id7" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		 <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
		 <script type="text/javascript" src="angular.1.5.8.min.js"></script>			
		  <div ng-app="myApp" ng-controller="myCtrl">
		  	<p>等同window.location?，這裡先印網址{{location}}</p>
		  	<p>測試timeout={{timeout}}</p>
		  	<p>測試interval={{interval}}</p>
		    <p>testHex254={{testHex}}</p>
		  	<p>253|myHexFormat = {{253|myHexFormat}}</p>
		  </div>		 
<script>
	var tcount = 0;
	var app = angular.module("myApp", []);
	//controller寫多次會被蓋過去
	app.controller("myCtrl", function($scope, $location, $timeout, $interval, HexUtil) {//這裡的$scope不能亂改變數名字
		$scope.location = $location.absUrl();
		$timeout(function() {
			$scope.timeout = "How are you today?" + (++tcount);
		}, 500);
		$interval(function() {
			$scope.interval = new Date().toLocaleTimeString();
		}, 1000);

		$scope.testHex = HexUtil.toHex(254);
	});

	app.service('HexUtil', function() {
		//一個service可以有多個function
		this.toHex = function(x) {
			return x.toString(16);
		}
	});
	app.filter('myHexFormat', [ 'HexUtil', function(HexUtil) {
		return function(x) {
			return HexUtil.toHex(x);
		};
	} ]);
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id8').value );">測試8</button>
		<br>
		<textarea id="id8" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		 <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
		 <script type="text/javascript" src="angular.1.5.8.min.js"></script>			
		  <div ng-app="myApp" ng-controller="myCtrl">
		  	<p>get：{{get}}</p>
		  	<p>get可以跨網域：{{get2}}</p>
		  	<p>get較詳細的寫法：{{get3}}</p>
		  </div>		 
<pre>如果有需要再補完，目前覺得這部分用jquery就夠了
.delete()
.get()
.head()
.jsonp()
.patch()
.post()
.put()
</pre>		  
<script>
	var app = angular.module("myApp", []);
	app.controller("myCtrl", function($scope, $http) {//這裡的$scope不能亂改變數名字
		$http.get("${pageContext.request.contextPath}/jquery001.mvc?aa=cc&bb=aa&qq=ww").then(function(response) {
			$scope.get = response.data;//好像是非同步，無法變更
		});
		$http.get("http://www.w3schools.com/angular/customers.php").then(function(response) {
			$scope.get2 = response.data;//好像是非同步，無法變更
		});
		$http({
			method : "GET",
			url : "${pageContext.request.contextPath}/jquery001.mvc?aa=cc&bb=aa&qq=ww"
		}).then(function mySucces(response) {//這裡的function後的mySucces可以省略，有比較好辨別 
			$scope.get3 = response.data;
		}, function myError(response) {//這裡的function後的myError可以省略，有比較好辨別 
			$scope.get3 = response.statusText;
		});

	});
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id9').value );">測試9</button>
		<br>
		<textarea id="id9" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		 <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
		 <script type="text/javascript" src="angular.1.5.8.min.js"></script>		
		  <div ng-app="myApp" ng-controller="myCtrl">
		  <p ng-mousedown="count = count + 1">ng-mousedown，按左中右鍵,count={{count}}</p>
		  <p ng-mouseenter="count2 = count2 + 1">ng-mouseenter，進來,count2={{count2}}</p>
		  <p ng-mouseleave="count3 = count3 + 1">ng-mouseleave，出去,count3={{count3}}</p>
		  <p ng-mousemove="count4 = count4 + 1">ng-mousemove，移動,count4={{count4}}</p>
		  <p ng-mousemove="xy($event)">ng-mousemove，移動,x={{x}},y={{y}}</p>
		  <p ng-mouseover="count5 = count5 + 1">ng-mouseover，在上面,count5={{count5}}</p>
		  <p ng-mouseup="count6 = count6 + 1">ng-mouseup，彈起左中右鍵,count6={{count6}}</p>		
		  <p ng-click="count7 = count7 + 1">ng-click，完成一次左中鍵按上彈起，右鍵彈menu所以不計數,count7={{count7}}</p>		  
		  <p ng-dblclick="count8 = count8 + 1">ng-dblclick，完成一次左鍵按上彈起，中右鍵好像不計數,count8={{count8}}</p>
		  <%--
		  <input type="text" ng-blur="aa1" ng-change="a2=a2+1" ng-copy="a3=a3+1" ng-cut="a4=a4+1" ng-focus="a5=a5+1"
					ng-paste="a6=a6+1" ng-keydown="a7=a7+1" ng-keypress="a8=a8+1" ng-keyup="a9=a9+1"></input>
		  <p>blur:{{aa1}},change:{{aa2}},copy:{{aa3}},cut:{{aa4}},focus:{{aa5}},paste:{{aa6}},keydown:{{aa7}},keypress:{{aa8}},keyup:{{aa9}}</p>
		   --%>
		  <input type="text" ng-blur="a1=a1+1" ng-copy="a3=a3+1" ng-cut="a4=a4+1" ng-focus="a5=a5+1" ng-paste="a6=a6+1"
					ng-keydown="a7=a7+1" ng-keypress="a8=a8+1" ng-keyup="a9=a9+1"></input>
		  <p>blur:{{a1}},copy:{{a3}},cut:{{a4}},focus:{{a5}},paste:{{a6}},keydown:{{a7}},keypress:{{a8}},keyup:{{a9}}</p>
		  <p>ng-change卡住了，晚點再測</p>
		  </div>		 	
<pre>
ng-blur
ng-change
ng-click
ng-copy
ng-cut
ng-dblclick
ng-focus
ng-keydown
ng-keypress
ng-keyup
ng-mousedown
ng-mouseenter
ng-mouseleave
ng-mousemove
ng-mouseover
ng-mouseup
ng-paste
</pre>		  
<script>
	var app = angular.module("myApp", []);
	app.controller("myCtrl", function($scope) {//這裡的$scope不能亂改變數名字
		$scope.xy = function(event) {
			$scope.x = event.clientX;
			$scope.y = event.clientY;
		};

	});
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id10').value );">測試10</button>
		<br>
		<textarea id="id10" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		 <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
		 <script type="text/javascript" src="angular.1.5.8.min.js"></script>
		  <div ng-app="myApp" ng-controller="myCtrl">
		  <p>copy:{{copy}}</p>
		  <p>轉小寫：{{lower}}，轉大寫:{{upper}}</p>
  		  <p>是字串：{{isString}}，是數字:{{isNumber}}</p>
		  </div>		 			
<script>
	var app = angular.module("myApp", []);
	app.controller("myCtrl", function($scope) {//這裡的$scope不能亂改變數名字
		$scope.names = [ {
			name : 'Jani',
			country : 'Norway'
		}, {
			name : 'Hege',
			country : 'Sweden'
		}, {
			name : 'Kai',
			country : 'Denmark'
		} ];
		$scope.copy = angular.copy($scope.names);
		$scope.lower = angular.lowercase($scope.names[0].name);
		$scope.upper = angular.uppercase($scope.names[0].name);
		$scope.isString = angular.isString("123");
		$scope.isNumber = angular.isNumber("123");

	});
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id11').value );">測試11</button>
		<br>
		<textarea id="id11" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		 <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
		 <script type="text/javascript" src="angular.1.5.8.min.js"></script>
		 <script type="text/javascript" src="angular-animate.min.js"></script>
<style>
div div {
	transition: all linear 0.5s;
	background-color: lightblue;
	height: 100px;
	width: 100%;
	position: relative;
	top: 0;
	left: 0;
}

.ng-hide {
	height: 0;
	width: 0;
	background-color: transparent;
	top: -200px;
	left: -200px;
}
</style>


<div ng-app="myApp" ng-controller="myCtrl">
	<p>
		Hide the DIV: <input type="checkbox" ng-model="myCheck">
	</p>
	<div ng-hide="myCheck"></div>
</div>
<script>
	var app = angular.module("myApp", [ 'ngAnimate' ]);
	app.controller("myCtrl", function($scope) {//這裡的$scope不能亂改變數名字

	});
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id12').value );">測試12</button>
		<br>
		<textarea id="id12" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		 <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
		 <script type="text/javascript" src="angular.1.5.8.min.js"></script>
		 <script type="text/javascript" src="angular-route.min.js"></script>		 
		  <div ng-app="myApp" ng-controller="myCtrl">
				<a href="#/">Main</a>
				<a href="#red">Red</a>
				<div ng-view></div>
		  </div>		 			
<script>
	var app = angular.module("myApp", [ "ngRoute" ]);
	app.controller("myCtrl", function($scope) {//這裡的$scope不能亂改變數名字

	});
	app.config(function($routeProvider) {
		$routeProvider.when("/", {
			templateUrl : "main.jsp"
		}).when("/red", {
			templateUrl : "red.jsp"
		});
	});
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id13').value );">測試13</button>
		<br>
		<textarea id="id13" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		 <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
		 <script type="text/javascript" src="angular.1.5.8.min.js"></script>
		  <div ng-app="myApp" ng-controller="myCtrl">
		  
		  </div>		 			
<script>
	var app = angular.module("myApp", []);
	app.controller("myCtrl", function($scope) {//這裡的$scope不能亂改變數名字

	});
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id14').value );">測試14</button>
		<br>
		<textarea id="id14" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		 <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
		 <script type="text/javascript" src="angular.1.5.8.min.js"></script>
		  <div ng-app="myApp" ng-controller="myCtrl">
		  
		  </div>		 			
<script>
	var app = angular.module("myApp", []);
	app.controller("myCtrl", function($scope) {//這裡的$scope不能亂改變數名字

	});
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id15').value );">測試15</button>
		<br>
		<textarea id="id15" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		 <script type="text/javascript" src="jquery-3.0.0.min.js"></script>
		 <script type="text/javascript" src="angular.1.5.8.min.js"></script>
		  <div ng-app="myApp" ng-controller="myCtrl">
		  
		  </div>		 			
<script>
	var app = angular.module("myApp", []);
	app.controller("myCtrl", function($scope) {//這裡的$scope不能亂改變數名字

	});
</script>
		</textarea>
		<br>


	</div>







</body>
<script>
	function javascriptWindow(txt) {
		開新視窗: {
			var x = screen.width / 2 - 600 / 2;
			var y = screen.height / 2 - 500 / 2;
			var w = window.open("", "", "scrollbars=1;width=600,height=500,left=" + x + ",top=" + y);
			w.document.open();
			w.document.write(txt);
			w.document.close();
		}
	}
</script>
</html>

