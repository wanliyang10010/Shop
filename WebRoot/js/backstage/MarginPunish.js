
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function submargin()
   {
	     if(judgeNull())
	     {
	        document.form1.action = ctx+"/marginDetailAction_submargin.action";
		    document.form1.submit();
	     }
   }
   
   function judgeNull()
   {
	     if(document.getElementById("money").value.trim()=="")
	     {	    	 
	        alert("请填写处罚金额！");
	        document.getElementById("money").value="";
	        return false;
	     }
	     else if(parseFloat(document.getElementById("money").value)>parseFloat(document.getElementById("margin").value))
    	 {
    		 alert("处罚金额不能大于店铺保证金金额！");
 	         document.getElementById("money").value="";
 	         return false;
    	 }
	      if(document.getElementById("remark").value.trim()=="")
	     {
	        alert("请填写处罚原因！");
	        document.getElementById("remark").value="";
	        return false;
	     }
	     return true;
   }
  
    function cancel()
   {
      document.getElementById("money").value="";
	     document.getElementById("remark").value="";
   }