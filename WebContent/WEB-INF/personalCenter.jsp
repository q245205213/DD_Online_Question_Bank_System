<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/personalCenter.css" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<title>DD在线题库系统：个人中心</title>
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/personalCenter.js"></script>
</head>
<body>
	<!--<img src="img/tile-picture.jpeg"/>-->
	<div class="navigetion">
		<div class="nav_index">
			<h1>
				<a href="#" id="logo_index">DD在线题库系统</a>
			</h1>
		</div>
		<div class="nav_account">
			<ul>
				<li><a href="#" id="cancel">注销</a></li>
				<li><a href="#" id="personalCenter">个人中心</a></li>
				<li><b><s:property value="#session.username" />的</b></li>
			</ul>
		</div>
	</div>
	<div class="container_main">
		<div class="operation">
			<ul>
				<li><a href="#" id="a-infomation">个人信息</a></li>
				<li><a href="#" id="a-upload">题目上传</a></li>
				<li><a href="collectionRecord">收藏记录</a></li>
				<li><a href="uploadRecord">上传记录</a></li>
				<li><a href="commentRecord">评论记录</a></li>
			</ul>
		</div>
		<div class="user-infomation" id="infomation">
			<div class="infomation">
				<div>
					<p>姓名：</p>
					<p>年龄：</p>
					<p>性别：</p>
					<p>身份：</p>
					<p>手机：</p>
					<p>住址：</p>
				</div>
				<div id="userInfo">
					<p><s:property value="#session.name"/></p>
					<p><s:property value="#session.age"/></p>
					<p><s:property value="#session.sex"/></p>
					<p><s:property value="#session.identity"/></p>
					<p><s:property value="#session.mobile"/></p>
					<p><s:property value="#session.address"/></p>
				</div>
				<input class="button" type="button" id="bt-modify" value="修改信息" />
			</div>
		</div>
		<div class="user-infomation" id="modify-ui">
			<div class="infomation">
				<div>
					<p>姓名：</p>
					<p>年龄：</p>
					<p>性别：</p>
					<p>身份：</p>
					<p>手机：</p>
					<p>住址：</p>
				</div>
				<form action="userInformation" method="post" id="form-infomation">
					<input type="text" name="name" id="name" value="" /> 
					<input type="text" name="age" id="age" value="" /> 
					<input type="text" name="sex" id="sex" value="" /> 
					<input type="text" name="identity" id="identity" value="" /> 
					<input type="text" name="mobile" id="mobile" value="" />
					<input type="text" name="address" id="address" value="" /> 
					<input class="button" type="submit" id="bt-submit" value="确认修改" />
				</form>
			</div>
		</div>
	</div>
</body>

</html>
