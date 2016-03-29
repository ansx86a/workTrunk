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
<%-- 
這裡主要是展示render可以動態調整欄位的內容值
這邊我把101的click事件加進去，結果alert出來的值是原來的值，非render的值
所以dataTable內存的data值不變，而Dom已被改變了
 --%>
$(document).ready(function() {
	var table =$('#example').DataTable( {
        "columnDefs": [
            {"render": function ( data, type, row ) {
                return data +' ('+ row[3]+')'+'{'+type+'}';
                },"targets": 0
            },
            {"render": function ( data, type, row ) {
                return data +'['+ row[3]+']'+'{'+type+'}';
                },"targets": 1
       	    },            
            { "visible": true,  "targets": [ 3 ] }
        ]
    } );
    
	$('#example tbody').on('click', 'tr', function() {
		var data = table.row(this).data();
		alert('You clicked on ' + data[1] + '\'s row'+"\r\n" + $(this).html());
	});
} );
</script>
</html>