function paymoney() {
	confirm('支付完成后不得取消订单和申请退款，确定要支付吗？',paymoneyconfirm,null,null,'380');
	
}

function paymoneyconfirm() {
	$("#btn_submit").attr('disabled',true);
	var url=window.location.href;
	var redirectUrl=url.substring(url.lastIndexOf("/"));	
	document.getElementById("redirectUrl").value = redirectUrl;
		
	document.userform.action = ctx+"/orderAction_payNow.action";
	document.userform.submit();
}