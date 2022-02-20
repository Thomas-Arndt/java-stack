<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <div class="d-flex flex-column align-items-center gap-3">
        <div class="d-flex flex-column align-items-center col-8 gap-3 border border-primary rounded-3 p-3 mt-3 mx-auto">
            <h2><c:out value="${project.title}" /></h2>
            <h5>Project Lead: <c:out value="${project.lead.firstName}" /></h5>
            <form:form action="/projects/${project.id}/tasks" method="post" modelAttribute="task" >
                <div>
                    <form:label path="description">Add a task ticket for this team:</form:label>
                    <form:textarea path="description" cols="30" rows="5" class="form-control"></form:textarea>
                    <form:errors path="description" class="alert alert-danger py-1 text-center" />
                </div>
                <input type="submit" value="Submit" class="btn btn-success mt-3" />
            </form:form>
            <div>
                <h5 class="text-center border-bottom">All Tasks:</h5>
                <c:forEach var="task" items="${project.tasks}">
                    <div>
                        <h6>-- Added by <c:out value="${task.creator.firstName}" /> at <fmt:formatDate type="both" pattern="KK:mm a MMM dd" value="${task.createdAt}" /> --</h6>
                        <p class="text-center"><c:out value="${task.description}" /></p>
                    </div>
                </c:forEach>
            </div>
        </div>
        <a href="/projects/${project.id}" class="btn btn-primary">Back</a>
    </div>
</body>
</html>