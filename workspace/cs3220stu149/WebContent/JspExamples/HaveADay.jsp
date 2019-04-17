<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Have a Day</title>
</head>
<body>

<% if (Math.random() < 0.5) { %>
	<h1>Have a Great Day!</h1>
<% } else { %>
	<h1>Have a <em>Lousy</em> Day!</h1>
<% } %>

</body>
</html>