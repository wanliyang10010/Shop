<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!DOCTYPE HTML>
<html>
  <head>
    <meta content="IE=11.0000" http-equiv="X-UA-Compatible"/>
    <title>登录页面</title>
    <link rel="shortcut icon" href="${ctx}/image/favicon.ico" >
    <link rel="icon" type="image/gif" href="${ctx}/image/animated_favicon.gif" >
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <link href="${ctx}/css/login.css" rel="stylesheet" type="text/css"/>
    <script src="${ctx}/js/jQuery/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">var ctx = "${ctx}";</script>
    <script src="${ctx}/artDialog/dialog-alter-confirm.js" type="text/javascript"></script>
    <script src="${ctx}/artDialog/dialog-min.js" type="text/javascript"></script>
    <link href="${ctx}/artDialog/ui-dialog.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/artDialog/ui-dialog-color.css" rel="stylesheet" type="text/css"/>
    <script src="${ctx}/js/user/Login.js" type="text/javascript"></script>
  </head>
  <body>
    <form action="" id="form1" name="form1">
      <div align="center" class="top_div">
        <br/>
        <a href="${ctx}/viewProductAction_MyShop.do" style="color: rgb(204, 204, 204);"><h4>返回主页</h4></a>
      </div>
      <div style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 200px; text-align: center;">
        <div style="width: 165px; height: 96px; position: absolute;">
          <div class="tou"></div>
          <div class="initial_left_hand" id="left_hand"></div>
          <div class="initial_right_hand" id="right_hand"></div>
        </div>
        <p style="padding: 30px 0px 10px; position: relative;">
          <span class="u_logo"></span>
          <input class="ipt" id="username" maxlenght="35" name="username" placeholder="请输入用户名" type="text" value="${param.username}"/>
        </p>
        <p style="position: relative;">
          <span class="p_logo"></span>
          <input class="ipt" id="password" maxlenght="20" name="password" oncontextmenu=return(false) placeholder="请输入密码" type="password" value=""/>
        </p>
        <div style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
          <p style="margin: 0px 35px 20px 45px;">
            <span style="float: left;">
              <a href="${ctx}/user/PasswordReset.jsp" style="color: rgb(204, 204, 204);">忘记密码?</a>
            </span>
            <span style="float: left; margin-left:25px">
              <a href="${ctx}/unifiedLogin_unifiedLogin.chao" style="color: rgb(204, 204, 204);">门户登录入口</a>
            </span>
            <span style="float: right;">
              <a href="${ctx}/user/NormalRegedit.jsp" style="color: rgb(204, 204, 204); margin-right: 10px;">注册</a>
              <!-- <a style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;" onclick="javascript:login();" href="javascript:void(0);">登录</a> -->
              <span
                href="javascript:void(0);"
                onclick="javascript:login();"
                style="cursor: pointer ;background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;">登录</span>
            </span>
          </p>
        </div>
      </div>
      <script type="text/javascript">
        var ss = '${msg}';
        if (ss != "") {
          alert(ss);
        }
      </script>
    </form>
  </body>
</html>
