<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>收货地址</title>
    <%@ include file="/common/top-head.jspf" %>
    <meta content="no-cache" http-equiv="pragma"/>
    <meta content="no-cache" http-equiv="cache-control"/>
    <link href="${ctx}/css/order/addr.css" rel="stylesheet" type="text/css"/>
  </head>

  <body>
    <div align="center" style="margin-top:-40px;">
      <%@ include file="/common/top-nav.jspf" %>
    </div>
    <div id="templatemo_main" style="margin-top:-12px;">
      <s:action executeResult="false" name="deliverAddrAction!list" namespace="/order"></s:action>
      <input id="context" type="hidden" value="${ctx}"/>
      <center>
        <h3 style="color:#999;">我的收货地址</h3>
      </center>
      <form action="" id="addrForm" method="post" name="addrForm" onsubmit="return check();">
        <s:token/>
        <input id="authorizedToken" name="authorizedToken" type="hidden" value="${userid }"/>
        <input id="updateId" name="deliveraddrId" type="hidden"/>
        <input id="area" name="area" type="hidden"/>
        <div class="tbl-deliver-wrapper">
          <table class="tbl-deliver-add">
            <colgroup>
              <col class="c-blank"/>
              <col class="c-text"/>
              <col class="c-ipt"/>
            </colgroup>
            <tbody>
              <tr>
                <td>
                  <em>*</em>
                </td>
                <td>收货人：</td>
                <td>
                  <input class="ipt_txt char" id="recevername" maxlength="8" name="recevername" type="text"/>
                  <em></em>
                </td>
              </tr>
              <tr>
                <td>
                  <em>*</em>
                </td>
                <td>所在地区：</td>
                <td class="c-picker">
                  <div class="distpicker" id="picker">
                    <select id="province" name="province"></select>
                    <select id="city" name="city"></select>
                    <select id="district" name="district"></select>
                    <em></em>
                  </div>
                </td>
              </tr>
              <tr>
                <td>
                  <em>*</em>
                </td>
                <td>详细地址：</td>
                <td>
                  <input class="ipt_txt" id="addr" maxlength="30" name="addr" type="text"/>
                  <em></em>
                </td>
              </tr>
              <tr>
                <td></td>
                <td>邮政编码：</td>
                <td>
                  <input class="ipt_txt" id="postcode" maxlength="6" name="postcode" type="text"/>
                  <em></em>
                </td>
              </tr>
              <tr>
                <td>
                  <em>*</em>
                </td>
                <td>手机号码：</td>
                <td>
                  <input class="ipt_txt" id="phone" maxlength="11" name="phone" type="text"/>
                  <em></em>
                </td>
              </tr>
              <tr>
                <td></td>
                <td>设为默认地址</td>
                <td><input id="isdefault" name="isdefault" type="checkbox" value="1"/></td>
              </tr>
            </tbody>
            <tfoot>
              <tr>
                <td colspan="4" style="text-align: center;">
                  <button class="btn_save" id="btn_add" type="submit">添加</button>
                  <button class="btn_save" id="btn_update" style="display:none" type="submit">保存</button>
                </td>
              </tr>
            </tfoot>
          </table>
          <div>
            <em id="error"></em>
          </div>
        </div>
      </form>
      <script type="text/javascript">
        if ('${rest}' === '0') {
          var btn = document.getElementById("btn_add");
          btn.disabled = "false";
          btn.style.background = "gray";
        }
      </script>
      <div class="msg">${msg }</div>
      <div class="tbl-deliver-address">
        <form action="${ctx}/order/deliverAddrAction!list.action" id="form1" method="post">
          <table border="1" cellpadding="0" cellspacing="0" class="tb-main">
            <colgroup>
              <col class="col-man"/>
              <col class="col-area"/>
              <col class="col-address"/>
              <col class="col-postcode"/>
              <col class="col-phone"/>
              <col class="col-actions"/>
            </colgroup>
            <tbody>
              <tr class="thead-tbl-grade">
                <th>收货人</th>
                <th>所在地区</th>
                <th>详细地址</th>
                <th>邮编</th>
                <th>手机号</th>
                <th>操作</th>
                <th></th>
              </tr>
              <s:if test="#request.page.totalItems == 0">
                <tr>
                  <td align="center" colspan="7">
                    <span class="msg">未添加收货地址!</span>
                  </td>
                </tr>
              </s:if>
              <s:else>
                <s:iterator status="s" value="#request.page">
                  <tr class="lb-display">
                    <td><lable class="lb-receivername">${recevername }</lable></td>
                    <td><lable class="lb-area">${area }</lable></td>
                    <td><lable class="lb-addr">${addr }</lable></td>
                    <td><lable class="lb-postcode">${postcode }</lable></td>
                    <td><lable class="lb-phone">${phone }</lable></td>
                    <td>
                      <a href="javascript:void(0);" onclick="updateType('${deliveraddrId}','${recevername}','${area}','${addr}','${postcode}','${phone}','${isdefault}');">修改</a>
                      <a class="del_${deliveraddrId }" href="javascript:void(0);" onclick="deleteAddr(${deliveraddrId});">删除</a>
                    </td>
                    <td>
                      <c:if test="${isdefault=='1'}">
                        <span class="note">默认地址</span>
                      </c:if>
                      <c:if test="${isdefault=='0'}">
                        <span class="note">
                          <a href="javascript:void(0);" onclick="changeDefaultAddr('${deliveraddrId}');">设为默认</a>
                        </span>
                      </c:if>
                    </td>
                  </tr>
                </s:iterator>
              </s:else>
            </tbody>
          </table>
        </form>
      </div>
    </div>
    <footer>
      <script src="${ctx}/js/jQuery/jquery.validate.min.js" type="text/javascript"></script>
      <script src="${ctx}/js/distpicker/distpicker.data.min.js" type="text/javascript"></script>
      <script src="${ctx}/js/distpicker/distpicker.js" type="text/javascript"></script>
      <script src="${ctx}/js/order/addr.js" type="text/javascript"></script>
    </footer>
  </body>
</html>
