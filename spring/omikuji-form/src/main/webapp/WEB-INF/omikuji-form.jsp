<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Omikuji Form</title>
</head>
<body>
	<h1 class="text-center mt-3">Send an Omikuji!</h1>
	<form action="/form/process" method="post" class="col-6 mt-3 p-3 mx-auto border">
		<div class="form-group">
			<label for="numberChoice">Choose a number between 5 and 25...</label>
			<input type="number" name="numberChoice" id="numberChoice" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="city" class="mt-3">Enter the name of any city...</label>
			<input type="text" name="city" id="city" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="person" class="mt-3">Enter the name of any person...</label>
			<input type="text" name="person" id="person" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="occupation" class="mt-3">Enter professional endeavor or hobby...</label>
			<input type="text" name="occupation" id="occupation" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="thing" class="mt-3">Enter any type of living thing...</label>
			<input type="text" name="thing" id="thing" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="message" class="mt-3">Say something nice to someone...</label>
			<textarea cols="30" rows="5" name="message" id="message" class="form-control"/></textarea>
		</div>
		<input type="submit" value="Send" class="btn btn-success mt-3"/>
	</form>
</body>
</html>