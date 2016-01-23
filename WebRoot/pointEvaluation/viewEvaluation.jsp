<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<title>查看评价</title>

<script type="text/javascript" src="${ctx}/js/web.js"></script>
<script type="text/javascript" src="${ctx}/js/pointEvaluation/viewEvaluation.js"></script>
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
						<div class="col-md-1  hidden-xs"></div>
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
											<h3 style="margin-left: 40%;"><B>查看评价</B></h3>
											<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
											<s:if test="#request.goodsEvaluationModel!= null">
											<%-- <s:iterator value="#goodsEvaluationModel.order" status="s">	 --%>
											 <fieldset>
						                      <legend>订单信息</legend>
						                       <div class="form-group">
						                          <label class="col-md-2 control-label padding-right-0">购买人：</label>
						                          <div class="col-md-3 ">
						                             <label class="lb-paddingtop-fontnormal">${goodsEvaluationModel.userinfo.username}</label>
						                          </div>
						                          <label class="col-md-2 control-label padding-right-0">购买的店铺名称：</label>
						                          <div class="col-md-4 ">
						                          	<label class="lb-paddingtop-fontnormal">
						                          	<a href="${ctx}/viewProductAction_shop.do?shopid=${goodsEvaluationModel.shop.shopId}"  target="_blank">
														${goodsEvaluationModel.shop.shopname}</a>
						                          	</label>
						                          </div>
						                       </div>
						                       <div class="form-group">
						                          <label class="col-md-2 control-label padding-right-0">宝贝名称：</label>
						                          <div class="col-md-3 ">
						                             <label class="lb-paddingtop-fontnormal">
						                             <a href="javascript:opendetial('${goodsEvaluationModel.goods.goodsid}','${goodsEvaluationModel.goods.shop.shopId}');">
														${goodsEvaluationModel.goods.goodsname}
														<c:if test="${goodsEvaluationModel.orderSon.property !=null}">
														（${goodsEvaluationModel.orderSon.property}）
														</c:if>
														</a>
						                             </label>
						                          </div>
						                          <label class="col-md-2 control-label padding-right-0">单价（元）：</label>
						                          <div class="col-md-4 ">
						                          	<label class="lb-paddingtop-fontnormal">￥${goodsEvaluationModel.orderSon.price}</label>
						                          </div>
						                       </div>
						                       <div class="form-group">
						                          <label class="col-md-2 control-label padding-right-0">数量（件）：</label>
						                          <div class="col-md-3 ">
						                             <label class="lb-paddingtop-fontnormal">${goodsEvaluationModel.orderSon.amount}</label>
						                          </div>
						                          <label class="col-md-2 control-label padding-right-0">评价状态：</label>
						                          <div class="col-md-4 ">
						                          	<label class="lb-paddingtop-fontnormal">
						                          		<c:if test="${goodsEvaluationModel.state=='0'}">买家已评价</c:if>
														<c:if test="${goodsEvaluationModel.state=='1'}">卖家已评价</c:if>
														<c:if test="${goodsEvaluationModel.state=='2'}">买家已追评</c:if>
						                          	</label>
						                          </div>
						                       </div>
						                    </fieldset>     
											 <fieldset>
						                      <legend>评价内容</legend>
						                       <div class="form-group">
						                           <label class="col-md-2 control-label padding-right-0">买家评价：</label>
						                          <div class="col-md-10">
						                            <label class="lb-paddingtop-fontnormal">${goodsEvaluationModel.goodscontent}</label>
						                          </div>
						                          <div class="col-md-10 col-md-offset-2">
						                            <label class="lb-paddingtop-fontnormal">${goodsEvaluationModel.evaluationTime}</label>
						                          </div>
						                       </div>
						                       <div class="form-group">
						                           <label class="col-md-2 control-label padding-right-0">卖家评价：</label>
						                          <div class="col-md-10" style="color:#BD7F00">
						                            <label class="lb-paddingtop-fontnormal">${goodsEvaluationModel.checkIdea}</label>
						                          </div>
						                          <div class="col-md-10 col-md-offset-2" style="color:#BD7F00">
						                            <label class="lb-paddingtop-fontnormal">${goodsEvaluationModel.checkTime}</label>
						                          </div>
						                       </div>
						                       <div class="form-group">
						                           <label class="col-md-2 control-label padding-right-0">买家追评：</label>
						                          <div class="col-md-10">
						                            <label class="lb-paddingtop-fontnormal">${goodsEvaluationModel.addcontent}</label>
						                          </div>
						                          <div class="col-md-10 col-md-offset-2">
						                            <label class="lb-paddingtop-fontnormal">${goodsEvaluationModel.addTime}</label>
						                          </div>
						                       </div>
						                    </fieldset>     
						                    <button type="button" class="btn btn-primary center-block" style="margin-left: 40%;"
						                    	onclick="location.href='javascript:history.go(-1);'">
												返回上一页
											</button>
											</s:if>	
									    </div>	
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-1  hidden-xs"></div>
					</div>
				</div>				
			</div>
		</form>
	</div>		
</body>
</html>
