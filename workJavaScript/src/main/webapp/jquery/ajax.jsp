<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>template</title>
</head>
<body>

	<div style="position: fixed; bottom: 10px; right: 10px; width: 50px; border: 3px solid #73AD21;">
		<a href="#div0">回開頭</a>
	</div>
	<pre>
$(selector).load(url,data,callback)	把遠程數據加載到被選的元素中
$.ajax(options)	把遠程數據加載到 XMLHttpRequest 對象中
$.get(url,data,callback,type)	使用 HTTP GET 來加載遠程數據
$.post(url,data,callback,type)	使用 HTTP POST 來加載遠程數據
$.getJSON(url,data,callback)	使用 HTTP GET 來加載遠程 JSON 數據
$.getScript(url,callback)	加載並執行遠程的 JavaScript 文件

(url) 被加載的數據的 URL（地址）
(data) 發送到服務器的數據的鍵/值對象
(callback) 當數據被加載時，所執行的函數
(type) 被返回的數據的類型 (html,xml,json,jasonp,script,text)
(options) 完整 AJAX 請求的所有鍵/值對選項
</pre>

	<div id="div0" align="center">
		<p>
			<a href="#id1">id1</a>
		</p>
		<p>
			<a href="#id2">id2</a>
		</p>

		<p>
			<a href="#id3">id3</a>
		</p>

		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id1').value );">測試1</button>
		<br>
		<textarea id="id1" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
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
	
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id3').value );">測試3</button>
		<br>
		<textarea id="id3" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
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

