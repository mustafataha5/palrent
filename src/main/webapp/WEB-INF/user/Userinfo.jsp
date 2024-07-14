<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Information</title>
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/userinfo.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/pannellum/build/pannellum.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/pannellum/build/pannellum.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
</head>
<body>
	<div class="navbar">
		<div class="logo">
			<a href="/"><img src="/img/palrent-logo.png" alt="Logo"></a>
		</div>
		<div class="hamburger-menu" onclick="toggleMenu()">
			<i class="fas fa-bars"></i>
		</div>
		<ul class="nav-links">
			<li><a href="/">Home</a></li>
			<li><a href="/about">About us</a></li>
			<li><a href="/contact">Contact us</a></li>
			<li><a href="/user">User</a></li>
		</ul>
		<c:choose>
			<c:when test="${user == null}">
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
									href="/user/apartment">Apartment</a> <a href="/logout">Log
									out</a>
							</div>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="profile-page">
		<div class="content">
			<div class="content__cover">
				<div class="content__avatar"
					style="background: #0a0a0a url(${user.urlImage}) center center no-repeat; background-size: cover;">
				</div>
			</div>
			<div class="content__info">
				<h1 class="content__title">${user.firstName}${user.lastName}</h1>
				<div class="content__details">
					<p>
						<i class="fas fa-envelope"></i> Email: ${user.username}
					</p>
					<p>
						<i class="fas fa-phone"></i> Phone: ${user.phone}
					</p>
					<p>
						<i class="fas fa-building"></i> Apartments Owned:
						${fn:length(user.ownedDeparment)}
					</p>
				</div>

			</div>

		</div>
		<div class="booking-history-container">
			<h2 class="content__subtitle">Booking History</h2>
			<div class="booking-history">
				<div class="booking-history__list">
					<!-- Booking history items will go here -->
					<c:forEach var="book" items="${user.booking}">
						<div class="booking-history__item">
							<div class="booking-details">
								<div class="booking-details__content">
									<h3>${book.department.title}</h3>
									<p>From: ${book.startDate}</p>
									<p>To: ${book.endDate}</p>
									<p>Price: ${book.department.price}</p>
								</div>
								<div class="booking-details__action">
									<a href="/user/booking/${book.id}" class="btn-more">More</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
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
	<script type="text/javascript" src="/js/userinfo.js"></script>
</body>
</html>
