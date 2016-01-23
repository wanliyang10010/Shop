<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看延长收货时间</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/haveBorder.css">
<script type="text/javascript"
	src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${ctx}/js/prolongTime/viewProlong.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
	<div id="templatemo_main">
		<center>
			<form name="userform" action="" id="userform">
				&nbsp; &nbsp;&nbsp;
				<h3>查看延长收货时间</h3>
				<input type="hidden" id="authorizedToken" name="authorizedToken"
					value="${userid}" /> <input type="hidden" name="page.pageNo"
					id="pageNo" value="${page.pageNo}" /> <input type="hidden"
					name="page.pageSize" id="pageSize" value="${page.pageSize}" />
				<%@ include file="/common/searchByDate.jspf"%>
				<s:if test="#request.page!= null&&#request.page.getTotalItems()>0">
					<table width="800px" align="center">
						<tr id="trMain" style="background:#BFDBEB">
							<td align="center" width=10%>序号</td>
							<td align="center" width=25%>申请人</td>
							<td align="center" width=25%>申请时间</td>
							<td align="center" width=30%>审核状态</td>
							<td align="center" width=10%>详情</td>
							<td align="center" width=10% style="display:none">ID</td>
						</tr>
						<s:iterator value="#request.page" status="s">
							<s:if test="%{prolongapplyId==(#request.prolongId)}">
								<tr id="tr${s.count}" style="background:#BFEFFF">
							</s:if>
							<s:else>
								<tr id="tr${s.count}">
							</s:else>
							<td align="center">${s.count+(page.pageNo-1)*page.pageSize}</td>
							<td align="center">${userinfo.username}</td>
							<td align="center">${applyTime}</td>
							<td align="center"><s:if test="%{state==\"0\"}">待审核</s:if> 
							<s:if test="%{state==\"1\"}">审核已通过</s:if> 
							<s:if test="%{state==\"2\"}">审核未通过</s:if>
							<s:if test="%{state==\"3\"}">交易状态已改变，数据失效</s:if>
							</td>
							<td align="center"><a
								href="javascript:lbtDetail('${prolongapplyId}',
			    				'${order.orderid}','${dayapply}',
			    				'${reason}','${checkIdea}',
			    				'${state}','${s.count}');">详情</a>
							</td>
							<td align="center" style="display:none">${prolongapplyId}</td>
							</tr>
						</s:iterator>
						<tr>
							<td colspan="6"><%@ include file="/common/shopPaging.jspf"%>
							</td>
						</tr>
					</table>
				</s:if>
				<div id="msg_searchMyViewList">
					<font color="red" id="font1">${msg_searchMyViewList}</font>
				</div>
				<table width="800px" align="center" colspan="2" id="tbDetail"
					style="display: none">
					<tr>
						<td align="right" width="250px"><label for="textfield">订单编号：</label>
						</td>
						<td align="left" width="550px"><input type="text"
							name="orderId" id="orderId" size="60" maxlength="30"
							value="${param.orderId}" readonly="readonly"
							style="background:#CCCCCC">
						</td>
					</tr>
					<tr>
						<td align="right"><label for="textfield">申请天数：</label>
						</td>
						<td align="left"><input type="text" name="dayapply"
							id="dayapply" size="60" maxlength="30" value="${param.dayapply}"
							readonly="readonly" style="background:#CCCCCC">
						</td>
					</tr>
					<tr>
						<td align="right"><label for="textfield">申请理由：</label>
						</td>
						<td align="left"><input type="text" name="reason" id="reason"
							size="60" maxlength="30" value="${param.reason}"
							readonly="readonly" style="background:#CCCCCC">
						</td>
					</tr>
				</table>
				<table width="800px" align="center" id="tbCheck"
					style="display: none">
					<tr>
						<td align="left" style="background:#E0FFFF"><label
							for="textfield">已审核意见：</label></td>
					</tr>
					<tr>
						<td align="left"><input type="text" name="checkIdea"
							id="checkIdea" style="width:100%;height:50px;background:#CCCCCC"
							readonly="readonly"></td>
					</tr>
				</table>
				<table width="800px" align="center" id="tbHidden"
					style="display: none">
					<tr>
						<td align="center">
							<button id="btn_hidden" type="button" style="width:80px;"
								onclick="btnhidden();">隐藏详情</button></td>
					</tr>
				</table>
			</form>
		</center>
	</div>
</body>
</html>
