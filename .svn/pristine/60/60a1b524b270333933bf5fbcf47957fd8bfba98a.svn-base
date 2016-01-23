var url=window.location.href;
var redirectUrl=url.substring(url.lastIndexOf("/"));

function opendetial(id,sid)
{
	window.open(ctx+"/viewProductAction_product.do?gid="+id+"&sid="+sid+"");
}

function paynow(orderid, username, buytime, shopname, ftotal, remark,authorizedToken) {
	window.location.href = ctx + "/haveBuyGoods/payNow.jsp?orderid=" + orderid
			+ "&username=" + username + "&buytime=" + buytime + "&shopname="
			+ shopname + "&ftotal=" + ftotal
			+ "&remark=" + remark+"&authorizedToken=" + authorizedToken + "&redirectUrl=" + redirectUrl;
}

function cancelorder(orderid) {
	confirm('取消订单后不可恢复，确定要取消订单？',cancelorderconfirm,null,orderid,'300');
}
function cancelorderconfirm(orderid) {
	document.getElementById("orderid").value = orderid;
	document.getElementById("redirectUrl").value = redirectUrl;
	document.userform.action = ctx + "/orderAction_cancelOrder.action";
	document.userform.submit();
}
function deleteorder(orderid) {
	confirm('删除订单后不可恢复，确定要删除订单？',deleteorderconfirm,null,orderid,'300');
}
function deleteorderconfirm(orderid) {
	document.getElementById("orderid").value = orderid;
	document.getElementById("redirectUrl").value = redirectUrl;
	document.userform.action = ctx + "/orderAction_deleteOrder.action";
	document.userform.submit();
} 
function viewtrans(orderid) {
	window.location.href = ctx + "/orderAction_viewtrans.action?orderid=" + orderid;
}

function confirmgoods(orderid) {
		confirm('确认收货后钱将立马打给卖家，您确定要确认收货吗？',confirmgoodsconfirm,null,orderid,'350');
}
function confirmgoodsconfirm(orderid) {
		document.getElementById("orderid").value = orderid;
		document.getElementById("redirectUrl").value = redirectUrl;
		document.userform.action = ctx + "/orderAction_confirmGoods.action";
		document.userform.submit();
}
function makeevaluation(ordersonId, shopId, goodsId, goodsPicture, goodsName,authorizedToken) {
	window.location.href = ctx
			+ "/pointEvaluation/makeEvaluation.jsp?ordersonId=" + ordersonId
			+ "&shopId=" + shopId + "&goodsId=" + goodsId + "&goodsPicture="
			+ goodsPicture + "&goodsName=" + goodsName+"&authorizedToken=" + authorizedToken;
}

function viewevaluation(ordersonId) {
	document.getElementById("ordersonId").value = ordersonId;
	document.userform.action = ctx+ "/goodsEvaluationAction_viewEvaluation.action";
	document.userform.submit();
}

function replysellevaluation(authorizedToken) {
	window.location.href = ctx + "/goodsEvaluationAction_searchPointEvaluation.action?authorizedToken="+authorizedToken;
}

function applyprolong(orderid, username, buytime, shopname, ftotal, remark,shopId,authorizedToken) {
	window.location.href = ctx + "/prolongTime/applyProlong.jsp?orderid="
			+ orderid + "&username=" + username + "&buytime=" + buytime
			+ "&shopname=" + shopname + "&ftotal=" + ftotal + "&remark="
			+ remark + "&shopId=" + shopId+"&authorizedToken=" + authorizedToken;
}

function alterprolong(orderid,authorizedToken) {
	window.location.href = ctx
			+ "/prolongApplyAction_searchMyAlterList.action?orderid=" + orderid+"&authorizedToken=" + authorizedToken;
}

function viewprolong(orderid,authorizedToken) {
	window.location.href = ctx
			+ "/prolongApplyAction_searchMyViewList.action?orderid=" + orderid+"&authorizedToken=" + authorizedToken;
}

function applyreturn(orderid, username, buytime, shopname, ftotal, remark,
		shopId,authorizedToken) {
	window.location.href = ctx + "/returnGoods/applyReturn.jsp?orderid="
			+ orderid + "&username=" + username + "&buytime=" + buytime
			+ "&shopname=" + shopname + "&ftotal=" + ftotal + "&remark="
			+ remark + "&shopId=" + shopId+"&authorizedToken=" + authorizedToken;
}

function alterreturn(orderid,authorizedToken) {
	window.location.href = ctx
			+ "/returnGoodsAction_searchMyAlterList.action?orderid=" + orderid+"&authorizedToken=" + authorizedToken;
}

function transInforeturn(orderid,authorizedToken) {
	window.location.href = ctx
			+ "/returnGoodsAction_searchMyPassList.action?orderid=" + orderid+"&authorizedToken=" + authorizedToken;
}

function viewreturn(orderid,authorizedToken) {
	window.location.href = ctx
			+ "/returnGoodsAction_searchMyViewList.action?orderid=" + orderid+"&authorizedToken=" + authorizedToken;
}

 function dispute(id)
   {              
       window.open(ctx+"/disputeAction_disputeinfo.action?ordersonid="+id+"");                                                    
   }
    function viewdispute(id)
   {     
      window.open(ctx+"/disputeAction_viewdispute.action?ordersonid="+id+"");                                            
   }
