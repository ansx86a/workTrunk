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
	
<%-- 把一個欄位定義成多欄位，就只能都大或是都小，不能一大一小或一小一大 --%>
	$(document).ready(function() {
		$('#example').DataTable({
			columnDefs : [ {
				targets : [ 0 ],
				orderData : [ 0, 1 ]
			}, {
				targets : [ 1 ],
				orderData : [ 1, 0 ]
			}, {
				targets : [ 4 ],
				orderData : [ 4, 0 ]
			} ]
		});
	});
</script>