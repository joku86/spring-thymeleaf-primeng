 function SendAjaxJsonRequest( jsonObject)
        {
            $.ajax({
                type: "POST",
                url: "save",
                data:jsonObject,
                 
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
       
