  window.conform =function(content,func){   
        create_mask();
        var temp="<div id=\"msg1\" style=\"width:300px;border: 2px solid #37B6D1;background-color: #fff; font-weight: bold;font-size: 12px;\" >"
                +"<div style=\"line-height:25px; padding:0px 5px;    background-color: #37B6D1;\">校园电商平台提示您</div>"
                +"<table  cellspacing=\"0\" border=\"0\"><tr><td style=\" padding:0px 0px 0px 20px; \"></td>"
                +"<td ><div style=\"background-color: #fff; font-weight: bold;font-size: 12px;padding:20px 0px ; text-align:left;\">"+content
                +"</div></td></tr></table>"
                +"<div style=\"text-align:center; padding:0px 0px 20px;background-color: #fff;\"><input type='button'  style=\"border:1px solid #CCC; background-color:#CCC; width:50px; height:25px;\" value='确定'id=\"msgconfirmb\"   onclick=\"doOk();"+func+";\">";
        temp+="   <input type='button' style=\"border:1px solid #CCC; background-color:#CCC; width:50px; height:25px;\" value='取消'  id=\"msgcancelb\"   onClick='doOk()'>";
        temp+="</div></div>";
        create_msgbox(temp);
        document.getElementById("msgconfirmb").focus();        
    }
  
    function create_msgbox(temp){
        var box=document.createElement("div")    ;
        box.id="msgbox";
        box.style.position="absolute";
        box.style.width=400;
        box.style.height=200;
        box.style.overflow="visible";
        box.innerHTML=temp;
        box.style.zIndex=1001;
        document.body.appendChild(box);
        if(null!=box){
            var w=box.style.width;
            var h=box.style.height;
            box.style.left=get_left(400)+"px";
            box.style.top=get_top(200)+"px";
        }
    }
    
    function create_mask(){
        var mask=document.createElement("div");
        mask.id="mask";
        mask.style.position="absolute";
        mask.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=4,opacity=25)";//IE的不透明设置
        mask.style.opacity=0.4;//Mozilla的不透明设置
        mask.style.background="black";
        mask.style.top="0px";
        mask.style.left="0px";
        mask.style.width=document.body.clientWidth+document.body.scrollLeft;
        mask.style.height=document.body.clientHeight+document.body.scrollTop;
        mask.style.zIndex=1000;
        document.body.appendChild(mask);
        }
    
    function get_width(){
        return (document.body.clientWidth+document.body.scrollLeft);
    }
    function get_height(){
        return (document.body.clientHeight+document.body.scrollTop);
    }
    function get_left(w){
        var bw=document.body.clientWidth;
        var bh=document.body.clientHeight;
        w=parseFloat(w);
        return (bw/2-w/2+document.body.scrollLeft);
    }
    function get_top(h){
        var bw=document.body.clientWidth;
        var bh=document.body.clientHeight;
        h=parseFloat(h);
        return (bh/2-h/2+document.body.scrollTop);
    }
   
    this.doOk= function(){
        /*
        清除遮罩层以及弹出的对话框
        */
        var mask=document.getElementById("mask");
        var msgbox=document.getElementById("msgbox");
        if(null==mask&&null==msgbox)return;
        mask.style.display = "none";
		msgbox.style.display = "none";
        document.body.removeChild(mask);
        document.body.removeChild(msgbox);  
    };   