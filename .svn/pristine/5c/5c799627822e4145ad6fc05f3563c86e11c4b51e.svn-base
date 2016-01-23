<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>立即下单</title>
    <meta http-equiv="Expires" CONTENT="0"> 
	<meta http-equiv="Cache-Control" CONTENT="no-cache">
	<meta http-equiv="Pragma" CONTENT="no-cache"> 
	<%@ include file="/common/top-head.jspf" %> 
	<link rel="stylesheet" type="text/css" href="${ctx}/css/order/buynow.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/css/order/addrlist.css">
  </head>
  <body>
  	<div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf" %>
	</div>
  	<div id="templatemo_main" style="margin-top:-12px;">
    <center>
    	<div class="address">
	    	<h3>确认收货地址<span class="manage-address"><a href="${ctx }/order/deliverAddrAction!showMyAddr.action" target="_blank">管理收货地址</a></span></h3>
	    	<div class="address" style="margin-top: 20px;">
			<s:action name="deliverAddrAction!toplist" executeResult="false" namespace="/order"></s:action>
	     	<%@ include file="/users/deliverAddr/addrtoplist.jspf" %>
	     	</div>
		</div>
		<div class="orderdiv">
		<h3>确认订单信息</h3>
    	<form id="form1" name="form1">
    		<s:token />
    		<input type="hidden" name="authorizedToken" value="${userid }" />
	    	<input id="addrid" type="hidden" name="addrid" value="0" />
	    	<input type="hidden" name="shopid" value="${order.shop.shopId }" />
			<table style="border:1px solid silver;" class="grid-bundle">
			<thead>
				<tr>
					<th class="tube-title">店铺宝贝</th>
					<th class="tube-price">单价（元）</th>
					<th class="tube-amount">数量</th>
					<th class="tube-sum">小计（元）</th>
				</tr>
				<tr class="row-border">
					<td></td><td></td>
					<td></td><td></td>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#request.order.sons" var="son">
				<tr>
					<td colspan="4" style="text-align: left;">店铺: <s:property value="order.shopname"/></td>
				</tr>
				<tr class="grid-main">
					<td colspan="4" class="tube-main">
						<table>
							<tbody>
								<tr id="item_" class="gird-order">
									<td class="tube-img">
									  <a href="${ctx}/viewProductAction_product.do?gid=${son.goods.goodsid}" target="_blank"><Img height="50px" src="${ctx}${son.goods.goodsPicture.url}"/></a>
									  <input type="hidden" name="goodsid" value="${son.goods.goodsid}" />
									</td>
									<%-- <td class="tube-master">${son.goodsName}<input type="hidden" name="goodsname" value="${son.goodsName}" /></td> --%>
									<td class="tube-master">
									  <ul>
										<li><a href="${ctx}/viewProductAction_product.do?gid=${son.goods.goodsid}" title="${son.goodsName }" target="_blank" >${son.goodsName }</a></li>
										<li>${son.property }<input type="hidden" name="property" value="${son.property}" /></li>
									  </ul>
									</td>
									<td class="tube-price"><fmt:formatNumber pattern=".00"  minIntegerDigits="1" value="${son.price}"></fmt:formatNumber><input type="hidden" name="price" value="${son.price}" /></td>
									<td class="tube-amount">${son.amount }<input type="hidden" name=amount value="${son.amount}" /></td>
									<td class="tube-sum"><fmt:formatNumber pattern=".00"  minIntegerDigits="1" value="${son.price * son.amount}"></fmt:formatNumber></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr></s:iterator>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3"></td>
					<td>运费:<span>¥<fmt:formatNumber pattern=".00" minIntegerDigits="1" value="${order.freight }"></fmt:formatNumber></span></td>
				</tr>
				<tr>
					<td colspan="3">
						<div class="memo"><label>备注信息:</label><input type="text" class="tc-text" maxlength="40" id="remark" name="remark" onkeydown="if(event.keyCode==13) return false;" /></div>
					</td>
					<td class="tube-bill">
						<div class="orderPay" id="orderPay_id">店铺合计<span class="isIncPostage">(含运费)</span>: <span class="tc-rmb">¥<fmt:formatNumber pattern=".00" value="${order.ftotal }" minIntegerDigits="1"></fmt:formatNumber></span></div>
					</td>
				</tr>
			</tfoot>
		</table>
		<br/>
		<input type="button" id="btn_submit" alt="确认无误后即可提交订单" value="提交订单">
		</form>
		</div>
    </center>
    </div>
    <footer>
    	<script type="text/javascript" src="${ctx}/js/order/buynow.js"></script>
    </footer>
  </body>
</html>
