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
<title>角色添加成功</title>
<script type="text/javascript" src="<%=basePath%>js/jQuery/jquery-1.9.0.js"></script>

<script type="text/javascript" src="<%=basePath%>js/security/role/create.js"></script>
<!-- 
<script type="text/javascript" src="<%=basePath%>js/alert.js"></script>
 -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/security/role/create.css">

</head>
<body>
	<!-- 
	<div id="fanhui">
		<form  action="" id="fanhuiform">
			<table>
				<tr>
					<td>
						<input type="button" value="继续添加角色" id="continueButton"></input>
					</td>
					 
					<td>
						<input type="button" value="返回主页" id="fanhuibutton" />
					</td>
					
				</tr>
			</table>
		</form>
		
	</div>
	<br/>
	 -->
<p>角色： ${message}添加成功.</p>
</body>
</html>