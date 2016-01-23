
function checkdate() {
	var fromdate = document.getElementById("fromdate").value;
	var todate = document.getElementById("todate").value;
	if ((fromdate != "") && (todate != "") && (fromdate > todate)) {
			alert("终止日期不应该小于起始日期");
			return false;		
		}
	else
		 return true;		
	}
function search() {	
	 if(checkdate())
        {
	document.getElementById("pageNo").value = 1;
	document.userform.action = ctx+"/expressAction_searchViewList.action";
	document.userform.submit();
	}
}
