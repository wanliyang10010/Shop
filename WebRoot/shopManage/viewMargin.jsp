<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看保证金</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/haveBorder.css">
<script type="text/javascript"
	src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${ctx}/js/shopManage/viewMargin.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			&nbsp; &nbsp;&nbsp;<h3>查看保证金</h3>
			<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			  <input type="hidden"  name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	          <input type="hidden"  name="page.pageSize" id="pageSize" value="${page.pageSize}"/> 
			<s:if test="#request.viewShopList!= null && #request.viewShopList.size()>0">
				<table width="900" align="center">
					<tr id="trMain" style="background:#BFDBEB">
						<td align="center" width=8%>申请人</td>
						<td align="center" width=12%>注册时间</td>
						<td align="center" width=12%>店铺名称</td>
						<td align="center" width=12%>店铺类别</td>
						<td align="center" width=12%>商品类别</td>
						<td align="center" width=8%>店铺平均得分（分）</td>
						<td align="center" width=5%>保证金（元）</td>
						<td align="center" width=10%>保证金状态</td>
						<td align="center" width=9%>店铺状态</td>
						<td align="center" width=7%>保证金详情</td>
					</tr>
					<s:iterator value="#request.viewShopList" status="s">
						<tr id="tr${s.count}">
							<td align="center">${userinfo.username}</td>
							<td align="center">${regeditdate.substring(0, 10)}</td>
							<td align="center">${shopname}</td>
							<td align="center">${shopcategory}</td>
							<td align="center">${productcategory}</td>
							<td align="center">${point}</td>
							<td align="center">${margin}</td>
							<td align="center"><s:if test="%{marginstate==\"0\"}">未交保证金</s:if>
								<s:if test="%{marginstate==\"1\"}">保证金正常</s:if> <s:if
									test="%{marginstate==\"2\"}">保证金冻结</s:if>
							</td>
							<td align="center">
							
								<s:if test="%{shopstate==\"0\"}">店铺冻结</s:if> 
							<s:if test="%{shopstate==\"1\"}">店铺正常</s:if> 
								</td>
							<td align="center"><a
								href="javascript:lbtDetail('${shopId}','${s.count}');">详情</a></td>
						</tr>
					</s:iterator>
				</table>
			</s:if>		
			<div id="msg_viewShop">
				<font color="red" id="font1">${msg_viewShop}</font>
			</div>
			
<!-- 			<div id="marginDetail">
			此处配合/shopManage/marginDetail.jsp页面使用，用来实现局部刷新	
			</div> -->
			<s:if test="#request.page!= null&&#request.page.getTotalItems()>0"> 
				<table width="900px" align="center" id="tbDetail">
					</br>
					<tr style="background:#E0FFFF">
						<td align="center" width=10%>序号</td>
						<td align="center" width=20%>操作人</td>
						<td align="center" width=20%>操作时间</td>
						<td align="center" width=20%>流水金额（元）</td>
						<td align="center" width=30%>备注</td>
					</tr>
					<s:iterator value="#request.page" status="s">	
						<tr>
							<td align="center">${s.count+(page.pageNo-1)*page.pageSize}</td>
							<td align="center">${userinfo.username}</td>
							<td align="center">${userTime.substring(0, 10)}</td>
							<td align="center">
							<s:if test="%{money>0}">+${money}</s:if>
							<s:else>${money}</s:else>
							</td>
							<td align="center">
							<s:if test="%{remark==null||remark==\"0\"}">此用户很懒，什么也没留下……</s:if>
							<s:else>${remark}</s:else>
							</td>
						</tr>
					</s:iterator>
					 <tr><td colspan="5">
				  <%@ include file="/common/shopPaging.jspf" %>
				  </td>
				  </tr>
					<tr>
						<td align="center" colspan="5">
							<button id="btn_hidden" type="button" style="width:80px;"
								onclick="btnhidden();">隐藏详情</button></td>
					</tr>
				</table>
			</s:if>
			<div id="msg_viewMargin">
				<font color="red" id="font1">${msg_viewMargin}</font>
			</div>	
		</form>
	</center>
	</div>
</body>
</html>
