function SendAjaxJsonRequest(e, jsonObject, fn) {

	$.ajax({
		type : "POST",
		contentType : 'application/json; charset=utf-8',
		async : false,
		url : "/save",
		data : JSON.stringify(jsonObject),
		success : function(result) {
			console.log("erfolgrecih" + result);
		},
		error : fn
	});

}

/**
 * AJAX-Response auswerten
 */
function onSuccess(content) {
	// Das empfangene Objekt wird wieder zum Objekt geparst

	console.log("erfolgrecih" + content);

}
