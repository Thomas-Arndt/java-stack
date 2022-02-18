<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Book Club</title>
</head>
<body class="d-flex flex-column align-items-center">
    <div class="d-flex flex-column align-items-center border border-primary rounded-3 shadow gap-3 p-3 mt-5">
        <h1>Login</h1>
        <form:form action="/login" method="post" modelAttribute="loginUser" class="d-flex flex-column align-items-center gap-3">
            <div class="d-flex flex-column">
                <form:input path="email" placeholder="Email" class="form-control" />
                <form:errors path="email" class="alert alert-danger py-0 text-center" />
            </div>
            <div class="d-flex flex-column">
                <form:input path="password" type="password" placeholder="Password" class="form-control" />
                <form:errors path="password" class="alert alert-danger py-0 text-center" />
            </div>
            <input type="submit" value="Login" class="btn btn-primary" />
        </form:form>
        <p>Not registered yet? <a href="/register">Register</a></p>
    </div>
</body>
</html>