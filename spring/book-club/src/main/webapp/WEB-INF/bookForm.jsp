<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Book Club</title>
</head>
<body class="d-flex flex-column align-items-center">
    <div class="d-flex align-items-center justify-content-between w-100 border-bottom p-2">
        <h1>Add a Book to Your Shelf</h1>
        <a href="/books" class="btn btn-primary">Dashboard</a>
    </div>
    <form:form action="/books/new" method="post" modelAttribute="book" class="d-flex flex-column align-items-center border border-primary rounded-3 shadow gap-3 p-3 mt-3">
        <div class="d-flex flex-column">
            <form:input path="title" placeholder="Title" class="form-control" />
            <form:errors path="title" class="alert alert-danger p-1 text-center" />
        </div>
        <div class="d-flex flex-column">
            <form:input path="author" placeholder="Author" class="form-control" />
            <form:errors path="author" class="alert alert-danger p-1 text-center" />
        </div>
        <div class="d-flex flex-column">
            <form:textarea path="thoughts" cols="30" rows="5" placeholder="Your thoughts..." class="form-control" ></form:textarea>
            <form:errors path="thoughts" class="alert alert-danger p-1 text-center" />
        </div>
        <input type="submit" value="Place on the Shelf" class="btn btn-success" />
    </form:form>
</body>
</html>