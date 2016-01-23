<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="cn.xaut.shop.pojo.GoodsDetial"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<s:token />
<title>商品库存信息</title>
	<%@ include file="/common/top-head.jspf"%>
<link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css" /> 
<script type="text/javascript" src="${ctx}/js/web1.js"></script>
<script type="text/javascript" src="${ctx}/js/Goods/GoodsStockInfo.js"></script>
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
	  <input type="hidden" name="goodsId" id="goodsId" value="${goods.goodsid}"/>
	   <input type="hidden" name="goodstockId" id="goodstockId"/>
			 <table width="800"   border="1" oncontextmenu=return(false)>
			 <tr>
					<td align="right" width="30%"><label for="textfield">商品名称：</label></td>
					<td align="left">${goods.goodsname}</td>
				</tr>
				 <% 
								List<GoodsDetial> list=(List<GoodsDetial>)request.getAttribute("GDetialList");
								if(list!=null&&list.size()>0)
								{
								%>
                 <tr id="tr_add">
                  <td align="right" style=" width:30%" ><label for="textfield">商品属性：</label>
                                    </td>
                  <td align="left">
                 
								<input type="hidden" name="listsize" id="listsize" value="<%=list.size()%>"/>
								<%
								 for(int i=0;i<list.size();i++)
								 {
								    GoodsDetial goodsDetial=list.get(i);
								    String[] str=goodsDetial.getItemvalue().split("，");
								    if(str.length>0)
									{
									%>
									<select name="itemtype" id="itemtype<%=i%>">
									 <option value="请选择">请选择</option>
									<%
									   for(int j=0;j<str.length;j++)
									 {
									     if(str[j].length()>10)
									     {
									     	str[j]=str[j].substring(0,9)+"...";
									     }
									 %>
									  <option value="<%=str[j]%>"><%=str[j]%></option>
									<% 
									}
									%>
									</select>
									<%
									}
									}
									%>
                  </td>
               </tr>
                <tr id="tr_update" style="display:none">
					<td align="right" width="30%"><label for="textfield">属性名称：</label></td>
					<td align="left"><font color="" id="itemname"></td>
				</tr>
              <tr>
					<td align="right"><label for="textfield">库存量：</label></td>
					<td align="left">
					 <input type="text" name="amount" id="amount" maxlength="7" onpaste="return false"
					  onkeyup="var myreg=/^([1-9][0-9]*)$/;if(!myreg.test(this.value)){this.value=''; }; "
					  oninput="var myreg=/^([1-9][0-9]*)$/;if(!myreg.test(this.value)){this.value=''; }; "   
					 onpropertychange="var myreg=/^([1-9][0-9]*)$/;if(!myreg.test(this.value)){this.value=''; }; ">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
					<input type="button" name="btn_update" id="btn_update" value="修改" onclick="update();" style="display:none"> 
					  &nbsp;&nbsp; 
					<input type="button" name="btn_submit" id="btn_submit" value="添加" onclick="add();">
					 &nbsp;&nbsp; 
					<input type="button" name="btn_cancel" id="btn_cancel" value="取消" onclick="cancel();"></td>
				</tr>
							<%
									}
									else
									{
									%>
									 <tr>
					<td align="center" colspan="2">
					<font color="red" id="font1" >该商品尚未添加商品子项,无需添加明细库存</font>
					 <a href="javascript:item('${goods.goodsid}','${goods.typeid}');">前往添加商品子项</a>
					</td>
				   </tr>
						<%}%>
			</table>
			<div>
	 <c:if test="${request.page!= null&&request.page.getTotalItems()>0}"> 		
       <table width="800"  align="center" >
	     <tr height="40">
	          <td align="center" width=10%>序号</td>
		      <td align="center" width=40%>商品属性</td>
		      <td align="center" width=30%>库存</td>
		      <td align="center" width=20%>操作</td>
	     </tr>
		     <s:iterator value="#request.page" status="s">
		    <tr>
		         <td  align="center" width=10%>${s.count+(page.pageNo-1)*page.pageSize}</td>
		        <td align="center" width=40%>${goodstype}</td>
			    <td  align="center" width=30%>${amount}</td>
			     <td  align="center" width=20%>
			    	<a href="javascript:updateItem('${goodstockId}','${goodstype}','${amount}');">修改</a>
					  <a href="javascript:deleteItem('${goodstockId}');">删除</a>
			     </td>
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
