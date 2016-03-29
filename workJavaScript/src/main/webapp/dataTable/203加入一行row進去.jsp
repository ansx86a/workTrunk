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
<table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Column 1</th>
                <th>Column 2</th>
                <th>Column 3</th>
                <th>Column 4</th>
                <th>Column 5</th>
            </tr>
        </thead>
    </table>
<button id="addRow" >addrow按鈕</button>    
</body>
<script>
<%-- 在dataTable中加入資料後，再用draw畫出來 --%>
$(document).ready(function() {
    var t = $('#example').DataTable();
    var counter = 1;
 
    $('#addRow').on( 'click', function () {
    	//加入一行資料，t.rows.add可以加入多行資料
       var data = t.row.add( [
            counter +'.1',
            counter +'.2',
            counter +'.3',
            counter +'.4',
            counter +'.5'
        ] );
        //data.draw( false );
        data.draw( );//我看到的範例用draw就可以了
        counter++;
    } );
 
    // Automatically add a first row of data
    $('#addRow').click();
} );
</script>
</html>