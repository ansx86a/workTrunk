<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css">
</head>
<body>
	<jsp:include page="空白table.html" />
</body>
<script>
<%-- 就算調整成不可見還是可以搜尋，但是這樣做會造成誤會，最好不要 --%>
	$(document).ready(function() {
		$('#example').DataTable({
			"columnDefs" : [ {
				"targets" : [ 2 ],
				"visible" : true,
				"searchable" : false
			}, {
				"targets" : [ 3 ],
				"visible" : false,
				"searchable" : true

	} ]
		});
	});
</script>
</html>