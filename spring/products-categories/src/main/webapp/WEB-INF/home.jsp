<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products and Categories</title>
</head>
<body>
    <a href="/products">New Product</a>
    <a href="/categories">New Category</a>
    <h4>Products</h4>
    <c:forEach var="product" items="${allProducts}">
        <a href="/products/${product.id}">${product.name}</a>
    </c:forEach>
    <h4>-------------------</h4>
    <h4>Categories</h4>
    <c:forEach var="category" items="${allCategories}">
        <a href="/categories/${category.id}">${category.name}</a>
    </c:forEach>
</body>
</html>