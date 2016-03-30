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
    </table>
</body>
<script>
<%-- 
此例展示的是由javascript塞陣列資料，如果定義好欄位columns
就可以使用ttt.clear() + ttt.draw()後，可以用ttt.rows.add(dataSet) + ttt.draw()回復
json的使用方式還不明，目前只會用陣列的方式
另外DOM的方式要把dataTable.destory()掉後，改掉DOM的樣式後再dataTable一次

--%>
var dataSet= [
           [ "Tiger Nixon", "System Architect", "Edinburgh", "5421", "2011/04/25", "$320,800" ],
           [ "Garrett Winters", "Accountant", "Tokyo", "8422", "2011/07/25", "$170,750" ],
           [ "Ashton Cox", "Junior Technical Author", "San Francisco", "1562", "2009/01/12", "$86,000" ]];

//這裡命名好columns，如果使用ttt.clear() + ttt.draw()後，可以用ttt.rows.add(dataSet) + ttt.draw()回復
$(document).ready(function() {
    ttt = $('#example').DataTable( {
        data: dataSet,
        columns: [
            { title: "Name" },
            { title: "Position" },
            { title: "Office" },
            { title: "Extn." },
            { title: "Start date" },
            { title: "Salary" }            
        ]
    } );
    
//     ttt.destroy();
//     ttt = $('#example').DataTable( {
//         data: dataSet,
//         columns: [
//             { title: "Name" },
//             { title: "Position" },
//             { title: "Office" },
//             { title: "Extn." },
//             { title: "Start date" },
//             { title: "Salary" }            
//         ]
//     } );    
} );
  
	             
</script>
</html>