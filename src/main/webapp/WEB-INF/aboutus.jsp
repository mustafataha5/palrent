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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/countup.js/2.0.7/countUp.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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
						<img src="/img/profile.png" alt="Image not found"
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
								onerror="this.src='/img/profile.png';" class="user-icon" />
							<div class="burger-menu" id="user-menu">

								<a href="/user/info/${user.id}">User Info</a> <a
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
    <section id="home">
        <div class="home-left">
            <img src="/img/palrent-logo.png" alt="">
        </div>
        <div class="home-right">
            <h2 class="home-heading"> Growing up with team </h2>
            <p class="home-para">Growing up with a dedicated and supportive team by our side, we've navigated countless hurdles, collaborated on ideas, and pooled our strengths to create a project that reflects our collective efforts and achievements.</p>
         
        </div>
    </section>
   
    <section id="workFlow">
    <h2 class="heading"> Face Challenges </h2>
    <p class="para">Facing challenges head-on has been a cornerstone of our journey together, where each obstacle became an opportunity to innovate, problem-solve, and strengthen our bonds as a cohesive team. Through perseverance and shared determination, we've not only overcome hurdles but also cultivated a resilient spirit that defines our project's success.</p>
    <div class="num-container">
        <div class="num-item"><span id="count1"><i class="fas fa-users"></i> 300 <br> Users</span></div>
        <div class="num-item"><span id="count2"><i class="fas fa-percentage"></i> 90% <br> Rental</span></div>
        <div class="num-item"><span id="count3"><i class="fas fa-eye"></i> 1200 <br> Views</span></div>
        <div class="num-item"><span id="count4"><i class="fas fa-building"></i> 3600 <br> Apartments</span></div>
    </div>
</section>
   
        <div class="goal-left">
            <h2>Our Goal</h2>
           
            <ul>
                <li>Enhance User Experience </li>
                <li> Increase Conversion Rates</li>
                <li>Expand Property Listings and Reach</li>
            </ul>
           
        </div>
       <!--  <div class="goal-right">
            <img src="https://e0.pxfuel.com/wallpapers/574/541/desktop-wallpaper-interior-mockup-vectors-stock-psd-minimal-interior.jpg" alt="">
        </div> -->
    </section>

    <section id="our-Team">
        <h2>Our Team</h2>
        <div class="teamContainer">
            <div class="team-item">
                <img src="/img/ibrahim.jpg" alt="">
                <h5 class="member-name">Ibrahim Khalil</h5>
       
            </div>
            <div class="team-item">
                <img src="/img/tabakhna.png" alt="">
                <h5 class="member-name">Mohammad Tabakhna</h5>
              
            </div>
            <div class="team-item">
                <img src="/img/mustafa.png" alt="">
                <h5 class="member-name">Mustafa Taha</h5>
             
            </div>
            <div class="team-item">
                <img src="/img/laith.png" alt="">
                <h5 class="member-name">Laith Amer</h5>
              
            </div>
        </div>
    </section>

    <footer class="m-4 p-3">
        <p> &copy;  2024 Apartment Rental. All rights reserved</p>
    </footer>
   

    <script type="text/javascript" src="/js/aboutus.js"></script>
</body>
</html>