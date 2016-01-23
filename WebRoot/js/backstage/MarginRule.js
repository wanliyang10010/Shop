
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
function deletemargin(id) {
		document.getElementById("marginruleId").value = id;
		document.form1.action = ctx+"/marginRuleAction_delete.action";
		document.form1.submit();
	}

	function judgeNull() {
		if (document.form1.type.value == "请选择") {
			alert("请选择店铺类型！");
			return false;
		}
		if (document.form1.product.value == "请选择") {
			alert("请选择商品类别！");
			return false;
		}
		if (document.form1.money.value.trim() == "") {
			alert("保证金不能为空！");
			document.form1.money.value= "";
			return false;
		}
		return true;
	}

	function add() {
		if (judgeNull()) {
			document.form1.action = ctx+"/marginRuleAction_add.action";
			document.form1.submit();
		}
	}

	function update() {
		if (judgeNull()) {
			document.form1.action = ctx+"/marginRuleAction_update.action";
			document.form1.submit();
		}
	}

	function search() {
		document.getElementById("pageNo").value=1;
		document.form1.action = ctx+"/marginRuleAction_list.action";
		document.form1.submit();
	}

	function editmargin(id, type, product, money) {
		document.getElementById("marginruleId").value = id;
		document.getElementById("btn_update").style.display = "";
		document.getElementById("btn_submit").style.display = "none";
		
		tt = document.getElementById("product");
		tt1 = document.getElementById("money");
		tt.value = product;
		tt1.value = money;
		tt2 = document.getElementById("type");
		for ( var i = 0; i < tt2.options.length; i++) {
			if (tt2.options[i].value === type) {
				tt2.options[i].selected = true;
			}
		}
		 tt.disabled=true;
		 tt2.disabled=true;
	}

	function cancel() {
		tt = document.getElementById("product");
		tt1 = document.getElementById("money");
		tt2 = document.getElementById("type");
		document.getElementById("btn_update").style.display = "none";
		document.getElementById("btn_submit").style.display = "";
		tt1.value = "";
		tt2.value = "请选择";
		tt.value = "请选择";
		 tt.disabled=false;
		 tt2.disabled=false;
	}