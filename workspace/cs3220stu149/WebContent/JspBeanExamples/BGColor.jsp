<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="models.BGBean" id="bg" scope="session"/>
<%-- 
<jsp:setProperty name="bg" property="r" value="0" />
<jsp:setProperty name="bg" property="g" param="green" />
<jsp:setProperty name="bg" property="b" /> 
--%>

<jsp:setProperty name="bg" property="*" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	body {
		background-color: rgb(
			${bg.r},
			${bg.g},
			${bg.b}
		);
	}
</style>
</head>
<body>

	
	

	<h1>BG Color</h1>
	<h3>Red: <jsp:getProperty name="bg" property="r" /></h3>
	<h3>Green: <jsp:getProperty name="bg" property="g" /></h3>
	<h3>Blue: <jsp:getProperty name="bg" property="b" /></h3>
	
	<h3>bg.abc: <jsp:getProperty name="bg" property="abc" /></h3>
	<h3>bg.name: <jsp:getProperty name="bg" property="name" /></h3>
</body>
</html>