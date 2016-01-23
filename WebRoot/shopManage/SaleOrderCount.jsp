<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jspf"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>店铺订单统计</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/page.css" />
    <div align="center" style="margin-top:-40px;">
<%@ include file="/common/top.jspf" %>
</div>
<script type="text/javascript" src="${ctx}/js/web1.js"></script>
<script type="text/javascript" src="${ctx}/js/shopManage/SaleCount.js"></script> 
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="templatemo_main">
     <center>
	<form name="form1" action=""  id="form1" >
	<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
	<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	  <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
	   <input type="hidden" name="shopId" id="shopId" value="${sessionScope.shop.shopId}" >
                            <table width="800" border="0">
                            <tr>
                                    <td align="right" style=" width:35%" >
                                    <label for="textfield">起始时间：</label>
                                    <input class="Wdate" name="fromdate" id="fromdate" size="19" value="${param.fromdate}" onClick="WdatePicker()" readonly="true">
                                    </td>
                                     <td align="left" style=" width:35%" >
                                    <label for="textfield">终止时间：</label>
                                      <input class="Wdate" name="todate" id="todate" size="19" value="${param.todate}" onClick="WdatePicker()" readonly="true">
                                    </td>
                                        <td align="left">      
                                         <input id="btn_search" type="button"  onclick="searchDate();" value="查询">
                                    </td>
                                </tr>
                            </table>
      <c:if test="${msg==''}">
       <table width="800" >
        <tr>
           <td colspan="5" align="center">该部分仅将用户已确认收货的订单作为统计对象</td>
       </tr>
       <tr>
           <td colspan="3">店铺名称：${sessionScope.shop.shopname}</td>
           <td colspan="2">总销售额：<fmt:formatNumber value="${totalmoney}" pattern=".00"  minIntegerDigits="1"/></td>
       </tr>
	     <tr>
	          <td align="center" width=5%>序号</td>
	          <td align="center" width=15%>订单号</td>
		      <td align="center" width=10%>时间</td>
		       <td align="center" width=15%>运费</td>
		      <td align="center" width=15%>订单总金额</td>
	     </tr>
		     <s:iterator value="#request.page" status="s">
		    <tr>
		         <td  align="center">${s.count+(page.pageNo-1)*page.pageSize}</td>
		        <td width=15% align="center">${orderid}</td>
			    <td width=10% align="center">${fn:substring(buytime,0,19)}</td>
			    <td width=15% align="center"><fmt:formatNumber value="${freight}" pattern=".00"  minIntegerDigits="1"/></td>
			     <td width=15% align="center"><fmt:formatNumber value="${ftotal}" pattern=".00"  minIntegerDigits="1"/></td>
		    </tr>
		      </s:iterator>
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