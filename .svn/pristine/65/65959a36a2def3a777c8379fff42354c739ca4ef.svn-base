<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.xaut.shop.pojo.GoodsDetial"%>
<%@ include file="/common/taglibs.jspf"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>

<title>${stagegoods.goodsname}</title>  
<%@ include file="/common/top-head.jspf"%>  
<link rel="stylesheet" type="text/css" href="css/order/buynow.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/order/addrlist.css">
<script type="text/javascript" src="${ctx}/js/ViewGoods/ViewStageGoods.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
<div id="templatemo_main">
	<center>
	 	<c:choose>
		<c:when test="${stagegoods.sgoodsId>0}">
		  <form name="form1" id="form1" >
		  	<s:token />
			<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
			<input type="hidden" name="sgoodsId"  id="sgoodsId" value="${stagegoods.sgoodsId}" />
			<input id="addrid" type="hidden" name="addrid" value="0" />
			<table width="900">
				<tr>
					<td align="right" style=" width:20%">
		   <img src="${ctx}${stagegoods.url}" id="main_img" style="width:200px; height:200px;" />
					</td>
					<td align="left" style=" width:60%">
						<table  id="save_text" align="left" style=" width:100%" border="1">
							<tr height="40">
								<td width="30%" align="right">商品名称：</td>
								<td align="left">${stagegoods.goodsname}</td>
							</tr>
							<tr height="40">
								<td width="30%" align="right">商品描述：</td>
								<td align="left">${stagegoods.remark}</td>
							</tr>
							<tr height="40">
								<td  width="30%" align="right">所需积分(分)：</td>
								<td align="left">${stagegoods.points}</td>
							</tr>
							<tr height="40">
								<td  width="30%" align="right">我的积分(分)：</td>
								<td align="left">${sessionScope.userinfo.points}</td>
							</tr>
							<tr height="40">
								<td  align="right" colspan="2">
								<input type="button" id="btn_change"  name ="btn_change" onclick="changeNow();"  value="立即兑换" style="height:30" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<div class="address" id ="address"style="display:none">
	    	<h3>确认收货地址<span class="manage-address"><a href="${ctx }/users/deliverAddr/MyAddr.jsp" target="_blank">管理收货地址</a></span></h3>
			<s:action name="deliverAddrAction!toplist" executeResult="false" namespace="/order"></s:action>
	     	<%@ include file="/users/deliverAddr/addrtoplist.jspf" %>
			<table width="900px">
			  <tr>
				<td align="right" colspan="6">
					<input type="button"  onclick="addOrder('${stagegoods.sgoodsId}');"  value="提交订单" style="height:30" />
				</td>
			</tr>
		</div>
			</form>
			</c:when>
			<c:otherwise>    
	              <font color="red" id="font1" >该积分商品已下架</font>
	              	</c:otherwise>
				</c:choose>
		</div>
		</form>
	</center>
</body>
<script type="text/javascript">
$("img").each(function(){
  this.onerror=function(){
    this.src="image/picerror.jpg";
 };
});
</script>
</html>
