
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
//页面载入的时候执行表单验证
$().ready(function() {
	'use strict';
	var authorizedToken = $("#authorizedToken").val();
	
    try{
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
    
    } catch(e) {
    	console.log(e);
    }
    
	//IE兼容模式不支持JSON
	if(typeof JSON == 'undefined'){
        $("head").append($("<script type='text/javascript' src='"+ ctx + "/js/common/json2.js'>"));
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
   
function  ages()   
{    
	  var str=document.form1.bdate.value.trim();
      var r= str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);     
      var d= new   Date(r[1], r[3]-1, r[4]);     
      if (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4])   
      {   
          var Y = new Date().getFullYear();   
          if(parseFloat(Y-r[1])>=14&&parseFloat(Y-r[1])<=100)
          {
        	  return true;
          }
          else
          {
        	  return false;
          }
      }
      else{
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
          document.form1.action = ctx+"/userinfoAction_updateR.action"
			document.form1.submit();
     }
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
   var partten = /^1[3,5,8,7,4]\d{9}$/;
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
  
function cancel(){
	window.location.href=ctx+"/MyShop.jsp";   
}
function update(id)
{
	// alert(id);
  document.form1.action= ctx+"/userinfoAction_MessageR.action";
  document.form1.submit(); 
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