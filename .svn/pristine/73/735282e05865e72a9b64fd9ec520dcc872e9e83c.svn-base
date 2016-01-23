<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
  <head>
    <META content="text/html; charset=UTF-8" http-equiv="Content-Type">
      <title>热卖商品</title>
       <%@ include file="/common/top-head.jspf"%>
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
            <h1>热卖商品</h1>
            <table align="center" width="800">
              <s:iterator status="s" value="#request.page">
                <c:choose>
                  <c:when test="${s.count%4==1}">
                    <tr>
                      <td>
                        <div class="product_box">
                          <a href="javascript:opendetial('${goodsid}','${shop.shopId}');">
                            <img height="200" src="${ctx}${goodsPicture.url}" width="200"/>
                          </a>
                          <p>
                            <a href="javascript:opendetial('${goodsid}','${shop.shopId}');">${goodsname}</a>
                          </p>
                          <c:choose>
                            <c:when test="${discount.discountId>0}">
                              <p >原价：${price}
                                <lable: class="product_price">促销价：${discount.price}</lable:>
                              </p>
                            </c:when>
                            <c:otherwise>
                              <p class="product_price">价格：${price}</p>
                            </c:otherwise>
                          </c:choose>
                          <c:choose>
                            <c:when test="${not empty shand&&shand=='1'}">
                              <p class="product_price">
                                <font color="red" id="font1">二手商品 &nbsp;&nbsp;&nbsp;&nbsp;</font>销量：${samount}
                              </p>
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
                            <img height="200" src="${ctx}${goodsPicture.url}" width="200"/>
                          </a>
                          <p>
                            <a href="javascript:opendetial('${goodsid}','${shop.shopId}');">${goodsname}</a>
                          </p>
                          <c:choose>
                            <c:when test="${discount.discountId>0}">
                              <p >原价：${price}
                                <lable: class="product_price">促销价：${discount.price}</lable:>
                              </p>
                            </c:when>
                            <c:otherwise>
                              <p class="product_price">价格：${price}</p>
                            </c:otherwise>
                          </c:choose>
                          <c:choose>
                            <c:when test="${not empty shand&&shand=='1'}">
                              <p class="product_price">
                                <font color="red" id="font1">二手商品 &nbsp;&nbsp;&nbsp;&nbsp;</font>销量：${samount}
                              </p>
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
                          <img height="200" src="${ctx}${goodsPicture.url}" width="200"/>
                        </a>
                        <p>
                          <a href="javascript:opendetial('${goodsid}','${shop.shopId}');">${goodsname}</a>
                        </p>
                        <c:choose>
                          <c:when test="${discount.discountId>0}">
                            <p >原价：${price}
                              <lable: class="product_price">促销价：${discount.price}</lable:>
                            </p>
                          </c:when>
                          <c:otherwise>
                            <p class="product_price">价格：${price}</p>
                          </c:otherwise>
                        </c:choose>
                        <c:choose>
                          <c:when test="${not empty shand&&shand=='1'}">
                            <p class="product_price">
                              <font color="red" id="font1">二手商品 &nbsp;&nbsp;&nbsp;&nbsp;</font>销量：${samount}
                            </p>
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
            <div id="msg">
              <font color="red" id="font1">${msg}</font>
            </div>
          </form>
          <br/>
          <br/>
        </div>
      </center>
    </body>
    <script type="text/javascript">
      $("img").each(function () {
        this.onerror = function () {
          this.src = "image/picerror.jpg";
        };
      });
    </script>
  </html>
