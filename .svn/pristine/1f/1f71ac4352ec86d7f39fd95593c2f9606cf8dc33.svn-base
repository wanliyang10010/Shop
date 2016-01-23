<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!DOCTYPE HTML>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>店铺收藏夹</title>
	<%@ include file="/common/top-head.jspf" %>
	<link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css" />
	<link rel="stylesheet" type="text/css"  href="${ctx}/css/favourite/favshop.css" media=screen />
</head>
<body>
	<div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf" %>
	</div>
	<div id="templatemo_main">
	<br/>
    <center>
	<form id="form1" action="${ctx}/order/favouriteShopAction!list.action"  method="post">
		<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid }" />
	    <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	    <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
	</form>
	<h3>我收藏的店铺</h3>
	<table width="600px">
		<thead>
			<tr>
				<th>序号</th>
				<th>店铺名称</th>
				<th>店铺类别</th>
				<th>店铺状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<s:if test="#request.page.totalItems <= 0">
			<tr><td colspan="5">还没有收藏任何店铺!</td></tr>
			</s:if>
			<s:else>
			<s:iterator value="#request.page" status="s">
				<tr>
					<td>${s.count}</td>
					<td><a href="${ctx }/viewProductAction_shop.action?shopid=${shop.shopId}" target="_blank">${shop.shopname}</a></td>
					<td>${shop.shopcategory}</td>
					<td><s:if test="%{shop.shopstate==\"0\"}">店铺冻结</s:if> <s:if test="%{shop.shopstate==\"1\"}">店铺正常</s:if></td>
					<td><a href="javascript:deleteFavouriteShop(${favouriteshopId});">删除</a></td>
				</tr>
			</s:iterator>
		 	</s:else>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5"><%@ include file="/common/pagination.jspf" %></td>
			</tr>
		</tfoot>
	</table>
	</center>
	<br/><br/>
	</div>
	<footer>
		<script type="text/javascript" src="${ctx}/js/web1.js"></script>
		<script type="text/javascript" src="${ctx}/js/favourite/favo.js"></script>
	</footer>
</body>
</html>