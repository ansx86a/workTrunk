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
	<jsp:include page="空白table_html5_2.html" />
</body>
<%--
            <tr>
                <td data-search="Tiger Nixon">T. Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>61</td>
                <td data-order="1303686000">Mon 25th Apr 11</td>
                <td data-order="320800">$320,800/y</td>
            </tr>
data-search->重新定義search的內容，而不是用顯示的來search
data-order->重新定義排序的標準，不用預設的文字排序            
 --%>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
</html>