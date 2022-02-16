<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Add a Ninja</title>
</head>
<body>
    <h1>New Ninja</h1>
    <form:form action="/ninjas" method="post" modelAttribute="ninja" class="d-flex flex-column align-items-center gap-3 mt-3" >
        <form:select path="dojo" >
            <c:forEach var="dojo" items="${allDojos}">
                <form:option value="${dojo.id}" path="dojo" >
                    <c:out value="${dojo.name}" />
                </form:option>
            </c:forEach>
        </form:select>
        <form:input path="firstName" placeholder="FirstName" />
        <form:errors path="firstName" />
        <form:input path="lastName" placeholder="Last Name" />
        <form:errors path="lastName" />
        <form:input path="age" placeholder="Age" />
        <form:errors path="age" />
        <input type="submit" value="Add Ninja" />
    </form:form>
</body>
</html>