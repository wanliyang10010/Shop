//var ctx="/"+window.location.pathname.split("/")[1];
function opendetial(id,sid)
{
	window.open(ctx+"/viewProductAction_product.do?gid="+id+"&sid="+sid+"");
}

function ok() {
	if($.trim($("#transcompany").val()).length<=0){ 
		alert("亲，物流公司不能为空哦！");
		return false;
	}
	if($.trim($("#transnumber").val()).length<=0){ 
		alert("亲，物流单号不能为空哦！");
		return false;
	}else{
		var repPass =/^[0-9a-zA-Z]*$/g;
		var transnumber=document.getElementById("transnumber").value;
		if(!repPass.test(transnumber)){
			alert("亲，请按照物流单上的单号填写哦！");
			return false;
		}
	}
	if(checkIllegalChar()!=true){
	confirm('确定要发货？',okconfirm,null,null,'300');
	}
	else{
	alert("文本框中不能包含下列任何字符： \" \' &amp;");
	}
}

function okconfirm() {
	$("#btn_submit").attr('disabled',true);
	document.userform.action = ctx+"/orderAction_confirmDelivery.action";
	document.userform.submit();
}
function cancel() {
    document.getElementById("transcompany").value = "";
    document.getElementById("transnumber").value = "";
	}