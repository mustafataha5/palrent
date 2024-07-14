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
<title>Offer</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/apartmentstyle.css"> 
</head>
<body>
	<div class="row d-flex justify-content-center mx-5 mt-3">
		<div class="col-ld-11">
			<div class="card border-light ">
				<div class="d-flex justify-content-between my-2">
					<h4 class="card-title mx-3">Offer</h4>
					<a href="/admin"><h4
							class="card-title mx-3 btn btn-outline-secondary ">Go back</h4></a>
				</div>
				<div class="card-body">
					<table class="table  text-center">
						<thead class="table-primary">
							<th>Id</th>
							<th>Offer Name</th>

							<th>Action</th>
						</thead>
						<tbody>
							<c:forEach var="offer" items="${offers}">
								<tr>
									<td>${offer.id}</td>
									<td>${offer.name}</td>

									<%-- <td><a class=" btn btn-outline-secondary"
										href="/admins/offer/${offer.id}/edit">Edit</a> <a
										class=" btn btn-outline-secondary" href="/admins/offer/${offer.id}/delete">Delete</a></td> --%>
									<td><div class="d-flex justify-content-center"" >
                                            <a href="/admins/offer/${offer.id}/edit"" class="mx-3 btn btn-outline-warning btn-sm" >Edit</a>
                                            <form action="/admins/offer/${offer.id}/delete" method="post" >
                                                <input type="hidden" name="_method" value="delete">
                                                <input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
                                                <button type="submit" class="btn btn-outline-danger btn-sm" >Del</button>
                                            </form>

                                        </div></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="my-4">
						<a href="/admins/offer/new" class=" btn btn-outline-secondary">
							+ New Offer </a>
					</div>
				</div>
			</div>
		</div>
	</div>	
</body>
</html>