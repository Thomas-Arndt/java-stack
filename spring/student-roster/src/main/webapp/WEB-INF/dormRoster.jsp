<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1>${currentDorm.name} Dormitory</h1>
    <form action="/students/assign" method="post">
        <input type="hidden" name="_method" value="put" />
        <input type="hidden" name="dormId" value="${currentDorm.id}" />
        <select name="studentId" id="studentId">
            <c:forEach var="student" items="${allStudents}">
                <option value="${student.id}">
                    <c:out value="${student.firstName} ${student.lastName}" />
                </option>
            </c:forEach>
        </select>
        <input type="submit" value="Assign" />
    </form>

    
    <a href="/students/new">Create Student</a>
    <h4>Assigned Students</h4>
    <table class="table table-striped w-50 mx-auto mt-3">
        <thead>
            <tr>
                <th>Student</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${currentDorm.students}">
                <tr>
                    <td>${student.firstName} ${student.lastName}</td>
                    <td>
                        <form action="/students/remove" method="post">
                            <input type="hidden" name="_method" value="put" />
                            <input type="hidden" name="dormId" value="${currentDorm.id}" />
                            <input type="hidden" name="studentId" value="${student.id}" />
                            <input type="submit" value="Remove" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

