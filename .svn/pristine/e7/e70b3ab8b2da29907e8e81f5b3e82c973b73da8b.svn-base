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
	document.userform.action = ctx+"/returnGoodsAction_searchMyPassList.action";
	document.userform.submit();
	}
}
function lbtDetail(id, orderId,tr) {
	document.getElementById("returngoodsId").value = id;
	document.getElementById("orderId").value = orderId;
	
	$("#tr"+tr).css("background-color", "#BFEFFF").siblings().css("background","#FFFFFF");
    $("#trMain").css("background-color", "#BFDBEB"); 
	document.getElementById("tbDetail").style.display = "";
}

function transInfo() {
	if(checkIllegalChar()){
		alert("文本框中不能包含下列任何字符： \" \' &amp;");
		return false;
	}	
	if($.trim($("#logisticscompany").val()).length<=0){ 
		alert("亲，物流公司名称不能为空哦！");
		return false;
	}
	else if($.trim($("#logisticsnum").val()).length<=0){ 
		alert("亲，物流单号不能为空哦！");
		return false;
	}else{
		var repPass =/^[0-9a-zA-Z]*$/g;
		var logisticsnum=document.getElementById("logisticsnum").value;
		if(!repPass.test(logisticsnum)){
			alert("亲，请按照物流单上的单号填写哦！");
			return false;
		}else{
			$("#btn_submit").attr('disabled',true);
			$("#btn_cancel").attr('disabled',true);
			document.userform.action = ctx+"/returnGoodsAction_transInfoUpdate.action";
			document.userform.submit();
		}
	}	
}
function cancel() {
	document.getElementById("tbDetail").style.display = "none";
}