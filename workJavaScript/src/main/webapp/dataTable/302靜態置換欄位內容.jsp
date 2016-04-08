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
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Extn.</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
        </thead>
    </table>
</body>
<%-- 不太清楚能有什麼用途，-1表示最後一欄
103才有實作的價值吧，此功能保留
 --%>
<script>
	$(document).ready(function() {
	    var table = $('#example').DataTable( {
	        "ajax": "json/ajax.txt",
	        "columnDefs": [ {
	            "targets": -1,
	            "data": null,
	            "defaultContent": "<button>Click!</button>"
	        } ]
	    } );
	 	//動態綁定button的動作
	    $('#example tbody').on( 'click', 'button', function () {
	        var data = table.row( $(this).parents('tr') ).data();
	        alert( data[0] +"'s salary is: "+ data[ 5 ] );
	    } );
	});
</script>
</html>