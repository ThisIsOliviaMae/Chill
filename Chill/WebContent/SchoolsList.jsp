
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/custom.css">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">		
		function getindex(index){		
			//e.preventDefault();
			//alert("1");
			var x = index;
			$.ajax({
				url : "ToSchoolInfo",
				data : {"index" : x,
				method : "GET",
				success : function(data) {
					/* window.location.replace("SchoolsInfo.jsp");
					alert("success"); */
				}
				}});
		}

	</script>

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
					<li><a href="ToScholarships">Scholarships</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="col-md-3 searchpanel">
		<!-- sidebar div -->
		Region: <select class="form-control" id="region" name="region">

			<option>All</option>
			<c:forEach var="c" items="${r}" varStatus="counter">
				<option>${c.region_name}</option>
			</c:forEach>

		</select> <br /> Province: <select class="form-control" id="region"
			name="region">

			<option>All</option>
			<c:forEach var="c" items="${p}" varStatus="counter">
				<option>${c.province_name}</option>

			</c:forEach>

		</select> <br />

		<form>
			<input type="radio" name="schooltype_radio" value="All"> All
			<br> <input type="radio" name="schooltype_radio" value="Public">
			Public <br> <input type="radio" name="schooltype_radio"
				value="Private"> Private
		</form>

		Degree: <select class="form-control" id="degree" name="degree">
			<option>All</option>
			<option>BS</option>
			<option>MS</option>
			<option>PHD</option>
		</select><br />
	</div>
	<!-- end sidebar div -->

	<div class="col-md-8 result">
		<br />
		<h2>Search: <input type="text" name="search_field" /></h2> <br>
		<h2>List of Universities</h2>
		<!--  school list section -->
		<div>
			<c:forEach var="c" items="${s}" varStatus="counter">

				<form class="form-horizontal">
					<button type="submit" class="btn btn-default btn-xs"
						onclick="javascript:getindex(${counter.index})">
						${c.school_name}</button>
				</form>

			</c:forEach>

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