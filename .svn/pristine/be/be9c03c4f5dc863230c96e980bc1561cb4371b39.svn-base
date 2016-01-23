//var ctx="/"+window.location.pathname.split("/")[1];

function applyReturn() {
	document.getElementById("tbDetail").style.display = "";		
	}
	
	function ok() {	
		if(checkIllegalChar()){
			alert("文本框中不能包含下列任何字符： \" \' &amp;");
			return false;
		}	
		if($.trim($("#reason").val()).length>0){
			$("#btn_submit").attr('disabled',true);
			$("#btn_cancel").attr('disabled',true);
			
		    document.userform.action = ctx+"/returnGoodsAction_save.action";
			document.userform.submit();
			}
		else{
			alert("亲，退货理由不能为空哦！");
			return false;
		}	
	}
	function cancel() {
         document.getElementById("tbDetail").style.display = "none";
	}
