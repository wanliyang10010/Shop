
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function checkname()
  {
   if(document.form1.username.value.trim()!="")
   {
	 document.form1.method="post";
     document.form1.action= ctx+"/userinfoAction_checkuser.do";
     document.form1.submit(); 
   }
   else
   {
	   document.form1.username.value="";
	  // alert("用户名不能为空");
	   return;
   }
  }
  function setbutton()
  {
	  document.getElementById("font1").innerHTML ="";
	  document.getElementById("btn_submit").disabled = "false";
	  document.form1.password.value = "";
	  document.form1.password2.value = "";
  }
  function adduser()
  {
	  if(document.form1.username.value.trim()=="")
	   {
		    alert("用户名不能为空！");
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
		  	  				document.form1.action= ctx+"/userinfoAction_save.do";
		  	  	            document.form1.submit(); 
	  	  				} else if (result.data == 'wrong') {
		  	  				alert('注册失败，该用户已被注册');
		  	  			    setbutton();
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
  
  function cancel()
  {
  	 window.location.href=ctx+'/user/NormalRegedit.jsp';
  }
  
  
 