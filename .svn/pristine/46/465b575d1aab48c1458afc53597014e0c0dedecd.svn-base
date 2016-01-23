//var ctx="/"+window.location.pathname.split("/")[1];

function applyProlong() {
	document.getElementById("tbDetail").style.display = "";		
	}
	
	function ok() {
		if($.trim($("#dayapply").val()).length<=0){ 
			alert("延长天数不能为空！");
			return false;
		}
	 var da=document.getElementById("dayapply");
	 if (da.value == "00"||da.value == "0" ||da.value == "0 ") {
			alert("延长天数必须为大于0的数字!");
			return false;
		   }
	 var re = /^[0-9]*[1-9][0-9]*$/ ; 
	 if(!re.test(da.value))
	 {
		 alert("延长天数必须为大于0的数字!");
		 return false;
	 }  
	if(checkIllegalChar()){
		alert("文本框中不能包含下列任何字符： \" \' &amp;");
		return false;
	}	
	$("#btn_submit").attr('disabled',true);
	$("#btn_cancel").attr('disabled',true);
	document.userform.action = ctx+"/prolongApplyAction_save.action";
	document.userform.submit();
	}
	function cancel() {
     document.getElementById("tbDetail").style.display = "none";
	}