<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/pannellum/build/pannellum.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/pannellum/build/pannellum.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>User Apartment</title>

</head>
<body>

	<div class="navbar">
		<div class="logo">
			<a href="/"> <img src="/img/palrent-logo.png" alt="Logo"></a>
		</div>
		<div class="hamburger-menu" onclick="toggleMenu()">
			<i class="fas fa-bars"></i>
		</div>
		<ul class="nav-links">
			<li><a href="#">About us</a></li>
			<li><a href="#">Contact us</a></li>
			<li><a href="#">User</a></li>
		</ul>
		<c:choose>
			<c:when test="${ user == null}">
				<div class="user-icon-container">
					<div class="user-icon-wrapper">
						<img src="user-image" alt="Image not found"
							onerror="this.src='img/profile.png';" class="user-icon" />
						<div class="burger-menu" id="user-menu">
							<a href="/register" id="register-btn">Register</a> <a
								href="/login" id="login-btn">Log In</a>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="d-flex align-items-center mx-3">
					<h4 class="text-light mx-2">${user.firstName}</h4>
					<div class="user-icon-container">
						<div class="user-icon-wrapper">
							<img src="user-image" alt="Image not found"
								onerror="this.src='/img/profile.png';" class="user-icon" />
							<div class="burger-menu" id="user-menu">

								<a href="/userinfo/${user.id}">User Info</a> <a
									href="/user/apartment"> apartment</a> <a href="/logout">
									Log out</a>

							</div>
						</div>
					</div>

				</div>

			</c:otherwise>
		</c:choose>
	</div>


	<div class="row d-flex justify-content-center mx-5 mt-5 my-5">
		<div class="col-ld-11 my-5">
			<div class="card border-light ">
				<div class="d-flex justify-content-between my-5">
					<h4 class="card-title mx-3">My Apartment</h4>
					<a href="/"><h4
							class="card-title mx-3 btn btn-outline-primary ">Go back</h4></a>
				</div>

				<div class="my-4">
					<a href="apartment/new" class=" btn btn-outline-primary"> + New
						Apartment </a>
				</div>
			</div>
		</div>
	</div>

	<div class="row mx-5 ">
		<c:forEach var="apartment" items="${user.ownedDeparment}">
			<div class="col-3 my-3">
				<div class="card" style="width: 18rem;">

					<img alt="not work" src="${ apartment.images[0].url}">
					<div class="card-body ">

						<h1>${apartment.title}</h1>
						<p>description : ${ apartment.description}</p>

						<div class="d-flex justify-content-center"" >
						 
							<a href="/user/apartment/${apartment.id}/edit"
								class="mx-3 btn btn-outline-warning btn-sm">Edit</a> 
							<form action="/user/apartment/${apartment.id}/delete"
								method="post">
								<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
								<input type="hidden" name="_method" value="delete">
								<button type="submit" class="btn btn-outline-danger btn-sm">Del</button>
							</form>

						</div>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>


	<script type="text/javascript" src="/js/apartment.js"></script>
</body>
</html>