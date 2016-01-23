<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付商品</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/haveBorder.css">
<script type="text/javascript" src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/haveBuyGoods/payNow.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			&nbsp; &nbsp;&nbsp;<h3>支付商品</h3>
			<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			<s:if test="#request.orderid!=''">
				<table width="900px" align="center">
					<tr style="background:#BFDBEB">
						<td align="center" width=10%>订单号</td>
						<td align="center" width=15%>购买人</td>
						<td align="center" width=20%>购买时间</td>
						<td align="center" width=20%>店铺名称</td>
						<td align="center" width=15%>订单金额（元）</td>												
						<td align="center" width=20%>备注</td>					
					</tr>
					<tr>
						<td align="center">${param.orderid}</td>
						<td align="center">${param.username}</td>
						<td align="center">${param.buytime.substring(0,19)}</td>
						<td align="center">${param.shopname}</td>
						<td align="center">${param.ftotal}</td>
						<td align="center">${param.remark}</td>
					</tr>
				</table>
			</s:if>

			<table width="900px" align="center">
				<tr style="display:none">
					<td><input type="text" name="orderid" id="orderid"
						value="${param.orderid}">
					</td>
				</tr>
				<tr style="display:none">
					<td><input type="text" name="ftotal" id="ftotal"
						value="${param.ftotal}">
					</td>
				</tr>
				<tr style="display:none">
					<td><input type="text" name="redirectUrl" id="redirectUrl"
						value="${param.redirectUrl}">
					</td>
				</tr>			
				<tr>
					<td align="center" style="height:400px">
						<h1>银行支付信息</h1></td>
				</tr>
				<tr>
					<td align="center">
						<button id="btn_submit" type="button" style="width:100px;"
							onclick="paymoney();">完成支付</button>
					</td>
				</tr>
			</table>
		</form>
	</center>
	</div>
</body>
</html>
