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
<title>Edit Language</title>
</head>
<body class="d-flex flex-column align-items-center py-4">
	<h1>Edit Language Details</h1>
	<form:form action="/languages/${language.id }" method="post" modelAttribute="language" class="d-flex flex-column align-items-center col-6 gap-3">
		<input type="hidden" name="_method" value="put" /> 
		<div class="d-flex flex-column" >
			<form:input path="name" placeholder="Language Name" class="form-control" />
			<form:errors path="name" class="alert alert-danger py-1 text-center"/>
		</div>
		<div class="d-flex flex-column" >
			<form:input path="creator" placeholder="Creator" class="form-control" />
			<form:errors path="creator" class="alert alert-danger py-1 text-center"/>
		</div>
		<div class="d-flex flex-column" >
			<form:input path="version" placeholder="Version" class="form-control" />
			<form:errors path="version" class="alert alert-danger py-1 text-center"/>
		</div>
		<input type="submit" value="Submit" />
	</form:form>
	<div class="d-flex justify-content-center gap-3 mt-3">
		<a href="/languages" class="btn btn-primary">Back</a>
		<form action="/languages/delete/${language.id }" method="post">
			<input type="hidden" name="_method" value="delete" />
			<input type="submit" value="Delete" class="btn btn-danger" />
		</form>
	</div>
</body>
</html>