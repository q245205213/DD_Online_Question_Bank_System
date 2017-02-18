$(document).ready(function(){

//	个人中心页面跳转
	$("#a-comment").click(function(){
		window.location="commentRecord";
	});
	$("#a-upload").click(function(){
		window.location="questionUpload";
	});
	$("#a-infomation").click(function(){
		window.location="personalCenter";
	});
	$("#cancel").click(function(){
		window.location="cancel";
	});
	$("#personalCenter").click(function(){
		window.location="personalCenter";
	});
	$("#logo_index").click(function(){
		window.location="logo_index";
	});
//	隐藏显示个人信息修改框
	$("#bt-modify").click(function(){
		$("#infomation").hide();
		$("#modify-ui").show();
	});
	
});
