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
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/backstage/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/backstage/css/main.css"/>
    <%@ include file="/common/topAmin.jspf"%>
<script type="text/javascript" src="${ctx}/backstage/js/libs/modernizr.min.js"></script>
<script type="text/javascript">  
window.onload=function(){   
getTime();    
window.setInterval("getTime()",1); 
};                             
function getTime(){    
   var date = new Date();    
   var y = date.getFullYear();    
   var m = date.getMonth()+1;    
   var d = date.getDate();    
   var h = date.getHours();    
   var i = date.getMinutes();    
   var s = date.getSeconds();   
   document.getElementById("showTimes").innerHTML =y+"年"+(m>9?m:("0"+m))+"月"+(d>9?d:("0"+d))+"日 "+(h>9?h:("0"+h))+":"+(i>9?i:("0"+i))+":"+(s>9?s:("0"+s));
}    
</script> 
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="${ctx}/backstage/index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="${ctx}/backstage/index.jsp">首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="${ctx}/superUserAction_viewmessageBack.action">${sessionScope.userinfo.username}</a></li>
                <li><a href="${ctx}/backstage/PasswordChange.jsp">修改密码</a></li>
                <!-- 
                <li><a href="${ctx}/superUserAction_clearBack.do">退出</a></li>
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
                    <a href="#"><i class="icon-font">&#xe006;</i>项目管理</a>
                    <ul class="sub-menu">
                      <li><a href="${ctx}/dateItemAction_qury.action"><i class="icon-font">&#xe008;</i>日期项管理</a></li> 
                   <li><a href="${ctx}/pointsItemAction_qury.action"><i class="icon-font">&#xe008;</i>积分项管理</a></li>
                   <li><a href="${ctx}/marginItemAction_qury.action"><i class="icon-font">&#xe008;</i>商品项管理</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>规则管理</a>
                    <ul class="sub-menu">
                        <li><a href="${ctx}/dateItemAction_getlist.action"><i class="icon-font">&#xe005;</i>日期规则管理</a></li>
                        <li><a href="${ctx}/pointsItemAction_getlist.action"><i class="icon-font">&#xe005;</i>积分规则管理</a></li>
                        <li><a href="${ctx}/marginItemAction_getlist.action"><i class="icon-font">&#xe005;</i>保证金规则管理</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
                    <ul class="sub-menu">
                        <li><a href="${ctx}/superUserAction_queryAdmin.action"><i class="icon-font">&#xe052;</i>管理员账号管理</a></li>
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
                <h1>系统基本信息</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">开发语言:</label><span class="res-info">Java</span>
                    </li>
                    <li>
                        <label class="res-lab">数据库:</label><span class="res-info">Oracle 11g</span>
                    </li>
                    <li>
                        <label class="res-lab">上传附件限制:</label><span class="res-info">2M</span>
                    </li>
                    <li>
                        <label class="res-lab">当前时间:</label><span class="res-info"><font color="" id="showTimes" ></font></span>
                    </li>
                    <li>
                        <label class="res-lab">服务器域名/IP:</label><span class="res-info">localhost [ 127.0.0.1 ]</span>
                    </li>
                    <li>
                        <label class="res-lab">Host:</label><span class="res-info">127.0.0.1</span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>使用帮助</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">联系电话：</label><span class="res-info">xxxxx</span>
                    </li>
                    <li>
                        <label class="res-lab">公司地址：</label><span class="res-info">xx省xx市xx路xx号</span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>