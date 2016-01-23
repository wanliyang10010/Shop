//var ctx="/"+window.location.pathname.split("/")[1];

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
	document.userform.action = ctx+"/prolongApplyAction_searchMyAlterList.action";
	document.userform.submit();
	}
}

function lbtDetail(id, orderid, dayapply, reason, checkidea,tr) {
	document.getElementById("prolongapplyId").value = id;
	document.getElementById("orderid").value = orderid;
	document.getElementById("dayapply").value = dayapply;
	if (reason == null || reason == "null" || reason == "") {
		reason = "";
	}
	document.getElementById("reason").value = reason;
	if (checkidea != null && checkidea != "") {
		document.getElementById("checkIdea").value = checkidea;
		document.getElementById("tbCheck").style.display = "";
	}
	$("#tr"+tr).css("background-color", "#BFEFFF").siblings().css("background","#FFFFFF");
    $("#trMain").css("background-color", "#BFDBEB"); 
	document.getElementById("tbDetail").style.display = "";
}

function deleteprolongApply(id,orderid) {	
	document.getElementById("prolongapplyId").value = id;
	document.getElementById("orderid").value = orderid;
	confirm('确定要删除吗？',deleteprolongApplyconfirm,null,null,'300');
/*	document.userform.action = ctx+"/prolongApplyAction_delete.action";
	document.userform.submit();*/
}

function deleteprolongApplyconfirm() {
/*	document.getElementById("prolongapplyId").value = id;
	document.getElementById("orderid").value = orderid;*/
	document.userform.action = ctx+"/prolongApplyAction_delete.action";
	document.userform.submit();
}

function alter() {
if($.trim($("#dayapply").val()).length<=0){ 
	alert("延长天数不能为空！");
	return false;
}
var da=document.getElementById("dayapply");
if (da.value == "00"||da.value == "0" ||da.value == "0 ") {
	alert("延长天数必须为大于0的数字!");
	return false;
   }
if(checkIllegalChar()){
	alert("文本框中不能包含下列任何字符： \" \' &amp;");
	return false;
}	
$("#btn_submit").attr('disabled',true);
$("#btn_cancel").attr('disabled',true);
	document.userform.action = ctx+"/prolongApplyAction_alterUpdate.action";
	document.userform.submit();
}
function cancel() {
	document.getElementById("tbDetail").style.display = "none";
	document.getElementById("tbCheck").style.display = "none";
}