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
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/register.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
						<img src="user-image" alt="Image not found"
							onerror="this.src='img/profile.png';" class="user-icon" />
						<div class="burger-menu" id="user-menu">
							<a href="/new-apartment" >New apartment</a> 
							<a href="/logout">Log out</a>
						</div>
					</div>
				</div>

				</div>

			</c:otherwise>
		</c:choose>
	</div>
   

    <!-- Registration Form Section -->
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h2 class="card-title text-center">Register</h2>
                        <form id="register-form" action="/user/new" method="post">
                            <div class="form-group">
                                <label for="firstName">First Name</label>
                                <input type="text" class="form-control" id="firstName" name="firstName" required>
                            </div>
                            <div class="form-group">
                                <label for="lastName">Last Name</label>
                                <input type="text" class="form-control" id="lastName" name="lastName" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <div class="form-group">
                                <label for="confirmPassword">Confirm Password</label>
                                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Register</button>
                        </form>
                        <div class="text-center mt-3">
                            <p>Already have an account? <a href="/login">Login here</a></p>
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
  
</body>
</html>