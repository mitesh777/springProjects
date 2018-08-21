<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Airline</title>
</head>
<body>
	<form:form action="updateAirline.html" method = "post" commandName="airlineObj">
		<form:input  path= "id" placeholder="Enter Airline Id"/><br>
		<form:input  path= "airlineName" placeholder="Enter Airline Name"/><br>
		<form:input  path= "serviceType" placeholder="Enter Service Type"/><br>
		<form:button  value = "Add Airline">Submit</form:button>
	</form:form>
</body>
</html>