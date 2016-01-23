<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
<%@ page pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
  <head>
	<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<s:token />
   	<title>商品特价促销</title>   
   	<%@ include file="/common/top-head.jspf"%>
	<script type="text/javascript" src="${ctx}/My97DatePicker/WdatePicker.js"></script> 
	<script type="text/javascript" src="${ctx}/js/backstage/AddDiscount.js"></script> 
 </head>
  <body>
  <div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
  <div id="templatemo_main">
     <center>
	<form name="form1" action=""  id="form1" autocomplete="off">
	<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
	<h1>商品促销</h1>
                            <div>
                             <table width="500px" align="center"  border="1" oncontextmenu=return(false)>
                        <tr height="40"> 
                                     <td align="right">
                                        <label for="textfield">商品名称：</label>
                                    </td>
                                    <td align="left" >
                                      <label for="textfield">${good.goodsname}</label>
                                    </td>
                                </tr>
                                
                                 <tr height="40"> 
                                     <td align="right">
                                        <label for="textfield">商品价格(元)：</label>
                                    </td>
                                    <td align="left">
                                     <label for="textfield">${good.price}</label>
                                    </td>
                                    </tr>
                                 <tr height="40">
                                    <td align="right" style=" width:30%" >
                                    <label for="textfield">促销价：</label>
                                    </td>
                                    <td align="left">
                                       <input type="text" name="price" id="price" maxlength="7" onpaste="return false"
                                       onkeyup="var myreg=/^[0-9]+\.?[0-9]{0,2}$/;if(!myreg.test(this.value)){this.value=''; }; "
                                       oninput="var myreg=/^[0-9]+\.?[0-9]{0,2}$/;if(!myreg.test(this.value)){this.value=''; };"   
					 					onpropertychange="var myreg=/^[0-9]+\.?[0-9]{0,2}$/;if(!myreg.test(this.value)){this.value=''; };"
                                        value="${discount.price}">
                                        </td>
                                </tr>
                              <c:choose>
								<c:when test="${discount!=null&&discount.discountId>0}">
								<tr align="center" height="40" id="tr_update"> 
                                 <td colspan="2">
                                     <input id="btn_submit" type="button"  onclick="update('${good.price}');" value="更新促销">
                                     &nbsp;&nbsp;&nbsp;&nbsp;
                                      <input id="btn_submit" type="button"  onclick="deleted();" value="终止促销">
                                    </td>
                                 </tr>
								</c:when>
								<c:otherwise>
									<tr align="center" height="40" id="tr_add" > 
                                 <td colspan="2">
                                     <input id="btn_submit" type="button"  onclick="add('${good.price}');" value="添加促销">
                                     &nbsp;&nbsp;&nbsp;&nbsp;
                                      <input id="btn_submit" type="button"  onclick="cancel();" value="重置价格">
                                    </td>
                                 </tr>
								</c:otherwise>
							</c:choose>
                                
                                 
                                
                                 <tr style="display:none"> 
                                    <td align="left">
                                        <input type="number" name="goodId" id="goodId" value="${good.goodsid}">
                                        <input type="number" name="discountid" id="discountid" value="${discount.discountId}">
                                        <input type="number" name="shopId" id="shopId" value="${good.shop.shopId}" >
                                    </td>
                                    </tr>
                            </table>   
	    </div>        
	 </form>
	</center> 
	</div>      
  </body>
</html>
