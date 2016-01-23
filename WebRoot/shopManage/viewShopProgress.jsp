<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>店铺审核进展查看</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/haveBorder.css">
<script type="text/javascript" src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/shopManage/viewShopProgress.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			 &nbsp; &nbsp;&nbsp;<h3>店铺审核进展查看</h3>
			 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			  <input type="hidden"  name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	    <input type="hidden"  name="page.pageSize" id="pageSize" value="${page.pageSize}"/> 
				<s:if test="#request.page!= null&&#request.page.getTotalItems()>0"> 
				<table width="800px" align="center">
					<tr id="trMain" style="background:#BFDBEB;">
						<td align="center" width=10%>序号</td>
						<td align="center" width=15%>申请人</td>
						<td align="center" width=20%>申请时间</td>
						<td align="center" width=20%>店铺名称</td>
						<td align="center" width=15%>审核状态</td>
						<td align="center" width=10%>详情</td>
						<td align="center" width=10% style="display:none">ID</td>
					</tr>
				<s:iterator value="#request.page" status="s">				
				<s:if test="%{shopApplyId==(#request.shopId)}">
				<tr id="tr${s.count}" style="background:#BFEFFF">	
				</s:if>
				<s:else>
				<tr id="tr${s.count}">
				</s:else>
							<td align="center">${s.count+(page.pageNo-1)*page.pageSize}</td>
							<td align="center">${userinfo.username}</td>
							<td align="center">${applyTime.substring(0, 10)}</td>
							<td align="center">${shopname}</td>
							<td align="center">
							<s:if test="%{state==\"0\"}">待审核</s:if>
							<s:if test="%{state==\"1\"}">审核已通过，为享有开店权利，请您重新登录</s:if>
							<s:if test="%{state==\"2\"}">审核未通过，需修改</s:if>
							</td>
							<td align="center"><a
								href="javascript:lbtDetail(
			    				'${shopname}','${shopcategory}',
			    				'${productcategory}','${shopaddress}',
			    				'${shoppostnumber}','${shopphone}',
			    				'${identifynumber}',
			    				'${userpicture}',
			    				'${identifypicture}',
			    				'${identifypicture2}'
			    				,'${checkIdea}','${state}','${s.count}','${addrarea}'
									);">详情</a></td>
							<td align="center" style="display:none">${shopApplyId}</td>
						</tr>
					</s:iterator>
					 <tr><td colspan="7" style="display:none">
				  <%@ include file="/common/shopPaging.jspf" %>
				  </td></tr>
				</table>

				<div id="msg_searchMyViewList">
					<font color="red" id="font1">${msg_searchMyViewList}</font>
				</div>
			</s:if>
			<table width="800px" align="center" colspan="2" border="1"
				id="tbDetail" style="display: none">
				<tr>
					<td align="right" width="150px"><label for="textfield">店铺名称：</label>
					</td>
					<td align="left" width="450px"><input type="text"
						name="shopname" id="shopname" size="60" maxlength="30"
						value="${param.shopname}" readonly="readonly"
						style="background:#CCCCCC">
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">店铺类别：</label>
					</td>
					<td align="left"><input type="text" name="shopcategory"
						id="shopcategory" size="60" maxlength="30"
						value="${param.shopcategory}" readonly="readonly"
						style="background:#CCCCCC">
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">商品类别：</label>
					</td>
					<td align="left"><input type="text" name="productcategory"
						id="productcategory" size="60" maxlength="30"
						value="${param.productcategory}" readonly="readonly"
						style="background:#CCCCCC">
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">店铺所在地区：</label></td>
					<td align="left"><input type="text" name="addrarea"
						id="addrarea" size="60" maxlength="65" readonly="readonly"
						style="background:#CCCCCC" value="${param.addrarea}"></td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">店铺具体位置：</label>
					</td>
					<td align="left"><input type="text" name="shopaddress"
						id="shopaddress" size="60" maxlength="65" readonly="readonly"
						style="background:#CCCCCC" value="${param.shopaddress}">
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">店铺所在地邮编：</label>
					</td>
					<td align="left"><input type="text" name="shoppostnumber"
						id="shoppostnumber" size="60" maxlength="6" readonly="readonly"
						style="background:#CCCCCC" value="${param.shoppostnumber}">
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">手机号码：</label>
					</td>
					<td align="left"><input type="text" name="shopphone"
						id="shopphone" size="60" maxlength="11" readonly="readonly"
						style="background:#CCCCCC" value="${param.shopphone}">
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">身份证号：</label>
					</td>
					<td align="left"><input type="text" name="identifynumber"
						id="identifynumber" size="60" maxlength="18" readonly="readonly"
						style="background:#CCCCCC" value="${param.identifynumber}">
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">半身照：</label>
					</td>
					<td align="left"><img id="userpicturepicture"
						style="weight:102px;height:116px"
						src="/upload/shopapply/download/middle.png" /></td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">身份证正面：</label>
					</td>
					<td align="left"><img id="identifypicturepicture"
						style="weight:283px;height:179px"
						src="/upload/shopapply/download/middle.png" /></td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">身份证反面：</label>
					</td>
					<td align="left"><img id="identifypicture2picture"
						style="weight:283px;height:179px"/></td>
				</tr>
			</table>
			<table width="800px" align="center" id="tbCheck"
				style="display: none">
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
			<table width="800px" align="center" id="tbHidden"
				style="display: none">
				<tr>
					<td align="center">
						<button id="btn_hidden" type="button" style="width:80px;"
							onclick="btnhidden();">隐藏详情</button>
					</td>
				</tr>
			</table>
			<div id="msg_searchMyViewList">
				<font color="red" id="font1">${msg_searchMyViewList}</font>
			</div>
		</form>
	</center>
	</div>
</body>
</html>
