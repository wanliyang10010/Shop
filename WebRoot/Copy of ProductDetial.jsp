<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.xaut.shop.pojo.GoodsStock"%>
<%@ include file="/common/taglibs.jspf"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>${goods.goodsname}</title>
    <link href="${ctx}/css/jquery.spinner.css" rel="stylesheet"/>
    <link href="${ctx}/css/zzsc.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/css/magiczoomplus.css" rel="stylesheet" type="text/css"/>
    <script src="${ctx}/js/web1.js" type="text/javascript"></script>
    <div align="center" style="margin-top:-40px;">
      <%@ include file="/common/top.jspf"%>
    </div>
  </head>
  <body>
    <div id="templatemo_main">
      <center>
        <c:if test="${msg==''}">
          <input id="shopowner" name="shopowner" type="hidden" value="${shop.userinfo.userinfoId}"/>
          <input id="buyer" name="buyer" type="hidden" value="${userinfo.userinfoId}"/>
          <table width="900px">
            <tr height="40px">
              <td align="center" colspan="4">店铺名称：${shop.shopname} |店铺类别：${shop.shopcategory}|店铺保证金：${shop.margin} |
                <a href="javascript:addFavouriteShop(${shop.shopId});">收藏该店铺</a>
              </td>
            </tr>
            <tr height="40px">
              <td align="left" colspan="4">
                <a href="javascript:shopdetial('${shop.shopId}');">所有商品></a>${goods.goodsname}</td>
              <tr></table>
              <table width="900px">
                <tr>
                  <td align="right" style="width:40%;">
                    <div class="box">
                      <div class="left-pro">
                        <div class="t2">
                          <a class="MagicZoom MagicThumb" href="${ctx}${goods.goodsPicture.url}" id="zoom1">
                            <img class="main_img" id="main_img" src="${ctx}${goods.goodsPicture.url}" style="width:350px; height:350px;"/>
                          </a>
                        </div>
                        <div class="t1">
                          <img id="gotop" src="${ctx}/image/viewproduct/gotop.gif"/>
                          <div id="showArea">
                            <c:forEach items="${GPictureList}" var="gpicture">
                              <a href="${ctx}${gpicture.url}" rel="zoom1" rev="${ctx}${gpicture.url}"><img src="${ctx}${gpicture.url}"/>
                              </a>
                            </c:forEach>
                          </div>
                          <img id="gobottom" src="${ctx}/image/viewproduct/gobottom.gif"/>
                        </div>
                      </div>
                    </div>
                  </td>
                  <c:if test="${!empty goods.discount.price }"></c:if>
                  <form id="form1" name="form1">
                    <input id="pageNo" name="page.pageNo" type="hidden" value="${page.pageNo}"/>
                    <input id="pageSize" name="page.pageSize" type="hidden" value="${page.pageSize}"/>
                    <input id="shopid" name="shopid" type="hidden" value="${shop.shopId}"/>
                    <input id="goodsId" name=goodsId type="hidden" value="${goods.goodsid}"/>
                    <input id="gid" name="gid" type="hidden" value="${goods.goodsid}"/>
                    <input id="num" name="amount" type="hidden" value="1"/>
                    <input id="viewtag" name="viewtag" type="hidden" value="${param.viewtag}"/>
                    <td align="left" style="width:60%;">
                      <h5>${goods.goodsname}</h5>
                      <c:if test="${not empty goods.shand&&goods.shand=='1'}">
                        <font color="red" id="font1">二手商品 &nbsp;&nbsp;&nbsp;&nbsp;</font>
                      </c:if>
                      <table align="left" border="1px" id="save_text" style="width:100%;">
                        <tr height="40px" id="tr_p" style="display:none;font-size: 15px;color:red;">
                          <td align="right" width="30%">促销价￥：</td>
                          <td align="left">${goods.discount.price}</td>
                        </tr>
                        <tr height="40px">
                          <td align="left" width="30%">商品售价￥：</td>
                          <td align="left">${goods.price}</td>
                        </tr>
                        <tr height="40px">
                          <td align="right" width="30%">运费￥：</td>
                          <td align="left">${goods.freight}</td>
                        </tr>
                        <tr height="40px">
                          <td align="right">总库存：</td>
                          <td align="left">
                            <span class="goods_amount">${goods.amount}</span>件</td>
                          <script type="text/javascript">
                            var ss = '${goods.discount.discountId}';
                            if (ss > 0) {
                              document.getElementById("tr_p").style.display = "";
                            } else {
                              document.getElementById("tr_p").style.display = "none";
                            }
                          </script>
                          <tr height="40px">
                            <td align="right">
                              <label for="textfield">累计销量：</label>
                            </td>
                            <td align="left">${goods.samount}
                              <a href="javascript:openDetialOrEva('evaluation')">查看评价</a>
                            </td>
                          </tr>
                          <c:if test="${StockList!=null&&StockList.size()>0}">
                            <tr height="40px">
                              <td align="right">
                                <label for="textfield">商品类别：</label>
                              </td>
                              <td align="left" class="td_properities">
                                <s:iterator status="s" value="#request.StockList">
                                  <c:choose>
                                    <c:when test="${amount>0}">
                                      <input id="radio_${goodstockId}" name="property" type="radio" value="${goodstockId}">${goodstype}(库存：
                                        <span>${amount}</span>)
                                      </c:when>
                                      <c:otherwise>
                                        <input disabled="true" id="radio_${goodstockId}" name="property" type="radio" value="${goodstockId}">${goodstype}(库存：
                                          <span>${amount}</span>)
                                        </c:otherwise>
                                      </c:choose>
                                      <c:if test="${s.count%2==0}">
                                        <br/>
                                      </c:if>
                                    </s:iterator>
                                  </td>
                                </tr>
                              </c:if>
                              <tr height="40px">
                                <td align="right">数量：</td>
                                <td align="left"><input class="spinner" id="amount" onafterpaste="this.value=this.value.replace(/\D/g,'')" onkeyup="this.value=this.value.replace(/\D/g,'')" type="text"/></td>
                              </tr>
                              <tr height="45px">
                                <td align="center">
                                  <a href="javascript:addFavourite('${goods.goodsid}');">收藏商品</a>
                                </td>
                                <td align="center"><input id="add2cart" onclick="add2Cart();" style="height:30px" type="button" value="加入购物车"/>
                                  <input id="btb_buynow" onclick="doBuyNowSubmit();" style="height:30px" type="button" value="立即购买"></td>
                                  <script type="text/javascript">
                                    var ss = '${goods.amount}';
                                    if (ss <= 0) {
                                      document.getElementById("add2cart").disabled = "true";
                                      document.getElementById("btn_cancel").disabled = "true";
                                    }
                                  </script>
                                </tr>
                              </table>
                            </td>
                          </form>
                        </tr>
                      </table>
                      <div class="float_l" id="sidebar">
                        <div class="sidebar_box">
                          <span class="bottom"></span>
                          <h3 align="left">
                            畅销
                            <a "" href="${ctx}/viewProductAction_listSale.do?keyword=">更多畅销</a>
                          </h3>
                          <div class="content">
                            <s:iterator status="s" value="#request.GoodList">
                              <div class="bs_box">
                                <a href="javascript:opendetial('${goodsid}','${shop.shopId}');">
                                  <img height="180" src="${ctx}${goodsPicture.url}" width="180"/>
                                </a>
                                <h4>
                                  <a href="javascript:opendetial('${goodsid}','${shop.shopId}');">${goodsname}</a>
                                </h4>
                                <c:choose>
                                  <c:when test="${discount.discountId>0}">
                                    <p>原价：${price}</p>
                                    <p>
                                      <lable: class="price">促销价：${discount.price}</lable:>
                                    </p>
                                  </c:when>
                                  <c:otherwise>
                                    <p class="price">价格：${price}</p>
                                  </c:otherwise>
                                </c:choose>
                                <div class="cleaner"></div>
                              </div>
                            </s:iterator>
                          </div>
                        </div>
                      </div>

                      <div class="float_r" id="content">
                        <table align="center" width="90%">
                          <tr height="40">
                            <td align="center">
                              <a href="javascript:openDetialOrEva('detial');" style="font-size:15px;">商品描述</a>
                            </td>
                            <td align="center">
                              <a href="javascript:openDetialOrEva('evaluation');" style="font-size:15px;">商品评价</a>
                            </td>
                          </tr>
                        </table>
                        <div align="center" id="div_detial">
                          <br/>
                          <table align="center" width="90%">
                            <c:forEach items="${GItemList}" var="gitem" varStatus="s">
                              <c:choose>
                                <c:when test="${s.count%4==1}">
                                  <tr height="45px">
                                    <td>${gitem.gtItem.itemname}:${gitem.itemvalue}</td>
                                  </c:when>
                                  <c:when test="${s.count%4==0}">
                                    <td>${gitem.gtItem.itemname}:${gitem.itemvalue}</td>
                                  </tr>
                                </c:when>
                                <c:otherwise>
                                  <td>${gitem.gtItem.itemname}:${gitem.itemvalue}</td>
                                </c:otherwise>
                              </c:choose>
                            </c:forEach>
                          </table>
                          <br/>
                          <table align="center" border="1px" width="90%">
                            <c:forEach items="${GPictureListAll}" var="gpicture">
                              <tr>
                                <td align="center"><img height="400px" src="${ctx}${gpicture.url}" width="500px"/></td>
                              </tr>
                            </c:forEach>
                          </table>
                        </div>
                        <div align="center" id="div_eva" style="display: none">
                          <table align="center" border="0" width="90%">
                            <input id="pageNo" name="page.pageNo" type="hidden" value="${page.pageNo}"/>
                            <input id="pageSize" name="page.pageSize" type="hidden" value="${page.pageSize}"/>
                            <s:iterator status="s" value="#request.page">
                              <tr height="40">
                                <td>
                                  <font aligen="left" color="red">商品评价${s.count+(page.pageNo-1)*page.pageSize}</font>
                                </td>
                                <c:choose>
                                  <c:when test="${ispublic=='0'}">
                                    <td colspan="2">匿名用户</td>
                                  </c:when>
                                  <c:otherwise>
                                    <td colspan="2">${userinfo.username }</td>
                                  </c:otherwise>
                                </c:choose>
                              </tr>
                              <tr height="40">
                                <td align="center" width=20%>买家评论：</td>
                                <td align="center" width=60%>${goodscontent}</td>
                                <td align="center" width=20%>${evaluationTime}</td>
                              </tr>
                              <c:if test="${not empty addcontent}">
                                <tr height="40">
                                  <td align="center" width=20%>买家追评：</td>
                                  <td align="center" width=60%>${addcontent}</td>
                                  <td align="center" width=20%>${addTime}</td>
                                </tr>
                              </c:if>
                              <c:if test="${ not empty checkIdea}">
                                <tr height="40">
                                  <td align="center" width=20%>店家回复：</td>
                                  <td align="center" width=60%>${checkIdea}</td>
                                  <td align="center" width=20%>${checkTime}</td>
                                </tr>
                              </c:if>
                            </s:iterator>
                          </table>
                          <%@ include file="/common/pagination.jspf"%>
                          <font color="red" id="font1">${msg1}</font>
                        </div>
                      </div>
                      <br/>
                      <br/>
                      <br/>
                    </c:if>
                  </center>

                  <div id="msg">
                    <font color="red" id="font1">${msg}</font>
                  </div>
                  <br/>
                  <br/>
                </div>
                <footer>
                  <script src="${ctx}/js/mzp-packed.js" type="text/javascript"></script>
                  <script src="${ctx}/js/ViewGoods/ProductDetial.js" type="text/javascript"></script>
                  <script src="${ctx}/js/cart/add2cart.js" type="text/javascript"></script>
                  <script src="${ctx}/js/jquery.spinner.js" type="text/javascript"></script>
                  <script src="${ctx}/js/zzsc.js" type="text/javascript"></script>
                </footer>
              </body>
              <script type="text/javascript">
                $("img").each(function () {
                  this.onerror = function () {
                    this.src = "image/picerror.jpg";
                  };
                });
                var ss = document.getElementById("viewtag").value;
                //alert(ss);
                if (ss == "evaluation") {
                  document.getElementById("div_eva").style.display = "";
                  document.getElementById("div_detial").style.display = "none";
                } else {
                  document.getElementById("div_eva").style.display = "none";
                  document.getElementById("div_detial").style.display = "";
                }
              </script>
            </html>
