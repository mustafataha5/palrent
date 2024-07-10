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
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>


	<div class="row d-flex justify-content-center mx-5 mt-3">
		<div class="col-md-8">
			<div class="card border-light">

				<div class="d-flex justify-content-between my-2">
					<h4 class="card-title mx-3">New A Apartment</h4>
					<a href="/admins/apartment"><h4
							class="card-title mx-3 btn btn-outline-primary ">Go back</h4></a>
				</div>
				<div class="card-body">


					<form:form action="/admins/apartment/${Apartment.id}/edit"
						method="post" modelAttribute="Apartment">
						<input type="hidden" name="_method" value="patch">

						
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
						<p class="error">
							<form:errors path="approval"></form:errors>
						</p>
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
									<td><form:input type="number" value="1" min="1" path="numOfRoom" /></td>
								</tr>
								<tr>
									<td><form:label path="numOfBath">Number Of Baths:</form:label></td>
									<td><form:input type="number" value="1" min="1" path="numOfBath" /></td>
								</tr>
								<tr>
									<td><form:label path="numOfBed">Number Of Beds:</form:label></td>
									<td><form:input type="number" value="1" min="1" path="numOfBed" /></td>
								</tr>
								<tr>
									<td><form:label path="area">Apartment Space:</form:label></td>
									<td><form:input path="area" type="number" value="1" min="1" /></td>
								</tr>
								<tr>
									<td><form:label path="numOfGuest">Number Of Guests:</form:label></td>
									<td><form:input path="numOfGuest" type="number" value="1" min="1"/></td>
								</tr>
							<tr>
									<td><form:label path="approval">Approval:</form:label></td>
									<td><form:select path="approval">
									<form:option value="false" >False</form:option>
									<form:option value="true">True</form:option>
									</form:select> </td>
								</tr>
								<tr>
									<td><form:label path="price">Price:</form:label></td>
									<td><form:input type="double" value="0" path="price" /></td>
								</tr>
								
								<tr>
									<td><form:label path="">address:</form:label></td>
									<td><form:input type="text" path="departmentNum" placeholder="department number" />  <form:input type="text" path="buildingNum" placeholder="Building Number" /> <form:input type="text" path="street"  placeholder="Street"/> <form:input type="text" path="city" placeholder="City" /></td>
					
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
										<button type="submit" class="btn btn-outline-primary">
											Edit Apartment</button>
									</td>
								</tr>

							</tbody>
						</table>
					</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>