$(document).ready(function(){
	var j = $("#i").val();
	for(var i = 1 ; i <= j ; i ++){
		$("#a-answer"+i).bind("click", {index: i}, clickAnswer);
		$("#comment"+i).bind("click", {index: i}, clickComment);
	}	
	function clickAnswer(event) {
		var index = event.data.index;
		$("#answer-analysis"+index).toggle();
	}
	function clickComment(event) {
		var index = event.data.index;
		$("#commentContent"+index).toggle();
	}
})
