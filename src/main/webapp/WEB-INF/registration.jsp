<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
	crossorigin="anonymous"></script>
<title>Registration Page</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="/">TV Shows</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="/login">Login</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/registration">Registration</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container mt-3">
		<div class="mt-3 text-center">
			<form:errors path="user.*" />
		</div>

		<h1>Register</h1>

		<form:form method="POST" action="/registration" modelAttribute="user">
			<div class="form-group">
				<form:label path="username">Username:</form:label>
				<form:input path="username" type="text" class="form-control" placeholder="Username" />
			</div>
			
			<div class="form-group">
				<form:label path="email">Email:</form:label>
				<form:input path="email" class="form-control" placeholder="Email" />
				<small id="emailHelp" class="form-text text-muted">We'll never share you email with anyone else</small>
			</div>
			
			<div class="form-group">
				<form:label path="password">Password:</form:label>
				<form:password path="password" class="form-control" placeholder="Password" />
			</div>
			
			<div class="form-group">
				<form:label path="passwordConfirmation">Password Confirmation:</form:label>
				<form:password path="passwordConfirmation" class="form-control" placeholder="Password Confirmation" />
			</div>
			<input type="submit" class="btn btn-primary" value="Register!"/>


		</form:form>

	</div>


</body>