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
	<jsp:include page="空白table_formInput.html"/>
	<br>
	<button>測試序列化</button>
</body>
<%-- 
主要是序列化，會是row-[第幾列]-[欄位名]=[值]&串起來，空格會變成+號
不是很喜歡的串法，後台要解也很麻煩，一列的話還可以考慮其中的應該
先放置play
 --%>
<script>
	$(document).ready(function() {
		var table = $('#example').DataTable();
		
		
	    $('button').click( function() {
	        var data = table.$('input, select').serialize();
	        alert(
	            "The following data would have been submitted to the server: \n\n"+
	            data.substr( 0, 120 )+'...'
	        );
	        return false;
	    } );
	});
</script>
</html>