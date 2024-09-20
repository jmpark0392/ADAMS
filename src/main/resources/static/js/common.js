function errorHandler(xhr) {
	if (xhr.status == "403" || xhr.status == "404") {
		$("#pageName").val("/error/error_400");
	} else if (xhr.status == "500" || xhr.status == "503") {
		$("#pageName").val("/error/error_500");
	} else {
		$("#pageName").val("/error/error");
	} 
	$("#form").submit();
}