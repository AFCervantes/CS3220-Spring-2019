<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="gb" class="models.GuestBookBean" scope="application" />

<c:if test="${ not empty param.addBtn }">
	<%-- Create the empty guestbook entry --%>
	<jsp:setProperty name="gb" property="addEntry" value="dummy" />
	
	<%-- Populate the empty (last created) guestbook entry --%>
	<c:set target="${ gb.lastEntry }" property="name" value="${ param.name }" />
	<c:set target="${ gb.lastEntry }" property="message" value="${ param.message }" />
	
	<%-- Redirect the user back to the main page --%>
	<c:redirect url="GuestBook.jsp" />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Comment</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">

<form action="AddComment.jsp" method="post">

	<input type="text" name="name" placeholder="Enter your name">
	<br>
	<textarea name="message" placeholder="Enter your message"></textarea>
	<br>
	<input type="submit" name="addBtn" value="Add Message">

</form>

</div>
</body>
</html>