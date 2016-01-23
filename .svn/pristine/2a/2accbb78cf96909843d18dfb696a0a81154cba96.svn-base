
function deleteitem(id)
  {
       document.getElementById("itemId").value=id; 
       document.form1.action= ctx+"/superUserAction_delete.action"; 
       document.form1.submit(); 
  }
  
  function judgeNull()
  {
     if(document.form1.username.value=="")
     {
        alert("用户名不能为空！");
        return false;
     }
      if(document.form1.password.value=="")
	  {
	    alert("密码不能为空");
	    return;
	  }
     return true;
  }
  
  function add()
  {
      if(judgeNull())
     {
    	 
       document.form1.action= ctx+"/superUserAction_add.action"; 
       document.form1.submit(); 
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