<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
<%@ include file="/common/taglibs.jspf"%>
<%@ page pageEncoding="UTF-8" %>
<!doctype html>
<html>
  <head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>查看用户申诉</title>    
<%@ include file="/common/top-head.jspf"%>
  </head>
  <body>
  <div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
  <div id="templatemo_main">
     <center>
	<form name="form1"  id="form1"  action="" >
	<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
                            <div>
                            <h1>订单申诉查看</h1>
                            <table width="800" border="1">
                                <tr height="40px"> 
                                    <td align="right" style=" width:30%" >
                                    <label for="textfield">申诉人：</label>
                                    </td>
                                    <td align="left">
                                      <label for="textfield">${dispute.accuser}</label>
                                       </td>
                                 </tr>
                                 <tr height="40px">
                                    <td align="right" style=" width:30%" >
                                    <label for="textfield">被申诉人：</label>
                                    </td>
                                    <td align="left">
                                     <label for="textfield">${dispute.sccused}</label>
                                       </td>
                                </tr>
                                 <tr height="40px">
                                    <td align="right" style=" width:30%" >
                                    <label for="textfield">相关交易：</label>
                                    </td>
                                    <td align="left">
                                     <label for="textfield">${dispute.orderson}</label>
                                       </td>
                                </tr>
                                 <tr height="40px">
                                    <td align="right" style=" width:30%" >
                                    <label for="textfield">申诉类型：</label>
                                    </td>
                                        <td align="left">
                                         <label for="textfield">${dispute.dtype}</label>
                                    </td>
                                </tr>
                                 <tr height="40px">
                                    <td align="right" style=" width:30%" >
                                    <label for="textfield">申诉原因：</label>
                                    </td>
                                    <td align="left">
                                    <label for="textfield">${dispute.content}</label>
                                       </td>
                                </tr>
                                 <tr height="40px">
                                    <td align="right" style=" width:30%" >
                                    <label for="textfield">处理结果：</label>
                                    </td>
                                     <td align="left" width:80%">
                                       <label for="textfield"><font color="red" id="font1" >${dispute.result}</font></label>
                                      </td>
                                 <tr>
                                 <tr style="display:none"> 
                                     <td align="right">
                                        <label for="textfield">id：</label>
                                    </td>
                                    <td align="left">
                                        <input type="number" name="disputeId" id="disputeId" value="${dispute.disputeid}">
                                        <input type="number" name="fileId" id="fileId">
                                    </td>
                                    
                            </table>
                            <c:if test="${not empty DisputeFileList}">
	      <table width="800" border="1">
       <c:forEach items="${DisputeFileList}" var="disputeFile">
								<tr>
									<td align="center"><img height="400" width="500" src="${ctx}${disputeFile.url}" /></td>
								</tr>
							</c:forEach>
	   </table> 
	  </c:if>
     
	    </div>             
	 </form>
	</center> 
	</div>
  </body>
  <script type="text/javascript">
$("img").each(function(){
  this.onerror=function(){
    this.src="image/picerror.jpg";
 };
});
</script>
</html>
