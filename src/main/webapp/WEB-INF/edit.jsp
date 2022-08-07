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
<title>Edit Show</title>
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
	
		<h1 class="font-wight-bold">
			${editShow.showTitle}
		</h1>
		<form:errors path="show.*"/>
		<div class="text-center">
			<c:if test="${errors != null}">
			<c:out value ="${errors}"></c:out>
			</c:if>
		</div>
		
		<form:form method="POST" action="/shows/${editShow.id}/edit" modelAttribute="editShow">
			<div class="form-group row pt-2">
				<form:label path="showTitle" class="col-sm-2 col-form-label col-form-label-sm">Show Title: </form:label>
				<div class="col-sm-10">
					<form:input type="text" path="showTitle" class="form-control"/>
				</div>
			</div>
			<div class="text-center my-2">
				<small><form:errors path="showTitle"/></small>
			</div>
			<div class="form-group row">
				<form:label path="showNetwork" class="col-sm-2 col-form-label col-form-label-sm">Network: </form:label>
				<div class="col-sm-10">
					<form:input type="text" path="showNetwork" class="form-control"/>
				</div>
			</div>
			<div class="text-center mt-2">
				<small><form:errors path="showNetwork"/></small>
			</div>
			<div class="text-center pt-4">
				<input type="submit" value="Update"	class="btn btn-lg btn-primary"/>			
			</div>
		
		</form:form>
		<c:if test="${currentUser.id == creatorShow.id}">
			<a href="/shows/${editShow.id}/delete" class="btn btn-lg btn-danger">Delete</a>
		</c:if>

</div>

</body>
</html>