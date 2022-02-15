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
	<div class="d-flex justify-content-between align-items-center border-bottom px-3 mt-2">
		<h1>Lookify</h1>
		<form action="/search" method="post" class="d-flex align-items-center gap-1">
			<input type="text" name="searchQuery" value="${songsByArtist.get(0).getArtist() }" class="form-control" />
			<input type="submit" value="New Search" class="btn btn-primary" />
		</form>
		<a href="/dashboard" class="btn btn-primary">Dashboard</a>
	</div>
	<h2 class="text-center mt-3">Songs by <c:out value="${songsByArtist.get(0).getArtist() }"/></h2>
	<table class="table table-striped w-75 mx-auto mt-3">
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="song" items="${songsByArtist }">
				<tr>
					<td><c:out value="${song.title }"></c:out></td>
					<td><c:out value="${song.rating }"></c:out></td>
					<td class="d-flex justify-content-center gap-2">
					<a href="/songs/edit/${song.id }" class="btn btn-success py-0 px-1">Edit</a>
						<form action="/songs/delete/${song.id }" method="post">
							<input type="hidden" name="_method" value="delete" />
							<input type="submit" value="Delete" class="btn btn-danger py-0 px-1" />
						</form>
					</td>
				</tr>
			</c:forEach>		
		</tbody>
	</table>
</body>
</html>