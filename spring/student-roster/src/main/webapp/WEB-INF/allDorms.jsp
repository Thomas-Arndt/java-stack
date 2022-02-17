<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Student Roster</title>
</head>
<body>
    <h1>Dormitories</h1>
    <table class="table table-striped w-50 mx-auto mt-4">
        <thead>
            <tr>
                <th>Name</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="dorm" items="${allDorms}">
                <tr>
                    <td><a href="/dorm/${dorm.id}">${dorm.name}</a></td>
                    <td>
                        <form action="/dorms/delete/${dorm.id }" method="post">
							<input type="hidden" name="_method" value="delete" />
							<input type="submit" value="Delete" class="btn btn-danger py-0 px-1" />
						</form>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td><a href="/dorms/new" class="btn btn-success rounded-circle">+</a></td>
                <td></td>
            </tr>
        </tbody>
    </table>
</body>
</html>