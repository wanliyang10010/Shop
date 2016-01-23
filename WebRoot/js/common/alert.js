window.alert =function(content){   
        //var icon="http://images.cnblogs.com/cnblogs_com/IT-Bear/365886/t_msgbox_"+icon+".png";
        
        var mask=document.createElement("div");
        mask.id="mask";
        mask.style.position="absolute";
        mask.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=4,opacity=25)";//IE的不透明设置
        mask.style.opacity=0.4;//Mozilla的不透明设置
        mask.style.background="black";
        mask.style.top="0px";
        mask.style.left="0px";
        mask.style.width=document.body.scrollWidth+"px";
        mask.style.height=document.body.scrollHeight+"px";
        mask.style.zIndex=1000;
        document.body.appendChild(mask);
        var temp="<div id=\"msg\" style=\"width:300px;border: 2px solid #37B6D1;background-color: #fff; font-weight: bold;font-size: 12px;\" >"
            +"<div  style=\"line-height:25px; padding:0px 5px; text-align:left;  background-color: #37B6D1; color: #4B4B4B;\">校园电商平台提示您</div>"
            +"<ui>"
            +"<div align=\"center\"  style=\" line-height:40px;background-color: #fff; font-weight: bold;font-size: 12px;padding:20px 0px ; text-align:center;\">"+content
            +"</div></ui>"
            +"<div style=\"text-align:center; padding:0px 0px 20px;background-color: #fff;\"><input type='button'  style=\"border:1px solid #CCC; background-color:#CCC; width:50px; height:25px;\" value='确定' id=\"msgconfirmb\"   onclick=\"doOk();\">";
//        var temp="<div id=\"msg\" style=\"width:300px;border: 2px solid #37B6D1;background-color: #fff; font-weight: bold;font-size: 12px;\" >"
//                +"<div align=\"left\" style=\"line-height:25px; padding:0px 5px;   background-color: #37B6D1;\">校园电商平台提示您</div>"
//                +"<table  cellspacing=\"0\"><tr><td style=\" padding:0px 0px 0px 20px; \"><img src=\""+icon+"\" width=\"64\" height=\"64\"></td>"
//                +"<td ><div style=\"background-color: #fff; font-weight: bold;font-size: 12px;padding:20px 0px ; text-align:left;\">"+content
//                +"</div></td></tr></table>"
//                +"<div style=\"text-align:center; padding:0px 0px 20px;background-color: #fff;\"><input type='button'  style=\"border:1px solid #CCC; background-color:#CCC; width:50px; height:25px;\" value='确定' id=\"msgconfirmb\"   onclick=\"doOk();\">";
        temp+="</div></div>";
        var box=document.createElement("div")    ;
        box.id="msgbox";
        box.style.left = "50%";
        box.style.top = "50%";
    	box.style.marginLeft = "-150px";
    	box.style.marginTop = "-200px";
        box.style.textAlign = "center";
        box.style.position="absolute";
        box.style.width="400px";
        box.style.height="200px";
        box.style.overflow="visible";
        box.innerHTML=temp;
        box.style.zIndex=1001;
        document.body.appendChild(box);
        document.getElementById("msgconfirmb").focus();        
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

//window.alert = function(txt)
//{
//
//	var shield=document.createElement("div");
//	shield.style.position="absolute";
//	shield.style.top="0";
//	shield.style.background="#CCC";
//	shield.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75)";
//	shield.style.opacity="0.6";
//	shield.style.left="0";
//	shield.style.width="100%";
//	//shield.style.height="250%";
//	shield.style.height= document.body.scrollHeight;
//	shield.style.zIndex = "10000";
//	document.body.appendChild(shield);
//	
//	var alertFram = document.createElement("DIV");
//	alertFram.id="alertFram";
//	alertFram.style.position = "absolute";
//	alertFram.style.left = "50%";
//	alertFram.style.top = "50%";
//	alertFram.style.marginLeft = "-150px";
//	alertFram.style.marginTop = "-200px";
//	alertFram.style.width = "300px";
//	alertFram.style.height = "150px";
//	alertFram.style.background = "#ccc";
//	alertFram.style.textAlign = "center";
//	alertFram.style.lineHeight = "150px";
//	alertFram.style.zIndex = "10001";
//	strHtml = "<ul style=\"list-style:none;margin:0px;padding:0px;width:100%\">\n";
//	strHtml += " <li style=\"background:#41B3CF;color:#5E5E5E;text-align:left;padding-left:5px;font-size:14px;font-weight:bold;height:25px;line-height:25px;border:1px solid #41B3CF;\">校园电商系统提示</li>\n";
//	strHtml += " <li style=\"background:#FFF;text-align:center;font-size:14px;height:120px;line-height:120px;border-left:1px solid #41B3CF;border-right:1px solid #41B3CF;\">"+txt+"</li>\n";
//	strHtml += " <li style=\"background:#41B3CF;text-align:center;font-weight:bold;height:25px;line-height:25px; border:1px solid #41B3CF;\"><input type=\"button\" value=\"确 定\" id=\"msgconfirmb\" onclick=\"doOk()\"/></li>\n";
//	strHtml += "</ul>\n";
//	alertFram.innerHTML = strHtml;
//	document.body.appendChild(alertFram);
//	document.getElementById("msgconfirmb").focus();        
//	var c = 0;
//	this.doAlpha = function(){
//		if (c++ > 20){clearInterval(ad);return 0;}
//		shield.style.filter = "alpha(opacity="+c+");";
//	}
//	var ad = setInterval("doAlpha()",5);
//	this.doOk = function(){
//		alertFram.style.display = "none";
//		shield.style.display = "none";
//	}
//	//alertFram.focus();
//	document.body.onselectstart = function(){return false;};
//}
