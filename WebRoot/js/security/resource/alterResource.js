$(document).ready(function(){
	/* B 该页面的公共函数 */
	//1、判断资源名称
	function checkResourceName(){
		/* 判断资源名称是否为空*/
		if($.trim($("#resourceName").val())==""){
			window.alert("资源名称不可以为空！");
			//$("#resourceName").focus();
			return false;
		}else{
			/*判断资源名称是否合法*/
			var reg=/^RESO_[a-zA-Z0-9_-]+$/;
			if(!reg.test($.trim($("#resourceName").val()))){
				//window.alert("资源名称格式不正确！格式要求：以RESO_开头，后面接有字母、数字和下划线组成的串!");
				window.alert("资源名称格式不正确！");
				//$("#resourceName").focus();
				return false;
			}else{
				return true;
			}
		} 
	}
	
	//1.2resourceType触发的事件
	function resourceTypeClick(resourceType){
		var url = "searchDeleteResourceAction_!ResourceStringList.action?resource.type="+resourceType;
		window.location.href=url;
	    return true;

	}
	
	//2、判断资源链接
	function checkResourceString(){
		/* 判断资源链接是否为空*/
		if($.trim($("#resourceString").val())==""){
			window.alert("资源链接不可以为空！");
			//$("#resourceString").focus();
			return false;
		}else{
			/*判断资源链接是否合法
			
			var reg=/^\/(\w+)(_)*(!\w+)*.action$/;
			if(!reg.test($.trim($("#resourceString").val()))){
				window.alert("资源链接格式不正确！格式要求：以" + "/" + "开始，后接数据字母下划线感叹号组成的字符串，以"+".action" +"结尾.");
				$("#resourceString").focus();
				return false;
			}else{
				return true;
			}*/
			
			//目前不用判断
			return true;
		} 
	}

	//3、判断资源描述
	function checkDescription(){
		/* 判断资源描述是否为空*/
		if($.trim($("#description").val())==""){
			window.alert("资源描述不能为空！");
			//$("#description").focus();
			return false;
		}else{
			return true;
		}
	}
	//4、防止重复提交函数
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
	/* 页面初始化的时候就让权限名称不能修改 */
	$("resourceName").attr("disabled","disabled");
	
	/*判断资源名称   */
	$("#resourceName").change(checkResourceName);
	/*判断资源链接*/
	$("#resourceString").change(checkResourceString);
	/* 判断资源描述 */
	$("#description").change(checkDescription);
	
	/* 资源类型绑定click事件 */
	$("#resourceTypeAction").bind("click",function(){
		resourceTypeClick("action");
	});
	$("#resourceTypeUrl").bind("click",function(){
		resourceTypeClick("url");
	});
	
	
	
	
	/* 提交表单判断 */
	$("#mysubmit").bind("click",function(){
		//1、判断资源名称
		var resultResourceName = checkResourceName();
		if(!resultResourceName){
			//禁止表单提交
			return false;
		}
		//2、判断资源链接
		var resultResourceString = checkResourceString();
		if(!resultResourceString){
			//禁止表单提交
			return false;
		}
		//3、判断资源描述
		var resultDescription = checkDescription();
		if(!resultDescription){
			//禁止表单提交
			return false;
		}
		//4、判断表单是否已提交
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
		//重置：资源类型
		$("input:radio[name='resource.type']:eq(0)").attr("checked","checked");
		$("input:radio[name='resource.type']:eq(1)").removeAttr("checked");
		//重置：资源链接
		// $("#resourceString").val(""); 
		$("#resourceString option[value='-1']").attr("selected","selected")
		//重置：角色描述
		$("#description").val("");
		//重置：是否被禁用
		$("input:radio[name='resource.enabled']:eq(0)").attr("checked","checked");
		$("input:radio[name='resource.enabled']:eq(1)").removeAttr("checked");
		//重置：是否是超级用户
		$("input:radio[name='resource.isSys']:eq(0)").attr("checked","checked");
		$("input:radio[name='resource.isSys']:eq(1)").removeAttr("checked");
		return false;	
	});*/
	
	//返回主页
	$("#fanhuibutton").bind("click",function(){
		$("#fanhuiform").attr("action","jumpToIndexAdmin.action");
		$("#fanhuiform").submit();
	});
	
});

function goback(){
	var url= "searchDeleteResourceAction_!back.action";
	window.location.href=url;
    return true;
}