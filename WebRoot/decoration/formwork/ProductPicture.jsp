<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="${ctx}/js/web1.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/jquery-1.9.0.js"></script>
<script type="text/javascript" src="${ctx}/js/ViewGoods/ProductDetial.js"></script>  
<title>${goods.goodsname}</title>    
<style type="text/css">
div {
	
		align:center;
		margin-left:auto; margin-right:auto;
	}	
	body{text-align:center} 
</style> 
<link href="${ctx}/css/MyShop/templatemo_style.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="${ctx}/css/MyShop/nivo-slider.css"
	type="text/css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/css/MyShop/ddsmoothmenu.css" />
</head>
<body>
	<center>
	<form name="form1" action=""  id="form1">
	 <input type="hidden" name="goodsid" id="goodsid" value="${goods.goodsid}"/>
	<br/>
	   <table width="800"  align="center" border="0">
	   <tr>
	     <td align="center">
	       <a href="javascript:openDetialPicture(${goods.goodsid})">商品详情</a>
	     </td>
	     <td align="center">
	      <a href="javascript:openEvaPicture(${goods.goodsid})">商品评价</a>
	     </td >
	   </tr>
	   </table>
	   <c:choose>
	   <c:when test="${tag=='detial'}">
	   <div id="div_detial" >
	   <table width="800"  align="center"  >
	   <c:forEach items="${GItemList}" var="gitem" varStatus="s">
	   <c:choose>
	   <c:when test="${s.count%4==1}">
		<tr>  
	         <td>
		      ${gitem.gtItem.itemname}:${gitem.itemvalue}
		</td>
	     </c:when>
	     <c:when test="${s.count%4==0}">
	     <td>
		      ${gitem.gtItem.itemname}:${gitem.itemvalue}
		</td>
		</tr>
		</c:when>
	     <c:otherwise>
	     <td>
		       ${gitem.gtItem.itemname}:${gitem.itemvalue}
			</td>
	     </c:otherwise> 
		 </c:choose>
		</c:forEach>
		
		<table width="800"  align="center" border="0" >
	   <c:forEach items="${GPictureList}" var="gpicture">
	   <tr>
			<img height="400" src="${ctx}${gpicture.url}" />
			 </tr>
				</c:forEach>
		</table>											
	   </div>
	   </c:when>
	<c:otherwise>
	<div id="div_evalution" >
	<table width="800"  align="center" border="0" >
       <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	  <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
	   <c:if test="${msg==''}">
		 <s:iterator value="#request.page" status="s">
		  <tr height="40">  
		  <td colspan="3">
		    <font color="red" aligen="left" >商品评价--</font> 
		       <c:choose>
			      <c:when test="${ispublic=='0'}">
			                                匿名用户
			     </c:when>        
			     <c:otherwise>
			      用户：${userinfo.username} 
			      </c:otherwise> 
			  </c:choose>
		    </td>
		      </tr>
		    <tr height="40">   
		       <td width=20% align="center">买家自评：</td>
		        <td width=60% align="center">${goodscontent}</td>  
			     <td width=20% align="center">${evaluationTime}</td>
			</tr>
			     <c:if test="${not empty evalution.addcontent}">
			 <tr height="40">   
		       <td  align="center">买家追评：</td>
		        <td  align="center">${addcontent}</td>
			    <td align="center">${addTime}</td>
			    </tr>  
			     </c:if>
			   <c:if test="${ not empty evalution.checkIdea}">
			  <tr height="40">   
		       <td align="center">店家回复：</td>
		        <td  align="center">${checkIdea}</td>
			    <td  align="center">${checkTime}</td>
			   </tr>    
			 </c:if>
	    </s:iterator>
	      </c:if>
	   </table>
	    <%@ include file="/common/pagination.jspf" %>
	    <font color="red" id="font1" >${msg}</font>
		</div>
		 </c:otherwise> 
		 </c:choose>
		</form>
	</center>
</body>
</html>
