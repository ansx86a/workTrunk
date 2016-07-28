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
			<a href="#id1">get的用法</a>
		</p>
		<p>
			<a href="#id2">id2</a>
		</p>

		<p>
			<a href="#id3">id3</a>
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
		<p>
		jQuery.get( url(Sting) [, data(PlainObject or String) ] <br>
		[, success Function( PlainObject data, String textStatus, jqXHR jqXHR )] <br>
		[, dataType（xml, json, script, text，html ] )<br>
		<button id="getBtn">get基本，不能跨網域</button>
		<button id="getBtn2">get基本2，有參數，不能跨網域</button>
		<button id="getBtn3">get基本3，設回傳type，不能跨網域</button>
		<button id="getBtn4">get複雜一點的，不能跨網域</button>
		</p>
<pre>等同ajax的同法如下
$.ajax({
  url: url,
  data: data,
  success: success,
  dataType:dataType
});		
post不再重覆，和get九成像
$.ajax({
  type: "POST",
  url: url,
  data: data,
  success: success,
  dataType: dataType
});
</pre>
<script>
	$(document).ready(
			function() {
				$("#getBtn").on("click", function() {
					$.get("${pageContext.request.contextPath}/jquery001.mvc", function(data) {
						alert(JSON.stringify(data));
					});
				});
				$("#getBtn2").on("click", function() {
					//$.get("${pageContext.request.contextPath}/jquery001.mvc",{"a":"b","c":"dddd"}, function(data) {
					$.get("${pageContext.request.contextPath}/jquery001.mvc", "a=bc&c=ddaa", function(data) {//上面用json寫法也ok
						alert(JSON.stringify(data));
					});
				});
				$("#getBtn3").on("click", function() {
					$.get("${pageContext.request.contextPath}/jquery001.mvc", function(data) {
						alert(data);
					}, "text");
				});
				$("#getBtn4").on(
						"click",
						function() {
							var xhr = $.get("${pageContext.request.contextPath}/jquery001.mvc", "a=bc&c=ddaa",
									function(data, textStatus, jqXHR) {
										alert("ok:" + data);
										alert("status:" + textStatus);
										alert("" + jqXHR.readyState + "\n" + jqXHR.responseText + "\n" + jqXHR.status
												+ "\n" + jqXHR.statusText);
									}, "json");
							//這裡可以修改網扯成錯的，就會彈出fail出來，舊版的是用jqXHR.success(), jqXHR.error(), 和 jqXHR.complete()
							xhr.done(function() {
								alert("done")
							});
							xhr.fail(function() {
								alert("fail")
							});
							xhr.always(function() {
								alert("always")
							});
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
<script>
	
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id3').value );">測試3</button>
		<br>
		<textarea id="id3" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		<script type="text/javascript" src="jquery-3.0.0.min.js"></script>
<script>
	
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

