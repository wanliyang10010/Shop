//var ctx="/"+window.location.pathname.split("/")[1];

/*function checkdate()
  { 
       var fromdate = document.getElementById("fromdate").value;
		var todate = document.getElementById("todate").value;
	   if(fromdate!=""&&todate!="")
	   {
			 if(fromdate==todate)
		   { 
		   		alert("起始日期和终止日期不应该相等");  
		   		return false;
		   }else if(fromdate>todate)
		   { 
		   		alert("终止日期不应该小于起始日期");
		   		return false;
		   }
	   }	
	}
	
function search() {
    if(checkdate()==false)
   {
   return false;
   } else{
	document.userform.action = ctx+"/shopApplyAction_searchMyViewList.action";
	document.userform.submit();
	}
}
*/
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
	
	document.getElementById("userpicturepicture").src= ctx+""+userpicture;
	document.getElementById("identifypicturepicture").src= ctx+""+identifypicture;
	document.getElementById("identifypicture2picture").src= ctx+""+identifypicture2;
	
	$("#addrarea").val(addrarea);
	
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