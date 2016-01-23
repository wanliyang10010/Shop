<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<title>买进宝贝订单</title>

<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/order/havegoods.css">
<script type="text/javascript" src="${ctx}/js/haveBuyGoods/haveBuyGoods.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js" ></script>
<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/ypublic.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/mediaQuery.css"/>
<%@ include file="/common/topAmin.jspf" %>
<script type="text/javascript">
</script>
<style type="text/css">

</style>
</head>
<body>
<div class="container-fluid" id="templatemo_main">
		<form class="form-horizontal" role="form" name="userform" action="" id="userform">
		 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
	 	 <input type="hidden"  name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
   		 <input type="hidden"  name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
   		 <input type="hidden" name="orderid" id="orderid" value="${param.orderid}" />
		 <input type="hidden" name="redirectUrl" id="redirectUrl" value="${param.redirectUrl}"/> 
		 <input type="hidden" name="ordersonId" id="ordersonId" value="${param.ordersonId}"/>
			<div class="row">				
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-1  hidden-xs hidden-sm"></div>
						<div class="col-md-10 col-xs-12">
							<div class="row" style="background-color: #cccccc;height: 30px;"></div>
							<div class="row" style="background-color: #ff4401;height: 50px;"></div>
							<div class="row">
								<div class="col-md-2">
									<div class="list-group">
									  <a href="#" class="list-group-item">填写发货的物流信息</a>
									  <a href="#" class="list-group-item">查看物流信息</a>
									  <a href="#" class="list-group-item">延长收货时间</a>
									  <a href="${ctx}/userPointAction_forwardUserPoint.action" class="list-group-item">买家积分查看</a>
									  <a href="${ctx}/shopEvaluationAction_forwardShopPoint.action" class="list-group-item">店铺评分查看</a>
									  <a href="makeEvaluation.html" class="list-group-item active">评价商品、店铺</a>
									</div>
								</div>
								<div class="col-md-10">
									<h3 class="text-center"><B>买进宝贝订单</B></h3>
									<div class="col-md-12" id="msg_operatingResult">
										<font color="red" size="5" id="font1"><B>${msg_operatingResult}</B>
										</font>
									</div>
									<s:if test="#request.page.totalItems<=0">
										<span style="color:red;font-size:18px">无订单信息!</span>
									</s:if>
									<s:iterator value="#request.page" var="orders">
									<div class="row">
									<div class="col-md-12"  style="margin-top: 10px;">
									 <table style="border:1px solid #E8E8E8;width:100%;word-wrap:break-word;word-break:break-all"
											class="table-responsive blueline">
									   <thead>	
										<tr class="hidden-xs hidden-sm">
											<th align="left" style="width:10%;">
												订单号:${orderid}
											</th>
											<th align="center" style="width:15%;">
												店铺:<a href="${ctx}/viewProductAction_shop.do?shopid=${shop.shopId}"  target="_blank">
												${shopname}</a>
											</th>
											<th align="center" style="width:10%;" >单价（元）</th>
											<th align="center" style="width:10%;" >数量（件）</th>
											<th align="center" style="width:10%;" >小计（元）</th>
											<th align="center" style="width:10%;" >投诉</th>
											<th align="center" style="width:15%;">订单状态</th>
											<th align="center" style="width:20%;">操作</th>
										</tr>
										<!-- 以下内容手机端显示 -->
										<tr class=" hidden-md hidden-lg">
											<th style="text-align:left;" colspan="5">
												<div class="orderPay" style="padding-left:3px">
													店铺:<a href="${ctx}/viewProductAction_shop.do?shopid=${shop.shopId}"  target="_blank">
													${shopname}</a>
												</div>
											</th>
											<th style="text-align:right;color:#ff4401;" colspan="5">
												<div class="orderPay" style="padding-right:3px">
													<s:if test="%{state==\"0\"}">等待买家付款</s:if>
													<s:if test="%{state==\"1\"}">交易关闭</s:if> 
													<s:if test="%{state==\"2\"}">买家已付款</s:if> 
													<s:if test="%{state==\"3\"}">卖家已发货</s:if> 
													<s:if test="%{state==\"31\"}">等待卖家审核延长收货时间申请</s:if> 
													<s:if test="%{state==\"32\"}">等待买家修改延长收货时间申请</s:if> 
													<s:if test="%{state==\"33\"}">卖家已发货</s:if> 
													<s:if test="%{state==\"4\"}">买家已收货&nbsp;&nbsp;&nbsp;&nbsp;交易成功</s:if>
													<s:if test="%{state==\"5\"}">买家已退货&nbsp;&nbsp;&nbsp;&nbsp;交易关闭</s:if>
													<s:if test="%{state==\"51\"}">等待卖家审核退货申请</s:if>
													<s:if test="%{state==\"52\"}">等待买家修改退货申请</s:if> 
													<s:if test="%{state==\"53\"}">等待买家填写物流运单</s:if> 
													<s:if test="%{state==\"54\"}">等待卖家收货</s:if>
												</div>
											</th>
										</tr>
										<tbody class="blueline  hidden-md hidden-lg" >
											<tr>
												<td width="10%"></td>
												<td width="10%"></td>
												<td width="10%"></td>
												<td width="10%"></td>
												<td width="10%"></td>
												<td width="10%"></td>
												<td width="10%"></td>
												<td width="10%"></td>
												<td width="10%"></td>
												<td width="10%"></td>
											</tr>
										</tbody>
										<!-- 手机端显示结束 -->
										<tr class="row-border hidden-xs hidden-sm">
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tbody border="1">
										<tr>
											<td colspan="6" class="blueline hidden-xs hidden-sm">
												<table style="border:none;width:100%;word-wrap:break-word;word-break:break-all" class="table-responsive">
													<tbody>
														<s:iterator value="#orders.sons" var="son">
															<tr id="item_" class="">
																<td class="tube-img">
																<div class="orderPay">
																<a href="javascript:opendetial('${goods.goodsid}','${goods.shop.shopId}');">
																<image id="havegoodsImage" height="80px" width="80px" src="${ctx}${goods.goodsPicture.url}"/>
																</a>
																</div>
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
											<!-- 以下内容手机端显示 -->
											<td colspan="8" class="blueline  hidden-md hidden-lg" style="width:100%;">
												<table style="border:none;width:100%;word-wrap:break-word;word-break:break-all;
													margin-top:0px;margin-bottom:0px;" class="table-responsive">
													<tbody>
														<s:iterator value="#orders.sons" var="son">
															<tr id="item_">
																<td  width="30%">
																<div class="orderPay">
																<a href="javascript:opendetial('${goods.goodsid}','${goods.shop.shopId}');">
																<image id="havegoodsImage" height="80px" width="80px" src="${ctx}${goods.goodsPicture.url}"/>
																</a>
																</div>
																</td>
																<td  width="20%">
																<a href="javascript:opendetial('${goods.goodsid}','${goods.shop.shopId}');">												
																${goodsName} <br/>${son.property}</td>
																<td  width="20%">${price}</td>
																<td  width="10%">${amount}</td>
																<td  width="20%">
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
											<!-- 手机端显示结束 -->
											<td class="blueline hidden-xs hidden-sm" rowspan="#orders.sons.size()" align="center">
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
											<td class="blueline" rowspan="#orders.sons.size()" align="center" colspan="2">
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
																<div class="ststeDiv">
																<a href="javascript:makeevaluation('${ordersonId}','${shop.shopId}','${goods.goodsid}',
																	'${ctx}${goods.goodsPicture.url}','${goodsName}','${userid}');"/>立即评价</a>
																</div>
															</s:if> 													
															<s:if test="#orders.sons.size()==1">
																<a href="javascript:applyreturn('${orderid}','${user.username}','${buytime}','${shopname}','${ftotal}','${remark}','${shop.shopId}','${userid}');">我要退货</a>
																<br/> 
																<a href="javascript:makeevaluation('${ordersonId}','${shop.shopId}','${goods.goodsid}',
																	'${ctx}${goods.goodsPicture.url}','${goodsName}','${userid}');"/>立即评价</a>
																<br/>
																<a href="javascript:deleteorder('${orderid}');">删除订单</a> 
															</s:if>
														</s:if>
														
														<s:if test="(sonstate==\"41\")|| (sonstate==\"43\")">
															<s:if test="#orders.sons.size()>1">
																<div class="ststeDiv">
																<a href="javascript:viewevaluation('${ordersonId}');">查看评价</a>
																</div>
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
																<div class="ststeDiv">
																<a href="javascript:replysellevaluation('${userid}');">追评</a>	
																</div>
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
										<tr class="hidden-xs hidden-sm">
											<td colspan="2" align="left">
												<div class="orderPay" id="orderDate_id">
													<B>订单日期:</B> ${fn:substring(buytime,0,10)}
												</div>
											</td>
											<td colspan="4" align="center">
												<div class="orderPay">
													<B>运费: </B>
													<span>¥<fmt:formatNumber pattern=".00" minIntegerDigits="1" value="${freight}"></fmt:formatNumber>
													</span>
												</div>
											</td>
											<td colspan="1" align="right">
												<div class="orderPay" id="orderPay_id">
													<B>店铺合计<span class="isIncPostage">(含运费)</span>:</B>
												</div>
											</td>
											<td colspan="1" align="left">
												<div class="orderPay" id="orderPay_id">
													<span>¥<fmt:formatNumber pattern=".00" minIntegerDigits="1" value="${ftotal}"></fmt:formatNumber>
													</span>
												</div>
											</td>
										</tr>
										<tr  class="hidden-xs hidden-sm">
											<td colspan="7" align="left">
												<div class="orderPay" id="orderAddress_id">
													<B>收货地址:</B> ${addr}
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
										<tr  class="hidden-xs hidden-sm">
											<td colspan="7" align="left">
												<div class="orderPay" id="orderPay_remark_id">
													<B>备 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</B> ${remark}
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
											<!-- 以下内容手机端显示 -->
										<tr class="  hidden-md hidden-lg">
											<td colspan="8" align="left" >
												<div class="orderPay" id="orderDate_id">
													<B>订单日期:</B> ${fn:substring(buytime,0,10)}
												</div>
											</td>
											<td colspan="2" align="center">
												 <s:if test="%{state==\"4\"}">
												 <s:if test="#orders.sons.size()>1">
													<a href="javascript:applyreturn('${orderid}','${user.username}','${buytime}','${shopname}',
														'${ftotal}','${remark}','${shop.shopId}','${userid}');">我要退货</a>
												</s:if>	
												</s:if>
											</td>
										</tr>
										<tr class=" hidden-md hidden-lg">
											<td colspan="8" align="left">
												<div class="orderPay" id="orderPay_id">
													<B>店铺合计<span class="isIncPostage">(含运费)</span>:</B>
													<span>¥<fmt:formatNumber pattern=".00" minIntegerDigits="1" value="${ftotal}"></fmt:formatNumber>
													</span>
												</div>
											</td>
											<td colspan="2" align="center">
												 <s:if test="%{state==\"4\"}">
												 <s:if test="#orders.sons.size()>1">
												<a href="javascript:deleteorder('${orderid}');">删除订单</a> 
												</s:if>	
												</s:if>
											</td>
										</tr>
										<tr class=" hidden-md hidden-lg">
											<td colspan="10" align="left">
												<div class="orderPay" id="orderAddress_id">
													<B>收货地址:</B> ${addr}
												</div>
											</td>
											
										</tr>
										<tr class=" hidden-md hidden-lg">
											<td colspan="10" align="left">
												<div class="orderPay" id="orderPay_remark_id">
													<B>备 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</B> ${remark}
												</div>
											</td>
											
										</tr>
											<!-- 手机端显示结束 -->
									</tfoot>
								</table>
							</s:iterator>
									<table width="100%">
										<tr>
											<td>
											<%@ include file="/common/pagination.jspf"%>
											</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<div class="col-md-1 hidden-xs hidden-sm"></div>
					</div>
				</div>				
			</div>
		</form>
	</div>		
</body>
</html>
