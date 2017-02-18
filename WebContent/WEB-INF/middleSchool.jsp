<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/middleSchool.css" />
<link rel="stylesheet" type="text/css" href="css/comment.css" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<title>DD在线题库系统：中学>初一</title>
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/questionInformation.js"></script>
<script type="text/javascript" src="js/middleSchool.js"></script>
<script type="text/javascript" src="js/starScore.js"></script>
<script type="text/javascript" src="js/collection.js"></script>
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
	<div class="container_main">
		<div id="" class="group-primary">
			<div>
				<ul>
					<li><a href="#" class="middleSchool">中学</a></li>
				</ul>
			</div>
			<div id="" class="">
				<ul>
					<li><a href="#" class="primarySchool">小学</a></li>
					<li><a href="#" class="middleSchool">中学</a></li>
					<li><a href="#" class="university">大学</a></li>
					<li><a href="#" class="socialProfession">社会职业</a></li>
				</ul>
			</div>
		</div>

		<div class="operation">
			<ul>
				<li><a href="#" class="middleSchool">初一</a></li>
				<li><a href="#" class="middleSchool2">初二</a></li>
				<li><a href="#" class="middleSchool3">初三</a></li>
				<li><a href="#" class="middleSchool4">高一</a></li>
				<li><a href="#" class="middleSchool5">高二</a></li>
				<li><a href="#" class="middleSchool6">高三</a></li>
			</ul>
		</div>
		<div id="" class="category">
			<ul>
				<li><a href="#" id="subject1">语文</a></li>
				<li><a href="#" id="subject2">数学</a></li>
				<li><a href="#" id="subject3">英语</a></li>
				<li><a href="#" id="subject4">物理</a></li>
				<li><a href="#" id="subject5">化学</a></li>
				<li><a href="#" id="subject6">生物</a></li>
				<li><a href="#" id="subject7">政治</a></li>
				<li><a href="#" id="subject8">历史</a></li>
				<li><a href="#" id="subject9">地理</a></li>
			</ul>
		</div>
		<div id="" class="question-content">
			<p>你的位置：<b><s:property value="#request.group1"/>><s:property value="#request.group2"/>><s:property value="#request.group3"/></b></p>
			<p>选择题型：</p>
			<select class="select" name="">
				<option>全部</option>
				<option>选择题</option>
				<option>填空题</option>
				<option>判断题</option>
				<option>解答题</option>
			</select>
			<input type="hidden" id="i" value="<s:property value="#request.i"/>">
			<input type="hidden" id="group1" value="<s:property value="#request.group1"/>">
			<input type="hidden" id="group2" value="<s:property value="#request.group2"/>">
			<input type="hidden" id="group3" value="<s:property value="#request.group3"/>">
			<s:iterator value="#request.middleSchools" status="st" id="middleSchool">		
				<s:property value="#middleSchool" escape="false"/>
			</s:iterator>
		</div>
	</div>
	
	<div class="collectionSuccess">
		<p>收藏成功！</p>
		<input type="button" value="确定">
	</div>
</body>
</html>
