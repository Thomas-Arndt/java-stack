<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>All Books</title>
</head>
<body>
	<table class="table mt-4">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Language</th>
				<th>Pages</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${allBooks }">
				<tr>
					<td><c:out value="${book.id }" /></td>
					<td><a href="/books/${book.id }"><c:out value="${book.title }" /></a></td>
					<td><c:out value="${book.language }" /></td>
					<td><c:out value="${book.numberOfPages }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>