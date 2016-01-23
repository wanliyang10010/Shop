<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品添加</title>
<link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css" />
	<%@ include file="/common/top-head.jspf"%>  
<script type="text/javascript" src="${ctx}/js/web1.js"></script>
<script type="text/javascript" src="${ctx}/js/Goods/GoodsView.js"></script>

</head>
<body>
<div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
<div id="templatemo_main">
	<center>
		<form name="form1" action="" id="form1">
		<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
	  <input type="hidden" name="goodsId" id="goodsId" value="${sessionScope.goodsAdd.goodsid}"/>
	  <input type="hidden" name="shopId" id="shopId" value="${shop.shopId}"/>
<h2> 商品添加成功</h2> 
			 <table width="400"   border="1">
			 <tr>
					<td align="right" colspan="2">
					 <a href="${ctx}/goodsTypeAction_getListByShop.action">继续添加商品</a></td>
				</tr>
			 <tr>
					<td align="center" colspan="2">
					<font color="red" id="font1" >商品添加成功，您还可以点击以下链接完善商品信息！</font></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
					    <a href="javascript:AddItem('${sessionScope.goodsAdd.typeid}','${sessionScope.goodsAdd.goodsid}');">完善商品属性</a>---------
						<a href="javascript:AddFile('${sessionScope.goodsAdd.goodsid}');">上传商品图片</a>---------
                         <a href="javascript:AddStock('${sessionScope.goodsAdd.goodsid}');">添加库存明细</a>
				</tr>
				<tr>
					<td align="right" width="30%"><label for="textfield">商品名称：</label></td>
					<td align="left">${sessionScope.goodsAdd.goodsname}</td>
				</tr>
				<tr>
					<td align="right" width=30%><label for="textfield">商品单价(元)：</label></td>
					<td align="left" width="30%">${sessionScope.goodsAdd.price}</td>
				</tr>
				<tr>
					<td align="right" width="30%"><label for="textfield">运费(元)：</label></td>
					<td align="left">${sessionScope.goodsAdd.freight}</td>
				</tr>
				<tr>
					<td align="right" width="30%"><label for="textfield">库存量：</label></td>
					<td align="left">${sessionScope.goodsAdd.amount}</td>
				</tr>
				
			
			</table>
			<div>
		</form>
	</center>
	</div>
</body>
</html>
