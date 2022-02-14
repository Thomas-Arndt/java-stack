<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show</title>
</head>
<body>
	<h1><c:out value="${title }" /></h1>
	<h3>Description: <c:out value="${description }" /></h3>
	<h3>Language: <c:out value="${language }" /></h3>
	<h3>Number of Pages: <c:out value="${numberOfPages }" /></h3>
</body>
</html>