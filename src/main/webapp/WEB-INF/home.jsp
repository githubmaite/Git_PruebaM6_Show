<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
<title>Home Page</title>
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

<div class="container">
	<div class="py-3">
	
		<h1 class="font-wight-bold">Welcome, <c:out value="${currentUser.username}"></c:out>
		</h1>
	</div>
	<h2>TV shows</h2>
	
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Show</th>
				<th scope="col">Network</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allShows}" var="show">
				<tr>
					<td scoped="row"><a href="/shows/${show.id}" class="text-info font-weight-bold">${show.showTitle}</a></td>
					<td>${show.showNetwork} </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

</body>
</html>


