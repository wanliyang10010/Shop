
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function checkdate()
{ 
  var fromdate = document.getElementById("fromdate").value;
	var todate = document.getElementById("todate").value;
	   if(fromdate!=""&&todate!="")
	   {
		  if(Date.parse(fromdate)>Date.parse(todate))
		   { 
		   		alert("终止日期不能小于起始日期！");
		   		return false;
		   }
		 return true;
	   }
	   else
	   {
		   alert("请选择起始日期与终止日期！");
		   return false;
	   }
	}
	
function searchDate() {
		 if(checkdate())
		  {
			 document.getElementById("pageNo").value=1; 
			 document.form1.action = ctx+"/stageOrderAction_searchAdmin.action";
		     document.form1.submit();
		  } 
}

function updateR()
{
	  var sorderid=document.getElementById("sorderid").value;
	  var transcompany=document.getElementById("transcompany").value.trim();
	  var transnumber=document.getElementById("transnumber").value.trim();
	  var authorizedToken=document.getElementById("authorizedToken").value;
	   if(judge())
	   {
		   $.ajax({
	  			type : "POST",
	  			url : ctx+"/stageOrderAction_trans.action",
	  			data : "sorderid=" + sorderid
	  			+"&transcompany="+transcompany
	  			+"&transnumber="+transnumber
	  			+"&authorizedToken=" + authorizedToken,
	  			success : function(result) {
	  				if (result.data == 'right') {
	  					// alert("提交成功");
	  					window.location.reload(true);
	  				} else if (result.data == 'wrong') {
	  				 alert("提交失败");
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
 function judge()
{
	 if(checkIllegalChar()!=true){
		 if (document.form1.transcompany.value.trim()=="") {
		     alert("请输入物流公司！");
		     document.form1.transcompany.value="";
		     return false;
		   }
		   if (document.form1.transnumber.value.trim()=="") {
			   document.form1.transnumber.value="";
		     alert("请输入物流单号！");
		     return false;
		   } else {
			    var filter = /^[A-Za-z0-9]+$/;
				if (!filter.test(document.form1.transnumber.value)) {
					    alert("您输入的物流单号格式不正确");
				           return false;
					}
	       }
} else
{
	alert("文本框中不能包含下列任何字符： \" \' &amp;");
    return false;
}
	   return true;
}
 function trans(id,addr)
 {
	 document.getElementById("sorderid").value=id;
	 document.getElementById("addr").value=addr;
	 document.getElementById("tb_trans").style.display="";  
 }
 
 function cancel()
 {
	 document.getElementById("sorderid").value="";
	 document.form1.transcompany.value="";
	 document.form1.transnumber.value="";
	 document.getElementById("tb_trans").style.display="none";  
 }
 