<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改退货申请</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css"  href="${ctx}/css/haveBorder.css"> 
<script type="text/javascript"	src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/returnGoods/alterReturn.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			 &nbsp; &nbsp;&nbsp;<h3>修改退货申请</h3>
			 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			 <input type="hidden"  name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	   		 <input type="hidden"  name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
		 <%@ include file="/common/searchByDate.jspf" %>
			<div id="msg_alterover">
				<font color="red" id="font1">${msg_alterover}</font>
			</div>
				<s:if test="#request.page!= null&&#request.page.getTotalItems()>0">
			<table width="800px" align="center">
				<tr id="trMain" style="background:#BFDBEB;">
					<td align="center" width=5%>序号</td>
					<td align="center" width=10%>申请人</td>
					<td align="center" width=20%>申请时间</td>
					<td align="center" width=16%>店铺名称</td>
					<td align="center" width=8%>订单号</td>
					<td align="center" width=8%>订单金额</td>
					<td align="center" width=13%>商品详情</td>
					<td align="center" width=10%>退货详情</td>
					<td align="center" width=10%>删除</td>
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
						href="javascript:lbtDetail('${returngoodsId}',
			    				'${order.orderid}',
			    				'${reason}','${checkIdea}','${s.count}','${order.addr}');">详情</a>
					</td>
					<td align="center">
					<ahref="javascript:deletereturnGoods('${returngoodsId}','${order.orderid}');">删除</a></td>
					<td align="center" style="display:none">${returngoodsId}</td>
				</tr>
				</s:iterator>
				 <tr>
				 <td colspan="10">
				  <%@ include file="/common/shopPaging.jspf" %>
				  </td>
				  </tr>
			</table>
				</s:if>
			<div id="msg_searchMyAlterList">
				<font color="red" id="font1">${msg_searchMyAlterList}</font>
			</div>

			<table width="800px" id="tbCheck" style="display: none">
				<tr>
					<td align="left" style="background:#E0FFFF"><label
						for="textfield">已审核意见：</label>
					</td>
				</tr>
				<tr>
					<td align="left"><input type="text" name="checkIdea"
						id="checkIdea" style="width:100%;height:50px;background:#CCCCCC"
						readonly="readonly">
					</td>
				</tr>
			</table>
			<table width="800px" align="center" colspan="2" border="1" id="tbDetail" style="display: none">
				<tr>
					<td align="right" width="150px"><label for="textfield">订单编号：</label>
					</td>
					<td align="left" width="450px"><input type="text"
						name="orderid" id="orderid" size="80" maxlength="30"
						value="${param.orderid}" readonly="readonly"
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
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">申请理由：</label>
					</td>
					<td align="left"><input type="text" name="reason" id="reason"
						size="80" maxlength="30" value="${param.reason}">
					</td>
				</tr>
				<tr style="display:none">
					<td></td>
					<td><input type="number" name="returngoodsId"
						id="returngoodsId"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button id="btn_submit" type="button" style="width:80px;" onclick="alter();">修改</button>
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
