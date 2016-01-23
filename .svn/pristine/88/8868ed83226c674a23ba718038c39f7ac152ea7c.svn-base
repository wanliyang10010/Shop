
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function deleteitem(id)
  {
       document.getElementById("itemId").value=id; 
       document.form1.action= ctx+"/pointsItemAction_delete.action"; 
       document.form1.submit(); 
  }
  
  function judgeNull()
  {
	  if(checkIllegalChar()!=true){
		  if(document.form1.itemname.value.trim()=="")
		     {
		        alert("积分类别不能为空！");
		        document.form1.itemname.value="";
		        return false;
		     }
		      if(document.form1.remark.value.trim()=="")
			  {
			    alert("备注不能为空");
			    document.form1.remark.value="";
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
       document.form1.action= ctx+"/pointsItemAction_add.action"; 
       document.form1.submit(); 
       }
  }
  
   function update()
  {
   if(judgeNull())
     {
       document.form1.action= ctx+"/pointsItemAction_update.action"; 
       document.form1.submit(); 
       }
  }
  
  function search()
  {
	 document.getElementById("pageNo").value=1;
     document.form1.action= ctx+"/pointsItemAction_list.action"; 
     document.form1.submit();  
  }
  
  function edititem(id,name,remark){
  
         document.getElementById("itemId").value=id;
         document.getElementById("itemname").value=name;
         document.getElementById("itemname").readOnly=true;
	     document.getElementById("remark").value=remark;
	     document.getElementById("btn_update").style.display="";
          document.getElementById("btn_submit").style.display="none";
     }
     
     
     function cancel(){
         document.getElementById("itemId").value="";
	     document.getElementById("itemname").value="";
	     document.getElementById("itemname").readOnly=false;
	     document.getElementById("remark").value="";
	      document.getElementById("btn_update").style.display="none";
          document.getElementById("btn_submit").style.display="";
         
     }