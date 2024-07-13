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
<link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet" />
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pannellum/build/pannellum.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/pannellum/build/pannellum.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
</head>
<body>
    <div class="navbar">
        <div class="logo">
            <a href="/"><img src="img/palrent-logo.png" alt="Logo"></a>
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
                        <img src="img.png" alt="Image not found"
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
                            <img src="user-image" alt="Image not found"
                                onerror="this.src='img/profile.png';" class="user-icon" />
                            <div class="burger-menu" id="user-menu">
                                <a href="/userinfo/${user.id}">User Info</a>
                                <a href="user/apartment">Apartment</a>
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
    <div class="panorama-container">
        <div id="panorama"></div>
        <div class="overlay-text">
            <h1>Find Your Perfect Stay, Anytime, Anywhere</h1>
        </div>
        <form action="/search" method="post">
            <div class="search-bar">
                <select class="p-3" id="city" name="city">
                    <option value="">Select Location</option>
                    <c:forEach var="cit" items="${cities}">
                        <option value="${cit}">${cit}</option>
                    </c:forEach>
                </select>
                <input type="date" id="checkin" name="start" placeholder="Check-in">
                <input type="date" id="checkout" name="end" placeholder="Check-out">
                <input type="number" id="guests" name="guest" placeholder="Number of Guests">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <button id="search" type="button">Search</button>
            </div>
        </form>
        <div class="my-5 call-to-action">
            <p class="error">${error}</p>
            <p>Explore our top-rated apartments now!</p>
        </div>
    </div>
    <div id="slider" class="cards" style="display:none;">
        <c:forEach var="apartment" items="${apartments}">
            <div class="card">
                <img src="${apartment.images[0].url}" alt="Apartment Image">
                <div class="card-body">
                    <h4>${apartment.title}</h4>
                    <p>${apartment.city}, ${apartment.street}, ${apartment.buildingNum}</p>
                    <a href="/apartment/${apartment.id}/show" class="btn btn-primary">View Details</a>
                </div>
            </div>
        </c:forEach>
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
    <script type="text/javascript" src="/js/searchByAjax.js"></script>
</body>
</html>
