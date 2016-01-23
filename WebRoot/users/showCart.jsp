<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>我的购物车</title>
    <%@ include file="/common/top-head.jspf" %>
    <script src="${ctx}/js/cart/mycart.js" type="text/javascript"></script>
    <link href="${ctx}/css/cart/cartcss.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <div align="center" style="margin-top:-40px;">
      <%@ include file="/common/top-nav.jspf" %>
    </div>
    <div id="templatemo_main">
      <label style="color:red;">${errMsg }</label>
      <div class="divcenter">
        <form id="form1" name="form1">
          <input id="authorizedToken" name="authorizedToken" type="hidden" value="${userid }"/>
          <input id="cartIdlist" name="cartIdlist" type="hidden"/>
          <table align="center" class="tablex" id="shop">
            <tr bgcolor="#E2F4FC">
              <th class="title" width="80px">选择</th>
              <th class="title" colspan="2" width="200px">商品</th>
              <th class="title" width="100px">价格</td>
              <th class="title" width="100px">数量</th>
              <th class="title" width="100px">小计</td>
              <th class="title" width="100px">操作</th>
            </tr>
            <tr class="itemrowspan">
              <td border="0" colspan="7"><hr/></td>
            </tr>
            <c:forEach items="${requestScope.cartlist}" var="cart">
              <tr class="shopname" id="trshop_${cart.shop.shopId }">
                <td class="item"><input id="CheckAll_${cart.shop.shopId}" style="zoom:120%;" type="checkbox" value="${cart.cartId}"/><!--  name="checkedCart"  --></td>
                <td class="shopname" colspan="6">店铺:
                  <a href="${ctx }/viewProductAction_shop.action?shopid=${cart.shop.shopId}">${cart.shop.shopname}</a>
                </td>
              </tr>
              <c:forEach items="${cart.cartitems}" var="item">
                <tr class="itemrow" id="tritem_${item.goodsId }">
                  <td class="item"><input id="item_${cart.shop.shopId}" name="chkItem" type="checkbox" value="${item.itemId}"/></td>
                  <td class="item" height="80px" width="80px">
                    <a href="${ctx}/viewProductAction_product.do?gid=${item.goodsId}" target="_blank" title="${item.itemname }">
                      <img height="75px" src="${ctx}${item.goodsPicUrl}" width="75px"/>
                    </a>
                  </td>
                  <td class="item" width="200px">
                    <div id="detail">
                      <ul>
                        <li>
                          <a href="${ctx}/viewProductAction_product.do?gid=${item.goodsId}" target="_blank">${item.itemname}</a>
                        </li>
                        <li>${item.property}</li>
                        <li>
                          <span class="invalid" id="item_${item.itemId}"></span>
                        </li>
                      </ul>
                    </div>
                  </td>
                  <td class="item">
                    <span id="iprice_${item.itemId}">
                      <fmt:formatNumber minIntegerDigits="1" pattern="#.00" value="${item.price}"></fmt:formatNumber>
                    </span>
                  </td>
                  <td class="item">
                    <div style="background:#CCC;display: block;text-align: center;">
                      <p class="p_num">
                        <a href="javascript:minus('${item.goodsId }','${item.itemId}','${item.property}');" style="font-size: 16px;">
                          <img height="10px" src="${ctx }/image/cart/minus.png" width="10px"></img>
                        </a>
                        <input autocomplete="off" id="amount_${item.itemId}" readonly="readonly" style="width:40px;text-align:center;" type="text" value="${item.amount}"/>
                        <a href="javascript:plus('${item.goodsId }','${item.itemId}','${item.property}');">
                          <img height="10px" src="${ctx }/image/cart/plus.png" width="10px"></img>
                        </a>
                      </p>
                    </div>
                  </td>
                  <td class="item">
                    <span class="${item.price * item.amount}" id="itotal_${item.itemId}">
                      <fmt:formatNumber minIntegerDigits="1" pattern="#.00" value="${item.price * item.amount}"></fmt:formatNumber>
                    </span>
                  </td>
                  <td class="itemlink" id="test">
                    <div>
                      <a href="javascript:addFavourite('${item.goodsId}');">加入收藏</a>
                      <br/><br/>
                      <a class="delLink" href="#" id="${item.itemId }">删除</a>
                    </div>
                  </td>
                </tr>
              </c:forEach>
            </c:forEach>
          </table>
        </form>
        <div class="foot" id="foot">
          <label class="fl select-all"><input class="check-all" type="checkbox"/>&nbsp;全选</label>
          <div class="fr closing" id="submit">结 算</div>
          <div class="fr total">合计：￥
            <span id="priceTotal">0.00</span>
          </div>
          <div class="fr selected" id="selected">已选商品
            <span id="selectedTotal">0</span>件
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
