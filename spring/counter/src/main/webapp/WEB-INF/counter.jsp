<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Count</title>
</head>
<body>
	<h1><c:out value="${count}"></c:out></h1>
	<a href="/">Test Another Visit</a>
	<a href="/counter/2">Add Two</a>
	<a href="/reset">Reset Count</a>
</body>
</html>