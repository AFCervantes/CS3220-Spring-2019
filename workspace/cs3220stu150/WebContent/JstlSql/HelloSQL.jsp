<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%-- set data source --%>
<sql:setDataSource
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://cs3.calstatela.edu/cs3220stu150"
	user="cs3220stu150"
	password="" />

<%-- query --%>
<%-- <sql:query var="items" sql="SELECT * FROM items"/> --%>
<sql:query var="items">
 SELECT * FROM guestbook
</sql:query>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>JSTL SQL Example</TITLE> </HEAD>


<table border="1">
	<tr>
		<th>Name</th><th>Price</th><th>Quantity</th>
	</tr>
  <c:forEach items="${items.rowsByIndex}" var="row">
    <tr>
    <c:forEach items="${row}" var="col">      
        <td>${col}</td>
    </c:forEach>
    </tr>
  </c:forEach>
</table>

<%-- <table border="1">
  <c:forEach items="${items.rows}" var="row">
    <c:forEach items="${row}" var="col">
      <tr>
        <td>${col.key}</td><td>${col.value}</td>
      </tr>
    </c:forEach>
  </c:forEach>
</table> --%>
    
</BODY>
</HTML>
