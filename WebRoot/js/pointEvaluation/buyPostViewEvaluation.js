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
function replyfrombuy(id) {
	document.getElementById("imgFromBuyReply"+id).style.display = "none";
	document.getElementById("checkIdea"+id).style.display = "";
	document.getElementById("imgFromBuyPublishReply"+id).style.display = "";
}

function publishreplyfrombuy(id) {
		var checkIdea=document.getElementById("checkIdea"+id).value;
		if($.trim(checkIdea).length<=0){ 			
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
	       url:ctx+"/goodsEvaluationAction_replyfrombuy.action",
	       data:"id="+id+"&checkIdea="+checkIdea+"&authorizedToken=" + authorizedToken,
	       success:function(result){
	    	   if(result.data == "no"){
					 window.location.href =ctx + "/error/reOperation.jsp";					 					 
				  }else{
	         document.getElementById("imgFromBuyReply"+id).style.display = "none";
	         document.getElementById("checkIdea"+id).style.display = "none";
			 document.getElementById("imgFromBuyPublishReply"+id).style.display = "none";
			 window.location = ctx+"/goodsEvaluationAction_buySearchPointEvaluation.action";
				  }
				  },
	       error:function(){
				alert("系统错误，请联系管理员！");
			}
	     });
}

function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
}