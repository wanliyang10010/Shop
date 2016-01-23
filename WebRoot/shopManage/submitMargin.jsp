<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保证金交费</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/haveBorder.css">
<script type="text/javascript"
	src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${ctx}/js/shopManage/submitMargin.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			&nbsp; &nbsp;&nbsp;<h3>保证金交费</h3>
			<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			<s:if test="#request.viewShopList!= null && #request.viewShopList.size()>0">
				<table width="900px" align="center">
					<tr id="trMain" style="background:#BFDBEB">
						<td align="center">申请人</td>
						<td align="center">注册时间</td>
						<td align="center">店铺名称</td>
						<td align="center">店铺类别</td>
						<td align="center">商品类别</td>
						<td align="center">店铺平均得分（分）</td>
						<td align="center">保证金（元）</td>
						<td align="center">保证金状态</td>
						<td align="center">店铺状态</td>
						<td align="center">操作</td>
					</tr>
					<s:iterator value="#request.viewShopList" status="s">
						<tr	id="tr${s.count}">
							<td align="center">${userinfo.username}</td>
							<td align="center">${regeditdate.substring(0, 10)}</td>
							<td align="center">${shopname}</td>
							<td align="center">${shopcategory}</td>
							<td align="center">${productcategory}</td>
							<td align="center">${point}</td>
							<td align="center">${margin}</td>
							<td align="center">
							<s:if test="%{marginstate==\"0\"}">未交保证金</s:if> 
							<s:if test="%{marginstate==\"1\"}">保证金正常</s:if> 
							<s:if test="%{marginstate==\"2\"}">保证金冻结</s:if></td>
							<td align="center">
							<s:if test="%{shopstate==\"0\"}">店铺冻结</s:if> 
							<s:if test="%{shopstate==\"1\"}">店铺正常</s:if> 
							</td>						
							<td align="center">
							<s:if test="%{shopstate!=\"0\"}">
							<a	href="javascript:lbtDetail('${shopId}',
			    				'${shopname}','${shopcategory}',
			    				'${productcategory}','${userinfo.username}',
			    				'${regeditdate.substring(0, 10)}','${margin}','${s.count}'
			    				);">
			    				</s:if>
			    				<s:if test="%{shopstate==\"1\"&&marginstate==\"0\"}">交费</s:if> 
			    				<s:if test="%{shopstate==\"1\"&&marginstate==\"1\"}">追交</s:if> 
			    				<s:if test="%{shopstate==\"0\"}">请先激活店铺</s:if>
			    				</a>
							</td>
						</tr>
					</s:iterator>				
				</table>			
				<div id="msg_viewShop">
					<font color="red" id="font1">${msg_viewShop}</font>
				</div>
				</s:if>
				
				<table width="900px" align="center" colspan="2" border="1"
					id="tbDetail" style="display: none">
					<tr style="display:none">
						<td align="right"><label for="textfield">id：</label>
						</td>
						<td align="left"><input type="number" name="shopId"
							id="shopId">
						</td>
					</tr>
					<tr style="display:none">
						<td align="right"><label for="textfield">userId：</label>
						</td>
						<td align="left"><input type="text" name="userId" id="userId">
						</td>
					</tr>
					<tr style="display:none">
						<td align="right"><label for="textfield">regeditdate：</label>
						</td>
						<td align="left"><input type="text" name="regeditdate"
							id="regeditdate">
						</td>
					</tr>
					<tr style="display:none">
						<td align="right"><label for="textfield">margin：</label>
						</td>
						<td align="left"><input type="number" name="margin"
							id="margin">
						</td>
					</tr>
					<tr>
						<td align="right" width="300px"><label for="textfield">您的店铺名称：</label>
						</td>
						<td align="left" width="600px"><input type="text"
							name="shopname" id="shopname" size="60" maxlength="30"
							readonly="readonly" style="background:#CCCCCC"></td>
					</tr>
					<tr>
						<td align="right"><label for="textfield">您的店铺类别：</label></td>
						<td align="left"><input type="text" name="shopcategory"
							id="shopcategory" size="60" maxlength="30" readonly="readonly"
							style="background:#CCCCCC"></td>
					</tr>
					<tr>
						<td align="right"><label for="textfield">您的商品类别：</label></td>
						<td align="left"><input type="text" name="productcategory"
							id="productcategory" size="60" maxlength="30" readonly="readonly"
							style="background:#CCCCCC"></td>
					<tr>
						<td align="right"><label for="textfield">最低缴费金额（元）：</label></td>
						<td align="left"><input type="text" name="minmoney"
							id="minmoney" size="9" maxlength="10" readonly="readonly"
							style="background:#CCCCCC">
						</td>
					</tr>
					<tr>
						<td align="right"><span style="color:#FF0000">*</span><label for="textfield">实际缴费金额（元）：</label></td>
						<td align="left">
						<input type="text" name="money"	id="money" size="9" maxlength="7" 						
						onkeyup="var myreg=/^[0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
						oninput="var myreg=/^[0-9]+$/;if(!myreg.test(this.value)){this.value=''; };"
						value="${param.money}">
						</td>
					</tr>
					<tr>
						<td align="right"><label for="textfield">备注：</label></td>
						<td align="left">
							<input type="text" name="remark" id="remark"												
							 size="60" maxlength="33"/>
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<button id="btn_submit" type="button" style="width:80px;"
								onclick="pay('${userid}');">确定交费</button> &nbsp; &nbsp;&nbsp;
							<button id="btn_cancel" type="reset" style="width:80px;"
								onclick="cancel()">取消</button></td>
					</tr>
				</table>
		</form>
	</center>
	</div>
</body>
</html>
