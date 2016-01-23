//var ctx="/"+window.location.pathname.split("/")[1];

function checkdate()
  { 
       var fromdate = document.getElementById("fromdate").value;
		var todate = document.getElementById("todate").value;
	   if(fromdate!=""&&todate!="")
	   { if(fromdate>todate)
		   { 
		   		alert("终止日期不应该小于起始日期");
		   		return false;
		   }
	   else if(!RQcheck(fromdate) || !RQcheck(todate))
		  {
		  alert("您输入的日期非法，请重新选择");
		  return false;
		  }
	   }	
	}

	function RQcheck(RQ) {
	   var date = RQ;
	   var result = date.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
	
	   if (result == null)
	       return false;
	   var d = new Date(result[1], result[3] - 1, result[4]);
	   return (d.getFullYear() == result[1] && (d.getMonth() + 1) == result[3] && d.getDate() == result[4]);
	}
	
function search() {
    if(checkdate()==false)
   {
   return false;
   } else{
	document.getElementById("pageNo").value = 1;
	document.userform.action = ctx+"/shopApplyAction_adminViewShopProgress.action";
	document.userform.submit();
	}
}

function lbtDetail(shopname, shopcategory, productcategory, shopaddress,
		shoppostnumber, shopphone, identifynumber, userpicture,
		identifypicture, identifypicture2,checkidea,state,tr,addrarea) {
	document.getElementById("shopname").value = shopname;
	document.getElementById("shopcategory").value = shopcategory;
	document.getElementById("productcategory").value = productcategory;
	document.getElementById("shopaddress").value = shopaddress;
	document.getElementById("shoppostnumber").value = shoppostnumber;
	document.getElementById("shopphone").value = shopphone;
	document.getElementById("identifynumber").value = identifynumber;
	
	$("#addrarea").val(addrarea);
	$("#userpicturepicture").attr("src",ctx+""+userpicture);
	$("#identifypicturepicture").attr("src",ctx+""+identifypicture);
	$("#identifypicture2picture").attr("src",ctx+""+identifypicture2);
	
 	if ((checkidea == null || checkidea == "null" || checkidea == "")
			&& (state == "1" || state == "2")) {
		checkidea = "审核人很懒，什么也没有留下……";
	} 
	if (checkidea != null && checkidea != "null" && checkidea != "") {
		document.getElementById("checkIdea").value = checkidea;
		document.getElementById("tbCheck").style.display = "";
	}
	else{
	document.getElementById("tbCheck").style.display = "none";
	}

    $("#tr"+tr).css("background-color", "#BFEFFF").siblings().css("background","#FFFFFF");
    $("#trMain").css("background-color", "#BFDBEB"); 
    
	document.getElementById("tbDetail").style.display = "";
	document.getElementById("tbHidden").style.display = "";	
}
	function btnhidden(){
		document.getElementById("tbDetail").style.display = "none";
		document.getElementById("tbCheck").style.display = "none";
		document.getElementById("tbHidden").style.display = "none";
	}