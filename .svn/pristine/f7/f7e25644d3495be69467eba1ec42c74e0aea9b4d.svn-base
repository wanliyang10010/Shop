
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function checkdate()
{ 
  var fromdate = document.getElementById("fromdate").value;
	var todate = document.getElementById("todate").value;
	   if(fromdate!=""&&todate!="")
	   {
		 if(fromdate==todate)
		   { 
		   		alert("起始日期和终止日期不应该相等！");  
		   		return false;
		   }else if(fromdate>todate)
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
			 document.form1.action = ctx+"/stageOrderAction_searchOrder.action";
		     document.form1.submit();
		  } 
	 }