
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function open(url) {
	alert("file");
}

function update(id, type) {
	// alert(type);
	var authorizedToken=document.getElementById("authorizedToken").value;
	if (type == "1") {
		$.ajax({
			type : "POST",
			url : ctx+"/goodsPictureAction_updateGoodsAdmin.action",
			data : "fileid=" + id+"&authorizedToken=" + authorizedToken,
			success : function(result) {
				if (result.data == 'right') {
					//alert("封面状态修改成功！");
					window.location.reload(true);
				} else if (result.data == 'wrong') {
					alert("封面状态修改失败，请稍后重试！");
			           return;
				}
			},
			error : function() {
				window.location.href=ctx+"/error/remotelogin.jsp";
   				//alert('系统忙，请稍后重试');
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
		url : ctx+"/goodsPictureAction_updatePictureAdmin.action",
		data : "fileid=" + id+"&authorizedToken=" + authorizedToken,
		success : function(result) {
			if (result.data == 'right') {
				//alert("设置预览成功！");
				window.location.reload(true);
			} else if (result.data == 'wrong') {
				alert("设置预览失败，请稍后重试！");
		           return;
			}
		},
		error : function() {
			window.location.href=ctx+"/error/remotelogin.jsp";
				//alert('系统忙，请稍后重试');
		}
	});
}

function deletefile(id) {
	var authorizedToken=document.getElementById("authorizedToken").value;
	$.ajax({
		type : "POST",
		url : ctx+"/goodsPictureAction_deleteAdmin.action",
		data : "fileid=" + id+"&authorizedToken=" + authorizedToken,
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
			window.location.href=ctx+"/error/remotelogin.jsp";
				//alert('系统忙，请稍后重试');
		}
	});
}