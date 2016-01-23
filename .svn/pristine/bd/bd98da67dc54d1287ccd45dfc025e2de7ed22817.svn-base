
$(function(){
	var id = '';
	try{id = document.form1.sortype.value;}catch(e){}
	if(id == ''){
		$("#sortnew").attr("class", "choose");
	} else if(id=="1"){
		 $("#sortnew").attr("class", "choose");//.css("backgroundColor", "#ADFF99");
    } else if(id=="2"){
    	 $("#sortlow").attr("class", "choose");
	} else if(id=="3"){
		$("#sortheight").attr("class", "choose");
	} else if(id=="4"){
		$("#sortsub").attr("class", "choose");  
	}
});
 function searchType()
 {
	 var type=document.form1.stype.value;
	 
	 if(type=="商品")
	 {
		 listGoods();
	 }
	 else if(type=="店铺")
	 {
		 listShop();
	 }
	 else if(type=="二手")
	 {
		 listShand();
	 }
 }
 
 function AutoResieImage(maxWidth,maxHeight,objImg){
		var img = new Image();
		img.src = objImg.src;
		var hRatio;
		var wRatio;
		var Ratio = 1;
		var w = img.width;
		var h = img.height;
		wRatio = maxWidth / w;
		hRatio = maxHeight / h;
		if (maxWidth ==0 && maxHeight==0){
		Ratio = 1;
		}else if (maxWidth==0){//
		if (hRatio<1) Ratio = hRatio;
		}else if (maxHeight==0){
		if (wRatio<1) Ratio = wRatio;
		}else if (wRatio<1 || hRatio<1){
		Ratio = (wRatio<=hRatio?wRatio:hRatio);
		}
		if (Ratio<1){
		w = w * Ratio;
		h = h * Ratio;
		}
		objImg.height = h;
		objImg.width = w;
}	
 
 function search(id)
 {
	     document.getElementById("pageNo").value=1; 
	     document.getElementById("sortype").value=id; 
	     if(id=="1")
         {
	    	 document.form1.action=ctx+"/viewProductAction_listGoods.do"; 
	         document.form1.submit();  
         }
         else if(id=="2"){
		      document.form1.action= ctx+"/viewProductAction_listpricel.do"; 
		      document.form1.submit();  
		  }
		   else if(id=="3"){
		      document.form1.action= ctx+"/viewProductAction_listpriceh.do"; 
		      document.form1.submit();  
		  }
		   else if(id=="4"){
			      document.form1.action= ctx+"/viewProductAction_listSale.do"; 
			      document.form1.submit();  
			  }
 }
 
 function listShop()
 {
	 document.getElementById("pageNo").value=1; 
	 document.form1.action=ctx+"/viewProductActionShopSearch_listShop.do"; //dwj加了ShopSearch
     document.form1.submit();  
 }
 
 function listGoods()
 {
	 document.getElementById("pageNo").value=1; 
	 
    	 document.form1.action=ctx+"/viewProductAction_listGoods.do"; 
         document.form1.submit();  
		
 }
 
 function listShand()
 {
	 document.getElementById("pageNo").value=1; 
	 if( document.getElementById("typeitem").value=="所有商品")
     {
	 document.form1.action= ctx+"/viewProductAction_listShand.do"; 
	 document.form1.submit(); 
     }else
     {
    	 document.form1.action= ctx+"/viewProductAction_listShandByKey.do"; 
    	 document.form1.submit(); 
     }
 }
 
 function opendetial(id,sid)
 {
	
		  window.open(ctx+"/viewProductAction_product.do?gid="+id+"&sid="+sid+"");
 }
 
 function openHot()
 {
		  window.open(ctx+"/viewProductAction_productH.do");
 }
 
 function openDiscount()
 {
		  window.open(ctx+"/viewProductAction_productD.do");
 }
 
 function shopdetial(id)
 {
		  window.open(ctx+"/viewProductAction_shop.do?shopid="+id+"");
 }