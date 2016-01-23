<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
  <head>
    <head>
      <META content="text/html; charset=UTF-8" http-equiv="Content-Type"></head>
      <title>${sessionScope.shopView.shopname}</title>
       <%@ include file="/common/top-head.jspf"%>
      <script src="${ctx}/js/web1.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/js/ViewGoods/ViewShop.js" type="text/javascript"></script>
      <script src="${ctx}/js/favourite/add2fav.js" type="text/javascript"></script>
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
            <input id="shopid" name="shopid" type="hidden" value="${sessionScope.shopView.shopId}"/>
            <input id="shopowner" name="shopowner" type="hidden" value="${shopView.userinfo.userinfoId}"/>
          	<input id="buyer" name="buyer" type="hidden" value="${userinfo.userinfoId}"/>
            <table width="950px">
              <tr height="40">
                <td align="right">
                  <label for="textfield">店铺名称：</label>
                </td>
                <td align="left">
                  <label for="textfield">${sessionScope.shopView.shopname}</label>
                  <span>|</span>
                  <a href="javascript:addFavouriteShop(${sessionScope.shopView.shopId});" >收藏本店铺</a>
                </td>
                <td align="right"><label for="textfield">店铺平均得分：</label></td>
                <td align="left" width="30%">
                <label for="textfield">${sessionScope.shopView.point}分（买家的平均打分，满分5分）</label></td>
              </tr>
              <tr height="40">
                <td align="right">
                  <label for="textfield">店铺类别：</label>
                </td>
                <td align="left" width="30%">
                  <label for="textfield">${sessionScope.shopView.shopcategory}</label>
                </td>
                <td align="right">
                  <label for="textfield">店铺保证金：</label>
                </td>
                <td align="left" width="30%">
                  <label for="textfield">${sessionScope.shopView.margin}</label>
                </td>
              </tr>
            </table>
            <table width="950">
              <tr height="40">
                <td align="center">
                  <a href="javascript:shopdetial('${sessionScope.shopView.shopId}');">店铺首页</a>
                </td>
                <td align="center">
                  <a href="javascript:openDiscount('${sessionScope.shopView.shopId}');">特价商品</a>
                </td>
                <td align="center">
                  <a href="javascript:openHot('${sessionScope.shopView.shopId}');">热卖商品</a>
                </td>
              </tr>
              <tr style="display:none">
                <td align="right">
                  <label for="textfield">id：</label>
                </td>
                <td align="left">
                  <input id="sid" name="sid" type="text" value="${sessionScope.shopView.shopId}"></td>
                </tr>
              </table>
              <c:if test="${msg==''}">
                <table align="center" width="930">
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
                                  <p>
                                    原价：${price}
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
                                  <p>
                                    原价：${price}
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
                                <p>
                                  原价：${price}
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
              <%@ include file="/common/paginationProduct.jspf"%>
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
