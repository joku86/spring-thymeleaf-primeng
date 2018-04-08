 function SendAjaxJsonRequest(url, method, jsonObject)
        {
            $.ajax({
                type: "GET",
                url: "save",
                 
                success: onSuccess
            });
        }

        /**
         * AJAX-Response auswerten
         */
        function onSuccess(content)
        {
            // Das empfangene Objekt wird wieder zum Objekt geparst
            
console.log("hhhh h "+content);
            
        }
       
