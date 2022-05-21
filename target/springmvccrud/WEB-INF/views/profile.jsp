<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List" import="com.demo.model.Employee"
	import="com.demo.model.Address"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<%@ include file="header.jsp"%>
<body>
	<form action="ProfileServlet">
		<a href="edit-employee-details.jsp" class="btn btn-success">Edit</a> <a
			href="add-new-address-repeat-logic.html" class="btn btn-success">Add
			New Address </a> <a href="homepage.jsp" class="btn btn-success">Home
		</a>
	</form>

	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<hr>
			<br>
			<%
					HttpSession httpSession = request.getSession();
					Employee emp=(Employee) httpSession.getAttribute("empKeyForjsp");						
						%>
			<tr>
				<td><b>Employee Id: </b><%= emp.getEmpId() %></td>
				<br />
				<br />
				<td><b>Name : </b><%= emp.getFirstName() %></td>
				<br />
				<br />
				<td><b>Email : </b><%= emp.getEmail() %></td>
				<br />
				<br />
				<td><b>DOB : </b><%= emp.getDob()  %></td>
				<br />
				<br />
				<td><b>Mob No : </b><%= emp.getMobNo() %></td>
				<br />
				<br />
				<td><b>Hobbies : </b><%= emp.getHobbies()  %></td>
				<br />
				<br />
				<td><b>Admin : </b><%= emp.getIsAdmin() %></td>
				<br />
				<br />
				<br />
				<br />
				<td></td>
				<b>Password : </b>
				<%
						for(int i=0;i<emp.getPassword().length();i++){
							%>*
				<%}
						 %></td>
				<br />
				<br />

				<%-- <td><b>Password : </b><%= emp.getPassword() %></td><br/><br/> --%>
			</tr>

			<table class="table table-striped table-hover table-bordered">

				<thead class="thead-dark">

					<tr>

						<th>Address</th>

						<th>Street</th>

						<th>City</th>

						<th>State</th>

						<th>Pincode</th>

					</tr>

				</thead>

				<tbody>

					<%	
						int count = 1;
						List<Address> addressdata = (List<Address>) httpSession.getAttribute("addressDetailsKeyForJsp");
						for (Address add : addressdata) {
						%>
					<tr>
						<td><%= count++ %></td>
						<td><%= add.getStreet() %></td>
						<td><%= add.getCity() %></td>
						<td><%= add.getState() %></td>
						<td><%= add.getPinCode() %></td>
						
						<%-- 			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="DeleteProjectServlet?id=<%=p.getProjectId()%>">Delete</a></td> --%>
					</tr>
					<%
						}
						%>


				</tbody>

			</table>

		</div>
	</div>
</body>
<%@ include file="footer.jsp"%>
</html>