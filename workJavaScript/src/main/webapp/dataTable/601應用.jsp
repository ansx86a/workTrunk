<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/dataTable/jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dataTable/jquery.serializeToJSON.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dataTable/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/dataTable/css/jquery.dataTables.min.css">
</head>
<body>
	<form id="myForm">
		<div>
			查詢1:
			<input type="text" name="txt1">
			查詢2:
			<input type="text" name="txt2">
			查詢3:
			<input type="text" name="txt3">
			查詢3:
			<input type="text" name="txt3">
		</div>
	</form>
	<div>
		<button id="bt1">非同步</button>
		<button id="bt2">同步</button>
		<button id="bt3">測試3</button>
		<button id="bt4">測試4</button>
	</div>
	==以下是table=============
	<br>
	<div id="tableDiv">
		<table id="example">
		</table>
	</div>

</body>
<script>
	var t = "0";
	$(document).ready(function() {
		//initTable();
		//$("#tableDiv").hide();//控制不要一開始就透出dataTable來

		$("#bt1").on("click", function() {
			var url = '${pageContext.request.contextPath}/dataTable002.mvc';
			
			$.ajax({
				type : 'post',
				url : url,
				data : {
					data1 : $("[name='txt1']").val(),
					data2 : $("[name='txt2']").val()
					,jsonData : JSON.stringify($("#myForm").serializeToJSON())
//https://github.com/raphaelm22/jquery.serializeToJSON
//$("#myForm").serializeToJSON()  //jsonObject
//$("#myForm").serializeToJSON()  //jsonString
				},
				dataType : 'json',
				cache : false,
				success : function(data) {
					putTable(data);
				},
				error : function(data) {
					alert("伺服器錯誤");
				}
			});
		});
		$("#bt2").on("click", function() {
		
		});
		$("#bt3").on("click", function() {
			alert($(this).html());
		});
		$("#bt4").on("click", function() {
			alert($(this).html());
		});
	});

	function putTable(data) {
		if (t === "0") {
			initTable();
		} else {
			t.clear();
		}
		t.rows.add(data.abc);
		t.draw();
	}

	function initTable() {
		t = $('#example').DataTable({
			"language" : {
				"url" : "${pageContext.request.contextPath}/dataTable/json/lang_tw.json"
			},
			"paging" : true,
			"ordering" : false,
			"info" : false,
			"searching" : false,
			"columns" : [ {
				data : "name",
				title : "名字"
			},//其它的欄位就照排
			{
				data : "data1",
				title : "資料1"
			}, {
				data : "data2",
				title : "資料2"
			}, {
				data : "data3",
				title : "資料3"
			} ]
		});
	}
</script>
</html>