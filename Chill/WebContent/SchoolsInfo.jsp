<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/custom.css">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<img class="logo col-md-1" src="images/logo.png" width="inherit"
				height="inherit"></img>
			<div class="navbar-header">
				<ul class="nav navbar-nav">
					<li><a href="index.jsp">Home</a></li>
					<li class="active"><a href="ToSchoolList">Schools</a></li>
					<li><a href="ToScholarshipList">Scholarships</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div>
		<!-- school info -->
		<img src="images/schools_logo.jpg" class="img-circle" />
		<!-- school picture goes here -->
		<!-- school name goes here -->
		<!--<c:out value="${sessionScope.i.school_name}"/>-->
		
		Courses & Price Range:
		<ul>
			
		</ul>
		<a href="">See Scholarships Offered by School</a> <br> Location:
		<!-- google maps go here -->
	</div>
	<!-- end school info -->
</body>

</html>