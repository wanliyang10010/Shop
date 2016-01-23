<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申请店铺</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/haveBorder.css">
<script type="text/javascript" src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/shopManage/applyShop.js"></script>

<script type="text/javascript" src="${ctx}/js/distpicker/distpicker.data.min.js"></script>
<script type="text/javascript" src="${ctx}/js/distpicker/distpicker.min.js"></script>
</head>

<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform" enctype="multipart/form-data"> 
		 <s:if test="#request.msg_isShopApply!= null">
			 <script language="JavaScript">
			 function viewApplyProgress(){
			 	location.href='${ctx}/shopApplyAction_searchMyViewList.action';
			 }
			 function goHomePage(){
			 	location.href='${ctx}/viewProductAction_MyShop.do';
			 }
			 window.confirm('对不起，您已申请过开店，请查看店铺审核进展！',viewApplyProgress,goHomePage,null,'350');
			 /*
			 if(window.confirm('对不起，您已申请过开店，请查看店铺审核进展！')){
           	 location.href='${ctx}/shopApplyAction_searchMyViewList.action';
             }
             else{
             location.href='${ctx}/MyShop.jsp';
             }*/
             </script>
			 </s:if>
			 &nbsp; &nbsp;&nbsp;<h3>申请店铺</h3>	
			 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			<table width="800px" align="center" colspan="2">
				<tr>
					<td align="right" width="270px"><span style="color:#FF0000">*</span><label for="textfield">店铺名称：</label>
					</td>
					<td align="left" width="530px"><input type="text"
						name="shopname" id="shopname" size="25" maxlength="15"											
						onpaste='return false'
						value="${param.shopname}" onchange="checkshopname();"> 
						&nbsp; 
						 <input type="text" style="border-width:0;color:#FF0000;width:57%;" readonly="readonly"
						name="msgshopname" id="msgshopname" value="${msg_shopname}" > 
						</td>
					<!-- 	onKeypress="return (/[a-zA-Z\d\s]/.test(String.fromCharCode(event.keyCode||e.which)))"	 -->
				</tr>
				<tr>
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">店铺类别：</label></td>
					<td align="left"><select name="shopcategory" id="shopcategory"
						style="width:120px">
							<option value="个人一般店铺" selected>个人一般店铺</option>
							<option value="个人旗舰店铺">个人旗舰店铺</option>
							<option value="企业一般店铺">企业一般店铺</option>
							<option value="企业旗舰店铺">企业旗舰店铺</option>
					</select></td>
				</tr>
				<tr>
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">商品类别：</label></td>
					<td align="left"><select name="productcategory"
						id="productcategory" style="width:120px">
							<c:forEach items="${sessionScope.MarginItemList}" var="marginitem">
								 <option value="${marginitem.itemname}">${marginitem.itemname}</option>
							</c:forEach>							
					</select></td>
				</tr>
				<tr>
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">店铺所在地区：</label></td>
					<td align="left">
					<div id="picker" class="distpicker" data-toggle="distpicker">
          					<select id="province" name="province" style="min-width:100px"></select>
          					<select id="city" name="city" style="min-width:130px"></select>
          					<select id="district" name="district" style="min-width:110px"></select>
          					<!-- <em></em> -->
        				</div>
					</td>
				</tr>				
				<tr>
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">店铺具体位置：</label></td>
					<td align="left"><input type="text" name="shopaddress"
						id="shopaddress" size="60" maxlength="30"						
						 onpaste='return false'
						 value="${param.shopaddress}">
					</td>
				</tr>
				<tr>
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">店铺所在地邮编：</label></td>
					<td align="left"><input type="text" name="shoppostnumber"
						id="shoppostnumber" size="60" maxlength="6"
							onkeyup="var myreg=/^[0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
						oninput="var myreg=/^[0-9]+$/;if(!myreg.test(this.value)){this.value=''; };"
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
						value="${param.identifynumber}"
						onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[\W]/g,''))"
						></td>
				</tr>
				<tr id="tr_userpicture" style="display:none">
					<td align="right"><label for="textfield">半身照预览：</label></td>
					<td align="left">
					<div id="viewuserpictureDiv" style='width:102px; height:116px;'>						
					<img  id="viewuserpicture" width="102px" height="116px" src="../image/picerror.jpg">
					 </div>						
					</td>
				</tr>
				<tr>
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">半身照：</label></td>
					<td align="left"><input type="file" name="userPicture.item"
						id="userpicture"  style="width:400px" value="${param.userpicturehide}"></td>
				</tr>
				<tr id="tr_identifypicture" style="display:none">
					<td align="right"><label for="textfield">身份证正面预览：</label></td>
					<td>	
					<div id="viewidentifypictureDiv" style='width:283px; height:179px;'>					
					<img id="viewidentifypicture" width="283px" height="179px">	
					 </div>						
					</td>
				</tr>
				<tr>
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">身份证正面：</label></td>
					<td align="left"><input type="file"
						name="identifyPicture.item" id="identifypicture" style="width:400px">
					</td>
				</tr>
				<tr id="tr_identifypicture2" style="display:none">
					<td align="right"><label for="textfield">身份证反面预览：</label></td>
					<td>		
					<div id="viewidentifypicture2Div" style='width:283px; height:179px;'>				
					<img id="viewidentifypicture2" width="283px" height="179px">	
					 </div>						
					</td>
				</tr>				
				<tr>
					<td align="right"><span style="color:#FF0000">*</span><label for="textfield">身份证反面：</label></td>
					<td align="left"><input type="file" name="uploadFile.item"
						id="identifypicture2" style="width:400px"></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<button id="btn_submit" type="button" style="width:80px;"
							onclick="addshop();">提交</button> &nbsp; &nbsp;&nbsp;
						<button id="btn_cancel" type="reset" style="width:80px;"
							onclick="cancel()">取消</button></td>
				</tr>			
			</table>
		</form>
	</center>
	</div>
</body>
</html>