<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="ba" class="models.BeanA" />
<jsp:useBean id="bb" class="models.BeanB" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>BeanA</h3>
<ul>
	<li>id: ${ ba.id }</li>
	<li>name: ${ ba.name }</li>
	<li>weekdays[1]: ${ ba.weekdays[1] }</li>
	<li>weekdays["1"]: ${ ba.weekdays["1"] }</li>
	
	<li>numbers[1]: ${ ba.numbers[1] }</li>
	<li>numbers["1"]: ${ ba.numbers["1"] }</li>
</ul>

<h3>BeanB</h3>
<ul>
	<li>bean0.id: ${ bb.bean0.id }</li>
	<li>bean0.name: ${ bb.bean0.name }</li>
	<li>beans[1].id: ${ bb.beans[1].id }</li>
	<li>beans["1"].name: ${ bb.beans["1"].name }</li>
</ul>

<h3>
	2 + 3/2: ${2+3/2}
</h3>

</body>
</html>