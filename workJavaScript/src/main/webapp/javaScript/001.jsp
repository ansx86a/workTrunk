<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>簡單的第一課</title>
</head>
<body>

	<div style="position: fixed; bottom: 10px; right: 10px; width: 50px; border: 3px solid #73AD21;">
		<a href="#div0">回開頭</a>
	</div>


	<div id="div0" align="center">
		<p>ECMAScript :http://www.w3school.com.cn/js/index_pro.asp</p>
		<p>JavaScript Number 对象 :http://www.w3school.com.cn/jsref/jsref_obj_number.asp</p>
		<a href="#id1">測試用document寫出文字、escape文字，用javascript替換文字和style</a>
		<p>如果在html載入完成後執行document.write，整個 HTML將被覆盖：</p>
		<p>外部javascript匯入語法 &ltscript src="myScript.js"> &lt/script>(可放head，也可以放在body中用document.write產生文字)</p>
		<p>
			<a href="#id2">javascript 類型宣告 字符串、数字、布尔、数组、对象、Null、Undefined，jsonStr轉object</a>
		</p>
		<p>
			<a href="#id3">javascript 數字轉換函數，===，驗証nan非數字[好像不是絕對可靠]</a> <br>
		</p>
		<p>整數至多15位，小數最大位數17，浮數運算和java相同[0.1+0.2=0.30000000000000004]，有toString和valueOf可以用</p>
		<p>
			<a href="#id4">運算符 || && !三種，位元運算</a>
		</p>
		<p>
			<a href="#id5">switch、for、forin[用在json的key，array的index]範例</a>
		</p>
		<p>迴圈中可以加lable，和java相同可以用 break label或是continue label</p>
		<p>
			<a href="#id6">try catch範例</a>
		</p>
		<p>
			<a href="#id7">prototype範例</a>
		</p>
		<p>
			<a href="#id8">字串範例</a>
		</p>
		<p>
			<a href="#id9">日期範例</a>
		</p>
		<p>
			<a href="#id10">陣列範例</a>
		</p>
		<p>
			<a href="#id11">數學範例</a>
		</p>
		<p>
			<a href="#id12">正規表示式範例</a>
		</p>
		<p>
			<a href="#id13">browser物件</a>
		</p>
		<p>
			<a href="#id14">Screen物件</a>
		</p>
		<p>
			<a href="#id15">Location物件</a>
		</p>
		<p>
			<a href="#id16">History 物件</a>
		</p>
		<p>
			<a href="#id17">Navigator 物件</a>
		</p>
		<p>
			<a href="#id18">Cookies 物件</a>
		</p>

		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id1').value );">測試1</button>
		<br>
		<textarea id="id1" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<div id="div1">this is div1</div>
<div id="div2">this is div2</div>			
<script>
	document.write("<h1>This is a\
			heading</h1>");//字串可以用一個\換行
	document.write("<p>This is a paragraph.</p>");
	document.write(escape("<p>This is a paragraph.</p>"));//用unescape可以回來
	x = document.getElementById("div1") //查找元素
	x.innerHTML = "Hello JavaScript"; //改变内容	
	x = document.getElementById("div2") //找到元素
	x.style.color = "#ff0000"; //改变样式
	x = "aa123";
	if (x == "" || isNaN(x)) {
		alert("Not\
Numeric");
	}
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id2').value );">測試2</button>
		<br>
		<textarea id="id2" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	//new String()也可以用，感覺沒有用處
	var x1 = 34.00; //使用小数点来写
	var x2 = 34, x3 = new Number(), x4 = new Number(777); //不使用小数点来写
	var x5 = x4.valueOf();//還有 toString()方法
	var y1 = 123e5; // 12300000
	var z1 = 183e-5; // 0.00123
	var x = true, xx = new Boolean(), xxx = new Boolean(true);
	var y = false;
	var nul = null;
	var cars = new Array();
	cars[0] = "Audi";
	cars[1] = "BMW";
	cars[2] = "Volvo";//陣列
	var cars2 = [ "Audi", "BMW", "Volvo" ];//陣列2
	var person2 = new Object();
	var person = {
		firstname : "Bill",
		lastname : "Gates",//前面沒用"lastname"，就不能用person["lastname"]只能用person.lastname]
		id : 5566
	};//object
	var text = '{"firstName":"John","lastName":"Doe"}';
	var obj = JSON.parse(text);//json字串轉obj，轉回來用JSON.stringify(person)，ie8之後才能用
	var obj2 = eval("(" + text + ")");//舊版沒有JSON.parse的寫法
	document.write("x1:" + x1 + "<br>");
	document.write("x2,x3,x5:" + x2 + "," + x3 + "," + x5 + "<br>");
	document.write("y1:" + y1 + "<br>");
	document.write("z1" + z1 + "<br>");//fix是4捨5入
	document.write("x,xx:" + x, "," + xx + "<br>");
	document.write("y:" + y + "<br>");
	document.write("nul:" + nul + "<br>");
	document.write("cars:" + cars + "<br>");
	document.write("car2:" + cars2 + "<br>");
	document.write("person2,person,person.firstname:");
	document.write(person2 + person + "," + person.firstname + "<br>");
	document.write("obj,obj.firstName,obj['lastname']:");
	document.write(obj + "," + obj.firstName + "," + obj['lastname'] + "<br>");
	document.write("obj2,obj2.firstName,obj2['lastName']:");
	document.write(obj2 + "," + obj2.firstName + "," + obj2["lastName"] + "<br>");
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id3').value );">測試3</button>
		<br>
		<textarea id="id3" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	document.write("parseInt測試<br>");
	document.write("parseInt(aaa),parseInt(0xa),parseInt('AF', 16):<br>");
	document.write(parseInt("aaa") + "," + parseInt("0xa") + "," + parseInt("AF", 16) + "<br>");
	document.write("parseInt測試<br>");
	document.write("parseFloat('12345red''),parseFloat('11.22.33'),parseFloat('0102''):<br>");
	document.write(parseFloat("11.22.33") + "," + parseInt("0xa") + "," + parseFloat("0102") + "<br>");
	document.write("toFixed四捨五入測試<br>");
	document.write("12345.23567.toFixed(3):" + 12345.23567.toFixed(3) + "<br>");//小數點3位四捨五入
	document.write("typeof測試<br>");
	document.write("typeof 86,typeof 'xx':" + typeof 86 + "," + typeof 'xx' + "<br>");
	document.write("型別測試<br>");
	document.write("[111].constructor,'a'.constructor:" + [ 111 ].constructor + "," + 'a'.constructor + "<br>");
	document.write("型別測試2<br>");
	document.write("Array,String:" + Array + "," + String + "<br>");
	document.write("undefined是null的子型別的概念測試<br>");
	document.write("(null == undefined):" + (null == undefined) + "<br>");
	document.write("判斷是不是有限值，也可以做為是不是正常數字的判斷測試？<br>");
	document.write("(isFinite(1122)):" + (isFinite(1122)) + "<br>");
	document.write("isNaN判斷是不是非數字測試？<br>");
	document.write("(NaN == NaN),(isNaN('blue'),(isNaN('666')):<br>");
	document.write((NaN == NaN) + "," + (isNaN('blue')) + "," + (isNaN('666')) + "<br>");
	document.write(" 三個等於也會判斷型別測試<br>");
	document.write("(5 == '5'),(5 === '5')):");
	document.write((5 == '5') + "," + (5 === '5') + "<br>");
	document.write(" Number toString ttt=255，轉16進制測試<br>");
	var ttt = 255;
	document.write("ttt.toString(16):" + ttt.toString(16) + "<br>");
</script>
<table class="dataintable">
		<tbody>
			<tr>
				<th style="width: 60%;">用法</th>
				<th>结果</th>
			</tr>
			<tr>
				<td>Number(false)</td>
				<td>0</td>
			</tr>
			<tr>
				<td>Number(true)</td>
				<td>1</td>
			</tr>
			<tr>
				<td>Number(undefined)</td>
				<td>NaN</td>
			</tr>
			<tr>
				<td>Number(null)</td>
				<td>0</td>
			</tr>
			<tr>
				<td>Number("1.2")</td>
				<td>1.2</td>
			</tr>
			<tr>
				<td>Number("12")</td>
				<td>12</td>
			</tr>
			<tr>
				<td>Number("1.2.3")</td>
				<td>NaN</td>
			</tr>
			<tr>
				<td>Number(new object())</td>
				<td>NaN</td>
			</tr>
			<tr>
				<td>Number(50)</td>
				<td>50</td>
			</tr>
		</tbody>
	</table>


		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id4').value );">測試4</button>
		<br>
		<textarea id="id4" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	var a = 0;
	if (a == 0 || a++ == 0) {
		document.write("用||，第一個條件成立就不會有第二條件的運算<br>(a==0 || a++==0)，a=");
		document.write(a);
	}
	if (a == 1 || a++ == 1) {
		document.write("<br>這裡主要是要讓它跑第二個條件的運算");
	}
	document.write("<br>用||，會有第二條件的運算<br>(a==1 || a++==1)，a=");
	document.write(a);
	document.write("<br>用|，位元運算<br> (a|8)=");
	document.write((a | 8));
	document.write("<br>用|，位元運算<br> (a|1)=");
	document.write((a | 1));
	document.write("<br>用if(1)看有沒有執行=");
	if (1) {
		document.write("有執行");
	} else {
		document.write("無執行");
	}
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id5').value );">測試5</button>
		<br>
		<textarea id="id5" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	var day = new Date().getDay();
	switch (day) {
		case 6:
			x = "Today it's Saturday";
			break;
		case 0:
			x = "Today it's Sunday";
			break;
		default:
			x = "Looking forward to the Weekend";
	}
	document.write("switch:" + x);
	document.write("<br>");
	for (var i = 0; i < 5; i++) {
		document.write("for:" + i + "<br>");
	}

	var person = {
		fname : "John",
		lname : "Doe",
		age : 25
	};
	document.write("person:" + JSON.stringify(person) + "<br>");
	for (x in person) {
		document.write("person forin:" + x + ":" + person[x] + "<br>");
	}
	var array = [ "ssss", 1111, "hhhh", "wwwww" ];
	document.write("array:" + array + "<br>");
	for (x in array) {
		document.write("array forin:" + x + ":" + array[x] + "<br>");
	}
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id6').value );">測試6</button>
		<br>
		<textarea id="id6" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	try {
		document.write("errorTest:");

		var x = "";
		if (x == "") throw "empty";
		if (isNaN(x)) throw "not a number";
		if (x > 10) throw "too high";
		if (x < 5) throw "too low";
	} catch (err) {
		document.write(err);
	}
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id7').value );">測試7</button>
		<br>
		<textarea id="id7" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	function person(firstname, lastname, age) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.old = old; //就算是function，也要給值才能用
		function old() {
			this.age++;
		}
	}
	var p = new person("名字", "姓氏", 33);
	document.write("person=" + JSON.stringify(p));
	p.old();
	document.write("<br>person=" + JSON.stringify(p));
</script>
		</textarea>
		<br>

		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id8').value );">測試8</button>
		<br>
		<textarea id="id8" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	var a = "字串的test";
	document.write(a.big() + "<br>");
	document.write("長度測試：a.length=" + a.length + "<br>");
	document.write("回傳第三個字：a.charAt(2)=" + a.charAt(2) + "<br>");
	document.write("回傳第三個字unicode：a.charCodeAt(2)=" + a.charCodeAt(2) + "<br>");
	document.write("字串相接：a.concat(',','a','b','Z')=" + a.concat(',', 'a', 'b', 'Z') + "<br>");
	document.write("字串出現位置：a.indexOf('t') ，找不到回傳-1=" + a.indexOf('t') + "<br>");
	document.write("字串最後出現位置：a.lastIndexOf('t') ，找不到回傳-1=" + a.lastIndexOf('t') + "<br>");
	document.write("字串比大小：a.localeCompare('1')，排序用=" + a.localeCompare('1') + "<br>");
	document.write("取出字串中的數字[陣列？]：'aa1bb2cc33dd'.match(/\d+/g) =" + 'aa1bb2cc33dd'.match(/\d+/g) + "<br>");
	var xx = 'aa1bb2cc33dd'.match(/\d+/g);
	for ( var x in xx) {
		document.write(x + ":" + xx[x] + "-");
	}
	document.write("<br>");
	document.write("替換第一個： 'a1b2c33aABb44b'.replace(/b/,'冏')  =" + 'a1b2c33aABb44b'.replace(/b/, '冏') + "<br>");
	document.write("全部替換： 'a1b2c33aABb44b'.replace(/b/,'冏')  =" + 'a1b2c33aABb44b'.replace(/b/g, '冏') + "<br>");
	document.write("替換不分大小寫： 'a1b2c33aABb44b'.replace(/b/ig,'冏')  =" + 'a1b2c33aABb44b'.replace(/b/ig, '冏') + "<br>");
	document.write("找出出現位置不分大小寫:'a1B2c33aABb44b'.search(/B/i) =" + 'a1B2c33aABb44b'.search(/b/i) + "<br>");
	document.write("substr()在ECMAscript 沒標準化，最好不要用，而substring可用但不接受負數[會變成0，ex：substring(3,-2)等於substring(0,3)]，slice看來最強<br>");
	document.write("捉最後3字： 'a1B2c33aABb44b'.slice(-3)=" + 'a1B2c33aABb44b'.slice(-3) + "<br>");
	document.write("捉3-6字： 'a1B2c33aABb44b'.slice(2,5)=" + 'a1B2c33aABb44b'.slice(2, 5) + "<br>");
	document.write("拆分字串：'a1B2c33aABb44b'.split('B')=" + 'a1B2c33aABb44b'.split('B') + "<br>");
	document.write("拆分字串，取前2個：'a1B2c33aABb44b'.split('B',2)=" + 'a1B2c33aABb44b'.split('B', 2) + "<br>");
	document.write("拆分成字元陣列：'a1B2c33aABb44b'.split('')=" + 'a1B2c33aABb44b'.split('') + "<br>");
	document.write("拆分字串正規表示： 'a1B2c33aABb44b'.split(/\d+/)=" + 'a1B2c33aABb44b'.split(/\d+/) + "<br>");
	document.write("轉小寫： 'a1B2c33aABb44b'.toLowerCase()=" + 'a1B2c33aABb44b'.toLowerCase() + "<br>");
	document.write("轉大寫： 'a1B2c33aABb44b'.toUpperCase()=" + 'a1B2c33aABb44b'.toUpperCase() + "<br>");
	document.write("轉大小寫有local方法，如土耳其語會用local才會正確，一般不需要local方法<br>");
</script>
<pre>
\0nnn	八進制代碼 nnn 表示的字符（n 是 0 到 7 中的一個八進制數字）
\xnn	十六進制代碼 nn 表示的字符（n 是 0 到 F 中的一個十六進制數字）
\unnnn	十六進制代碼 nnnn 表示的 Unicode 字符（n 是 0 到 F 中的一個十六進制數字）
</pre>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id9').value );">測試9</button>
		<br>
		<textarea id="id9" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	document.write("今天的日期：new Date()=" + new Date() + "<br>");
	document.write("今天的日期(localString)：new Date().toLocaleString()=" + new Date().toLocaleString() + "<br>");
	document
			.write("今天的日期(localdateString)：new Date().toLocaleDateString()=" + new Date().toLocaleDateString() + "<br>");
	document
			.write("今天的日期(localtimeString)：new Date().toLocaleTimeString()=" + new Date().toLocaleTimeString() + "<br>");
	var d = new Date();
	d.setFullYear(2016, 11, 22);
	document.write("設定日期(setFullYear(2016,11,22))：d.toLocaleString()=" + d.toLocaleString() + "<br>");
	document.write("取得日(1-31)：new Date().getDate()=" + new Date().getDate() + "<br>");
	document.write("取得星期(日0-6六)：new Date().getDay()=" + new Date().getDay() + "<br>");
	document.write("取得月份(一0-11十二)：new Date().getMonth()=" + new Date().getMonth() + "<br>");
	document.write("取得小時(0-23)：new Date().getHours()=" + new Date().getHours() + "<br>");
	document.write("取得分(0-59)：new Date().getMinutes()=" + new Date().getMinutes() + "<br>");
	document.write("取得秒(0-59)：new Date().getSeconds()=" + new Date().getSeconds() + "<br>");
	document.write("取得毫秒(0-999)：new Date().getMilliseconds()=" + new Date().getMilliseconds() + "<br>");
	document.write("取得1970年到現在的ms：new Date().getTime()=" + new Date().getTime() + "<br>");
	document.write("取得 (GMT)分鐘差：new Date().getTimezoneOffset()=" + new Date().getTimezoneOffset() + "<br>");
	document.write("取得UTC小時(0-23)，其它同理可證：new Date().getUTCHours()=" + new Date().getUTCHours() + "<br>");
	document.write("其它同理可證：new Date().setUTCHours(),new Date().setHours(),new Date().setTime() <br>");
</script>
		</textarea>
		<br>

		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id10').value );">測試10</button>
		<br>
		<textarea id="id10" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	var a = [ 1, 2 ];
	var b = [ "A", "B" ];
	document.write("合併陣列：[].concat(a,b,'zz','xx')=" + [].concat(a, b, 'zz', 'xx') + "<br>");
	document.write("修改分隔符號：[].concat(a,b,'zz','xx').join('冏')=" + [].concat(a, b, 'zz', 'xx').join('冏') + "<br>");
	document.write("pop取出最後一個並刪除：(b.pop() --> b) =" + (b.pop() + "-->" + b) + "<br>");
	document.write("push加入多個元素：(b.push('kk','ff','cc','dd','ww','zz','yy')-->b) ="
			+ (b.push('kk', 'ff', 'cc', 'dd', 'ww', 'zz', 'yy') + "-->" + b) + "<br>");
	document.write("反轉陣列值：b.reverse() =" + b.reverse() + "<br>");
	document.write("反pop取出第一個並刪除：(b.shift() --> b) =" + (b.shift() + "-->" + b) + "<br>");
	document.write("反push加入多個元素：(b.unshift(1,2,3) --> b) =" + (b.unshift(1, 2, 3) + "-->" + b) + "<br>");

	document.write("取回最後2個元素：b.slice(-2) =" + b.slice(-2) + "<br>");
	document.write("取回2,3個元素：b.slice(1,3) =" + b.slice(1, 3) + "<br>");
	document.write("排序陣列值：b.sort()-->b =" + (b.sort() + "-->" + b) + "<br>");
	document.write("sort(sortNumber)可自已定義排序的method：function sortNumber(a, b){return a - b}<br>");

	document.write("刪除最後2個元素：(b.splice(-2) -->b) =" + (b.splice(-2) + "-->" + b) + "<br>");
	document.write("刪除第2個元素並加入2個元素：(b.splice(1,1,'冏','囧') -->b) =" + (b.splice(1, 1, '冏', '囧') + "-->" + b) + "<br>");
</script>
		</textarea>
		<br>

		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id11').value );">測試11</button>
		<br>
		<textarea id="id11" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	document.write("絕對值:Math.abs(-7.25)=" + Math.abs(-7.25) + "<br>");
	document.write("三角函數：acos(x),asin(x),atan(x),atan2(y,x),cos(x),sin(x),tan(x)<br>");
	document.write("取自然對數e的指數：Math.exp(1)=" + Math.exp(1) + "<br />")
	document.write("取log自然對數e為底：Math.log(2.7183)=" + Math.log(2.7183) + "<br />")
	document
			.write("正數無絛件進位，負數捨去：Math.ceil(0.40),Math.ceil(-3.4)=" + Math.ceil(0.40) + "," + Math.ceil(-3.4) + "<br />")
	document.write("正數無條件捨去，負數進位：Math.floor(2.40),Math.floor(-3.4)=" + Math.floor(2.40) + "," + Math.floor(-3.4)
			+ "<br />")
	document.write("四捨五入，正數小於捨去，負數小於也捨去：Math.round(0.40),Math.round(-3.4)=" + Math.round(0.40) + "," + Math.round(-3.4)
			+ "<br />")
	document.write("四捨五入，正數大於進位，負數大於也進位：Math.round(0.60),Math.round(-3.6)=" + Math.round(0.60) + "," + Math.round(-3.6)
			+ "<br />")

	document.write("取較大值：Math.max(-3,-5)=" + Math.max(-3, -5) + "<br />")
	document.write("取較小值：Math.min(-3,-5)=" + Math.min(-3, -5) + "<br />")
	document.write("產生0-1之間的亂數：Math.random()=" + Math.random() + "<br />")
	document.write("取數值的幾次方：Math.pow(2,10)=" + Math.pow(2, 10) + "<br />")
	document.write("開根號：	Math.sqrt(9)=" + Math.sqrt(9) + "<br />")

	document.write("<br>");
	document.write("Math.E=" + Math.E + "<br>");
	document.write("Math.LN2=" + Math.LN2 + "<br>");
	document.write("Math.LN10=" + Math.LN10 + "<br>");
	document.write("Math.LOG2E=" + Math.LOG2E + "<br>");
	document.write("Math.LOG10E=" + Math.LOG10E + "<br>");
	document.write("Math.PI=" + Math.PI + "<br>");
	document.write("Math.SQRT1_2=" + Math.SQRT1_2 + "<br>");
	document.write("Math.SQRT2=" + Math.SQRT2 + "<br>");
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id12').value );">測試12</button>
		<br>
		<textarea id="id12" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	document.writeln("宣告=/pattern/attributes  or  new RegExp(pattern, attributes);" + "<br>");
	document.writeln("attributes為i大小寫，g全域，m多行於ECMAScript 標準化後支援" + "<br>");
	document.writeln("找出有出現all的單字：'Is this all there is'.match(/[a-z]+(?= all)/ig)="
			+ 'Is this all there is'.match(/[a-z]+(?= all)/ig) + "<br>");
	document.writeln("下例是非貪婪的匹配，出乎我的意料之外<br>");
	document.writeln("找出沒有出現all的單字：'Is this all there is'.match(/[a-z]+(?! all)/ig)="
			+ 'Is this all there is'.match(/[a-z]+(?! all)/ig) + "<br>");
	document.writeln("顯示attributes：/a/.global,/a/g.global,/a/.ignoreCase,/a/i.ignoreCase=" + /a/.global + ","
			+ /a/g.global + "," + /a/.ignoreCase + "," + /a/i.ignoreCase + "<br>");
	document.writeln("顯示attributes：/a/.multiline,/a/m.global=" + /a/.multiline + "," + /a/m.multiline + "<br>");
	document.writeln("compile用途不明，直接patt=/xxx/比較快，為什麼還要patt.compile(/xxx/)" + "<br>");
	document.writeln("compile用法應該是patt.compile('[a-z]+','g') ，沒試過不過差不多是這樣子" + "<br>");
	//var patt = new RegExp("W3School","g");
	var patt = /w3s/ig;
	document.writeln("patt = /w3s/ig，和string.match類似的功能，但一次回傳一個，加上回傳index：<br>");
	document.writeln("patt.exec('Visw3sit W3School'),patt.exec('Visw3sit W3School'),patt.lastIndex="
			+ patt.exec('Visw3sit W3Schoo') + "，" + patt.exec('Visw3sit W3Schoo') + "，" + patt.lastIndex + "<br>");
	document.writeln("index停在S，把g拿掉index會變0，但仍會捉到後面的W3S：<br>");
	document.writeln("test： patt.test('abc'), patt.test('aaw3saa') '=" + patt.test('abc') + "," + patt.test('aaw3saa')
			+ "<br>");
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id13').value );">測試13</button>
		<br>
		<textarea id="id13" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	//w3c的範例，說適用全部的browser了
	var w = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
	var h = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
	document.writeln("視窗的寬高：" + w + "," + h + "<br>");
	document.writeln("子視窗或frame的最上層視窗：window.top.location=" + window.top.location + "<br>");
	document.writeln("自已視窗是不是最上層：window.top==window.self=" + (window.top == window.self) + "<br>");
	document.writeln("這裡的視窗要再研究一下，會不會是opne的參數null開的新視窗沒有opener呢？，還是top是看iframe的而已<br>")
	document.writeln("setInterval和clearInterval[週期],setTimeout和clearTimeout[一次性]<br>")
	document.writeln("控制滾輪：scrollBy(x,y) , scrollTo(x,y) <br>");
</script>
<br>
<input type="button" value="確認視窗" onclick='confirm("確認資訊，你腋下如何啊")?alert("可"):alert("不可");' /><br>
<input type="button" value="輸入視窗" onclick='alert("我叫:" +prompt("你叫啥米名","預設值"));' /><br>

<input type="button" onclick="window.open('http://www.kimo.com.tw');" value="open開新分頁[最簡單的例子]" /><br>
<input type="button" value="開新視窗加一堆設定"
				onclick='window.open("http://www.kimo.com.tw","_blank","toolbar=yes, location=yes, directories=no, status=no, menubar=yes, scrollbars=yes, resizable=no, copyhistory=yes, width=400, height=400")' />
<div>
<h2 id="windowfeatures">窗口特征（Window Features）</h2>
<table class="dataintable">
    <tr>
    <td>channelmode=yes|no|1|0</td>
    <td>是否使用剧院模式显示窗口。默认为 no。</td>
    </tr>
    <tr>
    <td>directories=yes|no|1|0</td>
    <td>是否添加目录按钮。默认为 yes。</td>
    </tr>
    <tr>
    <td>fullscreen=yes|no|1|0</td>
    <td>是否使用全屏模式显示浏览器。默认是 no。处于全屏模式的窗口必须同时处于剧院模式。</td>
    </tr>
    <tr>
    <td>height=pixels</td>
    <td>窗口文档显示区的高度。以像素计。</td>
    </tr>
    <tr>
    <td>left=pixels</td>
    <td>窗口的 x 坐标。以像素计。</td>
    </tr>
    <tr>
    <td>location=yes|no|1|0</td>
    <td>是否显示地址字段。默认是 yes。</td>
    </tr>
    <tr>
    <td>menubar=yes|no|1|0</td>
    <td>是否显示菜单栏。默认是 yes。</td>
    </tr>
    <tr>
    <td>resizable=yes|no|1|0</td>
    <td>窗口是否可调节尺寸。默认是 yes。</td>
    </tr>
    <tr>
    <td>scrollbars=yes|no|1|0</td>
    <td>是否显示滚动条。默认是 yes。</td>
    </tr>
    <tr>
    <td>status=yes|no|1|0</td>
    <td>是否添加状态栏。默认是 yes。</td>
    </tr>
    <tr>
    <td>titlebar=yes|no|1|0</td>
    <td>是否显示标题栏。默认是 yes。</td>
    </tr>
    <tr>
    <td>toolbar=yes|no|1|0</td>
    <td>是否显示浏览器的工具栏。默认是 yes。</td>
    </tr>
    <tr>
    <td>top=pixels</td>
    <td>窗口的 y 坐标。</td>
    </tr>
    <tr>
    <td>width=pixels</td>
    <td>窗口的文档显示区的宽度。以像素计。</td>
    </tr>
</table>
</div>



		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id14').value );">測試14</button>
		<br>
		<textarea id="id14" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	document.writeln("屏幕的高度 (除Windows不含命令列)：screen.availHeight=" + screen.availHeight + "<br>");
	document.writeln("屏幕的寬度 (除Windows不含命令列)：screen.availWidth=" + screen.availWidth + "<br>");
	document.writeln("返回顯示器屏幕的寬度：screen.width=" + screen.width + "<br>");
	document.writeln("返回顯示屏幕的高度：screen.height=" + screen.height + "<br>");
	document.writeln("設置或返回調色板的比特深度：screen.bufferDepth=" + screen.bufferDepth + "<br>");
	document.writeln("返回目標設備或緩衝器上的調色板的比特深度：screen.colorDepth=" + screen.colorDepth + "<br>");
	document.writeln("返回顯示屏幕的每英吋水平點數：screen.deviceXDPI=" + screen.deviceXDPI + "<br>");
	document.writeln("返回顯示屏幕的每英吋垂直點數：screen.deviceYDPI=" + screen.deviceYDPI + "<br>");
	document.writeln("返回顯示屏幕每英吋的水平方向的常規點數：screen.logicalXDPI=" + screen.logicalXDPI + "<br>");
	document.writeln("返回顯示屏幕每英吋的垂直方向的常規點數：screen.logicalYDPI=" + screen.logicalYDPI + "<br>");
	document.writeln("返回顯示屏幕的顏色分辨率（比特每像素）：screen.pixelDepth=" + screen.pixelDepth + "<br>");
	document.writeln("設置或返回屏幕的刷新率：screen.updateInterval=" + screen.updateInterval + "<br>");
	document.writeln("返回用戶是否在顯示控制面板中啟用了字體平滑：screen.fontSmoothingEnabled=" + screen.fontSmoothingEnabled + "<br>");

	document.write("Screen resolution: ")
	document.write(screen.width + "*" + screen.height)
	document.write("<br />")
	document.write("Available view area: ")
	document.write(screen.availWidth + "*" + screen.availHeight)
	document.write("<br />")
	document.write("Color depth: ")
	document.write(screen.colorDepth)
	document.write("<br />")
	document.write("Buffer depth: ")
	document.write(screen.bufferDepth)
	document.write("<br />")
	document.write("DeviceXDPI: ")
	document.write(screen.deviceXDPI)
	document.write("<br />")
	document.write("DeviceYDPI: ")
	document.write(screen.deviceYDPI)
	document.write("<br />")
	document.write("LogicalXDPI: ")
	document.write(screen.logicalXDPI)
	document.write("<br />")
	document.write("LogicalYDPI: ")
	document.write(screen.logicalYDPI)
	document.write("<br />")
	document.write("FontSmoothingEnabled: ")
	document.write(screen.fontSmoothingEnabled)
	document.write("<br />")
	document.write("PixelDepth: ")
	document.write(screen.pixelDepth)
	document.write("<br />")
	document.write("UpdateInterval: ")
	document.write(screen.updateInterval)
	document.write("<br />")
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id15').value );">測試15</button>
		<br>
		<textarea id="id15" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	document.writeln("設置或返回主機名和當前URL:端口號：location.host	=" + location.host + "<br>");
	document.writeln("設置或返回當前 URL 的主機名：location.hostname	=" + location.hostname + "<br>");
	document.writeln("設置或返回完整的 URL：location.href	=" + location.href + "<br>");
	document.writeln("設置或返回當前 URL 的路徑部分：location.pathname	=" + location.pathname + "<br>");
	document.writeln("設置或返回當前 URL 的端口號：location.port	=" + location.port + "<br>");
	document.writeln("設置或返回當前 URL 的協議：location.protocol	=" + location.protocol + "<br>");
	document.writeln("設置或返回從問號 (?) 開始的 URL（查詢部分）：location.search	=" + location.search + "<br>");
</script>
<br>
		<input type="button" value="window.location.assign(url)等於location = url等於location.href = url"
				onclick="location.assign('http://www.kimo.com');" /><br>
	<input type="button" value="location.reload(true)[暫存=false]等於history.go(0)" onclick="location.reload(true);" /><br>
	<input type="button" value="location.replace('http://www.kimo.com')，和href差在history，但還是可以上一頁，所以我分不出差在那"
				onclick="location.replace('http://www.kimo.com');" /><br>
		</textarea>
		<br>
		<input type="button" value="印出錨點" onclick="alert(location.hash);" />
		<br>
		<input type="button" value="跳到開頭錨點" onclick="location.hash='div0';" />
		<br> <br>

		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id16').value );">測試16</button>
		<br>
		<textarea id="id16" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	document.write("目前的網扯記錄長度：history.length=" + history.length + "<br>");
	document.write("上一頁：history.back()<br>");
	document.write("上上一頁：history.go(-2)<br>");
	document.write("下一頁=history.forward() or history.go(1)<br>");
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id17').value );">測試17</button>
		<br>
		<textarea id="id17" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	document.writeln("返回瀏覽器的代碼名：navigator.appCodeName	=" + navigator.appCodeNam + "<br>");
	document.writeln("返回瀏覽器的次級版本：navigator.appMinorVersion	=" + navigator.appMinorVersion + "<br>");
	document.writeln("返回瀏覽器的名稱：navigator.appName	=" + navigator.appName + "<br>");
	document.writeln("返回瀏覽器的平台和版本信息：navigator.appVersion	=" + navigator.appVersion + "<br>");
	document.writeln("返回當前瀏覽器的語言：navigator.browserLanguage	=" + navigator.browserLanguage + "<br>");
	document.writeln("返回是否啟用 cookie：navigator.cookieEnabled	=" + navigator.cookieEnabled + "<br>");
	document.writeln("返回瀏覽器系統的 CPU 等級：navigator.cpuClass	=" + navigator.cpuClass + "<br>");
	document.writeln("返回指明系統是否處於脫機模式：navigator.onLine	=" + navigator.onLine + "<br>");
	document.writeln("返回運行瀏覽器的操作系統平台：navigator.platform	=" + navigator.platform + "<br>");
	document.writeln("返回 OS 使用的默認語言：navigator.systemLanguage	=" + navigator.systemLanguage + "<br>");
	document.writeln("返回由客戶機發送服務器的 user-agent 頭部的值：navigator.userAgent	=" + navigator.userAgent + "<br>");
	document.writeln("返回 OS 的自然語言設置：navigator.userLanguage	=" + navigator.userLanguage + "<br>");
	document.writeln("返回當前瀏覽器是否已啟用 Java ：navigator.javaEnabled()	=" + navigator.javaEnabled() + "<br>");
	document.writeln("返回當前瀏覽器是否已啟用 data tainting ：navigator.taintEnabled()	=" + navigator.taintEnabled() + "<br>");
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id18').value );">測試18</button>
		<br>
		<textarea id="id18" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	document.writeln("cookies的生命如果沒設定expires，關掉ie後就死了<br>")
	document.writeln("cookies長度：document.cookie.length=" + document.cookie.length + "<br>")
	document.writeln("設cookies：document.cookie= ('ckName=' + escape('ab//cc'))  <br>");
	document.cookie = ('ckName=' + escape('ab//cc'));
	document.writeln("cookies長度：document.cookie.length=" + document.cookie.length + "<br>")
	document.writeln("讀cookies：getCookie('ckName')= " + getCookie('ckName') + " <br>");
	document.writeln("設定有到期日的cookie<br>")
	x = getCookie('ckName2');
	document.writeln("讀cookies：getCookie('ckName2')=" + x + " <br>");
	var d = new Date();
	d.setMinutes(d.getMinutes() + 2);
	document.writeln("設定到期日2" + d.toGMTString() + "<br>")
	document
			.writeln("設cookies：document.cookie= ('ckName2=' + escape('cccc//ddd')+';expires=' + d.toGMTString())  <br>");
	document.cookie = ('ckName2=' + escape('cccc//ddd') + ';expires=' + d.toGMTString());
	function getCookie(c_name) {
		if (document.cookie.length > 0) {
			c_start = document.cookie.indexOf(c_name + "=")
			if (c_start != -1) {
				c_start = c_start + c_name.length + 1
				c_end = document.cookie.indexOf(";", c_start)
				if (c_end == -1) c_end = document.cookie.length
				return unescape(document.cookie.substring(c_start, c_end))
			}
		}
		return ""
	}
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id19').value );">測試195</button>
		<br>
		<textarea id="id19" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id20').value );">測試20</button>
		<br>
		<textarea id="id20" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id21').value );">測試21</button>
		<br>
		<textarea id="id21" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	
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

