<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Airline</title>
</head>
<body>
	<form:form action="addAirline.html" method = "post" commandName="airlineObj">
		<form:input  path= "airlineName" placeholder="Enter Airline Name"/><br>
		<form:input  path= "serviceType" placeholder="Enter Service Type"/><br>
		<form:button  value = "Add Airline">Submit</form:button>
	</form:form>
</body>
</html>