<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${message} </h1>
	
	<form action="home.html" method = "post">
		Enter your Name<input type="text" name= "name" /><br>
		<a href="admin.html">ADMIN</a>
		<input type = "submit" value = "Submit"/>
	</form>
</body>
</html>