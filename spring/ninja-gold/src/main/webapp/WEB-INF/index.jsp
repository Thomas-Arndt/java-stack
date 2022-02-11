<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css">


<title>Ninja Gold</title>
</head>
<body class="p-3">
	<div class="d-flex align-items-center gap-2">
		<h5 class="m-0">Your Gold</h5>
		<h5 class="border border-dark m-0 p-1">${gold}</h5>
		<form action="/find/gold" method="post">
			<input type="hidden" name="propertyType" value="reset" />
			<input type="submit" value="Reset" class="btn-sm btn-primary" />
		</form>
	</div>
	<div class="d-flex align-items-center justify-content-center gap-3 mt-4">
		<form action="/find/gold" method="post" class="d-flex flex-column align-items-center border p-2 gap-3">
			<h4>Farm</h4>
			<p>(earns 10-20 gold)</p>
			<input type="hidden" name="propertyType" value="farm" />
			<input type="submit" value="Find Gold!" class="btn-sm btn-warning" />
		</form>
		<form action="/find/gold" method="post" class="d-flex flex-column align-items-center border p-2 gap-3">
			<h4>Cave</h4>
			<p>(earns 5-10 gold)</p>
			<input type="hidden" name="propertyType" value="cave" />
			<input type="submit" value="Find Gold!" class="btn-sm btn-warning" />
		</form>
		<form action="/find/gold" method="post" class="d-flex flex-column align-items-center border p-2 gap-3">
			<h4>House</h4>
			<p>(earns 2-5 gold)</p>
			<input type="hidden" name="propertyType" value="house" />
			<input type="submit" value="Find Gold!" class="btn-sm btn-warning" />
		</form>
		<form action="/find/gold" method="post" class="d-flex flex-column align-items-center border p-2 gap-3">
			<h4>Casino!</h4>
			<p>(earns/takes 0-50 gold)</p>
			<input type="hidden" name="propertyType" value="casino" />
			<input type="submit" value="Find Gold!" class="btn-sm btn-warning" />
		</form>
		<form action="/find/gold" method="post" class="d-flex flex-column align-items-center border p-2 gap-3">
			<h4>Spa</h4>
			<p>(spend 5-20 gold)</p>
			<input type="hidden" name="propertyType" value="spa" />
			<input type="submit" value="Relax" class="btn-sm btn-warning" />
		</form>
	</div>
	<h4 class="mt-4">Activity</h4>
	<div class="w-100 border activity overflow-auto">
		<c:forEach var="event" items="${activity}">
			<p class="m-0"><c:out value="${event}"></c:out></p>
		</c:forEach>
	</div>
</body>
</html>