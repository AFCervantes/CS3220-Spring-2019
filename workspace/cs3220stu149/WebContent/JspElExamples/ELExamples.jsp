<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="models.BeanA" id="ba" />
<jsp:useBean class="models.BeanB" id="bb" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>BeanA</p>
<ul>
  <li>id: ${ba.id}</li>
  <li>name: ${ba.name}</li>
  <li>weekdays[1]: ${ba.weekdays[1]}</li>
  <li>weekdays["1"]: ${ba.weekdays["1"]}</li>
  <li>numbers[1]: ${ba.numbers[1]}</li>
  <li>numbers["1"]: ${ba.numbers["1"]}</li>
</ul>

<p>BeanB</p>
<ul>
  <li>bean0.id: ${bb.bean0.id}</li>
  <li>bean0.name: ${bb.bean0.name}</li>
  <li>beans[1].id: ${bb.beans[1].id}</li>
  <li>beans[1].name: ${bb.beans[1].name}</li>
</ul>

<p>2 + 3/2: ${2+3/2}</p>

</body>
</html>

</body>
</html>