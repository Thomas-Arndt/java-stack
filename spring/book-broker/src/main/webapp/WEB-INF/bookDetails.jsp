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
<body class="d-flex flex-column align-items-center">
    <div class="d-flex align-items-center justify-content-between w-100 border-bottom p-2">
        <h1>Book Details: ${book.title}</h1>
        <a href="/books" class="btn btn-primary">Dashboard</a>
    </div>
    <div class="d-flex flex-column align-items-center border border-primary rounded-3 p-3 mt-3 gap-3">
        <c:choose>
            <c:when test="${book.creator.id == uuid}" >
                <h4><span class="text-danger">You</span> read</h4>
            </c:when>
            <c:otherwise >
                <h4><span class="text-danger">${book.creator.firstName}</span> read</h4>
            </c:otherwise>
        </c:choose>
        <h4><span class="text-primary">${book.title}</span> by <span class="text-success">${book.author}</span></h4>
        <c:choose>
            <c:when test="${book.creator.id == uuid}" >
                <h6>Here are your thoughts...</h6>
            </c:when>
            <c:otherwise >
                <h6>Here are ${book.creator.firstName}'s thoughts...</h6>
            </c:otherwise>
        </c:choose>
        <p class="border rounded-3 p-3">${book.thoughts}</p>
        <c:choose>
            <c:when test="${book.creator.id == uuid}" >
                <a href="/books/${book.id}/edit" class="btn btn-primary">Edit</a>
            </c:when>
        </c:choose>
    </div>
</body>
</html>