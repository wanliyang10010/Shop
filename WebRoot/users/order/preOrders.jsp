<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!DOCTYPE HTML>
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
	<%@ include file="/common/top-head.jspf" %>
	<link rel="stylesheet" type="text/css" href="${ctx}/css/order/addrlist.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/css/order/confirm.css">
 </head>
 <body>
  <div align="center" style="margin-top:-40px;">
	<%@ include file="/common/top-nav.jspf" %>
  </div>
  <div id="templatemo_main" style="margin-top:-12px">
  <center><h3 style="color:#999;margin-bottom:0px;">确认订单</h3></center> 
  <center>
  <div class="address">
    	<h3>选择收货地址<span class="manage-address"><a href="${ctx }/order/deliverAddrAction!showMyAddr.action" target="_blank">管理收货地址</a></span></h3>
		<s:action name="deliverAddrAction!toplist" executeResult="false" namespace="/order"></s:action>
     	<%@ include file="/users/deliverAddr/addrtoplist.jspf" %>
  </div>
  <c:choose>
    <c:when test="${empty requestScope.orderlist}">
    	<input id="input_empty" type="hidden" value="empty"/>
    	<span class="emptyorder">无订单确认信息!</span>
   	</c:when>
	<c:otherwise>
	  <div class="div_orders">
  		<form name="form1" id="form1">
  		  <!-- order.statemark 对应 cartId , son.sonstate 对应 itemId -->
		  <input type="hidden" name="authorizedToken" value="${userid }" />
		  <input id="addrid" type="hidden" name="addrid" value="0" />
		  <input type="hidden" value="${ctx}" id="idctx"/>
		  <c:forEach items="${requestScope.orderlist}"  var="order">
			<table class="grid-bundle">
				<thead>
					<tr>
						<th class="tube-title">店铺:${order.shopname}</th>
						<th class="tube-price">单价（元）</th>
						<th class="tube-amount">数量</th>
						<th class="tube-sum">小计（元）</th>
					</tr>
					<tr class="row-border">
						<td><input type="hidden" name="shopid_${order.remark}" value="${order.shop.shopId }"/></td>
						<td></td>
						<td></td>
						<td><input type="hidden" name="cartIds" value="${order.remark }"/></td>
					</tr>
				</thead>
				<tbody >
					<c:forEach items="${order.sonlist}" var="son">
					<tr class="grid-main">
						<td colspan="4" class="tube-main">
							<input type="hidden" name="itemIds" value="${son.sonstate }">
							<input type="hidden" name="itemIds_${order.remark }" value="${son.sonstate }">
							<table>
								<tbody>
									<tr id="item_" class="gird-order">
										<td class="tube-img"><a href="${ctx}/viewProductAction_product.do?gid=${son.goods.goodsid}" target="_blank"><img height="50px" width="50px" src="${ctx}${son.goods.goodsPicture.url}"/></a></td>
										<td class="tube-name">
										  <input type="hidden" name="item_${order.remark }_${son.sonstate }_itemName" value="${son.goodsName }">
										  <ul style="">
										    <li>${son.goodsName}<input type="hidden" name="item_${order.remark }_${son.sonstate }_gid" value="${son.goods.goodsid }"></li>
										    <li>${son.property }<input type="hidden" name="item_${order.remark }_${son.sonstate }_property" value="${son.property }"></li>
										  </ul>
										</td>
										<td class="tube-price">
											<input type="hidden" name="item_${order.remark }_${son.sonstate }_price" value="${son.price}"/>
											<fmt:formatNumber pattern=".00" minIntegerDigits="1" value="${son.price}"></fmt:formatNumber>
										</td>
										<td class="tube-amount"><input type="hidden" name="item_${order.remark }_${son.sonstate }_amount" value="${son.amount}"/>${son.amount }</td>
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
						<td colspan="3"><input type="hidden" name="freight_${order.remark }" value="${order.freight }"/></td>
						<td>运费:<span>¥<fmt:formatNumber pattern=".00" minIntegerDigits="1" value="${order.freight }"></fmt:formatNumber></span></td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="memo">
								<label>备注信息：</label>
								<input id="${orderid}" type="text" class="tc-text" name="remark_${order.remark }" maxlength="40" onkeydown='if(event.keyCode==13) return false;'/>
							</div>
						</td>
						<td class="tube-bill" colspan="2" style="text-align:right;">
							<input type="hidden" name="total_${order.remark }" value="${order.ftotal }">
							<div class="orderPay" id="orderPay_id">店铺合计<span class="isIncPostage">(含运费)</span>: <span class="tc-rmb">¥<fmt:formatNumber pattern=".00" minIntegerDigits="1" value="${order.ftotal }"></fmt:formatNumber></span></div>
						</td>
					</tr>
				</tfoot>
			</table>
			<hr class="gap" />	
		  </c:forEach>
		   <input type="button" id="btn_submit" value="确认订单" style="width:100px;"/>
		   <input type="button" id="btn_back" value="返回购物车" style="width:100px;" onClick="location.href='${ctx}/cartAction_queryCarts.action'" />
		  </form>
		 </div>
	</c:otherwise>
  </c:choose>
  </center>
  </div>
  <footer>
  	<script type="text/javascript" src="${ctx}/js/order/confirmorder.js"></script>
  </footer>
  </body>
</html>
