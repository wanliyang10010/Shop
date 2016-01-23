
function deleteitem(id)
  {
       document.getElementById("itemId").value=id; 
       document.form1.action= ctx+"/superUserAction_delete.action"; 
       document.form1.submit(); 
  }
  
  function judgeNull()
  {

		if(checkIllegalChar()!=true){
			 if(document.form1.username.value.trim()=="")
		     {
		        alert("用户名不能为空！");
		        document.form1.username.value="";
		        return false;
		     }
		      if(document.form1.password.value.trim()=="")
			  {
			    alert("密码不能为空");
			    document.form1.password.value="";
			    return false;
			  }
		      if(document.form1.password.value.length<6)
				 {
					alert("密码不能低于六位！");
					return false;
				 }
		} else
		{
			alert("文本框中不能包含下列任何字符： \" \' &amp;");
	        return false;
		}   
     return true;
  }
  
  function add()
  {
      if(judgeNull())
     {
    	  var username= document.form1.username.value;
    	  var password= document.form1.password.value;
    	  $.ajax({
	  			type : "POST",
	  			url : ctx+"/superUserAction_add.action",
	  			data : "username=" + username + "&password=" + password,
	  			success : function(result) {
	  				if (result.data == 'right') {
	  					//alert("添加成功!");
	  					window.location.reload(true);
	  				} else if (result.data == 'wrong') {
	  				 alert("该用户名已存在，请重新输入");
				           return;
	  				}
	  			},
	  			error : function() {
	  				window.location.href=ctx+"/error/remotelogin.jsp";
	   				//alert('系统忙，请稍后重试');
	  			}
	  		});
       }
  }
  
  function updateState(id)
  {
	   document.getElementById("itemId").value=id;
       document.form1.action= ctx+"/superUserAction_updateState.action"; 
       document.form1.submit(); 
  }
  
  function update()
  {
   if(judgeNull())
     {
       document.form1.action= ctx+"/superUserAction_update.action"; 
       document.form1.submit(); 
       }
  }
  
  function search()
  {
	 /* 贺鑫修改替换
     document.form1.action= ctx+"/superUserAction_list.action"; 
     */
	 document.form1.action= ctx+"/superUserAction_listAdmin.action"; 
     document.form1.submit();  
  }
  
  function edititem(id,name,password){
         document.getElementById("itemId").value=id;
         document.getElementById("username").value=name;
         document.getElementById("username").readOnly=true;
	     document.getElementById("password").value=password;
	     document.getElementById("btn_update").style.display="";
          document.getElementById("btn_submit").style.display="none";
  }
     
     function cancel(){
         document.getElementById("itemId").value="";
	     document.getElementById("username").value="";
	     document.getElementById("username").readOnly=false;
	     document.getElementById("password").value="";
	      document.getElementById("btn_update").style.display="none";
          document.getElementById("btn_submit").style.display="";
          
     }