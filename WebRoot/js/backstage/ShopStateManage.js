
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function deleteshop(id)
  {
	var authorizedToken=document.getElementById("authorizedToken").value;
	$.ajax({
		type : "POST",
		url : ctx+"/shopStateAction_deleteShop.action",
		data : "shopId=" + id+"&authorizedToken=" + authorizedToken,
		success : function(result) {
			if (result.data == 'right') {
				//alert("店铺删除成功！");
				window.location.reload(true);
			} else if (result.data == 'wrong') {
				alert("该店铺下有商品在售，不能删除！");
		           return;
			}
		},
		error : function() {
			window.location.href=ctx+"/error/remotelogin.jsp";
				//alert('系统忙，请稍后重试');
		}
	});
  }
  
   function shopdetial(id)
  {
      window.open(ctx+"/shopStateAction_sdetial.action?sid="+id+"");
  }
  
   function update(id)
  {
	   var authorizedToken=document.getElementById("authorizedToken").value;
 	  $.ajax({
			type : "POST",
			url : ctx+"/shopStateAction_updateStateShop.action",
			data : "shopId=" + id+"&authorizedToken=" + authorizedToken,
			success : function(result) {
				if (result.data == 'right') {
					//alert("店铺状态修改成功！");
					window.location.reload(true);
				} else if (result.data == 'wrong') {
					alert("店铺状态修改失败！");
			           return;
				}
			},
			error : function() {
				window.location.href=ctx+"/error/remotelogin.jsp";
   				//alert('系统忙，请稍后重试');
			}
		});
  }
  
  function marginpunish(id)
  {
      window.open(ctx+"/marginDetailAction_marginsub.action?shopId="+id+"");
  }
  
   function viewmargin(id)
  {
      window.open(ctx+"/marginDetailAction_viewDeital.action?shopId="+id+"");
  }
  
  function search()
  {
	 document.getElementById("pageNo").value=1; 
     document.form1.action= ctx+"/shopStateAction_listShop.action"; 
     document.form1.submit();  
  }