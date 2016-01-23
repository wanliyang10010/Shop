
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function checkpassword()
  {
     var ss=document.getElementById("oldpassword").value.trim();   
	   if(ss!="")
	   {
	     document.form1.method="post";
	     document.form1.action= ctx+"/userinfoAction_checkPWD.action";
	     document.form1.submit(); 
	   }else
	     {
	         alert("请输入密码！");
	         return;
	     }
  }
   function changePWD()
  {
	   if (document.form1.password.value.trim()=="") {
	     alert("密码不能为空！");
	     return;
	   }
	   if (document.form1.password2.value.trim()=="") {
	     alert("确认密码不能为空！");
	     return;
	   }
	   if(document.form1.password.value.length<6||document.form1.password2.value.length<6)
		 {
			alert("密码和确定密码不能低于六位！");
			return;
		 }
	  if (document.form1.password.value == document.form1.password2.value) {
		  if(document.form1.password.value == document.form1.oldpassword.value)
		  {
			  alert("新密码与当前密码相同，请重新输入！");
			  document.form1.password.value ="";
			  document.form1.password2.value="";
			  return;
		  }
		  else
		  {
			  var authorizedToken=document.getElementById("authorizedToken").value;
			 var userinfoId=document.form1.userinfoId.value;
			 var password=document.form1.password.value;
			  $.ajax({
	  	  			type : "POST",
	  	  			url : ctx+"/userinfoAction_updatePWD.action",
	  	  			data : "userinfoId=" + userinfoId + "&password=" + password
	  	  		+"&authorizedToken=" + authorizedToken,
	  	  			success : function(result) {
	  	  				if (result.data == 'right') {
	  	  				    //alert("密码修改成功");
	  	  				 document.form1.method="post";
	  	  				document.form1.action= ctx+"/userinfoAction_clear.action";
	  				     document.form1.submit(); 
	  	  				} else if (result.data == 'wrong') {
	  				           return false;
	  	  				}
	  	  			},
	  	  			error : function() {
	  	  				alert('系统忙，请稍后重试');
	  	  			}
	  	  		});
		  }
	     } else {
				document.form1.password.value = "";
				document.form1.password2.value = "";
				alert("两次密码输入不一致，请重新输入！");
				return;
			}
  }
  
  function cancel()
  {
  	 window.location.href=ctx+'/user/PasswordChange.jsp';
  }