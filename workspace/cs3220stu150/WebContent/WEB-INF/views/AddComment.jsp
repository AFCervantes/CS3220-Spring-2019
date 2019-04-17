<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Comment</title>
</head>
<body>

<h1>Add Comment</h1>

<form action="addcomment" method="post">

	<c:if test="${ not empty nameError }">
		<p>${ nameError }</p>
	</c:if>
	
	<input type="text" name="name" value="${param.name}" placeholder="Enter your name">
	<br>
	
	<p>${ messageError }</p>
	
	<textarea name="message" placeholder="Enter your message">${ param.message }</textarea>
	<br>
	<input type="submit" name="addBtn" value="Add Message">

</form></body>
</html>