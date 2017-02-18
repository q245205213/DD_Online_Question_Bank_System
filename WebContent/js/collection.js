/**
 * 
 */
$(document).ready(function() {
	var j = $("#i").val();
	for(var i = 1 ; i <= j ; i++){
		$("#collection"+i).bind("click", {index: i}, clickShow);
	}		
	function clickShow(event) {
		var index = event.data.index;
		var queID = $("#queID"+index).html();
		console.log("queID的值是："+queID);
		$(".collectionSuccess").show();
		console.log(queID);
		$.ajax({
			type:"POST",
			url:"collection?queID="+queID,
			success:function(response){
				console.log("response");
			}
		});
		return false;
	}

	$(".collectionSuccess input").click(function(){
		$(".collectionSuccess").hide();
	})
})