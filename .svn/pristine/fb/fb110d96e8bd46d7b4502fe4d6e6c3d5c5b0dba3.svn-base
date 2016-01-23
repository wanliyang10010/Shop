<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<%@ page pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<s:token />
<title>用户申诉</title>
<%@ include file="/common/top-head.jspf"%>
<script type="text/javascript" src="${ctx}/js/dispute/DisputeInfo.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
<div id="templatemo_main">
	<center>
		<form name="form1" id="form1" action="" enctype="multipart/form-data">
		<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
			<input type="hidden" name="orderid" id="orderid"
				value="${sessionScope.orderson.ordersonId}"> <input
				type="hidden" name="sccusedid" id="sccusedid"
				value="${sessionScope.orderson.order.shop.shopId}"> <input
				type="hidden" name="accuserid" id="accuserid"
				value="${sessionScope.userinfo.userinfoId}">
			<input type="hidden" name="fileid" id="fileid">
			<input type="hidden" name="filecount" id="filecount" value='${filecount}' size="30">
			<input type="hidden" name="filecontent" id="filecontent" value='${json}' size="30">
 <table width="800" align="center" border="1">
           <tr>
					<td align="right" width="30%">申诉人:</td>
					<td align="left">${sessionScope.userinfo.username}</td>
				</tr>
                              <tr>
					<td align="right">被申诉店铺：</td>
					<td align="left">${sessionScope.orderson.order.shop.shopname}
					</td>
				</tr>
				<tr>
					<td align="right">相关交易：</td>
					<td align="left">${sessionScope.orderson.goodsName}</td>
				</tr>
				<tr>
					<td align="right">申诉类型：</td>
					<td align="left">
					<select name="type" id="type" onchange="typechange(this[selectedIndex].value);">
					       <option value="请选择">请选择</option>
					       <option value="订单发货问题">订单发货问题</option>
					       <option value="退换货问题">退换货问题</option>
					       <option value="店家态度问题">店家态度问题</option>
					       <option value="商品质量问题">商品质量问题</option>
					       <option value="商品描述问题">商品描述问题</option>
					       <option value="其他">其他</option>  
					</select>
                      <input type="text" name="dtype" id="dtype" maxlength="10" size="40"
						value="${param.dtype}" style="display:none"></td>
				</tr>
				 <script type="text/javascript">
										var ss = '${param.type}';
										if (ss != "") {
											document.getElementById("type").value = '${param.type}';
											//document.getElementById("stype")['${param.stype}'].selected = true;
										   if(ss=="其他")
										   {
										     document.getElementById("dtype").style.display="";
										   }
										}
									</script>
				<tr>
					<td align="right">申诉原因：</td>
					<td align="left"><textarea rows="3"name="reason"  maxlength="50"  onkeyup="if(value.length>50) value=value.substr(0,50)" 
							id="reason" style="overflow:hidden;width:400px;">${param.reason}</textarea>
					</td>
				</tr>
                            </table>

			<table width="800" align="center" border="1">
			 <tr>
					<td align="right" width="30%">上传交易截图：</td>
					<td align="left"><input type="file" id="upload"
						name="uploadFile.item" style=" width:30%"> <input id="btnsubmit"
						type="button" value="上传" onclick="up();"></td>
				</tr>
				<tr id="tr_userpicture" style="display:none">
					<td align="right"><label for="textfield">半身照预览：</label></td>
					<td>						
					<img id="viewuserpicture" width="250px" height="200px">						
					</td>
				</tr>
				</table>
				<c:if test="${not empty DisputeFileList}">
				<table width="800" align="center" border="1" id="tb_file">
				<tr height="40">
					<td align="center" width=10%>序号</td>
					 <td align="center" width=30%>图片预览</td>
					<td align="center" width=40%>文件名称</td>
					<td align="center" width=20%>操作</td>
				</tr>
				<c:forEach items="${DisputeFileList}" var="disputeFile"
					varStatus="s">
					<tr>
						<td align="center"  width=10%>${s.count}</td>
						 <td width=30% align="center"> 
					        <img height="80" width="80" src="${ctx}${disputeFile.url}" />
			               </td>    
						<td width=40% align="center">${disputeFile.name}</td>
						<td width=20% align="center"><a
							href="javascript:deletefile('${disputeFile.fileid}');">删除</a>
							</td>
					</tr>
				</c:forEach>
			</table>
			</c:if>
			<table width="800" align="center" border="1">
			 <tr>
					<td align="center" colspan="4"><input type="button" name="btn_submit"
						id="btn_submit" value="提交" onclick="add();">
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" name="btn_cancel"
						id="btn_cancel" value="取消" onclick="cancel();"></td>
				</tr>
				</table>
		</form>
	</center>
	</div>
</body>
</html>
