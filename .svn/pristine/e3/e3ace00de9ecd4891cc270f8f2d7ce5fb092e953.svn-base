
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function search() {
		document.getElementById("pageNo").value=1; 
		document.form1.action = ctx+"/shopStateAction_getGoods.action";
		document.form1.submit();
	
}
function update(id,state)
{
	var authorizedToken=document.getElementById("authorizedToken").value;
		   $.ajax({
	  			type : "POST",
	  			url : ctx+"/shopStateAction_setTopGoods.action",
	  			data : "goodsId=" + id+"&state="+state
	  			+"&authorizedToken=" + authorizedToken,
	  			success : function(result) {
	  				if (result.data == 'right') {
	  					// alert("设置成功");
	  					window.location.reload(true);
	  				} else if (result.data == 'wrong') {
	  				 alert("设置失败，首页显示商品数量以达到最大值6");
	  				}
	  			},
	  			error : function() {
	  				window.location.href=ctx+"/error/remotelogin.jsp";
	   				//alert('系统忙，请稍后重试');
	  			}
	  		});
}

 function openDetial(id,url)
{
	 var imgView=document.getElementById(id);
	 if(imgView.src!="http://localhost:8080/MyShop/image/picerror.jpg")
	 {
		 window.open(url); 
	 }
	 else
	 {
		 alert("图片加载失败！");
	 }
}

 