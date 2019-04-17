<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Info</title>
</head>
<body>

<h3>
The method of the request: ${pageContext.request.method} <br />
Remote user: ${pageContext.request.remoteUser} <br />
Remote address: ${pageContext.request.remoteAddr} <br />
The value of parameter a: ${param.a} <br />
The value of parameter b: ${param["b"]} <br />
The value of cookie JSESSIONID: ${cookie["JSESSIONID"].value} <br />
</h3>
</body>
</html>