<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Expense - <c:out value="${expense.name }" /></title>
</head>
<body class="d-flex flex-column align-items-center py-4">
	<h1>Expense Details</h1>
	<h5>Name: <c:out value="${expense.name }" /></h5>
	<h5>Vendor: <c:out value="${expense.vendor }" /></h5>
	<h5>Price: <fmt:formatNumber type="CURRENCY" value="${expense.price }" /></h5>
	<h5>Description: <c:out value="${expense.description }" /></h5>
	<a href="/" class="btn-sm btn-primary text-decoration-none" >Back</a>
</body>
</html>