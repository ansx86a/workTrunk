<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="bootstrap.min.js"></script>
<script type="text/javascript" src="jquery.dataTables.min.js"></script>
<script type="text/javascript" src="dataTables.bootstrap.min.js"></script>
<%--<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css"> --%>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.min.css">
</head>
<%-- 實作失敗，以後有空再回來實作 --%>
<body>
	<ul class="nav nav-tabs" role="tablist">
		<li class=""><a href="#tab-table1" data-toggle="tab" aria-expanded="false">Table 1</a></li>
		<li class="active"><a href="#tab-table2" data-toggle="tab" aria-expanded="true">Table 2</a></li>
	</ul>

	<table id="myTable1" class="table table-striped table-bordered" cellspacing="0" width="100%">
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
	<table id="myTable2" class="table table-striped table-bordered" cellspacing="0" width="100%">
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
<%-- 實作失敗，以後有空再回來實作 --%>
<script>
	$(document).ready(function() {
		$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
			//alert(e);
			//這一行看不懂啦
			$.fn.dataTable.tables({
				visible : true,
				api : true
			}).columns.adjust();//適應性？要適應什麼？
		});
		//把table 而且class有table的表，dataTable化
		$('table.table').DataTable({
			ajax : 'json/ajax.txt',
			scrollY : 200,
			scrollCollapse : true,
			paging : false
		});

		//直接呼叫api的search方法，然後重load
		$('#myTable2').DataTable().search('New York').draw();
	});
</script>
</html>