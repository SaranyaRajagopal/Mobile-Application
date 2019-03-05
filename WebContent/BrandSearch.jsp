<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	padding: 10px 24px; /* Some padding */
	cursor: pointer; /* Pointer/hand icon */
	float: left; /* Float the buttons side by side */
}
/* Clear floats (clearfix hack) */
.btn-group:after {
	content: "";
	clear: both;
	display: table;
}

.btn-group

 

button


:not

 

(
:last-child

 

)
{
border-right


:

 

none


; /* Prevent double borders */
}

/* Add a background color on hover */
.btn-group button:hover {
	background-color: #3e8e41;
}
</style>
<body>
	<form method="post" action="ModelServlet">

		<h3>Brand</h3>
		<div class="btn-group">



			<c:forEach var="brand" items="${brand}">
				<button type="submit" name="brand" value="${brand.brand}">${brand.brand}</button>

			</c:forEach>


		</div>
		
	</form>

</body>
</html>