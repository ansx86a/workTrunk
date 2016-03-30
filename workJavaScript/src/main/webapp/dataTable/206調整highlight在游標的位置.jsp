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
<style>
td.highlight {
	background-color: red !important;//如果沒有!important，第一列的顏色蓋不過去，應該說預設不重要，!後就變重要了，別的css蓋不過去
}

table.dataTable.hover tbody tr:hover, table.dataTable.display tbody tr:hover{
background-color: blue ;//這裡試著想把row也變色，結果只成功一半，會被order的column的css擋住
}
</style>

<script>
$(document).ready(function() {
    var table = $('#example').DataTable();
    $('#example tbody')
        .on( 'mouseenter', 'td', function () {
            var colIdx = table.cell(this).index().column;
            $( table.cells().nodes() ).removeClass( 'highlight' );
            $( table.column( colIdx ).nodes() ).addClass( 'highlight' );
        } );
} );
</script>
</html>