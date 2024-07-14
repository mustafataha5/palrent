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
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<title>Admin Apartment</title>
<link rel="stylesheet" href="/css/apartmentstyle.css">
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
        <div class="user-icon-container">
            <img src="user-image" alt="Image not found" onerror="this.src='img/profile.png';" class="user-icon" />
            <div class="burger-menu">
                <a href="#" id="register-btn">Register</a>
                <a href="#" id="login-btn">Log In</a>
            </div>
        </div>
    </div>

    <div class="marginslider">
        <div id="carouselExampleDark" class="carousel carousel-dark slide">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div th:each="image, iterStat : ${departments.images}" th:class="${iterStat.index == 0} ? 'carousel-item active' : 'carousel-item'">
                    <img th:src="@{${image}}" class="d-block w-100" alt="Image" style="max-width: 300px;">
                </div>
            </div>
            <button class="carousel-control-prev ms-3" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next me-3" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>

    <div class="text-center p-2 bg-light border ms-5 me-5 mt-2">
        <h1 class="fw-light p-2" th:text="${departments.title}"></h1>
        <p class="p-2 mt-3" th:text="${department.description}"></p>
    </div>

    <br>

    <div class="row ms-5 me-5 mt-2 text-center d-flex justify-content-start">
        <div class="col-sm-5">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title" th:text="${departments.title}"></h5>
                    <img src="user-image" alt="Image not found" onerror="this.src='img/profile.png';" class="user-icon" />
                    <h6 th:text="'Price: $' + ${departments.price}"></h6>
                </div>
            </div>
        </div>
    </div>

    <div class="row ms-5 me-5 mt-2 text-center d-flex justify-content-start">
        <div class="col-sm-5">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Apartment offers</h5>
                    <ul class="list-group">
                        <li th:each="offer : ${departments.offers}" class="list-group-item" th:text="${offer.name}"></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="col-sm-5">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Apartment rules</h5>
                    <ul class="list-group">
                        <li th:each="rule : ${departments.rules}" class="list-group-item" th:text="${rule.description}"></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>