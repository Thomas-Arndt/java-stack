<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Safe Travels</title>
</head>
<body class="d-flex flex-column align-items-center gap-4">
	<h1>Safe Travels</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${allExpenses }">
				<tr>
					<td><a href="/expenses/${expense.id }"><c:out value="${expense.name }"/></a></td>
					<td><c:out value="${expense.vendor }"/></td>
					<td><fmt:formatNumber type="CURRENCY" value="${expense.price }"/></td>
					<td class="d-flex gap-1"><a href="/expenses/edit/${expense.id }" class="btn btn-primary p-1 py-0">Edit</a> | 
					<form action="/expenses/delete/${expense.id }" method="post">
						<input type="hidden" name="_method" value="delete" />
						<input type="submit" value="Delete" class="btn btn-danger p-1 py-0" />
					</form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form:form action="/expenses" method="post" modelAttribute="expense" class="d-flex flex-column align-items-center col-6 gap-3">
		<div class="d-flex flex-column" >
			<form:input path="name" placeholder="Expense Name" class="form-control" />
			<form:errors path="name" class="alert alert-danger py-1 text-center"/>
		</div>
		<div class="d-flex flex-column" >
			<form:input path="vendor" placeholder="Vendor" class="form-control" />
			<form:errors path="vendor" class="alert alert-danger py-1 text-center"/>
		</div>
		<div class="d-flex flex-column" >
			<form:input path="price" placeholder="Price" class="form-control" />
			<form:errors path="price" class="alert alert-danger py-1 text-center"/>
		</div>
		<div class="d-flex flex-column" >
			<form:textarea path="description" cols="30" rows="5" placeholder="Description" />
			<form:errors path="description" class="alert alert-danger py-1 text-center"/>
		</div>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>