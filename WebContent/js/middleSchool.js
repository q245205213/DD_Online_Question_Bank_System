/**
 * 
 */
$(document).ready(function(){
	$(".middleSchool6").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI("中学"));
		var group2 = encodeURI(encodeURI("高三"));
		var group3 = encodeURI(encodeURI("语文"));
		window.location="middleSchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	});
	$(".middleSchool5").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI("中学"));
		var group2 = encodeURI(encodeURI("高二"));
		var group3 = encodeURI(encodeURI("语文"));
		window.location="middleSchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	});
	$(".middleSchool4").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI("中学"));
		var group2 = encodeURI(encodeURI("高一"));
		var group3 = encodeURI(encodeURI("语文"));
		window.location="middleSchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	});
	$(".middleSchool3").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI("中学"));
		var group2 = encodeURI(encodeURI("初三"));
		var group3 = encodeURI(encodeURI("语文"));
		window.location="middleSchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	});
	$(".middleSchool2").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI("中学"));
		var group2 = encodeURI(encodeURI("初二"));
		var group3 = encodeURI(encodeURI("语文"));
		window.location="middleSchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	});

	$("#subject1").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI($("#group2").val()));
		var group3 = encodeURI(encodeURI($(this).html()));
		window.location="middleSchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	})
	$("#subject2").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI($("#group2").val()));
		var group3 = encodeURI(encodeURI($(this).html()));
		window.location="middleSchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	})
	$("#subject3").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI($("#group2").val()));
		var group3 = encodeURI(encodeURI($(this).html()));
		window.location="middleSchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	})
	$("#subject4").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI($("#group2").val()));
		var group3 = encodeURI(encodeURI($(this).html()));
		window.location="middleSchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	})
	$("#subject5").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI($("#group2").val()));
		var group3 = encodeURI(encodeURI($(this).html()));
		window.location="middleSchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	})
	$("#subject6").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI($("#group2").val()));
		var group3 = encodeURI(encodeURI($(this).html()));
		window.location="middleSchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	})
	$("#subject7").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI($("#group2").val()));
		var group3 = encodeURI(encodeURI($(this).html()));
		window.location="middleSchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	})
	$("#subject8").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI($("#group2").val()));
		var group3 = encodeURI(encodeURI($(this).html()));
		window.location="middleSchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	})
	$("#subject9").click(function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI($("#group2").val()));
		var group3 = encodeURI(encodeURI($(this).html()));
		window.location="middleSchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	})

	$(".select").bind('change',function(){
		var queType = encodeURI(encodeURI($(".select").val()));
		var group1 = encodeURI(encodeURI($("#group1").val()));
		var group2 = encodeURI(encodeURI($("#group2").val()));
		var group3 = encodeURI(encodeURI($("#group3").val()));
		window.location="middleSchool?group1="+group1+"&group2="+group2+"&group3="+group3+"&queType="+queType;
	});
})