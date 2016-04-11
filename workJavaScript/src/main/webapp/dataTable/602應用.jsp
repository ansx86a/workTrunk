<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/dataTable/jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dataTable/jquery.serializeToJSON.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dataTable/jquery.jsonext.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dataTable/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/dataTable/css/jquery.dataTables.min.css">
</head>
<%-- 本頁比601多了一點前端的東西，主要是可以在dataTable中有checkBox
而且可以撈出本頁的checkBox和全table的checkBox，而且可以透過head的dom去調整本頁的dom
差不多就這樣 --%>

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
			<br>
			<input type="checkBox" name="cb" value="true">
			check
			<input type="radio" name="rad" value="rad1">
			radio
			<input type="radio" name="rad" value="rad2">
			radio
		</div>
	</form>
	<div>
		<button id="bt1">捉server的資料</button>
	</div>
	==以下是table=============
	<br>
	<div id="tableDiv">
		<table id="example" class="display">
			<thead></thead>
			<tbody></tbody>
		</table>
	</div>

</body>
<script>
	var t = "0";
	$(document).ready(function() {
		$("#bt1").on("click", function() {
			var url = '${pageContext.request.contextPath}/dataTable002.mvc';
			$.ajax({
				type : 'post',
				url : url,
				//這個js的缺點？優點？，如果radio為null時，該參數就不會進json
				//另外checkBox要設value=true，不然json值會變成on
				data : {
					jsonData : JSON.stringify($("#myForm").serializeJsonObject())
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
	});

	$("#example tbody").on(
			"click",
			"input[type='checkBox']",
			function() {
				me = $(this);
				if (me.prop("checked")) {
					//checkbox要用prop來取得，就可以取得true or false'
				}
				//這裡的重點是t.$可以下jquery去撈值，不然#example tbody input只能撈出該頁的東西，跳頁就不見了
				alert(me.next().html() + "-->" + $("#example tbody input[type='checkBox']:checked").length + "-->"
						+ t.$("input:checked").length);

			});
	$("#example thead").on("click", "input[type='checkBox']", function() {
		me2 = $(this);
		if (me2.prop("checked")) {
			$("#example tbody input[type='checkBox']").prop("checked", true);
		} else {
			$("#example tbody input[type='checkBox']").prop("checked", false);
		}
	});

	function putTable(data) {
		if (t === "0") {
			$("#tableDiv").css("border", "3px solid #73AD21");
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
			"columnDefs" : [ {
				"render" : function(data, type, row) {
					return '<input type="checkBox" value="true"/>' + '<span> (' + row.name + ')</span>';
				},
				"targets" : 0
			} ],
			"columns" : [ {
				title : "<input type='checkBox'>全選"
			}, {
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
