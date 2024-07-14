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
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/aboutus.css">
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
								onerror="this.src='img/profile.png';" class="user-icon" />
							<div class="burger-menu" id="user-menu">

								<a href="/userinfo/${user.id}">User Info</a> <a
									href="user/apartment">Apartment</a>
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
    <section id="home">
        <div class="home-left">
            <img src="palrent-logo.png" alt="">
        </div>
        <div class="home-right">
            <h2 class="home-heading"> Grow Up Your Workflow Speed </h2>
            <p class="home-para">Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta quibusdam blanditiis
                quas assumenda nam error vel dolores suscipit ad, sapiente deleniti ipsum, obcaecati perspiciatis.</p>
         
        </div>
    </section>
   
    <section id="workFlow">
        <h2 class="heading"> Grow Up Your Workflow Speed. </h2>
        <p class="para">Lorem ipsum dolor sit amet consectetur adipisicing elit. A, commodi sint. <br>Ipsam molestias
            nemovel laboriosam consequatur, perferendis<br> minima soluta? Natus necessitatibus autem suscipit!</p>
        <div class="num-container">
            <div class="num-item"><span>27,882 <br>Customers</span></div>
            <div class="num-item"><span>90% <br>Action Plans</span></div>
            <div class="num-item"><span>70,592 <br>Downloads</span></div>
        </div>
    </section>
   
        <div class="goal-left">
            <h2>Our Goal</h2>
           
            <ul>
                <li>Enhance Property Management</li>
                <li> Provide Comprehensive Property Information</li>
                <li>Strengthen Marketing and Outreach:</li>
            </ul>
           
        </div>
        <div class="goal-right">
            <img src="https://e0.pxfuel.com/wallpapers/574/541/desktop-wallpaper-interior-mockup-vectors-stock-psd-minimal-interior.jpg" alt="">
        </div>
    </section>

    <section id="our-Team">
        <h2>Our Member</h2>
        <div class="teamContainer">
            <div class="team-item">
                <img src="./ibrahim.jpg" alt="">
                <h5 class="member-name">Ibeahim Khalil</h5>
       
            </div>
            <div class="team-item">
                <img src="./ibrahim.jpg" alt="">
                <h5 class="member-name">Mohammad Tabakhna</h5>
              
            </div>
            <div class="team-item">
                <img src="./ibrahim.jpg" alt="">
                <h5 class="member-name">Mustafa Taha</h5>
             
            </div>
            <div class="team-item">
                <img src="./ibrahim.jpg" alt="">
                <h5 class="member-name">Laith Amer</h5>
              
            </div>
        </div>
    </section>

    <footer>
        <p> &copy; 2022 - All rights reserved - geekshelp.in</p>
    </footer>
   

    
</body>
</html>