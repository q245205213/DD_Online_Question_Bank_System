$(document).ready(function(){
	var url = "questionGroup.json";
	var groupJson;
	var group1 = $("#group1");
	var group2 = $("#group2");
	var group3 = $("#group3");
	$.getJSON(url,function(data){
		groupJson = data;
//		alter(groupJson);
		console.log(groupJson); 
		$.each(groupJson,function(index,element){
			group1.append("<option value='" + element.group1 + "'>" + element.group1 + "</option>");
		})
	
	})
	var group11 = function(){
		var n = group1.get(0).selectedIndex;
		group2.html("");
		console.log(group1.val());
		$.each(groupJson[n-1].next1,function(index,element){
			group2.append("<option value='" + element.group2 + "'>" + element.group2 + "</option>")
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
			group3.append("<option value='" + element.group3 + "'>" + element.group3 + "</option>")
		})
		
	}
	group1.change(function(){
		group11();
	})
	group2.change(function(){
		group22();
	})
	/*var d1 = $("#editor1")[0].contentWindow.document; 
	var d2 = $("#editor2")[0].contentWindow.document; 
	var d3 = $("#editor3")[0].contentWindow.document; 
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
//	$("#submit-upload").click(function(){
//		var a = $("#select-queTitle").val();
//		alter(a);
//		console.log(a+"hi");
//		$.post("questionUpload2");
//	})
})
