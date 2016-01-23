//var ctx="/"+window.location.pathname.split("/")[1];

function checkdate()
  { 	
        var fromdate = $("#fromdate").val();
		var todate =  $("#todate").val();
	   if(fromdate!=""&&todate!="")
	   {
		   if(fromdate>todate)
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
			document.userform.action = ctx+"/shopApplyAction_searchAllCheckList.action";
			document.userform.submit();
			}
	}

	function lbtDetail(shopname, shopcategory, productcategory, shopaddress,
			shoppostnumber, shopphone, identifynumber, userpicture,
			identifypicture, identifypicture2,tr,count,addrarea) {
		 $("#shopname").val(shopname);
		 $("#shopcategory").val(shopcategory);
		 $("#productcategory").val(productcategory);
		 $("#shopaddress").val(shopaddress);
		 $("#shoppostnumber").val(shoppostnumber);
		 $("#shopphone").val(shopphone);
		 $("#identifynumber").val(identifynumber);
		 $("#userpicturepicture").attr("src",ctx+""+userpicture);
		 $("#identifypicturepicture").attr("src",ctx+""+identifypicture);
		 $("#identifypicture2picture").attr("src",ctx+""+identifypicture2); 
		 
		 $("#addrarea").val(addrarea);
		 
          $("#tr"+tr).css("background-color", "#BFEFFF").siblings().css("background","#FFFFFF");
          $("#trMain").css("background-color", "#BFDBEB");
		  $("#tbDetail").show();
		  
		  for(var i=1;i<count+1;i++){
			  if(i==tr)
				  $("#ckbox"+tr).prop("checked", true);
			  else
		           $("#ckbox"+i).prop("checked", false);			  
		  }
	}

	function pass(count) {
		if(checkIllegalChar()){
			alert("文本框中不能包含下列任何字符： \" \' &amp;");
			return false;
		}	
	for(var i=1;i<count+1;i++){
	if( $("#ckbox"+i).prop("checked")){
		
		$("#btn_pass").attr('disabled',true);
		$("#btn_notpass").attr('disabled',true);
		
		document.userform.action = ctx+"/shopApplyAction_updateAndSave.action";
		document.userform.submit();
		return false;
	}	
	}
	alert("请选择审核项目!");
	return false;
	}
	
	function notpass(count) {
		if(checkIllegalChar()){
			alert("文本框中不能包含下列任何字符： \" \' &amp;");
			return false;
		}	
	for(var i=1;i<count+1;i++){	
	if($("#ckbox"+i).prop("checked"))
	{
	 	    if($.trim($("#checkIdea").val()).length<=0){ 
				alert("审核意见不能为空！");
				return false;
			}else { 
			   $("#btn_pass").attr('disabled',true);
				$("#btn_notpass").attr('disabled',true);
			document.userform.action = ctx+"/shopApplyAction_notpassupdate.action";
		    document.userform.submit();
		    return false;
		 } 
	}	
	}
	alert("请选择审核项目!");
	return false;		
	}