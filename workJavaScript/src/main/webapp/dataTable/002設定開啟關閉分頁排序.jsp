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
	    $('#example').DataTable( {
	        "paging":   true,
	        "ordering": false,
	        "info":     false
	    } );
	});
</script>
<%--
https://datatables.net/reference/option/
這個datatable好用歸好用，但是可以調整的東西主要都在columnDefs，可以調整顯示和搜尋

autoWidth	
deferRender	功能控制延遲渲染的初始化的額外的速度Feature control deferred rendering for additional speed of initialisation.
info	功能控制表信息顯示領域 Feature control table information display field
jQueryUI	為表使用標記和類由jQuery用戶界面進行的ThemeRoller主題Use markup and classes for the table to be themed by jQuery UI ThemeRoller.
lengthChange	功能控制終端用戶的改變表的分頁顯示長度的能力Feature control the end user's ability to change the paging display length of the table.
ordering	排序Feature control ordering (sorting) abilities in DataTables.
paging 	分頁Enable or disable table pagination.
processing	功能控制的處理指標Feature control the processing indicator.
scrollX	Horizontal scrolling
scrollY	Vertical scrolling
searching	功能控制搜索（過濾）的能力Feature control search (filtering) abilities
serverSide	功能控制數據表“服務器端的處理模式Feature control DataTables' server-side processing mode.
stateSave	State saving - restore table state on page reload
 --%>


</html>