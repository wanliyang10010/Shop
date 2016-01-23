<%@ page language="java" contentType="text/html;charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>店铺修改</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/haveBorder.css">
<script type="text/javascript"
	src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/shopManage/alterShop.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform" enctype="multipart/form-data">
			 &nbsp; &nbsp;&nbsp;<h3>店铺修改</h3>
			 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			<div id="msg_alterover" align="center">
				<font color="red" id="font1">${msg_alterover}</font>
			</div>
			<s:if test="#request.alterShopList!= null && #request.alterShopList.size()>0">
				<table width="800px" align="center">
					<tr id="trMain" style="background:#BFDBEB;">
						<td align="center" width=10%>序号</td>
						<td align="center" width=20%>申请人</td>
						<td align="center" width=20%>申请时间</td>
						<td align="center" width=30%>店铺名称</td>
						<td align="center" width=10%>详情</td>
						<td align="center" width=10%>删除</td>
						<td align="center" width=10% style="display:none">ID</td>
					</tr>
					<s:iterator value="#request.alterShopList" status="s">
						<s:if test="%{shopApplyId==(#request.shopId)}">
				<tr id="tr${s.count}" style="background:#BFEFFF">	
				</s:if>
				<s:else>
				<tr id="tr${s.count}">
				</s:else>
							<td align="center">${s.count}</td>
							<td align="center">${userinfo.username}</td>
							<td align="center">${applyTime.substring(0, 10)}</td>
							<td align="center">${shopname}</td>
							<td align="center"><a
								href="javascript:lbtDetail('${shopApplyId}',
			    				'${shopname}','${shopcategory}',
			    				'${productcategory}','${shopaddress}',
			    				'${shoppostnumber}','${shopphone}',
			    				'${identifynumber}',
			    				'${userpicture}',
			    				'${identifypicture}',
			    				'${identifypicture2}'
			    				,'${checkIdea}','${s.count}','${addrarea}'
			    				);">详情</a>
							</td>
							<td align="center">
							<a href="javascript:deleteshopApply('${shopApplyId}');">删除</a></td>
							<td align="center" style="display:none">${shopApplyId}</td>
						</tr>
					</s:iterator>
				</table>
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
				<table width="800px" align="center" colspan="2" border="1"
					id="tbDetail" style="display: none">
					<tr style="display:none">
						<td align="right"><label for="textfield">id：</label></td>
						<td align="left"><input type="number" name="shopApplyId"
							id="shopApplyId"></td>
					</tr>
					<tr>
						<td align="right" width="250px"><label for="textfield">店铺名称：</label>
						</td>
						<td align="left" width="550px"><input type="text"
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
						<td align="right"><span style="color:#FF0000">*</span><label for="textfield">店铺具体位置：</label></td>
						<td align="left"><input type="text" name="shopaddress"
							id="shopaddress" size="60" maxlength="30"
							 value="${param.shopaddress}">
						</td>
					</tr>
					<tr>
						<td align="right"><span style="color:#FF0000">*</span><label for="textfield">店铺所在地邮编：</label></td>
						<td align="left"><input type="text" name="shoppostnumber"
							id="shoppostnumber" size="60" maxlength="6"
							onkeyup="var myreg=/^[0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
						   ninput="var myreg=/^[0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
							value="${param.shoppostnumber}" >
						</td>
					</tr>
					<tr>
						<td align="right"><span style="color:#FF0000">*</span><label for="textfield">手机号码：</label></td>
						<td align="left"><input type="text" name="shopphone"
							id="shopphone" size="60" maxlength="11"
							onkeyup="var myreg=/^[0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
						    oninput="var myreg=/^[0-9]+$/;if(!myreg.test(this.value)){this.value=''; };"
							value="${param.shopphone}" ></td>
					</tr>
					<tr>
						<td align="right"><span style="color:#FF0000">*</span><label for="textfield">身份证号：</label></td>
						<td align="left"><input type="text" name="identifynumber"
							id="identifynumber" size="60" maxlength="18"
							onkeyup="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
							oninput="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
							value="${param.identifynumber}"></td>
					</tr>
					<tr id="tr_userpicture">
						<td align="right"><label for="textfield">半身照：</label>
						</td>
						<td align="left">
						<div id="viewuserpictureDiv" style='width:102px; height:116px;'>	
						<img id="viewuserpicture" style="weight:102px;height:116px"/>
						</div>
						</td>
					</tr>
					<tr style="display: ">
						<td align="right"><label for="textfield">修改后半身照：</label></td>
						<td align="left">
						<input type="file" name="userPicture.item"
							id="userpicture" style="width:400px" ></td>
					</tr>
					<tr id="tr_identifypicture">
						<td align="right"><label for="textfield">身份证正面：</label>
						</td>
						<td align="left">
						<div id="viewidentifypictureDiv" style='width:283px; height:179px;'>	
						<img id="viewidentifypicture" style="weight:283px;height:179px"/>
						</div>
						</td>
					</tr>
					<tr>
						<td align="right"><label for="textfield">修改后身份证正面：</label></td>
						<td align="left"><input type="file"
							name="identifyPicture.item" id="identifypicture" style="width:400px">
						</td>
					</tr>
					<tr id="tr_identifypicture2">
						<td align="right"><label for="textfield">身份证反面：</label>
						</td>
						<td align="left">
						<div id="viewidentifypicture2Div" style='width:283px; height:179px;'>	
						<img id="viewidentifypicture2" style="weight:283px;height:179px"/>
						</div>
						</td>
					</tr>
					<tr>
						<td align="right"><label for="textfield">修改后身份证反面：</label></td>
						<td align="left"><input type="file" name="uploadFile.item"
							id="identifypicture2" style="width:400px"></td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<button id="btn_submit" type="button" style="width:80px;"
								onclick="altershop();">修改</button> &nbsp; &nbsp;&nbsp;
							<button id="btn_cancel" type="reset" style="width:80px;"
								onclick="cancel();">取消</button>
						</td>
					</tr>
				</table>
			</s:if>
			<div id="msg_searchMyAlterList" align="center">
				<font color="red" id="font1">${msg_searchMyAlterList}</font>
			</div>
		</form>
	</center>
	</div>
</body>
</html>
