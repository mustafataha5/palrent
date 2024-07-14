<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin main</title>
    
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
     
    <link rel="stylesheet" href="/css/apartmentstyle.css"> 
</head>
<body>
	
	<div class="row m-5 ">
		<div class="col-md-6">
			<div class="card p-5">
				<h1 class="card-title"> Admin Main Page:</h1>
				<div class="card-body">
					<div	class="d-flex flex-column justify-content-even ">
						<a href="/admins/user" class="my-2 btn btn-outline-primary"> User</a>
						<a href="/admins/apartment" class="my-2 btn btn-outline-primary"> Department</a>
						<a href="/admins/rule" class="my-2 btn btn-outline-primary"> Rule</a>
						<a href="/admins/offer" class="my-2 btn btn-outline-primary"> Offer</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>