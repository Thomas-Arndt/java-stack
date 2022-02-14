<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Edit Expense</title>
</head>
<body>
	<h1>Edit Expense</h1>
	<form:form action="/expenses/edit/${expense.id }" method="put" modelAttribute="expense" class="d-flex flex-column align-items-center col-6 gap-3">
		<div class="d-flex flex-column" >
			<form:input path="name" class="form-control" />
			<form:errors path="name" class="alert alert-danger py-1 text-center"/>
		</div>
		<div class="d-flex flex-column" >
			<form:input path="vendor" class="form-control" />
			<form:errors path="vendor" class="alert alert-danger py-1 text-center"/>
		</div>
		<div class="d-flex flex-column" >
			<form:input type="number" step="0.01" path="price" class="form-control" />
			<form:errors path="price" class="alert alert-danger py-1 text-center"/>
		</div>
		<div class="d-flex flex-column" >
			<form:textarea path="description" cols="30" rows="5" />
			<form:errors path="description" class="alert alert-danger py-1 text-center"/>
		</div>
		<div class="d-flex justify-content-center gap-3">
			<a href="/" class="btn-sm btn-primary text-decoration-none" >Back</a>
			<input type="submit" value="Submit" class="btn-sm btn-success" />
		</div>
	</form:form>
</body>
</html>