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
    <div class="d-flex flex-column align-items-center mt-3">
        <h5>The stacks:</h5>
        <table class="table table-striped w-75 mx-auto">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Owner</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${allBooks}">
                    <tr>
                        <td>${book.id}</td>
                        <td><a href="/books/${book.id}">${book.title}</a></td>
                        <td>${book.author}</td>
                        <td>${book.creator.firstName} ${book.creator.lastName}</td>
                        <td>
                            <c:choose>
                                <c:when test="${book.creator.id == user.id}" >
                                    <div class="d-flex gap-1">
                                        <a href="/books/${book.id}/edit" class="btn btn-primary py-0 px-1">Edit</a>
                                        <form action="/books/${book.id}/delete" method="post">
                                            <input type="hidden" name="_method" value="delete" />
                                            <input type="submit" value="Delete" class="btn btn-danger py-0 px-1" />
                                        </form>                                    
                                    </div>
                                </c:when>
                                <c:otherwise >
                                    <form action="/books/checkout" method="post">
                                        <input type="hidden" name="_method" value="put" />
                                        <input type="hidden" name="bookId" value="${book.id}" />
                                        <input type="submit" value="Check Out" class="btn btn-primary py-0 px-1" />
                                    </form>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <c:if test="${user.borrowedBooks.size() != 0}">
        <div class="d-flex flex-column align-items-center mt-5">
            <h5>Books you have checked out:</h5>
            <table class="table table-striped w-75 mx-auto">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Owner</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${user.borrowedBooks}">
                        <tr>
                            <td>${book.id}</td>
                            <td><a href="/books/${book.id}">${book.title}</a></td>
                            <td>${book.author}</td>
                            <td>${book.creator.firstName} ${book.creator.lastName}</td>
                            <td>
                                <form action="/books/return" method="post">
                                    <input type="hidden" name="_method" value="put" />
                                    <input type="hidden" name="bookId" value="${book.id}" />
                                    <input type="submit" value="Return" class="btn btn-primary py-0 px-1" />
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
</body>
</html>