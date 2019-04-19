<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%-- set data source --%>
<sql:setDataSource
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://cs3.calstatela.edu/cs3220stu150"
	user="cs3220stu150"
	password="" />
    
<c:if test="${not empty param.name and not empty param.message}">
	<sql:update>
		INSERT INTO guestbook (name, message) VALUES(?, ?)
		<sql:param value="${param.name}" />
		<sql:param value="${param.message}" />
	</sql:update>
	<c:redirect url="GuestBookJSTL.jsp" />
</c:if>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Add Comment (JSTL)</h1>

<form action="AddCommentJSTL.jsp" method="post">
	Name: <input type="text" name="name" /> <br />
	Message: <input type="text" name="message" /> <br />
	<input type="submit" name="add" value="Add" />
</form>

</body>
</html>