<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<header>
			<h1>Log In Page</h1>
		</header>
		<form action="logInProcess" method="post">
			<label>Enter your email : </label>
			<input type="email" name="userEmail"/>
			<label>Enter your password : </label>
			<input type="password" name="userPass"/>
			<input type="submit" value="Log In"/>
		</form> 
		<a href="register.jsp">Don't have account</a>
	</div>
</body>
</html>