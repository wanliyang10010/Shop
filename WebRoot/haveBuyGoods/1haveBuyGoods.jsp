<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>买进宝贝订单</title>
<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/order/havegoods.css">
<script type="text/javascript" src="${ctx}/js/haveBuyGoods/haveBuyGoods.js"></script>

</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
	<div id="templatemo_main">
		<center>
			<form name="userform" action="" id="userform">
				<input type="hidden" id="authorizedToken" name="authorizedToken"
					value="${userid}" /> <input type="hidden" name="page.pageNo"
					id="pageNo" value="${page.pageNo}" /> <input type="hidden"
					name="page.pageSize" id="pageSize" value="${page.pageSize}" /> 
					<input type="hidden" name="orderid" id="orderid" value="${param.orderid}" />
					<input type="hidden" name="redirectUrl" id="redirectUrl" value="${param.redirectUrl}" /> 
					<input type="hidden" name="ordersonId" id="ordersonId" value="${param.ordersonId}" />
				&nbsp; &nbsp;&nbsp;
				<h3>买进宝贝订单</h3>
				<div id="msg_operatingResult">
					<font color="red" size="5" id="font1"><B>${msg_operatingResult}</B>
					</font>
				</div>
				<s:if test="#request.page.totalItems<=0">
					<span style="color:red;font-size:18px">无订单信息!</span>
				</s:if>
				<s:iterator value="#request.page" var="orders">
					<table style="border:1px solid;width:900px;word-wrap:break-word;word-break:break-all"
						class="grid-bundle grid-TmallSeller">
						<thead>
							<tr>
								<th align="center" width=10%>订单号:${orderid}</th>
								<th align="center" width=15%>店铺:								
								<a href="${ctx}/viewProductAction_shop.do?shopid=${shop.shopId}"  target="_blank">
								${shopname}</a></th>
								<th align="center" width=10%>单价（元）</th>
								<th align="center" width=10%>数量（件）</th>
								<th align="center" width=10%>小计（元）</th>
								<th align="center" width=10%>投诉</th>
								<th align="center" width=15%>订单状态</th>
								<th align="center" width=20%>操作</th>
							</tr>
							<tr class="row-border">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</thead>
						<tbody border="1">
							<tr>
								<td colspan="6" class="tube-main">
									<table>
										<tbody>
											<s:iterator value="#orders.sons" var="son">
												<tr id="item_" class="gird-order">
													<td class="tube-img">
													<a href="javascript:opendetial('${goods.goodsid}','${goods.shop.shopId}');">
													<image height="80px" width="80px" src="${ctx}${goods.goodsPicture.url}"/>
													</td>
													<td class="tube-master">
													<a href="javascript:opendetial('${goods.goodsid}','${goods.shop.shopId}');">												
													${goodsName} <br/>${son.property}</td>
													<td class="tube-price">${price}</td>
													<td class="tube-amount">${amount}</td>
													<td class="tube-sum">
													<fmt:formatNumber pattern=".00" minIntegerDigits="1" value="${price * amount}"></fmt:formatNumber>
													</td>
													<td class="tube-dispute">
													<s:if test="%{state!=\"1\"}">
														<c:if test="${isdispute=='0'}">
															<a href="javascript:dispute('${ordersonId}');">投诉卖家</a>
														</c:if>
													</s:if> 
													<c:if test="${isdispute=='1'}">
														<a href="javascript:viewdispute('${ordersonId}');">查看投诉</a>
													</c:if>
													</td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
								</td>
								<td class="tube-main" rowspan="#orders.sons.size()" align="center">
									<s:if test="%{state==\"0\"}">等待买家付款</s:if>
									<s:if test="%{state==\"1\"}">交易关闭</s:if> 
									<s:if test="%{state==\"2\"}">买家已付款</s:if> 
									<s:if test="%{state==\"3\"}">卖家已发货</s:if> 
									<s:if test="%{state==\"31\"}">等待卖家审核<br />延长收货时间申请</s:if> 
									<s:if test="%{state==\"32\"}">等待买家修改<br />延长收货时间申请</s:if> 
									<s:if test="%{state==\"33\"}">卖家已发货</s:if> 
									<s:if test="%{state==\"4\"}">买家已收货<br />交易成功</s:if>
									<s:if test="%{state==\"5\"}">买家已退货<br />交易关闭</s:if>
									<s:if test="%{state==\"51\"}">等待卖家审<br />核退货申请</s:if>
									<s:if test="%{state==\"52\"}">等待买家修<br />改退货申请</s:if> 
									<s:if test="%{state==\"53\"}">等待买家填<br />写物流运单</s:if> 
									<s:if test="%{state==\"54\"}">等待卖家收货</s:if>
								</td>
								<td class="tube-main" rowspan="#orders.sons.size()" align="center">
									<s:if test="%{state==\"0\"}">
										<img height="25px" src="${ctx}/image/buysellgoods/payNow.png"
											onclick="paynow('${orderid}','${user.username}','${buytime}','${shopname}', '${ftotal}','${remark}','${userid}');" />
										<br/>
										<img height="20px" src="${ctx}/image/buysellgoods/cancelOrder.png"
											onclick="cancelorder('${orderid}');" />
									</s:if>
									<s:if test="%{state==\"1\"}">
										<a href="javascript:deleteorder('${orderid}');">删除订单</a>
									</s:if> 
									<s:if test="%{state==\"3\"}">									
										<a href="javascript:viewtrans('${orderid}');">查看物流信息</a>
										<br/>
										<a href="javascript:confirmgoods('${orderid}');">确认收货</a>
										<br/>
										<a href="javascript:applyprolong('${orderid}','${user.username}','${buytime}','${shopname}',
											'${ftotal}','${remark}','${shop.shopId}','${userid}');">延长收货时间</a>
									</s:if> 
									<s:if test="%{state==\"32\"}">
										<a href="javascript:viewtrans('${orderid}');">查看物流信息</a>
										<br/>
										<a href="javascript:confirmgoods('${orderid}');">确认收货</a>
										<br/>
										<a href="javascript:alterprolong('${orderid}','${userid}');">修改延长收货时间</a>
									</s:if> 
									<s:if test="(state==\"31\")|| (state==\"33\")">
									<a href="javascript:viewtrans('${orderid}');">查看物流信息</a>
										<br/>
										<a href="javascript:confirmgoods('${orderid}');">确认收货</a>
										<br/>
										<a href="javascript:viewprolong('${orderid}','${userid}');">查看延长收货时间</a>
									</s:if>
									 <s:if test="%{state==\"4\"}">
										<s:iterator value="#orders.sons" var="son" status="s">
											<s:if test="%{sonstate==\"40\"}">
											<s:if test="#orders.sons.size()>1">
											<s:if test="#s.index+1 == 1">
											<div style="padding-top:30px;padding-bottom:30px;">
											<a href="javascript:makeevaluation('${ordersonId}','${shop.shopId}','${goods.goodsid}',
												'${ctx}${goods.goodsPicture.url}','${goodsName}','${userid}');"/>立即评价</a>
											</div>
											<br/> 
											</s:if> 											
											</s:if> 													
											<s:if test="(#s.index+1 != 1)&&(#s.index+1 != #orders.sons.size())">
											<div style="padding-top:30px;padding-bottom:30px;">
											<a href="javascript:makeevaluation('${ordersonId}','${shop.shopId}','${goods.goodsid}',
												'${ctx}${goods.goodsPicture.url}','${goodsName}','${userid}');"/>立即评价</a>
											</div>
											<br/>										
											</s:if>
											<s:if test="#orders.sons.size()>1"> 
											<s:if test="#s.index+1 == #orders.sons.size()">
											<div style="padding-top:30px;padding-bottom:30px;">
											<a href="javascript:makeevaluation('${ordersonId}','${shop.shopId}','${goods.goodsid}',
												'${ctx}${goods.goodsPicture.url}','${goodsName}','${userid}');"/>立即评价</a>
											</div>
											</s:if>
											</s:if>
											<s:if test="#orders.sons.size()==1">
											<a href="javascript:applyreturn('${orderid}','${user.username}','${buytime}','${shopname}','${ftotal}','${remark}','${shop.shopId}','${userid}');">我要退货</a>
											<br/>
											<a href="javascript:makeevaluation('${ordersonId}','${shop.shopId}','${goods.goodsid}',
												'${ctx}${goods.goodsPicture.url}','${goodsName}','${userid}');"/>立即评价</a>
											<br/>
											<a href="javascript:deleteorder('${orderid}');">删除订单</a> 
											<br/>	
											</s:if>
											</s:if>
											
											<s:if test="(sonstate==\"41\")|| (sonstate==\"43\")">
											<s:if test="#orders.sons.size()>1">
											<s:if test="#s.index+1 == 1">
											<div style="padding-top:30px;padding-bottom:30px;">
											<a href="javascript:viewevaluation('${ordersonId}');">查看评价</a>
											</div>
											<br/>
											</s:if> 											
											</s:if> 											
											<s:if test="(#s.index+1 != 1)&&(#s.index+1 != #orders.sons.size())">
											<div style="padding-top:30px;padding-bottom:30px;">
											<a href="javascript:viewevaluation('${ordersonId}');">查看评价</a>
											</div>											
											<br/>												
											</s:if>	
											<s:if test="#orders.sons.size()>1">
											<s:if test="#s.index+1 == #orders.sons.size()">	
											<div style="padding-top:30px;padding-bottom:30px;">										
											<a href="javascript:viewevaluation('${ordersonId}');">查看评价</a>
											</div>																																												
											</s:if>
											</s:if>
												
											<s:if test="#orders.sons.size()==1">
											<a href="javascript:applyreturn('${orderid}','${user.username}','${buytime}','${shopname}','${ftotal}','${remark}','${shop.shopId}','${userid}');">我要退货</a>
											<br/>
											<a href="javascript:viewevaluation('${ordersonId}');">查看评价</a>	
											<br/>
											<a href="javascript:deleteorder('${orderid}');">删除订单</a>
											</s:if>										
											</s:if>
											
											<s:if test="%{sonstate==\"42\"}">
											<s:if test="#orders.sons.size()>1">
											<s:if test="#s.index+1 == 1">
											<div style="padding-top:30px;padding-bottom:30px;">
											<a href="javascript:replysellevaluation('${userid}');">追评</a>	
											</div>
											<br/>
											</s:if> 											
											</s:if> 											
											<s:if test="(#s.index+1 != 1)&&(#s.index+1 != #orders.sons.size())">
											<div style="padding-top:30px;padding-bottom:30px;">
											<a href="javascript:replysellevaluation('${userid}');">追评</a>													
											</div>
											<br/>																																						
											</s:if>
											<s:if test="#orders.sons.size()>1">
											<s:if test="#s.index+1 == #orders.sons.size()">	
											<div style="padding-top:30px;padding-bottom:30px;">											
											<a href="javascript:replysellevaluation('${userid}');">追评</a>	
											</div>																																					
											</s:if>
											</s:if>
											<s:if test="#orders.sons.size()==1">
											<a href="javascript:applyreturn('${orderid}','${user.username}','${buytime}','${shopname}','${ftotal}','${remark}','${shop.shopId}','${userid}');">我要退货</a>
											<br/>
											<a href="javascript:replysellevaluation('${userid}');">追评</a>	
											<br/>
											<a href="javascript:deleteorder('${orderid}');">删除订单</a>
											</s:if>
											</s:if>
										</s:iterator>
									</s:if> 
									<s:if test="(state==\"5\")|| (state==\"51\")|| (state==\"54\")">
										<a href="javascript:viewreturn('${orderid}','${userid}');">查看退货申请</a>
										<s:if test="%{state==\"5\"}">
											<br/>
											<a href="javascript:deleteorder('${orderid}');">删除订单</a>
										</s:if>
									</s:if> 
									<s:if test="%{state==\"52\"}">
										<a href="javascript:alterreturn('${orderid}','${userid}');">修改退货申请</a>
									</s:if> 
									<s:if test="%{state==\"53\"}">
										<a href="javascript:transInforeturn('${orderid}','${userid}');">填写物流运单</a>
									</s:if>
								</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="2" align="left">
									<div class="orderPay" id="orderDate_id">
										订单日期:<strong> ${fn:substring(buytime,0,10)}</strong>
									</div>
								</td>
								<td colspan="4" align="center">
									<div class="orderPay">
										运费: <strong>
										<span>¥<fmt:formatNumber pattern=".00" minIntegerDigits="1" value="${freight}"></fmt:formatNumber>
										</span>
										</strong>
									</div>
								</td>
								<td colspan="1" align="right">
									<div class="orderPay" id="orderPay_id">
										店铺合计<span class="isIncPostage">(含运费)</span>:
									</div>
									</div>
								</td>
								<td colspan="1" align="left">
									<div class="orderPay" id="orderPay_id">
										<strong>
										<span>¥<fmt:formatNumber pattern=".00" minIntegerDigits="1" value="${ftotal}"></fmt:formatNumber>
										</span>
										</strong>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="7" align="left">
									<div class="orderPay" id="orderAddress_id">
										收货地址:<strong> ${addr}</strong>
									</div>
								</td>
								<td colspan="1" align="center">
									 <s:if test="%{state==\"4\"}">
									 <s:if test="#orders.sons.size()>1">
										<a href="javascript:applyreturn('${orderid}','${user.username}','${buytime}','${shopname}',
											'${ftotal}','${remark}','${shop.shopId}','${userid}');">我要退货</a>
									</s:if>	
									</s:if>
								</td>
							</tr>
							<tr>
								<td colspan="7" align="left">
									<div class="orderPay" id="orderPay_remark_id">
										备&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注:<strong> ${remark}</strong>
									</div>
								</td>
								<td colspan="1" align="center">
									 <s:if test="%{state==\"4\"}">
									 <s:if test="#orders.sons.size()>1">
									<a href="javascript:deleteorder('${orderid}');">删除订单</a> 
									</s:if>	
									</s:if>
								</td>
							</tr>
						</tfoot>
					</table>
					<br />
				</s:iterator>
				<table width="800px">
					<tr>
						<td><%@ include file="/common/pagination.jspf"%>
						</td>
					</tr>
				</table>
			</form>
		</center>
	</div>
</body>
</html>
