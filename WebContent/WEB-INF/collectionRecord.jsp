<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/personalCenter.css" />
<link rel="stylesheet" type="text/css" href="css/collectionRecord.css" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<title>DD在线题库系统：收藏记录</title>
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/personalCenter.js"></script>
</head>
<body>
	<!--<img src="img/tile-picture.jpeg"/>-->
	<div class="navigetion">
		<div class="nav_index">
			<h1>
				<a id="logo_index" href="#">DD在线题库系统</a>
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
			<input type="hidden" id="i" value="<s:property value="#session.i"/>">
			<table id="tab-collection" border="1">
				<tr>
					<th>题目ID</th>
					<th>题目类型</th>
					<th id="th-three">题目标题</th>
					<th id="th-four">操作</th>
				</tr>
				<s:iterator value="#session.collectionRecords" status="st" id="collectionRecord">
					<s:property value="#collectionRecord" escape="false"/>		
				</s:iterator>
				<!-- <tr>
					<td>1</td>
					<td>选择题</td>
					<td>广东省廉江市石颈镇石颈小学五年级数学第二次摸底考试第七题</td>
					<td><a href="">查看</a></td>
				</tr> -->
			</table>
		</div>
	</div>
</body>

</html>
