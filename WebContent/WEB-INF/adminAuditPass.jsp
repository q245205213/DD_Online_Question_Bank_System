<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/adminIndex.css" />
<link rel="stylesheet" type="text/css" href="css/adminPersonalCenter.css" />
<link rel="stylesheet" type="text/css" href="css/adminQuestionUpload.css" />
<link rel="stylesheet" type="text/css" href="css/adminUploadRecord.css" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<title>DD在线题库系统：审核通过</title>
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/uploadRecord.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
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
				<li><a href="adminAuditPassReturn">审核通过</a></li>
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
		<div class="user-infomation" id="infomation">
			<input type="hidden" id="i" value="<s:property value="#session.i"/>">
			<s:iterator value="#session.adminAuditPasses" status="st" id="adminAuditPass">		
				<label class="label">序号：<s:property value="#st.index+1" /></label>
				<s:property value="#adminAuditPass" escape="false"/>
				<script type="text/javascript">
									var myedito = CKEDITOR.replace("ckeditor1<s:property value="#st.index+1" />",
									{ toolbar:'Basic', 
									width:700, 
									height:150
									});
									</script>	
				<script type="text/javascript">
									var myedito = CKEDITOR.replace("ckeditor2<s:property value="#st.index+1" />",
									{ toolbar:'Basic', 
									width:700,
									height:150
									});
									</script>	
				
				 <script type="text/javascript">
									var myedito = CKEDITOR.replace("ckeditor3<s:property value="#st.index+1" />",
									{ toolbar:'Basic', 
									width:700,
									height:150
									});
									</script>				
			</s:iterator>
		</div>
	</div>

</body>

</html>
