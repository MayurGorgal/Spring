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
</head>
<body>
	<div class="container">
		<form:form action="resetpassword?email=${email}" method="POST"
			modelAttribute="emaildetails">
			<div class="form-group">
				<label for="password">Password</label>
				<form:input path="password" class="form-control" />
				<form:errors path="password" cssClass="error"></form:errors>
			</div>
			<div>
				<input type="submit" value="Reset Password"
					class="btn btn-success center-block btn-block">
			</div>
		</form:form>

	</div>
</body>
</html>