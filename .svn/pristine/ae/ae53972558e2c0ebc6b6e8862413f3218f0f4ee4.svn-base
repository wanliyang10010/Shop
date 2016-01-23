<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看物流信息</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css"  href="${ctx}/css/noneBorder.css"> 
<script type="text/javascript" src="${ctx}/My97DatePicker/WdatePicker.js"> </script>
<script type="text/javascript" src="${ctx}/js/haveBuyGoods/viewTrans.js"> </script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			 &nbsp; &nbsp;&nbsp;<h3>查看物流信息</h3>
			 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
		<s:if test="#request.order!= null">
		<s:iterator value="#request.order" status="s">	
		     <table width="800px" align="center">
					<tr style="background:#BFDBEB">
						<td align="center" width=10%>订单号</td>
						<td align="center" width=10%>购买人</td>
						<td align="center" width=18%>购买时间</td>
						<td align="center" width=18%>店铺名称</td>
						<td align="center" width=12%>商品详情</td>
						<td align="center" width=12%>订单金额（元）</td>												
						<td align="center" width=20%>备注</td>					
					</tr>
					<tr>
						<td align="center">${orderid}</td>
						<td align="center">${user.username}</td>
						<td align="center">${fn:substring(buytime,0,19)}</td>
						<td align="center">
						<a href="${ctx}/viewProductAction_shop.do?shopid=${shop.shopId}"  target="_blank">
								${shop.shopname}</a>
						</td>
											
						<td align="center">					
					<s:iterator value="%{sons}" status="s">		
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
					<td align="center">${ftotal}</td>
					<td align="center">${remark}</td>
					</tr>
					<tr>
					<td align="right" colspan="2"><label for="textfield">物流公司：</label>
					</td>
					<td align="left" colspan="5"><input type="text" name="transcompany" id="transcompany"
						size="80" maxlength="33" value="${transcompany}" readonly="readonly"
						style="background:#CCCCCC">
					</td>
				</tr>
				<tr>
					<td align="right" colspan="2"><label for="textfield">物流单号：</label>
					</td>
					<td align="left" colspan="5"><input type="text" name="transnumber" id="transnumber"
						size="80" maxlength="33" value="${transnumber}" readonly="readonly"
						style="background:#CCCCCC">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="7">
						<button id="btn_submit" type="button" style="width:120px;"
							onclick="location.href='javascript:history.go(-1);'">返回上一页</button>
					</td>					
				</tr>
				</table>
				
				</s:iterator>
			</s:if>						
		</form>
	</center>
</div>
</body>
</html>
