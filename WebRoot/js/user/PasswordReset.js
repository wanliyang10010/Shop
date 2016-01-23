
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function checkRadio(item) {
	document.form1.item.value = item;
	if (item == "1") {
		document.getElementById("div1").style.display = "";
		document.getElementById("div2").style.display = "none";
		document.getElementById("div3").style.display = "none";
	} else if (item == "2") {
		document.getElementById("div1").style.display = "none";
		document.getElementById("div2").style.display = "";
		document.getElementById("div3").style.display = "none";
	} else if (item == "3") {
		document.getElementById("div1").style.display = "none";
		document.getElementById("div2").style.display = "none";
		document.getElementById("div3").style.display = "";
	}
}

function check(item) {
	if (item == "1") {
		var name = document.form1.name.value.trim();
		var bdate = document.form1.date.value.trim();
		 if(name!=""&&bdate!="")
         {
			 $.ajax({
					type : "POST",
					url : ctx+"/userinfoAction_judgeMessage.do",
					data : "name=" + name + "&bdate=" + bdate,
					success : function(result) {
						if (result.data == 'right') {
							setPWD();
						} else if (result.data == 'wrong') {
							alert("姓名或者生日不正确，请重新输入");
							return;
						}
					},
					error : function() {
						alert("姓名或者生日不正确，请重新输入");
						return;
					}
				});
         }
         else
         {
        	document.form1.name.value="";
     		document.form1.date.value="";
            alert("姓名或者生日不能为空，请重新输入");
            return ;
        }
	} else if (item == "3") {
		if (document.form1.random.value.trim() != "") {
			var random = document.form1.random.value;
			$.ajax({
				type : "POST",
				url : ctx+"/userinfoAction_JudgeRandom.do",
				data : "Random=" + random,
				success : function(result) {
					if (result.data == 'right') {
						setPWD();
					} else if (result.data == 'wrong') {
						alert("验证码输入有误，请查看邮箱确认");
						return;
					}
					else if (result.data == 'null') {
	  				      alert("您尚未获取验证码，请点击发送按钮获取！");
				          return;
	  				}
				},
				error : function() {
					alert('系统忙，请稍后重试');
				}
			});
		} else {
			alert("请输入验证码");
			return;
		}
	} else if (item == "2") {
		if (document.form1.randomp.value.trim() != "") {
			var random = document.form1.randomp.value;
			$.ajax({
				type : "POST",
				url : ctx+"/userinfoAction_JudgeRandom.do",
				data : "Random=" + random,
				success : function(result) {
					if (result.data == 'right') {
						setPWD();
					} else if (result.data == 'wrong') {
						alert("验证码输入有误，请查看手机短信确认");
						return;
					}
					else if (result.data == 'null') {
	  				      alert("您尚未获取验证码，请点击发送按钮获取！");
				          return;
	  				}
				},
				error : function() {
					alert('请先登录在进行操作');
				}
			});

		} else {
			alert("请输入验证码");
			return;
		}
	}
}

function setPWD() {
	document.getElementById("username").readOnly="true";
	document.getElementById("dv_pwd").style.display = "";
	document.getElementById("dv_byway").style.display = "none";
	document.getElementById("div1").style.display = "none";
	document.getElementById("div2").style.display = "none";
	document.getElementById("div3").style.display = "none";
	document.getElementById("dv_check1").style.display = "none";
	document.getElementById("dv_check2").style.display = "none";
	document.getElementById("dv_check3").style.display = "none";
}

function checkname() {
	var ss = document.getElementById("username").value.trim();
	if (ss != "") {
		document.form1.method = "post";
		document.form1.action = ctx+"/userinfoAction_checkPWDuser.do";
		document.form1.submit();
	} else {
		document.getElementById("username").value="";
		alert("用户名不能为空，请重新输入");
		return;
	}

}
function changePWD() {
	if (document.form1.password.value.trim() == "") {
		alert("密码不能为空！");
		return;
	}
	if (document.form1.password2.value.trim() == "") {
		alert("确认密码不能为空！");
		return;
	}
	if(document.form1.password.value.length<6||document.form1.password2.value.length<6)
	 {
		alert("密码和确定密码不能低于六位！");
		return;
	 }
	if (document.form1.password.value == document.form1.password2.value) {
		var userinfoId=document.form1.userinfoId.value;
		 var password=document.form1.password.value;
		  $.ajax({
 	  			type : "POST",
 	  			url : ctx+"/userinfoAction_updatePWD.do",
 	  			data : "userinfoId=" + userinfoId + "&password=" + password,
 	  			success : function(result) {
 	  				if (result.data == 'right') {
 	  				 document.form1.method="post";
 	  				document.form1.action= ctx+"/userinfoAction_clear.action";
 				     document.form1.submit(); 
 	  				} else if (result.data == 'wrong') {
 				           return false;
 	  				}
 	  			},
 	  			error : function() {
 	  				alert('系统忙，请稍后重试');
 	  			}
 	  		});
	} else {
		document.form1.password.value = "";
		document.form1.password2.value = "";
		alert("两次密码输入不一致，请重新输入！");
		return;
	}
}

function cancel() {
	window.location.href = ctx+'/user/PasswordReset.jsp';
}

function cancelCheck() {
	document.getElementById("div1").style.display = "none";
	document.getElementById("div2").style.display = "none";
	document.getElementById("div3").style.display = "none";
}

function send() {
	var userinfoId=document.form1.userinfoId.value;
	 $.ajax({
 			type : "POST",
 			url : ctx+"/userinfoAction_RMail.do",
 			data : "userinfoId=" + userinfoId,
 			success : function(result) {
 				if (result.data == 'right') {
 					alert('验证码已发送，请注意查收！');
 					return;
	  				} else if (result.data == 'wrong') {
	  				       alert('验证码发送失败，请注意重新获取！');
				           return false;
	  				}
 			},
 			error : function() {
 				alert('系统忙，请稍后重试');
 			}
 		});
}


function sendPhone() {
	var userinfoId=document.form1.userinfoId.value;
	 $.ajax({
 			type : "POST",
 			url : ctx+"/userinfoAction_RPhone.do",
 			data : "userinfoId=" + userinfoId,
 			success : function(result) {
 				    document.form1.randomp.value=result.data;
 					alert('验证码已发送，请注意查收！');
 					return;
 			},
 			error : function() {
 				alert('系统忙，请稍后重试');
 			}
 		});
}