<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
   
   <%
   response.sendRedirect("customer/list"); 
   %> 
   <!--  redirect to the list controller which 
         ultimately redirects to the list page as provided in redirect through mapping. 
    -->
</body>
</html>