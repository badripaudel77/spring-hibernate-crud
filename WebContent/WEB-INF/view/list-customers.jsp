<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- ${pageContext.request.contextPath} -->

<link rel="styelsheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<style>

body {
	text-align: center;
	background-color: #239B56;
}

</style>

</head>

<body>

	<h1 align="center" class="page">Customers List Page</h1>

	<!-- add button for adding the customers -->

	<!-- call our controller class to map showFormAdd on click -->

	<input type="button" align="center" value="Add Customer"
		onclick="window.location.href='showFormForAdd'; return false;" />

	<div>
		<h2 align="center" class="heading">Customers</h2>
	</div>

	<div>

		<table border="border" align="center"
			style="border: 2px solid orange;">

			<tr>

				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Update Customer</th>
				<th>Delete Customer</th>
			</tr>

			<!-- customersList is the actual attribute name from our customer controller  -->
			<!-- traverse customer in customerList  -->
			<c:forEach var="customer" items="${customersList}">

				<!-- make delete link for every customer based on their id -->

				<c:url var="upLink" value="/customer/showUpdateForm/">

					<c:param name="custId" value="${customer.id}"></c:param>

				</c:url>

				<c:url var="delLink" value="/customer/delete/">

					<c:param name="custId" value="${customer.id}"></c:param>

				</c:url>
				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>

					<td><a href="${upLink}"> Update </a></td>
					<!-- alert for the delete -->
					<td><a href="${delLink}"
						onclick="if(!(confirm('are you sure to delete?')))return false;">|
							Delete</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>