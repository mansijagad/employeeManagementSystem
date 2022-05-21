
<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
	<% 	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); // HTTP 1.1
	response.setHeader("Pragma", "no-cache");// HTTP 1.0
	response.setHeader("Expires", "0"); // proxies
	response.setDateHeader("Expires", -1);
	session.setAttribute("listEmpkeyForjsp", null);
	session.setAttribute("emp_id", null);

	 Cookie cookies = null;
	 Cookie[] cookie = request.getCookies();
	  if( cookie != null ) {
	  for (int i = 0; i < cookie.length; i++) {
		 cookies = cookie[i];;
	 response.addCookie(cookies);
	  }
	  }
	cookies.setMaxAge(0);
	 request.getSession(false);
	session.invalidate();
	response.sendRedirect("index.jsp");
	%>
</body>


</html>
