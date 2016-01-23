
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function deletemargin(id)
  {
     document.getElementById("dateId").value=id; 
      document.form1.action= ctx+"/dateRuleAction_delete.action"; 
       document.form1.submit(); 
  }
  
  function judgeNull()
  {
     if(document.form1.rule.value=="请选择")
     {
        alert("请选择日期类别！");
        return false;
     }
     if(document.form1.count.value.trim()=="")
     {
        alert("天数不能为空！");
        document.form1.count.value="";
        return false;
     }
     return true;
  }
  
  function add()
  {
     if(judgeNull())
     {
        document.form1.action= ctx+"/dateRuleAction_add.action"; 
       document.form1.submit(); 
     }
  }
  
   function update()
  {
   if(judgeNull())
     {
       document.form1.action= ctx+"/dateRuleAction_update.action"; 
       document.form1.submit(); 
        }
  }
  
  function search()
  {
	  document.getElementById("pageNo").value=1;
     document.form1.action= ctx+"/dateRuleAction_list.action"; 
     document.form1.submit();  
  }
  
  function editmargin(id,rule,count){
         document.getElementById("dateId").value=id; 
          document.getElementById("btn_update").style.display="";
          document.getElementById("btn_submit").style.display="none";
         tt = document.getElementById("rule");
         tt.value=rule;
         tt.disabled=true;
	     tt1 = document.getElementById("count");
	     tt1.value=count;
	    
     }
     
     function cancel(){
	     tt = document.getElementById("rule");
	     tt.disabled=false;
	     tt.readOnly=false;
	     tt1 = document.getElementById("count");
	     document.getElementById("btn_update").style.display="none";
          document.getElementById("btn_submit").style.display="";
	     tt.value="请选择";
	     tt1.value="";
     }