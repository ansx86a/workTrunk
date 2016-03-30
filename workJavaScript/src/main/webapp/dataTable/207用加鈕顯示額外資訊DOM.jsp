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
function format ( d ) {
	kkk=d;
    var s= '<table cellpadding="4" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
            '<td>Full name:</td>'+
            '<td>'+d[0]+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>Age:</td>'+
            '<td>'+d[3]+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>Start date:</td>'+
            '<td>'+d[4]+'</td>'+
        '</tr>'+
    '</table>';
    return s;
}


	$(document).ready(function() {
		table = $('#example').DataTable({
			"columnDefs" : [ {
				"targets" : [ 3 ],
				"visible" : false,
				"searchable" : false
			}, {
				"targets" : [ 4 ],
				"visible" : false,
				"searchable" : false
			} ]
		});
	});
	
	  // 主要是改圖和加入一行row，row的寫法在format裡面
    $('#example tbody').on('click', 'td', function () {
        var tr = $(this).closest('tr');//捉出最近的tr，很有趣的寫法
        var row = table.row( tr );//這裡的shown應該是datatable的東西，而tr的class影嚮details-control的顯示
        if ( row.child.isShown() ) {//這裡的row應該是dataTable的東西，有shown可以用還蠻不錯的
            row.child.hide();//這裡就不知道是dataTable還是jquery的東西了
        }
        else {
            row.child( format(row.data()) ).show();
        }
    } );

</script>
</html>