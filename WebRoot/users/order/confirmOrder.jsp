<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
  	<!-- 
  	<meta http-equiv="Expires" CONTENT="0"> 
	<meta http-equiv="Cache-Control" CONTENT="no-cache"> 
	<meta http-equiv="Pragma" CONTENT="no-cache">
	 --> 
    <title>订单确认</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link rel="stylesheet" type="text/css" href="${ctx}/css/order/addrlist.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/css/order/confirm.css">
  	<div align="center" style="margin-top:-40px;">
	<%@ include file="/common/top.jspf" %>
	</div>
 </head>
 <body>
  <div id="templatemo_main" style="margin-top:-12px">
  <center><h3 style="color:#999;margin-bottom:0px;">确认订单</h3></center> 
  <center>
  <div class="address">
    	<h3>选择收货地址<span class="manage-address"><a href="${ctx }/order/deliverAddrAction!showMyAddr.action" target="_blank">管理收货地址</a></span></h3>
		<s:action name="deliverAddrAction!toplist" executeResult="false" namespace="/order"></s:action>
     	<%@ include file="/users/deliverAddr/addrtoplist.jspf" %>
  </div>
  <c:choose>
    <c:when test="${empty sessionScope.orderlist}">
    	<input id="input_empty" type="hidden" value="empty"/>
    	<span class="emptyorder">无订单确认信息!</span>
   	</c:when>
	<c:otherwise>  
  		<form name="form1" id="form1">
		  <s:token />
		  <input type="hidden" name="authorizedToken" value="${userid }" />
		  <input id="addrid" type="hidden" name="addrid" value="0" />
		  <input type="hidden" value="${ctx}" id="idctx"/>
		  <c:forEach items="${sessionScope.orderlist}"  var="order">
			<table class="grid-bundle">
				<thead>
					<tr>
						<th class="tube-title">店铺:${order.shopname}</th>
						<th class="tube-price">单价（元）</th>
						<th class="tube-amount">数量</th>
						<th class="tube-sum">小计（元）</th>
					</tr>
					<tr class="row-border">
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</thead>
				<tbody >
					<c:forEach items="${order.sonlist}" var="son">
					<tr class="grid-main">
						<td colspan="4" class="tube-main">
							<table>
								<tbody>
									<tr id="item_" class="gird-order">
										<td class="tube-img"><a href="${ctx}/viewProductAction_product.do?gid=${son.goods.goodsid}" target="_blank"><img height="50px" width="50px" src="${ctx}${son.goods.goodsPicture.url}"/></a></td>
										<td class="tube-name">
										  <ul style="">
										    <li>${son.goodsName}</li>
										    <li>${son.property }</li>
										  </ul>
										</td>
										<td class="tube-price"><fmt:formatNumber pattern=".00" minIntegerDigits="1" value="${son.price}"></fmt:formatNumber></td>
										<td class="tube-amount">${son.amount }</td>
										<td class="tube-sum"><fmt:formatNumber pattern="#.00" minIntegerDigits="1" value="${son.price * son.amount}"></fmt:formatNumber></td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
					</c:forEach>
				</tbody>
				<tfoot >
					<tr>
						<td colspan="3"></td>
						<td >运费:<span>¥<fmt:formatNumber pattern=".00" minIntegerDigits="1" value="${order.freight }"></fmt:formatNumber></span></td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="memo">
								<label>备注信息：</label>
								<input id="${orderid}" type="text" class="tc-text" name="remark_${order.shop.shopId}" maxlength="40" onkeydown='if(event.keyCode==13) return false;'/>
							</div>
						</td>
						<td class="tube-bill" colspan="2" style="text-align:right;">
							<div class="orderPay" id="orderPay_id">店铺合计<span class="isIncPostage">(含运费)</span>: <span class="tc-rmb">¥<fmt:formatNumber pattern=".00" minIntegerDigits="1" value="${order.ftotal }"></fmt:formatNumber></span></div>
						</td>
					</tr>
				</tfoot>
			</table>
			<hr style="width:840px;margin-top:10px;" />	
		  </c:forEach>
		   <input type="button" id="btn_submit" value="确认订单" style="width:100px;"/>
		   <input type="button" id="btn_back" value="返回购物车" style="width:100px;" onClick="location.href='${ctx}/cartAction_queryCarts.action'" />
		  </form>
	</c:otherwise>
  </c:choose>
  </center>
  </div>
  <footer>
  	<script type="text/javascript" src="${ctx}/js/order/confirmorder.js"></script>
  </footer>
  </body>
</html>
