<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hopper's Receipt</title>
</head>
<body>
	<h1>Customer Name: <c:out value="${customerName}"/></h1>
	<h4>Item Name: <c:out value="${itemName}"></c:out></h4>
	<h4>Price: <fmt:formatNumber value="${price}" type="currency"/></h4>
	<h4>Description: <c:out value="${description}"></c:out></h4>
	<h4>Vendor: <c:out value="${vendor}"></c:out></h4>
</body>
</html>