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
				<h4 class="card-title mx-3">All User:</h4>
				<div class="card-body">
					
					<div class="my-2 d-flex justify-content-end">
						<a href="/admins/user/new" class=" btn btn-outline-secondary"> +
							New User</a>
					</div>
					
					<table class="table  text-center">
						<thead class="table-primary">
							<th>User Name</th>
							<th>Email</th>
							<th>Phone</th>
							<th>Date Of Birth</th>
							<th>Action</th>
						</thead>
						<tbody>
							<c:forEach var="userX" items="${users}">
								<tr>
									<td>
										<p>${userX.firstName} ${userX.lastName}</p>
									</td>
									<td>${userX.email}</td>
									<td>${userX.phone}</td>
									<td> ${userX.dateOfBirth}</td>
									<td>
									    <div class="d-flex">
									    	<a href="/admins/user/${userX.id}/edit" class="btn btn-outline-warning btn-sm" >Edit</a>
									    	<form action="/admins/user/${userX.id}/delete" method="post" >
									    		<input type="hidden" name="_method" value="delete">
									    		<button type="submit" class="btn btn-outline-danger btn-sm" >Del</button>
									    	</form>
									    	
									    </div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>