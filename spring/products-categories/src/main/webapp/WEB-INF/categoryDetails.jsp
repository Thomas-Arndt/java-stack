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
    <h1>${category.name}</h1>
    <form action="/categories/${category.id}/addProduct" method="post">
        <input type="hidden" name="_method" value="put" />
        <select name="product" id="product">
            <c:forEach var="product" items="${nonCategoryProducts}">
                <option value="${product.id}">${product.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Add" />
    </form>
    <h4>-----------------------</h4>
    <h4>Products in Category:</h4>
    <c:forEach var="product" items="${category.products}">
        <h5>-${product.name}</h5>
    </c:forEach>
</body>
</html>