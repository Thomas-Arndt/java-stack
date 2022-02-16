<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
    <h1 class="text-center mt-4">Create New Dojo</h1>
    <form:form action="/dojos" method="post" modelAttribute="dojo" class="d-flex flex-column align-items-center mx-auto mt-3 col-6 gap-3">
		<div class="d-flex flex-column" >
			<form:input path="name" placeholder="Dojo Name" class="form-control" />
			<form:errors path="name" class="alert alert-danger py-1 text-center"/>
		</div>
		<input type="submit" value="Add Dojo" class="btn btn-success" />
	</form:form>
</body>
</html>