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
    <h1>${product.name}</h1>
    <form action="/products/${product.id}/addCategory" method="post">
        <input type="hidden" name="_method" value="put" />
        <select name="category" id="category">
            <c:forEach var="category" items="${nonProductCategories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Add" />
    </form>
    <h4>-----------------------</h4>
    <h4>Product Categories:</h4>
    <c:forEach var="category" items="${product.categories}">
        <h5>-${category.name}</h5>
    </c:forEach>
</body>
</html>