<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申请延长收货时间</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
 <link rel="stylesheet" type="text/css"  href="${ctx}/css/noneBorder.css"> 
<script type="text/javascript"	src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/prolongTime/applyProlong.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			 &nbsp; &nbsp;&nbsp;<h3>申请延长收货时间</h3>
			 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
		<s:if test="#request.orderid!=''">
		     <table width="900px" align="center">
					<tr style="background:#BFDBEB">
						<td align="center" width=10%>订单号</td>
						<td align="center" width=15%>购买人</td>
						<td align="center" width=20%>购买时间</td>
						<td align="center" width=20%>店铺名称</td>
						<td align="center" width=15%>订单金额（元）</td>												
						<td align="center" width=20%>备注</td>					
					</tr>
					<tr>
						<td align="center">${param.orderid}</td>
						<td align="center">${param.username}</td>
						<td align="center">${param.buytime.substring(0,19)}</td>
						<td align="center">${param.shopname}</td>
						<td align="center">${param.ftotal}</td>
						<td align="center">${param.remark}</td>
					</tr>
					<tr>
					<td align="center" colspan="6">
									<button id="btn_apply" type="button" style="width:150px;"
							onclick="applyProlong();">申请延长收货时间</button></td>
							
				</tr>
				</table>
			</s:if>
							
				<table  width="900px" align="center" id="tbDetail" style="display: none">
				<hr width="900px">
				<tr style="display:none">
					<td><input type="text" name="orderid" id="orderid"
						value="${param.orderid}">
					</td>
				</tr>
				<tr style="display:none">
					<td><input type="text" name="shopId" id="shopId"
						value="${param.shopId}">
					</td>
				</tr>
				<tr>
					<td align="center" ><span style="color:#FF0000">*</span>延长天数：
					<input type="text" name="dayapply"	id="dayapply" size="9" maxlength="2" 
						onkeyup="var myreg=/^[0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "						
						value="${param.dayapply}">
					</td>
				</tr>
				<tr >
					<td align="center">
					理由：<input type="text" name="reason" id="reason" 
					size="40" maxlength="20"></td>
				</tr>
				<tr>
					<td align="center" >
						<button id="btn_submit" type="button" style="width:80px;"
							onclick="ok();">确定</button>
							 &nbsp;&nbsp;&nbsp; 
							
					<button id="btn_cancel" type="reset" style="width:80px;"
							onclick="cancel();">取消</button></td>					
				</tr>
			</table>
		</form>
	</center>
</div></body>
</html>
