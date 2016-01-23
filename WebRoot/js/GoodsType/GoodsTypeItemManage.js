
function judgeNull()
  {
			if(checkIllegalChar()!=true){
				if(document.form1.itemname.value.trim()=="")
			     {
			        alert("属性名称不能为空！");
			        document.form1.itemname.value="";
			        return false;
			     }
			     if(document.form1.remark.value.trim()=="")
			     {
			        alert("备注不能为空！");
			        document.form1.remark.value="";
			        return false;
			     }
			} else
			{
				alert("文本框中不能包含下列任何字符： \" \' &amp;");
		        return false;
			}   
     return true;
  }

function add()
{
    if(judgeNull())
     {
    	var authorizedToken=document.getElementById("authorizedToken").value;
    	var itemname=document.form1.itemname.value;
    	var gtypeId=document.form1.gtypeId.value;
    	  $.ajax({
    		type : "POST",
    		url : ctx+"/goodsTypeItemAction_checkname.action",
    		data : "itemname=" + itemname + "&gtypeId=" + gtypeId
    		+"&authorizedToken=" + authorizedToken,
    		success : function(result) {
    			if (result.data == 'right') {
    				document.form1.action= ctx+"/goodsTypeItemAction_add.action"; 
    	            document.form1.submit();
    			} 
    			else if (result.data == 'wrong') {
    				alert('该类别商品属性已存在！');
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
    if(judgeNull())
     {
    	var itemname=document.form1.itemname.value;
    	var gtypeId=document.form1.gtypeId.value;
    	var gtItemId=document.getElementById("gtItemId").value;
    	var authorizedToken=document.getElementById("authorizedToken").value;
    	  $.ajax({
    		type : "POST",
    		url : ctx+"/goodsTypeItemAction_checkupdate.action",
    		data : "itemname=" + itemname + "&gtypeId=" + gtypeId+ "&gtItemId=" + gtItemId
    		+"&authorizedToken=" + authorizedToken,
    		success : function(result) {
    			if (result.data == 'right') {
    				document.form1.action= ctx+"/goodsTypeItemAction_update.action"; 
    	    	     document.form1.submit(); 
    			}
    	    	     else if (result.data == 'wrong') {
    	    				alert('该类别商品属性已存在！');
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

 function search()
  {
	 document.getElementById("pageNo").value=1;
     document.form1.action= ctx+"/goodsTypeItemAction_list.action"; 
     document.form1.submit();  
  }

function updateItem(id,name,remark)
{
    document.getElementById("gtItemId").value=id;
    document.getElementById("remark").value=remark;
    document.getElementById("itemname").value=name;
    document.getElementById("remark").value=remark;
    document.getElementById("btn_update").style.display="";
    document.getElementById("btn_submit").style.display="none";
}

function deleteItem(id)
{
	var authorizedToken=document.getElementById("authorizedToken").value;
	 $.ajax({
			type : "POST",
			url : ctx+"/goodsTypeItemAction_delete.action",
			data : "gtItemId=" + id+"&authorizedToken=" + authorizedToken,
			success : function(result) {
				if (result.data == 'right') {
					//alert('删除成功！');
					window.location.reload(true);
				} 
				else if (result.data == 'wrong') {
					alert('该类别属性已被商品引用，请先删除商品引用！');
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
   document.getElementById("itemname").value="";
   document.getElementById("remark").value="";
   document.getElementById("btn_update").style.display="none";
   document.getElementById("btn_submit").style.display="";
}