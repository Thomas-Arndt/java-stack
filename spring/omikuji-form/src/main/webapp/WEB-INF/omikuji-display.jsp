<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
	<h1 class="text-center mt-3">Here's Your Omikuji!</h1>
	<div  class="d-flex flex-column align-items-center col-6 mt-3 p-3 border mx-auto bg-info">
		<h4>In <span><c:out value="${numberChoice}"></c:out></span>
		years, you will live in <span><c:out value="${city}"></c:out></span>
		with <span><c:out value="${person}"></c:out></span>
		as your roommate, selling <span><c:out value="${occupation}"></c:out></span>
		for a living. The next time you see a <span><c:out value="${thing}"></c:out></span>,
		you will have good luck. Also, <span><c:out value="${message}"></c:out></span>.</h4>
		<a href="/omikuji" class="btn btn-success mt-3">Back</a>
	</div>
</body>
</html>