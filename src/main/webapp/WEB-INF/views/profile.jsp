<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List"
	import="com.demo.model.Employee" import="com.demo.model.Address"%>
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
		<a href="edit-employee-details/${employee.empId}"
			class="btn btn-success">Edit</a> <a href="homepage"
			class="btn btn-success">Home </a>
	</form>

	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<hr>
			<br>
			<tr>
				<td><b>Employee Id: </b>${employee.getEmpId()}</td>
				<br />
				<br />
				<td><b> First Name : </b> ${employee.getFirstName()}</td>
				<br />
				<br />
				<td><b> Last Name : </b> ${employee.getLastName()}</td>
				<br />
				<br />
				<td><b>Mob No : </b> ${employee.getMobNo()}</td>
				<br />
				<br />
				<td><b>Email : </b> ${employee.getEmail()}</td>
				<br />
				<br />
				<td><b>DOB : </b> ${employee.getDob()}</td>
				<br />
				<br />

				<td><b>Hobbies : </b> ${employee.getHobbies()}</td>
				<br />
				<br />
				<td><b>Admin : </b> <c:choose>
						<c:when test="${employee.getIsAdmin()==0}">No</c:when>
						<c:otherwise>Yes</c:otherwise>
					</c:choose></td>
				<br />
				<br />
				<br />
				<br />
				<td></td>
				<%-- <b>Password : </b>
				<%
						for(int i=0;i<${emp.getPassword().length()};i++){
					%>* <%}
						 %></td> --%>
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

					<%-- <%	
						int count = 1;
						List<Address> addressdata = (List<Address>) httpSession.getAttribute("addressDetailsKeyForJsp");
						for (Address add : addressdata) {
						%> --%>
					<c:choose>
						<c:when test="${address.size()<1 }">
							<h3>No address found</h3>
						</c:when>
						<c:otherwise>
							<%
							int count = 1;
							%>
							<c:forEach var="i" begin="0" end="${address.size()-1}">

								<tr>
									<td><%=count++%></td>
									<td>${address.get(i).getStreet()}</td>
									<td>${address.get(i).getCity()}</td>
									<td>${address.get(i).getState()}</td>
									<td>${address.get(i).getPinCode()}</td>

									<%-- 			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="DeleteProjectServlet?id=<%=p.getProjectId()%>">Delete</a></td> --%>
								</tr>
								<%-- 						<%
						}
						%> --%>

							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>

			</table>

		</div>
	</div>
</body>
<%@ include file="footer.jsp"%>
</html>