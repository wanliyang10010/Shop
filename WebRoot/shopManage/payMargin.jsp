<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付保证金</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/haveBorder.css">
<script type="text/javascript"
	src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/shopManage/payMargin.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			&nbsp; &nbsp;&nbsp;<h3>支付保证金</h3>
			<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			<s:if test="#request.shopId!=''">
				<table width="900px" align="center">
					<tr style="background:#BFDBEB">
						<td align="center" width=10%>申请人</td>
						<td align="center" width=14%>注册时间</td>
						<td align="center" width=12%>店铺名称</td>
						<td align="center" width=12%>店铺类别</td>
						<td align="center" width=14%>商品类别</td>
						<td align="center" width=10%>保证金（元）</td>
						<td align="center" width=10%>本次交费（元）</td>
						<td align="center" width=18%>备注</td>
					</tr>
					<tr>
						<td align="center">${param.userId}</td>
						<td align="center">${param.regeditdate}</td>
						<td align="center">${param.shopname}</td>
						<td align="center">${param.shopcategory}</td>
						<td align="center">${param.productcategory}</td>
						<td align="center">${param.margin}</td>
						<td align="center">${param.money}</td>
						<td align="center">${param.remark}</td>
					</tr>
				</table>
			</s:if>

			<table width="900px" align="center">
				<tr style="display:none">
					<td><input type="text" name="shopId" id="shopId"
						value=${param.shopid}>
					</td>
				</tr>
				<tr style="display:none">
					<td><input type="text" name="money" id="money" value=${param.money}>
					</td>
				</tr>
				<tr style="display:none">
					<td><input type="text" name="remark" id="remark"
						value=${param.remark}></td>
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
