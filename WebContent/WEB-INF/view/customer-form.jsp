<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer form</title>

<style type="text/css">
body {
	text-align: center;
	font-family: arial;
}

form {
	display: inline-block;
}
</style>

</head>

<body>

	<h1 align="center">Customer Form</h1>
	<h2 align="center">Please Fill Up the Form</h2>

	<!-- customer is the model attribute in the controller  -->
	<form:form action="saveCustomer" modelAttribute="customer"
		method="POST">

		<!-- 
		 to know exactly which customer to update and track based on id
         as it calls getId() and setId(id) behind the scene
        -->
		<form:hidden path="id" />
		<!-- calls get and set id -->
		<table>

			<!-- ON SUBMIT CALL SETTERS AND ON LOADING CALL GETTERS -->
			<tr>
				<!-- calls setFirstName(value), from the entity class that maps to the database using hibernate -->
				<td>First Name :<form:input path="firstName" /></td>
			</tr>

			<tr>
				<td>Last Name :<form:input path="lastName" /></td>
			</tr>

			<tr>
				<td>Email :<form:input path="email" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form:form>

<a href="${pageContext.request.contextPath }/customer/list">Go to Customer List </a>
	<!-- gives appname/customer/list here appname is Spring_Hib_CRUD  -->

</body>

</html>
