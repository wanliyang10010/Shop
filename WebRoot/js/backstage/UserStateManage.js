
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function deleteuser(id)
  {
	var authorizedToken=document.getElementById("authorizedToken").value;
	 $.ajax({
			type : "POST",
			url : ctx+"/userinfoAction_delete.action",
			data : "userinfoId=" + id+"&authorizedToken=" + authorizedToken,
			success : function(result) {
				if (result.data == 'right') {
					//alert("会员账号删除成功！");
					window.location.reload(true);
				} else if (result.data == 'wrong') {
					alert("会员账号删除失败！");
			           return;
				}
			},
			error : function() {
				window.location.href=ctx+"/error/remotelogin.jsp";
   				//alert('系统忙，请稍后重试');
			}
		});
  }
  
   function update(id)
  {
	   var authorizedToken=document.getElementById("authorizedToken").value;
	   $.ajax({
			type : "POST",
			url : ctx+"/userinfoAction_updateState.action",
			data : "userinfoId=" + id+"&authorizedToken=" + authorizedToken,
			success : function(result) {
				if (result.data == 'right') {
					//alert("会员账号状态更新成功！");
					window.location.reload(true);
				} else if (result.data == 'wrong') {
					alert("会员账号状态更新失败！");
			           return;
				}
			},
			error : function() {
				window.location.href=ctx+"/error/remotelogin.jsp";
   				//alert('系统忙，请稍后重试');
			}
		});
  }
  
  function search()
  {
	  //document.form1.action= ctx+"/userinfoAction_list.action";   hx修改
	 document.getElementById("pageNo").value=1; 
     document.form1.action= ctx+"/userinfoAction_listUser.action"; 
     document.form1.submit();  
  }
  
  function edituser(id)
  {  
	 document.getElementById("userinfoId").value=id; 
	 document.getElementById("editMessage").style.display=""; 
  } 
  
  function judgeNull()
  {
  	 var evalue = document.form1.bdate.value;
  	 var dB = new Date(evalue.replace(/-/g, "/"));
    if(document.form1.name.value=="")
    {
       alert("请填写用户姓名！");
       return false;
    }
    if(document.form1.bdate.value=="")
    {
       alert("请填写出生日期！");
       return false;
    }
    else if (new Date() < Date.parse(dB)) {
  		 alert("出生日期不能大于当前日期！");
  	     return false;
     } 
    if(document.form1.telephone.value=="")
    {
       alert("请填写联系方式！");
       return false;
    }
      if(document.form1.mail.value=="")
    {
       alert("请填写邮箱!！");
       return false;
    }
    return true;
  }

  function checkmail() {
  	var mail = document.form1.mail.value;
  	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  	if (mail != "") {
  		if (filter.test(mail)) {
  			return;
  		} else {
  			alert("您的电子邮件格式不正确");
  			return;
  		}
  	} else {
  		alert("邮箱地址不能为空！");
  		return;
  	}
  }

  function checkPhone()
  {
  var partten = /^1[3,5,8,7]\d{9}$/;
  var inputString= document.form1.telephone.value;
     if(partten.test(inputString))
     {
  	  return;
     }
     else
     {
  	   alert('输入手机号码格式不正确');
         return;
     }   
  }
  function changePWD()
  {
  	   if (document.form1.password.value=="") {
  	     alert("密码不能为空！");
  	     return;
  	   }
  	   if (document.form1.password2.value=="") {
  	     alert("确认密码不能为空！");
  	     return;
  	   }
  	  if (document.form1.password.value == document.form1.password2.value) {
  		var  userinfoId=document.getElementById("userinfoId").value; 
		var password=document.getElementById("password").value; 
		var authorizedToken=document.getElementById("authorizedToken").value;
	  $.ajax({
			type : "POST",
			url : ctx+"/adminUserAction_resetPWD.action",
			data : "userinfoId=" + userinfoId+"&password=" + password
			+"&authorizedToken=" + authorizedToken,
			success : function(result) {
				if (result.data == 'right') {
					alert("重置密码成功");
					cancel();
				} else if (result.data == 'wrong') {
				 alert("重置密码失败");
			           return;
				}
			},
			error : function() {
				window.location.href=ctx+"/error/remotelogin.jsp";
   				//alert('系统忙，请稍后重试');
			}
		});
  	     } else {
  				document.form1.password.value = "";
  				document.form1.password2.value = "";
  				alert("两次密码输入不一致，请重新输入！");
  				return;
  			}
  }
  
  function updateR()
  {
	  if(judgeNull())
	 {
	   var  userinfoId=document.getElementById("userinfoId").value; 
		var username=document.getElementById("username").value; 
		var name= document.getElementById("name").value; 
		var telephone= document.getElementById("telephone").value; 
		var mail= document.getElementById("mail").value; 
		var address= document.getElementById("address").value; 
		var bdate= document.getElementById("bdate").value; 
		var authorizedToken=document.getElementById("authorizedToken").value;
	  $.ajax({
			type : "POST",
			url : ctx+"/adminUserAction_updateUser.action",
			data : "userinfoId=" + userinfoId
			       +"&name=" + name
			       +"&telephone=" + telephone
			       +"&mail=" + mail
			       +"&bdate=" + bdate
			       +"&address=" + address
			       +"&authorizedToken=" + authorizedToken,
			success : function(result) {
				if (result.data == 'right') {
					//alert("修改成功");
					window.location.reload(true);
					cancel();
				} else if (result.data == 'wrong') {
				 alert("修改失败");
			           return;
				}
			},
			error : function() {
				window.location.href=ctx+"/error/remotelogin.jsp";
   				//alert('系统忙，请稍后重试');
			}
		});
	 }
  }
  function cancel()
  {
	     document.getElementById("userinfoId").value=""; 
		 document.getElementById("password").value=""; 
		 document.getElementById("password2").value=""; 
		 document.getElementById("editMessage").style.display="none";
  }