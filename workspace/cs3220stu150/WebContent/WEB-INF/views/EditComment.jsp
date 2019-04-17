<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Comment</title>
</head>
<body>


<h1>Edit Comment</h1>

<form action="editcomment" method="post">

	<c:if test="${ not empty nameError }">
		<p>${ nameError }</p>
	</c:if>
	
	<input type="text" name="name" value="${entry.name}" placeholder="Enter your name">
	<br>
	
	<p>${ messageError }</p>
	
	<textarea name="message" placeholder="Enter your message">${ entry.message }</textarea>
	<br>
	
	<input type="hidden" name="id" value="${entry.id}" >
	
	<input type="submit" name="saveBtn" value="Save Message">

</form>

</body>
</html>