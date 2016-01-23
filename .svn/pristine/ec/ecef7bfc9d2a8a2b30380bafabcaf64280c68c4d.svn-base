//var ctx="/"+window.location.pathname.split("/")[1];
	  function lbtDetail(id, shopname, shopcategory, productcategory,
				shopaddress, shoppostnumber, shopphone, identifynumber,
				userpicture, identifypicture, identifypicture2,tr,addrarea) {
			document.getElementById("shopApplyId").value = id;
			document.getElementById("shopname").value = shopname;
			document.getElementById("shopcategory").value = shopcategory;
			document.getElementById("productcategory").value = productcategory;
			document.getElementById("shopaddress").value = shopaddress;
			document.getElementById("shoppostnumber").value = shoppostnumber;
			document.getElementById("shopphone").value = shopphone;
			document.getElementById("identifynumber").value = identifynumber;		
			document.getElementById("viewuserpicture").src= ctx+""+userpicture;
			document.getElementById("viewidentifypicture").src= ctx+""+identifypicture;
			document.getElementById("viewidentifypicture2").src= ctx+""+identifypicture2;
			
			$("#addrarea").val(addrarea);
			
		 	$("#tr"+tr).css("background-color", "#BFEFFF").siblings().css("background","#FFFFFF");
	        $("#trMain").css("background-color", "#BFDBEB"); 
			document.getElementById("tbDetail").style.display = "";
		}	
	function altershop() {
		if(checkIllegalChar()){
			alert("文本框中不能包含下列任何字符： \" \' &amp;");
			return false;
		}	
		if($.trim($("#shopaddress").val()).length<=0){ 
			alert("店铺具体位置不能为空！");
			return false;
		} else if($.trim($("#shoppostnumber").val()).length<=0){ 
			alert("店铺所在地店铺所在地邮编不能为空！");
			return false;
		}  else if($.trim($("#shopphone").val()).length<=0){ 
			alert("手机号码不能为空！");
			return false;
		} else {	
			$("#btn_submit").attr('disabled',true);
			$("#btn_cancel").attr('disabled',true);
			document.userform.method="post";
		    document.userform.enctype="multipart/form-data";
			document.userform.action = ctx+"/shopApplyAction_alterMyShopUpdate.action";
			document.userform.submit();
		}
	}
	function cancel() {
		document.getElementById("tbDetail").style.display = "none";
	}
	
	