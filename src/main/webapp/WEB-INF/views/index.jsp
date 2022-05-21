<style>
* {
	box-sizing: border-box;
	margin: 0px;
	padding: 0px;
}

body {
	font-family: "Raleway", sans-serif;
	background: #344a72;
	font-weight: 500;
	font-size: 15px;
}

a {
	text-decoration: none;
}

.container {
	width: 100vw;
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	margin: 65px auto;
	max-width: 400px;
	padding: 20px;
}

.form-wrap {
	background-color: #ffffff;
	box-shadow: 0px 0px 10px black;
	padding: 15px 25px;
	color: #333;
	border-radius: 10px;
}

.form-wrap h1, .form-wrap p {
	text-align: center;
	margin-bottom: 10px;
}

.form-wrap .form-group {
	margin-top: 15px;
}

.form-wrap .form-group label {
	display: block;
	color: #666;
}

.form-wrap .form-group input {
	width: 100%;
	padding: 10px;
	border: #ddd 1px solid;
	border-radius: 5px;
}

.form-wrap button {
	display: block;
	width: 100%;
	border: 0;
	color: white;
	border-radius: 3px;
	padding: 10px;
	margin: 20px 0px 0px 0px;
	background: #49c1a2;
	cursor: pointer;
}

.form-wrap button:hover {
	background: #37a08e;
}

.form-wrap .bottom-text {
	font-size: 13px;
	margin-top: 20px;
}

.error-message {
	width: fit-content;
	margin: auto;
	padding: 10px;
	color: skyblue;
	font-weight: 900;
	background-color: #990000;
	border-radius: 20px;
}
</style>
<div class="container">
	<div class="form-wrap">
		<h1 class="page-title">Login Page</h1>
		<form action="validateUser/{}" method="post" class="form">
			<div class="form-group">
				<label for="username">Username</label> 
				<input type="text" placeholder="Enter Email" name="email" required>
			</div>
			<div class="form-group">
				<label for="userpass">Password</label> <input type="password"
					placeholder="Enter Password" name="password" required>
			</div>

			<div>
				<button type="submit">Login</button>

			</div>
			<a href="reset-password"> Forgot Password?</a>
			<p class="bottom-text">
				New User ? <a href="register"> Register here</a>
			</p>
		</form>
	</div>
	<div class="footer"></div>
</div>