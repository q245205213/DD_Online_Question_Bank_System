
$(document).ready(function(){
	var j = $("#i").val();
	for(var i = 1 ; i <= j ; i ++){
		$("#modifyButton"+i).bind("click", {index: i}, clickShow);
		$("#backButton"+i).bind("click", {index: i}, clickHide);
	}		
	function clickShow(event) {
		var index = event.data.index;
		$("#questionUpload"+index).toggle();
	}
	function clickHide(event) {
		var index = event.data.index;
		$("#questionUpload"+index).hide();
	}
	
	for(var i = 1 ; i <= j ; i ++){
		$("#group1"+i).bind("click", {index: i}, linkage);
	}	
	var url = "questionGroup.json";
	var groupJson;
	var group = $(".group1");
	$.getJSON(url,function(data){
		groupJson = data;
		$.each(groupJson,function(index,element){
			group.append("<option>" + element.group1 + "</option>");
		})
	
	})
	function linkage(event) {
		var index = event.data.index;
		var group1 = $("#group1"+index);
		var group2 = $("#group2"+index);
		var group3 = $("#group3"+index);
		
		var group11 = function(){
			var n = group1.get(0).selectedIndex;
			group2.html("");
			console.log(group1.val());
			$.each(groupJson[n-1].next1,function(index,element){
				group2.append("<option>" + element.group2 + "</option>")
			})
			group22();
			if(group1.val()=='社会职业'){
				group3.hide();
			}
			else{group3.show();}
		}
		var group22 = function(){
			var n = group1.get(0).selectedIndex;
			var m = group2.get(0).selectedIndex;
			group3.html("<option value=''>请选择</option>");
			console.log(n);
			$.each(groupJson[n-1].next1[m].next2,function(index,element){
				group3.append("<option>" + element.group3 + "</option>")
			})
			
		}
		group1.change(function(){
			group11();
		})
		group2.change(function(){
			group22();
		})
	}
	/*
	$(".recordShow").click(function(){
		$(".question-upload").show();
	});*/
	/*$(".recordHide").click(function(){
		$(".question-upload").hide();
	});*/
	/*var d1 = $(".editor11")[0].contentWindow.document; 
	var d2 = $(".editor22")[0].contentWindow.document; 
	var d3 = $(".editor33")[0].contentWindow.document; 
	d1.designMode = "On";
	d2.designMode = "On";
	d3.designMode = "On";	
	d1.contentEditable = true;
	d2.contentEditable = true;
	d3.contentEditable = true;
	d1.open();
	d2.open();
	d3.open();
	d1.close();
	d2.close();
	d3.close();*/
})
