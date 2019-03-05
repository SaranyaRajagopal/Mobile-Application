<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
</head>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
<body><form method="post" action="SuccessServlet">
<table  class="table table-hover" style="width:80%" align="center">
		<thead>
		<tr  class="table-primary" align="center">
			<th>ProductId</th>
			<th>Brand</th>
			<th>Model</th>
			<th>Price</th>
            <th>Processor</th>
            <th>Memory</th>
		</tr>
		</thead>
	
	<c:forEach var="showproduct" items= "${sessionScope.PRODUCT}" >
	<tr  class="table-success" align="center">
		<td>${showproduct.id}</td>
		<td>${showproduct.brand}</td>
		<td>${showproduct.model}</td>
		<td>${showproduct.price}</td>
		<td>${showproduct.processor}</td>
		<td>${showproduct.memory}</td>
		<td><button type="submit">Buy</button></td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</form>
<h2>${MESSAGE}</h2>

</body>
</html>