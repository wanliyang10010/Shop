<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>买家积分查看</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/haveBorder.css">
<script type="text/javascript"
	src="${ctx}/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			 &nbsp; &nbsp;&nbsp;<h3>买家积分查看</h3>
			 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			  <input type="hidden"  name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	    <input type="hidden"  name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
				 <s:if test="#request.page!= null&&#request.page.getTotalItems()>0"> 
				<table width="800px" align="center">
					<tr style="background:#BFDBEB;">
						<td align="center" width=10%>序号</td>
						<td align="center" width=17%>会员名字</td>
						<td align="center" width=25%>积分到账时间</td>
						<td align="center" width=18%>分值（分）</td>
						<td align="center" width=10%>加减</td>
						<td align="center" width=20%>内容</td>
					</tr>
					<s:iterator value="#request.page" status="s">	
						<tr>
							<td align="center">${s.count+(page.pageNo-1)*page.pageSize}</td>
							<td align="center">${userinfo.username}</td>
							<td align="center">${operateTime}</td>
							<td align="center">${point}</td>
							<td align="center">${plusminus}</td>
							<td align="center">${content}</td>
						</tr>
					</s:iterator>
					<tr><td colspan="6">
				  <%@ include file="/common/shopPaging.jspf" %>
				  </td></tr>
				</table>
			</s:if>
			<div id="msg_userpoint">
				<font color="red" id="font1">${msg_userpoint}</font>
			</div>
		</form>
	</center>
</div></body>
</html>
