<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<s:token />
<title>邮箱注册</title>
<%@ include file="/common/top-head.jspf"%>
<link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css" />
<script type="text/javascript" src="${ctx}/js/user/MailRegedit.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
		<center>
		<div id="templatemo_main">
			<form name="form1" action="" id="form1" autocomplete="off">
			<input type="password"  autocomplete="off" style="display:none"/>
			<input type="text"  autocomplete="off" style="display:none"/>
				<h1>用户注册-邮箱</h1>
				<table width="500" align="center" oncontextmenu=return(false)>
				<tr height="30">
				<td colspan="2" align="right">
				<label for="textfield">您还可以通过：</label> <a
						href="${ctx}/user/PhoneRegedit.jsp">手机注册</a> <a
						href="${ctx}/user/NormalRegedit.jsp">用户名注册</a>
						</td>
				</tr>
					<tr height="30">
						<td align="right" width="30%"><label for="textfield">邮箱地址：</label></td>
						<td align="left"><input type="text" name="username" maxlength="35"
						id="username" value="${param.username}" 
							size="35"> <font color="red" id="font1">${msg}</font></td>
					</tr>
					</table>
				<div id="dv_random">
					<table width="500" align="center" oncontextmenu=return(false)>
					<tr height="30">
						<td align="right" width="30%"><label for="textfield">验证码：</label></td>
						<td align="left"><input name="random" id="random" maxlength="6"
							type="text">
							<input type="button" id="btn_send" value="获取" onclick="checkMail();" />
						</td>
					</tr>
					<tr height="30" id="dv_check">
						<td align="center" colspan="4"><input type="button"
							value="验证" id="bt_check" onclick="check();" /> <input
							type="button" value="取消" onclick="cancel();" /></td>
					</tr>
				</table>
				</div>
				<div id="dv_add" style="display: none">
					<table width="500" align="center" oncontextmenu=return(false)>
						<tr>
							<td align="right" width="30%"><label for="textfield">密 码：</label></td>
							<td align="left"><input type="password" name="password" maxlength="20" placeholder="请入六位以上用户密码"
								id="password" onkeyup="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
								oninput="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "></td>
						</tr>
						<tr>
							<td align="right"><label for="textfield">密码确认：</label></td>
							<td align="left"><input type="password" name="password2" maxlength="20" placeholder="请入六位以上用户密码"
								id="password2"  onkeyup="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
								oninput="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "></td>
						</tr>
						<tr>
							<td align="center" colspan="4"><input type="button"
								name="btnsubmit" id="btnsubmit" value="注册" onclick="adduser();" />
								&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" name="btncancel"
								id="btncancel" value="取消" onclick="cancel();" /></td>
						</tr>
					</table>
				</div>
			</form>
</div>
		</center>
</body>
</html>
