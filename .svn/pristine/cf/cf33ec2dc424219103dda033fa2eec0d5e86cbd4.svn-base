function jumpPage(currentPage) {
	$("#currentPage").val(currentPage);
	//$("#myform").submit();
	//$('#mysubmit').trigger("click");
	pageGo();
	return true;
}

function changePageSize(pageSize) {
	$("#pageSize").val(pageSize);
	$("#currentPage").val(1);
	//$("#myform").submit();
	//$('#mysubmit').trigger("click");
	pageGo();
	return true;

}

function goPage(totalPages) {
	var currentPage;
	currentPage = $("#navNum").val();
	if(currentPage < 1){
		currentPage = 1;
	} else if(currentPage > totalPages) {
		currentPage = totalPages;
	}
	$("#currentPage").val(currentPage);
	//$("#myform").submit();
	//$('#mysubmit').trigger("click");
	pageGo();
	return true;
}

function search() {
	$("#currentPage").val(1);
	$("#pageSize").val(5);
	//$("#myform").submit();
	return true;

}
