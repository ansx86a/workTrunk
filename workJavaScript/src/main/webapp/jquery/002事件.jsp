<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>事件</title>
</head>
<body>

	<div style="position: fixed; bottom: 10px; right: 10px; width: 50px; border: 3px solid #73AD21;">
		<a href="#div0">回開頭</a>
	</div>
	<pre>
e.preventDefault();            //阻止預設要執行的行為
e.stopPropagation()         //阻止默認（冒泡）行為
return false：包含上述兩點，並停止回調函數執行並返回
//停止callback function執行並立即return
使用原生js時，若要阻止默認行為，最好還是用event.preventDefault（針對非IE）或event.returnValue=false（針對IE）來設定。
若使用的是jquery，return false 即會阻止默認行為，也會阻止事件的冒泡。在jquery中，一般使用return false.
</pre>

	<div id="div0" align="center">
		<p>
			<a href="#id1">on的應用(1.7後的jquery動態bind，也可以參考bind和delgate)<br>
			動態關掉事件用off，1.7之前用live()和die
			</a>

		</p>
		<p>
			<a href="#id2">嘗試用preventDefault停止事件</a>
		</p>

		<p>
			<a href="#id3">trigger</a>
		</p>
		<p>
			<a href="#id4">id4</a>
		</p>
		<p>
			<a href="#id5">id5</a>
		</p>
		<p>
			<a href="#id6">id6</a>
		</p>
		<p>
			<a href="#id7">id7</a>
		</p>
		<p>
			<a href="#id8">id8</a>
		</p>
		<p>
			<a href="#id9">id9</a>
		</p>

		<p>
			<a href="#id10">id10</a>
		</p>


		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id1').value );">測試1</button>
		<br>
		<textarea id="id1" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		<script type="text/javascript" src="jquery-3.0.0.min.js"></script>
		<p>.on( events [, selector ] [, data ], handler )</p>
		<span>span1，events [, selector ],handler</span>
		<span>span2，events,handler</span>
		<span>span3，events,data,handler</span>
		<pre>
on可以寫兩個事件，下面是滑鼠的進出去toggleClass		
$( "#cart" ).on( "mouseenter mouseleave", function( event ) {
  $( this ).toggleClass( "active" );
});		
</pre>		
<script>
	$(document).ready(function() {
		$("span").css({
			"border" : "2px solid red"
		});
		$("body").on("click", "span:contains('span1')", function() {
			alert("span1");
		});
		$("span:contains('span2')").on("click", function() {
			alert("span2");
		});
		$("span:contains('span3')").on("click", {
			"ttt" : "this is ttt"
		}, function(event) {
			alert(event.data + "-" + JSON.stringify(event.data));//Object可以直接用點屬性來存取
		});
	});
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id2').value );">測試2</button>
		<br>
		<textarea id="id2" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		<script type="text/javascript" src="jquery-3.0.0.min.js"></script>
<form id="form1" action="http://www.kimo.com.tw">
	<input type="submit" value="送出1" />
</form>
<form id="form2" action="http://www.kimo.com.tw">
	<input type="submit" value="送出2" />
</form>
<form id="form3" action="http://www.kimo.com.tw">
	<input type="submit" value="送出3，只有這個會轉頁" />
</form>
<script>
	$(document).ready(function() {
		$("#form1").on("submit", false);
		$("#form2").on("submit", function(event) {
			event.preventDefault();
		});
		$("#form3").on("submit", function(event) {
			event.stopPropagation();
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
		<span>span1，一般的click事件</span>
		<span>span2，tiggerSpan1的click事件</span>
		<span>span3，自定事件</span>		
		<span>span4，tigger自定事件</span>			
<script>
	$(document).ready(function() {
		$("span").css({
			"border" : "2px solid red"
		});
		$("body").on("click", "span:contains('span1')", function(event, Objdata) {
			alert("span1-" + Objdata);
		});
		$("span:contains('span2')").on("click", function() {
			$("span:contains('span1')").trigger("click", "objdataOOOO");
		});

		$("span:contains('span3')").on("myevent", function() {
			alert("this is my event");
		});
		$("span:contains('span4')").on("click", function() {
			$("span:contains('span3')").trigger("myevent");
		});

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
<script>
	$(document).ready(function() {

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
<script>
	$(document).ready(function() {

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
<script>
	$(document).ready(function() {

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
<script>
	$(document).ready(function() {

	});
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id8').value );">測試8</button>
		<br>
		<textarea id="id8" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		<script type="text/javascript" src="jquery-3.0.0.min.js"></script>			
<script>
	$(document).ready(function() {

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
<script>
	$(document).ready(function() {

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
<script>
	$(document).ready(function() {

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

