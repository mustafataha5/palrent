<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>PalRen</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css"><!-- change to match your file/naming structure -->
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/pannellum/build/pannellum.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pannellum/build/pannellum.css">
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
            <li><a href="#">Rent a Car</a></li>
            <li><a href="#">Contact Us</a></li>
            <li><a href="#">User</a></li>
        </ul>
        <div class="user-icon-container">
            <img src="user-image" alt="Image not found" onerror="this.src='/img/profile.png';" class="user-icon" />
            <div class="burger-menu">
                <a href="#">Register</a>
                <a href="#">Log In</a>
            </div>
        </div>
    </div>
    <div class="panorama-container">
        <div id="panorama"></div>
        <div class="search-bar">
            <input type="text" id="location" placeholder="Location">
            <input type="date" id="checkin" placeholder="Check-in Date">
            <input type="date" id="checkout" placeholder="Check-out Date">
            <input type="number" id="guests" placeholder="Number of Guests">
            <button id="search-btn">Search</button>
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
