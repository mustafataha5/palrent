<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/apartmentstyle.css">
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
			<img src="/img/palrent-logo.png" alt="Logo">
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
			<c:when test="${user == null}">
				<div class="user-icon-container">
					<div class="user-icon-wrapper">
						<img src="img.png" alt="Image not found"
							onerror="this.src='/img/profile.png';" class="user-icon" />
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
								<a href="/user/apartment">Apartment</a> <a href="/logout">Log
									out</a>
							</div>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<!-- <div id="map"></div> -->

	<!-- Your existing HTML content continues below -->
	<div class="apartment-details">
		<div class="details-left">
			<h1 class="title">Beautiful Apartment in City Center</h1>
			<div class="apartment-images">
				<c:forEach var="image" items="${booking.department.images}">
					<img src="${image.url}" alt="Apartment Image 2"
						class="apartment-img">
				</c:forEach>
				<!--  <img src="https://www.thespruce.com/thmb/BpZG-gG2ReQwYpzrQg302pezLr0=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Stocksy_txp3d216bb1tUq300_Medium_4988078-56c96ac19def4bf8ba430cf5063b6b38.jpg" alt="Apartment Image 1" class="apartment-img">
            <img src="https://upload.wikimedia.org/wikipedia/commons/9/97/Studio_apartment.webp" alt="Apartment Image 2" class="apartment-img">
            <img src="https://www.redfin.com/blog/wp-content/uploads/2022/09/spacejoy-xkJ2_THgKmk-unsplash.jpg" alt="Apartment Image 3" class="apartment-img"> -->
			</div>
			<div class="details-right">
				<div class="owner">
					<img src="${booking.department.owner.urlImage}" alt="Owner's Image"
						onerror="this.src='/img/profile.png';" class="owner-img">
					<h3>Owner: ${booking.department.owner.firstName} -
						${booking.department.owner.lastName}</h3>
				</div>

			</div>

			<div class="row d-flex justify-content-center">

				<div class="col-sm-4">
					<div class="card">
						<h3 class="card-title">Make a Reservation</h3>
						<div class="card-body">
							<div class="reservation-form">

								<form action="/user/booking/${booking.id}" method="post">
									<p class="error_q">${error_q}</p>
									<input type="hidden" name="_method" value="patch"> <label
										for="checkin">Check-in Date:</label> <input type="date"
										id="checkin" name="checkin" 
										value="<fmt:formatDate value='${booking.startDate}' pattern='yyyy-MM-dd' />"" required /> 
										<label for="checkout">Check-out Date:</label> <input
										type="date" id="checkout" name="checkout" 
										value="<fmt:formatDate value='${booking.endDate}' pattern='yyyy-MM-dd' />" required> 
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									<button type="submit">Edit Booking</button>
								</form>
								
								<form action="/user/booking/${booking.id}" method="post">
									<input type="hidden" name="_method" value="delete">
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									<button type="submit" class="btn btn-outline-danger" >Delete Booking</button>
								</form>	
							</div>
						</div>
					</div>
				</div>


				<div class="col-sm-4  ">

					<div class="row">
						<div class="card">
							<h3 class="card-title">Rules</h3>
							<div class="card-body">
								<lu> <c:forEach var="rule" items="${booking.department.rules}">
									<li>${ rule.name }</li>
								</c:forEach> </lu>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="card">
							<h3 class="card-title">Offers</h3>
							<div class="card-body">
								<lu> <c:forEach var="offer" items="${booking.department.offers}">
									<li>${ offer.name }</li>
								</c:forEach> </lu>
							</div>
						</div>
					</div>



				</div>




			</div>

			<%-- <div class="offers-rules">
				<div class="rules">
					<h3>Rules</h3>
					<ul>
						<!-- <li>No Smoking</li>
                <li>No Pets</li>
                <li>Check-in after 3 PM</li>
                <li>Check-out before 12:00 PM</li>
                Add more rules as needed -->

						<c:forEach var="rule" items="${apartment.rules}">
							<li>${ rule.name }</li>
						</c:forEach>
					</ul>
				</div>
				<div class="offers">
					<h3>Offers</h3>
					<ul>
						<!-- <li>Free Parking</li>
                <li>Hair Dryer</li>
                <li>Wi-Fi</li> -->
						<!-- Add more offers as needed -->
						<c:forEach var="offer" items="${apartment.offers}">
							<li>${ offer.name }</li>
						</c:forEach>
					</ul>
				</div>--%>
		</div>
	</div>







	<div id="image-popup" class="modal">
		<span class="close-btn">&times;</span> <img class="modal-content"
			id="img01"> <a class="prev" id="prevBtn">&#10094;</a> <a
			class="next" id="nextBtn">&#10095;</a>
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

	<script type="text/javascript" src="/js/department.js"></script>
	<script type="text/javascript" src="/js/dateSkip.js"></script>
</body>
</html>
