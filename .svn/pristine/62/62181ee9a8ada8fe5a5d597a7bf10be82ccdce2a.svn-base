<%@ page language="java"  import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>密码重置</title>
<%@ include file="/common/top-head.jspf"%>
<script type="text/javascript" src="${ctx}/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="${ctx}/js/user/PasswordReset.js"></script>  
</head>
  <body>
  <div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
  <center>
  <div id="templatemo_main">
   <form name="form1" id="form1" autocomplete="off">  
    <input type="hidden" name="userinfoId" id="userinfoId" value="${msg_id}"/>
     <input type="password"  autocomplete="off" style="display:none"/>
   <div>
     <label for="textfield">请输入你需要重置登录密码的账户名：</label> 
        <table width="600" align="center"  border="1" oncontextmenu=return(false)>
              <tr> 
						  <td align="right" width="30%">
						                <label for="textfield">用户名：</label> 
						             </td>    
                                    <td align="left" width="40%">
                                         <input type="text" name="username" id="username" onclick="cancelCheck()"  value="${param.username}"  size="30"> 
                                    </td>
                                    <td align="left" width="40%">
                                    	 <input type="button" value="确定" onclick="checkname()"/>
                                    	 <font color="red" id="font1" >${msg}</font>
                                      </td>
              </tr>
        </table>
   </div>
   <c:if test="${msg==''}">
   <div id="dv_byway" style="display:">
         <table width="600" align="center"  border="1" oncontextmenu=return(false)>
           <tr> 
            <td align="left" widht="400">
                                      <label for="textfield">请选择密码找回方式</label>
                                    </td>
           </tr>
             <tr>
             <td  widht="400">
                         <input type="radio" value="通过用户姓名找回"  name="room" onclick="checkRadio(1)">通过姓名和生日找回
			                 <input type="radio" value="通过手机验证找回"   name="room" onclick="checkRadio(2)">通过手机验证找回              
			                     <input type="radio" value="通过邮箱验证找回 "  name="room" onclick="checkRadio(3)">通过邮箱验证找回              
                         </td>
             </tr>
             
             <tr> 
            <td align="left" style="display: none">
                                       <input type="text" id="item" name="item" value="${item}"/>
                                    </td>
           </tr>
                    </table>
      </div>
       </c:if>
 <div id="div1" style="display: none">
    <table width="600" align="center"  border="1" oncontextmenu=return(false)>
                        <tr height="30"> 
                                     <td align="right">
                                        <label for="textfield">用户姓名：</label>
                                    </td>
                                    <td align="left">
									  <input type="text" name="name" id="name" maxlength="15">
						           </td>
                                </tr>
                                <tr height="30"> 
                                     <td align="right">
                                        <label for="textfield">出生日期：</label>
                                    </td>
                                    <td align="left">
                                        <input class="Wdate" name="date" id="date" type="text" readonly="true"  onClick="WdatePicker();">
                                    </td>
                                </tr>
                                <tr height="30" id="tr_detial" style="display: none"> 
                                     <td align="center" colspan="2">
                                        <label for="textfield">该用户尚未填写用户名和出生日期信息</label>
                                    </td>                                 
                                </tr>
                            </table>
                              <div id="dv_check1">
                                  <td align="center" colspan="4">
		                                  <input type="button" value="验证" onclick="check(1);"/>
		                                   &nbsp;&nbsp;&nbsp;&nbsp;  
		    							 <input type="button" value="取消" onclick="cancelCheck();"/>
                                  </td>
                                </div>
                        </div>
                        <script type="text/javascript">
                        var detial='${msg_detial}';
                        if(detial=="该用户尚未填写用户名和出生日期信息")
                        {
                          document.getElementById("name").disabled = "true";
                          document.getElementById("date").disabled = "true";
                          document.getElementById("tr_detial").style.display = "";
                          document.getElementById("dv_check1").style.display = "none";
                        }
                        </script>
<div id="div2" style="display: none">
    <table width="600" align="center"  border="1" oncontextmenu=return(false)>
                        <tr height="30"> 
                                     <td align="right" width="30%">
                                        <label for="textfield">电话号码：</label>
                                    </td>
                                    <td align="left" colspan="2">
                                    ${msg_phone}
						           </td>
                                </tr>
                                <tr height="30" width="20%"> 
                                     <td align="right">
                                        <label for="textfield">验证码：</label>
                                    </td>
                                    <td align="left" width="40%">
                                        <input  name="randomp" id="randomp" type="text"  maxlength="6" 
                                         onkeyup="var myreg=/^[0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
                                      oninput="var myreg=/^[0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; ">
                                    </td>
                                    <td align="left" width="40%">
                                    	 <input type="button" value="获取" id="randomphone" onclick="sendPhone();"/>
                                    </td>
                                </tr>
                            </table>
                            <div id="dv_check2">
                                  <td align="center" colspan="4">
		                                  <input type="button" value="验证" onclick="check(2);"/>
		                                   &nbsp;&nbsp;&nbsp;&nbsp;  
		    							 <input type="button" value="取消" onclick="cancelCheck();"/>
                                  </td>
                                </div>
                        </div>
                        <script type="text/javascript">
                        var phone='${msg_phone}';
                        if(phone=="该账户手机号码信息不完整")
                        {
                          document.getElementById("randomphone").disabled = "true";
                          document.getElementById("dv_check2").style.display = "none";
                        }
                        </script>
<div id="div3" style="display: none">
    <table width="600" align="center"  border="1" oncontextmenu=return(false)>
                         <tr height="30"> 
                         <td align="right" width="30%">
                                     <label for="textfield">邮箱：</label>
                                     </td>
                                     <td align="left" colspan="2">
                                     ${msg_mail}
						           </td>	
                                </tr>
                                 </tr>
                                <tr height="30"> 
                                     <td align="right" width="20%">
                                        <label for="textfield">验证码：</label>
                                    </td>
                                    <td align="left" width="40%">
                                        <input  name="random" id="random" type="text" maxlength="6" 
                                         onkeyup="var myreg=/^[0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
                                      oninput="var myreg=/^[0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; ">
                                    </td>
                                    <td align="left" width="40%">
                                    	 <input type="button"  value="获取" id="randomMail" onclick="send();"/>
                                    </td>
                                </tr>
                            </table>
                            <div id="dv_check3">
                                  <td align="center" colspan="4">
		                                  <input type="button" value="验证" onclick="check(3);"/>
		                                   &nbsp;&nbsp;&nbsp;&nbsp;  
		    							 <input type="button" value="取消" onclick="cancelCheck();"/>
                                  </td>
                                </div>
                        </div>
                        <script type="text/javascript">
                        var mail='${msg_mail}';
                        if(mail=="该账户未填写邮箱信息")
                        {
                          document.getElementById("randomMail").disabled = "true";
                          document.getElementById("dv_check3").style.display = "none";
                        }
                          </script>
                              <div id="dv_pwd"  style="display: none">
                                   <table width="600" align="center"  border="1" oncontextmenu=return(false)>
                                    <tr> 
                                     <td align="right" width="30%">
                                        <label for="textfield">密     码：</label>
                                    </td>
                                    <td align="left">
                                        <input type="password" name="password" id="password" maxlength="20"
                                          onkeyup="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
                                          oninput="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; ">
                                    </td>
                                </tr>
                                <tr>
                                		 <td align="right">
                                        <label for="textfield">密码确认：</label>
                                    </td>
                                    <td align="left">
                                        <input type="password" name="password2" id="password2" maxlength="20"
                                          onkeyup="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
                                          oninput="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; ">
                                    </td>
                                </tr>
                                   <tr>
                                     <td align="center" colspan="4">
		                                    <input id="btn_submit" type="button"  onclick="changePWD();" value="修改密码">
		                                     &nbsp;&nbsp;&nbsp;&nbsp;  
                                       <input id="btn_cancel" type="button"  onclick="cancel();" value="取消">
                                  </td>
                                  </tr>
                                  </table>
                                </div>
  </form>
  </div>
  </center>
  </body>
</html>
