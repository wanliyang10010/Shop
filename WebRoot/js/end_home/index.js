$(document).ready(function(){
	$("#button1").bind("click",function(){
		$("#myform").attr("action","jumpToRegister.action");
		$("#myform").submit();
	});
	$("#button2").bind("click",function(){
		$("#myform").attr("action","jumpToUserMapRole.action");
		$("#myform").submit();
	});
	$("#button3").bind("click",function(){
		$("#myform").attr("action","jumpToSearchDeleteUser.action");
		$("#myform").submit();
	});
	
	$("#button4").bind("click",function(){
		$("#myform").attr("action","jumpToAddRole.action");
		$("#myform").submit();
	});
	$("#button5").bind("click",function(){
		$("#myform").attr("action","jumpToRoleMapAuthority.action");
		$("#myform").submit();
	});
	$("#button6").bind("click",function(){
		$("#myform").attr("action","jumpToSearchRole.action");
		$("#myform").submit();
	});
	
	$("#button7").bind("click",function(){
		$("#myform").attr("action","jumpToAddAuthority.action");
		$("#myform").submit();
	});
	$("#button8").bind("click",function(){
		$("#myform").attr("action","jumpToAuthorityMapResource.action");
		$("#myform").submit();
	});
	$("#button9").bind("click",function(){
		$("#myform").attr("action","jumpToSearchDeleteAuthority.action");
		$("#myform").submit();
	});
	
	$("#button10").bind("click",function(){
		$("#myform").attr("action","jumpToAddResource.action");
		$("#myform").submit();
	});
	$("#button11").bind("click",function(){
		$("#myform").attr("action","jumpToSearchDeleteResource.action");
		$("#myform").submit();
	});

	//注销
	$("#zhuxiaobutton").bind("click",function(){
		$("#zhuxiaoform").attr("action","logoutAdmin.action");
		$("#zhuxiaoform").submit();
	});
	
	
});