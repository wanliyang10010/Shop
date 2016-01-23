<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>店铺评分查看</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/haveBorder.css">
<script type="text/javascript"
	src="${ctx}/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			 &nbsp; &nbsp;&nbsp;<h3>店铺评分查看</h3>
			 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			  <input type="hidden"  name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	   		 <input type="hidden"  name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
				 <s:if test="#request.page!= null&&#request.page.getTotalItems()>0"> 
				 
				<table width="800px" align="center">
					<tr style="background:#BFDBEB;">
						<td align="center" width=5%>序号</td>
						<td align="center" width=10%>评价人</td>
						<td align="center" width=21%>评价时间</td>
						<td align="center" width=9%>订单号</td>
						<td align="center" width=15%>商品名称</td>
						<td align="center" width=10%>宝贝与描述相符分值（分）</td>
						<td align="center" width=10%>卖家的服务态度分值（分）</td>
						<td align="center" width=10%>卖家发货的速度分值（分）</td>
						<td align="center" width=10%>店铺评分（分）</td>
					</tr>
					<s:iterator value="#request.page" status="s">	
						<tr>
							<td align="center">${s.count+(page.pageNo-1)*page.pageSize}</td>
							<td align="center">${userinfo.username}</td>
							<td align="center">${evaluationTime}</td>
							<td align="center">${orderSon.order.orderid}</td>
							<td align="center">${goods.goodsname}</td>
							<td align="center">${describepoint}</td>
							<td align="center">${servicepoint}</td>
							<td align="center">${speedpoint}</td>
							<td align="center">${shoppoint}</td>
						</tr>
					</s:iterator>
					<tr><td colspan="9">
				  <%@ include file="/common/shopPaging.jspf" %>
				  </td></tr>
				</table>
				<span style="color:red;font-size:14px;font-weight: bold;display:-moz-inline-box;display:inline-block;width:800px;margin-top:15px">
			（说明：店铺评分是根据各个买家对店铺打分的加权平均值，不是各个买家打分的简单累加，</br>店铺评分分值越高，代表店铺整体越优秀！）</span>
			</s:if>
			<div id="msg_shopEvaluationList">
				<font color="red" id="font1">${msg_shopEvaluationList}</font>
			</div>
		</form>
	</center>
</div></body>
</html>
