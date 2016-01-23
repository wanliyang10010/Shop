<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jspf"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>客服登录</title>
<link href="${ctx}/AdminStage/css/style.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
<div class="login">
	<h2>客服登录</h2>
	<div class="login-top">
		<form action="${ctx}/adminUserAction_loginAdmin.do" method="post">
		<input type="text" value="用户帐号" id="username" name="username" onfocus="this.value = '';"
		 onblur="if (this.value == '') {this.value = '用户帐号';}">
			<input type="password" value="password" id="password" name="password" 
			onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';}">
	    <div class="forgot">
	    	<input type="submit" value="登录" >
	    </div>
	    </form>
	</div>
	<script type="text/javascript">
	      var ss='${msg}';
	      if(ss!="")
	      { 
	         alert(ss);   
	      }
	      </script>
</div>	
</body>
</html>