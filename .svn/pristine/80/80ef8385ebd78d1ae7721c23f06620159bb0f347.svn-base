<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>修改密码</title>
<%@ include file="/common/top-head.jspf"%>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="${ctx}/js/user/PasswordChange.js"></script>  
</head>
  <body>
  <div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
  <center>
  <div id="templatemo_main">
   <form name="form1" id="form1" autocomplete="off">
   <input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
   <div>
    <input type="hidden" name="userinfoId" id="userinfoId" value="${userinfo.userinfoId}"/>
     <input type="password"  autocomplete="off" style="display:none"/>
        <table width="500" align="center"  border="1" id="tb_old" oncontextmenu=return(false)>
        <tr>
        <td colspan="2" align="left">
        请输入当前密码：
        </td>
        </tr>
              <tr> 
						  <td align="right" width="30%">
						                <label for="textfield">当前密码：</label> 
						             </td>    
                                    <td align="left">
                                        <input type="password"  name="oldpassword" id="oldpassword" value="${param.oldpassword}" maxlength="20" 
                                        onkeyup="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
                                        oninput="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
                                         autocomplete="off" />
                                    	 <input type="button" value="确定" onclick="checkpassword()"/>
                                    </td>
              </tr>
        </table>
   </div>
    <div id="dv_pwd" style="display:none">
                                   <table width="500" align="center"  border="1" oncontextmenu=return(false)>
                                    <tr> 
                                     <td align="right" width="30%">
                                        <label for="textfield">新密码：</label>
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
                                       <input id="btn_cancel" type="button"  onclick="cancel()" value="取消">
                                  </td>
                                  </tr>
                                  </table>
                                </div>
	      <script type="text/javascript">
	     var ss='${msg}';
	     //alert(ss);
	      if(ss=="请输入新密码！")
	      {
	         document.getElementById("tb_old").style.display="none"; 
	         document.getElementById("dv_pwd").style.display="";     
	      }
	      else  if(ss=="密码错误，请重新输入！")
	      {
	        alert(ss);
	      }
	      </script>
  </form>
  </div>
  </center>
  </body>
</html>
