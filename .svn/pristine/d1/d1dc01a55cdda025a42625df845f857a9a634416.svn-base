<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<s:token />
<title>用户注册</title>
<%@ include file="/common/top-head.jspf"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/page.css" />
<script type="text/javascript" src="${ctx}/js/user/NormalRegedit.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
	<center>
		<div id="templatemo_main">
			<form name="form1" id="form1" autocomplete="off" autocorrect="off" autocapitalize="off">
				<input type="password"  autocomplete="off" style="display:none"/>
				<input type="text"  autocomplete="off" style="display:none"/>
				<h1>用户注册</h1>
				<table width="550" align="center" oncontextmenu=return(false)>
				<tr height="30">
				<td colspan="2" align="right">
				<label for="textfield">您还可以通过：</label> <a
						href="${ctx}/user/PhoneRegedit.jsp">手机号码注册</a> <a
						href="${ctx}/user/MailRegedit.jsp">邮箱注册</a>
						</td>
				</tr>
				<tr height="30">
				<td colspan="2" align="center">
				  注册须知：1、用户名和密码仅限字母和数字；2、用户名和密码区分字母大小写，请认证核对。
						</td>
				</tr>
					<tr>
						<td align="right" width="30%"><label for="textfield">*用户名：</label></td>
						<td align="left"><input type="text" name="username" maxlength="20" autocomplete="off"
							id="username" value="${param.username}" onclick="setbutton();" onblur="checkname();" 
							  onkeyup="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
							   oninput="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "/>
						<font color="red" id="font1">${msg}</font>
						</td>
					</tr>
					<tr>
						<td align="right"><label for="textfield">*密 码：</label></td>
						<td align="left"><input type="password" name="password" maxlength="20"  autocomplete="off" placeholder="请入六位以上用户密码"
							id="password"  onkeyup="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
							oninput="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "></td>
					</tr>
					<tr>
						<td align="right"><label for="textfield">*确认密码：</label></td>
						<td align="left"><input type="password" name="password2" maxlength="20" placeholder="请入六位以上用户密码"
							id="password2"  onkeyup="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
							oninput="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input id="btn_submit"
							name="btn_submit" type="button" onclick="adduser();" value="注册" />
							&nbsp;&nbsp;&nbsp;&nbsp; <input id="btn_cancel" type="button"
							onclick="cancel()" value="取消" /></td>
					</tr>

				</table>
				<script type="text/javascript">
					var msg = '${msg}';
					if (msg != "该用户名可用") {
						document.getElementById("btn_submit").disabled = "true";
					}
				</script>
			</form>
		</div>
	</center>
</body>
</html>