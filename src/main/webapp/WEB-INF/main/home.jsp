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
		<c:choose>
			<c:when test="${ userId == null}">
				<div class="user-icon-container">
					<div class="user-icon-wrapper">
						<img src="user-image" alt="Image not found"
							onerror="this.src='img/profile.png';" class="user-icon" />
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
						<img src="user-image" alt="Image not found" onerror="this.src='img/profile.png';" class="user-icon" />
						<div class="burger-menu" id="user-menu">
			
						    <a href="/userinfo" >User Info</a>
							<a href="user/apartment" > apartment</a> 
							<a href="/logout"> Log out</a>

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
			<input type="text" id="location" placeholder="Location"> 
			<input type="date" id="checkin" placeholder="Check-in "> 
			<input type="date" id="checkout" placeholder="Check-out"> 
			<input type="number" id="guests" placeholder="Number of Guests">
			<button id="search-btn">Search</button>
		</div>
		<div class="call-to-action">
			<p>Explore our top-rated apartments now!</p>
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

	<script type="text/javascript" src="/js/home.js"></script>
</body>
</html>
