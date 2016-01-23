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
    <title>纠纷管理</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/backstage/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/backstage/css/main.css"/>
    <link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css">  
    <%@ include file="/common/topAmin.jspf"%>
    <script type="text/javascript" src="${ctx}/js/web1.js"></script>
    <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/backstage/js/libs/modernizr.min.js"></script>
<script type="text/javascript" src="${ctx}/js/dispute/DisputeCheck.js"></script>
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
               <h1>用户申诉查看</h1>
            </div>
            <div class="result-content">
                <left>
	<form name="form1" action=""  id="form1" >
	<input id="ctx" type="hidden" value="${ctx }">
	<script type="text/javascript">
	   var ctx = $("#ctx").val();
	</script>
	<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
	<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	  <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
                            <table width="950" border="0">
                                <tr id="tr2">
                                    <td align="right" colspan="2" >
                                    <label for="textfield">关键字：</label>
                                        <select id="stype" name="stype">
                                         		<option value="用户名" selected>用户名</option>
											     <option value="店铺名" >店铺名</option>
											    <option value="申诉类别">申诉类别</option>
											    
									    </select>    
									     <input type="text" name="keyword" id="keyword" size="25" value="${param.keyword}">
                                    </td>
                                        <td align="left" style=" width:30%">
                                         <input id="btn_search" type="button"  onclick="search();" value="查询">
                                    </td>
                                </tr>
                                <script type="text/javascript">
										var ss = '${param.stype}';
										if (ss != "") {
											document.getElementById("stype").value = '${param.stype}';
											//document.getElementById("stype")['${param.stype}'].selected = true;
										}
									</script>
                                <tr style="display:none"> 
                                     <td align="right">
                                        <label for="textfield">id：</label>
                                    </td>
                                    <td align="left">
                                        <input type="number" name="disputeId" id="disputeId" >
                                        <input type="number" name="path" id="path" >
                                    </td>
                                    </tr>
                            </table>
                             <table width="950" border="0">
                                 <tr >
                                    <td align="right" style=" width:35%">
                                    <label for="textfield">起始时间：</label>
                                    <input class="Wdate" name="dtstart" id="dtstart" size="19" value="${param.dtstart}" type="text" readonly="true" onClick="WdatePicker()">
                          			</td>
                          			<td align="right" style=" width:35%">
                                    <label for="textfield">终止时间：</label>
                                      <input class="Wdate" name="dtend" id="dtend" size="19" value="${param.dtend}" readonly="true" onClick="WdatePicker()">
                                    </td>
                                        <td align="left">   
                                         <select id="state" name="state">
                                         		<option value="全部申诉">全部申诉</option>
											     <option value="已处理" >已处理</option>
											    <option value="未处理" selected>未处理</option>
									    </select>    
                                         <input id="btn_search" type="button"  onclick="searchDate();" value="查询">
                                    </td>
                                    <script type="text/javascript">
										var ss = '${param.state}';
										if (ss != "") {
											document.getElementById("state").value = '${param.state}';
											//document.getElementById("state")['${param.state}'].selected = true;
										}
									</script>
                                </tr>
                                </table>
      <c:if test="${msg==''}">
       <table width="950" >
	     <tr>
	          <td align="center" width=5%>序号</td>
	          <td align="center" width=15%>用户名</td>
		      <td align="center" width=20%>店铺名</td>
		      <td align="center" width=15%>申诉类别</td>
		      <td align="center" width=15%>提交时间</td>
		      <td align="center" width=10%>状态</td>
		      <td align="center" width=10%>操作</td>
	     </tr>
		     <s:iterator value="#request.page" status="s">
		    <tr>
		         <td width=5% align="center">${s.count+(page.pageNo-1)*page.pageSize}</td>
		        <td width=15% align="center">${accuser}</td>
			    <td width=20% align="center">${sccused}</td>
			      <td width=15% align="center">${dtype}</td>
			     <td width=15% align="center">${infodate}</td>
			     <c:choose>
			      <c:when test="${state=='0'}">
			                   <td width=10% align="center" color="red">未处理 </td>
			                    <td width=10% align="center">
					         <a href="javascript:getlist('${disputeid }');">开始处理</a>
			     </td>      
			     </c:when>        
			     <c:otherwise>
			         <td width=10% align="center">已处理  </td>      
			           <td width=10% align="center">
					         <a href="javascript:getlist('${disputeid }');">查看结果</a>
			     </td>                               
			      </c:otherwise> 
			       </c:choose>
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