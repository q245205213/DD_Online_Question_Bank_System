<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/personalCenter.css" />
<link rel="stylesheet" type="text/css" href="css/questionUpload.css" />
<link rel="stylesheet" type="text/css" href="css/uploadRecord.css" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<title>DD在线题库系统：上传记录</title>
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/jquerySession.js"></script>
<script type="text/javascript" src="js/uploadRecord.js"></script>
<script type="text/javascript" src="js/personalCenter.js"></script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
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
			<%-- <div class="div-1">
				题目类型：<label><s:property value="#session.uplType1" /></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				题目分组：<s:property value="#session.group1" />&nbsp;>&nbsp;<s:property value="#session.group2" />&nbsp;>&nbsp;<s:property value="#session.group3" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				审核状态：<label><s:property value="#session.uplStatus1" /></label><br /><br /> 
				题目标题：<label><s:property value="#session.uplTitle1" /></label><br /><br /> 
				<input class="button recordShow" type="button" id=""	value="修改" /> 
				<input class="button" type="button" id="" value="删除" />
			</div>
			<div class="question-upload">
				<form class="form-upload" action="uploadRecord2">
					<div>
						<p>题目类型：</p>
						<select name="select">
							<option value="选择">选择题</option>
							<option value="填空">填空题</option>
							<option value="判断">判断题</option>
							<option value="解答">解答题</option>
						</select>
					</div>
					
					<div class="question-group">
						<p>题目分组：</p>
						<div>
							<select class="group1" name="group1">
								<option value="">请选择</option>
							</select> 
							<select class="group2" name="group2">
								<option value="">请选择</option>
							</select> 
							<select class="group3" name="group3">
								<option value="">请选择</option>
							</select>
						</div>
					</div>
					<div class="quetion-title">
						<p>题目标题：</p>
						<input type="text" name="uplTitle" class="text-queTitle" value="<s:property value="#session.uplTitle1" />" />
					</div>
					<div>
						<p>题目问题：</p> 
						<div class="textarea1">
							<textarea  name="uplContent" rows="" ><s:property value="#session.uplContent1" escape='false' /></textarea>
								<script type="text/javascript">
								var myedito = CKEDITOR.replace("uplContent",
								{ toolbar:'Basic', 
								width:700,
								height:150
								});
								</script>
						</div>
					</div>
					<div>
					<p>题目答案：</p>
						<div class="textarea2">
							<textarea  name="uplAnswer" rows="" ><s:property value="#session.uplAnswer1" escape='false' /></textarea>
								<script type="text/javascript">
								var myedito = CKEDITOR.replace("uplAnswer",
								{ toolbar:'Basic', 
								width:700,
								height:150
								});
								</script>
						</div>
					</div>
					<div>
						<p>题目解析：</p>
						<div class="textarea3">
							<textarea  name="uplAnalysis" rows="" ><s:property value="#session.uplAnalysis1" escape='false' /></textarea>
								<script type="text/javascript">
								var myedito = CKEDITOR.replace("uplAnalysis",
								{ toolbar:'Basic', 
								width:700,
								height:150
								});
								</script>
						</div>
					</div>
					<input type="submit" name="" class="submit-upload button" value="重新上传" />
				</form>
				<input type="button" name="" class="button recordHide" value="收起" />
			</div> --%>
			<input type="hidden" id="i" value="<s:property value="#session.i"/>">
			<s:iterator value="#session.uploadRecords" status="st" id="uploadRecord">
				<label class="label">序号：<s:property value="#st.index+1" /></label>
				<s:property value="#uploadRecord" escape="false"/>
					<%-- <input type="hidden" name="num" value="<s:property value="#st.index+1" />"/> --%>
				<%-- <s:property value="#i" /> --%>
			<%-- 	<s:if test="#session.uploadRecords11!=null">
					<s:property value="#session.uplTitle1" />
									
				</s:if>
				
					<s:set name="val" scope="pageScope" value="'session.uplTitle'+#i" />
					<s:property value="" />
				<s:property value="#session.uploadRecords81" escape='false'/><s:property value="#session.uplContent1" escape='false' /><s:property value="#session.uploadRecords91" escape='false'/>
				 --%><script type="text/javascript">
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
