<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${ not empty param.loginBtn }">
	<c:if test="${ param.name == 'albert' and param['password'] == 'abcd' }">
		<c:set var="user" value="${ param.name }" scope="session" />
		<!--
			The line above is the equivalent of the line below  
			session.setAttribute("user", request.getParameter("name")); 
		-->
		<c:redirect url="Members.jsp" />
	</c:if>
</c:if>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<form action="Login.jsp" method="post">
	<input type="text" placeholder="Enter your username" name="name">
	<br>
	<input type="password" placeholder="Enter your password" name="password">
	<br>
	<input type="submit" value="Login" name="loginBtn">
</form>

</body>
</html>