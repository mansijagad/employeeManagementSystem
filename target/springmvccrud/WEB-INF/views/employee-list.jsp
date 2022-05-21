<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List"
	import="com.demo.model.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>



<head>

<link rel="stylesheet" href="./hello.css">

<title>Employee Details</title>

<link rel="stylesheet"
	href=https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<%@ include file="header.jsp"%>
<body>
	<%-- 	<% 	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); // HTTP 1.1
	response.setHeader("Pragma", "no-cache");// HTTP 1.0
	response.setHeader("Expires", "0"); // proxies
	%> --%>

	<form action="/search" method="get,post">

		<div class="main-container">

			<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

			<nav class="navbar navbar-expand-lg navbar-dark bg-dark  sticky-top">

				<a class="navbar-brand" href="#">All Employee</a>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">

					<span class="navbar-toggler-icon"></span>

				</button>

				<div class="collapse navbar-collapse" id="navbarNav">

					<ul class="navbar-nav">

						<li class="nav-item"><a href="/springmvccrud/register" class="nav-link">Add
								New Employee</a></li>


						<li class="nav-item"><input type="text" name="name"
							placeholder="search employee name" id="name"> <input
							type="submit" name="submit" value="Search"></li>
						<li class="nav-item"><a href="/springmvcproject/logout" class="nav-link"
							align="right">Logout</a></li>

					</ul>

				</div>

			</nav>

			<div class="container">

				<br>

				<h3 class="text-center">List of Employee</h3>

				<br>

				<table class="table table-striped table-hover table-bordered">

					<thead class="thead-dark">

						<tr>

							<th>ID</th>

							<th>First Name</th>

							<th>Last Name</th>

							<th>Mobile No</th>

							<th>Email</th>

							<th>DOB</th>

							<th>Hobbies</th>

							<th>Action</th>

						</tr>

					</thead>

					<tbody>

						<c:forEach var="emp" items="${employee}">
							<tr>
								<td>${emp.empId}</td>
								<td>${emp.firstName}</td>
								<td>${emp.lastName}</td>
								<td>${emp.mobNo}</td>
								<td>${emp.email}</td>
								<td>${emp.dob}</td>
								<td>${emp.hobbies}</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="edit-employee-details/${emp.empId}">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="deleteEmployee/${emp.empId}">Delete</a></td>
							</tr>
							</tr>

						</c:forEach>

					</tbody>

				</table>
			</div>
		</div>
</body>
<br />
<br />
<br />
<%@ include file="footer.jsp"%>
</html>