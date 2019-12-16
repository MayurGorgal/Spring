<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>user details</title>
</head>
<body>
	<div class="container">
		<table id="users_table" class="table">
			<thead>
				<tr align="center">
					<th>Name</th>
					<th>Email</th>
					<th colspan="2"></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${userlist}" var="user">
					<tr align="center">
						<td><c:out value="${user.name}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:url var="editUrl"
								value="/admin/redirecttoupdate?email=${user.email}" /><a
							id="update" href="${editUrl}" class="btn btn-warning">Update</a>
						</td>
						<td><c:url var="deleteUrl"
								value="/admin/delete?email=${user.email}" /><a id="delete"
							href="${deleteUrl}" class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
