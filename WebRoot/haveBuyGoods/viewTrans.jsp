<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<title>查看物流信息</title>

<script type="text/javascript" src="${ctx}/js/web.js"></script>
<script type="text/javascript" src="${ctx}/js/haveBuyGoods/viewTrans.js"> </script>
<script type="text/javascript" src="${ctx}/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js" ></script>
<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/ypublic.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/mediaQuery.css"/>
<%@ include file="/common/topAmin.jspf" %>
</head>
<body>
<div class="container-fluid" id="templatemo_main">
		<form class="form-horizontal" role="form" name="userform" action="" id="userform">
			<div class="row">				
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-1 hidden-xs"></div>
						<div class="col-md-10 col-xs-12">
							<div class="row" style="background-color: #cccccc;height: 30px;"></div>
							<div class="row" style="background-color: #ff4401;height: 50px;"></div>
							<div class="row">
								<div class="col-md-2">
									<div class="list-group">
									  <a href="#" class="list-group-item active">Cras justo odio</a>
									  <a href="#" class="list-group-item">Dapibus ac facilisis</a>
									  <a href="#" class="list-group-item">Morbi leo risus</a>
									  <a href="#" class="list-group-item">Porta ac consectetur</a>
									  <a href="#" class="list-group-item">Vestibulum at eros</a>
									</div>
								</div>
								<div class="col-md-10">
									<div class="row">
										<div class="col-md-12">
											<h3 style="margin-left: 30%;"><B>查看物流信息</B></h3>
											<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
											<s:if test="#request.order!= null">
											<s:iterator value="#request.order" status="s">	
											 <fieldset>
						                      <legend>订单信息</legend>
						                       <div class="form-group">
						                        	<label class="col-md-2 control-label padding-right-0">订单号：</label>
						                          <div class="col-md-3 ">
						                           <label class="lb-paddingtop-fontnormal">${orderid}</label>
						                          </div>
						                          <label class="col-md-2 control-label padding-right-0">订单状态：</label>
						                          <div class="col-md-4 ">
						                           <label class="lb-paddingtop-fontnormal">
						                            <s:if test="%{state==\"0\"}">等待买家付款</s:if> 
													<s:if test="%{state==\"1\"}">交易关闭</s:if> 
													<s:if test="%{state==\"2\"}">买家已付款</s:if>
													<s:if test="%{state==\"3\"}">卖家已发货</s:if>
													<s:if test="%{state==\"31\"}">等待卖家审核延长收货时间申请</s:if> 
													<s:if test="%{state==\"32\"}">等待买家修改延长收货时间申请</s:if> 
													<s:if test="%{state==\"33\"}">卖家已发货</s:if> 
													<s:if test="%{state==\"4\"}">买家已收货，交易成功</s:if>
													<s:if test="%{state==\"5\"}">买家已退货，交易关闭</s:if> 
													<s:if test="%{state==\"51\"}">等待卖家审核退货申请</s:if> 
													<s:if test="%{state==\"52\"}">等待买家修改退货申请</s:if> 
													<s:if test="%{state==\"53\"}">等待买家填写物流运单</s:if> 
													<s:if test="%{state==\"54\"}">等待卖家收货</s:if> 
						                           </label>
						                          </div>
						                       </div>
						                        <div class="form-group">
						                           <label class="col-md-2 control-label padding-right-0">订单金额：</label>
						                          <div class="col-md-3">
						                            <label class="lb-paddingtop-fontnormal">￥${ftotal}</label>
						                          </div>
						                          <label class="col-md-2 control-label padding-right-0">店铺名称：</label>
						                          <div class="col-md-4 ">
						                           <label class="lb-paddingtop-fontnormal">
						                           	<a href="${ctx}/viewProductAction_shop.do?shopid=${shop.shopId}"  
						                           		target="_blank">${shop.shopname}</a>
						                           </label>
						                          </div>
						                       </div>
						                        <div class="form-group">
						                          <label class="col-md-2 control-label padding-right-0">商品信息：</label>
						                          <div class="col-md-8">
						                             <label class="lb-paddingtop-fontnormal">
						                             <s:iterator value="%{sons}" status="s">		
													<a href="javascript:opendetial('${goods.goodsid}','${goods.shop.shopId}');">
													${goodsName}
													<s:if test="%{property!=null}">
													（${property}）
													</s:if>
													</a>
													<s:if test="%{order.sons.size()>1}">
													&nbsp; &nbsp; &nbsp;
													</s:if>
													</s:iterator>
						                             </label>
						                          </div>
						                       </div>
						                       <div class="form-group">
						                          <label class="col-md-2 control-label padding-right-0">购买人：</label>
						                          <div class="col-md-3 ">
						                             <label class="lb-paddingtop-fontnormal">${user.username}</label>
						                          </div>
						                          <label class="col-md-2 control-label padding-right-0">购买时间：</label>
						                          <div class="col-md-4 ">
						                          	<label class="lb-paddingtop-fontnormal">${fn:substring(buytime,0,19)}</label>
						                          </div>
						                       </div>
						                        <div class="form-group">
						                          <label class="col-md-2 control-label padding-right-0">收货地址：</label>
						                          <div class="col-md-8">
						                             <label class="lb-paddingtop-fontnormal">${addr}</label>
						                          </div>
						                       </div>
						                         <div class="form-group">
						                          <label class="col-md-2 control-label padding-right-0">买家留言：</label>
						                          <div class="col-md-8">
						                             <label class="lb-paddingtop-fontnormal">${remark}</label>
						                          </div>
						                       </div>
						                    </fieldset>     
											 <fieldset>
						                      <legend>物流信息</legend>
						                       <div class="form-group">
						                           <label class="col-md-2 control-label padding-right-0">物流公司：</label>
						                          <div class="col-md-3">
						                            <label class="lb-paddingtop-fontnormal">${transcompany}</label>
						                          </div>
						                     <!--  </div>
						                       <div class="form-group">-->
						                           <label class="col-md-2 control-label padding-right-0">物流单号：</label>
						                          <div class="col-md-4">
						                            <label class="lb-paddingtop-fontnormal">${transnumber}</label>
						                          </div>
						                       </div>
						                    </fieldset>     
						                    <button type="button" class="btn btn-primary center-block"
						                    style="margin-left: 32%;"
						                    	onclick="location.href='javascript:history.go(-1);'">
												返回上一页
											</button>
											</s:iterator>
											</s:if>	
									    </div>	
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-1 hidden-xs"></div>
					</div>
				</div>				
			</div>
		</form>
	</div>		
</body>
</html>
