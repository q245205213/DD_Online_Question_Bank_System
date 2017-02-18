$(document).ready(function(){

	$(".primarySchool6").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI("六年级"));
		var group3 = encodeURI(encodeURI("语文"));
		window.location="primarySchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	});
	$(".primarySchool5").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI("五年级"));
		var group3 = encodeURI(encodeURI("语文"));
		window.location="primarySchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	});
	$(".primarySchool4").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI("四年级"));
		var group3 = encodeURI(encodeURI("语文"));
		window.location="primarySchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	});
	$(".primarySchool3").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI("三年级"));
		var group3 = encodeURI(encodeURI("语文"));
		window.location="primarySchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	});
	$(".primarySchool2").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI("二年级"));
		var group3 = encodeURI(encodeURI("语文"));
		window.location="primarySchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	});

	$("#subject1").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI($("#group2").val()));
		var group3 = encodeURI(encodeURI($(this).html()));
		window.location="primarySchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	})
	$("#subject2").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI($("#group2").val()));
		var group3 = encodeURI(encodeURI($(this).html()));
		window.location="primarySchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	})
	$("#subject3").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI($("#group2").val()));
		var group3 = encodeURI(encodeURI($(this).html()));
		window.location="primarySchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	})
	$("#subject4").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI($("#group2").val()));
		var group3 = encodeURI(encodeURI($(this).html()));
		window.location="primarySchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	})

	$(".select").bind('change',function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI($("#group2").val()));
		var group3 = encodeURI(encodeURI($("#group3").val()));
		window.location="primarySchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	});
})
