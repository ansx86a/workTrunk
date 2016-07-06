<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ajax</title>
</head>
<body>

	<div style="position: fixed; bottom: 10px; right: 10px; width: 50px; border: 3px solid #73AD21;">
		<a href="#div0">回開頭</a>
	</div>


	<div id="div0" align="center">
		<p>
			<a href="#id1">ajaxTest(不能跨網域)</a>
		</p>
		<p>xpath參考:http://www.w3schools.com/xml/xml_xpath.asp</p>
		<p>
			<a href="#id2">ajaxXml</a>
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
	function loadDoc(method) {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				alert(xhttp.responseText);
			} else {
				//這裡我不懂errorHandle怎麼做
				//alert("" + xhttp.readyState + "," + xhttp.status);
			}
		};
		xhttp.open(method, "ajaxInfo.html", true);//open(method,url,async)
		xhttp.send();
	}

	function loadDoc2() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				alert(xhttp.responseText);
			} else {
				//這裡我不懂errorHandle怎麼做
				//alert("" + xhttp.readyState + "," + xhttp.status);
			}
		};
		xhttp.open("POST", "ajaxInfo.html", true);//open(method,url,async)
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send();
	}

	function loadDoc3() {
		var xhttp = new XMLHttpRequest();
		xhttp.open("GET", "ajaxInfo.html", false);//open(method,url,async)
		xhttp.send();
		alert(xhttp.responseText);
	}
</script>
<button type="button" onclick="loadDoc('GET')">發ajaxGet</button><br>
<button type="button" onclick="loadDoc('POST')">發ajaxPost</button><br>
<button type="button" onclick="loadDoc2()">發ajaxPost，帶form參數</button><br>
<button type="button" onclick="loadDoc3()">發ajax，非同步範例</button><br>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id2').value );">測試2</button>
		<br>
		<textarea id="id2" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
<script>
	function loadDoc1() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				var xmlDoc = xhttp.responseXML;
				var tes = xmlDoc.getElementsByTagName("title");
				var ary = [];
				for (i = 0; i < tes.length; i++) {
					ary.push(tes[i].childNodes[0].nodeValue);
				}
				alert(ary);
			} else {
				//這裡我不懂errorHandle怎麼做
				//alert("" + xhttp.readyState + "," + xhttp.status);
			}
		};
		xhttp.open("GET", "books.xml", true);//open(method,url,async)
		xhttp.send();
	}
</script>
<button type="button" onclick="loadDoc1()">發ajaxXml</button><br>
<button type="button" onclick="loadDoc2()">發ajaxXpath</button><br>
參考這裡吧https://www.nczonline.net/blog/2009/04/04/xpath-in-javascript-part-3/
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

