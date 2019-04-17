<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id="gb" class="models.GuestBookBean" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest Book</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>Guest Book (Bean, EL, and JSTL)</h1>
	
	<c:if test="${ fn:length( gb.guestbook ) == 0}">
		<p>No one has signed our guestbook</p>
	</c:if>
	
	
	<c:if test="${ fn:length( gb.guestbook ) > 0}">
	
		<table class="table">
			<tr>
				<th>Index</th>
				<th>Name</th>
				<th>Message</th>
				<th>Date</th>				
			</tr>
			
			<c:forEach items="${ gb.guestbook }" var="entry" varStatus="status">
				<tr>
					<td>${ status.index + 1 }</td>
					<td>
						<c:out value="${ entry.name }" />
					</td>
					<td>
						<c:out value="${ entry.message }" />
					</td>
					<td>
						<%-- ${entry.date} --%>
						<fmt:formatDate value="${entry.date}" pattern="yyy-MM-dd hh:mm:ss a" />
					</td>
				</tr>
			</c:forEach>
		</table>
		
	
	</c:if>

	<a href="AddComment.jsp" class="btn btn-primary">Add Comment</a>
</div>
</body>
</html>