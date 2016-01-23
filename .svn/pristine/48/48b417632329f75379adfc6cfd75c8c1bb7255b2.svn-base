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
    <title>管理员登录</title>
    <link rel="stylesheet" type="text/css"  href="${ctx}/backstage/css/admin_login.css" />
</head>
<body>
<div class="admin_login_wrap">
    <h1>管理员登录</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="${ctx}/superUserAction_loginBack.do" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user">用户名：</label>
                        <input type="text" name="username" id="username" value="superuser" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwd">密码：</label>
                        <input type="password" name="password" id="password" value="123456" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="提交" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
     <script type="text/javascript">
	      var ss='${msg}';
	      if(ss!="")
	      { 
	         alert(ss);   
	      }
	      </script>
</div>
</body>
</html>