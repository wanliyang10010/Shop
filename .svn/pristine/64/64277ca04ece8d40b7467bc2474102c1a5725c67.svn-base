<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
  <head>
    <s:action name="viewProductAction_MyShop"/>
    <base href="<%=basePath%>">
      <title>创业平台</title>
      <div align="center" style="margin-top:-40px;">
        <%@ include file="/common/top.jspf"%>
      </div>
      <link href="${ctx}/css/page.css" rel="stylesheet" type="text/css"></head>
      <script type="text/javascript">
        //window.location.href=ctx+"/viewProductAction_MyShop.action";
        //window.open();
      </script>
      <body>
        <div id="templatemo_main">
          <h1 align="center">创业板块功能说明</h1>
          <table align="center" width="800px">
            <tr>
              <td align="center" width="15%">角色</td>
              <td align="center" width="25%">业务</td>
              <td align="center">业务相关功能</td>
            </tr>
            <tr>
              <td align="center" rowspan="12">平台会员</td>
              <td align="center">用户信息管理</td>
              <td>
                <a href="${ctx}/login.jsp" target="_blank">用户登录</a>|
                <a href="${ctx}/user/NormalRegedit.jsp" target="_blank">通过用户名注册</a>|
                <a href="${ctx}/user/MailRegedit.jsp" target="_blank">通过邮箱注册</a>
                |
                <a href="${ctx}/user/PhoneRegedit.jsp" target="_blank">通过手机号码注册</a>|
                <a href="${ctx}/user/ViewMessage.jsp" target="_blank">用户信息查看</a>|
                <a href="${ctx}/user/ResetUserMessage.jsp" target="_blank">用户信息修改</a>
                |
                <a href="${ctx}/user/PasswordChange.jsp" target="_blank">用户密码修改</a>|
                <a href="${ctx}/user/PasswordReset.jsp" target="_blank">用户密码找回</a>|
                <a href="${ctx}/users/deliverAddr/MyAddr.jsp" target="_blank">收货地址</a>|
                <a href="${ctx}/user/Message.jsp" target="_blank">用户消息查看</a>
              </td>
            </tr>
            <tr>
              <td align="center">商品浏览</td>
              <td>
                <a href="${ctx}/viewProductAction_MyShop.do" target="_blank">创业平台主页</a>|
                <a href="${ctx}/ViewDiscount.jsp" target="_blank">特价商品查看</a>|
                <a href="${ctx}/ViewHot.jsp" target="_blank">热卖商品查看</a>
                |
                <a href="${ctx}/ViewProduct.jsp" target="_blank">商品搜索</a>|
                <a href="${ctx}/ShopSearch.jsp" target="_blank">店铺搜索</a>|
                <a href="${ctx}/ProductDetial.jsp" target="_blank">商品查看</a>
                |
                <a href="${ctx}/ViewShop.jsp" target="_blank">店铺查看</a>
              </td>
            </tr>
            <tr>
              <td align="center">购物车与收藏夹</td>
              <td>
                <a href="${ctx}/cartAction_queryCarts.action" target="_blank">我的购物车</a>|
                <a href="${ctx}/order/favouriteAction_list.action" target="_blank">我的收藏夹</a>
                |
                <a href="${ctx}/order/favouriteShopAction_list.action" target="_blank">我收藏的店铺</a>
              </td>
            </tr>
            <tr>
              <td align="center">店铺商品类别管理</td>
              <td>
                <a href="${ctx}/GoodsType/GoodsTypeManage.jsp" target="_blank">店铺商品类别管理</a>|
                <a href="${ctx}/GoodsType/GoodsTypeItemManage.jsp" target="_blank">店铺商品类别子项管理</a>
              </td>
            </tr>
            <tr>
              <td align="center">店铺商品管理</td>
              <td>
                <a href="${ctx}/GoodsManage.jsp" target="_blank">店铺商品管理</a>|
                <a href="${ctx}/GoodsInfo.jsp" target="_blank">添加商品</a>|
                <a href="${ctx}/GoodsDetialInfo.jsp" target="_blank">添加商品属性</a>
                |
                <a href="${ctx}/GoodsPictureInfo.jsp" target="_blank">添加商品图片</a>|
                <a href="${ctx}/AddDiscount.jsp" target="_blank">商品特价促销</a>
              </td>
            </tr>
            <tr>
              <td align="center">用户申诉</td>
              <td>
                <a href="${ctx}/DisputeInfo.jsp" target="_blank">提交申诉</a>|
                <a href="${ctx}/DisputeView.jsp" target="_blank">申诉查看</a>
              </td>
            </tr>
            <tr>
              <td align="center">店铺管理</td>
              <td>
                <a href="${ctx}/shopApplyAction_searchProductcategory.action" target="_blank">制定店铺申请</a>
                |
                <a href="${ctx}/shopManage/alterShop.jsp" target="_blank">修改店铺申请</a>
                |
                <a href="${ctx}/shopManage/viewShopProgress.jsp" target="_blank">查看店铺申请审核进展</a>
                |
                <a href="${ctx}/shopManage/viewShop.jsp" target="_blank">店铺信息查看</a>
                |
                <a href="${ctx}/shopManage/submitMargin.jsp" target="_blank">交保证金</a>
                |
                <a href="${ctx}/shopManage/viewMargin.jsp" target="_blank">保证金查看</a>
              </td>
            </tr>
            <tr>
              <td align="center">买家订单管理</td>
              <td>
                <a href="${ctx}/orderAction_haveBuyGoods.action" target="_blank">已买到的宝贝</a>
              </td>
            </tr>
            <tr>
              <td align="center">卖家订单管理</td>
              <td>
                <a href="${ctx}/orderAction_haveSellGoods.action" target="_blank">已售出的宝贝</a>
              </td>
            </tr>
            <tr>
              <td align="center">延长收货时间管理</td>
              <td>
                <a href="${ctx}/prolongTime/checkProlong.jsp" target="_blank">审核延长收货时间</a>
                |
                <a href="${ctx}/prolongTime/alterProlong.jsp" target="_blank">修改延长收货时间</a>
                |
                <a href="${ctx}/prolongTime/viewProlong.jsp" target="_blank">查看延长收货时间</a>
              </td>
            </tr>
            <tr>
              <td align="center">退换货管理</td>
              <td>
                <a href="${ctx}/returnGoods/checkReturn.jsp" target="_blank">审核退货申请</a>
                |
                <a href="${ctx}/returnGoods/alterReturn.jsp" target="_blank">修改退货申请</a>
                |
                <a href="${ctx}/returnGoods/transInfoReturn.jsp" target="_blank">填写退货运单</a>
                |
                <a href="${ctx}/returnGoods/confirmReturn.jsp" target="_blank">确认收到买家退货</a>
                |
                <a href="${ctx}/returnGoods/viewReturn.jsp" target="_blank">查看退货申请</a>
              </td>
            </tr>
            <tr>
              <td align="center">积分评价管理</td>
              <td>
                <a href="${ctx}/goodsEvaluationAction_searchPointEvaluation.action" target="_blank">积分评价管理</a>
              </td>
            </tr>

            <tr>
              <td align="center" rowspan="5">平台客服</td>
              <td align="center">客服人员信息管理</td>
              <td>
                <a href="${ctx}/AdminStage/login.jsp" target="_blank">用户登录</a>|
                <a href="${ctx}/AdminStage/ViewMessage.jsp" target="_blank">用户信息查看</a>|
                <a href="${ctx}/AdminStage/ResetUserMessage.jsp" target="_blank">用户信息修改</a>
                |
                <a href="${ctx}/AdminStage/PasswordChange.jsp" target="_blank">用户密码修改</a>|
                <a href="${ctx}/AdminStage/Message.jsp" target="_blank">用户消息查看</a>
              </td>
            </tr>
            <tr>
              <td align="center">平台店铺管理</td>
              <td>
                <a href="${ctx}/AdminStage/ShopStateManage.jsp" target="_blank">店铺管理</a>|
                <a href="${ctx}/AdminStage/ShopGoodsManage.jsp" target="_blank">店铺商品管理</a>|
                <a href="${ctx}/AdminStage/GoodsPictureManage.jsp" target="_blank">店铺商品图片管理</a>|
                <a href="${ctx}/AdminStage/MarginPunish.jsp" target="_blank">店铺处罚</a>|
                <a href="${ctx}/AdminStage/MarginDetial.jsp" target="_blank">店铺保证金查看</a>|
                <a href="${ctx}/shopManage/checkShop.jsp" target="_blank">审核店铺申请</a>|
                <a href="${ctx}/shopManage/adminViewShopProgress.jsp" target="_blank">查看店铺申请</a>
              </td>
            </tr>
            <tr>
              <td align="center">平台会员管理</td>
              <td>
                <a href="${ctx}/AdminStage/UserStateManage.jsp" target="_blank">会员管理</a>
              </td>
            </tr>
            <tr>
              <td align="center">申诉管理</td>
              <td>
                <a href="${ctx}/AdminStage/DisputeCheck.jsp" target="_blank">申诉查询</a>|
                <a href="${ctx}/AdminStage/DisputeFile.jsp" target="_blank">申诉处理</a>|
                <a href="${ctx}/AdminStage/DisputeView.jsp" target="_blank">申诉处理结果查看</a>
              </td>
            </tr>
            <tr>
              <td align="center">积分商城管理</td>
              <td>
                <a href="${ctx}/AdminStage/StageGoodsManage.jsp" target="_blank">商城商品管理</a>|
                <a href="${ctx}/AdminStage/StageOrderManage.jsp" target="_blank">商城订单管理</a>
              </td>
            </tr>

            <tr>
              <td align="center" rowspan="5">平台管理员</td>
              <td align="center">管理员信息管理</td>
              <td>
                <a href="${ctx}/backstage/login.jsp" target="_blank">用户登录</a>|
                <a href="${ctx}/backstage/ViewMessage.jsp" target="_blank">用户信息查看</a>|
                <a href="${ctx}/backstage/ResetUserMessage.jsp" target="_blank">用户信息修改</a>
                |
                <a href="${ctx}/backstage/PasswordChange.jsp" target="_blank">用户密码修改</a>
              </td>
            </tr>
            <tr>
              <td align="center">积分规则管理</td>
              <td>
                <a href="${ctx}/backstage/PointsRule.jsp" target="_blank">积分规则管理</a>|
                <a href="${ctx}/backstage/PointsItem.jsp" target="_blank">积分项管理</a>
              </td>
            </tr>
            <tr>
              <td align="center">日期规则管理</td>
              <td>
                <a href="${ctx}/backstage/DateRule.jsp" target="_blank">日期规则管理</a>|
                <a href="${ctx}/backstage/DateItem.jsp" target="_blank">日期项管理</a>
              </td>
            </tr>
            <tr>
              <td align="center">保证金规则管理</td>
              <td>
                <a href="${ctx}/backstage/MarginRule.jsp" target="_blank">积分规则管理</a>|
                <a href="${ctx}/backstage/MarginItem.jsp" target="_blank">积分项管理</a>
              </td>
            </tr>
            <tr>
              <td align="center">平台客户账户管理</td>
              <td>
                <a href="${ctx}/backstage/AdminManage.jsp" target="_blank">客户账户管理</a>
              </td>
            </tr>
          </table>
          <br/>
          <br/>
        </div>
      </body>

    </html>
