$(document).ready(function(){
	$("#hide").click(function(){
		$("#login").hide();
		$("#regist").show();
		$("#regist_result").hide();
	});
	$("#show").click(function(){
		$("#login").show();
		$("#regist").hide();
		$("#regist_result").hide();
	});
	$("#password").focus(function(){
		if($(this).val().length==0){
			$("#input").css({'color':'blue','font-size':'11px','text-align':'center','position':'absolute','left':'36.5%','top':'46%'});
			$("#input").text("请输入密码！");
		}
	});
	$("#apassword").blur(function(){
		if($(this).val().length==0){
			$("#input1").css({'color':'red','font-size':'11px','text-align':'center','position':'absolute','left':'36.5%','top':'65%'});
			$("#input1").text("确认密码不能为空！");
		}
	});
	$("#apassword").keyup(function(){
		if($("#password").val()!=$("#apassword").val()){
			$("#input1").text("密码不一致，请重新输入！");
			$("#input1").css({'color':'red','font-size':'11px','text-align':'center','position':'absolute','left':'36.5%','top':'65%'});
		}
		else{
			$("#input1").text("");
		}
	});
	$("#password").blur(function(){
		
		if($(this).val().length==0){
			$("#input").css({'color':'red','font-size':'11px','text-align':'center','position':'absolute','left':'36.5%','top':'46%'});
			$("#input").text("密码不能为空！");
		}
		else{
			$("#input").text("");
		}
	});
	$("#regist_user").focus(function(){
		if($(this).val().length==0){
				$("#input2").css({'color':'blue','font-size':'11px','text-align':'center','position':'absolute','left':'36.5%','top':'26%'});
				$("#input2").text("请输入用户名！");
		}
	})
	$("#regist_user").keyup(function(){
		var user = $(this).val();
		$.post("regist_user?account="+user,null,function(response){	
			console.log(response);

			if(response==user){
				
				$("#input2").css({'color':'red','font-size':'11px','text-align':'center','position':'absolute','left':'36.5%','top':'26%'});
				$("#input2").text("用户已存在，请重新输入！");
			}
			else{
				$("#input2").css({'color':'black','font-size':'11px','text-align':'center','position':'absolute','left':'36.5%','top':'26%'});
				$("#input2").text("可以使用该用户名！");
			}
		});
	});
	$("#regist_user").blur(function(){
		var user = $(this).val();
		$.post("regist_user?account="+user,null,function(response){	
			console.log(response);
			/*if($(this).val()==null){
				$("#input2").css({'color':'red','font-size':'11px','text-align':'center','position':'absolute','left':'36.5%','top':'26%'});
				$("#input2").text("用户名不能为空！");
			}*/

			if(user.length==0){
				$("#input2").css({'color':'red','font-size':'11px','text-align':'center','position':'absolute','left':'36.5%','top':'26%'});
				$("#input2").text("用户名不能为空");
			}

			else if(response==user){
				
				$("#input2").css({'color':'red','font-size':'11px','text-align':'center','position':'absolute','left':'36.5%','top':'26%'});
				$("#input2").text("用户已存在，请重新输入！");
			}
			else{
				$("#input2").css({'color':'black','font-size':'11px','text-align':'center','position':'absolute','left':'36.5%','top':'26%'});
				$("#input2").text("可以使用该用户名！");
			}
		});
	});
//	注册
	$("#submit_regist").click(function(){
		if($("#password").val()!=$("#apassword").val()){
			$("#input1").text("密码不一致，请重新输入！");
			$("#input1").css({'color':'red','font-size':'11px','text-align':'center','position':'absolute','left':'36.5%','top':'65%'});
		}
		var user = $("#regist_user").val();
		var password = $("#password").val();
		var apassword = $("#apassword").val();
		var form1 = $("#regist_form");
		form1.submit(function(){
			$.ajax({
				type:"POST",
				url:"regist?account="+user+"&password="+password+"&password1="+apassword,
				success:function(response){
//					alter(response);	
					console.log(response); 
					if(response=="aaa"){
						$("#regist_result").show();
						$("#regist").hide();
						
					}					
					else if(response=="bbb"){
						
					}					
				}
			});
			return false;
		});
	});
//	登陆
	$("#submit_login").click(function(){
		var user = $("#login_user").val();
		var password = $("#login_password").val();
		var form1 = $("#login_form");
		form1.submit(function(){
			$.ajax({
				type:"POST",
				url:"login?account="+user+"&password="+password,
				success:function(response){
					console.log(response);
					if(response=="null"){
						$("#input3").css({'color':'red','font-size':'11px','text-align':'center','position':'absolute','left':'33.5%','top':'32%'});
						$("#input3").text("用户名不能为空");
					}

					else if(response=="false"){
						
						$("#input3").css({'color':'#485460','font-size':'11px','text-align':'center','position':'absolute','left':'33.5%','top':'32%'});
						$("#input3").text("用户不存在，请进行注册！");
					}
					else if(response=="success"){
						console.log(response);
						window.location="logo_index";
						$("#input3").text("");
					}
					else if(response=="admin"){
						window.location="adminAuditRecord";
					}
					else{
						$("#input3").css({'color':'red','font-size':'11px','text-align':'center','position':'absolute','left':'33.5%','top':'32%'});
						$("#input3").text("用户名或密码错误，请重新输入");
					}
				}
			});
			return false;
		});
		
	});
});


