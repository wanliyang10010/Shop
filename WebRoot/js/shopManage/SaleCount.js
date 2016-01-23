var ctx="/"+window.location.pathname.split("/")[1];
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function checkdate()
  { 
    var fromdate = document.getElementById("fromdate").value;
	var todate = document.getElementById("todate").value;
	   if(fromdate!=""&&todate!="")
	   {
		  if(fromdate>todate)
		   { 
		   		alert("终止日期不应该小于起始日期！");
		   		return false;
		   }
		 return true;
	   }
	   else
	   {
		   return true;
	   }
	}
	
	function searchDate() {
		 if(checkdate())
		  {
			 document.form1.action = ctx+"/orderAction_searchOrder.action";
		     document.form1.submit();
		  } 
	 }
	
	function search()
	{
		document.form1.action = ctx+"/goodsAction_searchGoods.action";
	     document.form1.submit();
	}