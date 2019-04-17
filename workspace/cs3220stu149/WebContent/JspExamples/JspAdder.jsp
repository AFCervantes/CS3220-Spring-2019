<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int num1, num2;
	try{
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
	}
	catch(Exception e){
		response.sendRedirect("JspAdder.html");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Adder</title>
</head>
<body>

<h1>JSP Adder</h1>

<h3>
	<%= num1 %>
	+
	<%= num2 %>
	=
	<%= num1 + num2 %>
</h3>

</body>
</html>