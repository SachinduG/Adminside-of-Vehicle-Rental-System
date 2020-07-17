<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="style/main.css">
	<style>

body{
	margin: 0;
	padding: 0;
	background-image: url(images/img.png);
	background-size: cover;

}
	</style>
</head>
<body>
<div class="login">
		<h1>Log In</h1>
		<form action="Login" method="POST">

			<p>
				<label for="">ID:</label>
				<input type="text" name="aId" id="" placeholder="ID">
			</p>
			<p>
				<label for="">Password:</label>
				<input type="password" name="aPassword" id="" placeholder="Password">
			</p>
			<p>
				<button type="submit" name="submit">Log In</button>
			</p>


		</form>

	</div>
</body>
</html>