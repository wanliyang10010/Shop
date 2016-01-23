<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
  <head>
    <title>个人信息查看</title>
    <%@ include file="/common/top-head.jspf" %>
    <link href="${ctx}/css/page.css" rel="stylesheet" type="text/css"/>
    <script src="${ctx}/js/user/ResetUserMessage.js" type="text/javascript"></script>
  </head>
  <body>
  <div align="center" style="margin-top:-40px;">
      <%@ include file="/common/top-nav.jspf" %>
  </div>
  <div id="templatemo_main" style="height: 550px;">
    <center>
      <form action="" autocomplete="off" id="form1" name="form1">
        <input id="authorizedToken" name="authorizedToken" type="hidden" value="${sessionScope.userid }"/>
        <input id="userinfoid" name="userinfoid" type="hidden" value="${userinfo.userinfoId}"/>
        <h1>个人中心</h1>
        <table align="center" width="600">
          <tr height="40px">
            <td align="right" colspan="2">
              <a href="javascript:update('${userinfo.userinfoId}');">修改个人信息</a>
            </td>
          </tr>
          <tr height="40px">
            <td align="right">
              <label for="textfield">当前用户：</label>
              <font color="red" id="font1"></font>
            </td>
            <td align="left">${userinfo.username}
            </td>
          </tr>
          <tr height="40px">
            <td align="right" width="30%">
              <label for="textfield">姓名：</label>
            </td>
            <td align="left">${userinfo.name}
            </td>
          </tr>
          <tr height="40px">
            <td align="right" width="30%">
              <label for="textfield">出生日期：</label>
            </td>
            <td align="left">
              ${userinfo.bdate}
            </td>
          </tr>
          <tr height="40px">
            <td align="right" width="30%">
              <label for="textfield">积分：</label>
            </td>
            <td align="left">${userinfo.points}
            </td>
          </tr>
          <tr height="40px">
            <td align="right" width="30%">
              <label for="textfield">手机号码：</label>
            </td>
            <td align="left">
              ${userinfo.telephone}
            </td>
          </tr>
          <tr height="40px">
            <td align="right" width="30%">
              <label for="textfield">邮箱地址：</label>
            </td>
            <td align="left">${userinfo.mail}
            </td>
          </tr>
          <tr height="40px">
            <td align="right" width="30%">
              <label for="textfield">常住地址：</label>
            </td>
            <td align="left">${userinfo.address}
            </td>
          </tr>
          <tr height="40px" style="display:none">
            <td align="right" width="30%">
              <label for="textfield">id：</label>
            </td>
            <td align="left">
              <input id="userinfoId" name="userinfoId" type="number" value=""></td>
            </tr>
          </table>
        </form>
      </center>
    </div>
  </body>
</html>
