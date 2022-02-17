<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Login/Registration</title>
</head>
<body class="d-flex gap-5 p-5">
    <div class="d-flex flex-column gap-3">
        <h2>Register</h2>
        <form:form action="/register" method="post" modelAttribute="newUser" class="d-flex flex-column align-items-center gap-3">
            <div class="d-flex flex-column">
                <form:label path="firstName">First Name</form:label>
                <form:input path="firstName" />
                <form:errors path="firstName" />
            </div>
            <div class="d-flex flex-column">
                <form:label path="lastName">Last Name</form:label>
                <form:input path="lastName" />
                <form:errors path="lastName" />
            </div>
            <div class="d-flex flex-column">
                <form:label path="email">Email</form:label>
                <form:input path="email" />
                <form:errors path="email" />
            </div>
            <div class="d-flex flex-column">
                <form:label path="password">Password</form:label>
                <form:input path="password" />
                <form:errors path="password" />
            </div>
            <div class="d-flex flex-column">
                <form:label path="confirm">Confirm Password</form:label>
                <form:input path="confirm" />
                <form:errors path="confirm" />
            </div>
            <input type="submit" value="Register" />
        </form:form>
    </div>
    <div class="d-flex flex-column gap-3">
        <h2>Login</h2>
        <form:form action="/login" method="post" modelAttribute="newLogin" class="d-flex flex-column align-items-center gap-3" >
            <div class="d-flex flex-column">
                <form:label path="email">Email</form:label>
                <form:input path="email" />
                <form:errors path="email" />
            </div>
            <div class="d-flex flex-column">
                <form:label path="password">Password</form:label>
                <form:input path="password" />
                <form:errors path="password" />
            </div>
            <input type="submit" value="Login" />
        </form:form>
    </div>
</body>
</html>