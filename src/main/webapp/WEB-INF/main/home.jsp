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
<title>PalRen</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/pannellum/build/pannellum.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/pannellum/build/pannellum.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="navbar">
		<div class="logo">
			<img src="img/palrent-logo.png" alt="Logo">
		</div>
		<div class="hamburger-menu" onclick="toggleMenu()">
			<i class="fas fa-bars"></i>
		</div>
		<ul class="nav-links">
			<li><a href="#">About us</a></li>
			<li><a href="#">Contact us</a></li>
			<li><a href="#">User</a></li>
		</ul>
		<!-- 	<div class="user-icon-container">
			<div class="user-icon-wrapper">
				<img src="user-image" alt="Image not found"
					onerror="this.src='img/profile.png';" class="user-icon" />
				<div class="burger-menu" id="user-menu">
					<a href="#" id="register-btn">Register</a> <a href="#"
						id="login-btn">Log In</a>
				</div>
			</div>
		</div> -->
		<c:choose>
			<c:when test="${ userId == null}">
				<div class="user-icon-container">
					<div class="user-icon-wrapper">
						<img src="user-image" alt="Image not found"
							onerror="this.src='img/profile.png';" class="user-icon" />
						<div class="burger-menu" id="user-menu">
							<a href="#" id="register-btn">Register</a> <a href="#"
								id="login-btn">Log In</a>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="d-flex align-items-center mx-3">
					<h4 class="text-light mx-2">${user.firstName}</h4>
					<div class="user-icon-container">
					<div class="user-icon-wrapper">
						<img src="user-image" alt="Image not found" onerror="this.src='img/profile.png';" class="user-icon" />
						<div class="burger-menu" id="user-menu">
						    <a href="/userinfo" >User Info</a>
							<a href="/apartment/new" >Booking</a>
							 <a href="/apartment/new" >Create Apartment</a>
							 <a href="/logout" >LogOut</a>
						</div>
					</div>
				</div>

				</div>

			</c:otherwise>
		</c:choose>
	</div>
	<div class="panorama-container">
		<div id="panorama"></div>
		<div class="overlay-text">
			<h1>Find Your Perfect Stay, Anytime, Anywhere</h1>
		</div>
		<div class="search-bar">
			<input type="text" id="location" placeholder="Location"> <input
				type="date" id="checkin" placeholder="Check-in "> <input
				type="date" id="checkout" placeholder="Check-out"> <input
				type="number" id="guests" placeholder="Number of Guests">
			<button id="search-btn">Search</button>
		</div>
		<div class="call-to-action">
			<p>Explore our top-rated apartments now!</p>
		</div>
	</div>
	<footer>
		<div class="social-icons">
			<a href="#"><i class="fab fa-facebook-f"></i></a> <a href="#"><i
				class="fab fa-instagram"></i></a> <a href="#"><i
				class="fab fa-linkedin-in"></i></a> <a href="#"><i
				class="fab fa-whatsapp"></i></a>
		</div>
		<p>&copy; 2024 Apartment Rental. All rights reserved.</p>
	</footer>

	<div class="blur-bg-overlay"></div>
	<div class="form-popup">
		<div class="form-box login">
			<div class="form-details">
				<h2>Welcome Back</h2>
				<p>Please log in using your personal information to stay
					connected with us.</p>
			</div>
			<span class="close-btn">&times;</span>
			<div class="form-content">
				<h2>LOGIN</h2>
				<c:if test="${ userId == null }">
					<form:form action="/user/login" method="post"
						modelAttribute="newLogin">
						<div class="input-field">
							<form:input path="email" placeholder="Enter your Email" />
							<form:errors path="email" cssClass="error" />
						</div>
						<div class="input-field">
							<form:input path="password" type="password"
								placeholder="Enter your Password" />
							<form:errors path="password" cssClass="error" />
						</div>
						<button type="submit">Log In</button>
					</form:form>
				</c:if>
				<div class="bottom-link">
					Don't have an account? <a href="#" id="signup-link">Signup</a>
				</div>
			</div>
		</div>

		<div class="form-box signup">
			<div class="form-details">
				<h2>Create Account</h2>
				<p>To become a part of our community, please sign up using your
					personal information.</p>
			</div>
			<span class="close-btn">&times;</span>
			<div class="form-content">
				<h2>SIGNUP</h2>
				<form:form action="/user/new" method="post" modelAttribute="newUser">
					<div class="input-field">
						<%-- <form:label path="firstName">First Name:</form:label> --%>
						<form:input path="firstName" placeholder="First Name:" />
						<form:errors path="firstName" cssClass="error" />
					</div>
					<div class="input-field">
						<%-- <form:label path="lastName">Last Name:</form:label> --%>
						<form:input path="lastName" placeholder="Last Name:" />
						<form:errors path="lastName" cssClass="error" />
					</div>
					<div class="input-field">
						<%-- <form:label path="email">Email:</form:label> --%>
						<form:input path="email" placeholder="Email:" />
						<form:errors path="email" cssClass="error" />
					</div>
					<div class="input-field">
						<%-- <form:label path="password">Password:</form:label> --%>
						<form:input type="password" path="password"
							placeholder="Password:" />
						<form:errors path="password" cssClass="error" />
					</div>
					<div class="input-field">
						<%-- <form:label path="confirm">Confirm PW:</form:label> --%>
						<form:input type="password" path="confirm"
							placeholder="Confirm PW:" />
						<form:errors path="confirm" cssClass="error" />
					</div>
					<div class="input-field">
						<%-- <form:label path="phone">Phone:</form:label> --%>
						<form:input path="phone" placeholder="Phone:" />
						<form:errors path="phone" cssClass="error" />
					</div>
					<div class="input-field">
						<%-- <form:label path="dateOfBirth">Date Of Birth:</form:label> --%>
						<form:input type="date" path="dateOfBirth" />
						<form:errors path="dateOfBirth" cssClass="error" />
					</div>
					<div class="input-field">
						<%-- <form:label path="urlImage">Url Image:</form:label> --%>
						<form:input path="urlImage" />
						<form:errors path="urlImage" cssClass="error" />
					</div>
					<div class="policy-text">
						<input type="checkbox" id="policy"> <label for="policy">
							I agree to the <a href="#" class="option">Terms & Conditions</a>
						</label>
					</div>
					<button type="submit">Sign Up</button>
				</form:form>
				<div class="bottom-link">
					Already have an account? <a href="#" id="login-link">Login</a>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="/js/home.js"></script>
</body>
</html>
