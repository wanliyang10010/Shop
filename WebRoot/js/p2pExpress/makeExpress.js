 
$(function(){
     	var html="<select name='weight' id='weight' style='width:150px'><option value='1kg以内'>1kg以内</option>";
     	var html21="<option value='20kg以上'>20kg以上</option></select>";
     	var weightDom=document.getElementById("weightDiv");
     	for (var i=1;i<21;i+=2) {
     		html+="<option value='"+i+"kg到"+(i+2)+"kg以内'>"+i+"kg到"+(i+2)+"kg以内</option>";
     	}
     	//alert(weightDom);<select name="weight" id="weight" style="width:150px"></select>
		weightDom.innerHTML=html+html21;
     });

function ok() {	
	if(checkIllegalChar()){
		alert("文本框中不能包含下列任何字符： \" \' &amp;");
		return false;
	}	
	if(($.trim($("#name").val()).length>0)&&($.trim($("#address").val()).length>0)&&
			($.trim($("#phone").val()).length>0)&&($.trim($("#receiveaddr").val()).length>0)&&
			($.trim($("#weight").val()).length>0)&&($.trim($("#description").val()).length>0)&&
			($.trim($("#money").val()).length>0)){
		$("#btn_submit").attr('disabled',true);
		$("#btn_cancel").attr('disabled',true);
		document.userform.action = ctx+"/expressAction_save.action";
		document.userform.submit();
	}
	else{
		alert("请将信息填写完整！");
		return false;
	}	
}
function cancel() {
	window.location.href = ctx+"/p2pExpress/makeExpress.jsp";
}
