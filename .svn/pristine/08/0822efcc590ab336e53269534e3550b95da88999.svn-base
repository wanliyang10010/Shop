//全局的AJAX访问，处理AJAX清求时SESSION超时
//Session过期的status 写在了SessionFilter的常量中:999
//$.ajaxSetup({
//    contentType:"application/x-www-form-urlencoded;charset=utf-8",
//    complete:function(XMLHttpRequest,textStatus){
//          //通过XMLHttpRequest取得响应头，sessionstatus           
//          var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); 
//          if(sessionstatus=="timeout"){
//               //这里怎么处理在你，这里跳转的登录页面
//               window.location.replace("/login.jsp");
//       }
//    }
//});


$(function(){
    $.ajaxSetup({
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        cache: false,
        complete: function(XHR, TS){
            var resText = XHR.responseText;
            var sessionstatus = XHR.getResponseHeader("sessionstatus");
            var loginPath = XHR.getResponseHeader("loginPath");
            var loginPath = XHR.getResponseHeader("loginPath");
            if (911 == XHR.status && "timeout" == sessionstatus) {
            	//alert('session过期');
                // 也可以使用下面的原生js的确认框，如果确认则跳转
                //if(window.confirm('session过期', '您的会话已经过期，请重新登陆后继续操作！')) {
                	// alert("xxx");
                	//window.location.replace(loginPath);
                	window.location.replace(loginPath);
                //}
                return;
            }
            if (999 == XHR.status && "unauthorized" == sessionstatus) {
            	//alert('无权操作页面数据');
            	
            	
            	
                //window.location.replace(loginPath);
            	window.location.replace("/index.jsp");
                return;
            }
        }
    });
});