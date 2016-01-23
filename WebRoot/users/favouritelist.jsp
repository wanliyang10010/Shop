<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>收藏夹</title>
	<%@ include file="/common/top-head.jspf" %>
	<link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css" />
	<link rel="stylesheet" type="text/css"  href="${ctx}/css/favourite/fav.css" media=screen />
</head>
<body style="text-align: center;">
	<div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf" %>
	</div>
	<div id="templatemo_main">
	<br/>
    <center>
	<center><h3>我的收藏商品</h3></center>
	<form id="form1" method="post">
		<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}" />
	    <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	    <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
		<table>
			<thead>
				<tr>
					<th width="50px">序号</th>
					<th colspan="2">商品名称</th>
					<th>商品价格</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:if test="#request.page.totalItems <= 0">
					<tr><td colspan="5">还没有收藏任何商品!</td></tr>
				</s:if>
				<s:else>
				<s:iterator value="#request.page" status="s">
					<tr>
						<td><s:property value="#s.index + 1"/></td>
						<td width="80px"><a href="${productUrl}" target="_blank"><img height="80px"  width="80px" src="${ctx}${good.goodsPicture.url}"/></a></td>
						<td><a href="${productUrl}" target="_blank">${good.goodsname}</a></td>
						<td>
							<c:choose>
								<c:when test="${good.discount == null}">${good.price}</c:when>
								<c:otherwise>${good.discount.price}</c:otherwise>
							</c:choose>
							</td>
						<td>
						  <a onclick="javascript:deleteFavourite(${favouriteId});" href="javascript:void(0);">删除</a>
						</td>
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
	</form>
	</center>
	<br /><br />
	</div>
	<footer>
		<script type="text/javascript" src="${ctx}/js/web1.js"></script>
		<script type="text/javascript" src="${ctx}/js/favourite/favo.js"></script>
	</footer>
</body>
</html>