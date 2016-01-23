
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
$(function() {

		//得到焦点
		$("#password").focus(function() {
			$("#left_hand").animate({
				left : "150",
				top : " -38"
			}, {
				step : function() {
					if (parseInt($("#left_hand").css("left")) > 140) {
						$("#left_hand").attr("class", "left_hand");
					}
				}
			}, 2000);
			$("#right_hand").animate({
				right : "-64",
				top : "-38px"
			}, {
				step : function() {
					if (parseInt($("#right_hand").css("right")) > -70) {
						$("#right_hand").attr("class", "right_hand");
					}
				}
			}, 2000);
		});
		//失去焦点
		$("#password").blur(function() {
			$("#left_hand").attr("class", "initial_left_hand");
			$("#left_hand").attr("style", "left:100px;top:-12px;");
			$("#right_hand").attr("class", "initial_right_hand");
			$("#right_hand").attr("style", "right:-112px;top:-12px");
		});
	});


   function login()
  {
	 if(document.form1.username.value.trim()!=""&&document.form1.password.value.trim()!="")
	 {
		 document.form1.method="post";
	     //document.form1.action= ctx+"/userinfoAction_login.do"
		 document.form1.action= ctx+"/frontLogin.action";
	     document.form1.submit(); 
	 }
	 else
	 {
		 document.form1.username.value="";
		 document.form1.password.value="";
		 alert("用户名和密码不能为空！");
	 }
  }
   

   $(function(){
	   $(".ipt").keydown(function(e){
		   keyDownSearch(e);
	   });
   });
   
   //document.onkeydown=keyDownSearch;
   //document.getElementById("test").onkeydown = keyDownSearch; 
   function keyDownSearch(e) {  
       // 兼容FF和IE和Opera  
       var theEvent = e || window.event;  
       var code = theEvent.keyCode || theEvent.which || theEvent.charCode;  
       if (code == 13) {  
    	   login();//具体处理函数  
           return false;  
       }  
       return true;  
   }
  

