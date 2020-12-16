<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
	<div class="col-4 mx-auto my-5">
		<form:form action="/add/categories/new" method="post" modelAttribute="category" class="">
			<h2 class="text-center">Add A Category:</h2>
			<input type="hidden" name="_method" value="post" />
			<div class="form-group">
				<form:label path="name">Name:</form:label>
				<form:errors path="name" />
				<form:input path="name" type="text" name="name" class="form-control" />
			</div>
			
			<div class="d-flex justify-content-end">
				<button class="btn btn-outline-dark">Create Category</button>
			</div>
		</form:form>
		
	</div>
	
</body>
</html>