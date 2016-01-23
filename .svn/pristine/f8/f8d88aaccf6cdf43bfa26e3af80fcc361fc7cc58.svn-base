
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
$().ready(function(){
	$(":input").bind("input propertychange keyup",function(){
		var text = $(this).val();
		$(this).val(text.replace(/[^\w@.]|_/ig,''));
	});
});
 function check(){
	 if(document.form1.username.value.trim()!="")
	 {
		var mail = document.form1.username.value.trim();
	    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (filter.test(mail))
		 {
			  if(document.form1.random.value!="")
			  {
				  var random=document.form1.random.value;
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
		  				 alert("验证码输入有误，请查看邮箱确认");
					           return;
		  				}
		  				else if (result.data == 'null') {
		  				      alert("您尚未获取验证码，请点击发送按钮获取！");
					          return;
		  				}
		  			},
		  			error : function() {
		  				alert('系统忙，请稍后重试');
		  			}
		  		});
			  } else{
			     alert("请输入验证码");
		          return;
			  }
		 }
		 else
		 {
			 alert("邮箱格式不正确！");
	         return;
		 }	
		}else {
			document.form1.username.value="";
			alert("邮箱地址不能为空！");
		return;
	}
  }


  function checkMail()
  {
	   var mail = document.form1.username.value.trim();
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (mail != "") {
			if (filter.test(mail)) {
				checkname()
			} else {
				alert("邮箱格式不正确");
				return;
			}
		}else {
			document.form1.username.value="";
			alert("邮箱地址不能为空！");
			return;
		}
  }
   
   function checkname()
   {
   		var mail=document.form1.username.value;
  		 $.ajax({
  	  			type : "POST",
  	  			url : ctx+"/userinfoAction_checkMailuser.do",
  	  			data : "Mail=" + mail,
  	  			success : function(result) {
  	  				if (result.data == 'right') {
  	  				 sendMail();
					 return;
  	  				} else if (result.data == 'wrong') {
  	  				 alert('该邮箱已注册！');
  	  			 return;
  	  				}
  	  			},
  	  			error : function() {
  	  				alert('系统忙，请稍后重试');
  	  			}
  	  		});
   }
   
  function sendMail()
 {
		 var mail=document.form1.username.value;
		 $.ajax({
	  			type : "POST",
	  			url : ctx+"/userinfoAction_Mail.do",
	  			data : "Mail=" + mail,
	  			success : function(result) {
	  				if (result.data == 'right') {
	  					alert('验证码已发送，请注意查收！');
	  					return;
	  				
  	  				} else if (result.data == 'wrong') {
  	  				       alert('验证码发送失败，请注意重新获取！');
  				           return false;
  	  				}
	  			},
	  			error : function() {
	  				alert('系统忙，请稍后重试');
	  			}
	  		});
 }
 function adduser()
 {
	 if(document.form1.username.value.trim()=="")
	   {
		    alert("邮箱不能为空！");
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
	  				     document.form1.action= ctx+"/userinfoAction_saveMail.do";
	  				     document.form1.submit(); 
	  				} else if (result.data == 'wrong') {
	  	  				alert('注册失败，该邮箱已被注册');
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
  	 window.location.href=ctx+'/user/MailRegedit.jsp';
  }
  