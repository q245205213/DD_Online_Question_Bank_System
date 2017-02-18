<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<title>欢迎来到DD在线题库系统</title>
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/commonJump.js"></script>
</head>
<body>
	<div class="navigetion">
		<div class="nav_index">
			<h1>
				<a id="logo_index" href="#">DD在线题库系统</a>
			</h1>
		</div>
		<div class="nav_account">
			<ul>
				<li><a id="cancel" href="#">注销</a></li>
				<li><a id="personalCenter" href="#">个人中心</a></li>
				<li><b><s:property value="#session.username" />的</b></li>
			</ul>
		</div>
	</div>
	<div class="container_main others">
		<div class="big-div">
			<div class="arrow-left">
				<a id="arrow-left" href="javascript:void(0);"><img
					src="img/arrow3.png" alt="" height="80" width="80" /></a>
			</div>
			<div id="focus">
				<a href="#" class="primarySchool"><img src="img/5.jpg" width="810" height="500"></a> 
				<a href="#" class="middleSchool"><img src="img/2.jpg" width="810" height="500"></a> 
				<a href="#"	class="university"><img src="img/7.jpg" width="810"	height="500"></a> 
				<a href="#" class="socialProfession"><img src="img/8.jpg" width="810" height="500"></a>
			</div>
			<div id="" class="arrow-right">
				<a id="arrow-right" href="javascript:void(0);"><img
					src="img/arrow4.png" alt="" height="80" width="80" /></a>
			</div>
		</div>
		<div class="little-div">
			<div>
				<a href="#" class="primarySchool"> <img src="img/5.jpg"
					width="200" height="150" />
				</a>
				<div id="">小学</div>
			</div>
			<div>
				<a href="#" class="middleSchool"> <img src="img/2.jpg"
					width="200" height="150" />
				</a>
				<div id="">中学</div>
			</div>
			<div>
				<a href="#" class="university"> <img src="img/7.jpg" width="200"
					height="150" />
				</a>
				<div id="">大学</div>
			</div>
			<div>
				<a href="#" class="socialProfession"> <img src="img/8.jpg"
					width="200" height="150" />
				</a>
				<div id="">社会职业</div>
			</div>
		</div>
	</div>
</body>
</html>