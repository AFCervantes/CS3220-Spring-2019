<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<c:if test="${ empty sessionScope.user }">
	<c:redirect url="Login.jsp" />
</c:if>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Members Only</title>
</head>
<body>
<h1>Members Only</h1>

<!--  
	Scopes
	
	Widest
				Application
				Session
				Request
				Page
	Narrowest
-->

<h3>Welcome, ${ user }!</h3>
<p>This is a members-only area</p>
<p>
	<a href="Logout.jsp">Logout</a>
</p>

</body>
</html>