<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title><decorator:title default="配置管理后台"/></title>
    <link rel="stylesheet" type="text/css" href="${ctx}/endDecorators/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/endDecorators/css/main.css"/>
	<script type="text/javascript" src="${ctx}/endDecorators/js/libs/modernizr.min.js"></script>
 	<script type="text/javascript" src="${ctx}/js/jQuery/jquery-1.9.0.js"></script>
 <!--  
 	<link href="<%=basePath%>/js/shopAlert/css/showBo.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>/js/shopAlert/js/showBo.js"></script>
	-->
	<script type="text/javascript" src="<%=basePath%>/artDialog/dialog-min.js"></script>
  <link rel="stylesheet" href="<%=basePath%>/artDialog/ui-dialog.css" type="text/css"></link>
 <link rel="stylesheet" href="<%=basePath%>/artDialog/ui-dialog-color.css" type="text/css"></link>
 <script type="text/javascript" src="<%=basePath%>/artDialog/dialog-alter-confirm.js"></script> 
<decorator:head />
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="${ctx}/backstage/index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="${ctx}/endDecorators/configureManagementIndex.jsp">首页</a></li>
                <!-- 
                <li><a href="${ctx}/MyShop.jsp" target="_blank">网站首页</a></li>
                 -->
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
            	<!-- 
                <li><a href="${ctx}/superUserAction_viewmessageBack.action">${sessionScope.userinfo.username}</a></li>
                <li><a href="${ctx}/backstage/PasswordChange.jsp">修改密码</a></li>
                 -->
                <!-- 
                <li><a href="${ctx}/superUserAction_clearBack.do">退出</a></li>
                 -->
                 <!-- 
                 <li><a href="${ctx}/logout.action">退出</a></li>
                  -->
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
                    <a href="#"><i class="icon-font">&#xe014;</i>用户管理</a>
                    <ul class="sub-menu">
	                   <li><a href="${ctx}/jumpToUserMapRole.action?authorizedToken=${userid}"><i class="icon-font">&#xe034;</i>分配用户角色</a></li>
	                  	<!-- 
	                   <li><a href="${ctx}/jumpToSearchDeleteUser.action"><i class="icon-font">&#xe037;</i>删除用户</a></li>
                    	 -->
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>角色管理</a>
                    <ul class="sub-menu">
                        <li><a href="${ctx}/jumpToAddRole.action?authorizedToken=${userid}"><i class="icon-font">&#xe005;</i>添加角色</a></li>
                        <li><a href="${ctx}/jumpToRoleMapAuthority.action?authorizedToken=${userid}"><i class="icon-font">&#xe034;</i>分配角色权限</a></li>
                        <li><a href="${ctx}/jumpToSearchRole.action?authorizedToken=${userid}"><i class="icon-font">&#xe046;</i>变更角色</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe006;</i>权限管理</a>
                    <ul class="sub-menu">
                        <li><a href="${ctx}/jumpToAddAuthority.action?authorizedToken=${userid}"><i class="icon-font">&#xe005;</i>添加权限</a></li>
                        <li><a href="${ctx}/jumpToAuthorityMapResource.action?authorizedToken=${userid}"><i class="icon-font">&#xe034;</i>分配权限资源</a></li>
                        <li><a href="${ctx}/jumpToSearchDeleteAuthority.action?authorizedToken=${userid}"><i class="icon-font">&#xe046;</i>变更权限</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>资源管理</a>
                    <ul class="sub-menu">
                    	<li><a href="${ctx}/jumpToAddResource.action?authorizedToken=${userid}"><i class="icon-font">&#xe005;</i>添加资源</a></li>
                        <li><a href="${ctx}/jumpToSearchDeleteResource.action?authorizedToken=${userid}" disabled="true"><i class="icon-font">&#xe046;</i>变更资源</a></li>
                     
                      
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>${sessionScope.user.username}--欢迎您的使用！</span></div>
        </div>
        <div class="result-wrap">
        	<!-- 
            <div class="result-title">
                <h1>系统基本信息</h1>
            </div>
            <div class="result-content">
                
            </div>
             -->
             <!-- 在这添加新内容 -->
                <decorator:body/>
        </div>
        <!-- 
        <div class="result-wrap">
            <div class="result-title">
            </div>
            <div class="result-content">
                
            </div>
        </div>
         -->
    </div>
    <!--/main-->
</div>
</body>
</html>