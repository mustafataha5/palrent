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
<title>Edit Image</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="row d-flex justify-content-center mx-5 mt-3">
		<div class="col-md-8">
			<div class="card border-light">
				<h4 class="card-title mx-3">Edit Image:</h4>
				<div class="card-body">
					<form:form action="/admins/image/${editImage.id}/edit" method="post"
						modelAttribute="editImage">
						<input type="hidden" name="_method" value="patch">
						<p class="error" > <form:errors path="urlImage"></form:errors> </p>
						<tr>

							<td><form:label path="urlImage">Name:</form:label></td>
							<td><form:input path="urlImage" /></td>
						</tr>
						<tr>
							<td></td>
							<td>
								<button type="submit" class="btn btn-outline-primary">
									Edit Image</button>
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
</html>>