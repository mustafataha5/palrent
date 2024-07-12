<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
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
<title>Admin User</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/style.css">
</head>
<body>

	<div class="row d-flex justify-content-center mx-5 mt-3">
		<div class="col-md-8">
			<div class="card border-light">
				<h4 class="card-title mx-3">Add New User:</h4>
				<div class="card-body">


					<%-- <form:form action="/admins/user/new" method="post"
						modelAttribute="newUser"> --%>

					<form:form action="/admins/register" method="post"
						modelAttribute="newUser">
						<p class="error">
							<form:errors path="firstName"></form:errors>
						</p>
						<p class="error">
							<form:errors path="lastName"></form:errors>
						</p>
						<p class="error">
							<form:errors path="username"></form:errors>
						</p>
						<p class="error">
							<form:errors path="password"></form:errors>
						</p>
						<p class="error">
							<form:errors path="confirm"></form:errors>
						</p>
						<p class="error">
							<form:errors path="phone"></form:errors>
						</p>
						<p class="error">
							<form:errors path="dateOfBirth"></form:errors>
						</p>
						<p class="error">
							<form:errors path="urlImage"></form:errors>
						</p>
						<table class="table">
							<tbody>
								<tr>

									<td><form:label path="firstName">First Name:</form:label></td>
									<td><form:input path="firstName" /></td>
								</tr>
								<tr>
									<td><form:label path="lastName">Last Name:</form:label></td>
									<td><form:input path="lastName" /></td>
								</tr>
								<tr>
									<td><form:label path="username">Email:</form:label></td>
									<td><form:input path="username" /></td>
								</tr>
								<tr>
									<td><form:label path="password">Password:</form:label></td>
									<td><form:input type="password" path="password" /></td>
								</tr>
								<tr>
									<td><form:label path="confirm">Confirm PW:</form:label></td>
									<td><form:input type="password" path="confirm" /></td>
								</tr>
								<tr>
									<td><form:label path="phone">Phone:</form:label></td>
									<td><form:input path="phone" /></td>
								</tr>
								<tr>
									<td><form:label path="dateOfBirth">Date Of Birth:</form:label></td>
									<td><form:input type="date" path="dateOfBirth" /></td>
								</tr>
								<tr>
									<td><form:label path="urlImage">Url Image:</form:label></td>
									<td><form:input path="urlImage" /></td>
								</tr>

								<tr>
									<td></td>
									<td>
										<button type="submit" class="btn btn-outline-primary">
											Create User</button>
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