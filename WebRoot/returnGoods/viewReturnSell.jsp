<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>卖家退货信息查看</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
 <link rel="stylesheet" type="text/css"  href="${ctx}/css/haveBorder.css"> 
<script type="text/javascript"	src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/returnGoods/viewReturnSell.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			 &nbsp; &nbsp;&nbsp;<h3>卖家退货信息查看</h3>
			 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			 <input type="hidden"  name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	    <input type="hidden"  name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
			 <%@ include file="/common/searchByDate.jspf" %>
			<s:if test="#request.page!= null&&#request.page.getTotalItems()>0">
			<table width="800px" align="center">
				<tr id="trMain" style="background:#BFDBEB;">
				<td align="center" width=5%>序号</td>
				<td align="center" width=10%>申请人</td>
				<td align="center" width=15%>申请时间</td>
                   <td align="center" width=20%>申请理由</td>
                   
                    <td align="center" width=10%>店铺名称</td>
				<td align="center" width=7%>订单号</td>
				<td align="center" width=8%>订单金额</td>
				<td align="center" width=13%>商品详情</td>
				
				<td align="center" width=12%>状态</td>		
				</tr>
				<s:iterator value="#request.page" status="s">
				<s:if test="%{returngoodsId==(#request.returnId)}"> 				
				<tr id="tr${s.count}" style="background:#BFEFFF">	
				</s:if>
				<s:else>
				<tr id="tr${s.count}">
				</s:else>
					<td align="center">${s.count+(page.pageNo-1)*page.pageSize}</td>
					<td align="center">${userinfo.username}</td>
					<td align="center">${applyTime}</td>					
					<td align="center">${reason}</td>
					
					<td align="center"><a href="${ctx}/viewProductAction_shop.do?shopid=${shop.shopId}"  target="_blank">
								${shop.shopname}</a></td>
					<td align="center">${order.orderid}</td>
					<td align="center">${order.ftotal}</td>
					<td align="center">
					
					<s:iterator value="%{order.sons}" status="s">					
					<a href="javascript:opendetial('${goods.goodsid}','${goods.shop.shopId}');">
					${goodsName}
					<s:if test="%{property!=null}">
					</br>${property} 
					</s:if>
					<s:if test="%{order.sons.size()>1}">
					</br> 
					</s:if>
					</s:iterator>
					</td>	
							
					<td align="center">
					<s:if test="%{state==\"0\"}">待审核</s:if>
					<s:if test="%{state==\"1\"}">审核已通过</s:if>
					<s:if test="%{state==\"2\"}">审核未通过</s:if>
					<s:if test="%{state==\"3\"}">已填写物流信息</s:if>
					<s:if test="%{state==\"4\"}">已收货并且退费</s:if>
					</td>			
				</tr>
				</s:iterator>
				 <tr><td colspan="9">
				  <%@ include file="/common/shopPaging.jspf" %>
				  </td></tr>
			</table>
				</s:if>
			<div id="msg_searchMyViewList">
				<font color="red" id="font1">${msg_searchMyViewList}</font>
			</div>
		</form>
	</center>
	</div>
</body>
</html>
