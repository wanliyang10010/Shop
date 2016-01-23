<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>访问错误--页面跳转中...</title>
<meta http-equiv=content-type content="text/html; charset=utf-8">
<link href="${ctx }/css/error/style.css" type="text/css" rel="stylesheet">

<c:choose>
	<c:when
		test="${sessionScope.userinfo==null||sessionScope.userinfo.role==0}">
		<meta http-equiv="refresh"
			content="5;url=${ctx}/viewProductAction_MyShop.do">
	</c:when>
	<c:when
		test="${sessionScope.userinfo!=null&&sessionScope.userinfo.role==2}">
		<meta http-equiv="refresh" content="5;url=${ctx}/AdminStage/index.jsp">
	</c:when>
	<c:when
		test="${sessionScope.userinfo!=null&&sessionScope.userinfo.role==3}">
		<meta http-equiv="refresh" content="5;url=${ctx}/backstage/index.jsp">
	</c:when>
	<c:otherwise>
		<meta http-equiv="refresh" content="5;url=${ctx}/login.jsp">
	</c:otherwise>
</c:choose>
</head>
<body>
	<div id=container>
		<img height=312 src="${ctx}/css/error/404.gif" width=512>
	</div>
	<div id=maincolumn>
		<div style="font-size: 20px;">您访问的网页暂时无法显示，我们将在5秒后为您跳转到相关页面！</div>
	</div>
	<div>copyright © 2014 - 2016 创业平台 all rights reserved.</div>

</body>
</html>
