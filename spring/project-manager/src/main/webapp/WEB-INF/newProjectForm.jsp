<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Project Manager</title>
</head>
<body>
    <div class="d-flex justify-content-between align-items-center border-bottom p-2 px-3">
        <h1>Welcome, <c:out value="${user.firstName}" /></h1>
        <div class="d-flex gap-3">
            <a href="/dashboard" class="btn btn-primary" >Dashboard</a>
            <a href="/logout" class="btn btn-danger" >Logout</a>
        </div>
    </div>
    <div class="d-flex flex-column align-items-center col-8 gap-3 border border-primary rounded-3 p-3 mt-3 mx-auto">
        <h2>Create A New Project</h2>
        <form:form action="/projects/new" method="post" modelAttribute="project" >
            <div class="d-flex flex-column">
                <form:label path="title">Project Title:</form:label>
                <form:input path="title" class="form-control" />
                <form:errors path="title" class="alert alert-danger py-1 text-center" />
            </div>
            <div class="d-flex flex-column mt-3">
                <form:label path="description">Project Description:</form:label>
                <form:textarea path="description" cols="30" rows="5" class="form-control" ></form:textarea>
                <form:errors path="description" class="alert alert-danger py-1 text-center" />
            </div>
            <div class="d-flex flex-column my-3">
                <form:label path="dueDate">Due Date:</form:label>
                <form:input type="date" path="dueDate" class="form-control" />
                <form:errors path="dueDate" class="alert alert-danger py-1 text-center" />
            </div>
            <input type="submit" value="Create" class="btn btn-success" />
        </form:form>
    </div>
</body>
</html>