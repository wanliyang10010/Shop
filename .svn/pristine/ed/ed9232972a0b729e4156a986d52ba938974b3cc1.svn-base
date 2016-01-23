<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
  <head>
    <title>个人信息修改</title>
    <%@ include file="/common/top-head.jspf" %>
    <link href="${ctx}/css/page.css" rel="stylesheet" type="text/css"/>
    <script src="${ctx}/js/user/ResetUserMessage.js" type="text/javascript"></script>
    <script src="${ctx}/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
  </head>
  <body>
    <div align="center" style="margin-top:-40px;">
      <%@ include file="/common/top-nav.jspf" %>
    </div>
    <div id="templatemo_main" style="height: 550px;">
      <center>
        <form autocomplete="off" id="form1" name="form1">
          <input id="authorizedToken" name="authorizedToken" type="hidden" value="${sessionScope.userid }"/>
          <h1>个人信息修改</h1>
          <table align="center" oncontextmenu=return(false) width="600">
            <tr height="40px">
              <td align="right">
                <label for="textfield">当前用户：</label>
                <font color="red" id="font1"></font>
              </td>
              <td align="left">${userinfo.username}</td>
            </tr>
            <tr height="40px">
              <td align="right" width="20%">
                <label for="textfield">*姓名：</label>
              </td>
              <td align="left">
                <input id="name" maxlength="10" name="name" type="text" value="${userinfo.name}"></td>
              </tr>
              <tr height="40px">
                <td align="right" width="20%">
                  <label for="textfield">*出生日期：</label>
                </td>
                <td align="left"><input class="Wdate" id="bdate" name="bdate" onClick="WdatePicker()" onkeydown="return false;" readonly="true" type="text" value="${userinfo.bdate}"/>
                </td>
              </tr>
              <tr height="40px">
                <td align="right" width="20%">
                  <label for="textfield">*手机号码：</label>
                </td>
                <td align="left">
                  <input id="telephone" maxlength="11" name="telephone" type="tel" value="${userinfo.telephone}"></td>
                </tr>
                <tr height="40px">
                  <td align="right" width="20%">
                    <label for="textfield">*邮箱地址：</label>
                  </td>
                  <td align="left"><input id="mail" maxlength="50" name="mail" size="35" type="text" value="${userinfo.mail}"/>
                  </td>
                </tr>
                <tr height="40px">
                  <td align="right">*所在地区：</td>
                  <td class="c-picker" align="left">
                    <div class="distpicker" id="picker">
                      <select id="province" name="province"></select>
                      <select id="city" name="city"></select>
                      <select id="district" name="district"></select>
                      <em></em>
                    </div>
                  </td>
                </tr>
                <tr height="40px">
                  <td align="right">*详细地址：</td>
                  <td align="left">
                    <input class="ipt_txt" id="addr" maxlength="30" name="addr" oninput="judgespace();" onkeyup="judgespace();" size="55" type="text"></td>
                  </tr>
                  <tr height="40px" style="display:none">
                    <td align="right" width="30%">
                      <label for="textfield">常住地址：</label>
                    </td>
                    <td align="left">
                      <input id="address" name="address" size="40" type="text" value="${fn:escapeXml(userinfo.address)}"></td>
                    </tr>
                    <tr style="display:none">
                      <td align="right" width="30%">
                        <label for="textfield">id：</label>
                      </td>
                      <td align="left">
                        <input id="userinfoId" name="userinfoId" type="number" value="${userinfo.userinfoId}"></td>
                      </tr>
                      <tr>
                        <td align="center" colspan="2">
                          <input onclick="updateR();" type="button" value="修改"/>
                          &nbsp;&nbsp;&nbsp;&nbsp;
                          <input onclick="cancel();" type="button" value="取消"/>
                        </td>
                      </tr>
                    </table>
                  </form>
                </center>
              </div>
              <footer>
                <script src="${ctx}/js/distpicker/distpicker.data.min.js" type="text/javascript"></script>
                <script src="${ctx}/js/distpicker/distpicker.js" type="text/javascript"></script>
              </footer>
            </body>
          </html>
