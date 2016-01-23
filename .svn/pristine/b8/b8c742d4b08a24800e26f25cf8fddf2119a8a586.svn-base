<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填写退货运单信息</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
 <link rel="stylesheet" type="text/css"  href="${ctx}/css/haveBorder.css"> 
<script type="text/javascript"	src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/returnGoods/transInfoReturn.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			 &nbsp; &nbsp;&nbsp;<h3>填写退货运单信息</h3>
			 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			 <input type="hidden"  name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	    <input type="hidden"  name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
			 <%@ include file="/common/searchByDate.jspf" %>
			<div id="msg_writeover">
				<font color="red" id="font1">${msg_writeover}</font>
			</div>
				<s:if test="#request.page!= null&&#request.page.getTotalItems()>0">
				<table width="800px" align="center">
					<tr id="trMain" style="background:#BFDBEB;">
						<td align="center" width=5%>序号</td>
						<td align="center" width=10%>申请人</td>
						<td align="center" width=15%>申请时间</td>
						<td align="center" width=20%>申请理由</td>
						<td align="center" width=11%>店铺名称</td>
						<td align="center" width=7%>订单号</td>
						<td align="center" width=10%>订单金额</td>
						<td align="center" width=12%>商品详情</td>
						<td align="center" width=10%>填写物流信息</td>
						<td align="center" width=1% style="display:none">ID</td>
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
							
							<td align="center"><a
								href="javascript:lbtDetail('${returngoodsId}',
			    				'${order.orderid}','${s.count}');">填写</a>
							</td>
							<td align="center" style="display:none">${returngoodsId}</td>
						</tr>
					</s:iterator>
					<tr><td colspan="10">
				  <%@ include file="/common/shopPaging.jspf" %>
				  </td></tr>
				</table>
			</s:if>
			<div id="msg_searchMyPassList">
				<font color="red" id="font1">${msg_searchMyPassList}</font>
			</div>
			
			<table width="800px" align="center" colspan="2" border="1"
				id="tbDetail" style="display: none">

				<tr>
					<td align="right" width="150px"><label for="textfield">订单编号：</label>
					</td>
					<td align="left" width="450px"><input type="text"
						name="orderId" id="orderId" size="70" maxlength="30"
						value="${param.orderId}" readonly="readonly"
						style="background:#CCCCCC">
					</td>
				</tr>
				
				<tr>
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">物流公司：</label>
					</td>
					<td align="left"><input type="text" name="logisticscompany" id="logisticscompany"
						 size="70" maxlength="30">
					</td>
				</tr>
				<tr>
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">物流单号：</label>
					</td>
					<td align="left"><input type="text" name="logisticsnum" id="logisticsnum"
						onkeyup="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; " size="70" maxlength="30" >
					</td>
				</tr>
				<tr style="display:none">
					<td></td>
					<td><input type="number" name="returngoodsId" id="returngoodsId"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button id="btn_submit" type="button" style="width:80px;" onclick="transInfo();">确定</button>
						&nbsp; &nbsp;&nbsp;
						<button id="btn_cancel" type="reset" style="width:80px;"
							onclick="cancel()">取消</button>
					</td>
				</tr>
			</table>
		</form>
	</center>
	</div>
</body>
</html>
