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
    // 先修正每個頁腳顯示，先弄成文字輸入
    $('#example tfoot th').each( function () {
        var title = $(this).text();
        $(this).html( '<input type="text" placeholder="Search '+title+'"  style="max-width: 120px;"/>' );
    } );
    // DataTable 
    var table = $('#example').DataTable();
 
    // 定義每個columns自已的search
    table.columns().every( function () {
        var that = this;
        //在textBox change的時候，改變column的search值，並重畫
        $( 'input', this.footer() ).on( 'keyup change', function () {
            if ( that.search() !== this.value ) {
                that
                    .search( this.value )
                    .draw();
            }
        } );
    } );
} );
</script>
</html>