<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Roster</title>
</head>
<body>
    <h1>Add New Dormitory</h1>
    <form:form action="/dorms" method="post" modelAttribute="dorm" >
        <form:input path="name" />
        <form:errors path="name" />
        <input type="submit" value="Add" />
    </form:form>
</body>
</html>