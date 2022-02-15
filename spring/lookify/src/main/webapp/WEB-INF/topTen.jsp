<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Lookify</title>
</head>
<body>
	<div class="d-flex justify-content-between align-items-center border-bottom px-3 mt-2" >
		<h1>Lookify</h1>
		<h2>Edit Song</h2>
		<a href="/dashboard" class="btn btn-primary">Dashboard</a>
	</div>
	<table class="table table-striped w-75 mx-auto mt-3">
		<thead>
			<tr>
				<th>Rating</th>
				<th>Title</th>
				<th>Artist</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="song" items="${topTen }">
				<tr>
					<td><c:out value="${song.rating }"></c:out></td>
					<td><a href="/songs/${song.id }"><c:out value="${song.title }"></c:out></a></td>
					<td><c:out value="${song.artist }"></c:out></td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
</body>
</html>