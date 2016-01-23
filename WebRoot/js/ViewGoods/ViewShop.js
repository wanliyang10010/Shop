
function opendetial(id,sid)
  {
		  window.open(ctx+"/viewProductAction_product.do?gid="+id+"&sid="+sid+"");  
  }
  
  function openHot(sid)
  {
		  document.form1.action= ctx+"/viewProductAction_productSH.do?sid="+sid+""; 
		  document.form1.submit();  
  }
  
  function openDiscount(sid)
  {
		  document.form1.action= ctx+"/viewProductAction_productSD.do?sid="+sid+""; 
		  document.form1.submit();  
  }
  
  function shopdetial(sid)
  {
	      document.form1.action= ctx+"/viewProductAction_shop.do";
		  document.form1.submit();  
  }