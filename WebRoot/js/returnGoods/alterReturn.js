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
	document.userform.action = ctx+"/returnGoodsAction_searchMyAlterList.action";
	document.userform.submit();
	}
}
function lbtDetail(id,orderid,reason, checkidea,tr,addr) {
	document.getElementById("returngoodsId").value = id;
	document.getElementById("orderid").value = orderid;
	document.getElementById("addr").value=addr;
	
	document.getElementById("reason").value = reason;
	if (checkidea != null && checkidea != "") {
		document.getElementById("checkIdea").value = checkidea;
		document.getElementById("tbCheck").style.display = "";
	}
	$("#tr"+tr).css("background-color", "#BFEFFF").siblings().css("background","#FFFFFF");
    $("#trMain").css("background-color", "#BFDBEB"); 
	document.getElementById("tbDetail").style.display = "";
}
function deletereturnGoods(id,orderid) {
	document.getElementById("returngoodsId").value = id;
	document.getElementById("orderid").value = orderid;
	confirm('确定要删除吗？',deletereturnGoodsconfirm,null,null,'300');	
	/*document.userform.action = ctx+"/returnGoodsAction_delete.action";
	document.userform.submit();*/
}
function deletereturnGoodsconfirm() {
	/*document.getElementById("returngoodsId").value = id;
	document.getElementById("orderid").value = orderid;*/
	document.userform.action = ctx+"/returnGoodsAction_delete.action";
	document.userform.submit();
}
function alter() {
	if(checkIllegalChar()){
		alert("文本框中不能包含下列任何字符： \" \' &amp;");
		return false;
	}	
	if($.trim($("#reason").val()).length>0){
	$("#btn_submit").attr('disabled',true);
	$("#btn_cancel").attr('disabled',true);
	document.userform.action = ctx+"/returnGoodsAction_alterUpdate.action";
	document.userform.submit();
	}
	else{
		alert("亲，退货理由不能为空哦！");		
		return false;
	}	
}
function cancel() {
	document.getElementById("tbDetail").style.display = "none";
	document.getElementById("tbCheck").style.display = "none";
}