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
		<a href="#id1">測試用document寫出文字，用javascript替換文字和style</a>
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
	document.write(" Number toString ttt=255，轉16進式測試<br>");
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
	document.write("substr()在ECMAscript 沒標準化，最好不要用，而substring可用但不接受負數，slice看來最強<br>");
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
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id9').value );">測試9</button>
		<br>
		<textarea id="id9" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	document.write("今天的日期：new Date()=" + new Date() + "<br>");
	document.write("取得日(1-31)：new Date().getDate()=" + new Date().getDate() + "<br>");
</script>
		</textarea>
		<br>

		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id10').value );">測試10</button>
		<br>
		<textarea id="id10" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	
</script>
		</textarea>
		<br>

		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id11').value );">測試11</button>
		<br>
		<textarea id="id11" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id12').value );">測試12</button>
		<br>
		<textarea id="id12" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id13').value );">測試13</button>
		<br>
		<textarea id="id13" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id14').value );">測試14</button>
		<br>
		<textarea id="id14" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id15').value );">測試15</button>
		<br>
		<textarea id="id15" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
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
			var w = window.open("", "", "width=600,height=500,left=" + x + ",top=" + y);
			w.document.open();
			w.document.write(txt);
			w.document.close();
		}
	}
</script>
</html>

