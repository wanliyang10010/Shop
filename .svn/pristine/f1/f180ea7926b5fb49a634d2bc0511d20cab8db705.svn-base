
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
	        return false;
	     }
	      if(document.form1.sex.value=="请选择")
	     {
	        alert("请选择性别！");
	        return false;
	     }
	      
	     if(document.form1.bdate.value.trim()=="")
	     {
	        alert("请填写出生日期！");
	        return false;
	     }
	     else if (new Date() < Date.parse(dB)) {
			 alert("出生日期不能大于当前日期！");
		     return false;
	      } 
	     if(document.form1.telephone.value.trim()=="")
	     {
	    	     document.form1.telephone.value=="";
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
	    		   document.form1.mail.value=="";
	    		   alert("请填写邮箱!！");
	    	        return false;
	     }
	      else
	      {
	    	  if(!checkname())
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
    function updateM()
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
        document.form1.action = ctx+"/userinfoAction_updateM.action"
			document.form1.submit();
     }
   }
   
   function checkname() {
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
		}
			 else {
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
   function cancel1()
   {
	   //alert("ok");
       window.location.href=ctx+"/viewProductAction_MyShop.do"; 
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