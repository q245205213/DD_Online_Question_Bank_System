<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/adminIndex.css" />
<link rel="stylesheet" type="text/css"
	href="css/adminPersonalCenter.css" />
<link rel="stylesheet" type="text/css"
	href="css/adminQuestionUpload.css" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<title>DD在线题库系统：题目上传</title>
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/questionUpload.js"></script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
</head>
<body>
	<div class="navigetion">
		<div class="nav_index">
			<h1>
				<a href="adminAuditRecordReturn">DD在线题库系统管理员平台</a>
			</h1>
		</div>
		<div class="nav_account">
			<ul>
				<li><s:a id="cancel" action="cancel">注销</s:a></li>
				<li><a href="adminQuestionUpload">题目上传</a></li>
			</ul>
		</div>
	</div>
	<div class="container_main">
		<div class="operation">
			<ul>
				<li><a href="adminAuditRecordReturn">题目审核</a></li>
				<li><a href="adminQuestionUpload">题目上传</a></li>
				<li><a href="adminUploadRecordReturn">上传记录</a></li>
				<li><a href="adminAuditPassReturn">审核通过</a></li>
			</ul>
		</div>
		<div class="user-infomation" id="question-upload">
			<div class="question-upload">
				<form action="AdminQuestionUpload2" method="post"  id="form-upload">
					<div>
						<p>题目类型：</p>
						<select name="select" id="select-queTitle">
							<option>选择题</option>
							<option>填空题</option>
							<option>判断题</option>
							<option>解答题</option>
						</select>
					</div>
					<div class="question-group">
						<p>题目分组：</p>
						<div>
							<select name="group1" id="group1">
								<option>请选择</option>
							</select> 
							<select name="group2" id="group2">
								<option>请选择</option>
							</select> 
							<select name="group3" id="group3">
								<option>请选择</option>
							</select>
						</div>
					</div>
					<div class="quetion-title">
						<p>题目标题：</p>
						<input type="text" name="queTitle" id="text-queTitle" value="" />
					</div>
					<div class="textareBox">
						<p>题目问题：</p>
						<textarea  name="queContent" rows="" ></textarea>
							<script type="text/javascript">
							var myedito = CKEDITOR.replace("queContent",
							{ toolbar:'Basic', 
							width:600,
							height:150
							});
							</script>
						<!-- <iframe name="queContent" id="editor1"></iframe> -->
					</div>
					<div class="textareBox">
					<p>题目答案：</p>
						<textarea  name="queAnswer" rows="" ></textarea>
							<script type="text/javascript">
							var myedito = CKEDITOR.replace("queAnswer",
							{ toolbar:'Basic', 
							width:600,
							height:150
							});
							</script>
					<!-- 	<iframe id="editor2"></iframe> -->
					</div> 
					<div class="textareBox">
						<p>题目解析：</p>
						<textarea  name="queAnalysis" rows="" >无</textarea>
							<script type="text/javascript">
							var myedito = CKEDITOR.replace("queAnalysis",
							{ toolbar:'Basic', 
							width:600,
							height:150
							});
							</script>
						<!-- <iframe id="editor3"></iframe> -->
					</div>
					<input type="submit" id="submit-upload"	class="submit-upload button" value="确认上传" />
				</form>
			</div>
		</div>
	</div>
</body>

</html>
