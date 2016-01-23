<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
  <head>
    <META content="text/html; charset=UTF-8" http-equiv="Content-Type">
      <title>商品搜索</title>
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
            <input id="sortype" name="sortype" type="hidden" value="${sortype}"/>
            <div>
              <tr>
                <td align="right" style=" width:20%">
                  <label for="textfield">搜索：</label>
                </td>
                <td align="left">
                  <select id="stype" name="stype">
                    <option selected value="商品">商品</option>
                    <option value="二手">二手</option>
                    <option value="店铺">店铺</option>
                  </select>
                  <input id="keyword" name="keyword" size="45" type="text" value="${param.keyword}">
                    <button id="btn_submit" onclick="searchType();" type="submit">查询</button>
                  </td>
                </tr>
                <table width="800">

                  <tr style="display:none">
                    <td align="right">
                      <label for="textfield">id：</label>
                    </td>
                    <td align="left">
                      <input id="Id" name="Id" type="number"></td>
                    </tr>
                  </table>
                  <c:if test="${page.pageSize>0}">
                    <table align="center" width="800">
                      <tr >
                        <td align="center" colspan="4">
                          <a href="javascript:search(1);" id="sortnew" style="font-size:15px;">新品排序</a>
                          <a href="javascript:search(2);" id="sortlow" style="font-size:15px;">价格由低到高</a>
                          <a href="javascript:search(3);" id="sortheight" style="font-size:15px;">价格由高到低</a>
                          <a href="javascript:search(4);" id="sortsub" style="font-size:15px;">销量递减排序</a>
                        </td>
                      </tr>
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
                                  <a href="javascript:opendetial('${goodsid}','${shop.shopId}');">${goodsname}
                                  </a>
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
                  </c:if>

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
