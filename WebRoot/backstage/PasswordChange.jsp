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
    <script type="text/javascript" src="${ctx}/backstage/js/backstage.js"></script>  
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
            <div class="result-content">
            <form name="form1" id="form1" autocomplete="off" >
            <input id="ctx" type="hidden" value="${ctx }">
	<script type="text/javascript">
	   var ctx = $("#ctx").val();
	</script>
   <h1>修改密码</h1>
   <div>
    <input type="hidden" name="userinfoId" id="userinfoId" value="${userinfo.userinfoId}"/>
    <input type="password"  autocomplete="off" style="display:none"/>
        <table width="950" align="left"  border="1" id="tb_old">
              <tr> 
						  <td align="right" width="30%">
						                <label for="textfield">当前密码：</label> 
						             </td>    
                                    <td align="left">
                                        <input type="password" name="oldpassword" id="oldpassword" value="${param.oldpassword}" autocomplete="off"
                                          onkeyup="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
                                          oninput="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; ">
                                    	 <input type="button" value="确定" onclick="checkpassword()"/>
                                    </td>
              </tr>
        </table>
   </div>
    <div id="dv_pwd" style="display:none">
                                   <table width="950" align="left"  border="1">
                                    <tr> 
                                     <td align="right" width="30%">
                                        <label for="textfield">新密码：</label>
                                    </td>
                                    <td align="left">
                                        <input type="password" name="password" id="password" maxlength="20"
                                        onkeyup="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
                                        oninput="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; ">
                                    </td>
                                </tr>
                                <tr>
                                		 <td align="right">
                                        <label for="textfield">密码确认：</label>
                                    </td>
                                    <td align="left">
                                        <input type="password" name="password2" id="password2" maxlength="20"
                                        onkeyup="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
                                        oninput="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; ">
                                    </td>
                                </tr>
                                   <tr>
                                     <td align="center" colspan="4">
		                                    <input id="btn_submit" type="button"  onclick="changePWD();" value="修改密码">
		                                     &nbsp;&nbsp;&nbsp;&nbsp;  
                                       <input id="btn_cancel" type="button"  onclick="cancel()" value="取消">
                                  </td>
                                  </tr>
                                  </table>
                                </div>
  </form>
            </div>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>