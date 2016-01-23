
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
<title>login</title>
</head>
<body>
<h1>前台</h1><br/>
	<form action="login" method="post">
	
	用户名：<input type="text" name="account"></input><br />
	密   码：<input type="text" name="password"></input><br />
	
	<input type="submit" value="提交"></input>
	<!-- 
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
	 -->
	</form>
	
	
</body>
</html>