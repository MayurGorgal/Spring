<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
.error {
	color: red;
}

.invalidDetails {
	color: red;
	text-align: center;
}
</style>
<meta charset="ISO-8859-1">
<title>forgot password email</title>
</head>
<body>

	<div class="invalidDetails">
		<h3>${invalidemailaddress}</h3>
	</div>
	<div class="container">
		<form:form action="emailexist" method="POST" modelAttribute="emaildetails">
			<div class="form-group">
				<label for="email">Email Address</label>
				<form:input path="emailaddress" class="form-control" />
				<form:errors path="emailaddress" cssClass="error"></form:errors>
			</div>
			<div>
				<input type="submit" value="Reset Password"
					class="btn btn-success center-block btn-block">
			</div>
		</form:form>

	</div>

</body>
</html>