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
                <th>Salary</th>
            </tr>
        </thead>
    </table>
</body>
<script>
<%-- 
json的應用就考慮在它是在非同步的ajax的應用
一開始是空值，然後再塞值進去
 --%>
$(document).ready(function() {
    ttt = $('#example').DataTable( {
        "columns": [//第一個欄位的data加入class，不能排序，內容是空值
                    { data: "name",title: "名字"  },//其它的欄位就照排
                    { data: "position",title: "位置" },
                    { data: "office" },
                    { data: "salary" }
                ]    	
    } );
    ttt.clear();
    ttt.rows.add(dataSet.data);
    ttt.draw();
} );

var dataSet = {
	    "data": [
	             {
	                 "name": "Tiger Nixon",
	                 "position": "System Architect",
	                 "salary": "$320,800",
	                 "start_date": "2011\/04\/25",
	                 "office": "Edinburgh",
	                 "extn": "5421"
	             },
	             {
	                 "name": "Garrett Winters",
	                 "position": "Accountant",
	                 "salary": "$170,750",
	                 "start_date": "2011\/07\/25",
	                 "office": "Tokyo",
	                 "extn": "8422"
	             },
	             {
	                 "name": "Ashton Cox",
	                 "position": "Junior Technical Author",
	                 "salary": "$86,000",
	                 "start_date": "2009\/01\/12",
	                 "office": "San Francisco",
	                 "extn": "1562"
	             }
]};	             
</script>
</html>