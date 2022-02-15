<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Languages</title>
</head>
<body class="d-flex flex-column align-items-center gap-4">
	<table class="table table-striped">
		<thead>
			<tr>
				<td>Name</td>
				<td>Creator</td>
				<td>Version</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="language" items="${allLanguages }">
				<tr>
					<td><a href="/languages/${language.id }"><c:out value="${language.name }"></c:out></a></td>
					<td><c:out value="${language.creator }"></c:out></td>
					<td><c:out value="${language.version }"></c:out></td>
					<td class="d-flex gap-1">
						<a href="/languages/edit/${language.id }" class="btn btn-primary p-0 py-0">Edit</a> |
						<form action="/languages/delete/${language.id }" method="post">
							<input type="hidden" name="_method" value="delete" />
							<input type="submit" value="Delete" class="btn btn-danger p-0 py-0" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form:form action="/languages" method="post" modelAttribute="language" class="d-flex flex-column align-items-center col-6 gap-3">
		<div class="d-flex flex-column" >
			<form:input path="name" placeholder="Language Name" class="form-control" />
			<form:errors path="name" class="alert alert-danger py-1 text-center"/>
		</div>
		<div class="d-flex flex-column" >
			<form:input path="creator" placeholder="Creator" class="form-control" />
			<form:errors path="creator" class="alert alert-danger py-1 text-center"/>
		</div>
		<div class="d-flex flex-column" >
			<form:input path="version" placeholder="Version" class="form-control" />
			<form:errors path="version" class="alert alert-danger py-1 text-center"/>
		</div>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>