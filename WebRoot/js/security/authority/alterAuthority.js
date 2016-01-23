$(document).ready(function(){
	/* B 该页面的公共函数 */
	//1、判断权限名称
	function checkAuthorityName(){
		/* 判断权限名称是否为空*/
		if($.trim($("#authorityName").val())==""){
			window.alert("权限名称不可以为空！");
			//$("#authorityName").focus();
			return false;
		}else{
			/*判断权限名称是否合法*/
			var reg=/^AUTH_[a-zA-Z0-9_-]+$/;
			if(!reg.test($.trim($("#authorityName").val()))){
				//window.alert("权限名称格式不正确！格式要求：以AUTH_开头，后面接有字母、数字和下划线组成的串!");
				window.alert("权限名称格式不正确！");
				//$("#authorityName").focus();
				return false;
			}else{
				return true;
			}
		} 
	}
	//2、判断权限描述
	function checkDescription(){
		/* 判断权限描述是否为空*/
		if($.trim($("#description").val())==""){
			window.alert("权限描述不能为空！");
			//$("#description").focus();
			return false;
		}else{
			return true;
		}
	}
	//3、防止重复提交函数
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
	/*判断权限名称   */
	$("#authorityName").change(checkAuthorityName);
	/* 判断权限描述 */
	$("#description").change(checkDescription);
	/* 提交表单判断 */
	$("#mysubmit").bind("click",function(){
		//1、判断权限名称
		var resultAuthorityName = checkAuthorityName();
		if(!resultAuthorityName){
			//禁止表单提交
			return false;
		}
		//2、判断权限描述
		var resultDescription = checkDescription();
		if(!resultDescription){
			//禁止表单提交
			return false;
		}
		//3、判断表单是否已提交
		var resultDoSubmit = doSubmit();
		if(!resultDoSubmit){
			//禁止表单提交
			return false;
		}
		return true;
	});


	/* 重置 */
	/* 暂时不使用
	$("#myreset").bind("click",function(){
		//重置：是否被禁用
		//$("input:radio[name=role.enabled]:nth(0)").attr('checked',true);
		//$("input:radio[name='authority.enabled']:eq(0)").removeAttr("checked");
		//$("input:radio[name='authority.enabled']:eq(1)").removeAttr("checked");
		//$("input:radio[name='authority.enabled']:checked").attr("checked",false);
		$("input:radio[name='authority.enabled'][value='0']").attr("checked",true);
		$("input:radio[name='authority.enabled'][value='1']").attr("checked",false);
		//$("input:radio[name='authority.enabled']:eq(1)").attr("checked",false);
		//$("input:radio[name=role.enabled]:nth(1)").attr('checked',false);

		
		
		//重置：是否是超级用户
		//$("input:radio[name='authority.isSys']:eq(0)").removeAttr("checked");
		//$("input:radio[name='authority.isSys']:eq(1)").removeAttr("checked");
		//$("input:radio[name='authority.isSys']:checked").attr("checked",false);
		$("input:radio[name='authority.isSys'][value='0']").attr("checked",true);
		$("input:radio[name='authority.isSys'][value='1']").attr("checked",false);
		//$("input:radio[name='authority.isSys']:eq(1)").attr("checked",false);
		//$("input:radio[name=role.isSys]:nth(0)").attr('checked',true);
		//$("input:radio[name=role.isSys]:nth(1)").attr('checked',false);

		//重置：权限描述
		$("#description").val("");
		return true;
	});*/
	
	//返回主页
	$("#fanhuibutton").bind("click",function(){
		$("#fanhuiform").attr("action","jumpToIndexAdmin.action");
		$("#fanhuiform").submit();
	});
	
});

function goback(){
	var url= "searchDeleteAuthorityAction_!back.action";
	window.location.href=url;
    return true;
}