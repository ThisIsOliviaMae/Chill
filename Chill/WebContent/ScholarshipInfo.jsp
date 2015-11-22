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
			<img class="logo col-md-1" src="logo.png" width="inherit" height="inherit"></img>
			<div class="navbar-header">
				<ul class="nav navbar-nav">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="ToSchoolList" >Schools</a></li>
					<li  class="active"><a href="">Scholarships</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="col-md-4">
		<!-- sidebar div -->
		Search: <input type="text" name="search_field" /> <br> Region: <select>
			<!--
					< % for () {
					out.println("<option value=\"");
					//data here
					out.println("\">");
					//data here
					out.println("</option>")
					}
					%>
					-->
		</select> Province: <select>
			<!--
					< % for () {
					out.println("<option value=\"");
					//data here
					out.println("\">");
					//data here
					out.println("</option>")
					}
					%>
					-->
		</select>

		<form>
			<input type="radio" name="schooltype_radio" value="All"> All
			<br> <input type="radio" name="schooltype_radio" value="Public">
			Public <br> <input type="radio" name="schooltype_radio"
				value="Private"> Private
		</form>

		Degree: <select>
			<!--
					< % for () {
					out.println("<option value=\"");
					//data here
					out.println("\">");
					//data here
					out.println("</option>")
					}
					%>
					-->
		</select> Price Range: <select>
			<!--
					< % for () {
					out.println("<option value=\"");
					//data here
					out.println("\">");
					//data here
					out.println("</option>")
					}
					%>
					-->
		</select>

	</div>
	<!-- end sidebar div -->

	<div class="col-md-8">
		<!-- school list section -->
		<!--
			< % for () {
			out.println("<div>");
			out.println("<image src=\"");
			//image link
			out.println("\"></image>");
			out.println("<a href=\"");
			//school link
			out.println("\">");
			//school name
			out.println("</a>");
			out.println("</div>")
			}
			%>
			-->
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