<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<title>评价商品、店铺</title>

<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/evaluation.css" />
<script type="text/javascript" src="${ctx}/js/pointEvaluation/makeEvaluation.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js" ></script>
<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/ypublic.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/mediaQuery.css"/>
<%@ include file="/common/topAmin.jspf" %>
<script type="text/javascript">
/* $(function(){
   	var divWidth = $("#divWidth").width();
  		 $('#divWidth').css({'height':divWidth});
	}); */
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
									<h3 class="text-center"><B>评价商品、店铺</B></h3>
									<br/>
									<s:if test="#request.ordersonId!=''">
									<div class="col-md-2 text-center hidden-xs hidden-sm">
										<a href="javascript:opendetial('${param.goodsId}','${param.shopId}');">
										<img src="${param.goodsPicture}" id="divWidth" class="img-rounded" style="width:95%;height:130px"/> 
										</br>${param.goodsName}
										</a>
									</div>
									<div class="col-xs-12 text-center hidden-md hidden-lg" >
										<a href="javascript:opendetial('${param.goodsId}','${param.shopId}');">
										<img src="${param.goodsPicture}" id="divWidth" class="img-rounded" style="width:70%;height:230px"/> 
										</br>${param.goodsName}
										</a>
									</div>
									<div class="col-md-10">
											<div class="row">
											<div  class="col-md-12">
											<table class="table-responsive " style="border:none;width:100%;height:100%;border-spacing: 0px">
												<tr>
													<td colspan="1" style="width:15%;height:45px">
														<input type="radio" value="1" id="goodspoint1" name="goodspoint" onclick="goodsRadio(1)" > 
														<img height="20px" src="${ctx}/image/evaluation/good.png" /> 
														<img height="25px" id="imgGood" src="${ctx}/image/evaluation/goodsell.png" style="display: none; " />
													</td>
													<td colspan="1" style="width:15%">
														<input type="radio" value="2" id="goodspoint2" name="goodspoint" onclick="goodsRadio(2)" > 
														<img height="20px" src="${ctx}/image/evaluation/middle.png" /> 
														<img height="25px" id="imgMiddle" src="${ctx}/image/evaluation/middlesell.png" style="display: none;" />
													</td>
													<td colspan="1" style="width:15%">
														<input type="radio" value="3" id="goodspoint3" name="goodspoint" onclick="goodsRadio(3)" > 
														<img height="20px" src="${ctx}/image/evaluation/bad.png" />
														<img height="25px" id="imgBad" src="${ctx}/image/evaluation/badsell.png" style="display: none;" />
													</td>
													<td colspan="3" class="hidden-xs">
														<label id="Ghind" style="display: none;">
														亲，好评无法修改和删除，请验货后再对商品和购物感受做出评论。</label>
														<label id="Mhind" style="display: none;">
														亲，很抱歉没能给您带来良好的购物体验，如有不满，您可联系卖家协商或发起售后维权。</label> 
														<label id="Bhind" style="display: none;">
														亲，很抱歉没能给您带来良好的购物体验，如有不满，您可联系卖家协商或发起售后维权。</label>
													</td>
												</tr>
											</table>
											</div>
											</div>
										<div class="row">
											<div class="col-md-12" >
											<textarea name="goodscontent" id="goodscontent" maxlength="333" style="width:100%;height:80px;" 
											onclick="clickgoodscontent()">亲，写点评价吧，你的评价对其他买家有很大帮助的。</textarea>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12 text-right">
											<input type="radio"	value="1" name="ispublic" onclick="checkRadio(4)">公开
											<input type="radio" value="0" name="ispublic" onclick="checkRadio(5)" checked="checked">匿名
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<hr style="width: 98%;">
										</div>
									</div>
									<div class="col-md-2 text-center">
										<table class="table-responsive " style="border:none;width:100%;height:75px;border-spacing: 0px">
											<tr>
												<td colspan="1">
													<label for="textfield"><img src="${ctx}/image/evaluation/shopDynamicPoint.png"/></label>
												</td>
											</tr>
										</table> 
								    </div>	
								    <div class="col-md-10">
										<div class="shop-rating">
											<span class="title">宝贝与描述相符：</span>
											<ul class="rating-level" id="stars1">
												<li><a class="one-star" star:value="1" href="#">1</a>
												</li>
												<li><a class="two-stars" star:value="2" href="#">2</a>
												</li>
												<li><a class="three-stars" star:value="3" href="#">3</a>
												</li>
												<li><a class="four-stars" star:value="4" href="#">4</a>
												</li>
												<li><a class="five-stars" star:value="5" href="#">5</a>
												</li>
											</ul>
											<span class="result" id="stars1-tips"></span>
											<input type="hidden" id="stars1-input" name="stars1-input" value=""
												size="2" />
										</div> <!-- # 星级评分 # star:value = 分数-->
										<div class="shop-rating">
											<span class="title">卖家的服务态度：</span>
											<ul class="rating-level" id="stars2">
												<li><a class="one-star" star:value="1" href="#">1</a>
												</li>
												<li><a class="two-stars" star:value="2" href="#">2</a>
												</li>
												<li><a class="three-stars" star:value="3" href="#">3</a>
												</li>
												<li><a class="four-stars" star:value="4" href="#">4</a>
												</li>
												<li><a class="five-stars" star:value="5" href="#">5</a>
												</li>
											</ul>
											<span class="result" id="stars2-tips"></span> 
											<input type="hidden" id="stars2-input" name="stars2-input" value="" size="2" />
										</div> <!-- END 星级评分 --> 
										<!-- # 星级评分 # star:value = 分数-->
										<div class="shop-rating">
											<span class="title">卖家发货的速度：</span>
											<ul class="rating-level" id="stars3">
												<li><a class="one-star" star:value="1" href="#">1</a>
												</li>
												<li><a class="two-stars" star:value="2" href="#">2</a>
												</li>
												<li><a class="three-stars" star:value="3" href="#">3</a>
												</li>
												<li><a class="four-stars" star:value="4" href="#">4</a>
												</li>
												<li><a class="five-stars" star:value="5" href="#">5</a>
												</li>
											</ul>
											<span class="result" id="stars3-tips"></span> 
											<input type="hidden" id="stars3-input" name="stars3-input" value=""
												size="2" />
										</div> <!-- END 星级评分 --> 
									 	<script type="text/javascript">
											var Class = {
												create : function() {
													return function() {
														this.initialize.apply(this,
																arguments);
													}
												}
											}
											var Extend = function(destination, source) {
												for ( var property in source) {
													destination[property] = source[property];
												}
											}
											function stopDefault(e) {
												if (e && e.preventDefault) {
													e.preventDefault();
												} else {
													window.event.returnValue = false;
												}
												return false;
											}
											/** * 星星打分组件 * * @author Yunsd * @date 2010-7-5 */
											var Stars = Class.create();
											Stars.prototype = {
												initialize : function(star, options) {
													this.SetOptions(options);
													//默认属性 
													var flag = 999; //定义全局指针 
													var isIE = (document.all) ? true
															: false; //IE? 
													var starlist = document.getElementById(
															star).getElementsByTagName('a'); //星星列表 
													var input = document
															.getElementById(this.options.Input)
															|| document.getElementById(star
																	+ "-input"); // 输出结果 
													var tips = document
															.getElementById(this.options.Tips)
															|| document.getElementById(star
																	+ "-tips"); // 打印提示 
													var nowClass = " "
															+ this.options.nowClass; // 定义选中星星样式名
													var tipsTxt = this.options.tipsTxt; // 定义提示文案 
													var len = starlist.length; //星星数量 
													for (i = 0; i < len; i++) {
														// 绑定事件 点击 鼠标滑过 
														starlist[i].value = i;
														starlist[i].onclick = function(e) {
															stopDefault(e);
															this.className = this.className
																	+ nowClass;
															flag = this.value;
															input.value = this
																	.getAttribute("star:value");
															tips.innerHTML = tipsTxt[this.value]
														}
														starlist[i].onmouseover = function() {
															if (flag < 999) {
																var reg = RegExp(nowClass,
																		"g");
																starlist[flag].className = starlist[flag].className
																		.replace(reg, "")
															}
														}
														starlist[i].onmouseout = function() {
															if (flag < 999) {
																starlist[flag].className = starlist[flag].className
																		+ nowClass;
															}
														}
													}
													;
													if (isIE) {
														//FIX IE下样式错误 
														var li = document.getElementById(
																star).getElementsByTagName(
																'li');
														for ( var i = 0, len = li.length; i < len; i++) {
															var c = li[i];
															if (c) {
																c.className = c
																		.getElementsByTagName('a')[0].className;
															}
														}
													}
												},
												//设置默认属性 
												SetOptions : function(options) {
													this.options = {
														//默认值
														Input : "",
														//设置触保存分数的
														Tips : "",//设置提示文案容器 
														nowClass : "current-rating",
														//选中的样式名 
														tipsTxt : [
																"1分 - 卖家态度很差，还骂人说脏话，简直不把顾客当回事",
																"2分 - 卖家有点不耐烦，承诺的服务也兑现不了",
																"3分 - 卖家回复问题很慢，态度一般，谈不上沟通顺畅",
																"4分 - 卖家服务挺好的，沟通挺顺畅的，总体满意",
																"5分 - 卖家的服务太棒了，考虑非常周到，完全超出期望值" ]
													//提示文案 
													};
													Extend(this.options, options || {});
												}
											}
											/* For TEST */
											function teststars() {
												alert(document
														.getElementById("stars1-input").value
														+ "|"
														+ document
																.getElementById("stars2-input").value
														+ "|"
														+ document
																.getElementById("stars3-input").value)
											}
											var Stars1 = new Stars("stars1", {
												nowClass : "current-rating",
												tipsTxt : [ "1分 - 差得太离谱，与卖家描述的严重不符，非常不满",
														"2分 - 部分有破损，与卖家描述的不符，不满意",
														"3分 - 质量一般，没有卖家描述的那么好",
														"4分 - 质量不错，与卖家描述的基本一致，还是挺满意的",
														"5分 - 质量非常好，与卖家描述的完全一致，非常满意" ]
											});
											var Stars2 = new Stars("stars2");
											var Stars3 = new Stars("stars3", {
												nowClass : "current-rating",
												tipsTxt : [ "1分 - 再三提醒下，卖家才发货，耽误时间，包装也很马虎",
														"2分 - 卖家发货有点慢的，催了几次终于发货了",
														"3分 - 卖家发货速度一般，提醒后才发货的",
														"4分 - 卖家发货挺及时的，运费收取很合理",
														"5分 - 卖家发货速度非常快，包装非常仔细、严实" ]
											});
										</script>
								    </div>	
									<div class="row">
										<div class="col-md-12">
											<hr style="width: 98%;">
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 text-center">
										<img id="imgSubmit"  style="CURSOR: pointer"
											src="${ctx}/image/evaluation/submit.png" onclick="ok();" />
										<img id="imgSubmitNo"
											src="${ctx}/image/evaluation/submit.png" style="display:none" />
										</div>
									</div>
									</s:if>
									
									<s:if test="#request.ordersonId!=''&&#request.shopId!=''&&#request.goodsId!=''">
									<table width="600" align="center" style="display:none;">
										<tr>
											<td align="center">子订单号：<input type="text" name="ordersonId"
												id="ordersonId" value="${param.ordersonId}" style="background:#CCCCCC"
												readonly="readonly"></td>
										</tr>
										<tr>
											<td align="center" style="display:none;">店铺号：<input
												type="text" name="shopId" id="shopId" value="${param.shopId}"
												readonly="readonly" style="background:#CCCCCC"></td>
										</tr>
										<tr>
											<td align="center" style="display:none;">商品号：<input
												type="text" name="goodsId" id="goodsId" value="${param.goodsId}"
												readonly="readonly" style="background:#CCCCCC"></td>
										</tr>
									</table>
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
