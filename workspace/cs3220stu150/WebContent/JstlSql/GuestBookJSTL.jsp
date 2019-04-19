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

<%-- query --%>
<sql:query var="entries">
	select * from guestbook
</sql:query>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GuestBook</title>
</head>
<body>

	<c:if test="${entries.rowCount == 0}">
		<p>There is no message yet.</p>
	</c:if>
	
	<c:if test="${entries.rowCount > 0}">
		<table border="1">
			<tr>
				<th>Id</th><th>Name</th><th>Message</th>
			</tr>
			<c:forEach items="${entries.rowsByIndex}" var="row">
				<tr>
				  <c:forEach items="${row}" var="col">
				  	<td>${col}</td>
				  </c:forEach>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<p><a href="AddCommentJSTL.jsp">Add Comment</a></p>
</body>
</html>