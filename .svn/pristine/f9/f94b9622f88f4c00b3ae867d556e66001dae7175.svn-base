
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function judgeNull(price)
   {
     if(document.form1.price.value.trim()=="")
     {
        alert("请填写促销价格！");
        document.form1.price.value="";
        return false;
     }
     else if(parseFloat(document.form1.price.value)>=parseFloat(price))
     {
    	 alert("促销价格应小于商品原价！");
         return false;
     }
     return true;
   }
  function add(price)
  {
	 if(judgeNull(price))
     {
        document.form1.action = ctx+"/discountAction_add.action"
		document.form1.submit();
     }
  } 
  
  function cancel()
  {
		document.getElementById("price").value="";
  }
  function update(price)
  {
	  if(judgeNull(price))
	     {
		     document.form1.action = ctx+"/discountAction_update.action"
			 document.form1.submit();
	     }
  }
  
  function deleted()
  {
		document.form1.action = ctx+"/discountAction_delete.action"
		document.form1.submit();
  }