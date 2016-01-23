<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户配置角色完成</title>
<script type="text/javascript" src="<%=basePath%>js/jQuery/jquery-1.9.0.js"></script>

<script type="text/javascript" src="<%=basePath%>js/security/user/mapOK.js"></script>
<script type="text/javascript" src="<%=basePath%>js/alert.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/security/user/mapOK.css">


</head>
<body>
	<div id="fanhui">
	<!-- 
	<form  action="" id="fanhuiform">
		<input type="button" value="返回主页" id="fanhuibutton" />
	</form>
	  -->
	<p><b>用户配置角色完成</b></p>
	
</div>
</body>
</html>