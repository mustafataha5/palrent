<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet" />
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/apartmentstyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pannellum/build/pannellum.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/pannellum/build/pannellum.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>

<title>Insert title here</title>
<link rel="stylesheet" href="/css/userinfo.css">
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

	<div class="profile-page my-5">
		<div class="content">
			<div class="content__cover">
				<div class="content__avatar"
					style="background: #0a0a0a url(${user.urlImage}) center center no-repeat; background-size: cover;">
				</div>
				<div class="content__bull"></div>
			</div>
			<div class="content__actions">
				<a href="#"> <span></span></a>
			</div>
			<div class="content__title">
				<h1>${user.firstName}${user.lastName}</h1>
				<span> </span>
			</div>
			<div class="content__description">
				<p>Email: ${user.username}</p>
				<p>Phone: ${user.phone}</p>
			</div>
			<ul class="content__list">
				<li><span># of owned appartment</span>${fn:length(user.ownedDeparment)}</li>

				<li><span>history: ${fn:length(user.booking)}</span> <lu
						class="content__list"> <c:forEach var="book"
						items="${user.booking}">
						<li>
							<div>

								<h3>${book.department.title}</h3>
								<h5>From :${book.startDate}</h5>
								<h5>To :${book.endDate}</h5>
								<p>price: ${book.department.price}</p>
							</div>
						</li>
					</c:forEach> </lu></li>
			</ul>

		</div>
		<div class="bg">
			<div></div>
		</div>
	</div>
		<script type="text/javascript" src="/js/apartment.js"></script>
</body>
</html>