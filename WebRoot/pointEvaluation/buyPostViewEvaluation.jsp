<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<title>我的评价</title>

<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/fontBorder.css">
<script type="text/javascript" src="${ctx}/js/pointEvaluation/buyPostViewEvaluation.js"></script>
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
									  <a href="#" class="list-group-item">填写发货的物流信息</a>
									  <a href="#" class="list-group-item">查看物流信息</a>
									  <a href="#" class="list-group-item">延长收货时间</a>
									  <a href="${ctx}/userPointAction_forwardUserPoint.action" class="list-group-item">买家积分查看</a>
									  <a href="${ctx}/shopEvaluationAction_forwardShopPoint.action" class="list-group-item">店铺评分查看</a>
									  <a href="makeEvaluation.html" class="list-group-item active">评价商品、店铺</a>
									</div>
								</div>
								<div class="col-md-10">
									<h3 class="text-center"><B>我的评价</B></h3>
									<s:if test="#request.msg_shoppoint!='暂无数据！' ">
									<div class="col-md-12 text-center" style="margin-top: 10px;">
										店铺平均得分： <font color="red" id="font1">${msg_shoppoint}</font>
										&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
										<button id="btn_shoppoint" type="button" class="btn btn-primary btn-small" 
										onclick="shoppoint('${userid}');" style="width:80px;">查看详情</button>
									</div>
									</s:if>
									
									<div class="col-md-12 text-center" style="margin-top: 10px;">
										买家累积积分： <font color="red" id="font1">${msg_userpoint}</font>
										&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
										<button id="btn_userpoint"  type="button"  class="btn btn-primary btn-small" 
										onclick="userpoint('${userid}');" style="width:80px;">查看详情</button>
									</div>
									<div class="col-md-12 text-center"  style="margin-top: 10px;">
									 <table class="table-responsive " style="border:none;width:100%;height:100%;border-spacing: 0px">
										<tr>
											<td align="center" style="width:110px;" colspan="1">
											<img id="imgFromBuyY" src="${ctx}/image/evaluation/fromBuyY.png" style="CURSOR: pointer" /> 
											<img id="imgFromBuyN" src="${ctx}/image/evaluation/fromBuyN.png" onclick="img1('${userid}');" style="CURSOR: pointer;display:none" />
											</td>
											<td align="center" style="width:120px" colspan="1">
											<img id="imgFromSellY" src="${ctx}/image/evaluation/fromSellY.png" style="CURSOR: pointer;display:none" /> 
											<img id="imgFromSellN" src="${ctx}/image/evaluation/fromSellN.png" onclick="img2('${userid}');" style="CURSOR: pointer" />
											</td>
											<td align="center" style="width:110px" colspan="1">
											<img id="imgToOtherY" src="${ctx}/image/evaluation/toOtherY.png" style="CURSOR: pointer;display:none" /> 
											<img id="imgToOtherN" src="${ctx}/image/evaluation/toOtherN.png" onclick="img3('${userid}');" style="CURSOR: pointer" />
											</td>
											<td align="center" style="width:460px" colspan="5"></td>
										</tr>
									 </table>
									</div>
									<div class="col-md-12 text-center">
									<table class="table-responsive " id="tbFromBuy" style="width:100%;height:100%;border-spacing: 0px"> 
										<tr>
											<td>
												<s:if test="#request.page!= null&&#request.page.getTotalItems()>0">
													<table class="table-responsive table" align="center"  
													style='width:100%;height:100%;border-spacing: 0px;word-wrap:break-word;word-break:break-all'>
														<tr style="background:#BFDBEB;">
															<td align="center" width=40%><B>评价内容</B></td>
															<td align="center" width=25%><B>评价人</B></td>
															<td align="center" width=25%><B>宝贝信息</B></td>
															<td align="center" width=10%><B>操作</B></td>
															<td align="center" width=10% style="display:none">ID</td>
														</tr>
														<s:iterator value="#request.page" status="s">
															<tr>
																<td align="center">${goodscontent}</br>[${evaluationTime}]
																	<textarea name="checkIdea${goodsEvaluationId}"
																		id="checkIdea${goodsEvaluationId}" maxlength="333"
																		style="margin-top: 5px;width:100%;height:50px;display:none"></textarea>
																	</br>
																	 <img id="imgFromBuyPublishReply${goodsEvaluationId}"
																	src="${ctx}/image/evaluation/publishReply.png"
																	onclick="publishreplyfrombuy('${goodsEvaluationId}');"
																	style="display:none;" /> 
																	
																	<s:if test="checkTime!=null && checkTime!=\"\" ">
																	<span class="lb-paddingtop-fontnormal">[我的回复]</span>
																	<span id="lbfrombuycheckIdea" class="lb-paddingtop-fontnormal"
																	style="color:#BD7F00">${checkIdea}</br>[${checkTime}]</span>
																	</s:if>
																	
																	 <s:if test="addTime!=null && addTime!=\"\" ">
																	 </br>
																	<span id="lbfrombuy" class="lb-paddingtop-fontnormal">[追加评论]${addcontent}</br>[${addTime}]</span>
																	</s:if>
																</td>
																<td align="center">
																	${userinfo.username}
																</td>
																<td align="center">
																	<a href="javascript:opendetial('${goods.goodsid}','${goods.shop.shopId}');">
																	${goods.goodsname}
																	<s:if test="%{orderSon.property!=null}">
																	（${orderSon.property}）
																	</s:if>
																	</a>
																</td>
																<td align="center">
																 <s:if test="(checkIdea==null) || (checkIdea==\"\")">
																	<img id="imgFromBuyReply${goodsEvaluationId}"
																		src="${ctx}/image/evaluation/reply.png"
																		onclick="replyfrombuy('${goodsEvaluationId}');"/>
																</s:if>
																</td>
																<td align="center" style="display:none">${goodsEvaluation}</td>
															</tr>
														</s:iterator>
														<tr>
															<td colspan="5">
															<%@ include file="/common/shopPaging.jspf"%>
															</td>
														</tr>
													</table>
												</s:if>
												<div id="msg_frombuy">
													<font color="red" id="font1">${msg_frombuy}</font>
												</div>
											</td>
										</tr>
									</table>
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
