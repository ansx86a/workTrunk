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
	$(document).ready(function() {
	    $('#example').DataTable( {
	        "scrollY":        "200px",
	        "scrollCollapse": true,
	        "paging":         false
	    } );
<%-- 這裡的50vh表視窗的50%高度
    $('#example').DataTable( {
        scrollY:        '50vh',
        scrollCollapse: true,
        paging:         false
    } );
--%>	    
	});
</script>
</html>