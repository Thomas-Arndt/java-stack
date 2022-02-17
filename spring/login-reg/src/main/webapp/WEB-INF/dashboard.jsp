<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body class="d-flex flex-column align-items-center pt-5">
    <h1>Welcome, ${user.firstName}</h1>
    <h5>This is your dashboard. Pretty cool, huh?</h5>
    <a href="/logout" class="btn btn-danger" >Logout</a>
</body>
</html>