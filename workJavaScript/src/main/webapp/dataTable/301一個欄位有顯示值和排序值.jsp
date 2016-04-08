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
<script>
	$(document).ready(function() {
		$(document).ready(function() {
		    $('#example').DataTable( {
		        ajax: "json/ajax3.txt",
		        columns: [
		            { data: "name" },
		            { data: "position" },
		            { data: "office" },
		            { data: "extn" },
		            { data: {
		                _:    "start_date.display",
		                sort: "start_date.timestamp"
		            } },
		            { data: "salary" }
		        ]
		    } );
		} );
	});
</script>
</html>