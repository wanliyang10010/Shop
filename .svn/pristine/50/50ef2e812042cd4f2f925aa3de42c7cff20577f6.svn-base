<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<s:token />
<title>商品描述信息</title>
	<%@ include file="/common/top-head.jspf"%>
<link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css"/>  
<script type="text/javascript" src="${ctx}/js/web1.js"></script>
<script type="text/javascript" src="${ctx}/js/Goods/GoodsDetialInfo.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
<div id="templatemo_main">
	<center>
		<form name="form1" action="" id="form1" autocomplete="off">
		<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
	  <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	  <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
	  <input type="hidden" name="goodId" id="goodId" value="${sessionScope.goodsAdd.goodsid}"/>
	  <input type="hidden" name="goodsId" id="goodsId" value="${sessionScope.goodsAdd.goodsid}"/>
	  <input type="hidden" name="gdetialId" id="gdetialId"/>
	  <input type="hidden" name="typeId" id="typeId" value="${param.typeId}"/>
			 <table width="800"   border="1">
			 <tr >
					<td align="right"><label for="textfield">商品属性添加使用说明：</label></td>
					<td align="left">
					 1、商品属性：表示商品的产地、材质等描述性信息，用于展示在商品详情；<br/>
					 2、商品子项：表示商品的尺码、颜色等商品规格参数，用于商品购买时选择类别；<br/>
					 3、例如：商品属性：产地-xx省xx市；商品子项：尺码-S，M，L，XL <font color="red">(中间以逗号隔开) </font>；<br/>
					</td>
				</tr>
                 <tr>
                  <td align="right" style=" width:30%" ><label for="textfield">商品名称：</label>
                                    </td>
                  <td align="left">${sessionScope.goodsAdd.goodsname}</td>
               </tr>
               <c:choose>
				<c:when test="${sessionScope.GoodsTypeItemList!=null&&sessionScope.GoodsTypeItemList.size()>0}">
									<tr>
					<td align="right"><label for="textfield">属性类别：</label></td>
					<td align="left">
					 <select name="itemtype" id="itemtype">
					       <option value="请选择">请选择</option>   
					       <option value="1">商品子项</option>   
					       <option value="0">商品属性</option>
					       
					</select>
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">属性名称：</label></td>
					<td align="left">
					<select name="itemid" id="itemid">
					       <option value="请选择">请选择</option>   
							<c:forEach items="${sessionScope.GoodsTypeItemList}" var="goodstypeitem">
								 <option value="${goodstypeitem.gtitemId}">${goodstypeitem.itemname}</option>
							</c:forEach>
					</select>
					<a href="javascript:openTypeItem('${sessionScope.goodsAdd.typeid}');">添加商品属性</a>
					<font color="red" id="font1" >${msgjudge}</font>
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">属性描述：</label></td>
					<td align="left">
					 <textarea rows="3" cols="60" name="itemvalue" id="itemvalue" 
					 maxlength="30"  onkeyup="if(value.length>30) value=value.substr(0,30)" style="overflow:hidden"></textarea>
					</td>
				</tr>
				<tr>
				<tr>
					<td align="center" colspan="2">
					<input type="button" name="btn_update" id="btn_update" value="修改" onclick="update();" style="display:none"> 
					  &nbsp;&nbsp; 
					<input type="button" name="btn_submit" id="btn_submit" value="添加" onclick="add();">
					 &nbsp;&nbsp; 
					<input type="button" name="btn_cancel" id="btn_cancel" value="取消" onclick="cancel();"></td>
				</tr>
								</c:when>
								<c:otherwise>
									<tr>
					<td align="center" colspan="2">
					<font color="red" id="font1" >您尚未添加商品描述项，请添加商品描述项后再商品描述信息</font>
					  <a href="javascript:goTypeItem('${sessionScope.goodsAdd.typeid}');">前往添加商品描述项</a>
					</td>
				</tr>
								</c:otherwise>
							</c:choose>
               
			</table>
			<div>
		 <c:if test="${msg==''}"> 		
       <table width="800"  align="center" >
	     <tr height="40">
	          <td align="center" width=10%>序号</td>
		      <td align="center" width=15%>商品属性</td>
		      <td align="center" width=40%>属性描述</td>
		      <td align="center" width=15%>属性类别</td>
		      <td align="center" width=30%>操作</td>
	     </tr>
		     <s:iterator value="#request.page" status="s">
		    <tr>
		         <td  align="center" width=10%>${s.count+(page.pageNo-1)*page.pageSize}</td>
		        <td align="center" width=15%>${gtItem.itemname}</td>
			    <td  align="center" width=40%>${itemvalue}</td>
			     <c:choose>
			      <c:when test="${itemtype=='0'}">
			           <td width=15% align="center">商品属性 </td>            
			     </c:when>        
			     <c:otherwise>
			          <td width=15% align="center">商品子项 </td>                      
			      </c:otherwise> 
			       </c:choose>
			     <td  align="center" width=30%>
			    	<a href="javascript:updateItem('${gdetialId}','${gtItem.gtitemId}','${itemvalue}','${itemtype}');">修改</a>
					  <a href="javascript:deleteItem('${gdetialId}');">删除</a>
			     </td>
		    </tr>
	    	   </s:iterator>
	   </table>
	    </c:if>
	    <%@ include file="/common/pagination.jspf" %>
		</form>
	</center>
	 <br/>
	  <br/>
	</div>
</body>
</html>
