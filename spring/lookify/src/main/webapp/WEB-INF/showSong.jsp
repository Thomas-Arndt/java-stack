<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
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
		<h2>Song Details</h2>
		<a href="/dashboard" class="btn btn-primary">Dashboard</a>
	</div>
	<div class="d-flex flex-column align-items-center mt-3 gap-3">
		<h5>Title: ${song.title }</h5>
		<h5>Artist: ${song.artist }</h5>
		<h5>Rating: ${song.rating }</h5>
		<div class="d-flex justify-content-center gap-2">
			<a href="/songs/edit/${song.id }" class="btn btn-success">Edit</a>
			<form action="/songs/delete/${song.id }" method="post">
				<input type="hidden" name="_method" value="delete" />
				<input type="submit" value="Delete" class="btn btn-danger" />
			</form>
		</div>
	</div>
</body>
</html>