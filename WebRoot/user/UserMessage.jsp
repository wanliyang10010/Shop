<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html> 
<title>完善个人信息 </title>
<%@ include file="/common/top-head.jspf"%>
 <script type="text/javascript" src="${ctx}/js/user/UserMessage.js"></script>  
 <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
  <body>
  <div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
  <div id="templatemo_main">
  <center>
    <form id="form1" name="form1" autocomplete="off">
    <input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
   <h1>完善用户信息</h1>
    <div> 
      <font color="red" id="font1" >当前用户：${username}</font>
     </div > 
     <div> 
      <font color="red" id="font1" >恭喜您，注册成功！请填写用户信息(可跳过)</font>
     </div > 
    <table width="600" align="center" oncontextmenu=return(false)>
                                 <tr >      
                              <td align="center" colspan="2">
                                <font color="red" id="font1" >姓名、生日、联系方式、邮箱信信息用于找回密码，请认真填写!</font>
                                  </td>
                                 </tr>
                        <tr> 
                                     <td align="right"  width="20%">
                                        <label for="textfield">*姓名：</label>
                                    </td>
                                    <td align="left">
                                        <input type="text" name="name" id="name" maxlength="10">
                                   </td>
                                </tr>
                                <tr>
                                	 
                                       <td align="right"  width="20%">
                                        <label for="textfield">*性别：</label>
                                    </td>
                                    <td align="left" >
							                <select name="sex" id="sex">
                                        <option value="请选择" selected>请选择</option>
									    <option value="男">男</option>
									    <option value="女">女</option>
									</select>
						           </td>	
                                </tr>
                                <tr> 
                                     <td align="right"  width="20%">
                                        <label for="textfield">*出生日期：</label>
                                    </td>
                                    <td align="left">
                                        <input class="Wdate" name="bdate" id="bdate" type="text" onClick="WdatePicker()" readonly="true">
                                    </td>
                                </tr>
                                <tr> 
                                     <td align="right"  width="20%">
                                        <label for="textfield">*手机号码：</label>
                                    </td>
                                    <td align="left" >
                                        <input type="tel" name="telephone" id="telephone" value="${telephone}" maxlength="11" >
                                    </td>
                                    
                                </tr>
                               <tr>
                                <td align="right"  width="20%">
                                        <label for="textfield">*邮箱地址：</label>
                                    </td>
                                    <td align="left">
                                        <input type="email" name="mail" id="mail" size="35" maxlength="50" value="${mail}">
                                    </td>
                               </tr>
                               <tr >
		    		<td align="right"  width="20%">*所在地区：</td>
		    		<td class="c-picker" align="left">
		    			<div id="picker" class="distpicker">
          					<select id="province" name="province"></select>
          					<select id="city" name="city"></select>
          					<select id="district" name="district"></select>
          					<em></em>
        				</div>
        			</td>
		    	</tr>
		    	<tr >
		    		<td align="right"  width="20%">*详细地址：</td>
		    		<td align="left"><input type="text" name="addr" id="addr" class="ipt_txt" size="55" maxlength="30" 
		    		 onkeyup="judgespace();" oninput="judgespace();"></td>
		    	</tr>
                               <tr  style="display:none">
								 <td align="right" width="30%">
                                        <label for="textfield">常住地址：</label>
                                    </td>
                                    <td align="left" >															
                                        <input type="text" name="address" id="address" size="40"  value="${fn:escapeXml(userinfo.address)}">
                                    </td>
								</tr>
								 <tr style="display:none">
								 <td align="right">
                                        <label for="textfield">id：</label>
                                    </td>
                                    <td align="left" width="300">
                                        <input type="text" name="userid" id="userid" value="${userid}">
                                    </td>
								</tr>
                                 <tr>
                                  <td align="center" colspan="4">
		                                  <input type="button" value="提交" onclick="updateM();"/>
		                                   &nbsp;&nbsp;&nbsp;&nbsp;  
		    							 <input type="button" value="跳过" onclick="cancel1();"/>
                                  </td>
                                </tr>
                            </table>
  </form>
  </center>
  </div>
    <footer>
     <script type="text/javascript" src="${ctx}/js/distpicker/distpicker.data.min.js"></script>
     <script type="text/javascript" src="${ctx}/js/distpicker/distpicker.js"></script>
   </footer>
  </body>
</html>
