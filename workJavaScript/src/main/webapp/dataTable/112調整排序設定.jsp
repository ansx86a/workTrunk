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
<%-- 
這裡可以設定第幾下用那種排序
一般都設null，就為第一下小到到，第二下大到小
老實說這裡的實用度不大，主要是設能不能排序比較重要，而排序我查不到由欄位定義去開關
我只查到002、109去全關
 --%>
<script>
$(document).ready(function() {
    $('#example').DataTable( {
        "aoColumns": [
            null,
            { "orderSequence": [ "asc", "asc", "asc" ] },
            { "orderSequence": [ "asc" ] },
            { "orderSequence": [ "desc", "asc", "asc" ] },
            { "orderSequence": [ "desc" ] },
            null
        ]
    } );
} );
</script>
</html>