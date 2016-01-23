
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function vieworder(id)
  {
	  window.open(ctx+"/orderSonAction_viewOrder.action?ordersonid="+id+"");
  }
  
function openpicture(url)
{
    window.open(ctx+url); 
}
 
  function check()
  {
	  if(document.form1.result.value.trim()!="")
	  {
		  if(checkIllegalChar()!=true){
			     document.form1.action= ctx+"/disputeAction_check.action"; 
			     document.form1.submit();  
			} else
			{
				alert("文本框中不能包含下列任何字符： \" \' &amp;");
		        return false;
			}
	  }
	  else
	  {
	    alert("请填写处理结果");
	    document.form1.result.value="";
	    return;
	  }
     
  }

  function cancel()
  {
     document.form1.result.value="";
  }