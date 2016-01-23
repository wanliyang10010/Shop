<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>审核退货</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/haveBorder.css">
<script type="text/javascript"
	src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/returnGoods/checkReturn.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			 &nbsp; &nbsp;&nbsp;<h3>审核退货</h3>
			 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			 <input type="hidden"  name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	    <input type="hidden"  name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
			 <%@ include file="/common/searchByDate.jspf" %>
			<div id="msg_checkover">
				<font color="red" id="font1">${msg_checkover}</font>
			</div>
				<s:if test="#request.page!= null&&#request.page.getTotalItems()>0">
				<table width="800px" align="center">
					<tr id="trMain" style="background:#BFDBEB;">
						<td align="center" width=5%>选择</td>
						<td align="center" width=5%>序号</td>
						<td align="center" width=10%>申请人</td>
						<td align="center" width=20%>申请时间</td>
						<td align="center" width=15%>店铺名称</td>
						<td align="center" width=10%>订单号</td>
						<td align="center" width=10%>订单金额</td>
						<td align="center" width=15%>商品详情</td>
						<td align="center" width=10%>退货详情</td>
						<td align="center" width=1% style="display:none">ID</td>
					</tr>
					<s:iterator value="#request.page" status="s">
						<s:if test="%{returngoodsId==(#request.returnId)}">
						<tr id="tr${s.count}" style="background:#BFEFFF">	
						</s:if>
						<s:else>
						<tr id="tr${s.count}">
						</s:else>
							<td align="center"><input type="checkbox" name="ckbox"
								id="ckbox${s.count}" value="${returngoodsId}" />
							</td>
							<td align="center">${s.count+(page.pageNo-1)*page.pageSize}</td>
							<td align="center">${userinfo.username}</td>
							<td align="center">${applyTime}</td>
							<td align="center">
							<a href="${ctx}/viewProductAction_shop.do?shopid=${shop.shopId}"  target="_blank">
								${shop.shopname}</a>
								</td>
							
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
								href="javascript:lbtDetail('${order.orderid}',
			    				'${reason}','${s.count}','${page.getResult().size()}','${order.addr}');">详情</a>
							</td>
							<td align="center" style="display:none">${returngoodsId}</td>
						</tr>
					</s:iterator>
					<tr><td colspan="10">
				  <%@ include file="/common/shopPaging.jspf" %>
				  </td></tr>
				</table>

				<table width="800px" align="center" colspan="2" border="1"
					id="tbDetail" style="display: none">
					<tr>
						<td align="right" width="150px"><label for="textfield">订单编号：</label>
						</td>
						<td align="left" width="450px"><input type="text"
							name="orderId" id="orderId" size="80" maxlength="30"
							value="${param.orderId}" readonly="readonly"
							style="background:#CCCCCC">
						</td>
					</tr>
					
					<tr>
					<td align="right" width="150px"><label for="textfield">收货地址：</label>
					</td>
					<td align="left" width="450px"><input type="text"
						name="addr" id="addr" size="80" maxlength="30"
						value="${param.addr}" readonly="readonly"
						style="background:#CCCCCC">
					</td>
					</tr>
				
					<tr>
						<td align="right"><label for="textfield">申请理由：</label>
						</td>
						<td align="left"><input type="text" name="reason" id="reason"
							size="80" maxlength="30" value="${param.reason}"
							readonly="readonly" style="background:#CCCCCC">
						</td>
					</tr>
				</table>
				<table width="800px" id="tbCheck" style="display: ">
					<tr>
						<td align="left" style="background:#E0FFFF"><label
							for="textfield">审核意见：</label>
						</td>
					</tr>
					<tr>
						<td align="left"><input type="text" name="checkIdea"
							id="checkIdea" maxlength="57" 
							style="width:100%;height:50px">
						</td>
					</tr>
					<tr>
						<td align="center">
							<button id="btn_pass" type="button" onclick="pass(${page.getResult().size()});"
								style="width:100px;">审核通过</button> &nbsp; &nbsp;&nbsp;
							<button id="btn_notpass" type="button"
								onclick="notpass(${page.getResult().size()});" style="width:100px;">审核不通过</button>
						</td>
					</tr>
				</table>				
<!-- 				<input type="text" name="dd"
							id="dd" maxlength="57" 
							style="width:100%;height:50px">
						<textarea></textarea>	 -->
				<span style="color:red;font-size:14px;font-weight: bold;display:-moz-inline-box;display:inline-block;width:800px;margin-top:15px">
			（友情提示：当前页面被选中（即被打钩）的每条申请均会被同时审核！为了防止误操作，如果翻页，则翻页之前的选中项将被取消，如果需要选中的申请条数过多，请将每页显示的条数增大！谢谢合作。）</span>
			</s:if>
			<div id="msg_searchMyCheckList">
				<font color="red" id="font1">${msg_searchMyCheckList}</font>
			</div>
		</form>
	</center>
	</div>
</body>
</html>
