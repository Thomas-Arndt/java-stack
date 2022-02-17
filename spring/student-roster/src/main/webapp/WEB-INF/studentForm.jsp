<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Student Roster</title>
</head>
<body>
    <h1>Creeate a New Student</h1>
    <form:form action="/students" method="post" modelAttribute="student" >
        <form:input path="firstName" placeholder="First name" />
        <form:errors path="firstName" />
        <form:input path="lastName" placeholder="Last Name" />
        <form:errors path="lastName" />
        <input type="submit" value="Create Student">
    </form:form>
</body>
</html>