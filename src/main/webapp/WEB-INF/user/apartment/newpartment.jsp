<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Apartment</title>
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
								onerror="this.src='img/profile.png';" class="user-icon" />
							<div class="burger-menu" id="user-menu">

								<a href="/userinfo/${user.id}">User Info</a> <a
									href="user/apartment"> apartment</a>
								<!-- <a href="/logout"> Log out</a> -->

								<form id="logoutForm" method="POST" action="/logout">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" /> <input type="submit" value="Logout!" />
								</form>

							</div>
						</div>
					</div>

				</div>

			</c:otherwise>
		</c:choose>
	</div>

	<div class="row d-flex justify-content-center mx-5 mt-5 my-4">
		<div class="col-md-8">
			<div class="card border-light">

				<div class="d-flex justify-content-between my-5 ">
					<h4 class="card-title mx-3">New A Apartment</h4>
					<a href="/user/apartment"><h4
							class="card-title mx-3 btn btn-outline-primary ">Go back</h4></a>
				</div>
				<div class="card-body">


					<form:form action="/user/apartment/new" method="post"
						modelAttribute="Apartment">


						<p class="error">
							<form:errors path="numOfRoom"></form:errors>
						</p>
						<p class="error">
							<form:errors path="numOfBath"></form:errors>
						</p>
						<p class="error">
							<form:errors path="numOfBed"></form:errors>
						</p>
						<p class="error">
							<form:errors path="area"></form:errors>
						</p>
						<p lass="error">
							<form:errors path="numOfGuest"></form:errors>
						</p>
						<%-- <p class="error">
							<form:errors path="approval"></form:errors>
						</p> --%>
						<p lass="error">
							<form:errors path="price"></form:errors>
						</p>
						<p class="error">
							<form:errors path="departmentNum"></form:errors>
						</p>
						<p class="error">
							<form:errors path="buildingNum"></form:errors>
						</p>
						<p class="error">
							<form:errors path="street"></form:errors>
						</p>
						<p class="error">
							<form:errors path="city"></form:errors>
						</p>
						<p class="error">
							<form:errors path="title"></form:errors>
						</p>
						<p class="error">
							<form:errors path="description"></form:errors>
						</p>
						<table class="table">
							<tbody>
								<tr>
									<td><form:label path="numOfRoom">Number Of Rooms:</form:label></td>
									<td><form:input type="number" value="1" min="1"
											path="numOfRoom" /></td>
								</tr>
								<tr>
									<td><form:label path="numOfBath">Number Of Baths:</form:label></td>
									<td><form:input type="number" value="1" min="1"
											path="numOfBath" /></td>
								</tr>
								<tr>
									<td><form:label path="numOfBed">Number Of Beds:</form:label></td>
									<td><form:input type="number" value="1" min="1"
											path="numOfBed" /></td>
								</tr>
								<tr>
									<td><form:label path="area">Apartment Space:</form:label></td>
									<td><form:input path="area" type="number" value="1"
											min="1" /></td>
								</tr>
								<tr>
									<td><form:label path="numOfGuest">Number Of Guests:</form:label></td>
									<td><form:input path="numOfGuest" type="number" value="1"
											min="1" /></td>
								</tr>
								<%-- <tr>
									<td><form:label path="approval">Approval:</form:label></td>
									<td><form:select path="approval">
									<form:option value="false" >False</form:option>
									<form:option value="true">True</form:option>
									</form:select> </td>
								</tr> --%>
								<tr>
									<td><form:label path="price">Price:</form:label></td>
									<td><form:input type="double" value="1" path="price" /></td>
								</tr>

								<tr>
									<td><form:label path="">address:</form:label></td>
									<td><form:input type="text" path="departmentNum"
											placeholder="department number" /> <form:input type="text"
											path="buildingNum" placeholder="Building Number" /> <form:input
											type="text" path="street" placeholder="Street" /> 
											<form:select path="city">
											<form:option value="0">Select City</form:option>
											<c:forEach var="cit" items="${cities}">
												<form:option value="${cit}">${ cit}</form:option>
											</c:forEach>

										</form:select></td>
					

								</tr>
								<tr>
									<td><form:label path="title">Title:</form:label></td>
									<td><form:input type="text" path="title" /></td>
								</tr>
								<tr>
									<td><form:label path="description">Description:</form:label></td>
									<td><form:input type="text" path="description" /></td>
								</tr>

								<tr>
									<td></td>
									<td>
										<button type="submit" class="btn w-25 btn-outline-primary">
											Create Apartment</button>
									</td>
								</tr>

							</tbody>
						</table>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/js/apartment.js"></script>
</body>
</html>