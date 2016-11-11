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
		<p>scss 語法 http://www.w3cplus.com/sassguide/syntax.html</p>
		<p>
			<a href="#id1">背景測試</a>
		</p>
		<p>
			<a href="#id2">本文</a>
		</p>

		<p>
			<a href="#id3">border</a>
		</p>
		<p>
			<a href="#id4">內外距</a>
		</p>
		<p>
			<a href="#id5">寬度和高度</a>
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
		<p>
			<a href="#id11">id11</a>
		</p>
		<p>
			<a href="#id12">id12</a>
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
			 <div>
			 		<p class="紅色本文 置中本文">紅色本文 置中本文</p>
					<p class="藍色本文 左靠本文">藍色本文 左靠本文</p>
					<p class="橘色本文 右靠本文">橘色本文 右靠本文</p>	
					<p class="綠色本文 右靠本文2">綠色本文 右靠本文2</p>					
					<p>
					<span class="陰影本文">陰影本文</span>
					<span class="上底線本文">上底線本文</span>
					<span class="刪除線本文">刪除線本文</span>
					<span class="底線本文">底線本文</span>
					<a class="無底線本文" href="http://www.kimo.com.tw">利用無底線本文刪除了連結的底線</a>
					</p>
					<p>
					
					<span class="轉大寫">轉大寫 this is a pen</span>
					<span class="轉小寫">轉小寫 THIS IS A PEN</span>
					<span class="單字首字轉大寫">單字首字轉大寫 this is a pen</span>
					</p>
					<p class="反向本文">反向本文 this is a pen</p>
							 		
			 		<p class="開頭縮排" style="width: 100px">
						1234567890123456789什麼鬼東西啊什麼鬼東西啊
					</p>
		 			<p class="不換行的本文" style="width: 100px">
						1234567890123456789什麼鬼東西啊什麼鬼東西啊
					</p>					
					<p>
					<span class="增加字母字距">增加字母字距 this is a pen</span>
					<span class="減少字母字距">減少字母字距 this is a pen</span>		
					<span class="增加單字字距">增加單字字距 this is a pen</span>
					<span class="減少單字字距">減少單字字距 this is a pen</span>										
					</p>
					<p class="增加行高">增加行高<br>增加行高</p>
					<p class="減小行高">減小行高<br>減小行高</p>		
					<p>
					<img class="頂端對齊本文 圓角邊框" src="g.png" style="height: 40px"></img>
					頂端對齊本文-目前只測span fail img ok-底部對齊本文
					<img class="底部對齊本文 圓角邊框" src="g.png" style="height: 40px"></img>
					</p>			
			 </div>

			
			
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id3').value );">測試3</button>
		<br>
		<textarea id="id3" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<link rel="stylesheet" type="text/css" href="mycss.css">
			<p class="點點邊框">點點邊框</p>
			<p class="虛線邊框">虛線邊框</p>
			<p class="單線邊框">單線邊框</p>
			<p class="雙線邊框">雙線邊框</p>
			<p class="凹線邊框">凹線邊框</p>
			<p class="嵌入邊框">嵌入邊框</p>
			<p class="浮出邊框">浮出邊框</p>
			<p class="沒有邊框">沒有邊框</p>
			<p class="隱藏邊框">隱藏邊框</p>
			<p class="複和邊框">複和邊框</p>
			<p class="複和邊框2">複和邊框2</p>
			<p class="不同邊粗顏色的邊框">不同邊粗顏色的邊框</p>
			<p class="圓角邊框">圓角邊框</p>
			
			<p class="點點外圍線">點點外圍線</p>
			<p class="虛線外圍線">虛線外圍線</p>	
			<p class="單線外圍線">單線外圍線</p>			
			<p class="雙線外圍線">雙線外圍線</p>
			<p class="凹線外圍線">凹線外圍線</p>
			<p class="凸線外圍線">凸線外圍線</p>
			<p class="嵌入外圍線">嵌入外圍線</p>
			<p class="浮出外圍線">浮出外圍線</p>
			
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id4').value );">測試4</button>
		<br>
		<textarea id="id4" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<link rel="stylesheet" type="text/css" href="mycss.css">
			<div style="width: 300px" class=" 單線邊框 用外距置中"> 用外距置中</div>
			<div style="width: 300px" class=" 單線邊框 四邊不同外距">四邊不同外距
				<div class="單線邊框">沒有繼承外距</div>
			</div>
			<div style="width: 300px" class=" 單線邊框 四邊不同外距2">四邊不同外距2
				<div class="單線邊框 繼承外距">繼承外距</div>
			</div>
			<div style="width: 300px" class=" 單線邊框 四邊不同內距">四邊不同內距
				<div class="單線邊框">沒有繼承內距</div>
			</div>
			<div style="width: 300px" class=" 單線邊框 四邊不同內距2">四邊不同內距2
				<div class="單線邊框 繼承內距">繼承內距</div>
			</div>
			
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id5').value );">測試5</button>
		<br>
		<textarea id="id5" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<link rel="stylesheet" type="text/css" href="mycss.css">
			<p class="一半寬度 淺藍色背景">一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十</p>
			<p class="最大寬度500像素 巧克力色背景">一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十</p>
			<p class="自動調整寬度 印第安紅色背景">一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十</p>
					
			
			
			
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id6').value );">測試6</button>
		<br>
		<textarea id="id6" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id7').value );">測試7</button>
		<br>
		<textarea id="id7" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id8').value );">測試8</button>
		<br>
		<textarea id="id8" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id9').value );">測試9</button>
		<br>
		<textarea id="id9" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id10').value );">測試10</button>
		<br>
		<textarea id="id10" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id11').value );">測試11</button>
		<br>
		<textarea id="id11" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id12').value );">測試12</button>
		<br>
		<textarea id="id12" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
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