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
			<pre>float要多花點時間搞，參考http://zh-tw.learnlayout.com/float.html
				(-webkit for Chrome, Safari; -moz for Firefox, -o for Opera, -ms for Internet Explorer)
				flexbox參考下面
				http://www.oxxostudio.tw/articles/201501/css-flexbox.html
				http://sweeteason.pixnet.net/blog/post/42781628-css-flexbox-layout-%E5%AD%B8%E7%BF%92%E5%BF%83%E5%BE%97
				media query參考下面的
				http://muki.tw/tech/css-media-queries-introduce-basic/
			</pre>
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
				<a href="#id6">link</a>
			</p>
			<p>
				<a href="#id7">list,dropdown,tooltip</a>
			</p>
			<p>
				<a href="#id8">table表格</a>
			</p>
			<p>
				<a href="#id9">顯示、layout</a>
			</p>
			<p>
				<a href="#id10">滑鼠指標種類，切圖</a>
			</p>
			<p>
				<a href="#id11">Pseudo (filter凝態)</a>
			</p>
			<p>
				<a href="#id12">透明度、transform</a>
			</p>
			<p>
				<a href="#id13">動畫(Transitions,animation)</a>
			</p>
			<p>
				<a href="#id14">image相關</a>
			</p>
			<p>
				<a href="#id15">Media Queries</a>
			</p>
			<p>
				<a href="#id16">RWD相關</a>
			</p>
			<p>
				<a href="#id17">id17</a>
			</p>
			<p>
				<a href="#id18">id18</a>
			</p>
			<p>
				<a href="#id19">id19</a>
			</p>
			<!-- ******************************************************************************************** -->
			<button type="button" onclick="javascriptWindow(document.getElementById('id1').value );">測試1</button>
			<br>
			<textarea id="id1" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<link rel="stylesheet" type="text/css" href="mycss.css">
			<p class="灰色背景">灰色背景的測試</p>
			<p class="橘色背景 背景的陰影">背景的陰影</p>
			
			<p class="圖片背景">圖片背景的測試</p>
			<p class="圖片背景x">圖片背景x的測試</p>
			<p class="圖片背景y">圖片背景y的測試</p>
			<p class="圖片背景不repeat">圖片背景不repeat的測試</p>
			<p class="圖片背景放右上角">圖片背景不repeat的測試</p>
			<p class="圖片背景多張">圖片背景多張的測試</p>
			<div>
				<span class="漸層紅到黃預設上到下" style="display: inline-block; height: 100px; width: 100px;">預設上到下</span>
				<span class="漸層紅到黃左到右" style="display: inline-block; height: 100px; width: 100px;">左到右</span>
				<span class="漸層紅到黃左上到右下" style="display: inline-block; height: 100px; width: 100px;">左上到右下</span>
				<span class="多重漸層左到右" style="display: inline-block; height: 100px; width: 200px;">多重漸層左到右</span>
				<span class="多段漸層" style="display: inline-block; height: 200px; width: 100px;">多段漸層，第1段到10%，第2段到20%，重覆5次</span>
				<span class="中心點圓形漸層" style="display: inline-block; height: 100px; width: 100px;">圓形漸層</span>
				<span class="中心點圓形漸層" style="display: inline-block; height: 100px; width: 100px;">圓形漸層</span>
				<span class="中心點圓形多段漸層" style="display: inline-block; height: 200px; width: 200px;">中心點圓形多段漸層</span>
			</div>
			</textarea>
			<br>
			<!-- ******************************************************************************************** -->
			<button type="button" onclick="javascriptWindow(document.getElementById('id2').value );">測試2</button>
			<br>
			<textarea id="id2" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<link rel="stylesheet" type="text/css" href="mycss.css">
			<div>
				<p class="紅色本文 置中本文 單線邊框">紅色本文 置中本文</p>
				<p class="藍色本文 左靠本文 單線邊框">藍色本文 左靠本文</p>
				<p class="橘色本文 右靠本文 單線邊框">橘色本文 右靠本文</p>
				<p class="綠色本文 右靠本文2 單線邊框">綠色本文 右靠本文2</p>
				<p>
					<span class="陰影本文 單線邊框">陰影本文</span>
					<span class="多重陰影本文 單線邊框">多重陰影本文(紅 藍)</span>
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
				
				<p class="開頭縮排 單線邊框" style="width: 100px">
					開頭縮排1234567890123456789什麼鬼東西啊什麼鬼東西啊
				</p>
				<p class="不換行的本文 單線邊框" style="width: 100px">
					不換行的本文1234567890123456789什麼鬼東西啊什麼鬼東西啊
				</p>
				<p class="單字強制換行 單線邊框" style="width: 100px">
					單字強制換行1234567890123456789什麼鬼東西啊什麼鬼東西啊
				</p>
				<p class="過長的文字轉點點點 單線邊框" style="width: 200px">
					過長的文字轉點點點1234567890123456789什麼鬼東西啊什麼鬼東西啊
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
				<p>
					<span class="正常字型">正常字型</span>
					<span class="斜體字型 大字型 粗體字">斜體字型</span>
					<span class="斜體字型2 中字型 粗體字">斜體字型2</span>
					<span class="大字型 粗體字 特殊轉大寫">Special eNglish 小寫轉大寫但比較小字</span>
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
			<p class="圖片邊框round">圖片邊框，圖片81*81，圖片設成30理應27，框線透明，round</p>
			<p class="圖片邊框stretch">圖片邊框，圖片81*81，圖片設成30理應27，框線透明，stretch</p>
			
			<p class="點點外圍線">點點外圍線</p>
			<p class="點點外圍線 外移外圍線">點點外圍線 外移外圍線</p>
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
			<div style="width: 300px" class=" 單線邊框 四邊不同內距">四邊不同內距，對比不計算內距width: 300px</div>
			<div style="width: 300px" class=" 單線邊框 ">單線邊框對比不計算內距width: 300px</div>
			<div style="width: 300px" class=" 單線邊框 四邊不同內距 長度包含內距">四邊不同內距，長度包含內距和邊框  box-sizing: border-box;</div>
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
			<link rel="stylesheet" type="text/css" href="mycss.css">
			<a class="連結點選前綠色 連結點選後藍色 連結快點選時水色 連結點選中紅色" href="http://www.kimo.com.tw">測試連結的顏色</a><br />
			<a class="連結點選前沒底線 連結點選後沒底線 連結快點選時有底線 連結點選中有底線" href="http://www.kimo.com.tw">測試連結的底線</a>
			<a class="連結按鈕" href="http://www.kimo.com.tw">一個長得像button的link</a>
			<br>
			<a class="選單連結" href="#">選單連結1</a>
			<a class="選單連結" href="#">選單連結2</a>
			<a class="選單連結" href="#">選單連結3</a>
			<a class="選單連結" href="#">選單連結4</a>
			<br><br>
			<a class="選單連結" style="float: left; border-right-style: solid;" href="#">選單連結1</a>
			<a class="選單連結" style="float: left; border-right-style: solid;" href="#">選單連結2</a>
			<a class="選單連結" style="float: left; border-right-style: solid;" href="#">選單連結3</a>
			<a class="選單連結" style="float: left; border-right-style: solid;" href="#">選單連結4</a>
			
			</textarea>
			<br>
			<!-- ******************************************************************************************** -->
			<button type="button" onclick="javascriptWindow(document.getElementById('id7').value );">測試7</button>
			<br>
			<textarea id="id7" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<link rel="stylesheet" type="text/css" href="mycss.css">
			<ul class="空心圓型編號 列表位置內縮">
				<li>空心圓型編號Coffee 列表位置內縮</li>
				<li>空心圓型編號Tea 列表位置內縮</li>
			</ul>
			<ul class="實心圓型編號 列表位置外擴">
				<li>實心圓型編號Coffee 列表位置外擴</li>
				<li>實心圓型編號Tea 列表位置外擴</li>
			</ul>
			<ul class="方型編號">
				<li>方型編號Coffee</li>
				<li>方型編號Tea</li>
			</ul>
			<ul class="圖片編號">
				<li>圖片編號Coffee</li>
				<li>圖片編號Tea</li>
			</ul>
			<ol class="羅馬數字編號 列表位置內縮">
				<li>羅馬數字編號Tea 列表位置內縮</li>
				<li>羅馬數字編號Coca Cola 列表位置內縮</li>
			</ol>
			<ol class="小寫英文編號 列表位置外擴">
				<li>小寫英文編號Coffee 列表位置外擴</li>
				<li>小寫英文編號Tea 列表位置外擴</li>
			</ol>
			<ol class="數字編號">
				<li>數字編號Coffee</li>
				<li>數字編號Tea</li>
			</ol>
			<ul class="左邊有紅線">
				<li>左邊有紅線Coffee</li>
				<li>左邊有紅線Tea</li>
			</ul>
			<ul class="手機清單樣式">
				<li>手機清單樣式Coffee</li>
				<li>手機清單樣式Tea</li>
				<li>手機清單樣式Coffee</li>
				<li>手機清單樣式Tea</li>
			</ul>
			<ul class="選單樣式">
				<li><a class="選單連結" style="float: left; border-right-style: solid;" href="#">選單連結1</a></li>
				<li><a class="選單連結" style="float: left; border-right-style: solid;" href="#">選單連結2</a></li>
				<li><a class="選單連結" style="float: left; border-right-style: solid;" href="#">選單連結3</a></li>
				<li><a class="選單連結" style="float: left; border-right-style: solid;" href="#">選單連結4</a></li>
			</ul>
			ccccccc<span class="dropdown主體 單線邊框 橘色邊框">
				只要滑鼠在這裡，就秀出dropdown清單列表
				<div class="dropdown清單內容 虛線邊框 暗海綠色邊框">
					<p>dropdown清單1</p>
					<p>dropdown清單2</p>
					<p>dropdown清單3</p>
				</div>
			</span>
			<div style="text-align: center;">
				<div class="tooltip主體">重點是內容對齊text-align:center;
					<br>chrome顯示用visibility先佔位才能置中(display會跑到字首)
					<br>ie會接在屁股，冏死了
					<span class="tooltip內容">提示內容</span>
				</div>
				<div class="tooltip主體">
					測試提示內容彈的地方
					<br>幹，用border做箭頭超醜超麻煩的，又有不同瀏覽器的問題，半放棄
					<span class="tooltip內容 tooltip內容上彈">上彈提示內容</span>
					<span class="tooltip內容 tooltip內容下彈">下彈提示內容</span>
					<span class="tooltip內容 tooltip內容左彈">左彈提示內容</span>
					<span class="tooltip內容 tooltip內容右彈">右彈提示內容</span>
				</div>
				
				<br>
				<br>
				<br>
				一堆空白行，沒什麼用處就只是為了排一下版而已
			</div>
			
			
			</textarea>
			<br>
			<!-- ******************************************************************************************** -->
			<button type="button" onclick="javascriptWindow(document.getElementById('id8').value );">測試8</button>
			<br>
			<textarea id="id8" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<link rel="stylesheet" type="text/css" href="mycss.css">
			<table class="普通的表格線框 標題放到下方">
				<caption>這個是table的標題，caption</caption>
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
				</tr>
				<tr>
					<td>普通的表格線框Peter靠右下</td>
					<td>普通的表格線框Griffin靠右下</td>
				</tr>
				<tr>
					<td></td>
					<td>空的欄位被hide，也可以設成show</td>
				</tr>
			</table>
			<br>
			<table class="單線的表格線框 單數列變色 跨在上方變色">
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
				</tr>
				<tr>
					<td>單線的表格線框Peter靠右下</td>
					<td>單線的表格線框Griffin靠右下</td>
				</tr>
				<tr>
					<td>單線的表格線框Lois</td>
					<td>單線的表格線框Griffin</td>
				</tr>
				<tr>
					<td>單線的表格線框Lois</td>
					<td>單線的表格線框Griffin</td>
				</tr>
				<tr>
					<td>單線的表格線框Lois</td>
					<td>單線的表格線框Griffin</td>
				</tr>
			</table>
			</textarea>
			<br>
			<!-- ******************************************************************************************** -->
			<button type="button" onclick="javascriptWindow(document.getElementById('id9').value );">測試9</button>
			<br>
			<textarea id="id9" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<link rel="stylesheet" type="text/css" href="mycss.css">
			<p style="z-index: 3; position: absolute; Top: 0px; color: white; font-size: 20px">→→→→→→→→→→→→</p>
			<p style="z-index: 1; position: absolute; Top: 0px; color: black; font-size: 20px">●●●●●●●●●●●●●●●Z-index比較大的會蓋過比較小的，此例白字就蓋過了黑字，用滑鼠選取可看出效果</p>
			<br><br>
			<p class="行內顯示 單線邊框 橘色邊框">p行內顯示</p>
			<p class="行內顯示 單線邊框 橘色邊框">p行內顯示</p>
			<span class="區塊顯示 單線邊框 橘色邊框">span區塊顯示</span>
			<span class="區塊顯示 單線邊框 橘色邊框">span區塊顯示</span>
			<div class="元素預設位置 單線邊框 淺藍色邊框" style="left: 500px;">position: static;由瀏覽器去排，定位偏移好像也沒用</div>
			<div class="元素位置加偏移並重新定位子容器 單線邊框 淺藍色邊框">position: relative;.元素位置加偏移並重新定位子容器</div>
			<div class="元素位置加偏移並重新定位子容器 單線邊框 淺藍色邊框" style="height: 300px;">position: relative;
				<div class="元素的絕對位置 單線邊框 暗海綠色邊框">position: absolute;元素的絕對位置，此例受父容器relative影嚮</div>
			</div>
			<div class="元素預設位置 單線邊框 淺藍色邊框">position: static;包紅字絕對的div
				<div class="元素的絕對位置 單線邊框 " style="color: red; border-color: red;">position: absolute;元素的絕對位置，此例不受父容器static影嚮</div>
			</div>
			<div class="單線邊框 暗海綠色邊框" style="width: 800px; height: 160px">
				<div class="顯示超出的部分 單線邊框 橘色邊框" style="width: 100px; height: 60px; position: absolute; left: 0px">測試overflow顯示超出的部分33333333333333333 看到鬼了看到鬼了看到鬼了看到鬼了看到鬼了看到鬼了</div>
				<div class="隱藏超出的部分 單線邊框 橘色邊框" style="width: 100px; height: 60px; position: absolute; left: 120px">測試overflow隱藏超出的部分33333333333333333 看到鬼了看到鬼了看到鬼了看到鬼了看到鬼了看到鬼了</div>
				<div class="超出的部分可捲動 單線邊框 橘色邊框" style="width: 100px; height: 160px; position: absolute; left: 240px">測試overflow超出的部分可捲動33333333333333333 看到鬼了</div>
				<div class="超出的部分自動判斷可捲動 單線邊框 橘色邊框" style="width: 100px; height: 160px; position: absolute; left: 360px">測試overflow超出的部分自動判斷可捲動33333333333333333 看到鬼了</div>
				<div class="超出的部分可水平捲動 單線邊框 橘色邊框" style="width: 100px; height: 60px; position: absolute; left: 480px">測試overflow超出的部分可水平捲動33333333333333333 看到鬼了看到鬼了看到鬼了看到鬼了看到鬼了看到鬼了</div>
				<div class="超出的部分可垂直捲動 單線邊框 橘色邊框" style="width: 100px; height: 60px; position: absolute; left: 600px">測試overflow超出的部分可垂直捲動33333333333333333 看到鬼了看到鬼了看到鬼了看到鬼了看到鬼了看到鬼了</div>
				<div class="絕對位置的元件剪裁(寫在style非scss) 單線邊框 印第安紅色背景"
				style="width: 100px; height: 160px; position: absolute; left: 720px; clip: rect(0px, 40px, 40px, 0px);">位置要絕對才能用？怪怪，rect (top, right, bottom, left)</div>
			</div>
			<br>
			<div class="單線邊框 暗海綠色邊框" style="width: 200px;">
				<div class="單線邊框  淺藍色邊框" style="width: 100px; height: 100px">測試一般沒有float的方式</div>
				<p>第1行</p>
				<p>第2行</p>
				<p>第3行</p>
				<p>第4行</p>
			</div>
			<div class="單線邊框 暗海綠色邊框" style="width: 200px;">
				<div class="單線邊框  淺藍色邊框 左邊的文遶圖" style="width: 100px; height: 100px">測試float=left</div>
				<p>第1行</p>
				<p>第2行</p>
				<p>第3行</p>
				<p>第4行</p>
			</div>
			<div class="單線邊框 暗海綠色邊框" style="width: 200px;">
				<div class="單線邊框  淺藍色邊框 左邊的文遶圖" style="width: 100px; height: 100px">測試float=left</div>
				<p>第1行</p>
				<p class="結束左邊的文遶圖">第2行+clear 結束左邊的文遶圖</p>
				<p>第3行</p>
				<p>第4行</p>
			</div>
			<div class="單線邊框 暗海綠色邊框" style="width: 200px;">
				<div class="單線邊框  淺藍色邊框 右邊的文遶圖" style="width: 100px; height: 100px">測試float=right</div>
				<p>第1行</p>
				<p>第2行，單字太長會跳aaaaaaaaaaaaaaaa</p>
				<p>第3行</p>
				<p>第4行</p>
			</div>
			<div class="單線邊框 暗海綠色邊框" style="width: 200px;">
				<div class="單線邊框  淺藍色邊框 右邊的文遶圖" style="width: 100px; height: 100px">測試float=right</div>
				<p>第1行</p>
				<p class="結束右邊的文遶圖">第2行+clear 結束右邊的文遶圖</p>
				<p>第3行</p>
				<p>第4行</p>
			</div>
			<div class="單線邊框 暗海綠色邊框" style="width: 200px;">
				<div class="單線邊框  淺藍色邊框 右邊的文遶圖" style="width: 100px; height: 100px">測試float=right</div>
				float的內容可能超出父容器
			</div>
			<div class="單線邊框 暗海綠色邊框 調整文遶圖的父容器大小" style="width: 200px;">
				<div class="單線邊框  淺藍色邊框 右邊的文遶圖" style="width: 100px; height: 100px">測試float=right</div>
				利用overflow調整父容器的大小
			</div>
			<div class="可調整大小 淺藍色邊框 單線邊框" style="width: 100px; height: 100px">可調整大小的div，不支援ie</div>
			<div class="flex容器1">
				<div class="fles元件1">direction: rtl;可由右到左排過來就不測了</div>
				<div class="fles元件1">-webkit-flex-direction: row-reverse;
				flex-direction: row-reverse;同上就不測了</div>
				<p>很容易的做到了垂直排版</p>
				<p>不用再用float之類的方式來達成排垂直列的排板</p>
				<div>test div</div>
			</div>
			<br>
			<div class="flex容器2">
				<div class="fles元件1">水平排列的排版</div>
				<div class="fles元件1">-webkit-flex-direction: column-reverse;
				flex-direction: column-reverse;可以由下到上，反過來</div>
			</div><br>
			<div class="flex容器1 flex水平排版後靠">
				<div class="fles元件1">flex水平排版後靠</div>
				<div class="fles元件1">justify-content: flex-end;</div>
			</div><br>
			<div class="flex容器1 flex水平排版置中">
				<div class="fles元件1">flex水平排版置中</div>
				<div class="fles元件1">justify-content: center;</div>
			</div><br>	
			<div class="flex容器1 flex水平排版均分空白部分">
				<div class="fles元件1">flex水平排版均分空白部分</div>
				<div class="fles元件1">justify-content: space-between;最左和最右不會分到</div>
			</div><br>				
			<div class="flex容器1 flex水平排版均分空白部分2">
				<div class="fles元件1">flex水平排版均分空白部分2</div>
				<div class="fles元件1">justify-content: space-around;最左和最右會各分到1/2</div>
			</div><br>				
			<div class="flex容器1 flex垂直排版填滿">
				<div class="fles元件1">flex垂直排版填滿，此例有設定height所以失效</div>
				<div class="fles元件1">align-items: stretch;</div>
			</div><br>					
			<div class="flex容器1 flex垂直排版往上">
				<div class="fles元件1">flex垂直排版往上</div>
				<div class="fles元件1">align-items: flex-start;</div>
			</div><br>	
			<div class="flex容器1 flex垂直排版往下">
				<div class="fles元件1">flex垂直排版往下</div>
				<div class="fles元件1">align-items: flex-end;</div>
			</div><br>			
			<div class="flex容器1 flex垂直排版置中">
				<div class="fles元件1">flex垂直排版置中</div>
				<div class="fles元件1">align-items: center;</div>
			</div><br>	
			flex相關的太複雜了，相容性又不高，要用再參考http://www.oxxostudio.tw/articles/201501/css-flexbox.html
													
			</textarea>
			<br>
			<!-- ******************************************************************************************** -->
			<button type="button" onclick="javascriptWindow(document.getElementById('id10').value );">測試10</button>
			<br>
			<textarea id="id10" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			這些並不是全部的圖示，要用時候還是要查一下w3c
			<span style="cursor: auto">auto</span><br>
			<span style="cursor: crosshair">crosshair</span><br>
			<span style="cursor: default">default</span><br>
			<span style="cursor: e-resize">e-resize</span><br>
			<span style="cursor: help">help</span><br>
			<span style="cursor: move">move</span><br>
			<span style="cursor: n-resize">n-resize</span><br>
			<span style="cursor: ne-resize">ne-resize</span><br>
			<span style="cursor: nw-resize">nw-resize</span><br>
			<span style="cursor: pointer">pointer</span><br>
			<span style="cursor: progress">progress</span><br>
			<span style="cursor: s-resize">s-resize</span><br>
			<span style="cursor: se-resize">se-resize</span><br>
			<span style="cursor: sw-resize">sw-resize</span><br>
			<span style="cursor: text">text</span><br>
			<span style="cursor: w-resize">w-resize</span><br>
			<span style="cursor: wait">wait</span><br>
			<span style="cursor: not-allowed">not-allowed</span><br>
			<div>
				<p>原圖<img src="2.gif" />
				</p>
				<p>切圖1 0 0：<img style="width: 40px; height: 40px; background: url(2.gif) 0 0;" />
				</p>
				<p>切圖2 10 10：<img style="width: 40px; height: 40px; background: url(2.gif) 10 10;" />
				</p>
				<p>切圖3 20 20：<img style="width: 40px; height: 40px; background: url(2.gif) 20 20;" />
				</p>
				<p>切圖4 -10 -10：<img style="width: 40px; height: 40px; background: url(2.gif) -10 -10;" />
				</p>
				<p>切圖5 -20 -20：<img style="width: 40px; height: 40px; background: url(2.gif) -20 -20;" />
				</p>
				<p>結論，可以正向切圖或反向切圖都可以，放在a元素的部分要用時再實作或參考w3c
					，原理大概是父元素放背景圖，a元素空值但把width和height調成和父元素一樣大
				</p>
			</div>
			
			</textarea>
			<br>
			<!-- ******************************************************************************************** -->
			<button type="button" onclick="javascriptWindow(document.getElementById('id11').value );">測試11</button>
			<br>
			<textarea id="id11" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<link rel="stylesheet" type="text/css" href="mycss.css">
			<div class="點選時變色">點選時變色</div>
			<div class="橫跨時變色">橫跨時變色</div>
			<input type="checkbox" class="選取後變色" /><span>選取後變色</span>
			<input type="checkbox" class="禁用後變色" disabled /><span>禁用後變色</span>
			<input type="checkbox" class=致能後變色 /><span>致能後變色</span>
			<input class="聚焦時變色" value="聚焦時變色" />
			<p class="沒有子元素變色"></p><span>p沒有子元素變色</span>
			<br>
			<span>ie不支援，input的type、min、max設好後，當數字在5-10之間會變色</span>
			<input class="數字區間變色" type="number" min="5" max="10" value="7">
			<br>
			<span>資料驗証錯誤變色，只有email有這個功能吧，我猜</span>
			<input class="資料驗証變色" type="email" value="請填入正確的email">
			<div class="單線邊框">
				<p class="反相選取變色">反相選取p，就p不變色，其它的都變色</p>
				<span class="反相選取變色">span1</span>,,,,,<span class="反相選取變色">span2</span>
			</div>
			<div class="單線邊框">
				第2個變色
				<span class="第2個變色">span1</span>
				<span class="第2個變色">span2</span>
				<span class="第2個變色">span3</span>
				<span class="第2個變色">span4</span>
				<span class="第2個變色">span5</span>
			</div>
			<div class="單線邊框">
				第偶數個變色
				<span class="第偶數個變色">span1</span>
				<span class="第偶數個變色">span2</span>
				<span class="第偶數個變色">span3</span>
				<span class="第偶數個變色">span4</span>
				<span class="第偶數個變色">span5</span>
			</div>
			<div class="單線邊框">
				第奇數個變色
				<span class="第奇數個變色">span1</span>
				<span class="第奇數個變色">span2</span>
				<span class="第奇數個變色">span3</span>
				<span class="第奇數個變色">span4</span>
				<span class="第奇數個變色">span5</span>
			</div>
			<div class="單線邊框">
				第3倍加1個變色
				<span class="第3倍加1個變色">span1</span>
				<span class="第3倍加1個變色">span2</span>
				<span class="第3倍加1個變色">span3</span>
				<span class="第3倍加1個變色">span4</span>
				<span class="第3倍加1個變色">span5</span>
			</div>
			<div class="單線邊框 父容器只有這一個這種元素">
				父容器只有這一個這種元素
				<span>span1</span>
				<b>bbbbbb</b>
			</div>
			<div class="單線邊框 父容器只有這一個這種元素">
				父容器只有這一個這種元素，失敗的對照組
				<span>span1</span>
				<b>bbbbbb</b>
				<span>span2</span>
			</div>
			<div>
				<input class="必填欄位變色" value="非必填欄位">
				<input class="必填欄位變色" value="必填欄位" required>
				<input class="唯讀變色" value="唯讀ie失效" readonly>
				<input class="唯讀變色" value="非唯讀ie失效">
			</div>
			<div>
				<a href="#錨點變色1">錨點1</a>	<a href="#錨點變色2">錨點2</a><a href="#錨點變色3">錨點3</a>
				<p id="錨點變色1" class="錨點變色">錨點變色1</p>
				<p id="錨點變色2" class="錨點變色">錨點變色2</p>
				<p id="錨點變色3">錨點變色3沒設class</p>
				<p>可以用這個原理做tab，但是因為只能有一個錨點，第2個會照成第1個失效</p>
			</div>
			<div>
				<p class="在後面加東西">我是ppp會被css3加東西，也可以加圖耶</p>
				<p class="在前面加東西">我是ppp會被css3加東西，也可以加圖耶</p>
				<p class="修改第一個字">我是ppp會被修改第一個字</p>
				<p class="修改第一個字 修改第一個行">我是ppp會被修改第一個字和第一行，第一個字優先<br>第二行行行</p>
				<p class="被選取的部分">我是ppp會被css3修改被選取的部分</p>
			</div>
			
			</textarea>
			<br>
			<!-- ******************************************************************************************** -->
			<button type="button" onclick="javascriptWindow(document.getElementById('id12').value );">測試12</button>
			<br>
			<textarea id="id12" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<link rel="stylesheet" type="text/css" href="mycss.css">
			<div class="橘色背景">橘色背景</div>
			<div class="透明度五十啪 橘色背景">透明度五十啪 橘色背景</div>
			<div style="background: rgba(76, 175, 80, 0.3)"> background: rgba(76, 175, 80, 0.3) /* Green background with 30% opacity */</div>
			<div class="位移轉換 單線邊框">位移轉換50px,10 px</div>
			<div class="角度轉換 單線邊框 淡粉紅色邊框">角度轉換-2度</div>
			<div class="角度轉換 單線邊框 改變軸心 淺藍色邊框">改變軸心 角度轉換-2度</div>
			<div class="縮放轉換 單線邊框" style="margin: 100px; width: 50px; height: 50px">縮放轉換(2,3)倍</div>
			<div class="水平斜轉轉換 單線邊框" style="width: 50px; height: 50px">水平斜轉轉換</div>
			<div class="垂直斜轉轉換 單線邊框" style="width: 50px; height: 50px">垂直斜轉轉換</div>
			<div class="斜轉轉換 單線邊框" style="width: 50px; height: 50px">斜轉轉換</div>
			<div class="綜合轉換 單線邊框" style="width: 150px; height: 150px">綜合轉換，只是把位移、角度、斜轉寫在一起而已</div>
			<p>以上是2d，以下是3d===============</p>
			<div class="單線邊框 淺藍色邊框">角度x軸心轉換，180度像水面映射的感覺</div>
			<div class="角度x軸心轉換 單線邊框 淺藍色邊框">角度x軸心轉換，180度像水面映射的感覺</div>
			<div class="單線邊框 淺藍色邊框">角度y軸心轉換，180度有點像左頁的書翻到右頁的感覺</div>
			<div class="角度y軸心轉換 單線邊框 淺藍色邊框">角度y軸心轉換，180度有點像左頁的書翻到右頁的感覺</div>
			<div class="單線邊框 淺藍色邊框">角度z軸心轉換，45度，感覺像是時鐘的時針旋轉的感覺</div>
			<div class="角度z軸心轉換 單線邊框 淺藍色邊框" style="width: 150px; height: 150px">角度z軸心轉換，45度，感覺像是時鐘的時針旋轉的感覺</div>
			<p>略過比較難懂不會用的方法</p>
			<p>transform-style:不懂，perspective:遠近透視法，近的會變大遠的會變小，backface-visibility：不懂</p>
			
			
			
			</textarea>
			<br>
			<!-- ******************************************************************************************** -->
			<button type="button" onclick="javascriptWindow(document.getElementById('id13').value );">測試13</button>
			<br>
			<textarea id="id13" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<link rel="stylesheet" type="text/css" href="mycss.css">
			<div class="動畫長度 淺藍色背景 單線邊框">hover動畫長度改變</div>
			<div class="動畫長度 淺藍色背景 單線邊框 長度轉換兩秒">hover動畫長度改變 長度轉換兩秒</div>
			<div class="動畫長度 淺藍色背景 單線邊框 長度轉換兩秒 轉換的廷遲">hover動畫長度改變 長度轉換兩秒 轉換的廷遲兩秒</div>
			<div class="動畫高度 淺藍色背景 單線邊框 高度轉換三秒">hover動畫高度改變 高度轉換三秒</div>
			<div class="動畫長度 動畫高度 淺藍色背景 單線邊框 長度轉換兩秒 高度轉換三秒 ">長度高度一起做，長度會失敗</div>
			<div class="動畫長度 動畫高度 淺藍色背景 單線邊框 同時轉換高度和長度">長度高度一起做，css寫一起會成功</div>
			<img src="ease.png" />
			<div class="動畫長度 淺藍色背景 單線邊框 長度轉換兩秒 線性轉換">hover動畫長度改變 linear</div>
			<div class="動畫長度 淺藍色背景 單線邊框 長度轉換兩秒 慢快慢的轉換">hover動畫長度改變 ease</div>
			<div class="動畫長度 淺藍色背景 單線邊框 長度轉換兩秒 起步較慢的轉換">hover動畫長度改變 ease-in</div>
			<div class="動畫長度 淺藍色背景 單線邊框 長度轉換兩秒 結束較慢的轉換 ">hover動畫長度改變 ease-out</div>
			<div class="動畫長度 淺藍色背景 單線邊框 長度轉換兩秒 起步和結束較慢的轉換">hover動畫長度改變 ease-in-out</div>
			
			<div class="動畫特效 淺藍色背景 單線邊框">hover動畫特效 transform</div>
			<div class="動畫特效 動畫特效轉換 淺藍色背景 單線邊框">hover動畫特效 動畫特效轉換</div>
			<hr>
			<div class="背景動畫效果元件 單線邊框">用animation做特效，不一定要綁hover，可直接有效果，動畫效果結束會變回原形</div>
			<div class="背景動畫效果元件 單線邊框 保留動畫效果">用animation做特效，動畫效果結束不會變回原形</div>
			<div class="背景動畫效果元件2 單線邊框">用animation做特效，這次有多段的變化</div>
			<div class="背景動畫效果元件3 單線邊框">用animation做特效，位置加顏色的變化，廷遲2秒重覆3次，正反正向，速度用ease區線</div>
			<div class="背景動畫效果元件4 單線邊框">用animation做特效，碰到才會動，離開就不動</div>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			</textarea>
			<br>
			<!-- ******************************************************************************************** -->
			<button type="button" onclick="javascriptWindow(document.getElementById('id14').value );">測試14</button>
			<br>
			<textarea id="id14" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<link rel="stylesheet" type="text/css" href="mycss.css">
			圓角的圖片
			<img class="圓角的圖片" src="2.png" alt="Paris" width="200" height="100">
			<br>圓形的圖片
			<img class="圓形的圖片" src="2.png" alt="Paris" width="200" height="100">
			<br>
			連結圖片框
			<a class="連結圖片框" href="2.png">  <img src="2.png" alt="Paris" width="200" height="100"></a>
			<br>濾鏡模糊blur(5px)<img class="濾鏡模糊" src="2.png" alt="Paris" width="200" height="100">
			<br>濾鏡亮度brightness(50%)<img class="濾鏡亮度" src="2.png" alt="Paris" width="200" height="100">
			<br>濾濾鏡對比contrast(200%)<img class="濾鏡對比" src="2.png" alt="Paris" width="200" height="100">
			<br>濾鏡陰影drop-shadow(8px 8px 10px red)<img class="濾鏡陰影" src="2.png" alt="Paris" width="200" height="100">
			<br>濾鏡灰階grayscale(50%)<img class="濾鏡灰階" src="2.png" alt="Paris" width="200" height="100">
			<br>濾鏡色調位移 hue-rotate(90deg)<img class="濾鏡色調位移" src="2.png" alt="Paris" width="200" height="100">
			<br>濾鏡色調反轉invert(100%)<img class="濾鏡色調反轉" src="2.png" alt="Paris" width="200" height="100">
			<br>濾鏡透明度opacity(30%)<img class="濾鏡透明度" src="2.png" alt="Paris" width="200" height="100">
			<br>濾鏡飽合度saturate(800%)<img class="濾鏡飽合度" src="2.png" alt="Paris" width="200" height="100">
			<br>濾鏡墨色sepia(100%)<img class="濾鏡墨色" src="2.png" alt="Paris" width="200" height="100">
			<br>多重濾鏡blur(5px) brightness(50%)<img class="多重濾鏡" src="2.png" alt="Paris" width="200" height="100">
			<br>嚮應式圖片大小<img class="嚮應式圖片大小1" src="2.png">
			<img class="嚮應式圖片大小1" src="2.png">
			<img class="嚮應式圖片大小1" src="2.png">
			<img class="嚮應式圖片大小1" src="2.png">
			嚮應式圖片大小結束
			<br>
			
			</textarea>
			<br>
			<!-- ******************************************************************************************** -->
			<button type="button" onclick="javascriptWindow(document.getElementById('id15').value );">測試15</button>
			<br>
			<textarea id="id15" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<link rel="stylesheet" type="text/css" href="mycss.css">
			<pre>
				使用media query來設定要載入那個css，這個有機會用到
				＜link rel="stylesheet" media="screen and (min-width: 400px) and (max-width: 700px)" href="test.css" /＞
				====================================================
				/*在 CSS 裡使用 @import，(我覺得不要用，因為這是一次性載入的吧，size再改變就會有問題吧)
					以下解釋為當螢幕寬度在 400px ~700px 之間，就會將 test.css 的檔案呼叫匯入，並套用設定。*/
				@import "test.css" screen and (min-width: 400px) and (max-width: 700px)
				====================================================
				有的瀏覽器並不支援 Media Queries，但支援 Media Type，所以我們可以用only來阻擋這些瀏覽器。
				＜link rel="stylesheet" type="text/css" href="test.css" media="only screen and (color)"＞
				瀏覽器支援(Media Queries & Media Type)：彩色螢幕就會讀取 test.css
				瀏覽器不支援(Media Queries)：因為有寫 only 條件，所以不讀取test.css，沒寫的話應該可能會被載入
				瀏覽器不支援(Media Queries & Media Type)：不讀取test.css
				====================================================
				not是用來排除某些設備的樣式，假設你希望這個樣式只在 A 設備有作用， B 設備完全沒用，就可以使用 not 囉。
				/*彩色螢幕不會套用 css 設定，彩色印表機會套用 css 設定*/
				@media not screen and (color), print and (color)
				@media (not (screen and (color))), print and (color)
				====================================================
				Media 常見的支援裝置有: all, screen, print ，以下列出所有支援的裝置類型(by @W3C):
				all ：所有可適用的裝置。
				braille ：盲人點字器。
				embossed ：盲人點字印表機。
				handheld ： 手機/ PDA裝置。
				print ：印表機列印輸出。
				projection ：全螢幕投影輸出。
				screen ：一般電腦螢幕 (含iphone, ipad)。
				speech ：朗讀式裝置。
				tty ：由文字長度決定大小的終端機裝置。
				tv ：電視。
				====================================================
				width | min-width | max-width (寬度 | 最小寬度 | 最大寬度)
				height | min-height | max-height (高度 | 最小高度 | 最大高度)
				device-width | min-device-width | max-device-width (裝置寬度 | 裝置最小寬度 | 裝置最大寬度)
				device-height | min-device-height | max-device-height (裝置高度 | 裝置最小高度 | 裝置最大高度)
				orientation (value: portrait | landscape) (裝置旋轉方向 值:直立 | 橫向)
				aspect-ratio | min-aspect-ratio | max-aspect-ratio (螢幕顯示比例 | 螢幕顯示最小比例 | 螢幕顯示最大比例)
				device-aspect-ratio | min-device-aspect-ratio | max-device-aspect-ratio(裝置顯示比例 | 裝置顯示最小比例 | 裝置顯示最大比例)
				color | min-color | max-color(彩色 | 最小顏色bit數 | 最大顏色bit數)color:0 表示該裝置為黑白(單色)
				color-index | min-color-index | max-color-index
				monochrome | min-monochrome | max-monochrome(單色 | 最小單色bit數 | 最大單色bit數)monochrome :0 表示該裝置不是黑白(單色)
				resolution | min-resolution | max-resolution(解析度 | 最小解析度 | 最大解析度)
				scan (value:progressive | interlace)(TV 專用掃描)
				grid
			</pre>
				<p class="小螢幕改變顏色">小螢幕改變顏色</p>
				<p class="中螢幕改變顏色">中螢幕改變顏色</p>
				<p class="大螢幕改變顏色">大螢幕改變顏色</p>
				<p class="小或大螢幕改變顏色">小或大螢幕改變顏色</p>
				<p class="直立螢幕改變顏色">直立螢幕改變顏色</p>
				<p class="橫向螢幕改變顏色">橫向螢幕改變顏色</p>
			
			</textarea>
			<br>
			<!-- ******************************************************************************************** -->
			<button type="button" onclick="javascriptWindow(document.getElementById('id16').value );">測試16</button>
			<br>
			<textarea id="id16" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<link rel="stylesheet" type="text/css" href="mycss.css">
			<pre>
				viewport應該是用來做手機縮放用的基準值，下例是設定基準值為960吧
				＜meta name="viewport" content="width=960"＞
				＜meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;"＞
				width:[數字] 或 device-width 
				height:[數字] 或 device-height
				initial-scale:最小0.25，最大5
				minimum-scale:最小0.25，最大5
				maximum-scale:最小0.25，最大5
				user-scalable:1 或 0 (yes 或 no)
				
								
			</pre>
			
			
			
			</textarea>
			<br>
			<!-- ******************************************************************************************** -->
			<button type="button" onclick="javascriptWindow(document.getElementById('id17').value );">測試17</button>
			<br>
			<textarea id="id17" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			</textarea>
			<br>
			<!-- ******************************************************************************************** -->
			<button type="button" onclick="javascriptWindow(document.getElementById('id18').value );">測試18</button>
			<br>
			<textarea id="id18" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			</textarea>
			<br>
			<!-- ******************************************************************************************** -->
			<button type="button" onclick="javascriptWindow(document.getElementById('id19').value );">測試19</button>
			<br>
			<textarea id="id19" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			</textarea>
			<br>
			<!-- ******************************************************************************************** -->
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