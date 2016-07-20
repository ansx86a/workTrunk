<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jquery</title>
</head>
<body>

	<div style="position: fixed; bottom: 10px; right: 10px; width: 50px; border: 3px solid #73AD21;">
		<a href="#div0">回開頭</a>
	</div>


	<div id="div0" align="center">
		<p>
			<a href="#id1">顯示、淡入淡出、滑動相關</a>
		</p>
		<p>
			<a href="#id2">動畫</a>
		</p>

		<p>
			<a href="#id3">Dom操作</a>
		</p>
		<p>
			<a href="#id4">css</a>
		</p>
		<p>
			<a href="#id5">children and parent</a>
		</p>
		<p>
			<a href="#id6">同層</a>
		</p>
		<p>
			<a href="#id7">過濾和選擇元素</a>
		</p>
		<p>
			<a href="#id8">noConflict，釋放錢字號或用其它的變數取代錢字號</a>
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

		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id1').value );">測試1</button>
		<br>
		<textarea id="id1" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
			<script type="text/javascript" src="jquery-3.0.0.min.js"></script>
			<p id="p1">這裡是p1的內文，fade相關和hide、show、滑動相關都有完成的callback，只在顯示中測試這一個效果</p>
			<button id="hide" type="button">隱藏</button>
			<button id="show" type="button">顯示</button>
			<button id="hideSlow" type="button">慢慢隱藏，效果會閃</button>
			<button id="showSlow" type="button">慢慢顯示，效果會閃</button>			
			<button type="button">toggle 1.9後移除了</button>	
			<br>		
			<button id="fadeIn" type="button">淡入</button>
			<button id="fadeOut" type="button">淡出</button>
			<button id="fadeToggle" type="button">淡入淡出</button>
			<button id="fadeTo" type="button">淡到指定程度，而再使用淡入也只能達到指定程度</button>
			<br>
			<button id="slideDown" type="button">slideDown往下滑動</button>
			<button id="slideUp" type="button">slideUp往上滑動</button>
			<button id="slideToggle" type="button">slideToggle</button>
			
<script>
	$(document).ready(function() {
		//用on好些，可以處理一些動態生成的dom為動態綁定，click就不行了
		//.on( events [, selector ] [, data ], handler )
		$("#show").on("click", function() {
			$("#p1").show(function() {
				alert("callback完了");
			});
		});
		$("#hide").click(function() {
			$("#p1").hide();
		});
		$("#showSlow").on("click", function() {
			$("#p1").show(1000);
		});
		$("#hideSlow").on("click", function() {
			$("#p1").hide(1000);
		});
		//===============================
		$("#fadeIn").on("click", function() {
			$("#p1").fadeIn(1000);//$("#p1").fadeIn();//$("#p1").fadeIn("slow");//$("#p1").fadeIn("fast");
		});
		$("#fadeOut").on("click", function() {
			$("#p1").fadeOut(1000);//$("#p1").fadeOut();//$("#p1").fadeOut("slow");//$("#p1").fadeOut("fast");
		});
		$("#fadeToggle").on("click", function() {
			$("#p1").fadeToggle(1000);//$("#p1").fadeToggle();//$("#p1").fadeToggle("slow");//$("#p1").fadeToggle("fast");
		});
		$("#fadeTo").on("click", function() {
			$("#p1").fadeTo(2000, 0.2);//後面是0-1的值
		});
		//====================================

		$("#slideDown").on("click", function() {
			$("#p1").slideDown(2000);//slideDown()，都有callback
		});
		$("#slideUp").on("click", function() {
			$("#p1").slideUp(2000);//slideUp()
		});
		$("#slideToggle").on("click", function() {
			$("#p1").slideToggle(2000);//slideToggle()
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
			<div id="p1" style="background: #98bf21; left: 500px; height: 100px; width: 100px; position: fixed;">hello world</div>
			
			<button id="moveRight" type="button">右移動畫，左右交換一直按會當掉</button>
			<button id="moveLeft" type="button">左移動畫，所以要在callback加入完成後才能按下一個動畫</button>
			<br>
			<button id="moveRight20" type="button">右移20px</button>
			<button id="chWidth" type="button">顯示隱藏寬度，效果好像不錯</button>
	
			<p>動畫是執行緒安全的，同時執行多個動畫會依序執行</p>
			<button id="stop" type="button">停止動畫(滑動也有效，那淡入淡出和顯示隱藏應該也有效)</button>
			<br>
			<button id="stopAll" type="button">停止全部的動畫</button>
			<button id="stopSkip" type="button">跳過全部的動畫</button>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	</div>

	<script>
		$(document).ready(function() {
			$("#moveRight").on("click", function() {
				$("#p1").animate({
					fontSize : '0.5em',
					left : '750px',
					opacity : '0.5',
					height : '150px',
					width : '150px'
				}, 2000);//slideToggle()
			});
			$("#moveLeft").on("click", function() {
				$("#p1").animate({
					fontSize : '2em',
					left : '300px',
					opacity : '1',
					height : '100px',
					width : '100px'
				}, 1000);//slideToggle()
			});
			$("#moveRight20").on("click", function() {
				$("#p1").animate({
					left : '+=20px'
				});
			});

			$("#chWidth").on("click", function() {
				$("#p1").animate({
					width : 'toggle'
				});
			});

			$("#stop").on("click", function() {
				$("#p1").stop();
			});
			$("#stopAll").on("click", function() {
				$("#p1").stop(true);
			});
			$("#stopSkip").on("click", function() {
				$("#p1").stop(true, true);
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
			<p id="test">測試<b>粗體的</b>內容。<input type="text" id="valtxt" value="ttt" />
		</p>
			<button id="htmlBtn">html()</button>
			<button id="textBtn">text()</button>
			<button id="valBtn">val()</button>
			<button id="attrBtn">attr('value')</button>
			<br>
			<button id="htmlBtn2">html(html()+"a|")</button>
			<button id="textBtn2">text()</button>
			<button id="valBtn2">val("val設值測試"")</button>
			<button id="attrBtn2">attr('value',"attr設值測試")[{value還是用val，attr設值會在value有更動時即非default值失效}]</button>
			<button id="attrBtn3">attr({"a":"b","a2":"c2"})[用檢查元素驗証]</button>
			<br>
			<button id="appendBtn1">append("abc")[會是在p元素內的結尾，吃html語法][內含字串、jq建物件、dom建物件append]</button>
			<button id="prependBtn">prepend("abc")[p元素之內]</button>
			<button id="afterBtn">after("abc")[p元素之外]</button>
			<button id="beforeBtn">before("abc")[p元素之外]</button>
			<br>
			<button id="emptyBtn">empty清空子元素，以下都用檢查元素驗証</button>
			<button id="removeBtn">remove刪除自已加子元素</button>
			<button id="removeBtn2">remove刪除加條件</button>
			<br>
			<button id="sizeBtn">取得p元素的長寬等等</button>
<script>
	$(document).ready(function() {
		var a = $("#test").html();
		$("#htmlBtn").click(function() {
			alert($("#test").html());
		});
		$("#textBtn").click(function() {
			alert($("#test").text());
		});
		$("#valBtn").click(function() {
			alert($("#valtxt").val());
		});
		$("#attrBtn").click(function() {
			alert($("#valtxt").attr('value'));
		});
		$("#htmlBtn2").click(function() {
			$("#test").html(a + ">a|");
		});
		$("#textBtn2").click(function() {
			$("#test").text("測試1<br/>測試2");
		});
		$("#valBtn2").click(function() {
			$("#valtxt").val("val設值測試");
		});
		$("#attrBtn2").click(function() {
			$("#valtxt").attr('value', "attr設值測試");
			//removeAttr("value")
		});
		$("#attrBtn3").click(function() {
			$("#valtxt").attr({
				'value' : "attr2設值測試",
				"aaa" : "bbb"
			});
		});
		$("#appendBtn1").click(function() {
			//字串append
			$("#test").append("<br>|append|");
			//jquery的方式create element
			var txt2 = $("<b></b>").text("粗體文字1");
			$("#test").append(txt2);
			//dom的方式加入
			var txt3 = document.createElement("p");
			txt3.innerHTML = "Text.";
			$("#test").append(txt3);
			//$("p").append(txt1,txt2,txt3);     
		});
		$("#prependBtn").click(function() {
			$("#test").prepend("|加到前面|<br>");
		});
		$("#afterBtn").click(function() {
			//$("img").after(txt1,txt2,txt3);
			$("#test").after("|<加到後面>|<br>");
		});
		$("#beforeBtn").click(function() {
			$("#test").before("|<加到前面>|<br>");
		});

		$("#emptyBtn").click(function() {
			$("#test").empty();
		});
		$("#removeBtn").click(function() {
			$("#test").remove();
		});
		$("#removeBtn2").click(function() {
			$("#test").remove("[id='test']");
		});

		$("#sizeBtn").click(function() {
			var txt = "";
			txt += "width(): " + $("#test").width() + "\n";
			txt += "height(): " + $("#test").height() + "\n";
			txt += "innerWidth(): " + $("#test").innerWidth() + "\n";
			txt += "innerHeight(): " + $("#test").innerHeight() + "\n";
			txt += "outerWidth(): " + $("#test").outerWidth() + "\n";
			txt += "outerHeight(): " + $("#test").outerHeight() + "\n";
			txt += "width(): " + $(document).width() + "\n";
			txt += "height(): " + $(document).height() + "\n";
			txt += "innerWidth(): " + $(document).innerWidth() + "\n";
			txt += "innerHeight(): " + $(document).innerHeight() + "\n";
			txt += "outerWidth(): " + $(document).outerWidth() + "\n";
			txt += "outerHeight(): " + $(document).outerHeight() + "\n";
			txt += "width(): " + $(window).width() + "\n";
			txt += "height(): " + $(window).height() + "\n";
			txt += "innerWidth(): " + $(window).innerWidth() + "\n";
			txt += "innerHeight(): " + $(window).innerHeight() + "\n";
			txt += "outerWidth(): " + $(window).outerWidth() + "\n";
			txt += "outerHeight(): " + $(window).outerHeight() + "\n";
			alert(txt);
			$("#test").width(600);
			$("#test").height(200);
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
			<style type="text/css">
.important {
	font-weight: bold;
	font-size: xx-large;
}

.blue {
	color: blue;
}
</style>
			
<h1>標題一</h1>
<h2>標題二</h2>
<p>段落一</p>
<p>重要段落二</p>
<div>重要的本文內容一 </div>
<br>
<button id="addCssBtn">加入css</button>
<button id="removeCssBtn">刪除css p div[全刪可用removeAttr('style')]</button>
<button id="toggleCssBtn">toggle css p div(blue)</button>
<button id="getSetCssBtn">取回第一個p的css並設置第r個p的css</button>
<button id="setMoreCssBtn">設定多組css</button>
<script>
	$(document).ready(function() {
		$("#addCssBtn").click(function() {
			$("h1,h2,p").addClass("blue");
			$("p").addClass("important blue");
			$("div").addClass("important");
		});
		$("#removeCssBtn").click(function() {
			$("p,div").removeClass("important blue");
		});
		$("#toggleCssBtn").click(function() {
			$("p,div").toggleClass("blue");
		});
		$("#getSetCssBtn").click(function() {
			alert($("p").css("color"));
			$("p:eq(1)").css("color", "red");
		});
		$("#setMoreCssBtn").click(function() {
			$("p").css({
				"color" : "blue",
				"background-color" : "gray"
			});
		});

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
			<p>Body</p>
  <div style="width: 500px;">
	  <p>div (曾祖父)</p>  
	  <ul>ul (祖父)  
        <li>li (直接父)
          <span>span</span>
        </li>
    </ul>   
  </div>
  <button id="parentBtn">span parent()，一層</button>
  <button id="parentsBtn">span parents(ul)，撈出為ul的全部父輩</button>
  <button id="parentsBtn2">span .parentsUntil("div")，撈出到div的全部父輩</button>
  <br>
  <button id="childrenBtn">div children()，只能一層</button>
  <button id="findBtn">div find()，能多層</button>
  
<script>
	$(document).ready(function() {
		$("span").parents().css({
			"color" : "red",
			"border" : "2px solid red",
			"padding" : "5px",
			"margin" : "15px"
		});
		$("#parentBtn").click(function() {
			alert($("span").parent().html());
		});
		$("#parentsBtn").click(function() {
			var q = $("span").parents("ul");
			alert(q.length + "\n" + q.last().html());
		});
		$("#parentsBtn2").click(function() {
			var q = $("span").parentsUntil("div");
			alert(q.length + "\n" + q.last().html());
		});
		$("#childrenBtn").click(function() {
			var q = $("div").children();
			var txt = "";
			q.each(function(index) {
				txt += ("\n第" + index + "個" + this.outerHTML);
			});
			alert(txt);
			//有指定children的情況下
			alert($("div").children("p")[0].outerHTML);
		});
		$("#findBtn").click(function() {
			var q = $("div").find("li");
			alert(q.length + "\n" + q.last().html());
			//div的全部字項
			var txt = "";
			q = $("div").find("*");
			q.each(function(index) {
				txt += ("\n第" + index + "個" + this.outerHTML);
			});
			alert(txt);
		});

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
<div>div (父)
  <p>p</p>
  <span>span</span>
  <h3>h3</h3>  
  <h2>h2</h2>
  <h3>h3</h3>
  <span>span</span>
  <p>p</p>
</div>
 <button id="removeCssBtn">移除css</button>
 <button id="siblingsBtn">h2 siblings同層全部</button>  <br>
  <button id="nextBtn">h2 next</button>
  <button id="nextAllBtn">h2 next All</button>
  <button id="nextUntilBtn">h2 nextUntill</button>  <br>
  <button id="prevBtn">h2 prev</button>
  <button id="prevAllBtn">h2 prev All</button>
  <button id="prevUntilBtn">h2 prevUntill</button>  <br>
<script>
	var redBorderCss = {
		"color" : "red",
		"border" : "2px solid red"
	};
	$(document).ready(function() {
		$("#removeCssBtn").click(function() {
			$("div").children().removeAttr('style');
		});
		$("#siblingsBtn").click(function() {
			$("h2").siblings().css(redBorderCss);
		});
		$("#nextBtn").click(function() {
			$("h2").next().css(redBorderCss);
		});
		$("#nextAllBtn").click(function() {
			$("h2").nextAll().css(redBorderCss);
		});
		$("#nextUntilBtn").click(function() {
			$("h2").nextUntil("p").css(redBorderCss);
		});
		$("#prevBtn").click(function() {
			$("h2").prev().css(redBorderCss);
		});
		$("#prevAllBtn").click(function() {
			$("h2").prevAll().css(redBorderCss);
		});
		$("#prevUntilBtn").click(function() {
			$("h2").prevUntil("p").css(redBorderCss);
		});
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
<div>div (父)
  <p>p</p>
  <span>span</span>
  <h3 test="1">h3</h3>  
  <h2>h2</h2>
  <h3 test="2">h3</h3>
  <span>span</span>
  <h3>h3</h3>  
  <p>p</p>
  <h3>h3</h3>  
</div>
		 <button id="removeCssBtn">移除css</button>
		 <button id="firstBtn">h3 first</button>		 
 		 <button id="lastBtn">h3 last</button>	
 		 <button id="eqBtn">h3 eq(1)</button>	
 		 <button id="filterBtn">h3 filter(test='2')</button>	
 		 <button id="notBtn">h3 not(test='2')</button>	
<script>
	var redBorderCss = {
		"color" : "red",
		"border" : "2px solid red"
	};
	$(document).ready(function() {
		$("#removeCssBtn").click(function() {
			$("div").children().removeAttr('style');
		});
		$("#firstBtn").click(function() {
			$("h3").first().css(redBorderCss);
		});
		$("#lastBtn").click(function() {
			$("h3").last().css(redBorderCss);
		});
		$("#eqBtn").click(function() {
			$("h3").eq(1).css(redBorderCss);
		});
		$("#filterBtn").click(function() {
			$("h3").filter("[test='2']").css(redBorderCss);
		});
		$("#notBtn").click(function() {
			$("h3").not("[test='2']").css(redBorderCss);
		});
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
<pre>
noConflict() 方法會釋放會 $ 標識符的控制，這樣其他腳本就可以使用它了
$.noConflict();
jQuery(document).ready(function(){
  jQuery("button").click(function(){
    jQuery("p").text("jQuery 仍在運行！");
  });
});
您也可以創建自己的簡寫。noConflict() 可返回對 jQuery 的引用，您可以把它存入變量，以供稍後使用。請看這個例子
var jq = $.noConflict();
jq(document).ready(function(){
  jq("button").click(function(){
    jq("p").text("jQuery 仍在運行！");
  });
});
如果你的 jQuery 代碼塊使用 $ 簡寫，並且您不願意改變這個快捷方式，那麼您可以把 $ 符號作為變量傳遞給 ready 方法。這樣就可以在函數內使用 $ 符號了 - 而在函數外，依舊不得不使用 "jQuery"：
$.noConflict();
jQuery(document).ready(function($){
  $("button").click(function(){
    $("p").text("jQuery 仍在運行！");
  });
});
</pre>
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
			<p id="p1">這裡是p1的內文</p>
<script>
	$(document).ready(function() {
		alert("ready");
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
			<p id="p1">這裡是p1的內文</p>
<script>
	$(document).ready(function() {
		alert("ready");
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

