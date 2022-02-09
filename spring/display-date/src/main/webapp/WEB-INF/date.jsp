<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">

<title>Display Date</title>
</head>
<body>
	<h1 class="date"><fmt:formatDate value="${date}" pattern="EEEE', the 'd' of 'MMMM', 'yyyy"/></h1>
	<script type="text/javascript" src="/js/dateScript.js"></script>
</body>
</html>