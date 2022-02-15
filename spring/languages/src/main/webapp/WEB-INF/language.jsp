<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title><c:out value="${language.name }" /></title>
</head>
<body class="d-flex flex-column align-items-center py-4">
	<h1>Language Details</h1>
	<h3><c:out value="${language.name }" /></h3>
	<h5>Created by: <c:out value="${language.creator }" /></h5>
	<h5>Current Version: <c:out value="${language.version }" /></h5>
	<div class="d-flex justify-content-center gap-3 mt-3">
		<a href="/languages" class="btn btn-primary">Back</a>
		<a href="/languages/edit/${language.id }" class="btn btn-success">Edit</a>
		<a href="" class="btn btn-danger">Delete</a>
	</div>
</body>
</html>