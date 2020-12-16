<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${currentCategory.name}"/></title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
	<div class="col-6 mx-auto my-5">
		<h2>Category: <c:out value="${currentCategory.name}"/></h2>
		<h3>Products:</h3>
		<ul>
		<c:forEach items="${currentCategory.products}" var="product">
			<li>${product.name}</li>
		</c:forEach>
		</ul>
		
		<form:form action="/categories/${currentCategory.id}" method="post">
			<label>Product:</label>
	        <select name="product_id">
	        	<c:forEach items="${allProducts}" var="product">
			    <option value="${product.id}"><c:out value="${product.name}" /></option>
			    </c:forEach>
			</select>
			<button class="btn btn-outline-dark">Add Product</button>
		</form:form>
	</div>
</body>
</html>