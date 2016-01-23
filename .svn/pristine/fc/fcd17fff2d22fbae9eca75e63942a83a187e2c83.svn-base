
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/end_home/login.css">
<title>后台登录</title>

</head>
<body>
	<div>
	<p><b>后台登录</b></p>
	</div>
	<div id="msg">
		<span>${msg}</span>
	</div>
	<form action="endloginAction.action" method="post">
		<table id="mytable">
			<tr>
				<td>
					<span>用户名：</span>
				</td>
				<td>
					<input type="text" name="account" value="${account}"></input>
				</td>
			</tr>
			<tr>
				<td>
					<span>密   码：</span>
				</td>
				<td>
					<input type="password" name="password"></input>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="登录"></input>
				</td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>