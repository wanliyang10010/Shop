
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}

$().ready(function() {
	'use strict';
	var authorizedToken = $("#authorizedToken").val();
    
    var $distpicker = $('#picker');
    
    $distpicker.distpicker({
      province: "---- 所在省 ----",
      city: "---- 所在市 ----",
      district: "---- 所在区 ----",
      autoSelect: false
    });
    var address=$("#address").val();
    var p_c_d = address.split(" ");
    var EVENT_CHANGE = 'change.distpicker';
    if(p_c_d.length>1)
    {
    	 $("#province").find("option[value='" + p_c_d[0] + "']").attr("selected", true).trigger(EVENT_CHANGE);
    	   $("#city").find("option[value='" + p_c_d[1] + "']").attr("selected", true).trigger(EVENT_CHANGE);
    	   $("#district").find("option[value='" + p_c_d[2] + "']").attr("selected", true);
    	   $("#addr").attr("value",p_c_d[3]);
    }
    else
    {
    	$("#addr").attr("value",p_c_d[0]);
    }

    $("#district").on("change",function(){
    	var addrArea = $("#province").val() +' ' + $("#city").val() + ' ' + $(this).val() + ' ';
    	$("#area").val(addrArea);
    });
    
	//IE兼容模式不支持JSON
	if(typeof JSON == 'undefined'){
        $('head').append($("<script type='text/javascript' src='"+ ctx + "/js/common/json2.js'>"));
	}
}); 
function judgeNull()
{
	 var evalue = document.form1.bdate.value;
	 var dB = new Date(evalue.replace(/-/g, "/"));
	 if(checkIllegalChar()!=true){
		 if(document.form1.name.value.trim()=="")
		    {
		   	   document.form1.name.value="";	   	   
		       alert("请填写用户姓名！");
		       document.form1.name.focus();
		       return false;
		    }
		    if(document.form1.bdate.value.trim()=="")
		    {
		       alert("请填写出生日期！");
		       document.form1.bdate.focus();
		       return false;
		    }
		    else if (new Date() < Date.parse(dB)) {
				 alert("出生日期不能大于当前日期！");
				 document.form1.bdate.focus();
			     return false;
		     } 
		    if(document.form1.telephone.value.trim()=="")
		    {
		   	     document.form1.telephone.value="";
		   		 alert("请填写联系方式！");
		   	     return false;
		    }
		    else
		    {
		      if(!checkPhone())
		  	    {
		  		  return false;
		  	    } 
		   	 
		    }
		     if(document.form1.mail.value.trim()=="")
		    {
		   		   document.form1.mail.value="";
		   		   alert("邮箱地址不能为空!！");
		   	       return false;
		    }
		     else
		     {
			   	  if(!checkmail())
			   	  {
			   		  return false;
			   	  } 
		     }
		     if(document.getElementById("province").value=="")
		     {
		    	   alert("请选择所在省份！");
		   	       return false;
		     }
		     if(document.getElementById("city").value=="")
		     {
		    	 alert("请选择所在城市！");
		   	       return false;
		     }
		     if(document.getElementById("district").value=="")
		     {
		    	   alert("请选择所在区县！");
		   	       return false;
		     }
		     if(document.getElementById("addr").value.trim()==""){
		    	 document.getElementById("addr").value="";
		    	 alert("请填写详细地址！");
		   	     return false;
		     }
} else
{
	alert("文本框中不能包含下列任何字符： \" \' &amp;");
    return false;
}
	  return true;
}

function checkmail() {
	var mail = document.form1.mail.value.trim();
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (mail != "") {
		if (filter.test(mail)) {
			if(mail.length>50)
			{
				alert("您的电子邮件格式不正确");
				return false;
			}
			else
			{
				return true;
			}  
		} else {
			alert("您的电子邮件格式不正确");
			return false;
		}
	} else {
		document.form1.mail.value="";
		alert("邮箱地址不能为空！");
		return false;
	}
}

function checkPhone()
{
var partten = /^1[3,4,5,8,7]\d{9}$/;
var inputString= document.form1.telephone.value.trim();
   if(partten.test(inputString))
   {
	  return true;
   }
   else
   {
	   alert('输入手机号码格式不正确');
       return false;
   }   
}

function updateR()
{
	if(judgeNull())
    {
		 var province=document.getElementById("province").value;
    	 var city=document.getElementById("city").value;
    	 var district=document.getElementById("district").value;
    	 var addr=document.getElementById("addr").value;
    	 var address=province +" "+city+" "+ district +" "+addr.replace(" ","");
    	 //alert(address)
    	 document.getElementById("address").value=address;
      document.form1.method="post";
      document.form1.action = ctx+"/adminUserAction_updateRBack.action"
	  document.form1.submit();
    }
}

function cancel()
{
	window.location.href=ctx+"/AdminStage/index.jsp";
}

function update(id)
{
  document.form1.method="post";
  document.form1.action= ctx+"/adminUserAction_MessageRBack.action?";
  document.form1.submit(); 
}
function checkpassword()
{
   var ss=document.getElementById("oldpassword").value;   
   var authorizedToken=document.getElementById("authorizedToken").value;
	   if(ss!="")
	   {
		   $.ajax({
	  			type : "POST",
	  			url : ctx+"/adminUserAction_checkPWDBack.action",
	  			data : "oldpassword=" + ss +"&authorizedToken=" + authorizedToken,
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
	  				window.location.href=ctx+"/error/remotelogin.jsp";
	  				//alert('系统忙，请稍后重试');
	  			}
	  		});
	   }else
	     {
	         alert("请输入密码！");   
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
		  	  			url : ctx+"/adminUserAction_updatePWDBack.do",
		  	  			data : "userinfoId=" + userinfoId + "&password=" + password
		  	  		          +"&authorizedToken=" + authorizedToken,
		  	  			success : function(result) {
		  	  				if (result.data == 'right') {
		  	  				   // alert("密码修改成功");
		  	  				 document.form1.method="post";
		  	  				document.form1.action= ctx+"/adminUserAction_clearBack.action";
		  				     document.form1.submit(); 
		  	  				} else if (result.data == 'wrong') {
		  				           return false;
		  	  				}
		  	  			},
		  	  			error : function() {
		  	  			window.location.href=ctx+"/error/remotelogin.jsp";
		  	  				//alert('系统忙，请稍后重试');
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
  function openmessage(id,url,type,value){
	  var authorizedToken=document.getElementById("authorizedToken").value;
     	  $.ajax({
   			type : "POST",
   			url : ctx+"/messageAction_OpenMessageAdmin.action",
   			data : "messageId=" + id+"&authorizedToken=" + authorizedToken,
   			success : function(result) {
   				if (result.data == 'right') {
   					window.location.href=ctx+"/"+url+"?"+type+"="+value;
   					//window.open(ctx+"/"+url+"?"+type+"="+value);
   					//window.location.reload(true);
   				} 
   			},
   			error : function() {
   				window.location.href=ctx+"/error/remotelogin.jsp";
   				//alert('系统忙，请稍后重试');
   			}
   		});
   }
   
   function updateM(id) {
	   var authorizedToken=document.getElementById("authorizedToken").value;
	   $.ajax({
  			type : "POST",
  			url : ctx+"/messageAction_OpenMessageAdmin.action",
  			data : "messageId=" + id+"&authorizedToken=" + authorizedToken,
  			success : function(result) {
  				if (result.data == 'right') {
  					//alert('修改成功');
  					window.location.reload(true);
  				} 
  			},
  			error : function() {
  				window.location.href=ctx+"/error/remotelogin.jsp";
   				//alert('系统忙，请稍后重试');
  			}
  		});
 	}
   
   function updateA(id) {
	   var authorizedToken=document.getElementById("authorizedToken").value;
	   $.ajax({
  			type : "POST",
  			url : ctx+"/messageAction_updateAllAdmin.action",
  			data : "authorizedToken=" + authorizedToken,
  			success : function(result) {
  				if (result.data == 'right') {
  					 document.form1.method="post";
	  	  			 document.form1.action= ctx+"/messageAction_getMessageAdmin.action";
	  				 document.form1.submit(); 
  				} 
  			},
  			error : function() {
  				window.location.href=ctx+"/error/remotelogin.jsp";
   				//alert('系统忙，请稍后重试');
  			}
  		});
 	}
   function showKey(evt)
   {
        evt = (evt) ? evt : window.event;
        if(evt.keyCode==32)
        {
             return false;//禁止空格翻页
        }
   }

   function judgespace()
   {
   	document.onkeydown=showKey;//不能用onkeyup 否则还是有动作的
   	}