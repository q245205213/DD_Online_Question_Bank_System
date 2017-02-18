<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
<title>DD题库系统：欢迎登陆/注册</title>
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/regist.js"></script>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
</head>

<body>
	<div id="login_title">
		<h1 id="title">DD在线题库系统</h1>
	</div>
	<div id="content">
		<div id="login1">
			<div id="title2">
				<ul>
					<li><a href="javascript:void(0);" id="show">登陆</a></li>
					<li><a href="javascript:void(0);" id="hide">注册</a></li>
				</ul>
			</div>
			<div id="login">

				<form id="login_form" action="login" method="post">
					<div class="into">
						<label>用户名：</label><input id="login_user" type="text" name="account" />
					</div>
					<br />
					<div id="input3"></div>
					<div class="into">
						<label>密码：</label><input id="login_password" type="password" name="password" />
					</div>
					<br />
					<div id="input4"></div>
					<div class="good">
						<input id="submit_login" class="submit" type="submit"
							value="登&nbsp;&nbsp;陆" />
					</div>
				</form>
			</div>
			<div id="regist">
				<form id="regist_form">
					<div class="into">
						<label>用户名：</label><input id="regist_user" type="text"
							name="account" />
					</div>
					<br />
					<div id="input2"></div>
					<div class="into">
						<label>密码：</label><input id="password" type="password"
							name="password" />
					</div>
					<br />
					<div id="input"></div>
					<div class="into">
						<label>确认密码：</label><input id="apassword" type="password"
							name="password1" />
					</div>
					<div id="input1"></div>
					<div class="good">
						<input id="submit_regist" class="submit" type="submit"
							value="注&nbsp;&nbsp;册" />
					</div>
				</form>
			</div>
			<div id="regist_result">
				<div class="into">
					<p>注册成功，请进行登陆！</p>
				</div>
			</div>
		</div>
	</div>

</body>
</html>