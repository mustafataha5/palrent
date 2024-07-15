
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact us page</title>
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/contactus.css">
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
<div class="panorama-container">
    <div id="panorama"></div>
</div>

<<div class="navbar">
		<div class="logo">
			<a href="/"><img src="img/palrent-logo.png" alt="Logo"></a>
		</div>
		<div class="hamburger-menu" onclick="toggleMenu()">
			<i class="fas fa-bars"></i>
		</div>
		<ul class="nav-links">
			<li><a href="/">Home</a></li>
			<li><a href="/about">About us</a></li>
			<li><a href="/contactus">Contact us</a></li>
			<c:if test="${user != null}">
				<li><a href="/user/info/${user.id}">User</a></li>
			</c:if>
		</ul>

		<c:choose>
			<c:when test="${ user == null}">
				<div class="user-icon-container">
					<div class="user-icon-wrapper">
						<img src="img.png" alt="Image not found"
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
							<img src="${user.urlImage}" alt="Image not found"
								onerror="this.src='img/profile.png';" class="user-icon" />
							<div class="burger-menu" id="user-menu">

								<a href="/userinfo/${user.id}">User Info</a> <a
									href="/user/apartment">Apartment</a>
								<form id="logoutForm" method="POST" action="/logout">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" /> <input type="submit"
										value="Logout!" />
								</form>
							</div>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

<div class="overlay-text">Contact Us</div>
<div class="contact-form-container">
  
    <div class="call-to-action">Leave us a message</div>
    <form id="contactForm" class="contact-form" method="post" action="/submit">
        <div class="form-group">
            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" required>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" required>
        </div>
           <div class="form-group">
            <input type="email" class="form-control" id="email" name="Email" placeholder="Email" required>
        </div>
        <div class="form-group">
            <textarea class="form-control" id="message" name="message" rows="5" placeholder="Your Message" required></textarea>
        </div>
        <button type="submit" class="btn ">Send a Message</button>
    </form>
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

<script type="text/javascript" src="/js/contactus.js"></script>
</body>
</html>
