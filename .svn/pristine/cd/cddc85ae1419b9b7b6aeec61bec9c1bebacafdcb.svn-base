
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function deletemargin(id)
  {
     document.getElementById("pointsId").value=id; 
      document.form1.action= ctx+"/pointsRuleAction_delete.action"; 
       document.form1.submit(); 
  }
  
  function judgeNull()
  {
     if(document.form1.type.value=="请选择")
     {
        alert("请选择用户类型！");
        return false;
     }
     if(document.form1.rule.value=="请选择")
     {
        alert("请选择积分项目！");
        return false;
     }
     if(document.form1.count.value.trim()=="")
     {
        alert("积分数不能为空！");
        document.form1.count.value="";
        return false;
     }
     return true;
  }
  
  function add()
  {
    if(judgeNull())
     {
       document.form1.action= ctx+"/pointsRuleAction_add.action"; 
       document.form1.submit(); 
       }
  }
  
   function update()
  {
    if(judgeNull())
     {
       document.form1.action= ctx+"/pointsRuleAction_update.action"; 
       document.form1.submit(); 
       }
  }
  
  function search()
  {
	 document.getElementById("pageNo").value=1;
     document.form1.action= ctx+"/pointsRuleAction_list.action"; 
     document.form1.submit();  
  }
  
  function editmargin(id,type,rule,count){
         document.getElementById("pointsId").value=id; 
          document.getElementById("btn_update").style.display="";
          document.getElementById("btn_submit").style.display="none";
         tt = document.getElementById("rule");
         tt.disabled=true;
	     tt1 = document.getElementById("count");
	     tt.value=rule;
	     tt1.value=count;
	     tt2 = document.getElementById("type");
	     tt2.disabled=true;
	     for(var i=0;i< tt2.options.length;i++){ 
            if( tt2.options[i].value===type){ 
                tt2.options[i].selected=true; 
     
          }
            }
     }
     
     
     function cancel(){
	     tt = document.getElementById("rule");
	     tt1 = document.getElementById("count");
	     tt2 = document.getElementById("type");
	     document.getElementById("btn_update").style.display="none";
          document.getElementById("btn_submit").style.display="";
	     tt1.value="";
	     tt2.value="请选择";
	     tt.value="请选择";
	     tt.disabled=false;
	     tt2.disabled=false;
     }