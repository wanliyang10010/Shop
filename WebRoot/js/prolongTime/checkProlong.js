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
	document.userform.action = ctx+"/prolongApplyAction_searchMyCheckList.action";
	document.userform.submit();
	}
	}

	function lbtDetail(orderId, dayapply, reason,tr,count) {
		document.getElementById("orderId").value = orderId;
		document.getElementById("dayapply").value = dayapply;
		if (reason == null || reason == "null" || reason == "") {
			reason = "";
		}		
		document.getElementById("reason").value = reason;				 
		$("#tr"+tr).css("background-color", "#BFEFFF").siblings().css("background","#FFFFFF");
        $("#trMain").css("background-color", "#BFDBEB");
		document.getElementById("tbDetail").style.display = "";
		document.getElementById("tbCheck").style.display = "";
		 for(var i=1;i<count+1;i++){
			  if(i==tr)
				  $("#ckbox"+tr).prop("checked", true);
			  else
		           $("#ckbox"+i).prop("checked", false);			  
		  }
	}

	function pass(count) {
		if(checkIllegalChar()){
			alert("文本框中不能包含下列任何字符： \" \' &amp;");
			return false;
		}	
	for(var i=1;i<count+1;i++){
	if(document.getElementById("ckbox"+i).checked)
	{
		$("#btn_pass").attr('disabled',true);
		$("#btn_notpass").attr('disabled',true);
		
		document.userform.action = ctx+"/prolongApplyAction_passupdate.action";
		document.userform.submit();
		return false;
		}	
	}
	alert("请选择审核项目!");
	return false;
	}
	
	function notpass(count) {
		if(checkIllegalChar()){
			alert("文本框中不能包含下列任何字符： \" \' &amp;");
			return false;
		}	
	for(var i=1;i<count+1;i++){
	if(document.getElementById("ckbox"+i).checked)
	{
		if($.trim($("#checkIdea").val()).length<=0){ 
			alert("审核意见不能为空！");
			return false;
		}
		else { 
			$("#btn_pass").attr('disabled',true);
			$("#btn_notpass").attr('disabled',true);
			document.userform.action = ctx+"/prolongApplyAction_notpassupdate.action";
			document.userform.submit();
			return false;
		 } 
	}	
	}
	alert("请选择审核项目!");
	return false;		
	}