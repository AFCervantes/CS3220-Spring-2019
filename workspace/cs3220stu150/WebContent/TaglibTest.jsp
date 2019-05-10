<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cs3220" uri="http://cs.calstatela.edu/cs3220stu150/examples" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<p>This is the result of the AddTag:
	<cs3220:add op1="${param.op1}" op2="${param.op2}" />
</p>

<p>This is the requestInfo tag:
	<cs3220:requestInfo type="method" />, <cs3220:requestInfo type="client" />.
</p>


<p>This is the cap tag:
	<cs3220:cap>${param.text}</cs3220:cap>
</p>


<p>This is the tag file:
	<cs3220:greeting name="Albert">Hello</cs3220:greeting>
</p>

<p>This is the EL function:
	${cs3220:leetTalk('fear my mad programming skills')}.
</p>



</body>
</html>