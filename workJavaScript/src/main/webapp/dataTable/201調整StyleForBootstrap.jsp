<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="jquery.dataTables.min.js"></script>
<script type="text/javascript" src="dataTables.bootstrap.min.js"></script>
<%--<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css"> --%>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.min.css">
</head>
<body>
	<jsp:include page="空白table_Bootstrap.html" />
</body>
<%-- 主要是table的class要寫對，然後要import的css和javascript要調整 --%>

<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
</html>