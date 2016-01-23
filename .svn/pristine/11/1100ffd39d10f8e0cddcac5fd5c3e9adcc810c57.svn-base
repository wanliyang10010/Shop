
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function deletefile(id) {
	document.getElementById("fileid").value = id;
	document.form1.action = ctx + "/disputeFileAction_delete.action";
	document.form1.submit();
}

function judgeNull() {
	  if(checkIllegalChar()!=true){
		  if (document.getElementById("upload").value!= "") {
				alert("您选中的图片尚未上传，请上传后再进行提交操作！");
				return false;
			}
		  if (document.form1.type.value.trim() == "请选择") {
				alert("请选择申诉类型！");
				document.form1.dtype.value= "";
				return false;
			}
			if (document.form1.dtype.value.trim() == "") {
				alert("请填写申诉类型！");
				document.form1.dtype.value= "";
				$("#dtype").css("border-color", "red");
				return false;
			}
			if (document.form1.reason.value.trim() == "") {
				alert("请填写申诉原因！");
				document.form1.reason.value = "";
				return false;
			}
		} else
		{
			alert("文本框中不能包含下列任何字符： \" \' &amp;");
	        return false;
		}
	
	return true;
}

function add() {
	
	if (judgeNull()) {
		document.form1.action = ctx + "/disputeAction_add.action";
		document.form1.submit();
	}
}

function up() {
	var file=document.getElementById("upload");
	var count = document.getElementById("filecount");
	if (document.getElementById("upload").value != "") {
		if(count.value==""||count.value<5)
		{
			if(checkImgType(file))
			{
				document.form1.method = "post";
				document.form1.action = ctx + "/disputeFileAction_save.action";
				document.form1.enctype = "multipart/form-data";
				document.form1.submit();
			}
		}
		else
		{
			alert("您的申诉图片已达到上限五张！");
			file.value="";
			return false;
		}
		
	} else {
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

function cancel() {
    document.form1.upload.value = "";
	document.form1.dtype.value = "";
	document.form1.type.value = "请选择";
	document.form1.filecontent.value = "";
	document.form1.reason.value = "";
	document.form1.action = ctx + "/disputeFileAction_cancelfile.action";
	document.form1.submit();
}

function dispute(id) {
	// alert(id);
	window.open(ctx + "/disputeAction_disputeinfo.action?ordersonid=" + id+ "");
}
function viewdispute(id) {
	window.open(ctx + "/disputeAction_viewdispute.action?ordersonid=" + id+ "");
}
function typechange(val){
    //alert(val);
	if(val=="其他")
    {
    	document.form1.dtype.value = "";
    	document.getElementById("dtype").style.display="";
    }
    else
    {
    	document.form1.dtype.value = val;
    	document.getElementById("dtype").style.display="none";
    }
 }
$(function() {
	$("#upload").change(
					function() {						
						var $file = $(this);
						var fileObj = $file[0];
						var windowURL = window.URL || window.webkitURL;
						var dataURL;
						var $img = $("#viewuserpicture");

						if (fileObj && fileObj.files && fileObj.files[0]) {
							dataURL = windowURL.createObjectURL(fileObj.files[0]);
							//允许上传的图片格式  
							var newPreview = document.getElementById("upload").value;
							var regext = /\.jpg$|\.gif$|\.jpeg$|\.png$|\.bmp$/gi;
							if (!regext.test(newPreview)) {
								alert("对不起，系统仅支持标准格式的照片，请您调整格式后重新上传！");
								
							 $(fileObj).after($(fileObj).clone($(fileObj)));
						     $(fileObj).remove();
						     $("#tr_userpicture").hide();
						     return false;
							}														         
							$img.attr("src", dataURL);
							$("#tr_userpicture").show();
							
						} else {
							$("#tr_userpicture").hide();
						}
					});
});