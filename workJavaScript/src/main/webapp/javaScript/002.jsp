<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ECMAScript</title>
</head>
<body>

	<div style="position: fixed; bottom: 10px; right: 10px; width: 50px; border: 3px solid #73AD21;">
		<a href="#div0">回開頭</a>
	</div>

	<div id="div0" align="center">
		<p>ECMAScript http://www.w3school.com.cn/js/pro_js_history.asp</p>
		<p>ECMAScript 有 5 種原始類型（primitive type），即 Undefined、Null、Boolean、Number 和 String</p>
		<p></p>
		<p>
			<a href="#id1">ECMAScript 關鍵字的完整列表：</a>
		</p>
		<p>
			<a href="#id2">typeof</a>
		</p>

		<p>
			<a href="#id3">物件</a>
		</p>

		<p>
			<a href="#id4">運算</a>
		</p>
		<p>
			<a href="#id5">call、apply</a>
		</p>
		<p>關於pototype的繼承方式，看這裡http://www.w3school.com.cn/js/pro_js_inheritance_implementing.asp</p>


		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id1').value );">測試1</button>
		<br>
		<textarea id="id1" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<pre>
break
case
catch
continue
default
delete
do
else
finally
for
function
if
in
instanceof
new
return
switch
this
throw
try
typeof
var
void
while
with			
			</pre>
			
<script>
	
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id2').value );">測試2</button>
		<br>
		<textarea id="id2" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	document.writeln("typeof 'sss' ,typeof('sss') = " + typeof 'sss' + "," + typeof ('sss') + "<br>");
	document.writeln("typeof 123 ,typeof(123) = " + typeof 123 + "," + typeof (123) + "<br>");
	document.writeln("typeof true ,typeof(true) = " + typeof true + "," + typeof (true) + "<br>");
	document.writeln("typeof null ,typeof(null) = " + typeof null + "," + typeof (null) + "<br>");
	document.writeln("typeof [] ,typeof([]) = " + typeof [] + "," + typeof ([]) + "<br>");
	document.writeln("typeof undefined  ,typeof(undefined ) = " + typeof undefined + "," + typeof (undefined) + "<br>");
	document.write("型別測試<br>");
	document.write("[111].constructor,'a'.constructor:" + [ 111 ].constructor + "," + 'a'.constructor + "<br>");
	document.write("型別測試2<br>");
	document.write("Array,String:" + Array + "," + String + "<br>");
	document.writeln("'hello world' instanceof String=" + ('hello world' instanceof String) + "<br>");
	var oStringObject = new String("hello world");
	document.writeln('var oStringObject = new String("hello world")<br>');
	document.writeln("oStringObject instanceof String=" + (oStringObject instanceof String) + "<br>");
	document.writeln("[] instanceof Object=" + ([] instanceof Object) + "<br>");
	document.writeln("[] instanceof Array=" + ([] instanceof Array) + "<br>");
	document.writeln("[] instanceof Array=" + ([] instanceof String) + "<br>");
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id3').value );">測試3</button>
		<br>
		<textarea id="id3" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	document.writeln("new Boolean(false) && true = " + (new Boolean(false) && true) + "</br>");
	document.writeln("new Boolean(false).valueOf() && true = " + (new Boolean(false).valueOf() && true) + "</br>");
	var a = new Object();
	a.name = 3;
	document.writeln("原型pototype加入:a.name=3->a.name=" + a.name + "<br>")
	delete a.name;
	document.writeln("原型pototype刪除:delete a.name->a.name=" + a.name + "<br>")
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id4').value );">測試4</button>
		<br>
		<textarea id="id4" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	var a = -"123";
	document.writeln("用+-號轉型(一元運算)：var a=+'123'->a,typeof a=" + a + "," + typeof a + "<br>");
	document.writeln("Not運算：~a =" + ~a + "<br>");
	document.writeln("Xor運算：7^11 =" + (7 ^ 11) + "<br>");
	document.writeln("左移：1<<3 =" + (1 << 3) + "<br>");
	document.writeln("右移：1>>3 =" + (1 >> 3) + "<br>");
	document.writeln("右移：-1>>3 =" + (-1 >> 3) + "<br>");
	document.writeln("(-1).toString(2) =" + (-1).toString(2) + "<br>");
	document.writeln("無符號右移：-1>>>3 =" + (-1 >>> 3) + "<br>");
	document.writeln("(-1>>>3).toString(2) =" + (-1 >>> 3).toString(2) + "<br>");
</script>


<table class="dataintable">
<tbody>
					<tr>
<th>表示式</th>
<th>值</th>
</tr>

<tr>
<td>null == undefined</td>
<td>true</td>
</tr>

<tr>
<td>"NaN" == NaN</td>
<td>false</td>
</tr>

<tr>
<td>5 == NaN</td>
<td>false</td>
</tr>

<tr>
<td>NaN == NaN</td>
<td>false</td>
</tr>

<tr>
<td>NaN != NaN</td>
<td>true</td>
</tr>

<tr>
<td>false == 0</td>
<td>true</td>
</tr>

<tr>
<td>true == 1</td>
<td>true</td>
</tr>

<tr>
<td>true == 2</td>
<td>false</td>
</tr>

<tr>
<td>undefined == 0</td>
<td>false</td>
</tr>

<tr>
<td>null == 0</td>
<td>false</td>
</tr>

<tr>
<td>"5" == 5</td>
<td>true</td>
</tr>
</tbody>
			</table>		
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id5').value );">測試5</button>
		<br>
		<textarea id="id5" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	function sayColor(sPrefix, sSuffix) {
		document.writeln("sPrefix + this.color + sSuffix=" + sPrefix + this.color + sSuffix + "<br>");
	}

	var obj = new Object();
	obj.color = "blue";
	document.writeln("使用call把第一個參數當this object (obj.color='blue'))" + "<br>");
	document.writeln("sayColor.call(obj, '開頭', '結尾');" + "<br>");
	sayColor.call(obj, '開頭', '結尾');
	document.writeln("sayColor.apply(obj, ['開頭apply', '結尾apply']);" + "<br>");
	sayColor.apply(obj, [ '開頭apply', '結尾apply' ]);
	document.writeln("同理，call可以用在繼承，ex:ClassB(sColor) call super ClassA -> ClassA.call(this, sColor);<br>");
	document.writeln("同理，apply可以用在繼承，ex:ClassB(sColor) call super ClassA -> ClassA.call(this, [sColor]);<br>");
	document.writeln("call和apply區別大至上就是call傳多個apply傳陣列的區別吧<br>");
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id6').value );">測試6</button>
		<br>
		<textarea id="id6" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	
</script>
		</textarea>
		<br>

		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id7').value );">測試7</button>
		<br>
		<textarea id="id7" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id8').value );">測試8</button>
		<br>
		<textarea id="id8" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id9').value );">測試9</button>
		<br>
		<textarea id="id9" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	
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

