	function lbtDetail(id, shopname, shopcategory, productcategory, userId,
			regeditdate, margin,tr) {
		var authorizedToken = $("#authorizedToken").val();
		$.ajax({
		type:"POST",
		url:ctx+"/marginRuleAction_getShopMargin.action",
		data:"shopcategory="+shopcategory+"&productcategory="+productcategory+"&authorizedToken=" + authorizedToken,
		success:function(result){
		document.getElementById("minmoney").value =result.data;
		},
		error:function(){
		alert("系统错误，请联系管理员！");
		}
		});
		document.getElementById("shopId").value = id;
		document.getElementById("shopname").value = shopname;
		document.getElementById("shopcategory").value = shopcategory;
		document.getElementById("productcategory").value = productcategory;
		
		document.getElementById("userId").value = userId;
		document.getElementById("regeditdate").value = regeditdate;
		document.getElementById("margin").value = margin;
		
		 $("#tr"+tr).css("background-color", "#BFEFFF").siblings().css("background","#FFFFFF");
          $("#trMain").css("background-color", "#BFDBEB");
		document.getElementById("tbDetail").style.display = "";	
	}
	
	function pay(authorizedToken) {
		if(checkIllegalChar()){
			alert("文本框中不能包含下列任何字符： \" \' &amp;");
			return false;
		}	
		var shopid=document.getElementById("shopId").value;
		var userId=document.getElementById("userId").value;
		var regeditdate=document.getElementById("regeditdate").value;
		var shopname=document.getElementById("shopname").value;
		var shopcategory=document.getElementById("shopcategory").value;
		var productcategory=document.getElementById("productcategory").value;	
		var margin=document.getElementById("margin").value;
		
		var money=document.getElementById("money").value;
		var remark=document.getElementById("remark").value;
		
		if($.trim($("#money").val()).length<=0){ 
			alert("实际缴费金额不能为空");
			return false;
		}
		else if (parseInt(money)<parseInt(document.getElementById("minmoney").value)) {
			alert("实际缴费金额不能低于最低缴费金额");
			return false;
		}
		 if (money == "0000000"||money == "000000"||money == "00000"||money == "0000"||money == "000"||money == "00"|| money == "0") {
				alert("实际缴费金额必须为大于最低缴费金额的数字!");
				return false;
		}
		 var re = /^[0-9]*[1-9][0-9]*$/ ; 
		 if(!re.test(money))
		 {
			 alert("实际缴费金额必须为大于0的数字!");
			 return false;
		 }  
		 var money=money.replace(/\b(0+)/gi,"");
		window.location.href = ctx+"/shopManage/payMargin.jsp?shopid="+shopid+"&userId="+userId
		+"&regeditdate="+regeditdate+"&shopname="+shopname+"&shopcategory="+shopcategory
		+"&productcategory="+productcategory+"&margin="+margin
		+"&money="+money+"&remark="+remark+"&authorizedToken=" + authorizedToken;
		
		$("#btn_submit").attr('disabled',true);
		$("#btn_cancel").attr('disabled',true);
	}
	
	function cancel() {
		document.getElementById("tbDetail").style.display = "none";
	}