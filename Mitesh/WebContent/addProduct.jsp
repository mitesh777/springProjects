<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="addProduct.html" method = "post" commandName="productObj">
		<form:input  path= "productName" placeholder="Enter  Name"/><br>
		<form:input  path= "price" placeholder="Enter price"/><br>
		<form:input  path= "date" placeholder="Enter date"/><br>
		
		<form:input  path= "category" placeholder="Enter price"/><br>
		<form:button  value = "Add Airline">Submit</form:button>
	</form:form>
</body>
</html>