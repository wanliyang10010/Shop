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
	document.userform.action = ctx+"/expressAction_searchAlterList.action";
	document.userform.submit();
	}
}
function deleteexpress(id) {
	document.getElementById("expressId").value = id;
	confirm('确定要删除吗？',deleteexpressconfirm,null,null,'300');	
}
function deleteexpressconfirm() {
	document.userform.action = ctx+"/expressAction_delete.action";
	document.userform.submit();
}
