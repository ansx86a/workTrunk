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
			<a href="#id1">get[post參照]的用法</a>
		</p>
		<p>
			<a href="#id2">getScript,getjson</a>
		</p>

		<p>
			<a href="#id3">load</a>
		</p>
		<p>
			<a href="#id4">param</a>
		</p>
		<p>
			<a href="#id5">ajax全局事件</a>
		</p>
		<p>
			<a href="#id6">ajax泛用</a>
		</p>
		<p>
			<a href="#id7">ajaxFile</a>
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
    	<p>jQuery.getScript( url [, success(script, textStatus, jqXHR) ] )</p>
    	 <button id="runMyjsBtn">載入myjs後可執行</button>
    	<button id="getScriptBtn">getScript的基本(可以跨網域)</button>
    	<button id="getScriptBtn2">getScript複雜(可以跨網域)</button>
    	<button id="getScriptBtn3">getScript複雜錯誤處理(可以跨網域)</button>
    	<pre>getScript等同
$.ajax({
  url: url,
  dataType: "script",
  success: success
});    	
    	</pre>
    	<p>jQuery.getJSON( url [, data(PlainObject or String) ] [, success(PlainObject data,String textStatus,jqXHR jqXHR) ] )</p>
    	<button id="getJSONBtn">getJSON的基本(不能跨網域)</button>
    	<button id="getJSONBtn2">getJSON的複雜(不能跨網域),jqXHR.done(),fail(),always()參考getBtn4</button>    	
    	<button id="getJSONBtn3">自已設jsonp不穩定，所以放棄，用ajax吧</button>
<pre>getJSON等同
$.ajax({
  dataType: "json",
  url: url,
  data: data,
  success: success
});
</pre>    	
<script>
	$(document).ready(
			function() {
				$("#runMyjsBtn").on("click", function() {
					myjs();
				});
				$("#getScriptBtn").on("click", function() {
					$.getScript("my.js", function() {
						alert("getScript ok");
					});
				});
				$("#getScriptBtn2").on(
						"click",
						function() {
							$.getScript("my.js", function(data, textStatus, jqxhr) {
								alert("getScript data:" + data + "\ntextStatus:" + textStatus + "\njqxhr:"
										+ jqxhr.readyState + "," + jqxhr.responseText + "," + jqxhr.status + ","
										+ jqxhr.statusText);
							});
						});
				$("#getScriptBtn3").on(
						"click",
						function() {
							$.getScript("my.js", function() {
								alert("ok先跑，done後跑");
							}).done(function(script, textStatus) {
								alert("done:" + script + "\n" + textStatus);
							}).fail(
									function(jqxhr, settings, exception) {
										alert("fail:" + settings + "\n" + exception + "\n\njqxhr:" + jqxhr.readyState
												+ "," + jqxhr.responseText + "," + jqxhr.status + ","
												+ jqxhr.statusText);
									});
						});
				$("#getJSONBtn").on("click", function() {
					$.getJSON("${pageContext.request.contextPath}/jquery001.mvc", function(data) {
						alert(JSON.stringify(data));
					});
				});
				$("#getJSONBtn2").on(
						"click",
						function() {
							$.getJSON("${pageContext.request.contextPath}/jquery001.mvc", "a=zzz&b=eeww", function(
									data, textStatus, jqXHR) {
								alert("ok:" + JSON.stringify(data));
								alert("status:" + textStatus);
								alert("" + jqXHR.readyState + "\n" + jqXHR.responseText + "\n" + jqXHR.status + "\n"
										+ jqXHR.statusText);
							});
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
		<p id="loadp">waitload,.load( url [, data ] [, complete(responseText, textStatus, XMLHttpRequest) ] )<br>
		默認使用 GET 方式 ， 如果data參數提供一個對象ex:{a:b}，那麼使用 POST 方式。
		</p>
		<button id="loadBtn">load等同ajax+jq.html(result)吧，網扯中可以加入jq select(ex:#id.class)</button>
<script>
	$(document).ready(function() {
		$("#loadBtn").on("click", function() {
			$("#loadp").load("${pageContext.request.contextPath}/jquery001.mvc", function(data) {
				alert("loadResult=" + JSON.stringify(data));
				//$('#b').load('article.html #target');//這裡表示把dom元件的Id=targe的Dom載入
			});
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
		<p>jQuery.param( obj [ Array 或 PlainObject 或 jQuery]) ,jQuery.param( obj,Boolean traditional [傳統的「shallow」的序列化])</p>
		<button id="paramBtn">參數化，有編碼問題要decodeURIComponent</button>
		<form>
			<input type="hidden" name="aaa" value="aaaValue" />
			<input type="hidden" name="bbb" value="bbbValue" />
 <select name="multiple" multiple="multiple">
    <option selected="selected">Multiple</option>
    <option>Multiple2</option>
    <option selected="selected">Multiple3</option>
  </select>			
			<input type="checkbox" name="check" value="c1" checked="checked" id="ch1" />
			<input type="checkbox" name="check" value="c2" id="ch2" />
			<input type="radio" name="radio" value="r1" checked="checked" id="r1" />
			<input type="radio" name="radio" value="r2" id="r2" />
		</form>
		<button id="serBtn">form的序列化serialize</button>
		<button id="serArrayBtn">form的序列化serializeArray(不喜歡用)</button>
		 <FORM action="http://server.com/cgi/handle" enctype="multipart/form-data" method="post">
   What is your name? <INPUT type="text" name="myName">					<BR>
   What files are you sending? <INPUT type="file" name="files">					<BR>
			</FORM>
 		 <button id="serBtn2">form2的序列化serialize，multipart序列化失敗，以後再試</button>
 		 <button id="serArrayBtn2">form2的序列化serializeArray(不喜歡用)，multipart序列化失敗，以後再試</button>
<script>
	$(document).ready(function() {
		$("#paramBtn").on("click", function() {
			var a = [ {
				name : "first第一",
				value : "Rick"
			}, {
				name : "last最後",
				value : "Astley"
			}, {
				name : "job工作",
				value : "Rock Star"
			} ];
			alert($.param(a));
			var a2 = decodeURIComponent($.param(a));
			alert(a2);
		});
		$("#serBtn").on("click", function() {
			var a = $("form:eq(0)").serialize();
			alert(a);
		});
		$("#serArrayBtn").on("click", function() {
			var a = $("form:eq(0)").serializeArray();
			alert(a);
			var result = "";
			$.each(a, function(i, field) {
				result += (field.value + " ");
			});
			alert(result);
		});

		$("#serBtn2").on("click", function() {
			var a = $("form:eq(1)").serialize();
			alert(a);
		});
		$("#serArrayBtn2").on("click", function() {
			var a = $("form:eq(1)").serializeArray();
			alert(a);
			$.each(a, function(i, field) {
				result += (field.value + " ");
			});
			alert(result);
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
<pre>	
.ajaxStart( handler() )	
.ajaxStop( handler() )
.ajaxSend( handler(event, jqXHR, ajaxOptions) )
.ajaxComplete( handler(event, XMLHttpRequest, ajaxOptions) )
.ajaxError( handler(event, jqXHR, ajaxSettings, thrownError) )
.ajaxSuccess( handler(event, XMLHttpRequest, ajaxOptions) )
</pre>
<button id="testBtn">測試ajax，修改網扯可以測error</button>
<p></p>
<script>
	$(document).ready(function() {
		$("#testBtn").on("click", function() {
			$.get("${pageContext.request.contextPath}/jquery001.mvc", function(data) {
				alert("get ok:" + JSON.stringify(data));
			});
		});
		$(document).ajaxStart(function() {
			alert("ajaxStart");
		});
		$(document).ajaxStop(function() {
			alert("ajaxStop");
		});
		$(document).ajaxSend(function(event, jqxhr, settings) {
			alert("ajaxSend");
		});
		$(document).ajaxComplete(function(event, xhr, settings) {
			alert("ajaxComplete");
		});
		$(document).ajaxError(function(event, jqxhr, settings, thrownError) {
			alert("ajaxError:" + settings + "\n" + settings.url + "\n" + thrownError)
		});
		$(document).ajaxSuccess(function(event, xhr, settings) {
			alert("ajaxSuccess");
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
		<p>jQuery.ajax( url [, settings ] )</p>
		<button id="ajaxBtn1">最簡單的非同步ajax舊版</button>
		<button id="ajaxBtn2">最簡單的非同步ajax新版</button>
		<button id="ajaxBtn3">無快取同步ajax</button>
		<button id="ajaxBtn4">jsonp</button>
		<pre>設定settings
url (默認: 當前頁面地址)		
method (default: 'GET') "POST", "GET ", "PUT" jQuery 1.9.0 之前的版本，你需要使用type選項
async (默認: true)跨域請求和 dataType: "jsonp" 請求不支持同步	
beforeSend Function( jqXHR jqXHR, PlainObject settings )	
cache (默認: true, dataType為"script"和"jsonp"時默認為false) 原理是在GET請求參數中附加"_={timestamp}"
contentType (default: 'application/x-www-form-urlencoded; charset=UTF-8') application/x-www-form-urlencoded, multipart/form-data, 或 text/plain
context Object 設定上下文，也就是this，可以設document.body
crossDomain (默認: 同域請求為false， 跨域請求為true)
data  PlainObject 或 String 或 Array
dataType (default: Intelligent Guess (xml, json, script, or html))
jsonp String 或者 Boolean
jsonpCallback String, Function
processData (默認: true)(只要不是字串)，都會轉化成查詢字串，以配合默認內容類型 "application/x-www-form-urlencoded"
statusCode (默認: {}) ex:statusCode: {404: function() { alert("page not found"); }//404時alert訊息

global (默認: true) 設置為 false 將不會觸發全局 AJAX 事件，如 ajaxStart 或者 ajaxStop。
complete Function( jqXHR jqXHR, String textStatus )，textStatus ("success", "notmodified", "nocontent"，"error", "timeout", "abort", 或者 "parsererror")
error Function( jqXHR jqXHR, String textStatus, String errorThrown ) textStatus得到null之外，還可能是"timeout", "error", "abort" ，和 "parsererror"
success Function( Object data, String textStatus, jqXHR jqXHR )
timeout類型: Number設置請求超時時間（毫秒）

比較沒用的 
contents PlainObject 一個以"{字符串/正則表達式}"配對的對象，根據給定的內容類型，解析請求的返回結果
converters (默認: {"* text": window.String, "text html": true, "text json": jQuery.parseJSON, "text xml": jQuery.parseXML})
dataFilter  Function( String data, String type ) data是Ajax返回的原始數據，type是調用jQuery.ajax時提供的dataType參數
headers (默認: {}) 此設置會在beforeSend 函數調用之前被設置
ifModified (默認: false) 
isLocal (默認: 取決於當前的位置協議)
mimeType String 一個mime類型用來覆蓋XHR的 MIME類型
password  String 用於響應HTTP訪問認證請求的密碼
username 類型: String 於響應HTTP訪問認證請求的用戶名
scriptCharset 通常只在本地和遠程的內容編碼不同時使用
traditional Boolean 參考jQuery.param 方法.
xhr (默認: 當可用的ActiveXObject（IE）中，否則為XMLHttpRequest)提供覆蓋你自己的執行的XMLHttpRequest或增強工廠
xhrFields 用於設定原生的 XHR對象
		</pre>
<script>
	var url = "${pageContext.request.contextPath}/jquery001.mvc";
	$(document).ready(function() {
		$("#ajaxBtn1").on("click", function() {
			$.ajax({
				url : url,
				beforeSend : function() {
					alert("beforeSend");
				},
				success : function(data) {
					alert("success->" + JSON.stringify(data))
				},
				error : function(data) {
					alert("error->" + JSON.stringify(data))
				},
				complete : function(data) {
					alert("complete->" + JSON.stringify(data))
				}
			})
			alert("完成")
		});
		$("#ajaxBtn2").on("click", function() {
			$.ajax({
				url : url
			}).done(function(data) {
				alert("done-success->" + JSON.stringify(data));
			}).fail(function(data) {
				alert("fail-error->" + JSON.stringify(data));
			}).always(function(data) {
				alert("always-complete->" + JSON.stringify(data));
			});
			alert("完成")
		});

		$("#ajaxBtn3").on("click", function() {
			$.ajax({
				method : "post",//
				url : url,
				async : false,
				data : {
					"a" : "111",
					"ccc" : "dddd"
				}
			}).done(function(data) {
				alert("done-success->" + JSON.stringify(data));
			});
			alert("完成")
		});
		$("#ajaxBtn4").on("click", function() {
			$.ajax({
				dataType : "jsonp",
				crossDomain : true,
				jsonpCallback : "jjj", //也可以寫function()，如果不需要回傳資的話這樣比較快，//異想天開:可以client配server的javascript來玩嗎？不建議啦
				//		function(data) {
				//		alert("jsonpCallback=" + data)
				//	},
				url : "http://127.0.0.1:8080/workJavaScript/jquery002.mvc"
			}).done(function(data) {
				alert("done-success->" + JSON.stringify(data));
			}).fail(function(data, txt, error) {
				alert("fail-error->" + JSON.stringify(data));
				alert("error" + error)
			});
			alert("完成")
		});

	});
	function jjj(data) {
		alert("jjj=" + data);
	}
</script>
		</textarea>
		<br>
		<!-- ******************************************************************************************** -->
		<button type="button" onclick="javascriptWindow(document.getElementById('id7').value );">測試7</button>
		<br>
		<textarea id="id7" style="width: 800px; height: 350px;" autocomplete="off" id="textareaCode" wrap="logical"
			spellcheck="false">
		<script type="text/javascript" src="jquery-3.0.0.min.js"></script>
        <form name='form1' method="POST" action="${pageContext.request.contextPath}/fileupload001.mvc"
				enctype="multipart/form-data">
            File1:<input type="file" name="files[0]" id="file" /> <br />
            <input type="submit" value="Upload" name="upload" id="upload" />
            <button type="button" id="getsize">getsize</button>
        </form>
        <form name='form2' method="POST" action="${pageContext.request.contextPath}/fileupload002.mvc"
				enctype="multipart/form-data">
            File2:<input type="file" name="myf" id="file2" /> <input name="myname" value="隨便的名字" /> <br />
            <input type="submit" value="Upload" name="upload" />
        </form>        
        <p>
				<button id="sendAjaxBtn">把form2的資料包成formData送出</button>
			</p>
		
<pre>使用formData上傳file的範例
		var formData = new FormData($(this).parent("form")[0]);
		formData.append("caseNo", $("#reuploadCaseNoLabel").text());
		var formURL="<%=request.getContextPath()%>/caseQuery/caseQuery/reupload/fileUpload";
		$.ajax({
			url : formURL,
			data : formData,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			type : 'post',
			dataType : 'json',
			success : function(data) {
				if (data.errorMsg != "") {
					alert(data.errorMsg);
				} else {
					updateImage(data);
				}
			},
			error : function(data) {
				alert("伺服器錯誤");
			}
		});
</pre>
		
<script>
	$(document).ready(function() {
		$("#getsize").on("click", function() {
			getsize();
		});
		$("#sendAjaxBtn").on("click", function() {
			//手動設值的寫法
			//var formData = new FormData();
			//formData.append("myf", form2.myf.files[0]);//把dom的值加進去
			//formData.append("myname", "ajax的名字");
			//自動設值的寫法
			var formData = new FormData(form2);
			$.ajax({
				url : "${pageContext.request.contextPath}/fileupload002.mvc",
				data : formData,
				async : false,
				cache : false,
				contentType : false,//可以試試這個 contentType: 'multipart/form-data',  
				processData : false,
				type : 'post',
				success : function(data) {
					alert("success");
				},
				error : function(data) {
					alert("伺服器錯誤");
				}
			});
		});
	});
	//取得檔案的大小
	function getsize() {
		var fi = document.getElementById('file');
		// VALIDATE OR CHECK IF ANY FILE IS SELECTED.
		if (fi.files.length > 0) {
			// RUN A LOOP TO CHECK EACH SELECTED FILE.
			for (var i = 0; i < fi.files.length; i++) {
				var fsize = fi.files.item(i).size; // THE SIZE OF THE FILE.
				alert(Math.round(fsize / 1024) + "KB");
			}
		} else {
			alert("空的");
		}
	}
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

