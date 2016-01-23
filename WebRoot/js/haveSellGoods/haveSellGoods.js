// var ctx = "/" + window.location.pathname.split("/")[1];
var url=window.location.href;
var redirectUrl=url.substring(url.lastIndexOf("/"));


function opendetial(id,sid)
{
	window.open(ctx+"/viewProductAction_product.do?gid="+id+"&sid="+sid+"");
}

function altermoney(orderid) {
	//document.getElementById("orderPay_id"+orderid).style.display = "none";
	document.getElementById("show_ftotal"+orderid).style.display = "none";
	document.getElementById("alterOrderPay_id"+orderid).style.display = "";
	document.getElementById("btn_altermoney"+orderid).style.display = "none";
	document.getElementById("btn_savealtermoney"+orderid).style.display = "";
	var showftotal=document.getElementById("show_ftotal"+orderid).innerHTML;
	document.getElementById("alterftotal"+orderid).innerHTML=showftotal;
	
	document.getElementById("show_ftotal2"+orderid).style.display = "none";
	document.getElementById("alterOrderPay_id2"+orderid).style.display = "";
	var showftotal=document.getElementById("show_ftotal2"+orderid).innerHTML;
	document.getElementById("alterftotal2"+orderid).innerHTML=showftotal;
	}

function deleteordersell(orderid) {
	confirm('删除订单后不可恢复，确定要删除订单？',deleteordersellconfirm,null,orderid,'300');
}
function deleteordersellconfirm(orderid) {
	document.getElementById("orderid").value = orderid;
	document.getElementById("redirectUrl").value = redirectUrl;
	document.userform.action = ctx + "/orderAction_deleteOrderSell.action";
	document.userform.submit();
} 
function savealtermoney(orderid) {
	var alterftotal="";
	alterftotal=document.getElementById("alterftotal"+orderid).value;
	//下面这个判断是唯一标识符，媒体查询动态添加的，初始化时0px，实际中不影响效果
	if($("#havesellgoodsorderPay_id2").css("margin-left")=="3px"){
		alterftotal=document.getElementById("alterftotal2"+orderid).value;
	}
	if(alterftotal==""||alterftotal==" "||alterftotal=="  "||alterftotal=="   "||
			alterftotal=="    "||alterftotal=="     "||alterftotal=="      "||
			alterftotal=="       "||alterftotal=="        "||alterftotal=="         "||alterftotal=="          ")
		{
		alert("亲，费用不能为空哦！");
		return false;
		}
		if(alterftotal.substring(0,2)=="0/")
		{
		alert("亲，请输入正确的数字哦！");
		return false;	
		}
		 var re =/^\d+(\.\d+)?$/;  
	  	 if(!re.test(alterftotal))
	  	 {
	  		 alert("亲，请输入正确的数字哦!!");
	  		 return false;
	  	 }  
	  	if(parseFloat(alterftotal).toFixed(2)>9999999.00)
		{
		 alert("亲，您输入的数字过大哦!!");
  		 return false;
		}
	//document.getElementById("orderPay_id"+orderid).style.display = "";
	document.getElementById("alterOrderPay_id"+orderid).style.display = "none";
	document.getElementById("btn_altermoney"+orderid).style.display = "";
	document.getElementById("btn_savealtermoney"+orderid).style.display = "none";	
	document.getElementById("show_ftotal"+orderid).innerHTML=parseFloat(alterftotal).toFixed(2);
	document.getElementById("show_ftotal"+orderid).style.display = "";
	
	document.getElementById("alterOrderPay_id2"+orderid).style.display = "none";
	document.getElementById("show_ftotal2"+orderid).innerHTML=parseFloat(alterftotal).toFixed(2);
	document.getElementById("show_ftotal2"+orderid).style.display = "";
	
	
	 var authorizedToken = $("#authorizedToken").val();
	 $.ajax({
		 type:"POST",
		 url:ctx+"/orderAction_saveAlterMoney.action",
		 async:false,
		 data:"orderid="+orderid+"&ftotal="+parseFloat(alterftotal).toFixed(1)+"&authorizedToken=" + authorizedToken,
		 success:function(result){	
			 if(result.data == "no"){
				 window.location.href =ctx + "/error/reOperation.jsp";					 					 
			  }
		 },
		 error:function(){		
		 }
		 }); 
	}

function confirmdelivery(orderid,authorizedToken) {
	window.location.href = ctx + "/orderAction_confirmdeliveryJSP.action?orderid=" + orderid+"&authorizedToken=" + authorizedToken;
	/*window.location.href = ctx + "/haveSellGoods/confirmDelivery.jsp?orderid="
	+ orderid + "&username=" + username + "&buytime=" + buytime
	+ "&shopname=" + shopname + "&ftotal=" + ftotal + "&remark="+ remark+"&authorizedToken=" + authorizedToken;	
	http://localhost:8080/SS/orderAction_confirmdeliveryJSP.action?orderid=1034&authorizedToken=1113*/	
}
	
function sellprolong(orderid,authorizedToken) {
	window.location.href = ctx + "/orderAction_prolongTime.action?orderid=" + orderid+"&authorizedToken=" + authorizedToken;
	/*window.location.href = ctx + "/prolongTime/prolongSeller.jsp?orderid="+orderid+"&username="+username
	+"&buytime="+buytime+"&shopname="+shopname+"&ftotal="+ftotal
	+"&remark="+ remark+"&authorizedToken=" + authorizedToken;		*/
	}
	
function replybuyevaluation(){		
		document.userform.action = ctx+"/goodsEvaluationAction_buySearchPointEvaluation.action";
	   document.userform.submit();
		}
		
function viewevaluation(ordersonId){	
	document.getElementById("ordersonId").value = ordersonId;
	document.userform.action = ctx+ "/goodsEvaluationAction_viewEvaluation.action";
	document.userform.submit();
		}
		  
function checkprolong(orderid,authorizedToken){
		window.location.href = ctx+"/prolongApplyAction_searchMyCheckList.action?orderid="+orderid+"&authorizedToken=" + authorizedToken;
		}
		
function viewprolong(orderid,authorizedToken){
		window.location.href = ctx+"/prolongApplyAction_searchMyViewListSell.action?orderid="+orderid+"&authorizedToken=" + authorizedToken;
		}
		
function checkreturn(orderid,authorizedToken){
		window.location.href = ctx+"/returnGoodsAction_searchMyCheckList.action?orderid="+orderid+"&authorizedToken=" + authorizedToken;
		}
		
function confirmreturn(orderid,authorizedToken){
		window.location.href = ctx+"/returnGoodsAction_searchMyConfirmList.action?orderid="+orderid+"&authorizedToken=" + authorizedToken;
		}
		
function viewreturn(orderid,authorizedToken){
		window.location.href = ctx+"/returnGoodsAction_searchMyViewListSell.action?orderid="+orderid+"&authorizedToken=" + authorizedToken;
		}