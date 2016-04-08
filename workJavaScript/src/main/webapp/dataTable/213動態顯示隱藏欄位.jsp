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
	<div id="mydiv">
		Toggle column: <a data-column="0">Name</a> - 
		<a data-column="1">Position</a> - 
		<a data-column="2">Office</a> - 
		<a data-column="3">Age</a> - 
		<a data-column="4">Start date</a> - 
		<a data-column="5">Salary</a>
	</div>
</body>
<script>
$(document).ready(function() {
    var table = $('#example').DataTable( {

    } );
 
    $('#mydiv a').on( 'click', function (e) {
        e.preventDefault();//使link失效的js寫法
        //捉出欄位物件
        var column = table.column( $(this).attr('data-column') );
        //直接設置欄位物件的顯示
        column.visible( ! column.visible() );
    } );
} );
</script>
</html>