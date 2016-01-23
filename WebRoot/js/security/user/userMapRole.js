$(document).ready(function(){
	/* B 公共函数 */
	//1、判断select的option是否没有选择
	function checkSelectId(){
		/* 判断是select的option是否选择*/
		if($.trim($("#selectId  option:selected").val())=="-1"){
			window.alert("请选择所要配置角色的用户！");
			return false;
		}else{
			var userId = $.trim($("#selectId  option:selected").val());
			var url = "userMapRole_!leftList.action?userId="+userId;
			window.location.href=url;
		    return true;
		}
	}

	//2、防止重复提交函数
	function doSubmit(){
		if(formSubmitFlag == false){
			formSubmitFlag = true;//表单提交后，让标识符设置为true
			return true;//让表单正常提交
		}else{
			window.alert("该表单已经提交过！");
			return false;//表单已经提交过，不让该表单再次提交；
		}
	}
	/* E 公共函数 */
	
	var formSubmitFlag = false;//表单是否提交标识符，默认为false,即没有提交
	
	/*判断select的option*/
	$("#selectId").change(checkSelectId);
	

	/* 提交表单判断 */
	$("#mysubmit").bind("click",function(){
		//1、判断select的option
		var resultSelectId = checkSelectId();
		if(!resultSelectId){
			//不允许表单提交
			return false;
		}

		//2、判断表单是否已提交
		var resultDoSubmit = doSubmit();
		if(!resultDoSubmit){
			//禁止表单提交
			return false;
		}
		
		return true;
	});
	
	
	//返回主页
	$("#fanhuibutton").bind("click",function(){
		$("#fanhuiform").attr("action","jumpToIndexAdmin.action");
		$("#fanhuiform").submit();
	});
	
});