
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function judgeNull()
  {
	if(checkIllegalChar()!=true){
		     if(document.form1.typename.value.trim()=="")
		     {
		        alert("商品二级类别不能为空！");
		        document.form1.typename.value="";
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
    	var typename=document.form1.typename.value;
    	var shopId=document.form1.shopId.value;
    	  $.ajax({
    		type : "POST",
    		url : ctx+"/goodsTypeAction_checkname.action",
    		data : "typename=" + typename + "&shopId=" + shopId
    		+"&authorizedToken=" + authorizedToken,
    		success : function(result) {
    			if (result.data == 'right') {
    				document.form1.action= ctx+"/goodsTypeAction_add.action"; 
    	            document.form1.submit();
    			} 
    			else if (result.data == 'wrong') {
    				alert('该二级类别已存在！');
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
    	var authorizedToken=document.getElementById("authorizedToken").value;
    	var typename=document.form1.typename.value;
    	var shopId=document.form1.shopId.value;
    	var remark=document.form1.remark.value;
    	var gtypeId= document.getElementById("gtypeId").value;
    	  $.ajax({
    		type : "POST",
    		url : ctx+"/goodsTypeAction_checkupdate.action",
    		data : "typename=" + typename + "&shopId=" + shopId + "&remark=" + remark
    		+ "&gtypeId=" + gtypeId+"&authorizedToken=" + authorizedToken,
    		success : function(result) {
    			if (result.data == 'right') {
    				document.form1.action= ctx+"/goodsTypeAction_update.action"; 
    	    	     document.form1.submit(); 
    			} 
    			else if (result.data == 'wrong') {
    				alert('该二级类别已存在！');
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
     document.form1.action= ctx+"/goodsTypeAction_list.action"; 
     document.form1.submit();  
  }

function updateType(id,name,remark)
{
    document.getElementById("gtypeId").value=id;
    document.getElementById("remark").value=remark;
    document.getElementById("typename").value=name;
    document.getElementById("remark").value=remark;
    document.getElementById("btn_update").style.display="";
    document.getElementById("btn_submit").style.display="none";
}

function deletetype(id)
{
	var authorizedToken=document.getElementById("authorizedToken").value;
	  $.ajax({
		type : "POST",
		url : ctx+"/goodsTypeAction_delete.action",
		data : "gtypeId=" + id+"&authorizedToken=" + authorizedToken,
		success : function(result) {
			if (result.data == 'right') {
				//alert('删除成功！');
				window.location.reload(true);
			} 
			else if (result.data == 'wrong') {
				alert('请在删除该二级类别下商品后，再删除该二级类别！');
				return false;
			} 
		},
		error : function() {
			alert('系统忙，请稍后重试');
		}
	});    
}

function typeitem(id)
{
      window.open(ctx+"/goodsTypeAction_typeItem.action?gtypeId="+id+"");
}

function cancel()
{
   document.getElementById("typename").value="";
   document.getElementById("remark").value="";
   document.getElementById("btn_update").style.display="none";
   document.getElementById("btn_submit").style.display="";
}