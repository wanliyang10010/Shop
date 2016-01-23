//var ctx="/"+window.location.pathname.split("/")[1];

function opendetial(id,sid)
{
	window.open(ctx+"/viewProductAction_product.do?gid="+id+"&sid="+sid+"");
}

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
	document.userform.action = ctx+"/returnGoodsAction_searchMyConfirmList.action";
	document.userform.submit();
	}
}
function lbtDetail(id, orderId,logisticscompany,logisticsnum,tr) {
	document.getElementById("returngoodsId").value = id;
	document.getElementById("orderId").value = orderId;
	document.getElementById("logisticscompany").value = logisticscompany;
	document.getElementById("logisticsnum").value = logisticsnum;
	
	$("#tr"+tr).css("background-color", "#BFEFFF").siblings().css("background","#FFFFFF");
    $("#trMain").css("background-color", "#BFDBEB"); 
	document.getElementById("tbDetail").style.display = "";
}

function confirmreturn() {
	if(checkIllegalChar()){
		alert("文本框中不能包含下列任何字符： \" \' &amp;");
		return false;
	}	
	$("#btn_submit").attr('disabled',true);	
	document.userform.action = ctx+"/returnGoodsAction_confirmUpdate.action";
	document.userform.submit();
}
