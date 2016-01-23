
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function judgeNull()
  {
	var count=document.form1.listsize.value;
	if(count=="2")
    {
		if(document.form1.itemtype0.value=="请选择")
	     {
	        alert("请选择属性类型！");
	        return false;
	     }
		if(document.form1.itemtype1.value=="请选择")
	     {
	        alert("请选择属性类型！");
	        return false;
	     }
    }
	else if(count=="1")
    {
		if(document.form1.itemtype0.value=="请选择")
	     {
	        alert("请选择属性类型！");
	        return false;
	     }
    }
	else{
		alert("该商品不需要添加库存明细！");
		return false;
	}	
     if(document.form1.amount.value.trim()=="")
     {
        alert("库存不能为空！");
        document.form1.itemvalue.value="";
        return false;
     }
     return true;
  }

function add()
{
    if(judgeNull())
     {
    	var authorizedToken=document.getElementById("authorizedToken").value;
    	var count=document.form1.listsize.value;
    	var amount=document.form1.amount.value;
    	var goodsId=document.form1.goodsId.value;
    	var itemtype="";
    	if(count=="2")
    	{
    		itemtype=document.form1.itemtype0.value+","+document.form1.itemtype1.value;
    	}
    	else
    	{
    		itemtype=document.form1.itemtype0.value;
    	}
    	  $.ajax({
    		type : "POST",
    		url : ctx+"/goodsStockAction_AddStock.action",
    		data : "goodstype=" + itemtype + "&amount=" + amount
    		+ "&goodsId=" + goodsId +"&authorizedToken=" + authorizedToken,
    		success : function(result) {
    			if (result.data == 'right') {
    				//alert('添加成功！');
    				window.location.reload(true);
    			} 
    			else if (result.data == 'wrong') {
    				alert('该类型库存信息已添加！');
    				return false;
    			} 
    		},
    		error : function() {
    			alert('系统忙，请稍后重试');
    			//return false;
    		}
    	}); 
     }
}

function update()
{
	 if(document.form1.amount.value.trim()=="")
     {
        alert("库存不能为空！");
        document.form1.itemvalue.value="";
        return;
     }
	 else
	 {
		 var authorizedToken=document.getElementById("authorizedToken").value;
		 var amount=document.form1.amount.value;
		 var goodstockId=document.form1.goodstockId.value;
		 $.ajax({
	    		type : "POST",
	    		url : ctx+"/goodsStockAction_updateStock.action",
	    		data : "amount=" + amount+ "&gstockid=" + goodstockId
	    		+"&authorizedToken=" + authorizedToken,
	    		success : function(result) {
	    			if (result.data == 'right') {
	    				//alert('修改成功！');
	    				window.location.reload(true);
	    			} 
	    			else if (result.data == 'wrong') {
	    				alert('修改失败！');
	    				return false;
	    			} 
	    		},
	    		error : function() {
	    			alert('系统忙，请稍后重试');
	    		}
	    	}); 
	 }

}

function updateItem(id,name,value)
{
    document.getElementById("goodstockId").value=id;
    document.getElementById("amount").value=value;
    document.getElementById("itemname").innerHTML =name;
    document.getElementById("btn_update").style.display="";
    document.getElementById("btn_submit").style.display="none";
    document.getElementById("tr_update").style.display="";
    document.getElementById("tr_add").style.display="none";
}

function deleteItem(id)
{
	var authorizedToken=document.getElementById("authorizedToken").value;
	 $.ajax({
 		type : "POST",
 		url : ctx+"/goodsStockAction_deleteStock.action",
 		data : "gstockid=" + id+"&authorizedToken=" + authorizedToken,
 		success : function(result) {
 			if (result.data == 'right') {
 				//alert('删除成功！');
 				window.location.reload(true);
 			} 
 			else if (result.data == 'wrong') {
 				alert('删除失败！');
 				return false;
 			} 
 		},
 		error : function() {
 			alert('系统忙，请稍后重试');
 		}
 	}); 
}

function cancel()
{
	document.getElementById("goodstockId").value="";
    document.getElementById("amount").value="";
    document.getElementById("itemname").innerHTML ="";
    document.getElementById("btn_update").style.display="none";
    document.getElementById("btn_submit").style.display="";
    document.getElementById("tr_update").style.display="none";
    document.getElementById("tr_add").style.display="";
    document.getElementById("itemtype0").value="请选择";
    document.getElementById("itemtype1").value="请选择";  
}
function item(goodsId,typeId)
{
	window.location.href=ctx+"/goodsDetialAction_listitem.action?goodId="+goodsId+"&&typeId="+typeId+"";
}