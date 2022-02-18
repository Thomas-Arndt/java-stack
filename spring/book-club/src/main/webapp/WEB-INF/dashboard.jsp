<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Book Club</title>
</head>
<body>
    <div class="d-flex align-items-center justify-content-between border-bottom p-2">
        <div class="d-flex align-items-center gap-3">
            <h1>Welcome, ${user.firstName}!</h1>
            <a href="/books/new" class="btn btn-success">Add a Book</a>
        </div>
        <a href="/logout" class="btn btn-danger">Logout</a>
    </div>
    <table class="table table-striped w-75 mx-auto mt-3">
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Added By</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${allBooks}">
                <tr>
                    <td>${book.id}</td>
                    <td><a href="/books/${book.id}">${book.title}</a></td>
                    <td>${book.author}</td>
                    <td>${book.user.firstName} ${book.user.lastName}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>