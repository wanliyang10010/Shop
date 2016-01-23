<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
<%@ page pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
  <head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>积分商城</title>    
   <%@ include file="/common/top-head.jspf"%>
<link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css" />  
<script type="text/javascript" src="${ctx}/js/web1.js"></script>
<script type="text/javascript" src="${ctx}/js/ViewGoods/ViewStageGoods.js"></script>  
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
	   <table width="900">
	    <tr>
                                <td align="right" colspan="2"> 当前用户：${sessionScope.userinfo.username}<br/>
                                                                          可用积分：${sessionScope.userinfo.points}
                                </td>
                                </tr>
                                <tr>
                                <td align="right" width="30%"> 
                                    <label for="textfield">关键字：</label>
                                    </td>
                                     <td align="left"> 
									    <input type="text" name="keyword" id="keyword" size="45" value="${param.keyword}">                             
                                         <button id="btn_submit" type="submit"  onclick="listGoods();" >查询</button>
                                    </td>
                                </tr>
                            </table>
                         <table width="900"  align="center" >
		 <s:iterator value="#request.page" status="s">      
	    <c:choose>
		<c:when test="${s.count%4==1}">
		<tr>  
	         <td>
		     <div class="product_box">
									<a href="javascript:openGoods('${sgoodsId}');">
										<img height="200" width="200"  src="${ctx}${url}" /> </a>
									<p>
										<a
											href="javascript:openGoods('${sgoodsId}');">${goodsname}</a>
									</p>
									<p class="product_price">所需积分(分)：${points}</p>
								</div>
		</td>
	     </c:when>
	     <c:when test="${s.count%4==0}">
	     <td>
		      <div class="product_box">
									<a href="javascript:openGoods('${sgoodsId}');">
										<img height="200" width="200"  src="${ctx}${url}" /> </a>
									<p>
										<a
											href="javascript:openGoods('${sgoodsId}');">${goodsname}</a>
									</p>
									<p class="product_price">所需积分(分)：${points}</p>
								</div>
		</td>
		</tr>
		</c:when>
	     <c:otherwise>
	     <td>
		       <div class="product_box">
									<a href="javascript:openGoods('${sgoodsId}');">
										<img height="200" width="200"  src="${ctx}${url}" /> </a>
									<p>
										<a
											href="javascript:openGoods('${sgoodsId}');">${goodsname}</a>
									</p>
									<p class="product_price">所需积分(分)：${points}</p>
								</div>
			</td>
	     </c:otherwise> 
		 </c:choose>
		 </s:iterator>
	   </table>
	 <%@ include file="/common/paginationProduct.jspf" %>
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
