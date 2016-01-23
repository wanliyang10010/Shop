
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function judgeNull()
  {
	if(checkIllegalChar()!=true){
		  if(document.form1.itemtype.value=="请选择")
		     {
		        alert("请选择属性类型！");
		        return false;
		     }
		     if(document.form1.itemid.value=="请选择")
		     {
		        alert("请选择商品属性！");
		        return false;
		     }
		     if(document.form1.itemvalue.value.trim()=="")
		     {
		        alert("属性描述不能为空！");
		        document.form1.itemvalue.value="";
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
    	var itemtype=document.form1.itemtype.value;
    	var itemid=document.form1.itemid.value;
    	var goodsId=document.form1.goodsId.value;
    	var itemvalue=document.form1.itemvalue.value;
    	  $.ajax({
    		type : "POST",
    		url : ctx+"/goodsDetialAction_add.action",
    		data : "itemtype=" + itemtype + "&itemid=" + itemid
    		+ "&goodsId=" + goodsId+ "&itemvalue=" + itemvalue
    		+"&authorizedToken=" + authorizedToken,
    		success : function(result) {
    			if (result.data == 'right') {
    				//alert('添加成功！');
    				window.location.reload(true);
    			} 
    			else if (result.data == 'wrong') {
    				alert('该描述信息已添加已存在！');
    				return false;
    			} 
    			else if (result.data == 'full') {
    				alert('该商品的商品子项信息已满两个，不能再添加！');
    				return false;
    			} 
    		},
    		error : function() {
    			alert('系统忙，请稍后重试');
    		}
    	}); 
     }
}


function update()
{
    if(judgeNull())
     {
        document.form1.action= ctx+"/goodsDetialAction_update.action"; 
        document.form1.submit(); 
     }
}

 function search()
  {
	 document.getElementById("pageNo").value=1;
     document.form1.action= ctx+"/goodsDetialAction_list.action"; 
     document.form1.submit();  
  }

function updateItem(id,name,value,type)
{
    document.getElementById("gdetialId").value=id;
    document.getElementById("btn_update").style.display="";
    document.getElementById("btn_submit").style.display="none";
    tt = document.getElementById("itemtype");
	tt1 = document.getElementById("itemid");
	tt2 = document.getElementById("itemvalue");
	tt.value =type;
	tt.disabled=true;
	tt1.value = name;
	tt1.disabled=true;
	tt2.value=value;
}
function openTypeItem(id)
{
	window.open(ctx+"/goodsTypeAction_typeItem.action?gtypeId="+id+"");
	}

function goTypeItem(id)
{
	window.location.href=ctx+"/goodsTypeAction_typeItem.action?gtypeId="+id+"";
	}

function deleteItem(id)
{
      document.getElementById("gdetialId").value=id;
      document.form1.action= ctx+"/goodsDetialAction_delete.action"; 
      document.form1.submit(); 
}

function cancel()
{
   document.getElementById("btn_update").style.display="none";
   document.getElementById("btn_submit").style.display="";
   tt = document.getElementById("itemtype");
	tt1 = document.getElementById("itemid");
	tt2 = document.getElementById("itemvalue");
	tt.value ="请选择";
	tt.disabled=false;
	tt1.value ="请选择";
	tt1.disabled=false;
	tt2.value="";
}