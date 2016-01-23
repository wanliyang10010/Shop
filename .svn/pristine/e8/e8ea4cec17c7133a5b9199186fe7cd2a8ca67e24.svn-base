<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看人人递信息</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/noneBorder.css">
<script type="text/javascript" src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/p2pExpress/viewExpress.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			&nbsp; &nbsp;&nbsp;<h3>查看人人递信息</h3>
			<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			<input type="hidden"  name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	   		 <input type="hidden"  name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
			 <%@ include file="/common/searchByDate.jspf" %>
			<div id="msg_alterover">
				<font color="red" id="font1">${msg_alterover}</font>
			</div>
			</br>
			<s:if test="#request.page!= null&&#request.page.getTotalItems()>0">
			<table width="900px" align="center" style="word-wrap:break-word;word-break:break-all">
			<thead>
				<tr style="background:#BFDBEB;font-weight:bold;font-size:13px">	
					<td align="center" width=15%>发件人地址</td>
					<td align="center" width=15%>收件人地址</td>
					<td align="center" width=10%>发布时间</td>
					<td align="center" width=13%>物品重量</td>
					<td align="center" width=5%>费用</td>
					<td align="center" width=10%>发件人</td>
					<td align="center" width=12%>发件人联系方式</td>
					<td align="center" width=10%>物品描述信息</td>
					<td align="center" width=10%>备注</td>
				</tr>
				</thead>
			<s:iterator value="#request.page" status="s">
			<tbody>
				<tr>					
					<td align="center">${address}</td>
					<td align="center">${receiveaddr}</td>
					<td align="center">${applyTime.substring(0, 10)}</td>
					<td align="center">${weight}</td>
					<td align="center">${money}</td>
					<td align="center">${name}</td>
					<td align="center">${phone}</td>
					<td align="center">${description}</td>
					<td align="center">${remark}</td>									
				</tr>
			</tbody>
			</s:iterator>	
			 <tr>
				 <td colspan="10">
				  <%@ include file="/common/shopPaging.jspf" %>
				  </td>
				  </tr>
			</table>
			</s:if>
			<div id="msg_searchViewList">
				<font color="red" id="font1">${msg_searchViewList}</font>
			</div>
		</form>
	</center>
	</div>
</body>
</html>
