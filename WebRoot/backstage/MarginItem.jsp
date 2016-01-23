<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
<%@ page pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jspf"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <s:token />
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/backstage/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/backstage/css/main.css"/>
    <script type="text/javascript" src="${ctx}/backstage/js/libs/modernizr.min.js"></script>
    <link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css">  
    <%@ include file="/common/topAmin.jspf"%>
    <script type="text/javascript" src="${ctx}/js/web1.js"></script>
    <script type="text/javascript" src="${ctx}/js/backstage/MarginItem.js"></script>
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
            <div class="result-title">
              <h1>商品项管理</h1>
            </div>
            <div class="result-content">
                   <left>
	<form name="form1" action=""  id="form1" >
	<input id="ctx" type="hidden" value="${ctx }">
	<script type="text/javascript">
	   var ctx = $("#ctx").val();
	</script>
	<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	  <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
    <table width="950"  height="97">
              <tr > 
                                     <td align="right" width="20%">
                                        <label for="textfield">商品类别：</label>
                                    </td>
                                    <td align="left">
                                        <input type="text" name="itemname" id="itemname"  maxlength="15" size="40">
                                    <font color="red" id="font1" >${msgjudge}</font>
                                    </td>
                                </tr>
                                <tr > 
                                     <td align="right">
                                        <label for="textfield">备注：</label>
                                    </td>
                                    <td align="left">
                                      <textarea rows="4" cols="60" name="remark" id="remark"  maxlength="35"  onkeyup="if(value.length>35) value=value.substr(0,35)" style="overflow:hidden"></textarea>
                                    </td>
                                </tr>
                                 <tr style="display:none"> 
                                     <td align="right">
                                        <label for="textfield">id：</label>
                                    </td>
                                    <td align="left">
                                        <input type="number" name="itemId" id="itemId" >
                                    </td>
                                </tr>
                                <tr>
                                  <td align="center" colspan="2">
                                  <input type="button" name="btn_update" id="btn_update" value="修改" onclick="update();" style="display:none">
                                  
                                    &nbsp;&nbsp;
                                   <input type="button" name="btn_submit" id="btn_submit" value="添加" onclick="add();" >
                                    &nbsp;&nbsp;
                                   <input type="button" name="btn_cancel" id="btn_cancel" value="取消" onclick="cancel();" >
                                  </td>
                                </tr>
                            </table>
                            <div>
                            <table width="950">
                                <tr>
                                    <td align="right" style=" width:30%" >
                                    <label for="textfield">商品类别：</label>
                                    </td>
                                    <td align="left">
                                       <input type="text" name="keyword" id="keyword" size="25" value="${param.keyword}">
                                   
                                         <button id="btn_submit" type="submit"  onclick="search();" >查询</button>
                                    </td>
                                </tr>
                            </table>
                            
  <c:if test="${page.pageSize>0}"> 
       <table width="950">
	     <tr>
	          <td align="center" width=10%>序号</td>
		      <td align="center" width=30%>商品类别</td>
		      <td align="center" width=40%>备注</td>
		      <td align="center" width=20%>操作</td>
	     </tr>
		   <s:iterator value="#request.page" status="s">
		    <tr>
		        <td  align="center" width=10%>${s.count+(page.pageNo-1)*page.pageSize}</td>
			    <td  align="center" width=30%>${itemname}</td>
			    <td  align="center" width=40%>${remark}</td>
			     <td align="center" width=20%>
			    	<a href="javascript:edititem('${mitemid}','${itemname}','${remark}');">修改</a> &nbsp; 
					  <a href="javascript:deleteitem('${mitemid}');">删除</a>
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