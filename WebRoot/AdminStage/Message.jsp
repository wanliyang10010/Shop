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
    <title>消息管理</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/backstage/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/backstage/css/main.css"/>
     <link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css">
<%@ include file="/common/topAmin.jspf"%>
     <script type="text/javascript" src="${ctx}/js/web1.js"></script>
    <script type="text/javascript" src="${ctx}/backstage/js/libs/modernizr.min.js"></script>
   <script type="text/javascript" src="${ctx}/AdminStage/js/AdminBack.js"></script> 
   <script type="text/javascript">
	var id=0;
	$.ajax({
	type : "POST",
	url : ctx+"/messageAction_getMessageCount.action",
	data : "id="+id,
	success : function(result) {
	if (result.data == 'right') {
	  				} else if (result.data == 'wrong') {
				          window.location.href=ctx+"/error/404.jsp";
	  				}
	},
	error : function() {
	window.location.href=ctx+"/error/404.jsp";
	}	
});	</script>
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
                      <li><a href="${ctx}/disputeAction_query.action"><i class="icon-font">&#xe008;</i>纠纷管理</a></li> 
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
                <h1>消息提醒</h1>
            </div>
            <div class="result-content">
              <left>
		<form name="form1" action="" id="form1">
		<input id="ctx" type="hidden" value="${ctx }">
	<script type="text/javascript">
	   var ctx = $("#ctx").val();
	</script>
		<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
		<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	  <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
		<c:if test="${msg==''}">  		
       <table width="950" border="1" >
         <c:if test="${request.page!=null&&request.page.pageNo>0}"> 
           <tr>
           <td></td>
	          <td align="center" width="20%"><a href="javascript:updateA();">忽略所有消息</a></td>
	      </tr>
         </c:if> 
		<s:iterator value="#request.page" status="s">
		  <tr>
	          <td align="left"  colspan="2"><font color="red" id="font1" >新消息</font></td>
	     </tr>
		    <tr>
		        <td align="left"><a href="javascript:openmessage('${messageId}','${url}','${idtype}','${idvalue}');">${text}</a></td>
			     <td  align="center" width="20%">
			    	 &nbsp; 
					  <a href="javascript:updateM('${messageId}');">忽略</a>
			     </td>
		    </tr>
	    	   </s:iterator>
	    	   <tr>
									<td colspan="10">
								   <%@ include file="/common/pagination.jspf"%>
							        </td>
								  </tr>
	   </table>
	    </c:if>
	         <div id="msg" >
	              <font color="red" id="font1" >${msg}</font>
	   
			</div>
		</form>
	</left>
            </div>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>