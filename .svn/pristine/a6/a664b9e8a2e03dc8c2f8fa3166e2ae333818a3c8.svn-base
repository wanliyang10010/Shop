function addCategory() {
		if (document.getElementById("ctype").value == "") {
			alert("请填写商品类别名称");
			document.form1.ctype.focus();
		} else {
			document.form1.action = "${pageContext.request.contextPath}/categoryAction_save.action";
			document.form1.submit();
		}
	}

	function cancelCategory()
	 {
	    document.getElementById("ctype").value == "";
	 }
	
	function addproperty() {
		if (document.getElementById("property").value == "") {
			alert("请填写商品属性描述名称");
			document.form1.property.focus();
		} else {
		    document.form1.method="post";
			document.form1.action ="${pageContext.request.contextPath}/categoryAction_saveproperty.action";
			document.form1.submit();
		}
	}
	
	function cancelproperty()
	 {
	       document.getElementById("property").value = "";
	}
	
	function delcfm() {
		if (!confirm("确认要删除？")) {
			window.event.returnValue = false;
		}
	}
	
    function query()
   {
     document.form1.method="post";
     document.form1.action= "${pageContext.request.contextPath}/categoryAction_query.action"; 
     document.form1.submit();
  }
  
      function updateensure()
   {
   
     var cid = document.getElementById("cid").value;
     document.form1.method="post";
     document.form1.action= "${pageContext.request.contextPath}/categoryAction_updateensure.action"; 
     document.form1.submit();
  }
  
  function change(id,ctype)
	{
	    document.getElementById("cid").value = id;
		document.getElementById("ctype").value = ctype;
	    document.getElementById("tb").style.display = "";
	}
  
  
  function changecategory(id, property) {
		document.getElementById("categorysonid").value = id;
		document.getElementById("property").value = property;
		document.getElementById("table").style.display = "";
	}

	function updateconfirm() {
		if (document.getElementById("property").value == "") {
			alert("请填写商品属性描述名称");
			document.form1.property.focus();
		} else {
			var categorysonid = document.getElementById("categorysonid").value;
			document.form1.method = "post";
			document.form1.action = "${pageContext.request.contextPath}/categoryAction_updateok.action";
			document.form1.submit();
		}
	}

	function updateok() {
		document.getElementById("property").value = "";
	}