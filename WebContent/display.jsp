<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>

</head>

<body align="center">
<form method="post" action="DisplayProduct">
<table  class="table table-hover" style="width:80%" align="center">
		<thead>
		<tr  class="table-primary">
			<th>ProductId</th>
			<th>Brand</th>
			<th>Model</th>
			<th>Price</th>
            <th>Processor</th>
            <th>Memory</th>
		</tr>
		</thead>
	<tr>
	<h3 text align ="center"> Your Order has been confirmed... </h3>
	</tr>
	<c:forEach var="showproduct" items= "${sessionScope.PRODUCT}" >
	<tr  class="table-success" align="center">
		<td>${showproduct.id}</td>
		<td>${showproduct.brand}</td>
		<td>${showproduct.model}</td>
		<td>${showproduct.price}</td>
		<td>${showproduct.processor}</td>
		<td>${showproduct.memory}</td>
	</tr>
	</c:forEach>
<tr>
</tr>

</table>
	<button type="button" class="btn btn-danger">
		<a href="Logout" style="color:white;">Logout</a>
	</button>
</form>
</body>
</html>