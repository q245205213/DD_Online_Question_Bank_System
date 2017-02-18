$(document).ready(function() {
	$(".star li").hover(function(){
		var num = $(this).index();  
		var list = $(this).parent().find('li');
		var starLight = "<img src=\"img/starLight.png\" width=\"20\" height=\"20\" />";
		var starDark = "<img src=\"img/starDark.png\" width=\"20\" height=\"20\" />";
		for(var i = 0 ; i <= num ; i++){  //设置从第一个星星到当前经过的星星都变亮
			 list.eq(i).html(starLight); 
        };
		 for(var i = num + 1 , len = list.length-1 ; i <= len ; i++){ 
             list.eq(i).html(starDark);
		}; 
		var n = num+1;
		$(".score").html("<input type=\"hidden\" name=\"comScore\" value=\""+n +"\"/>"+n+"分") 
	},function(){
		var num = $(this).index()+1; 
		$(".score").html("<input type=\"hidden\" name=\"comScore\" value=\""+num+"\"/>"+num+"分") 
		var n = $(".score input").val();
		console.log("评分是："+n);
	})
	
})