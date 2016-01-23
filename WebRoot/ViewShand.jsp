
<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
<%@ page pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
  <head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>二手商品</title>    
 <%@ include file="/common/top-head.jspf"%>
<script type="text/javascript" src="${ctx}/js/web1.js"></script>
<script type="text/javascript" src="${ctx}/js/ViewGoods/ViewProduct.js"></script>  
<script type="text/javascript" src="${ctx}/js/Alert.js"></script>
</head>
  <body>
  <div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
     <center>
     <div id="templatemo_main">
	<form name="form1" action=""  id="form1">
	 <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	  <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>                    <div> 
      <input type="hidden" name="type" id="type" value="${param.type}"/>
        <h1>二手商品</h1>
       <table width="800"  align="center" style="font-size:15px;">
         <tr>
                                    <td align="right" style=" width:20%" >
                                    <label for="textfield">搜索：</label>
                                    </td>
                                     <td align="left">     
									    <input type="text" name="keyword" id="keyword" size="45" value="${param.keyword}" placeholder="请输入商品名称">                             
                                         <select name="typeitem" id="typeitem">
					       <option value="所有商品">所有商品</option>   
							<c:forEach items="${listItem}" var="item">
								 <option value="${item.itemname}">${item.itemname}</option>
							</c:forEach>
					</select>	
                                         <button id="btn_submit" type="submit"  onclick="listShand();" >查询</button>
                                    </td>
                                </tr>
                                 <script type="text/javascript">
										var ss = '${param.typeitem}';
										if (ss != "") {
											document.getElementById("typeitem").value = '${param.typeitem}';
											//document.getElementById("stype")['${param.stype}'].selected = true;
										}
									</script>
		 <s:iterator value="#request.page" status="s">      
	    <c:choose>
		<c:when test="${s.count%4==1}">
		<tr>  
	         <td>
		      <div class="product_box">
				<a href="javascript:opendetial('${goodsid}','${shop.shopId}');">
					<img height="200" width="200"  src="${ctx}${goodsPicture.url}" /> </a>
				<p>
					<a
						href="javascript:opendetial('${goodsid}','${shop.shopId}');">${goodsname}</a>
				</p>
			<c:choose>
					<c:when test="${discount.discountId>0}">
					  <p >原价：${price} <lable: class="product_price">促销价：${discount.price}</lable:></p>
					</c:when>
					<c:otherwise>
					   <p class="product_price">价格：${price}</p>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${not empty shand&&shand=='1'}">
						<p class="product_price"><font color="red" id="font1" >二手商品 &nbsp;&nbsp;&nbsp;&nbsp;</font>销量：${samount} </p>
					</c:when>
					<c:otherwise>
						<p class="product_price">销量：${samount}</p>
					</c:otherwise>
				</c:choose>
			</div>
		</td>
	     </c:when>
	     <c:when test="${s.count%4==0}">
	     <td>
		      <div class="product_box">
				<a href="javascript:opendetial('${goodsid}','${shop.shopId}');">
					<img height="200" width="200" src="${ctx}${goodsPicture.url}" /> </a>
				<p>
					<a
						href="javascript:opendetial('${goodsid}','${shop.shopId}');">${goodsname}</a>
				</p>
				<c:choose>
					<c:when test="${discount.discountId>0}">
					  <p >原价：${price} <lable: class="product_price">促销价：${discount.price}</lable:></p>
					</c:when>
					<c:otherwise>
					   <p class="product_price">价格：${price}</p>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${not empty shand&&shand=='1'}">
						<p class="product_price"><font color="red" id="font1" >二手商品 &nbsp;&nbsp;&nbsp;&nbsp;</font>销量：${samount} </p>
					</c:when>
					<c:otherwise>
						<p class="product_price">销量：${samount}</p>
					</c:otherwise>
				</c:choose>
			</div>
		</td>
		</tr>
		</c:when>
	     <c:otherwise>
	     <td>
		       <div class="product_box">
					<a href="javascript:opendetial('${goodsid}','${shop.shopId}');">
						<img height="200" width="200" src="${ctx}${goodsPicture.url}" /> </a>
					<p>
						<a
							href="javascript:opendetial('${goodsid}','${shop.shopId}');">${goodsname}</a>
					</p>
					<c:choose>
					<c:when test="${discount.discountId>0}">
					  <p >原价：${price} <lable: class="product_price">促销价：${discount.price}</lable:></p>
					</c:when>
					<c:otherwise>
					   <p class="product_price">价格：${price}</p>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${not empty shand&&shand=='1'}">
						<p class="product_price"><font color="red" id="font1" >二手商品 &nbsp;&nbsp;&nbsp;&nbsp;</font>销量：${samount} </p>
					</c:when>
					<c:otherwise>
						<p class="product_price">销量：${samount}</p>
					</c:otherwise>
				</c:choose>
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