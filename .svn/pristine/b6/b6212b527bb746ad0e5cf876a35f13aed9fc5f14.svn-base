$(document).ready(function(){
	/* B 定义该页面公用的函数*/
	//1、判断角色名
	function checkRoleName(){
		/* 判断角色名是否为空*/
		if($.trim($("#roleName").val())==""){
			window.alert("角色名不可以为空！");
			//$("#roleName").focus();
			return false;
		}else{
			/*判断角色名是否合法*/
			var reg=/^ROLE_[a-zA-Z0-9_-]+$/;
			if(!reg.test($.trim($("#roleName").val()))){
				//window.alert("角色名格式不正确！格式要求：以ROLE_开头，后面接有字母、数字和下划线组成的串!");
				window.alert("角色名格式不正确！");
				//$("#roleName").focus();
				return false;
			}else{
				return true;
			}
		} 
	}

	//2、判断角色描述
	function checkDescription(){
		/* 判断角色描述是否为空*/
		if($.trim($("#description").val())==""){
			window.alert("角色描述不能为空！");
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
	/* E 公共函数*/

	
	
	var formSubmitFlag = false;//表单是否提交标识符，默认为false,即没有提交
	/*失去焦点判断角色名   */
	$("#roleName").change(checkRoleName);
	/* 失去焦点判断角色描述 */
	$("#description").change(checkDescription);


	
	/* 提交表单判断 */
	$("#mysubmit").bind("click",function(){
		//1、判断角色名
		var resultRoleName = checkRoleName();
		if(!resultRoleName){
			//禁止表单提交
			return false;
		}
		//2、判断角色描述
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
		$("input:radio[name='role.enabled']:eq(0)").attr("checked","checked");
		//$("input:radio[name=role.enabled]:nth(1)").attr('checked',false);

		//重置：角色描述
		$("#description").val("");
		
		//重置：是否是超级用户
		$("input:radio[name='role.isSys']:eq(0)").attr("checked","checked");
		//$("input:radio[name=role.isSys]:nth(0)").attr('checked',true);
		//$("input:radio[name=role.isSys]:nth(1)").attr('checked',false);
		return true;
		
	});*/
	
	//返回主页
	$("#fanhuibutton").bind("click",function(){
		$("#fanhuiform").attr("action","jumpToIndexAdmin.action");
		$("#fanhuiform").submit();
	});
	
});

function goback(){
	var url= "searchRoleAction_!back.action";
	window.location.href=url;
    return true;
}
