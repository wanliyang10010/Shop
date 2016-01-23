
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function add()
  {
	 var file=document.getElementById("upload");
     if(document.getElementById("upload").value!="" )
    {
    	 if(checkImgType(file))
 		{
	       document.form1.method="post";
		   document.form1.action= ctx+"/goodsPictureAction_save.action"; 
	       document.form1.submit(); 
 		}
    }
    else
    {
        alert("请选择要上传的文件");
        return false;
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

function update(id, type) {
	var authorizedToken=document.getElementById("authorizedToken").value;
	if (type == "1") {
		$.ajax({
			type : "POST",
			url : ctx+"/goodsPictureAction_updateGoods.action",
			data : "fileid=" + id+"&authorizedToken=" + authorizedToken,
			success : function(result) {
				if (result.data == 'right') {
					//alert("设置封面成功！");
					window.location.reload(true);
				} else if (result.data == 'wrong') {
					alert("设置封面失败，请稍后重试！");
			           return;
				}
			},
			error : function() {
				alert('系统忙，请稍后重试');
			}
		});
	} else {
		alert("封面必须为预览项，请先设为预览！");
		return;
	}

}

function updatePicture(id) {
	var authorizedToken=document.getElementById("authorizedToken").value;
	$.ajax({
		type : "POST",
		url : ctx+"/goodsPictureAction_updatePicture.action",
		data : "fileid=" + id+"&authorizedToken=" + authorizedToken,
		success : function(result) {
			if (result.data == 'right') {
				//alert("预览状态更改成功！");
				window.location.reload(true);
			} else if (result.data == 'wrong') {
				alert("预览状态更改成功，请稍后重试！");
		           return;
			}
		},
		error : function() {
			alert('系统忙，请稍后重试');
		}
	});
}

function deletefile(id) {
	var authorizedToken=document.getElementById("authorizedToken").value;
	$.ajax({
		type : "POST",
		url : ctx+"/goodsPictureAction_delete.action",
		data : "fileid=" + id +"&authorizedToken=" + authorizedToken,
		success : function(result) {
			if (result.data == 'right') {
				//alert("图片删除成功！");
				window.location.reload(true);
			} else if (result.data == 'wrong') {
				alert("图片删除失败，请稍后重试！");
		           return;
			}
		},
		error : function() {
			alert('系统忙，请稍后重试');
		}
	});
}
