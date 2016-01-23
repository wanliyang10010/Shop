
	    var defaultColor="#ffffff";
	    var overColor="#836FFF";
	    var clickColor="gold";
	    var chooseRow=9999;
	    function over_color(obj){
	        if(obj.style.backgroundColor!=clickColor)
	            obj.style.backgroundColor=overColor;
	    }
	    function remove_color(obj){
	        if(obj.style.backgroundColor!=clickColor)
	            obj.style.backgroundColor=defaultColor;
	    }
	    function click_color(td){
	    	var tdobj = td.parentNode; //获取td节点对象
	    	var obj = tdobj.parentNode; //获取tr节点对象
	        var tb=obj.parentNode;//获得父节点（tbody节点）对象
	        if(chooseRow!=9999){
	            var lastObj=tb.rows[chooseRow-1];
	            lastObj.style.backgroundColor=defaultColor;
	        }
	        chooseRow=obj.rowIndex;//获得当前行在表格中的序数
	        obj.style.backgroundColor=clickColor;        
	    }
	    
