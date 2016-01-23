$(document).ready(function(){
	/* B 定义该页面公用的函数*/
	//1、判断角色名
	function checkRoleName(){
		/* 判断角色名是否为空*/
		if($.trim($("#roleName").val())==""){
			window.alert("角色名不可以为空！");
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
				/* var isExsited = $.trim($("#isExsited").val());
				if(isExsited == "" || isExsited == "true"){
					var roleName = $.trim($("#roleName").val());
					url= "roleAction_!checkRoleName?role.roleName="+roleName;
					window.location.href=url;
					return true;
				}else{
					return true;
				} */

				var roleName = $.trim($("#roleName").val());
				$.ajax({
					 type:"POST", 
			         //url:"userActioncheckAcccount", 
			         url:"roleAction_!checkRoleName.action",
			         //dataType:"json",      
			         //contentType:"application/json",               
			         data:"role.roleName="+roleName,
			         async: true, 
			         success:function(result){
			         	/* var resultobj = $.parsejson(result);
			         	ajaxobj=eval("("+data+")");  */ 
			         	var returnIsExisted = result.responseJson.isExsited;
			            if(returnIsExisted == "true")  
			            {  
			                alert("该角色名称已存在！");
			                //$("#roleName").focus();
			                return true;  
			            }else{
			            	return true;  
				        } 
					}
				});
				
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
	$("#roleName").blur(checkRoleName);
	/* 失去焦点判断角色描述 */
	$("#description").change(checkDescription);
	/* 提交表单判断 */
	$("#mysubmit").bind("click",function(){
		//1、判断角色名
		if($.trim($("#roleName").val())==""){
			window.alert("角色名不可以为空！");
			return false;
		}
		//2、判断角色描述
		var resultDescription = checkDescription();
		if(!resultDescription){
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
	
	//返回主页
	$("#fanhuibutton").bind("click",function(){
		$("#fanhuiform").attr("action","jumpToIndexAdmin.action");
		$("#fanhuiform").submit();
	});
	
});