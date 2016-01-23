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
	document.userform.action = ctx+"/prolongApplyAction_searchMyViewListSell.action";
	document.userform.submit();
	}
}

function lbtDetail(id, orderId, dayapply, reason, checkidea, state,tr) {
	document.getElementById("orderId").value = orderId;
	document.getElementById("dayapply").value = dayapply;
	if (reason == null || reason == "null" || reason == "") {
		reason = "";
	}
	document.getElementById("reason").value = reason;
	if ((checkidea == null || checkidea == "null" || checkidea == "")
			&& (state == "1" || state == "2")) {
		checkidea = "审核人很懒，什么也没有留下……";
	}
	if (checkidea != null && checkidea != "null" && checkidea != "") {
		document.getElementById("checkIdea").value = checkidea;
		document.getElementById("tbCheck").style.display = "";
	} else {
		document.getElementById("tbCheck").style.display = "none";
	}
	$("#tr"+tr).css("background-color", "#BFEFFF").siblings().css("background","#FFFFFF");
      $("#trMain").css("background-color", "#BFDBEB");
	document.getElementById("tbDetail").style.display = "";
	document.getElementById("tbHidden").style.display = "";
}
function btnhidden() {
	document.getElementById("tbDetail").style.display = "none";
	document.getElementById("tbCheck").style.display = "none";
	document.getElementById("tbHidden").style.display = "none";
}