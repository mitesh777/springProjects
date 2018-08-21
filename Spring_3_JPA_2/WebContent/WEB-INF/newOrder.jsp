<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Place Order</h1>
	<form:form action="newOrder.html" method="post" commandName="command">
	<table>
	<tr>
	<th><form:label path="foodItem">Select a food Item</form:label></th>
	<th><form:label path="foodItem">Food Price</form:label></th>	
	</tr>
		<!-- form:radiobuttons  path= "foodItem" items = "${foodMenus}"/><br>  -->
	
	<c:forEach var = "foodPrice" items="${foodMenus}">
		<tr>	
		<td><form:radiobutton path="foodItem" label="${foodPrice.foodName}"
		value="${foodPrice.foodName}"/></td>
		<td>${foodPrice.price}</td>
		</tr>
	</c:forEach>
	<tr><td colspan="2"><form:button>Create</form:button></td></tr>
	</table>
	</form:form>
</body>
</html>