<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css">
<title>Debtor's Prison</title>
</head>
<body class="p-3">
	<h1>You owe too much, time to lock you up!</h1>
	<form action="/find/gold" method="post">
		<input type="hidden" name="propertyType" value="reset" />
		<input type="submit" value="Reset" class="btn-sm btn-primary" />
	</form>
</body>
</html>