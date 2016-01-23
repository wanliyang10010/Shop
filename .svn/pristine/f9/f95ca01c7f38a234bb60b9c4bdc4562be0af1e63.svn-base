<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jspf"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>查看个人信息</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/backstage/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/backstage/css/main.css"/>
     <link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css">  
    <%@ include file="/common/topAmin.jspf"%>
    <script type="text/javascript" src="${ctx}/backstage/js/libs/modernizr.min.js"></script>
    <script type="text/javascript" src="${ctx}/AdminStage/js/AdminBack.js"></script> 
	<script type="text/javascript">
	$.ajax({
	type : "POST",
	url : ctx+"/messageAction_getMessageCount.action",
	success : function(result) {
	},
	error : function() {
	
	}		
});
	</script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="${ctx}/AdminStage/index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="${ctx}/AdminStage/index.jsp">首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="${ctx}/adminUserAction_viewmessageBack.action">${sessionScope.userinfo.username}</a></li>
                <li><a href="${ctx}/messageAction_getMessageAdmin.action">新消息(${sessionScope.MessageCount})</a></li>
                <li><a href="${ctx}/AdminStage/PasswordChange.jsp">修改密码</a></li>
                <li><a href="${ctx}/userinfoAction_clear.do">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
         <div class="sidebar-content">
            <ul class="sidebar-list">
             <li>
                    <a href="#"><i class="icon-font">&#xe006;</i>纠纷管理</a>
                    <ul class="sub-menu">
                      <li><a href="${ctx}/AdminStage/disputeAction_query.action"><i class="icon-font">&#xe008;</i>纠纷管理</a></li> 
                    </ul>
                </li>
                 <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>积分商城管理</a>
                    <ul class="sub-menu">
                        <li><a href="${ctx}/stageGoodsAction_query.action"><i class="icon-font">&#xe005;</i>商城商品管理</a></li>
                        <li><a href="${ctx}/stageOrderAction_openAdmin.action"><i class="icon-font">&#xe005;</i>商城订单管理</a></li>
                    </ul>
                </li>
                 <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>创业平台首页管理</a>
                    <ul class="sub-menu">
                        <li><a href="${ctx}/shopStateAction_getTopGoods.action"><i class="icon-font">&#xe005;</i>首页展示商品管理</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>店铺管理</a>
                    <ul class="sub-menu">
                        <li><a href="${ctx}/shopStateAction_qury.action"><i class="icon-font">&#xe005;</i>店铺信息管理</a></li>
                         <li><a href="${ctx}/shopApplyAction_searchAllCheckList.action"><i class="icon-font">&#xe005;</i>审核店铺申请</a></li>
                         <li><a href="${ctx}/shopApplyAction_adminViewShopProgress.action"><i class="icon-font">&#xe005;</i>查看店铺申请</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>会员管理</a>
                    <ul class="sub-menu">
                        <li><a href="${ctx}/userinfoAction_queryUser.action"><i class="icon-font">&#xe052;</i>会员管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>${sessionScope.userinfo.username}--欢迎您的使用！</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>查看用户信息</h1> 
            </div>
            <div class="result-content">
                <left>
       <form id="form1" action="" name="form1">
       <input id="ctx" type="hidden" value="${ctx }">
	<script type="text/javascript">
	   var ctx = $("#ctx").val();
	</script>
       <input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
			 <input type="hidden" name="userinfoid" id="userinfoid" value="${userinfo.userinfoId}"/>
			<table width="950">
			<tr>
			    <td align="right" colspan="2" >
			  <a href="javascript:update('${userinfo.userinfoId}');">修改个人信息</a>
			    </td>  
			</tr>
			<tr>
			    <td align="right" >
			    <label for="textfield">当前用户：</label>
			      <font color="red" id="font1"></font>
			    </td>
			    <td align="left">${userinfo.username}
			    </td>  
			</tr>
				<tr>
					<td align="right" width="30%"><label for="textfield">姓名：</label>
					</td>
					<td align="left">${userinfo.name}
					</td>
				</tr>
				<tr>
					<td align="right" width="30%"><label for="textfield">出生日期：</label>
					</td>
					<td align="left">
					${userinfo.bdate}
					</td>

				</tr>

				<tr>
					<td align="right" width="30%"><label for="textfield">手机号码：</label>
					</td>
					<td align="left">
					${userinfo.telephone}
					</td>
				</tr>
				<tr>
					<td align="right" width="30%"><label for="textfield">邮箱地址：</label>
					</td>
					<td align="left">${userinfo.mail}
                                    </td>
                 </tr>
        
                               <tr>
								 <td align="right" width="30%">
                                        <label for="textfield">常住地址：</label>
                                    </td>
                                    <td align="left">${userinfo.address}
                                    </td>
								</tr>
								 <tr style="display:none"> 
                                     <td align="right"  width="30%">
                                        <label for="textfield">id：</label>
                                    </td>
                                    <td align="left">
                                        <input type="number" name="userinfoId" id="userinfoId" value="" >
                                    </td>
                     </tr>
                            </table>
  </form>
  </left>
            </div>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>