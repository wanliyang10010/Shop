<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
  <head>
  <title>店铺商品管理</title>
  	<%@ include file="/common/top-head.jspf"%>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css" />
<script type="text/javascript" src="${ctx}/js/web1.js"></script>
<script type="text/javascript" src="${ctx}/js/Goods/GoodsManage.js"></script>  
  </head>
  <body>
  <div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
  <div id="templatemo_main">
     <center>
	<form name="form1" action=""  id="form1" autocomplete="off">
	<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid}" />
	  <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	  <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
      <input type="hidden" name="shopId" id="shopId" value="${sessionScope.shop.shopId}" >
      <input type="hidden" name="goodId" id="goodId">
                            <div>
                             <table width="800px" align="center"  border="1">
                        <tr height="40"> 
                                     <td align="right" width="20%">
                                        <label for="textfield">店铺名称：</label>
                                    </td>
                                    <td align="left"  colspan="3">
                                      <label for="textfield">${sessionScope.shop.shopname}</label>
                                    </td>
                                </tr>
                                
                                 <tr height="40"> 
                                     <td align="right">
                                        <label for="textfield">店铺类别：</label>
                                    </td>
                                    <td align="left">
                                     <label for="textfield">${sessionScope.shop.shopcategory}</label>
                                    </td>
                                     <td align="right" width="20%">
                                        <label for="textfield">注册时间：</label>
                                    </td>
                                    <td align="left">
                                     <label for="textfield">${sessionScope.shop.regeditdate}</label>
                                    </td>
                                    </tr>
                            </table>
                             <table width="800">
                                <tr>
                                    <td align="right" style=" width:20%" >
                                    <label for="textfield">关键字：</label>
                                    </td>
                                    <td align="left">
                                          <select name="stype" id="stype">
									    <option value="所有商品">所有商品</option>
									    <option value="特价商品">特价商品</option>
									    <option value="热卖商品">热卖商品</option>
									    <option value="二手商品">二手商品</option>
									</select>
									 <script type="text/javascript">  
									 var ss='${param.stype}';
									 if(ss!="")
									 {
									     document.getElementById("stype").value='${param.stype}';  
                                         document.getElementById("stype")['${param.stype}'].selected= true; 
									 }
                                                                    </script>  
                                       <input type="text" name="keyword" id="keyword" size="25" value="${param.keyword}">
                                       <input id="btn_submit" type="button"  onclick="search();" value="查询">
                                       </td>
                                </tr>
                            </table>
 <c:if test="${page.pageSize>0}"> 
        <table width="800"  align="center" >
	     <tr height="40">
	          <td align="center" width=5%>序号</td>
	          <td align="center" width=45%>商品名称</td>
		      <td align="center" width=15%>状态</td>
		      <td align="center" width=15%>商品信息管理</td>
		      <td align="center" width=10%>特价</td>
		      <td align="center" width=10%>热销</td>
	     </tr>
		   <s:iterator value="#request.page" status="s">
		    <tr>
		         <td  align="center" width=5%>${s.count+(page.pageNo-1)*page.pageSize}</td>
		         <td align="center" width=45%>${goodsname}</td>
		          <c:choose>
			      <c:when test="${state=='0'}">
			                   <td width=15% align="center" color="red">
			                                       在售  <a href="javascript:updateG('${goodsid}','${amount}');">下架</a>  
			          </td>           
			     </c:when>    
			     <c:when test="${state=='1'}">
			                    <td width=15% align="center">
			                     下架  <a href="javascript:updateG('${goodsid}','${amount}');">开售</a></td>     
			     </c:when>  
			      <c:when test="${state=='3'}">
			                      <td width=15% align="center" color="red">
			                                       在售(首页显示)  <a href="javascript:updateG('${goodsid}','${amount}');">下架</a>  
			          </td>         
			     </c:when> 
			     <c:when test="${state=='5'}">
			                      <td width=15% align="center" color="red">
			                                     在售(二手商品)  <a href="javascript:updateG('${goodsid}','${amount}');">下架</a>  
			          </td>         
			     </c:when>       
			     <c:otherwise>
			      <td width=15% align="center">管理员下架</td>                   
			      </c:otherwise> 
			       </c:choose>
			     <td width=15% align="center">
			     <a href="javascript:opengoods('${goodsid}','${goodsname}','${price}','${amount}','${freight}');">价格库存信息</a><br/>
			     <a href="javascript:file('${goodsid}');">商品图片信息</a><br/>
			     <a href="javascript:item('${goodsid}','${typeid}');">商品描述信息</a><br/>
			     <a href="javascript:opendetial('${goodsid}','${sessionScope.shop.shopId}');">商品预览</a><br/>
			     <a href="javascript:deletegoods('${goodsid}');">删除</a><br/>
			     </td>
			    <c:choose>
			      <c:when test="${discount.discountId>0}">
			       <td align="center" width=10%>
			                                                 特价  <br/>
			                 <a href="javascript:AddDis('${goodsid}');">编辑特价</a>
			                                                 </td>             
			     </c:when>        
			     <c:otherwise>
			               <td  align="center" width=10%>
			                                       非特价<br/>
			            <a href="javascript:AddDis('${goodsid}');">特价促销</a>  
			          </td>                
			      </c:otherwise> 
			       </c:choose>
		        <c:choose>
			      <c:when test="${hot=='0'}">
			                     <td  align="center" width=10%>
			                                       非热卖<br/>
			             <a href="javascript:updateH('${goodsid}');">热卖促销</a>  
			          </td>          
			     </c:when>        
			     <c:otherwise>
			           <td  align="center" width=10%>
                                                                       热卖 <br/>
                        <a href="javascript:updateH('${goodsid}');">取消热卖</a>
                                                                                    </td>                  
			      </c:otherwise> 
			       </c:choose>
	             </tr> 
	     </s:iterator>
	   </table>
	   <div id="divedit" style="display:none">
	   <table width="800" align="center" oncontextmenu=return(false)>
				<tr>
					<td align="right" width="20%"><label for="textfield">商品名称：</label></td>
					<td align="left">
					 <input type="text" name="goodsname" id="goodsname" size="50" maxlength="30">
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">商品单价：</label></td>
					<td align="left">
					 <input type="text" name="price" id="price"  maxlength="7" onpaste="return false"
					 onkeyup="var myreg=/^[0-9]+\.?[0-9]{0,2}$/;if(!myreg.test(this.value)){this.value=''; }; "
					 oninput="var myreg=/^[0-9]+\.?[0-9]{0,2}$/;if(!myreg.test(this.value)){this.value=''; }; "   
					 onpropertychange="var myreg=/^[0-9]+\.?[0-9]{0,2}$/;if(!myreg.test(this.value)){this.value=''; }; "
					 >
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">运费：</label></td>
					<td align="left">
					 <input type="text" name="freight" id="freight"  maxlength="5" onpaste="return false"
					 onkeyup="var myreg=/^[0-9]+\.?[0-9]{0,2}$/;if(!myreg.test(this.value)){this.value=''; }; "
					 oninput="var myreg=/^[0-9]+\.?[0-9]{0,2}$/;if(!myreg.test(this.value)){this.value=''; }; "   
					 onpropertychange="var myreg=/^[0-9]+\.?[0-9]{0,2}$/;if(!myreg.test(this.value)){this.value=''; }; "
					 >
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">库存量：</label></td>
					<td align="left">
					<input type="text" name="amount" id="amount" maxlength="7" onpaste="return false"
					  onkeyup="var myreg=/^([1-9][0-9]*)$/;if(!myreg.test(this.value)){this.value=''; }; "
					  oninput="var myreg=/^([1-9][0-9]*)$/;if(!myreg.test(this.value)){this.value=''; }; "   
					 onpropertychange="var myreg=/^([1-9][0-9]*)$/;if(!myreg.test(this.value)){this.value=''; }; ">
					 <font color="red" id="fontStock" > </font><a href="javascript:openStock();">库存明细</a>
					</td>
				</tr>
				<tr>
				<tr>
					<td align="center" colspan="2">
					<input type="button" name="btn_submit" id="btn_submit" value="修改" onclick="updategoods();">
					 &nbsp;&nbsp; 
					<input type="button" name="btn_cancel" id="btn_cancel" value="取消" onclick="cancelupdate();"></td>
				</tr>
			</table>
			</div>
	    <%@ include file="/common/pagination.jspf" %>
	   </c:if>
	         <div id="msg" >
	              <font color="red" id="font1" >${msg}</font>
	             </div>
	    
	    </div>        
	 </form>
	</center>
	 <br/>
	  <br/> 
	</div>       
  </body>
</html>
