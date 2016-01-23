<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="owner" content="" />
<meta name="robots" content="index, follow" />
<meta name="googlebot" content="index, follow" />
<title>查看评价</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/noneBorder.css">
<script type="text/javascript" src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/pointEvaluation/viewEvaluation.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			 &nbsp; &nbsp;&nbsp;<h3>查看评价</h3>
			 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			<s:if test="#request.goodsEvaluationModel!= null">
			<table width="800px" align="center">
					<tr id="trMain" style="background:#BFDBEB">	
						<td align="center" width=15%>购买人</td>
						<td align="center" width=25%>购买的店铺名称</td>
						<td align="center" width=25%>宝贝名称</td>
						<td align="center" width=10%>单价（元）</td>
						<td align="center" width=10%>数量（件）</td>
						<td align="center" width=15%>评价状态</td>
					</tr>
					<tr>
						<td align="center">${goodsEvaluationModel.userinfo.username}</td>
						<td align="center">
						<a href="${ctx}/viewProductAction_shop.do?shopid=${goodsEvaluationModel.shop.shopId}"  target="_blank">
								${goodsEvaluationModel.shop.shopname}</a>
						</td>
						<td align="center">
						<a href="javascript:opendetial('${goodsEvaluationModel.goods.goodsid}','${goodsEvaluationModel.goods.shop.shopId}');">
						${goodsEvaluationModel.goods.goodsname}</td>
						<td align="center">${goodsEvaluationModel.orderSon.price}</td>
						<td align="center">${goodsEvaluationModel.orderSon.amount}</td>
						<td align="center">
						<c:if test="${goodsEvaluationModel.state=='0'}">买家已评价</c:if>
						<c:if test="${goodsEvaluationModel.state=='1'}">卖家已评价</c:if>
						<c:if test="${goodsEvaluationModel.state=='2'}">买家已追评</c:if>											
						</td>	
					</tr>
				</table>
					
				<table width="800px" align="center" style='word-wrap:break-word;word-break:break-all'>					
					<tr>
					<td align="center" colspan="2">
					<B>评价内容</B>
					</td>					
				</tr>
				<tr>
					<td align="right" width="230px"><label for="textfield">买家评价：</label></td>
					<td align="left" width="570px"><label for="textfield">${goodsEvaluationModel.goodscontent}</label></td>
				</tr>
				<tr>
					<td align="right"></td>
					<td align="left"><label for="textfield">${goodsEvaluationModel.evaluationTime}</label></td>
				</tr>
				<tr >
					<td align="right"><label for="textfield">卖家评价：</label></td>
					<td align="left" style="color:#BD7F00"><label for="textfield">${goodsEvaluationModel.checkIdea}</label></td>
				</tr>
				<tr style="color:#BD7F00">
					<td align="right"></td>
					<td align="left"><label for="textfield">${goodsEvaluationModel.checkTime}</label></td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">买家追评：</label></td>
					<td align="left"><label for="textfield">${goodsEvaluationModel.addcontent}</label></td>
				</tr>
				<tr>
					<td align="right"></td>
					<td align="left"><label for="textfield">${goodsEvaluationModel.addTime}</label></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<button id="btn_submit" type="button" style="width:120px;"
							onclick="location.href='javascript:history.go(-1);'">返回上一页</button>
					</td>					
				</tr>
				</table>
			</s:if>
			
			<div id="msg_goodsEvaluation">
				<font color="red" id="font1">${msg_goodsEvaluation}</font>
			</div>
		</form>
	</center>
</div>
</body>
</html>
