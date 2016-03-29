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
	
<%-- dataTable的可透過row(dom)來撈資料 
          然後透過data()來取得陣列或是json，應該是陣列的機會大些
 --%>
	$(document).ready(function() {
		var table = $('#example').DataTable();
		$('#example tbody').on('click', 'tr', function() {
			var data = table.row(this).data();
			alert('You clicked on ' + data[1] + '\'s row');
		});
	});
</script>
</html>