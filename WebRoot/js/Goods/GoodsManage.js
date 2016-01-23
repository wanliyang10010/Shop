
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}

function updateG(id,count)
  {
	var authorizedToken=document.getElementById("authorizedToken").value;
	if(parseFloat(count)>0)
	{
		$.ajax({
			type : "POST",
			url : ctx+"/goodsAction_updateGoods.action",
			data : "goodId=" + id+"&authorizedToken=" + authorizedToken,
			success : function(result) {
				if (result.data == 'right') {
					//alert("修改成功！");
					window.location.reload(true);
				}
				else
				{
					alert("修改失败！");
				}
			},
			error : function() {
				alert('系统忙，请稍后重试');
			}
		});  
	}
	else
	{
		alert('该商品库存0，请补货后再将商品上架');
	}
	
  }
  
  function file(id)
  {
	window.open(ctx+"/goodsPictureAction_listfile.action?goodId="+id+"");
  }
  
  function item(goodsId,typeId)
  {
	window.open(ctx+"/goodsDetialAction_listitem.action?goodId="+goodsId+"&&typeId="+typeId+"");
  }
  

 
  function updateH(id)
  {
         document.getElementById("goodId").value=id; 
		 document.form1.action= ctx+"/goodsAction_updateH.action"; 
         document.form1.submit();  
  }
  
  function AddDis(id)
  {
	window.open(ctx+"/goodsAction_AddDis.action?gid="+id+"");
  }
  
  function search()
  {
	  document.getElementById("pageNo").value=1; 
     document.form1.action= ctx+"/goodsAction_listDH.action"; 
     document.form1.submit();  
  }
  
  function edit(id)
  {
    document.form1.action= ctx+"/goodsAction_AddDis.action"; 
    document.form1.submit();  
  }
  
  function judgeNull()
  {
			if(checkIllegalChar()!=true){
				if(document.form1.goodsname.value=="")
			     {
			        alert("商品名称不能为空！");
			        return false;
			     }
			     if(document.form1.price.value=="")
			     {
			        alert("商品单价不能为空！");
			        return false;
			     }
			     else if(parseFloat(document.form1.price.value)<=0)
			     {
			    	 alert("商品单价不能为零！");
			         document.form1.price.value=""
			         return false;
			     }
			     if(document.form1.amount.value=="")
			     {
			        alert("商品数量不能为空！");
			        return false;
			     }
			} else
			{
				alert("文本框中不能包含下列任何字符： \" \' &amp;");
		        return false;
			}
     return true;
  }
  function  updategoods()
  {
	  if(judgeNull())
	  {
		  var authorizedToken=document.getElementById("authorizedToken").value;
		 var goodsname=document.getElementById("goodsname").value;
         var price=document.getElementById("price").value;
         var freight=document.getElementById("freight").value;
	     var amount=document.getElementById("amount").value;
		 var goodsid= document.getElementById("goodId").value;
    	  $.ajax({
  			type : "POST",
  			url : ctx+"/goodsAction_update.action",
  			data : "goodsid=" + goodsid
  			      +"&goodsname="+goodsname
  			    +"&price="+price
  			    +"&freight="+freight
  			  +"&amount="+amount+"&authorizedToken=" + authorizedToken,
  			success : function(result) {
  				if (result.data == 'right') {
  					cancelupdate();
  					window.location.reload(true);
  				}
  				else
  				{
  					alert("商品更新失败,商品价格不能低于促销价格！");
  				}
  			},
  			error : function() {
  				alert('系统忙，请稍后重试');
  			}
  		});
	  }
  }
  
  function  openStock()
  {
	  var id= document.getElementById("goodId").value;
	  window.open(ctx+"/goodsStockAction_getItem.action?goodsId="+id+"");
	  //window.location.href=ctx+"/goodsStockAction_getItem.action?goodsId="+id+"";
  }
  
  function  opengoods(id,goodsname,price,amount,freight)
  {
	    var authorizedToken=document.getElementById("authorizedToken").value;
	     document.getElementById("goodId").value=id; 
	     document.getElementById("goodsname").value=goodsname; 
	     document.getElementById("price").value=price; 
	     document.getElementById("freight").value=freight; 
	     document.getElementById("amount").value=amount; 
		 document.getElementById("divedit").style.display=""; 
	  $.ajax({
			type : "POST",
			url : ctx+"/goodsAction_checkStock.action",
			data : "goodsid=" + id +"&authorizedToken=" + authorizedToken,
			success : function(result) {
				if (result.data == 'right') {
					 document.getElementById("amount").style.display="none";
					 document.getElementById("fontStock").innerHTML =amount+"(件)修改商品库存，请前往";
				}
				else
				{
					document.getElementById("amount").style.display="";
					document.getElementById("fontStock").innerHTML ="添加";
					
				}
			},
			error : function() {
				alert('系统忙，请稍后重试');
			}
		});
  }
  
  function deletegoods(id)
  {
	  var authorizedToken=document.getElementById("authorizedToken").value;
 	  $.ajax({
			type : "POST",
			url : ctx+"/goodsAction_deleteGoods.action",
			data : "goodsid=" +id+"&authorizedToken=" + authorizedToken,
			success : function(result) {
				if (result.data == 'right') {
					//alert("商品删除成功！");
					window.location.reload(true);
				}
				else
				{
					alert("该商品已经售出，请删除订单后再删除该商品！");
				}
			},
			error : function() {
				alert('系统忙，请稍后重试');
			}
		});
  }
  
  function  cancelupdate()
  {
	  document.getElementById("goodId").value=""; 
	     document.getElementById("goodsname").value=""; 
	     document.getElementById("price").value=""; 
	     document.getElementById("freight").value="";
	     document.getElementById("amount").value=""; 
		 document.getElementById("divedit").style.display="none"; 
		 document.getElementById("amount").style.display="";
  }
  
  function opendetial(id,sid)
  {
 		  window.open(ctx+"/viewProductAction_product.do?gid="+id+"&sid="+sid+"");
  }
  