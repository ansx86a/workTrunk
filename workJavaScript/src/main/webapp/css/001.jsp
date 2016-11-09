<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>css測試</title>
</head>
<body>


	<div style="position: fixed; bottom: 10px; right: 10px; width: 50px; border: 3px solid #73AD21;">
		<a href="#div0">回開頭</a>
	</div>
	<div id="div0" align="center">
		<p>菜鳥教程(抄w3c)：http://www.runoob.com/</p>
		<p>CSS 語法 http://www.1keydata.com/css-tutorial/tw/syntax.php</p>
		<p>
			<a href="#id1">背景測試</a>
		</p>
		<p>
			<a href="#id2">本文</a>
		</p>

		<p>
			<a href="#id3">id3</a>
		</p>

		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id1').value );">測試1</button>
		<br>
		<textarea id="id1" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<link rel="stylesheet" type="text/css" href="mycss.css">
			<p class="灰色背景">灰色背景的測試</p>
			<p class="圖片背景">圖片背景的測試</p>
			<p class="圖片背景x">圖片背景x的測試</p>
			<p class="圖片背景y">圖片背景y的測試</p>
			<p class="圖片背景不repeat">圖片背景不repeat的測試</p>
			<p class="圖片背景放右上角">圖片背景不repeat的測試</p>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id2').value );">測試2</button>
		<br>
		<textarea id="id2" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<link rel="stylesheet" type="text/css" href="mycss.css">
			 <div >
			 		<p class="開頭縮排"  style="width:100px">
						1234567890123456789什麼鬼東西啊什麼鬼東西啊
					</p>
			 </div>

			
			
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



</body>
</html>