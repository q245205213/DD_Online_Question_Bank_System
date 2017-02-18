/**
 * 
 */
$(document).ready(function() {
	$("#cancel").click(function(){
		window.location="cancel";
	});
	$("#logo_index").click(function(){
		window.location="logo_index";
	});
	$("#personalCenter").click(function(){
		window.location="personalCenter";
	});
//	轮播图
	var index=1;//当前显示的第几张图，默认开始为0；
	var mg=$("#focus a");//将焦点图储存为一个变量方便调用节省下载调用查询时间。
	var len=mg.length;//焦点图图片数量
	var set = setInterval(roll,3000);
	function roll(){
//		mg.eq(2).fadeIn(200).siblings("img").fadeOt(200);
		
		mg.eq(index).fadeIn(500).siblings().hide();
		index++;
		if(index>=len){
			index=0;
		}
	}
	$("#focus").hover(function(){
		clearInterval(set);
	},function(){
		set = setInterval(roll,3000);
	})
	$("#arrow-left").click(function(){
		console.log(index);
		clearInterval(set);
		index--;
		mg.eq(index-1).fadeIn(500).siblings().hide();
		if(index<0){
			index=len-1;
		}
	})
	$("#arrow-right").click(function(){
		console.log(index);
		clearInterval(set);
		
		mg.eq(index).fadeIn(500).siblings().hide();
		index++;
		if(index>=len){
			index=0;
		}
	})
});