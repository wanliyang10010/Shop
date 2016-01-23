<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
				<s:if test="#request.page!= null&&#request.page.getTotalItems()>0"> 
				<table width="900px" align="center" id="tbDetail">
					</br>
					<tr style="background:#E0FFFF">
						<td align="center" width=10%>序号</td>
						<td align="center" width=20%>操作人</td>
						<td align="center" width=20%>操作时间</td>
						<td align="center" width=20%>流水金额（元）</td>
						<td align="center" width=30%>备注</td>
					</tr>
					<s:iterator value="#request.page" status="s">	
						<tr>
							<td align="center">${s.count+(page.pageNo-1)*page.pageSize}</td>
							<td align="center">${userinfo.username}</td>
							<td align="center">${userTime.substring(0, 10)}</td>
							<td align="center">
							<s:if test="%{money>0}">+${money}</s:if>
							<s:else>${money}</s:else>
							</td>
							<td align="center">
							<s:if test="%{remark==null||remark==\"0\"}">此用户很懒，什么也没留下……</s:if>
							<s:else>${remark}</s:else>
							</td>
						</tr>
					</s:iterator>
					 <tr><td colspan="5">
				  <%@ include file="/common/shopPaging.jspf" %>
				  </td>
				  </tr>
					<tr>
						<td align="center" colspan="5">
							<button id="btn_hidden" type="button" style="width:80px;"
								onclick="btnhidden();">隐藏详情</button></td>
					</tr>
				</table>
			</s:if>
			<div id="msg_viewMargin">
				<font color="red" id="font1">${msg_viewMargin}</font>
			</div>
