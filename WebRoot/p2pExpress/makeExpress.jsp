<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布人人递信息</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/noneBorder.css">
<script type="text/javascript" src="${ctx}/js/p2pExpress/makeExpress.js"></script>
</head>

<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform"> 
			 &nbsp; &nbsp;&nbsp;<h3>发布人人递信息</h3>	
			 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			<table width="800px" align="center" colspan="2">
				<tr>
					<td align="right" width="200px"><span style="color:#FF0000">*</span><label for="textfield">发件人姓名：</label>
					</td>
					<td align="left" width="600px">
					<input type="text" name="name" id="name" size="80" maxlength="10" value="${userinfo.username}"> 
					</td>
				</tr>
				<tr>
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">发件地址：</label></td>
					<td align="left">
					<input type="text" name="address" id="address" size="80" maxlength="60" value="${userinfo.address}"> 
					</td>
				</tr>				
				<tr>
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">发件人联系方式：</label></td>
					<td align="left">
					<input type="text" name="phone" id="phone" size="80" maxlength="15" value="${userinfo.telephone}"> 
					</td>
				</tr>
				<tr>
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">收件人地址：</label></td>
					<td align="left">
					<input type="text" name="receiveaddr" id="receiveaddr" size="80" maxlength="30" value="${param.receiveaddr}"> 
					</td>
				</tr>
					<tr>
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">物品重量：</label></td>
					<td align="left">
					<!-- IE不支持Select元素的innerHTML赋值，只能加div -->
					<div id="weightDiv"></div>
					</td>
				</tr>
					<tr>
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">物品描述信息：</label></td>
					<td align="left">
					<input type="text" name="description" id="description" size="80" maxlength="30" value="${param.description}"> 
					</td>
				</tr>
					<tr>
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">费用（元）：</label></td>
					<td align="left">
					<input type="text" name="money" id="money" size="80" maxlength="5" value="5"
					onkeyup="var myreg=/^[0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
					oninput="var myreg=/^[0-9]+$/;if(!myreg.test(this.value)){this.value=''; };"> 
					</td>
				</tr>
					<tr>
					<td align="right"><label for="textfield">备注：</label></td>
					<td align="left">
					<input type="text" name="remark" id="remark" size="80" maxlength="30" value="${param.remark}">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<button id="btn_submit" type="button" style="width:80px;"
							onclick="ok();">发布</button> &nbsp; &nbsp;&nbsp;
						<button id="btn_cancel" type="reset" style="width:80px;"
							onclick="cancel()">取消</button></td>
				</tr>			
			</table>
		</form>
	</center>
	</div>
</body>
</html>