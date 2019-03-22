<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Have some kind of day</title>
</head>
<body>

	<% if (Math.random() < 0.5) { %>
	<h1>Have a <strong>Great</strong> day!</h1>
	<% } else { %>
	<h1>Have a <em>Lousy</em> day!</h1>
	<% } %>
	
</body>
</html>