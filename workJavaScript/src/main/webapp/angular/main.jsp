<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>main jsp page
</body>
<script>
	alert(mainPage + " has a length = " + $("a").length);
	maina = "main頁變數in main";
	reda = "red頁變數in main";
	alert(maina + "\n" + reda);
	mainPage += "m";
	mainppp();
	function mainppp() {
		alert("i am mainppp");
	}
</script>
</html>