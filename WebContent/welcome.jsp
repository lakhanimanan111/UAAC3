<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/sample.css">

</head>
<body>
	<div class='brand'>
		<a href='https://www.jamiecoulter.co.uk' target='_blank'> <img
			src='https://s3-us-west-2.amazonaws.com/s.cdpn.io/217233/logo.png'>
		</a>
	</div>

	<form action="login" method="post">

		<div class='login'>
			<div class='login_title'>
				<span>Login to your account</span>
			</div>
			<div class='login_fields' id ="Username">
				<div class='login_fields__user' id ="Username">
					<input placeholder='Username' type='text' id ="Username"> </input>
				</div>
				<div class='login_fields__password' id ="Password">
					<input placeholder='Password' type='password' id ="Password">
				</div>
				<div class='login_fields__submit'>
					<input type='submit' value='Log In'>
				</div>
			</div>
		</div>
		
	</form>

	<script type="text/javascript" src="js/sample.js"></script>
</body>
</html>