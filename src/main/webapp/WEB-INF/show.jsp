<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
<title>Show details</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/">TV Shows</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="/shows/new">Add a Show</a>
      </li>
      <li class="nav-item">
      	<form id="logoutForm" method="POST" action="/logout">
      		<input type="hidden" name="${_csrf.parameterName}"
      		value="${_csrf.token}"/>
      		<input type="submit" value="Logout" class="btn btn-link text-secondary"/>
      	</form>
      </li>
    </ul>
  </div>
</nav>

<div class="container mt-3">
	
		<h1>Title: ${show.showTitle}</h1>
		<h2>Network: ${show.showNetwork}</h2>
		<h2 class="font-wight-bold">Users who rated this show</h2>
		
		<table class="table table-dark">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Rating</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${showRatings}">
						<tr>
							<td scope="row">${row.user.username}</td>
							<td>${row.rating}</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<c:if test="${currentUser.id == creatorShow.id}">
			<a href="/shows/${show.id}/edit" class="btn btn-info">Edit</a>
		</c:if>
		<br>
		<br>
		

		<form:form method="POST" action="/shows/${show.id}/add" modelAttribute="addRating">
			<form:hidden path="user.id" value="${currentUser.id}"/>
			<div class="form-inline">
				<form:label path="rating">Leave a rating: </form:label>
				<div class="mx-3">
					<form:input type="number" min="1" max="5" path="rating" class="form-control"/>
					<form:errors path="rating"/>
				</div>
				<div class="">
					<input type="submit" value="Rate!" class="btn btn-primary"/>
				</div>
			</div>
		</form:form>
		
		<div class="mt-5 pb-5">
			<a href="/shows" class="btn btn-dark">Go Back</a>
		</div>

</div>

</body>
</html>