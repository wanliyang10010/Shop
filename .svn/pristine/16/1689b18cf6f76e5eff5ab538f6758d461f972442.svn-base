<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>店铺查看</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/haveBorder.css">
<script type="text/javascript"
	src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${ctx}/js/shopManage/viewShop.js"></script>

</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			&nbsp; &nbsp;&nbsp;<h3>店铺查看</h3>
			<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			<s:if test="#request.viewShopList!= null && #request.viewShopList.size()>0">
			<table width="900px" align="center">
				<tr id="trMain" style="background:#BFDBEB">	
					<td align="center">申请人</td>
					<td align="center">注册时间</td>
					<td align="center">店铺名称</td>
					<td align="center">店铺类别</td>
					<td align="center">商品类别</td>
					<td align="center">店铺平均得分</td>
					<td align="center">保证金</td>
					<td align="center">保证金状态</td>
					<td align="center">店铺状态</td>
				</tr>
				<s:iterator value="#request.viewShopList" status="s">
				<tr id="tr${s.count}">					
				<td align="center">${userinfo.username}</td>
				<td align="center">${regeditdate.substring(0, 10)}</td>
				<td align="center">${shopname}</td>
				<td align="center">${shopcategory}</td>
				<td align="center">${productcategory}</td>
				<td align="center">${point}</td>
				<td align="center">${margin}</td>
				<td align="center">
				<s:if test="%{marginstate==\"0\"}">未交保证金</s:if> 
				<s:if test="%{marginstate==\"1\"}">保证金正常</s:if> 
				<s:if test="%{marginstate==\"2\"}">保证金冻结</s:if></td>
				<td align="center">
				<s:if test="%{shopstate==\"0\"}">店铺冻结</s:if> 
				<s:if test="%{shopstate==\"1\"}">店铺正常</s:if> 
				</td>									
				</tr>
				</s:iterator>	
			</table>
			</s:if>
			<div id="msg_viewShop">
				<font color="red" id="font1">${msg_viewShop}</font>
			</div>
		</form>
	</center>
	</div>
</body>
</html>
