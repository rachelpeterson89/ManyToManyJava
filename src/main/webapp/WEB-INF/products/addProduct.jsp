<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
	<div class="col-4 mx-auto my-5">
		<form:form action="/add/products/new" method="post" modelAttribute="product" class="">
			<h2 class="text-center">Add A Product:</h2>
			<input type="hidden" name="_method" value="post" />
			<div class="form-group">
				<form:label path="name">Name:</form:label>
				<form:errors path="name" />
				<form:input path="name" type="text" name="name" class="form-control" />
			</div>
			
			<div class="form-group">
				<form:label path="description">Description:</form:label>
				<form:errors path="description" />
				<form:input path="description" type="text" name="description" class="form-control" />
			</div>
			
			<div class="form-group">
				<form:label path="price">Price:</form:label>
				<form:errors path="price" />
				<form:input path="price" type="number" name="price" class="form-control" />
			</div>
			
			<div class="d-flex justify-content-end">
				<button class="btn btn-outline-dark">Create Product</button>
			</div>
		</form:form>
		
	</div>
	
</body>
</html>