<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Lookify</title>
</head>
<body>
	<div class="d-flex justify-content-between align-items-center border-bottom px-3 mt-2">
		<h1>Lookify</h1>
		<a href="/search/topTen" class="btn btn-primary text-nowrap">Top Ten</a>
		<form action="/search" method="get" class="d-flex align-items-center gap-1">
			<input type="text" name="searchQuery" placeholder="Search" class="form-control" />
			<input type="submit" value="Search Artists" class="btn btn-primary" />
		</form>
	</div>
	<table class="table table-striped w-75 mx-auto mt-3">
		<thead>
			<tr>
				<th>Song Name</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="song" items="${allSongs }">
				<tr>
					<td><a href="/songs/${song.id }"><c:out value="${song.title }" /></a></td>
					<td><c:out value="${song.rating }" /></td>
					<td class="d-flex justify-content-center gap-2">
					<a href="/songs/edit/${song.id }" class="btn btn-success py-0 px-1">Edit</a>
						<form action="/songs/delete/${song.id }" method="post">
							<input type="hidden" name="_method" value="delete" />
							<input type="submit" value="Delete" class="btn btn-danger py-0 px-1" />
						</form>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td><a href="/songs/new" class="btn btn-success rounded-circle">+</a></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</body>
</html>