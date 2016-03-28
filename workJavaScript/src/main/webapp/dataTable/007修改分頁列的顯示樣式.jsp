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
		$('#example').DataTable({
			"pagingType" : "full_numbers"
		});
	});
<%-- 
numbers - 只有數字鍵Page number buttons only (1.10.8)
simple - 只有上一頁和下一頁'Previous' and 'Next' buttons only
simple_numbers - 數字+上下頁'Previous' and 'Next' buttons, plus page numbers
full -只有第一頁、上一頁、下一頁、最後頁 'First', 'Previous', 'Next' and 'Last' buttons
full_numbers -全部 'First', 'Previous', 'Next' and 'Last' buttons, plus page numbers



--%>	
	
</script>
</html>