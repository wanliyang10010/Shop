<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>

<!-- 
<c:if test="${listItem==null}">
	<s:action name="viewProductAction_MyShop"/>
</c:if>
 -->
<base href="<%=basePath%>">
<title>创业平台</title>
<%@ include file="/common/top-head.jspf"%>
<link rel="stylesheet" href="css/h5css/style.css" media="screen" type="text/css" />
<script type="text/javascript" src="${ctx}/js/ViewGoods/ViewProduct.js"></script>
</head>
<body>
 	<div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
	<div id="templatemo_main">
		<div id="sidebar" class="float_l">
			<div class="sidebar_box">
				<span class="bottom"></span>
				<h3 align="left">商品列表 </h3>
				<div class="content">
					<ul class="sidebar_list">
						<c:forEach items="${listItem}" var="item" varStatus="s">
						<c:if test="${s.count<9}">
							<li><a href="viewProductAction_type.do?type=${item.itemname}">${item.itemname}</a></li>
						</c:if>
						</c:forEach>
						<c:forEach items="${listItem}" var="item" varStatus="s">
						<c:if test="${s.count==1}">
							<li><a href="viewProductAction_type.do?type=${item.itemname}">更多类别</a></li>
						</c:if>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div></div>
			<div class="sidebar_box">
				<span class="bottom"></span>
				<h3 align="left">
					畅销 <a href="${ctx}/viewProductAction_listSale.do?keyword=""">更多畅销</a>
				</h3>
				<div class="content">
					<s:iterator value="#request.pageSale" status="s">
						<div class="bs_box">
							<a href="javascript:opendetial('${goodsid}','${shop.shopId}');">
								<img height="180" width="180" src="${ctx}${goodsPicture.url}"/> 
							</a>
							<h4>
								<a href="javascript:opendetial('${goodsid}','${shop.shopId}');">${goodsname}</a>
							</h4>
							<c:choose>
								<c:when test="${discount.discountId>0}">
								<p >原价：${price}</p>
								<p> <lable: class="price">促销价：${discount.price}</lable:></p>
								</c:when>
								<c:otherwise>
									<p class="price">价格：${price}</p>
								</c:otherwise>
							</c:choose>
							<div class="cleaner"></div>
						</div>
					</s:iterator>
				</div>
			</div>
		</div>
		<div id="content" class="float_r">
			<div id="slider-wrapper">
				<div id="slider" class="nivoSlider">
					<c:choose>
						<c:when test="${request.pageTop!= null&&request.pageTop.getTotalItems()>0}">
							<s:iterator value="#request.pageTop" status="s">
							<a href="javascript:opendetial('${goodsid}','${shop.shopId}');">
							<img width="500px"  height="300px" src="${ctx}${goodsPicture.url}" title="${goodsname}"/> </a>
							</s:iterator>
						</c:when>
						<c:otherwise>
							<img src="image/slider/02.jpg" alt="" title="默认首页商品，只供参考" />
                		    <a href="#"><img src="image/slider/01.jpg" alt="" title="默认首页商品，只供参考" /></a>
                    		<img src="image/slider/03.jpg" alt="" title="默认首页商品，只供参考" />
                    		<img src="image/slider/04.jpg" alt=""  title="默认首页商品，只供参考" />
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<script type="text/javascript" src="${ctx}/js/MyShop/jquery-1.4.3.min.js"></script>
				
			<script type="text/javascript" src="${ctx}/js/MyShop/jquery.nivo.slider.pack.js"></script>
			<script type="text/javascript">		
				$(window).load(function() {
					$('#slider').nivoSlider();
				});
			</script>
			<h3 align="left">
				特价 <a href="${ctx}/viewProductAction_productD.do">更多特价</a>
			</h3>
			<s:iterator value="#request.pageDiscount" status="s">
				<c:choose>
					<c:when test="${s.count<3}">
						<div class="product_box">
							<a href="javascript:opendetial('${goodsid}','${shop.shopId}');">
								<img height="150" width="150" src="${ctx}${goodsPicture.url}" />
							</a>
							<p>
								<a href="javascript:opendetial('${goodsid}','${shop.shopId}');">${goodsname}</a>
							</p>
							<c:choose>
								<c:when test="${discount.discountId>0}">
									<p >原价：${price} <lable: class="product_price">促销价：${discount.price}</lable:></p>
								</c:when>
								<c:otherwise>
									<p class="product_price">价格：${price}</p>
								</c:otherwise>
							</c:choose>
							</p>
						</div>
					</c:when>
					<c:when test="${s.count==3}">
						<div class="product_box no_margin_right">
							<a href="javascript:opendetial('${goodsid}','${shop.shopId}');">
								<img height="150" width="150" src="${ctx}${goodsPicture.url}" />
							</a>
							<p>
								<a href="javascript:opendetial('${goodsid}','${shop.shopId}');">${goodsname}</a>
							</p>
							<c:choose>
								<c:when test="${discount.discountId>0}">
									<p >原价：${price} <lable: class="product_price">促销价：${discount.price}</lable:></p>
								</c:when>
								<c:otherwise>
									<p class="product_price">价格：${price}</p>
								</c:otherwise>
							</c:choose>
							</p>
						</div>
					</c:when>
				</c:choose>
			</s:iterator>
			<div class="cleaner"></div>
			<h3 align="left">
				热卖 <a href="${ctx}/viewProductAction_productH.do">更多热卖</a>
			</h3>
			<s:iterator value="#request.pageHot" status="s">
				<c:choose>
					<c:when test="${s.count<3}">
						<div class="product_box">
							<a href="javascript:opendetial('${goodsid}','${shop.shopId}');">
								<img height="150" width="150" src="${ctx}${goodsPicture.url}" />
							</a>
							<p>
								<a href="javascript:opendetial('${goodsid}','${shop.shopId}');">${goodsname}</a>
							</p>
							<c:choose>
								<c:when test="${discount.discountId>0}">
									<p >原价：${price} <lable: class="product_price">促销价：${discount.price}</lable:></p>
								</c:when>
								<c:otherwise>
									<p class="product_price">价格：${price}</p>
								</c:otherwise>
							</c:choose>
							</p>
						</div>
					</c:when>
					<c:when test="${s.count==3}">
						<div class="product_box no_margin_right">
							<a href="javascript:opendetial('${goodsid}','${shop.shopId}');">
								<img height="150" width="150" src="${ctx}${goodsPicture.url}" />
							</a>
							<p>
								<a href="javascript:opendetial('${goodsid}','${shop.shopId}');">${goodsname}</a>
							</p>
							<c:choose>
								<c:when test="${discount.discountId>0}">
									<p >原价：${price} <lable: class="product_price">促销价：${discount.price}</lable:></p>
								</c:when>
								<c:otherwise>
									<p class="product_price">价格：${price}</p>
								</c:otherwise>
							</c:choose>
							</p>
						</div>
					</c:when>
				</c:choose>
			</s:iterator>
		</div>
		<div class="cleaner"></div>
	</div>
	<!-- END of templatemo_main -->
</body>
 <script type="text/javascript">
$("img").each(function(){
  this.onerror=function(){
    this.src="image/picerror.jpg";
 };
});
</script>
</html>