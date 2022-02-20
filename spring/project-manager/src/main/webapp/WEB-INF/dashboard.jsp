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
        <a href="/logout" class="btn btn-danger" >Logout</a>
    </div>
    <div class="d-flex flex-column align-items-center col-8 gap-3 border border-primary rounded-3 p-3 mt-3 mx-auto">
        <h2>All Projects</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Project</th>
                    <th>Team Lead</th>
                    <th>Due Date</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="project" items="${availableProjects}">
                    <tr>
                        <td><a href="/projects/${project.id}"><c:out value="${project.title}" /></a></td>
                        <td><c:out value="${project.lead.firstName}" /></td>
                        <td><fmt:formatDate type="date" pattern="MMM dd" value="${project.dueDate}" /></td>
                        <td>
                            <form action="/projects/${project.id}/join" method="post">
                                <input type="hidden" name="_method" value="put" >
                                <input type="submit" value="Join Team" class="btn btn-primary px-1 py-0" >
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td><a href="/projects/new" class="btn btn-success rounded-circle mx-3" >+</a></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="d-flex flex-column align-items-center col-8 gap-3 border border-primary rounded-3 p-3 mt-3 mx-auto">
        <h2>Your Projects</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Project</th>
                    <th>Team Lead</th>
                    <th>Due Date</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="project" items="${user.projects}">
                    <tr>
                        <td><a href="/projects/${project.id}"><c:out value="${project.title}" /></a></td>
                        <td><c:out value="${project.lead.firstName}" /></td>
                        <td><fmt:formatDate type="date" pattern="MMM dd" value="${project.dueDate}" /></td>
                        <td>
                            <c:choose>
                                <c:when test="${project.lead.id == user.id}" >
                                    <a href="/projects/edit/${project.id}" class="btn btn-success px-1 py-0">Edit</a>
                                </c:when>
                                <c:otherwise >
                                    <form action="/projects/${project.id}/leave" method="post">
                                        <input type="hidden" name="_method" value="put" >
                                        <input type="submit" value="Leave Team" class="btn btn-primary px-1 py-0" >
                                    </form>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>