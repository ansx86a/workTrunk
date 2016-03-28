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
	        "language": {
	            "lengthMenu": "每頁顯示 _MENU_ 筆",
	            "zeroRecords": "--無資料--",
	            "info": "目前顯示頁面為 _PAGE_ / _PAGES_",
	            "infoEmpty": "",
	            "infoFiltered": "(從 _MAX_ 筆資料中篩選)"
	        }
	    } );
	    
<%-- 原來的樣子
	    $('#example').DataTable( {
	        "language": {
	            "lengthMenu": "Display _MENU_ records per page",
	            "zeroRecords": "Nothing found - sorry",
	            "info": "Showing page _PAGE_ of _PAGES_",
	            "infoEmpty": "No records available",
	            "infoFiltered": "(filtered from _MAX_ total records)"
	        }
	    } );
--%>	    
	    
	});
</script>
</html>