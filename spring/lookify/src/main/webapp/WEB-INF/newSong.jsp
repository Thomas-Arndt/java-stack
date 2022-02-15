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
<title>Lookify</title>
</head>
<body>
	<div class="d-flex justify-content-between align-items-center border-bottom px-3 mt-2" >
		<h1>Lookify</h1>
		<h2>Add a New Song</h2>
		<a href="/dashboard" class="btn btn-primary">Dashboard</a>
	</div>
	<form:form action="/songs" method="post" modelAttribute="song" class="d-flex flex-column align-items-center mx-auto mt-3 col-6 gap-3">
		<div class="d-flex flex-column" >
			<form:input path="title" placeholder="Song Name" class="form-control" />
			<form:errors path="title" class="alert alert-danger py-1 text-center"/>
		</div>
		<div class="d-flex flex-column" >
			<form:input path="artist" placeholder="Artist" class="form-control" />
			<form:errors path="artist" class="alert alert-danger py-1 text-center"/>
		</div>
		<div class="d-flex flex-column" >
			<form:input path="rating" placeholder="Rating" class="form-control" />
			<form:errors path="rating" class="alert alert-danger py-1 text-center"/>
		</div>
		<input type="submit" value="Add Song" class="btn btn-success" />
	</form:form>
</body>
</html>