//var ctx="/"+window.location.pathname.split("/")[1];
function opendetial(id,sid)
{
	window.open(ctx+"/viewProductAction_product.do?gid="+id+"&sid="+sid+"");
}
function shoppoint(authorizedToken) {
	 window.open(ctx+"/shopEvaluationAction_forwardShopPoint.action?authorizedToken="+authorizedToken);
}
function userpoint(authorizedToken) {
	 window.open(ctx+"/userPointAction_forwardUserPoint.action?authorizedToken="+authorizedToken);
}
//来自买家的评价
function img1(authorizedToken) {
   window.location = ctx+"/goodsEvaluationAction_buySearchPointEvaluation.action?authorizedToken="+authorizedToken;
}
//来自卖家的评价
function img2(authorizedToken) {
 window.location = ctx+"/goodsEvaluationAction_searchPointEvaluation.action?authorizedToken="+authorizedToken;
}
//给他人的评价
function img3(authorizedToken) {
 window.location = ctx+"/goodsEvaluationAction_otherSearchPointEvaluation.action?authorizedToken="+authorizedToken;
}
	
	function replyfromsell(id) {
		document.getElementById("imgFromSellReply"+id).style.display = "none";
		document.getElementById("addcontent"+id).style.display = "";
		document.getElementById("imgFromSellPublishReply"+id).style.display = "";
	}

	function publishreplyfromsell(id) {
		var addcontent=document.getElementById("addcontent"+id).value;
		if($.trim(addcontent).length<=0){ 
			alert("亲，写个回复内容呗！");
			return false;
		}
		if(checkIllegalChar()){
			alert("文本框中不能包含下列任何字符： \" \' &amp;");
			return false;
		}	
		var authorizedToken = $("#authorizedToken").val();
	  $.ajax({
       type:"POST",
       url:ctx+"/goodsEvaluationAction_replyfromsell.action",
       data:"id="+id+"&addcontent="+addcontent+"&authorizedToken=" + authorizedToken,
       success:function(result){
    	   if(result.data == "no"){
				 window.location.href =ctx + "/error/reOperation.jsp";					 					 
			  }else{
         document.getElementById("imgFromSellReply"+id).style.display = "none";
         document.getElementById("addcontent"+id).style.display = "none";
		 document.getElementById("imgFromSellPublishReply"+id).style.display = "none";
			  }
    	   },
       error:function(){
			alert("系统错误，请联系管理员！");
		}
     });
}