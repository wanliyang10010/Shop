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
				/* var isExsited = $.trim($("#isExsited").val());
				if(isExsited == "" || isExsited == "true"){
					var authorityName = $.trim($("#authorityName").val());
					url= "authorityAction_!checkAuthorityName?authority.authorityName="+authorityName;
					window.location.href=url;
					return true;
				}else{
					return true;
				} */
				var authorityName = $.trim($("#authorityName").val());
				$.ajax({
					 type:"POST", 
			         //url:"userActioncheckAcccount", 
			         url:"authorityAction_!checkAuthorityName.action",
			         //dataType:"json",      
			         //contentType:"application/json",               
			         data:"authority.authorityName="+authorityName,
			         async: true, 
			         success:function(result){
			         	/* var resultobj = $.parsejson(result);
			         	ajaxobj=eval("("+data+")");  */ 
			         	var returnIsExisted = result.responseJson.isExsited;
			            if(returnIsExisted == "true")  
			            {  
			                alert("该权限名称已存在！");
			                //$("#authorityName").focus();
			                return true;  
			            }else{
			            	return true;  
				        } 
					}
				});
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
	$("#authorityName").blur(checkAuthorityName);
	/* 判断权限描述 */
	$("#description").change(checkDescription);
	/* 提交表单判断 */
	$("#mysubmit").bind("click",function(){
		//1、判断权限名称
		/* var resultAuthorityName = checkAuthorityName();
		if(!resultAuthorityName){
			return false;
		} */
		if($.trim($("#authorityName").val())==""){
			window.alert("权限名称不可以为空！");
			//$("#authorityName").focus();
			return false;
		}
		//2、判断权限描述
		var resultDescripton = checkDescription();
		if(!resultDescripton){
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