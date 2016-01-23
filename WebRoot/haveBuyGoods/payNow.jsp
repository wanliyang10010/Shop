<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<title>支付商品</title>

<script type="text/javascript" src="${ctx}/js/web.js"></script>
<script type="text/javascript" src="${ctx}/js/haveBuyGoods/payNow.js"></script>
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
							<div class="row">
								<div class="col-md-12">
									<h3 style="text-align: center;"><B>支付商品</B></h3>
									<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
									<s:if test="#request.orderid!=''">
									 <fieldset>
				                      <legend>订单信息</legend>
				                       <div class="form-group">
				                        	<label class="col-md-2 control-label padding-right-0">订单号：</label>
				                          <div class="col-md-2 ">
				                           <label class="lb-paddingtop-fontnormal">${param.orderid}</label>
				                          </div>
				                            <label class="col-md-2 control-label padding-right-0">店铺名称：</label>
				                          <div class="col-md-2 ">
				                           <label class="lb-paddingtop-fontnormal">${param.shopname}</label>
				                          </div>
				                            <label class="col-md-2 control-label padding-right-0">订单金额：</label>
				                          <div class="col-md-2">
				                            <label class="lb-paddingtop-fontnormal">￥${param.ftotal}</label>
				                          </div>
				                       </div>
				                       <div class="form-group">
				                          <label class="col-md-2 control-label padding-right-0">购买人：</label>
				                          <div class="col-md-2">
				                             <label class="lb-paddingtop-fontnormal">${param.username}</label>
				                          </div>
				                          <label class="col-md-2 control-label padding-right-0">购买时间：</label>
				                          <div class="col-md-2">
				                          	<label class="lb-paddingtop-fontnormal">${param.buytime.substring(0,19)}</label>
				                          </div>
				                          <label class="col-md-2 control-label padding-right-0">买家留言：</label>
				                          <div class="col-md-2">
				                             <label class="lb-paddingtop-fontnormal">${param.remark}</label>
				                          </div>
				                       </div>
				                    </fieldset>     
									 <fieldset>
				                      <legend>支付信息</legend>
				                       <div class="form-group">
				                         <table class="table-responsive" align="center"  
											style='width:90%;height:100%;border: 1px solid;word-wrap:break-word;word-break:break-all'>
											<tr style="display:none">
												<td>
												<input type="text" name="orderid" id="orderid" value="${param.orderid}">
												<input type="text" name="ftotal" id="ftotal" value="${param.ftotal}">
												<input type="text" name="redirectUrl" id="redirectUrl" value="${param.redirectUrl}">
												</td>
											</tr>
											<tr>
												<td align="center" style="height:300px">
													<h2>银行支付信息</h2>
												</td>
											</tr>
										</table>
				                       </div>
				                    </fieldset>   
				                    <div class="col-md-12 text-center" >  
				                    	<button type="button" class="btn btn-primary" onclick="paymoney();">完成支付</button>
				                    </div>	
									</s:if>	
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
