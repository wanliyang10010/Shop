<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息管理</title>
<%@ include file="/common/top-head.jspf"%>
<link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css" /> 
<script type="text/javascript" src="${ctx}/js/web1.js"></script>
<script type="text/javascript" src="${ctx}/js/user/Message.js"></script>
<script type="text/javascript" src="${ctx}/js/Alert.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
<div id="templatemo_main">
<h3 align="left">新消息查看</h3>
	<center>
		<form name="form1" action="" id="form1">
		<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
		<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	  <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
		<c:if test="${msg==''}">  		
       <table width="800"  align="center" >
       <c:if test="${request.page!=null&&request.page.pageNo>0}"> 
           <tr>
           <td></td>
	          <td align="center" width="20%"><a href="javascript:updateA();">忽略所有消息</a></td>
	      </tr>
         </c:if> 
		<s:iterator value="#request.page" status="s">
		  <tr>
	          <td align="left"  colspan="2" ><font color="red" id="font1">新消息</font></td>
	     </tr>
		    <tr>
		        <td align="left"><a href="javascript:openmessage('${messageId}','${url}','${idtype}','${idvalue}');">${text}</a></td>
			     <td  align="center" width="20%">
					  <a href="javascript:update('${messageId}');">忽略</a>
			     </td>
		    </tr>
	    	   </s:iterator>
	   </table>
	    </c:if>
	    <%@ include file="/common/pagination.jspf" %>
	         <div id="msg" >
	              <font color="red" id="font1" >${msg}</font>
	   
			</div>
		</form>
	</center>
	 <br/>
	  <br/>
	</div>
</body>
</html>
