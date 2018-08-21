<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
<style>
.error {
	font-weight: bold;
	color: red;
}
</style>
</head>
<body>
	<h1>Add Book</h1>
	<form:form action="addBook.html" method="post" commandName="bookObj">
		<form:label path="bookName"> Book Name</form:label>
		<form:input path="bookName"/>
		<form:errors path="bookName" cssClass="error"/>
		<br>
		
		<form:label path="bookPrice"> Book Price</form:label>
		<form:input path="bookPrice"/>
		<form:errors path="bookPrice" cssClass="error"/>
		<br>
		
		<form:label path="isbn"> ISBN</form:label>
		<form:input path="isbn"/>
		<form:errors path="isbn" cssClass="error"/>
		
		<br>
		
		<form:label path="authors"> Select Authors</form:label>
		<form:checkboxes items="${authors }" path="authors"/>
		<form:errors path="authors" cssClass="error"/>
		
		<form:button>Add Book</form:button>
	</form:form>
	
</body>
</html>