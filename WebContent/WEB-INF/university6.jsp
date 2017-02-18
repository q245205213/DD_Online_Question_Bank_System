<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/university.css" />
<link rel="stylesheet" type="text/css" href="css/comment.css" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<title>DD在线题库系统：大学>人文与法学学院</title>
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/questionInformation.js"></script>
<script type="text/javascript" src="js/university.js"></script>
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
					<li><a href="#" class="university">大学</a></li>
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
				<li><a href="#" class="university">大学必修课</a></li>
				<li><a href="#" class="university2">信息科学与工程学院</a></li>
				<li><a href="#" class="university3">经济管理学院</a></li>
				<li><a href="#" class="university4">生命科学学院</a></li>
				<li><a href="#" class="university5">工程学院</a></li>
				<li><a href="#" class="university6">人文与法学学院</a></li>
				<li><a href="#" class="university7">艺术学院</a></li>
			</ul>
		</div>
		<div id="" class="category category3">
			<ul>
				<li><a href="#" id="subject1">法学基础理论</a></li>
				<li><a href="#" id="subject2">中国法律史</a></li>
				<li><a href="#" id="subject3">中国宪法</a></li>
				<li><a href="#" id="subject4">行政法</a></li>
				<li><a href="#" id="subject5">民法</a></li>
				<li><a href="#" id="subject6">刑法</a></li>
				<li><a href="#" id="subject7">合同法</a></li>
				<li><a href="#" id="subject8">国际法</a></li>
				<li><a href="#" id="subject9">经济法</a></li>
				<li><a href="#" id="subject10">知识产权法</a></li>
				<li><a href="#" id="subject11">行政诉讼法</a></li>
				<li><a href="#" id="subject12">民事诉讼法</a></li>
			</ul>
		</div>
		<div id="" class="question-content">
			<p>你的位置：<b><s:property value="#request.group1"/>><s:property value="#request.group2"/>><s:property value="#request.group3"/></b></p>
			<p>选择题型：</p>
			<select class="select" name="">
				<option>请选择</option>
				<option>选择题</option>
				<option>填空题</option>
				<option>判断题</option>
				<option>解答题</option>
			</select>			
			<input type="hidden" id="group1" value="<s:property value="#request.group1"/>">
			<input type="hidden" id="group2" value="<s:property value="#request.group2"/>">
			<input type="hidden" id="group3" value="<s:property value="#request.group3"/>">
			<input type="hidden" id="i" value="<s:property value="#request.i"/>">
			<s:iterator value="#request.universitys" status="st" id="university">		
				<s:property value="#university" escape="false"/>
			</s:iterator>
		</div>
	</div>
	<div class="collectionSuccess">
		<p>收藏成功！</p>
		<input type="button" value="确定">
	</div>
</body>
</html>
