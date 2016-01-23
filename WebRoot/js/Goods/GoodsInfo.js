
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function judgeNull()
  {
	if(checkIllegalChar()!=true){
		if(checkIllegalChar()!=true){
			 if(document.form1.typeid.value=="请选择")
		     {
		        alert("请选择商品子类别！");
		        return false;
		     }
		     if(document.form1.goodsname.value.trim()=="")
		     {
		        alert("商品名称不能为空！");
		        document.form1.goodsname.value="";
		        return false;
		     }
		     if(document.form1.price.value.trim()=="")
		     {
		        alert("商品单价不能为空！");
		        document.form1.price.value=""
		        return false;
		     }
		     else if(parseFloat(document.form1.price.value)<=0)
		     {
		    	 alert("商品单价不能为零！");
		         document.form1.price.value=""
		         return false;
		     }
		     if(document.form1.freight.value.trim()=="")
		     {
		        alert("运费不能为空！");
		        document.form1.price.value=""
		        return false;
		     }
		     if(document.form1.amount.value.trim()=="")
		     {
		        alert("库存量不能为空！");
		        document.form1.amount.value="";
		        return false;
		     }
			} else
			{
				alert("文本框中不能包含下列任何字符： \" \' &amp;");
		        return false;
			}
		} else
		{
			alert("文本框中不能包含下列任何字符： \" \' &amp;");
	        return false;
		}
     return true;
  }

function add()
{
    if(judgeNull())
     {
    	if(document.getElementById("checkbox").checked)
    	{
    		
    		document.getElementById("Smark").value=1;
    	}
        document.form1.action= ctx+"/goodsAction_Add.action"; 
        document.form1.submit(); 
     }
}

function cancel()
{
   document.getElementById("amount").value="";
   document.getElementById("goodsname").value="";
   document.getElementById("price").value="";
   document.getElementById("freight").value="";
   document.form1.typeid.value="请选择";
}