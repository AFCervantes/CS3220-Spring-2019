<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! int counter = 0; %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Counter</title>
</head>
<body>

<% counter++; %>

<h1>
	You are visitor #
	<%= counter %>
</h1>	
	
	
</body>
</html>