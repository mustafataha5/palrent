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
<title>Image</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="row d-flex justify-content-center mx-5 mt-3">
		<div class="col-ld-11">
			<div class="card border-light ">
				<div class="d-flex justify-content-between my-2">
					<h4 class="card-title mx-3">Image</h4>
					<a href="/admin"><h4
							class="card-title mx-3 btn btn-outline-secondary ">Go back</h4></a>
				</div>
				<div class="card-body">
					<table class="table  text-center">
						<thead class="table-primary">
							<th>Id</th>
							<th>Image Name</th>

							<th>Action</th>
						</thead>
						<tbody>
							<c:forEach var="image" items="${images}">
								<tr>
									<td>${image.id}</td>
									<td>${image.urlImage}</td>

									<%-- <td><a class=" btn btn-outline-secondary"
										href="/admins/offer/${offer.id}/edit">Edit</a> <a
										class=" btn btn-outline-secondary" href="/admins/offer/${offer.id}/delete">Delete</a></td> --%>
									<td><div class="d-flex justify-content-center"" >
                                            <a href="/admins/image/${image.id}/edit"" class="mx-3 btn btn-outline-warning btn-sm" >Edit</a>
                                            <form action="/admins/image/${image.id}/delete" method="post" >
                                                <input type="hidden" name="_method" value="delete">
                                                <button type="submit" class="btn btn-outline-danger btn-sm" >Delete</button>
                                            </form>

                                        </div></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="my-4">
						<a href="/admins/image/new" class=" btn btn-outline-secondary">
							+ New Image </a>
					</div>
				</div>
			</div>
		</div>
	</div>	
</body>
</html>>