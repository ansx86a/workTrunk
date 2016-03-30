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
                <th></th>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Salary</th>
            </tr>
        </thead>
    </table>
</body>
<style>
td.details-control {
    background: url('resources/details_open.png') no-repeat center center;
    cursor: pointer;
}
tr.shown td.details-control {
    background: url('resources/details_close.png') no-repeat center center;
}
</style>

<script>
/* Formatting function for row details - modify as you need */
function format ( d ) {
	kkk=d;
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
            '<td>Full name:</td>'+
            '<td>'+d.name+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>Extension number:</td>'+
            '<td>'+d.extn+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>Extra info:</td>'+
            '<td>And any further details here (images etc)...</td>'+
        '</tr>'+
    '</table>';
}
 
$(document).ready(function() {
    var table = $('#example').DataTable( {
        "ajax": "json/ajax2.txt",
        "columns": [//第一個欄位的data加入class，不能排序，內容是空值
            {
                "className":      'details-control',
                "orderable":      false,
                "data":           null,
                "defaultContent": ''
            },
            { "data": "name" },//其它的欄位就照排
            { "data": "position" },
            { "data": "office" },
            { "data": "salary" }
        ],
        "order": [[1, 'asc']]//由name來排序
    } );
     
    // 主要是改圖和加入一行row，row的寫法在format裡面
    $('#example tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');//捉出最近的tr，很有趣的寫法
        var row = table.row( tr );//這裡的shown應該是datatable的東西，而tr的class影嚮details-control的顯示
        if ( row.child.isShown() ) {//這裡的row應該是dataTable的東西，有shown可以用還蠻不錯的
            row.child.hide();//這裡就不知道是dataTable還是jquery的東西了
            tr.removeClass('shown');//沒有圖示的話，這裡可以拿掉
        }
        else {
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );
} );
</script>
</html>