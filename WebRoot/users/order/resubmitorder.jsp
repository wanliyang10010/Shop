<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>系统提示：重复提交操作</title>
    <%@ include file="/common/top-head.jspf" %>
  </head>
  
  <body>
  	<div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf" %>
	</div>
  	<br>
  	<h3>系统检测到您正在进行重复提交操作!</h3>
  	<a href="${ctx}/orderAction!haveBuyGoods.action" ><h3>查看已提交的订单</h3></a>
  	<a href="${ctx}/cartAction!queryCarts.action" ><h3>返回购物车</h3></a>
  </body>
</html>
