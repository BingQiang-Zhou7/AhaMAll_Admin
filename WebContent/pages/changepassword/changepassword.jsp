<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
	<link type="text/css" rel="stylesheet" href="../../maincss/main.css">
	<link type="text/css" rel="stylesheet" href="../../mainjsp/main.css">
	<script src="../../jquerylib/jquery-3.3.1.min.js"></script>
	<script src="../../mainjsp/main.js"></script>
	<script src="changepassword.js"></script>
	<link rel="stylesheet" type="text/css"  href="changepassword.css">
</head>
<body onload="load()">
<%@include file="../../mainjsp/main.jsp" %>
<div class="main_plane">
	<div class="changePassword">
		<form class="changePassword_from" action="../../ChangePasswordServlet" method="post">
			<ul>
				<li><p>old password</p></li>
				<li><input type="password" maxlength="16" id="oldPwd" name="oldPwd"></li>
			</ul>
			<ul>
				<li><p>new password</p></li>
				<li><input type="password" maxlength="16" id="newPwd1" name="newPwd1"></li>
			</ul>
			<ul>
				<li><p>confirm password</p></li>
				<li><input type="password" maxlength="16" id="newPwd2" name="newPwd2"></li>
			</ul>
			<ul>
			<li><p style="color: red" id="ErrorTip" class="hide">Password isn't the same!</p></li>
				<li>
				<button type="submit" disabled="disabled">change</button>
				</li>
			</ul>
		</form>
	</div>
</div>

</body>
</html>