<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
<%@ page pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
  <head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>兑换记录</title>    
   <%@ include file="/common/top-head.jspf"%>
<link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css" />  
<script type="text/javascript" src="${ctx}/js/web1.js"></script>
<script type="text/javascript" src="${ctx}/js/ViewGoods/ViewStageOrder.js"></script>  
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
  </head>
  <body>
  <div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
     <center>
     <div id="templatemo_main">
	<form name="form1" action=""  id="form1" >
	<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
	<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	  <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
	  <table width="800" border="0">
                            <tr>
                                    <td align="right" style=" width:35%" >
                                    <label for="textfield">起始时间：</label>
                                    <input class="Wdate" name="fromdate" id="fromdate" size="19" value="${param.fromdate}" onClick="WdatePicker()">
                                    </td>
                                     <td align="left" style=" width:35%" >
                                    <label for="textfield">终止时间：</label>
                                      <input class="Wdate" name="todate" id="todate" size="19" value="${param.todate}" onClick="WdatePicker()">
                                    </td>
                                        <td align="left">      
                                         <input id="btn_search" type="button"  onclick="searchDate();" value="查询">
                                    </td>
                                </tr>
                            </table>
      <c:if test="${msg==''}">
		 <table width="800" border="1">
	     <tr>
	          <td align="center" width=10%>序号</td>
	          <td align="center" width=15%>商品图片</td>
	          <td align="center" width=40%>商品名称</td>
		      <td align="center" width=15%>购买时间</td>
		      <td align="center" width=25%>物流信息</td>
	     </tr>
		   <s:iterator value="#request.page" status="s">
		    <tr>
		         <td  align="center">${s.count+(page.pageNo-1)*page.pageSize}</td>
		          <td align="center">
                   <img height="80" width="80" src="${ctx}${stagegoods.url}" />
                    </td>
		         <td align="center">${stagegoods.goodsname}</td>
		          <td align="center"> <fmt:formatDate value="${buytime}" type="both"/></td>
		          <c:choose>
			      <c:when test="${empty transcompany}">
			                   <td align="center">尚未发货</td>             
			     </c:when>        
			     <c:otherwise>
			          <td align="center">${transcompany}-${transnumber}</td>                      
			      </c:otherwise> 
			       </c:choose>
	             </tr> 
	     </s:iterator>
	   </table> 
	   </c:if>
	 <%@ include file="/common/pagination.jspf" %>
	         <div id="msg" >
	              <font color="red" id="font1" >${msg}</font>
	             </div>
	 </form>
	  <br/>
	  <br/>
	 </div>
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
