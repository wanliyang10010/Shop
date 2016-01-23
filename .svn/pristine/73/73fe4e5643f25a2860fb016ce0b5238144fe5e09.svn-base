<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
  <head>
    <META content="text/html; charset=UTF-8" http-equiv="Content-Type">
      <title>搜索店铺</title>
      <%@ include file="/common/top-head.jspf"%>
      <link href="${ctx}/css/page.css" rel="stylesheet" type="text/css"/>
      <script src="${ctx}/js/web1.js" type="text/javascript"></script>
      <script src="${ctx}/js/ViewGoods/ViewProduct.js" type="text/javascript"></script>
      <script src="${ctx}/js/Alert.js" type="text/javascript"></script>
    </head>
    <body>
    <div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
      <center>
        <div id="templatemo_main">
          <form action="" id="form1" name="form1">
            <input id="pageNo" name="page.pageNo" type="hidden" value="${page.pageNo}"/>
            <input id="pageSize" name="page.pageSize" type="hidden" value="${page.pageSize}"/>
            <div>
              <tr>
                <td align="right" style=" width:20%">
                  <label for="textfield">店铺名称：</label>
                </td>
                <td align="left">
                  <input id="keyword" name="keyword" size="45" type="text" value="${param.keyword}">
                    <button id="btn_submit" onclick="listShop();" type="submit">查询</button>
                  </td>
                </tr>
                <table align="center" width="800">
                  <s:iterator status="s" value="#request.page">
                    <c:choose>
                      <c:when test="${s.count%4==1}">
                        <tr>
                          <td>
                            <div class="product_box">
                              <a href="javascript:shopdetial('${shopId}');">
                                <img height="100" src="${ctx}/image/shoplogo.jpg"/></a>
                              <p class="product_price">
                                <a href="javascript:shopdetial('${shopId}');">${shopname}</a>
                              </p>
                              <p>${productcategory} &nbsp;&nbsp;&nbsp;&nbsp; ${shopcategory}</p>
                            </div>
                          </td>
                        </c:when>
                        <c:when test="${s.count%4==0}">
                          <td>
                            <div class="product_box">
                              <a href="javascript:shopdetial('${shopId}');">
                                <img height="100" src="${ctx}/image/shoplogo.jpg"/></a>
                              <p class="product_price">
                                <a href="javascript:shopdetial('${shopId}');">${shopname}</a>
                              </p>
                              <p>${productcategory} &nbsp;&nbsp;&nbsp;&nbsp; ${shopcategory}</p>
                            </div>
                          </td>
                        </tr>
                      </c:when>
                      <c:otherwise>
                        <td>
                          <div class="product_box">
                            <a href="javascript:shopdetial('${shopId}');">
                              <img height="100" src="${ctx}/image/shoplogo.jpg"/></a>
                            <p class="product_price">
                              <a href="javascript:shopdetial('${shopId}');">${shopname}</a>
                            </p>
                            <p>${productcategory} &nbsp;&nbsp;&nbsp;&nbsp; ${shopcategory}</p>
                          </div>
                        </td>
                      </c:otherwise>
                    </c:choose>
                  </s:iterator>
                </table>
                <%@ include file="/common/paginationProduct.jspf" %>
                <div id="msg">
                  <font color="red" id="font1">${msgs}</font>
                </div>
              </form>
              <br/>
            </div>
          </center>
        </body>
      </html>
