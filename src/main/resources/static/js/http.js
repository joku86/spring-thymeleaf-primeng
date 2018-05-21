 function SendAjaxJsonRequest(e, jsonObject)
        {
	 
	  e.preventDefault();
	    e.stopPropagation();
	    $.ajax({
            type: "POST",
            contentType : 'application/json; charset=utf-8',
            url: "/save",
            data: JSON.stringify(jsonObject)
        });
	  
        }

        /**
         * AJAX-Response auswerten
         */
        function onSuccess(content)
        {
            // Das empfangene Objekt wird wieder zum Objekt geparst
            
console.log("erfolgrecih"+content);
            
        }
       
