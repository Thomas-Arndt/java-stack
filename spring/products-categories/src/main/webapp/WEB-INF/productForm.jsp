<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products and Categories</title>
</head>
<body>
    <h1>New Product</h1>
    <form:form action="/products" method="post" modelAttribute="product" >
        <form:input path="name" />
        <input type="submit" value="Create" />
    </form:form>
    <a href="/home">Home</a>
</body>
</html>