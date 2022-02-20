<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <div class="d-flex flex-column align-items-center gap-3">
        <div class="d-flex flex-column align-items-center col-8 gap-3 border border-primary rounded-3 p-3 mt-3">
            <h2>Project Details</h2>
            <h5>Project:</h5>
            <p><c:out value="${project.title}" /></p>
            <h5>Description:</h5>
            <p><c:out value="${project.description}" /></p>
            <h5>Due Date:</h5>
            <p><fmt:formatDate pattern="M/dd/yyyy" value="${project.dueDate}" /></p>
            <h5>Project Members:</h5>
            <div>
                <c:forEach var="member" items="${project.users}">
                    <p class="py-0"><c:out value="${member.firstName} ${member.lastName}" /></p>
                </c:forEach>
            </div>
        </div>
        <a href="/projects/${project.id}/tasks" class="btn btn-primary">Project Tasks</a>
    </div>
</body>
</html>