<!DOCTYPE html>
<html>
<head>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not(.active) {
	background-color: #111;
}

.bgImage {
	width: 100vw;
	height: 100vh;
}

img {
	width: 97.25%;
}

.active {
	background-color: #04AA6D;
}

.welcome-message {
	font-size: 40px;
	font-weight: 400;
	color: darkBlue;
	margin: auto;
	width: fit-content;
}
</style>
</head>

<%@ include file="header.jsp"%>

<body>
<%-- <% 	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); // HTTP 1.1
	response.setHeader("Pragma", "no-cache");// HTTP 1.0
	response.setHeader("Expires", "0"); // proxies
/*  response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Cache-Control", "must-revalidate"); 
 */	
	if(session.getAttribute("emp_id")==null){
		response.sendRedirect("index.jsp");
	}
	%> --%>
	<form action="HomePageServlet" method="post,get">
		<ul>

			<li style="float: left"><a href="HomePageServlet">Profile </a></li>

			<li><a href="EmployeeProjectServlet">Project</a></li>
			
			<li style="float: right"><a class="active" href="LogoutServlet">Logout</a>
		</li>
			
		</ul>
	</form>
	<h1 class="welcome-message">Welcome to Inexture !!!!</h1>
	<div class="bgImage">
		<img
			src="https://www.yelu.in/img/in/m/1556609270-69-inexture-solutions-llp.png" />
	</div>


</body>
<%@ include file="footer.jsp"%>

</html>



