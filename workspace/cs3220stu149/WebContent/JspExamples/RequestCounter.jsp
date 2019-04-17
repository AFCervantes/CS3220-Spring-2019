<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- Declaration --%>
<%! 
	int counter = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Counter</title>
</head>
<body>
	
	<h1>
		You are visitor #<%= counter %>.  <%-- Expression --%>
	</h1>
	
	<%-- Scriptlet --%>
	<% counter++; %>
	
</body>
</html>