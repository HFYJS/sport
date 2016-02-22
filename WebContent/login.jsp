<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>运动圈——商家管理系统</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="/sport/js/login.js"></script>
<script>
	window.onload = function() {
		var code = document.getElementsByName("code")[0];
		var val = code.value;
		if (val == -1) {
			alert("没有此用户！");
		} else if (val == -2) {
			alert("此用户不是商家用户！");
		} else if (val == -3) {
			alert("密码错误！");
		}
	}
</script>
<head>
</head>
<body>
	<img src="img/login.png" width="100%" height="370px" />
	<form method="post" action="/sport/LoginServlet" class="login">
		<input type="hidden" name="code" value="${code }" />
		<p>
			<label for="login">用户名:</label> <input type="text" name="login"
				id="login">
		</p>
		<p>
			<label for="password">密&nbsp;&nbsp;&nbsp;码:</label> <input
				type="password" name="password" id="password">
		</p>
		<p class="login-submit">
			<button type="submit" class="login-button">Login</button>
		</p>
		<p class="forgot-password">
			<a href="index.html">还没有注册~ O(∩_∩)O</a>
		</p>
	</form>
</body>
</html>
