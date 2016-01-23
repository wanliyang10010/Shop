<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
  <head>
   <title>${goods.goodsname}用户评价</title>
  <%@ include file="/common/top-head.jspf"%>
    <link href="${ctx}/css/page.css" rel="stylesheet" type="text/css"/>
    <script src="${ctx}/js/web1.js" type="text/javascript"></script>
    <script src="${ctx}/js/jQuery/jquery-1.9.0.js" type="text/javascript"></script>
  </head>
  <body>
  <div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
    <center>
      <div id="templatemo_main">
        <form action="" id="form1" name="form1">
          <input id="gid" name="gid" type="hidden" value="${goods.goodsid}"/>
          <br/>
          <table align="center" border="0" width="800">
            <tr height="40">
              <td align="right" width="20%">商品名称：</td>
              <td align="left">${goods.goodsname}</td>
            </tr>
          </table>
          <table align="center" border="0" width="800">
            <input id="pageNo" name="page.pageNo" type="hidden" value="${page.pageNo}"/>
            <input id="pageSize" name="page.pageSize" type="hidden" value="${page.pageSize}"/>
            <c:if test="${msg==''}">
              <s:iterator status="s" value="#request.page">
                <tr height="40">
                  <td colspan="3">
                    <font aligen="left" color="red">商品评价${s.count+(page.pageNo-1)*page.pageSize}</font>
                  </td>
                </tr>
                <tr height="40">
                  <td align="center" width=20%>买家评论：</td>
                  <td align="center" width=60%>${goodscontent}</td>
                  <td align="center" width=20%>${evaluationTime}</td>
                </tr>
                <c:if test="${not empty evalution.addcontent}">
                  <tr height="40">
                    <td align="center" width=20%>买家追评：</td>
                    <td align="center" width=60%>${addcontent}</td>
                    <td align="center" width=20%>${addTime}</td>
                  </tr>
                </c:if>
                <c:if test="${ not empty evalution.checkIdea}">
                  <tr height="40">
                    <td align="center" width=20%>店家回复：</td>
                    <td align="center" width=60%>${checkIdea}</td>
                    <td align="center" width=20%>${checkTime}</td>
                  </tr>
                </c:if>
              </s:iterator>
            </c:if>
          </table>
          <%@ include file="/common/pagination.jspf" %>
          <font color="red" id="font1">${msg}</font>
          <br/>
          <br/>
        </div>
      </form>
    </table>
  </div>
</center>
</body>
</html>
