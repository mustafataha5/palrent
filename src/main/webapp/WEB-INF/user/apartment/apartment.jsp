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

<title>User Apartment</title>

</head>
<body>




	<div class="row d-flex justify-content-center mx-5 mt-3">
		<div class="col-ld-11">
			<div class="card border-light ">
				<div class="d-flex justify-content-between my-2">
					<h4 class="card-title mx-3">My Apartment</h4>
					<a href="/"><h4 class="card-title mx-3 btn btn-outline-secondary ">Go back</h4></a>
				</div>
				<div class="card-body">
					<table class="table  text-center">
						<thead class="table-primary">
							<th>Id</th>
							<th>Number Of Rooms</th>
							<th>Number Of Baths</th>
							<th>Number Of Beds</th>
							<th>Apartment Space</th>
							<th>Number Of Guests</th>
							<th>Approval</th>
							<th>$ Price</th>
							<th>Action</th>
						</thead>
						<tbody>
							<c:forEach var="apartment" items="${user.ownedDeparment}">
								<tr>
									<td id="apartmentcart">${apartment.id}</td>
									<td>${apartment.numOfRoom}</td>
									<td>${apartment.numOfBath}</td>
									<td>${apartment.numOfBed}</td>
									<td>${apartment.area}</td>
									<td>${apartment.numOfGuest}</td>
									<td>${apartment.approval}</td>
									<td>$ ${apartment.price}</td>
<!-- 									<td><a class=" btn btn-outline-warning" -->
<%-- 										href="/admins/apartment/${apartment.id}/edit">Edit</a> <a --%>
<!-- 										class=" btn btn-outline-danger" -->
<%-- 										href="/admins/apartment/delete/${apartment.id}">Delete</a></td> --%>



									<td><div class="d-flex justify-content-center"" >
                                            <a href="/user/apartment/${apartment.id}/edit" class="mx-3 btn btn-outline-warning btn-sm" >Edit</a>
                                            <form action="/user/apartment/${apartment.id}/delete" method="post" >
                                                <input type="hidden" name="_method" value="delete">
                                                <button type="submit" class="btn btn-outline-danger btn-sm" >Del</button>
                                            </form>

                                        </div></td>


								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="my-4">
						<a href="apartment/new" class=" btn btn-outline-primary">
							+ New Apartment </a>
					</div>
				</div>
			</div>
		</div>

		<div style="width: 800px;">
			<canvas id="acquisitions"></canvas>
		</div>

		<script type="text/javascript" src="/js/chart.js"></script>
</body>
</html>