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
					<li><a href="ToSchoolList">Schools</a></li>
					<li class="active"><a href="ToScholarships">Scholarships</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="col-md-4">
		<br />
		<!-- sidebar div -->
		<h2>Search: <input type="text" name="search_field" /></h2> <br>
	<div><br><br></div>
		<c:forEach var="a" items="${sc}" varStatus="counter">
				<h2>${a.scholarship_name}</h2>
			</c:forEach>



		<div class="col-md-8">
			<!-- scholarship list section -->



		</div>
		<!-- end school list section -->
		<!-- footer -->
		<div class="row">
			<div class="col-md-12">
				<hr class="break" />
				<ul>
					<li class="liblock">© Team Chill</li>
				</ul>
				<p style="padding-left: 4em">Icons from Glyphicons Free.</p>
			</div>
		</div>
		<!-- footer end -->
</body>

</html>