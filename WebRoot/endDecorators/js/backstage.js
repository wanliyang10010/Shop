
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

function updateR()
{
	if(judgeNull())
    {
      document.form1.method="post";
      document.form1.action = ctx+"/superUserAction_updateRBack.action"
	  document.form1.submit();
    }
}
function cancel()
{
	window.location.href=ctx+"/backstage/index.jsp";
}
function update(id)
{
  document.form1.method="post";
  document.form1.action= ctx+"/superUserAction_MessageRBack.action?";
  document.form1.submit(); 
}
function checkpassword()
{
   var ss=document.getElementById("oldpassword").value;   
	   if(ss!="")
	   {
		   $.ajax({
	  			type : "POST",
	  			url : ctx+"/superUserAction_checkPWDBack.action",
	  			data : "oldpassword=" + ss,
	  			success : function(result) {
	  				if (result.data == 'right') {
	  				 document.getElementById("tb_old").style.display="none";
	  		          document.getElementById("dv_pwd").style.display="";
	  				} else if (result.data == 'wrong') {
	  				 alert("密码输入有误，请重新输入");
				           return;
	  				}
	  			},
	  			error : function() {
	  				alert('系统忙，请稍后重试');
	  			}
	  		});
	   }else
	     {
	         alert("请输入密码！");   
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
	      document.form1.method="post";
	     document.form1.action=ctx+"/superUserAction_updatePWDBack.do";
	     document.form1.submit(); 
	     } else {
				document.form1.password.value = "";
				document.form1.password2.value = "";
				alert("两次密码输入不一致，请重新输入！");
				return;
			}
}
