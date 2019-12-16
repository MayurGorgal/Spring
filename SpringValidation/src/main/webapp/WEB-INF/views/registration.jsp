<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.error {
	color: red;
}

h1 {
	color: green;
	text-align: center;
}
</style>
</head>
<body>

	<div class="container">
		<form:form action="adduser" method="POST" modelAttribute="form">

			<div class="form-group">
				<label for="username">Name</label>
				<form:input path="name" class="form-control" />
				<form:errors path="name" cssClass="error"></form:errors>
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" cssClass="error"></form:errors>
				<small Class="error">${emailexist}</small>
			</div>

			<div class="form-group">
				<label for="password">Password</label>
				<form:password path="password" class="form-control" />
				<form:errors path="password" cssClass="error"></form:errors>
			</div>

			<div class="form-group">
				<label for="confirmpassword">ConfirmPassword</label>
				<form:password path="confirmPassword" class="form-control" />
				<form:errors path="confirmPassword" cssClass="error"></form:errors>
			</div>

			<div class="form-check">
				<label for="gender">Gender</label>
				<form:radiobutton path="gender" value="Male" />
				Male
				<form:radiobutton path="gender" value="Female" />
				Female
				<form:errors path="gender" cssClass="error"></form:errors>
			</div><br>


			<div class="form-group">
				<label for="address">Address</label>
				<form:textarea path="address" class="form-control" />
				<form:errors path="address" cssClass="error"></form:errors>
			</div>

			<div class="form-group">
				<label for="city">City</label>
				<form:input path="city" class="form-control" />
				<form:errors path="city" cssClass="error"></form:errors>
			</div>

			<div class="form-group">
				<label for="state">State</label>
				<form:select path="state" class="form-control">
					<form:option value="NONE" label="-----SELECT-----"></form:option>
					<form:options items="${statelist}" />
				</form:select>
				<form:errors path="state" cssClass="error"></form:errors>
			</div>



			<div class="form-group">
				<label for="zipcode">Zip</label>
				<form:input path="zipcode" class="form-control" />
				<form:errors path="zipcode" cssClass="error"></form:errors>
			</div>

			<div>
				<input type="submit" value="submit" class="btn btn-success">
				<a href="redirectToLogin" class="btn btn-primary">Login</a>
			</div>
		</form:form>
	</div>

	<div>
		<h1>${result}</h1>
	</div>
</body>
</html>