<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.demo.model.Employee"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.title {
	text-align: center;
}

label {
	font-weight: 600;
}

.main-container {
	width: 100%;
	display: flex;
	justify-content: center;
}

.input {
	height: 30px;
	width: 110%;
	border: 2px solid black;
	border-radius: 5px;
	margin-left: 10px;
}

.table-container {
	border: 1px solid black;
	padding: 50px;
	border-radius: 5px;
}

.submit-button {
	margin: auto;
	width: 110%;
	height: 40px;
}
</style>
<!DOCTYPE style PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Register New Employee</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen"
	href="https://bootswatch.com/3/paper/bootstrap.min.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<div class="form-wrap">

			<form action="updateEmployee" method="post">
				
				<div class="form-group">
				<b>
					<label for="name">Id :</label> <input class="input" type="text"
						name="empId" value="${employee.empId}" id="empId" readonly="readonly" />
				</b>
				
				</div>
				<div class="form-group">
					<label for="name">First Name :</label> <input class="input" type="text"
						name="firstName" value="${employee.firstName}" id="emp_name" />
				</div>
				<div class="form-group">
					<label for="name">Last Name :</label> <input class="input" type="text"
						name="lastName" value="${employee.lastName}" id="emp_name" />
				</div>
				
				<div class="form-group">
					<label for="mob">Mobile :</label> <input type="text" name="mobNo"
						value="${employee.mobNo}" class="input" />
				</div>
				
				<div class="form-group">
					<label for="email">Email :</label> <input type="email"
						class="input" name="email" value="${employee.email}" />
				</div>
				
					<div class="form-group">
					<label for="dob">DOB : </label> <input type="date" name="dob"
						value="${employee.dob}" class="input" />
				</div>
				
				<div class="form-group">
					<label for="hobbies">Hobbies : </label> <input type="text"
						name="hobbies" value="${employee.hobbies}" class="input" />
				</div>
				<div class="form-group">
					<label for="password">Password : </label> <input type="password"
						name="password" value="${employee.password}" class="input" />
				</div>
				<button type="Submit">Update Details</button>
			</form>
		</div>
	</div>
</body>
</html>
