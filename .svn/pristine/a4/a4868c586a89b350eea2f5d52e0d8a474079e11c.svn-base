
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function judge()
{
	if(checkIllegalChar()!=true){
		if(document.form1.goodsname.value.trim()=="")
	    {
	       alert("商品名称不能为空！");
	       document.form1.goodsname.value="";
	       return false;
	    }
	  if(document.form1.remark.value.trim()=="")
	    {
	       alert("商品描述不能为空！");
	       document.form1.remark.value="";
	       return false;
	    }
	    if(document.form1.points.value.trim()=="")
	    {
	       alert("积分数不能为空！");
	       document.form1.points.value="";
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
	if(judge())
	{
		var file=document.getElementById("upload");
		if(document.getElementById("upload").value!=""){
			if(checkImgType(file))
			{
				var authorizedToken=document.getElementById("authorizedToken").value;
				var goodsname=document.getElementById("goodsname").value;
				$.ajax({
					type : "POST",
					url : ctx+"/stageGoodsAction_judge.action",
					data : "goodsname=" + goodsname+"&authorizedToken=" + authorizedToken,
					success : function(result) {
						if (result.data == 'right') {
							document.form1.method="post";
							document.form1.action= ctx+"/stageGoodsAction_save.action";
							document.form1.submit(); 
						} else if (result.data == 'wrong') {
						   alert("该商品已存在，不能重复添加！");
				           return;
						}
					},
					error : function() {
						window.location.href=ctx+"/error/remotelogin.jsp";
		   				//alert('系统忙，请稍后重试');
					}
				});
			
			}
		}
		else
		{
			 alert("请选择展示图片！");
		     return false;
		}
	}
	
}


function checkImgType(ths) {
	var name=ths.value.substr(ths.value.replace("/","\\").lastIndexOf('\\')+1,ths.value.length-1);
	if(parseInt(name.length)<=65)
	{
		if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(ths.value)) {
			alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
			ths.value = "";
			return false;
		}
	}
	else
	{
		alert("文件名超过最大长度60，请修改后再上传！");
		ths.value = "";
		return false;
	}
	return true;
}

 function cancel()
{
	    document.getElementById("sgoodsId").value=""; 
	    document.getElementById("goodsname").value=""; 
	    document.getElementById("points").value=""; 
	    document.getElementById("remark").value="";
	    document.getElementById("upload").value=="";
	    document.getElementById("btn_update").style.display="none";
        document.getElementById("btn_submit").style.display="";
}
function search(){
	document.getElementById("pageNo").value=1; 
	document.form1.method="post";
	document.form1.action= ctx+"/stageGoodsAction_getlist.action";
	document.form1.submit(); 
   }
   
function updateGoods(id,name,points,remark) {
	document.getElementById("sgoodsId").value=id; 
    document.getElementById("goodsname").value=name; 
    document.getElementById("points").value=points; 
    document.getElementById("remark").value=remark; 
    document.getElementById("btn_update").style.display="";
    document.getElementById("btn_submit").style.display="none";
}

function deleteGoods(id) {
	var authorizedToken=document.getElementById("authorizedToken").value;
	$.ajax({
			type : "POST",
			url : ctx+"/stageGoodsAction_delete.action",
			data : "stagegoodsid=" + id +"&authorizedToken=" + authorizedToken,
			success : function(result) {
				if (result.data == 'right') {
					// alert("删除成功");
					window.location.reload(true);
				} else if (result.data == 'wrong') {
				 alert("该商品已被兑换，不能删除！");
		           return;
				}
			},
			error : function() {
				window.location.href=ctx+"/error/remotelogin.jsp";
   				//alert('系统忙，请稍后重试');
			}
		});
}

function updateG(id)
{
	    document.getElementById("sgoodsId").value=id; 
		document.form1.method="post";
		document.form1.action= ctx+"/stageGoodsAction_updateState.action";
		document.form1.submit(); 
}

function update()
{
	if(judge())
	{
		var file=document.getElementById("upload");
		if(document.getElementById("upload").value!=""){
			if(checkImgType(file))
			{
				document.form1.method="post";
				document.form1.action= ctx+"/stageGoodsAction_update.action";
				document.form1.submit(); 
			}
		}
		else
		{
			document.form1.method="post";
			document.form1.action= ctx+"/stageGoodsAction_update.action";
			document.form1.submit(); 
		}
	}
}
