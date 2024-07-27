<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register - PalRen</title>
<link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/register.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pannellum/build/pannellum.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/pannellum/build/pannellum.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="panorama-container">
		<div id="panorama"></div>
	</div>

	<div class="navbar">
		<div class="logo">
			<a href="/"> <img src="/img/palrent-logo.png" alt="Logo"></a>
		</div>
		<div class="hamburger-menu" onclick="toggleMenu()">
			<i class="fas fa-bars"></i>
		</div>
		<ul class="nav-links">
			<li><a href="/">Home</a></li>
			<li><a href="#">About us</a></li>
			<li><a href="/contactus">Contact us</a></li>
			<li><a href="#">User</a></li>
		</ul>

		<c:choose>
			<c:when test="${ user == null}">
				<div class="user-icon-container">
					<div class="user-icon-wrapper">
						<img src="/img.png" alt="Image not found" onerror="this.src='/img/profile.png';" class="user-icon" />
						<div class="burger-menu" id="user-menu">
							<a href="/register" id="register-btn">Register</a>
							<a href="/login" id="login-btn">Log In</a>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="d-flex align-items-center mx-3">
					<h4 class="text-light mx-2">${user.firstName}</h4>
					<div class="user-icon-container">
						<div class="user-icon-wrapper">
							<img src="${user.urlImage}" alt="Image not found" onerror="this.src='/img/profile.png';" class="user-icon" />
							<div class="burger-menu" id="user-menu">
								<a href="/userinfo/${user.id}">User Info</a>
								<a href="/user/apartment">Apartment</a>
								<form id="logoutForm" method="POST" action="/logout">
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									<input type="submit" value="Logout!" />
								</form>
							</div>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<!-- Registration Form Section -->
	<div class="registration-form">
		<div class="container mt-5">
			<div class="row justify-content-center align-items-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-body">
							<h2 class="card-title text-center">Register</h2>
							<form:form action="/register" method="post" modelAttribute="newUser">
								<p class="error"><form:errors path="firstName" cssClass="error"/></p>
								<p class="error"><form:errors path="lastName" cssClass="error"/></p>
								<p class="error"><form:errors path="username" cssClass="error"/></p>
								<p class="error"><form:errors path="password" cssClass="error"/></p>
								<p class="error"><form:errors path="confirm" cssClass="error"/></p>
								<p class="error"><form:errors path="phone" cssClass="error"/></p>
								<p class="error"><form:errors path="dateOfBirth" cssClass="error"/></p>
								<p class="error"><form:errors path="urlImage" cssClass="error"/></p>
								<table class="table">
									<tbody>
										<tr>
											<td><form:label path="firstName">First Name:</form:label></td>
											<td><form:input path="firstName" /></td>
										</tr>
										<tr>
											<td><form:label path="lastName">Last Name:</form:label></td>
											<td><form:input path="lastName" /></td>
										</tr>
										<tr>
											<td><form:label path="username">Email:</form:label></td>
											<td><form:input path="username" /></td>
										</tr>
										<tr>
											<td><form:label path="password">Password:</form:label></td>
											<td><form:input type="password" path="password" /></td>
										</tr>
										<tr>
											<td><form:label path="confirm">Confirm PW:</form:label></td>
											<td><form:input type="password" path="confirm" /></td>
										</tr>
										<tr>
											<td><form:label path="phone">Phone:</form:label></td>
											<td><form:input path="phone" /></td>
										</tr>
										<tr>
											<td><form:label path="dateOfBirth">Date Of Birth:</form:label></td>
											<td><form:input type="date" path="dateOfBirth" /></td>
										</tr>
										<%-- <tr>
											<td><form:label path="urlImage">Url Image:</form:label></td>
											<td><form:input path="urlImage" /></td>
										</tr> --%>
										<tr>
											<td></td>
											<td>
												<button type="submit" class="btn btn-outline-primary">
													Create User
												</button>
											</td>
										</tr>
									</tbody>
								</table>
							</form:form>
							<div class="text-center mt-3">
								<p>Already have an account? <a href="/login">Login here</a></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer>
		<div class="social-icons">
			<a href="#"><i class="fab fa-facebook-f"></i></a>
			<a href="#"><i class="fab fa-instagram"></i></a>
			<a href="#"><i class="fab fa-linkedin-in"></i></a>
			<a href="#"><i class="fab fa-whatsapp"></i></a>
		</div>
		<p>&copy; 2024 Apartment Rental. All rights reserved.</p>
	</footer>
	<script type="text/javascript" src="/js/register.js"></script>
</body>
</html>
