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
			<h1>Sign Up Page</h1>
		</header>
		<form action="registerProcess" method="post">
			<label>Enter your name : </label>
			<input type="text" name="userName" required/>
			<label>Enter your Email : </label>
			<input type="email" name="userEmail" required/>
			<label>Create password : </label>
			<input type="password" name="userPass" required/>
			<label>Select your gender : </label>
			<input type="radio" value="Male" name="userGender" required/>Male<input type="radio" value="Female" name="userGender" required/>Female
			<input type="submit" value="Register">
		</form>
		<a href="login.jsp">already have account</a>
	</div>
</body>
</html>