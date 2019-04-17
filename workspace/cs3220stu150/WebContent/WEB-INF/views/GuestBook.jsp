<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest Book</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>Guest Book (MVC)</h1>
	
	<c:if test="${ fn:length( guestbookEntries ) == 0}">
		<p>No one has signed our guestbook</p>
	</c:if>
	
	
	<c:if test="${ fn:length( guestbookEntries ) > 0}">
	
		<table class="table">
			<tr>
				<th>Index</th>
				<th>Name</th>
				<th>Message</th>
				<th>Date</th>	
				<th>Actions</th>			
			</tr>
			
			<c:forEach items="${ guestbookEntries }" var="entry" varStatus="status">
				<tr>
					<td>${ status.index + 1 }</td>
					<td>
						<c:out value="${ entry.name }" />
					</td>
					<td>${ entry.message }</td>
					<td>
						<fmt:formatDate value="${entry.date}" pattern="yyy-MM-dd hh:mm:ss a" />
					</td>
					<td>
						<c:url var="url" value="editcomment">
							<c:param name="id" value="${entry.id}"/>
						</c:url>						
						<a href="${url}">Edit</a>
						
						<c:url var="url" value="deletecomment">
							<c:param name="id" value="${entry.id}"/>
						</c:url>						
						<a href="${url}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
	
	</c:if>

	<a href="addcomment" class="btn btn-primary">Add Comment</a>
</div>
</body>
</html>