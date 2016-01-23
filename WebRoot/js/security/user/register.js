$(document).ready(function(){
	/* B 公共函数 */
	//1、判断用户名
	function checkAccount(){
		/* 判断是否为空*/
		if($.trim($("#account").val())==""){
			window.alert("邮箱不可以为空！！");
			$("#account").focus();
			return false;
		}else{
			/*判断邮箱是否合法*/
			var reg=/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			if(!reg.test($.trim($("#account").val()))){
				window.alert("注册邮箱不正确！");
				$("#account").focus();
				return false;
			}else{
				/* var isExsited = $.trim($("#isExsited").val());
				if(isExsited == "" || isExsited == "true"){
					var account = $.trim($("#account").val());
					url= "userAction_!checkAcccount?user.account="+account;
					window.location.href=url;
					return true;
				}else{
					return true;
				} */
				
				var account = $.trim($("#account").val());
				$.ajax({
					 type:"POST", 
			         //url:"userActioncheckAcccount", 
			         url:"userAction_!checkAcccount.action",
			         //dataType:"json",      
			         //contentType:"application/json",               
			         data:"user.account="+account,
			         async: true, 
			         success:function(result){
			         	/* var resultobj = $.parsejson(result);
			         	ajaxobj=eval("("+data+")");  */ 
			         	var returnIsExisted = result.responseJson.isExsited;
			            if(returnIsExisted == "true")  
			            {  
			                alert("账号已存在！");
			                $("#account").focus();
			                return true;  
			            }else{
			            	return true;  
				        } 
					}
				});
				
			}
		}
	}
	//2、判断姓名
	function checkUsername(){
		//判空
		if($.trim($("#username").val())==""){
			window.alert("姓名不可以为空！！");
			$("#username").focus();
			return false;
		}else{
			return true;
		}
	}
	//3、判断密码
	function checkPassword(){
		//判空
		if($.trim($("#password").val())==""){
			window.alert("密码不可以为空！");
			$("#password").focus();
			return false;
		}else{
			/* 判断密码格式 */
			var reg=/^[a-zA-Z0-9_-]{3,16}$/;
			if(!reg.test($.trim($("#password").val()))){
				window.alert("密码格式不正确！");
				$("#password").focus();
				return false;
			}else{
				return true;
			}
		}
	}
	//4判断单位
	function checkCompany(){
		if($.trim($("#company").val())==""){
			window.alert("单位不可以为空！");
			$("#company").focus();
			return false;
		}else{
			return true;
		}
	}
	//5判断部门
	function checkDepartment(){
		if($.trim($("#department").val())==""){
			window.alert("部门不可以为空！");
			$("#department").focus();
			return false;
		}else{
			return true;
		}
	}
	//6、判断职务
	function checkMemberpost(){
		if($.trim($("#memberpost").val())==""){
			window.alert("职务不可以为空！");
			$("#memberpost").focus();
			return false;
		}else{
			return true;
		}
	}
	//7、判断手机号码
	function checkPhonenumber(){
		var mobile = $.trim($("#phonenumber").val());
		if(mobile==""){
			window.alert("手机号码不可以为空！");
			$("#phonenumber").focus();
			return false;
		}else{
			if(mobile.length!=11){
				window.alert("手机号码格式不正确！");
				$("#phonenumber").focus();
				return false;
			}else{
				var reg=/^1(3\d|5[012356789]|8[03456789])\d{8}$/; 
				if(!reg.test(mobile)){
				window.alert("手机号码格式不正确！");
				$("#phonenumber").focus();
				return false;
				}else{
					return true;
				}
				
			}
		}
	}
	//8判断身份证号码
	function checkIDnumber(){
		var idnumber = $.trim($("#idnumber").val());
		if(idnumber==""){
			window.alert("身份证号码不可以为空！");
			$("#idnumber").focus();
			return false;
		}else{
			var reg=/^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/; 
			if(!reg.test(idnumber)){
				window.alert("身份证号码格式不正确！");
				$("#idnumber").focus();
				return false;
			}else{
				//如果通过该验证，说明身份证格式正确，但准确性还需计算
				if(idnumber.length==18){
		   			var idnumberWi=new Array( 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ); //将前17位加权因子保存在数组里
		   			var idnumberY=new Array( 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ); //这是除以11后，可能产生的11位余数、验证码，也保存成数组
		   			var idnumberWiSum=0; //用来保存前17位各自乖以加权因子后的总和
		   			for(var i=0;i<17;i++){
		    			idnumberWiSum+=idnumber.substring(i,i+1)*idnumberWi[i];
		   			}
		   			var idnumberMod=idnumberWiSum%11;//计算出校验码所在数组的位置
			   		var idnumberLast=idnumber.substring(17);//得到最后一位身份证号码
			   		//如果等于2，则说明校验码是10，身份证号码最后一位应该是X
				    if(idnumberMod==2){
					    if(idnumberLast=="X"||idnumberLast=="x"){     
					     	//alert("身份证号码可用！");
					     	return true;
					    }else{
					     	window.alert("身份证号码错误！");
					     	$("#idnumber").focus();
					      	return false;
					    }
				    }else{
					    //用计算出的验证码与最后一位身份证号码匹配，如果一致，说明通过，否则是无效的身份证号码
					    if(idnumberLast==idnumberY[idnumberMod]){
					    	// alert("身份证号码可用！");
					    	return true;
					    }else{
						     window.alert("身份证号码错误！");
						     $("#idnumber").focus();
						      return false;
					    }
				    }
				 }else{
				  	window.alert("身份证号码错误!");
				  	$("#idnumber").focus();
				  	return false;
			 	 }	
		     }	
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
	
	
	/* 用户名是否判断标识符 */
	/* var isChecked = false; */
	
	/*判断用户名*/
	$("#account").blur(checkAccount);
	/*判断姓名*/
	$("#username").change(checkUsername);
	/*判断密码*/
	$("#password").change(checkPassword);
	/* 判断单位 */
	$("#company").change(checkCompany);
	/* 判断部门 */
	$("#department").change(checkDepartment);
	/* 判断职务 */
	$("#memberpost").change(checkMemberpost);
	/* 判断手机号码  */
	$("#phonenumber").change(checkPhonenumber);
	/* 判断身份证号码 */
	$("#idnumber").change(checkIDnumber);
	
	var formSubmitFlag = false;//表单是否提交标识符，默认为false,即没有提交
	
	/* 提交表单判断 */
	$("#mysubmit").bind("click",function(){
		
		if($.trim($("#account").val())==""){
			window.alert("邮箱不可以为空！");
			$("#account").focus();
			return false;
		}
		/* //1、判断用户名
		var resultAccount = checkAccount();
		if(!resultAccount){
			//表单不提交
			return false;
		} */
		//2、判断姓名
		var resultUsername = checkUsername();
		if(!resultUsername){
			//表单不提交
			return false;
		}
		//3、判断密码
		var resultPassword = checkPassword();
		if(!resultPassword){
			//表单不提交
			return false;
		}
		//4、判断单位
		var resultCompany = checkCompany();
		if(!resultCompany){
			//表单不提交
			return false;
		}
		
		//5、判断部门
		var resultDepartment = checkDepartment();
		if(!resultDepartment){
			//表单不提交
			return false;
		}
		
		//6、判断职务
		var resultMemberpost = checkMemberpost();
		if(!resultMemberpost){
			//表单不提交
			return false;
		}
		
		//7、判断手机号码
		var resultPhonenumber = checkPhonenumber();
		if(!resultPhonenumber){
			//表单不提交
			return false;
		}
		
		//8、判断身份证号码
		var resultIDNumber = checkIDnumber();
		if(!resultIDNumber){
			//表单不提交
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