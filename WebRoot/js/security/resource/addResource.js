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
				/* var isExsited = $.trim($("#isExsited").val());
				if(isExsited == "" || isExsited == "true"){
					var resourceName = $.trim($("#resourceName").val());
					url= "resourceAction_!checkResourceName?resource.resourceName="+resourceName;
					window.location.href=url;
					return true;
				}else{
					return true;
				} */
				var resourceName = $.trim($("#resourceName").val());
				$.ajax({
					 type:"POST", 
			         //url:"userActioncheckAcccount", 
			         url:"resourceAction_!checkResourceName.action",
			         //dataType:"json",      
			         //contentType:"application/json",               
			         data:"resource.resourceName="+resourceName,
			         async: true, 
			         success:function(result){
			         	/* var resultobj = $.parsejson(result);
			         	ajaxobj=eval("("+data+")");  */ 
			         	var returnIsExisted = result.responseJson.isExsited;
			            if(returnIsExisted == "true")  
			            {  
			                alert("该资源名称已存在！");
			                //$("#resourceName").focus();
			                return true;  
			            }else{
			            	return true;  
				        } 
					}
				});
			}
		} 
	}
	//1.2resourceType触发的事件
	function resourceTypeClick(resourceType){
		var url = "resourceAction_!ResourceStringList.action?resource.type="+resourceType;
		window.location.href=url;
	    return true;

	}
	
	//2、判断资源链接
	//2.1 暂时没有使用
	function checkResourceStringPattern(resourceType){
			if(resourceType == "action"){
				var reg=/^\/(\w+)(_)*(!\w+)*.action$/;
				if(!reg.test($.trim($("#resourceString  option:selected").val()))){
					//window.alert("资源链接格式不正确！格式要求：以/开始，后接数据字母下划线感叹号组成的字符串，以.action结尾!");
					window.alert("资源链接格式不正确！");
					//$("#resourceString").focus();
					return false;
				}else{
					return true;
				}
			}else{
				var reg=/^\/(\w+)(_)*(-)*(\w+)*(\/(\w+)(_)*(-)*(\w+)*)*.jsp$/;
				if(!reg.test($.trim($("#resourceString  option:selected").val()))){
					//window.alert("资源链接格式不正确！格式要求：以/开始，后接数据字母下划线感叹号组成的字符串，以.jsp结尾!");
					window.alert("资源链接格式不正确！");
					//$("#resourceString").focus();
					return false;
				}else{
					return true;
				}
			}	
	}
	//2.2
	function checkResourceString(){
		/* 判断资源链接是否为空*/
		if($.trim($("#resourceString  option:selected").val())=="-1"){
			window.alert("资源链接不可以为空！");
			//$("#resourceString").focus();
			return false;
		}else{
			return true;
		}
		
		/* else{
			/*判断资源链接是否合法
			/* var resourceTypeAction = $.trim($("#resourceTypeAction").val());
			var resourceTypeUrl = $.trim($("#resourceTypeUrl").val()); 
			var resourceType = $("input:radio[name=resource.type]:checked").val();
			var result = checkResourceStringPattern(resourceType);
			return result;
			
		}  */
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
	/*判断资源名称   */
	$("#resourceName").blur(checkResourceName);
	/* 资源类型绑定click事件 */
	$("#resourceTypeAction").bind("click",function(){
		resourceTypeClick("action");
	});
	$("#resourceTypeUrl").bind("click",function(){
		resourceTypeClick("url");
	});
	
	
	
	/*判断资源链接*/
	$("#resourceString").change(checkResourceString);
	/* 判断资源描述 */
	$("#description").change(checkDescription);
	/* 提交表单判断 */
	$("#mysubmit").bind("click",function(){
		//1、判断资源名称
		/* var resultResourceName = checkResourceName();
		if(!resultResourceName){
			//禁止表单提交
			return false;
		} */
		if($.trim($("#resourceName").val())==""){
			window.alert("资源名称不可以为空！");
			//$("#resourceName").focus();
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
	
	//返回主页
	$("#fanhuibutton").bind("click",function(){
		$("#fanhuiform").attr("action","jumpToIndexAdmin.action");
		$("#fanhuiform").submit();
	});
	
});