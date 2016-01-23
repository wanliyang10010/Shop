//var ctx="/"+window.location.pathname.split("/")[1];

function opendetial(id,sid)
{
	window.open(ctx+"/viewProductAction_product.do?gid="+id+"&sid="+sid+"");
}

function ok() {
	if (document.getElementById("goodspoint1").checked == false
			&& document.getElementById("goodspoint2").checked == false
			&& document.getElementById("goodspoint3").checked == false) {
		alert("亲，给宝贝评个分呗！");
		return false;
	} else if (document.getElementById("goodscontent").value == "亲，写点评价吧，你的评价对其他买家有很大帮助的。"
			|| document.getElementById("goodscontent").value == "咳咳，你给卖家打了中评，需要说明原因哦。"
			|| document.getElementById("goodscontent").value == "咳咳，您给了差评哦，亲可以先联系卖家沟通一下售后哦~"
			|| ($.trim($("#goodscontent").val()).length<=0)) {
		alert("亲，给宝贝写个评价呗！");
		return false;
	} else if (document.getElementById("stars1-input").value == ""
			|| document.getElementById("stars2-input").value == ""
			|| document.getElementById("stars3-input").value == "") {
		alert("亲，给店铺评个分呗！");
		return false;
	} else {
		if(checkIllegalChar()){
			alert("文本框中不能包含下列任何字符： \" \' &amp;");
			return false;
		}		
		document.getElementById("imgSubmitNo").style.display="";
		document.getElementById("imgSubmit").style.display="none";
		document.userform.action = ctx+"/goodsEvaluationAction_save.action"
		document.userform.submit();
	}
}

function goodsRadio(num) {
	if (num == "1") {
		document.getElementById("imgGood").style.display = "";
		document.getElementById("imgMiddle").style.display = "none";
		document.getElementById("imgBad").style.display = "none";

		document.getElementById("Ghind").style.display = "";
		document.getElementById("Mhind").style.display = "none";
		document.getElementById("Bhind").style.display = "none";
		
		if (document.getElementById("goodscontent").value == ""
			|| document.getElementById("goodscontent").value == "咳咳，你给卖家打了中评，需要说明原因哦。"
			|| document.getElementById("goodscontent").value == "咳咳，您给了差评哦，亲可以先联系卖家沟通一下售后哦~") {
			document.getElementById("goodscontent").value = "亲，写点评价吧，你的评价对其他买家有很大帮助的。";
	}
		
	} else if (num == "2") {
		document.getElementById("imgGood").style.display = "none";
		document.getElementById("imgMiddle").style.display = "";
		document.getElementById("imgBad").style.display = "none";

		document.getElementById("Ghind").style.display = "none";
		document.getElementById("Mhind").style.display = "";
		document.getElementById("Bhind").style.display = "none";
		
		if (document.getElementById("goodscontent").value == "亲，写点评价吧，你的评价对其他买家有很大帮助的。"
			|| document.getElementById("goodscontent").value == ""
			|| document.getElementById("goodscontent").value == "咳咳，您给了差评哦，亲可以先联系卖家沟通一下售后哦~") {
			document.getElementById("goodscontent").value = "咳咳，你给卖家打了中评，需要说明原因哦。";
	}
		
	} else if (num == "3") {
		document.getElementById("imgGood").style.display = "none";
		document.getElementById("imgMiddle").style.display = "none";
		document.getElementById("imgBad").style.display = "";

		document.getElementById("Ghind").style.display = "none";
		document.getElementById("Mhind").style.display = "none";
		document.getElementById("Bhind").style.display = "";

		if (document.getElementById("goodscontent").value == "亲，写点评价吧，你的评价对其他买家有很大帮助的。"
			|| document.getElementById("goodscontent").value == "咳咳，你给卖家打了中评，需要说明原因哦。"
			|| document.getElementById("goodscontent").value == "") {
			document.getElementById("goodscontent").value = "咳咳，您给了差评哦，亲可以先联系卖家沟通一下售后哦~";
	}
		
	}
}
function clickgoodscontent()
{
	if (document.getElementById("goodscontent").value == "亲，写点评价吧，你的评价对其他买家有很大帮助的。"
		|| document.getElementById("goodscontent").value == "咳咳，你给卖家打了中评，需要说明原因哦。"
		|| document.getElementById("goodscontent").value == "咳咳，您给了差评哦，亲可以先联系卖家沟通一下售后哦~") {
		document.getElementById("goodscontent").value = "";
}

}