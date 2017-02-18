$(document).ready(function(){

	$("#cancel").click(function(){
		window.location="cancel";
	});
	$("#logo_index").click(function(){
		window.location="logo_index";
	});
	$("#personalCenter").click(function(){
		window.location="personalCenter";
	});
	$(".socialProfession").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI("社会职业"));
		var group2 = encodeURI(encodeURI("会计师"));
		var group3 = "";
		window.location="socialProfession?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	});
	$(".university").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI("大学"));
		var group2 = encodeURI(encodeURI("大学必修课"));
		var group3 = encodeURI(encodeURI("军事理论"));
		window.location="university?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	});
	$(".middleSchool").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI("中学"));
		var group2 = encodeURI(encodeURI("初一"));
		var group3 = encodeURI(encodeURI("语文"));
		window.location="middleSchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	});
	$(".primarySchool").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI("小学"));
		var group2 = encodeURI(encodeURI("一年级"));
		var group3 = encodeURI(encodeURI("语文"));
		window.location="primarySchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	});
	$(".group-primary div").hover(function(){
		$(".group-primary div:last-child").show();
	},function(){
		$(".group-primary div:last-child").hide();
	})
})