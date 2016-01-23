<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
<%@ page pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
  <head>
  <title>店铺商品销量统计</title>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx}/css/page.css" />
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top.jspf" %>
</div> 
<script type="text/javascript" src="${ctx}/js/shopManage/SaleCount.js"></script> 
  </head>
  <body>
  <div id="templatemo_main">
     <center>
	<form name="form1" action=""  id="form1" >
	<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
      <input type="hidden" name="shopId" id="shopId" value="${sessionScope.shop.shopId}" >
                             <table width="800">
                                <tr>
                                    <td align="right" style=" width:20%" >
                                    <label for="textfield">商品名称：</label>
                                    </td>
                                    <td align="left">
                                       <input type="text" name="keyword" id="keyword" size="25" value="${param.keyword}">
                                      <select name="typeid" id="typeid">
									       <option value="0">请选择</option>   
											<c:forEach items="${sessionScope.goodstypeList}" var="goodstype">
												 <option value="${goodstype.gtypeId}">${goodstype.typename}</option>
											</c:forEach>
									</select>
                                       <input id="btn_submit" type="button"  onclick="search();" value="查询">
                                       </td>
                                </tr>
                            </table>
                             <script type="text/javascript">
										var ss = '${param.typeid}';
										if (ss != "") {
											document.getElementById("typeid").value = '${param.typeid}';
											document.getElementById("typeid")['${param.typeid}'].selected = true;
										}
									</script>
 <c:if test="${page.pageSize>0}"> 
        <table width="800"  align="center" >
         <tr>
         <td colspan="6" align="center">该部分仅将用户已确认收货的订单作为统计对象</td></tr>
         <tr>
         <td colspan="2">店铺名称：${sessionScope.shop.shopname}</td>
         <td colspan="4">累计销售额：<fmt:formatNumber value="${totalmoney}" pattern=".00"  minIntegerDigits="1"/></td>
	     </tr>
	     <tr>
	          <td align="center" width=5%>序号</td>
	          <td align="center" width=45%>商品名称</td>
		      <td align="center" width=10%>销量</td>
		      <td align="center" width=10%>库存</td>
		      <td align="center" width=10%>已收货数量</td>
		      <td align="center" width=10%>销售额</td>
	     </tr>
		     <c:forEach items="${GoodsList}" var="saleGoods" varStatus="s">
		    <tr>
		         <td align="center" width=5%>${s.count+(page.pageNo-1)*page.pageSize}</td>
		         <td align="center" width=45%>${saleGoods.goodsname}</td>
		         <td align="center" width=10%>${saleGoods.samount}</td>
		         <td align="center" width=10%>${saleGoods.amount}</td>
		         <td align="center" width=10%>${saleGoods.point}</td>
		         <td align="center" width=10%><fmt:formatNumber value="${saleGoods.price}" pattern=".00"  minIntegerDigits="1"/></td>
	             </tr> 
	       </c:forEach>
	   </table>
	   </c:if>
	   <%@ include file="/common/pagination.jspf" %>
	         <div id="msg" >
	              <font color="red" id="font1" >${msg}</font>
	             </div>      
	 </form>
	</center> 
	 <br/>
	  <br/>
	</div>       
  </body>
</html>
