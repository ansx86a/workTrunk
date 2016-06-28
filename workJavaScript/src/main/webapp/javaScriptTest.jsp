<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="jquery-1.12.2.min.js"></script>
<title>test</title>
</head>
<body>
	<div align="center">
		<button name="sentIframe" type="button" txtid="txtArea" iframeDiv="iframeDiv">Click Me!</button>
	</div>
	<div align="center">
		<div id="textareaDiv">
			<textarea id="txtArea" style="width: 500px; height: 450px; // float: left;" autocomplete="off" id="textareaCode"
				wrap="logical" spellcheck="false">
				aaaa
				bbbb
				ccccc
		</textarea>
		</div>
		<div id="iframeDiv">
			<!--  <iframe id="txtIframe" width="500" height="450"></iframe>-->
		</div>
	</div>


	<script>
		$("button[name='sentIframe']").on(
				"click",
				function() {
					var txtid = $(this).attr("txtid");
					var ifdiv = $(this).attr("iframeDiv");
					//alert($("#txtArea").val());
					var txt = $("#" + txtid).val();
					javascriptWindow(txt);
					//$('#txtIframe').contents().find('html').html(txt);

					新增iframe: {
						break 新增iframe;//暫時停用新增iframe這個功能 ，先用openWindow來替代
						var ifr = document.createElement("iframe");
						ifr.setAttribute("frameborder", "0");
						ifr.setAttribute("id", "iframeResult");
						ifr.setAttribute("width", "500");
						ifr.setAttribute("height", "450");
						ifr.setAttribute("style", "border:medium double rgb(250,0,0)");
						document.getElementById(ifdiv).innerHTML = "";
						document.getElementById(ifdiv).appendChild(ifr);
						var ifrw = (ifr.contentWindow) ? ifr.contentWindow
								: (ifr.contentDocument.document) ? ifr.contentDocument.document : ifr.contentDocument;
						ifrw.document.open();
						ifrw.document.write(txt);
						ifrw.document.close();
						if (ifrw.document.body && !ifrw.document.body.isContentEditable) {
							ifrw.document.body.contentEditable = true;
							ifrw.document.body.contentEditable = false;
						}
					}

				});

		//研究了老半天，重點就這一段而已
		function javascriptWindow(txt) {
			開新視窗: {
				var x = screen.width / 2 - 400 / 2;
				var y = screen.height / 2 - 500 / 2;
				var w = window.open("", "", "width=400,height=500,left=" + x + ",top=" + y);
				w.document.open();
				w.document.write(txt);
				w.document.close();
			}
		}
	</script>
</body>
</html>