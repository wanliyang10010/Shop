
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function updateG(id)
  {
	var authorizedToken=document.getElementById("authorizedToken").value;
	var shopId = document.form1.shopId.value;
	$.ajax({
		type : "POST",
		url : ctx+"/shopStateAction_updateG.action",
		data : "goodId=" + id+"&shopId=" + shopId
		+"&authorizedToken=" + authorizedToken,
		success : function(result) {
			if (result.data == 'right') {
				//alert("商品状态修改成功！");
				window.location.reload(true);
			} else if (result.data == 'wrong') {
				alert("商品状态修改失败！");
		           return;
			}
		},
		error : function() {
			window.location.href=ctx+"/error/remotelogin.jsp";
				//alert('系统忙，请稍后重试');
		}
	});
  }
  
   function file(id)
  {
	   //alert(id);
	   //document.getElementById("goodId").value=id;
	   window.open(ctx+"/goodsPictureAction_listfileAdmin.action?goodId="+id+"");
  }
  
  function search()
  {
	 document.getElementById("pageNo").value=1; 
     document.form1.action= ctx+"/shopStateAction_listG.action"; 
     document.form1.submit();  
  }
  