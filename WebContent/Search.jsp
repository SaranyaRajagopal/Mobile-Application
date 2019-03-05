<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.btn-group button {
  background-color: #4CAF50; /* Green background */
  border: 1px solid green; /* Green border */
  color: white; /* White text */
  padding: 10px 10px; /* Some padding */
  cursor: pointer; /* Pointer/hand icon */
  width: 15%; /* Set a width if needed */
  display: block; /* Make the buttons appear below each other */
}

.btn-group button:not(:last-child) {
  border-bottom: none; /* Prevent double borders */
}

/* Add a background color on hover */
.btn-group button:hover {
  background-color: #3e8e41;
}
body
{
align: center;
}
</style>
<body>
<form method="post" action="SearchServlet">

<h2>Model</h2>
<div class="btn-group">

<c:forEach var ="model" items="${model}">

<button type="submit" name="model" value="${model.model}">${model.model}</button><br>
</c:forEach>
</div>
				

			</form>

</body>
</html>