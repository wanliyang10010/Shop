
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
 function check(){
	 if(document.form1.username.value.trim()!="")
	 {
		 var partten = /^1[3,5,8,7]\d{9}$/;
		    var inputString= document.form1.username.value.trim();
		 if(!partten.test(inputString))
		 {
			 alert("手机号码格式不正确！");
	         return;
		 }
		 else{
			 if(document.form1.random.value.trim()!="")
			  {
				  var random=inputString+"/"+document.form1.random.value;
		    	  $.ajax({
		  			type : "POST",
		  			url : ctx+"/userinfoAction_JudgeRandom.do",
		  			data : "Random=" + random,
		  			success : function(result) {
		  				if (result.data == 'right') {
		  				   document.getElementById("dv_random").style.display="none";
		  		           document.getElementById("dv_add").style.display="";
		  		           document.getElementById("username").readOnly="true";
		  				} else if (result.data == 'wrong') {
		  				       alert("验证码输入有误，请查看短信确认！");
					           return;
		  				}
		  				else if (result.data == 'null') {
		  				      alert("您尚未获取验证码，请点击发送按钮获取！");
					          return;
		  				}
		  			},
		  			error : function() {
		  				alert('系统忙，请稍后重试！');
		  			}
		  		});
			  }
			  else{
			     alert("请输入验证码！");
		          return;
			  }
		 }
		 
	 }
	 else
	 {
		 document.form1.username.value="";
		 alert("手机号码不能为空！");
         return;
	 }
  }
 
 function adduser()
 {
	 if(document.form1.username.value.trim()=="")
	   {
		    alert("手机号码不能为空！");
		    return;
	   }
	 if (document.form1.password.value.trim()=="") {
	     alert("密码不能为空！");
	     return;
	 }
	 if (document.form1.password2.value.trim()=="") {
	     alert("确认密码不能为空！");
	     return;
	 }
	 if(document.form1.password.value.length<6&&document.form1.password2.value.length<6)
	 {
		alert("密码和确定密码不能低于六位！");
		return;
	 }
   if (document.form1.password.value == document.form1.password2.value) {
	   var username=document.form1.username.value;
		  $.ajax({
	  			type : "POST",
	  			url : ctx+"/userinfoAction_finaljudge.do",
	  			data : "username=" + username,
	  			success : function(result) {
	  				if (result.data == 'right') {
	  					 document.form1.method="post";
	  				    document.form1.action= ctx+"/userinfoAction_savePhone.do"
	  				     document.form1.submit(); 
	  				} else if (result.data == 'wrong') {
	  	  				alert('注册失败，该手机号码已被注册');
	  	  			    clear();
	  				}
	  			},
	  			error : function() {
	  				alert('系统忙，请稍后重试');
	  				return;
	  			}
	  		});
	   
	} else {
		document.form1.password.value = "";
		document.form1.password2.value = "";
		alert("两次密码输入不一致，请重新输入！");
		return;
	}
  }
 
 function clear()
 {
	document.form1.password.value="";
    document.form1.password2.value="";
    document.form1.random.value="";
	document.getElementById("dv_random").style.display="";
    document.getElementById("dv_add").style.display="none";
    document.getElementById("username").readOnly="";
 }
 
   function cancel()
  {
  	 window.location.href=ctx+'/user/PhoneRegedit.jsp';
  }
   
   function checkphone()
   {
    var partten = /^1[3,5,8,7]\d{9}$/;
    var inputString= document.form1.username.value.trim();
    inputString=inputString.replace(/[^\d]/g,'')
    if(inputString!="")
    {
 	   if(partten.test(inputString))
        {
 		  checkname();
        }
        else
        {
        	alert('手机号码格式不正确！');
        	return;
        }
     }
    else
    {
    	alert('手机号码不能为空！');
    	return;
    }
   }
    
    function checkname()
    {
    		var phone=document.form1.username.value;
   		 $.ajax({
   	  			type : "POST",
   	  			url : ctx+"/userinfoAction_checkPhoneuser.do",
   	  			data : "Phone=" + phone,
   	  			success : function(result) {
   	  				if (result.data == 'right') {
   	  			    	sendPhone();
   	 			         return;
   	  				} else if (result.data == 'wrong') {
   	  				 alert('该手机号码已注册！');
   	   			      return;
   	  				}
   	  			},
   	  			error : function() {
   	  				alert('系统忙，请稍后重试');
   	  			 return false;
   	  			}
   	  		});
    }
   function sendPhone()
  {
		 var phone=document.form1.username.value;
		 $.ajax({
	  			type : "POST",
	  			url : ctx+"/userinfoAction_sendPhone.do",
	  			data : "Phone=" + phone,
	  			success : function(result) {
	  				    document.form1.random.value=result.data;
	  					alert('验证码已发送，请注意查收！');
	  					return;
	  			},
	  			error : function() {
	  				alert('系统忙，请稍后重试');
	  			}
	  		});
  }