<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
<%@ page pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
 <head>
	<META http-equiv="Content-Type" content="text/html; charset=UTF-8">	
   	<title>商品特价促销</title>  
  	<%@ include file="/common/top-head.jspf"%> 
	<script type="text/javascript" src="${ctx}/My97DatePicker/WdatePicker.js"></script>  
	<script type="text/javascript" src="${ctx}/js/Goods/GoodsManage.js"></script> 
 </head>
  <body>
  <div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
  <div id="templatemo_main">
     <center>
	<form name="form1" action=""  id="form1" >
	<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
	 <input type="hidden" name="gid" id="gid" value="${good.goodsid}">
	<h1>商品促销查看</h1>
                            <div>
                             <table width="500px" align="center"  border="1">
                             <tr>
			      <td align="right" colspan="2" >
			         <a href="javascript:edit('${good.goodsid}');">编辑促销</a>
			    </td>  
			</tr>
                        <tr height="40"> 
                                     <td align="right" width=30%>
                                        <label for="textfield">商品名称：</label>
                                    </td>
                                    <td align="left" >
                                      <label for="textfield">${good.goodsname}</label>
                                    </td>
                                </tr>
                                
                                 <tr height="40"> 
                                     <td align="right"  width=30%>
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
                                    <td align="left">${discount.price}</td>
                                </tr>
                            </table>   
	    </div>        
	 </form>
	</center> 
	</div>
  </body>
</html>
