<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${currentProduct.name}"/></title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
	<div class="col-6 mx-auto my-5">
		<h2>Product: <c:out value="${currentProduct.name}"/></h2>
		<h3>Categories:</h3>
		<ul>
		<c:forEach items="${currentProduct.categories}" var="category">
			<li>${category.name}</li>
		</c:forEach>
		</ul>
		
		<form:form action="/products/${currentProduct.id}" method="post">
			<label>Category:</label>
	        <select name="category_id">
	        	<c:forEach items="${allCategories}" var="category">
			    	<option value="${category.id}"><c:out value="${category.name}" /></option>
			    </c:forEach>
			</select>
			<button class="btn btn-outline-dark">Add Category</button>
		</form:form>
	</div>
</body>
</html>