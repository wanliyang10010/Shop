<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="owner" content="" />
<meta name="robots" content="index, follow" />
<meta name="googlebot" content="index, follow" />
<title>评价商品、店铺</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/evaluation.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/noneBorder.css">
<script type="text/javascript"
	src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/pointEvaluation/makeEvaluation.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			 &nbsp; &nbsp;&nbsp;<h3>评价商品、店铺</h3>
			 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			<s:if test="#request.ordersonId!=''">
				<table width="800px" align="center" colspan="2" id="goodsDetail">
					<tr>
						<td align="center" style="height:160px;width:160px" colspan="1"
							rowspan="3">
							<a href="javascript:opendetial('${param.goodsId}','${param.shopId}');">
							<img src="${param.goodsPicture}" style="width: 100%;height: 85%" /> </br>${param.goodsName}</td>
						<td align="left" style="height:40px;width:640px" colspan="1" rowspan="1">
							<table colspan="6" style="width:100%;height:100%">
								<tr>
									<td colspan="1" style="width:95px">
									<input type="radio" value="1" id="goodspoint1" name="goodspoint"
										onclick="goodsRadio(1)" > 
									<img height="20px" src="${ctx}/image/evaluation/good.png" /> 
									<img height="25px" id="imgGood" 
									src="${ctx}/image/evaluation/goodsell.png" style="display: none;" />
									</td>
									<td colspan="1" style="width:95px">
									<input type="radio" value="2" id="goodspoint2" name="goodspoint" onclick="goodsRadio(2)"> 
									<img height="20px" src="${ctx}/image/evaluation/middle.png" /> 
									<img height="25px" id="imgMiddle" src="${ctx}/image/evaluation/middlesell.png"
										style="display: none;" />
									</td>
									<td colspan="1" style="width:95px">
									<input type="radio" value="3" id="goodspoint3" name="goodspoint"
										onclick="goodsRadio(3)"> 
									<img height="20px" src="${ctx}/image/evaluation/bad.png" />
									<img height="25px" id="imgBad" src="${ctx}/image/evaluation/badsell.png"
										style="display: none;" />
									</td>
									<td colspan="3">
									<label id="Ghind" style="display: none;font-size: 14">
										亲，好评无法修改和删除，请验货后再对商品和购物感受做出评论。</label>
									<label id="Mhind" style="display: none;font-size: 14">
										亲，很抱歉没能给您带来良好的购物体验，如有不满，您可联系卖家协商或发起售后维权。</label> 
									<label id="Bhind" style="display: none;font-size: 14">
										亲，很抱歉没能给您带来良好的购物体验，如有不满，您可联系卖家协商或发起售后维权。</label>
									</td>
								</tr>
							</table>
							</td>
					</tr>
					<tr>
						<td align="center" style="height:70px;width:640px" colspan="1" rowspan="1">
						<textarea name="goodscontent" id="goodscontent" maxlength="333" 
						 style="width:100%;height:70px;font-size: 14" 
						 onclick="clickgoodscontent()">亲，写点评价吧，你的评价对其他买家有很大帮助的。</textarea>
						</td>
					</tr>
					<tr>
						<td style="height:40px;width:640px" colspan="1" rowspan="1">
							<table colspan="2" style="width: 100%;height: 100%">
								<tr>
									<%-- <td colspan="1" align="left"><img height="20px"
										src="${ctx}/image/evaluation/upPicture.png"/>
										 <img height="20px"
										src="${ctx}/image/evaluation/phoneUpPicture.png" /></td> --%>
									<td colspan="2" align="right"><input type="radio"
										value="1" name="ispublic" onclick="checkRadio(4)">公开 <input
										type="radio" value="0" name="ispublic" onclick="checkRadio(5)"
										checked="checked">匿名</td>
								</tr>
							</table></td>
					</tr>
				</table>

				<table width="800px" align="center" colspan="2" id="shopDetail">
					</br>
					<hr width="800px">
					<tr>
						<td align="center" style="height:160px;width:160px;">
						<label for="textfield"> <img src="${ctx}/image/evaluation/shopDynamicPoint.png"/></label>
						</td>
						<td align="left" style="height:160px;width:640px">
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
								<span class="result" id="stars1-tips"></span> <input
									type="hidden" id="stars1-input" name="stars1-input" value=""
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
								<span class="result" id="stars2-tips"></span> <input
									type="hidden" id="stars2-input" name="stars2-input" value=""
									size="2" />
							</div> <!-- END 星级评分 --> <!-- # 星级评分 # star:value = 分数-->
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
								<span class="result" id="stars3-tips"></span> <input
									type="hidden" id="stars3-input" name="stars3-input" value=""
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
							</td>
					</tr>
				</table>

				<table width="800px" align="center" id="tbDetail" style="display: ">
					<hr width="800px">
					<tr>
						<td align="center">
						<img id="imgSubmit"  style="CURSOR: pointer"
							src="${ctx}/image/evaluation/submit.png" onclick="ok();" />
						<img id="imgSubmitNo"
							src="${ctx}/image/evaluation/submit.png" style="display:none" />
						</td>
					</tr>
				</table>
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
		</form>
	</center>
</div></body>
</html>
