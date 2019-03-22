<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="models.BGBean" id="bg" />

<%-- 
<jsp:setProperty name="bg" property="g" value="100" />
<jsp:setProperty name="bg" property="b" param="blue" />
<jsp:setProperty name="bg" property="r" />
 --%>
<jsp:setProperty name="bg" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BGColor</title>

<style>
body{
	background-color: rgb(<jsp:getProperty name="bg" property="r" />, 
						  <jsp:getProperty name="bg" property="g" />, 
						  <jsp:getProperty name="bg" property="b" />);
}
</style>

</head>
<body>

<h1>Background Color</h1>
<h3>
	Red: <jsp:getProperty name="bg" property="r" /> 
</h3>
<h3>	
	Green: <jsp:getProperty name="bg" property="g" /> 
</h3>
<h3>
	Blue: <jsp:getProperty name="bg" property="b" /> 
</h3>



</body>
</html>