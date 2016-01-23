<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<title>店铺评分查看</title>

<script type="text/javascript" src="${ctx}/js/web.js"></script>
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
			 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			  <input type="hidden"  name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	   		 <input type="hidden"  name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
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
											<h3 class="text-center"><B>店铺评分查看</B></h3>
					                     	<div class="col-md-12 table-responsive  divtable">
					                     	 <s:if test="#request.page!= null&&#request.page.getTotalItems()>0"> 
											 <table class="table  table-striped table-hover table-condensed
											 	wordflow text-overflow text-center break-wrap" >
											 	<thead>
											 	<tr>
											 		<td width=10%>评价人</td>
												  	<td width=10%>评价时间</td>
												  	<td width=15%>订单号</td>
												  	<td width=15%>商品名称</td>
												  	<td class="hidden-xs" width=10%> 宝贝与描述相符分值</td>
												  	<td class="hidden-xs" width=10%>卖家的服务态度分值</td>
												  	<td class="hidden-xs" width=10%>卖家发货的速度分值</td>
												  	<td width=10%>店铺评分</td>
											 	</tr>
											 	</thead>
											 	<tbody>
											 	<s:iterator value="#request.page" status="s">	
											 		<tr>
											 			<td>${userinfo.username}</td>
											 			<td>${fn:substring(evaluationTime,0,10)}</td>
											 			<td>${orderSon.order.orderid}</td>
											 			<td>${goods.goodsname}</td>
											 			<td class="hidden-xs">${describepoint}</td>
											 			<td class="hidden-xs">${servicepoint}</td>
											 			<td class="hidden-xs">${speedpoint}</td>
											 			<td>${shoppoint}</td>
											 		</tr>
								 				</s:iterator>	
											 	</tbody>
											 </table>
											 <div>
											  <%@ include file="/common/shopPaging.jspf" %>
	 										 </div>
	 										  <div>
	 										 <span style="color:red;font-weight: bold;display:-moz-inline-box;display:inline-block;width:100%;margin-top:15px;text-align:center">
			（说明：店铺评分是根据各个买家对店铺打分的加权平均值，不是各个买家打分的简单累加，店铺评分分值越高，代表店铺整体越优秀！）</span>
											</div>
	 										  </s:if>
											</div>	
											<div id="msg_shopEvaluationList">
											<font color="red" id="font1">${msg_shopEvaluationList}</font>
											</div>
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
	</center>
</div></body>
</html>
