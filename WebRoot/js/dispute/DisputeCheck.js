
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function checkRadio(item){
	   if(item=="1"){
	    	document.getElementById("tr1").style.display="";
            document.getElementById("tr2").style.display="none";
	    }else if(item=="2"){	
            document.getElementById("tr1").style.display="none";
            document.getElementById("tr2").style.display="";
		}
	}
	
	function judgeNull()
   {
		if(checkIllegalChar()!=true){
			if(document.form1.dtstart.value.trim()=="")
		     {
		        alert("请填写开始日期！");
		        document.form1.dtstart.value="";
		        return false;
		     }
		     if(document.form1.dtend.value.trim()=="")
		     {
		        alert("请填写截止日期！");
		        document.form1.dtend.value="";
		        return false;
		     }
		     if(document.form1.dtstart.value>document.form1.dtend.value)
		     {
		        alert("结束日期必须大于截止日期！");
		        return false;
		     }
		} else
		{
			alert("文本框中不能包含下列任何字符： \" \' &amp;");
	        return false;
		}
     return true;
   }
	
   function searchDate()
  {
    if(judgeNull())
     {
    	document.getElementById("pageNo").value=1; 
     document.form1.action= ctx+"/disputeAction_searchDate.action"; 
     document.form1.submit();  
     }
  }
  
  function search()
  {
	  document.getElementById("pageNo").value=1; 
     document.form1.action= ctx+"/disputeAction_search.action"; 
     document.form1.submit();  
  }
  
   function getlist(id)
  {
   
      window.open(ctx+"/disputeFileAction_listfile.action?disputeId="+id+"");
      //document.getElementById("disputeId").value=id;
     // document.form1.action= "${ctx}/disputeFileAction_listfile.action"; 
     // document.form1.submit();  
  }
   
   function openpicture(url)
   {
       window.open(ctx+url); 
   }