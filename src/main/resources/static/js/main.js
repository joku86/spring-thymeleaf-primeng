//
//$(document).ready( function () {
//	 var table = $('#employeesTable').DataTable({
//		 "lengthMenu": [ 1,2,10, 25, 50, 75, 100 ],
//		 "pagingType": "full_numbers",
//		 "language": {
//	            "lengthMenu": "Anzahl Zeilen _MENU_ ",
//	            "zeroRecords": "Keine Treffer",
//	            "info": "Seite _PAGE_ von  _PAGES_",
//	            "infoEmpty": "Keine Datensätze vorhanden",
//	            "infoFiltered": "(Gefiltert auf insgesamt _MAX_ Zeilen)",
//	            "paginate": {
//	                "first":      "|<",
//	                "last":       ">|",
//	                "next":       ">>",
//	                "previous":   "<<"
//	            },
//	        },
//		 "pageLength": 10,
//		 "responsive": true,
//			"sAjaxSource": "/employee",
//			"sAjaxDataProp": "",
//			"order": [[ 0, "asc" ]],
//			"aoColumns": [
//			   
//		      { "mData": "name" },
//				  { "mData": "vorname" } ,
//				  { "mData": "a" },
//				  { "mData": "b" } 
//			]
//	 })
//});
$(function ()  
{  
    var x = "Self-Invoking Function";
    let d="df";
    
    console.log(x+ d);
}); 
$(function() {
	console.log("ddddd");
//	 MyFunctions = {  
//		        Sum: function (x, y)  
//		        {  
//		            return x + y;  
//		        },  
//		        Sub: function (x, y)  
//		        {  
//		            return x - y;  
//		        },  
//		        Div: function (x, y)  
//		        {  
//		            return x / y;  
//		        },  
//		        Mul: function (x, y)  
//		        {  
//		            return x * y;  
//		        }  
//		    }  
//		    var a = 20;  
//		    var b = 10;  
//		    alert("Value is 20 and 10 \n" + "Sum of Both value is is= " + MyFunctions.Sum(a, b) + "\n Subtraction of Both value is is= " + MyFunctions.Sub(a, b) + "\n Multiplication of Both value is is= " + MyFunctions.Mul(a, b) + "\n Divison of Both value is is= " + MyFunctions.Div(a, b))  

 
 
        var localData = [
            {'brand': 'Volkswagen', 'year': 2012, 'color': 'White', 'vin': 'dsad231ff'},
            {'brand': 'Audi', 'year': 2011, 'color': 'Black', 'vin': 'gwregre345'},
            {'brand': 'Renault', 'year': 2005, 'color': 'Gray', 'vin': 'h354htr'},
            {'brand': 'BMW', 'year': 2003, 'color': 'Blue', 'vin': 'j6w54qgh'},
            {'brand': 'Mercedes', 'year': 1995, 'color': 'White', 'vin': 'hrtwy34'},
            {'brand': 'Volvo', 'year': 2005, 'color': 'Black', 'vin': 'jejtyj'},
            {'brand': 'Honda', 'year': 2012, 'color': 'Yellow', 'vin': 'g43gr'},
            {'brand': 'Jaguar', 'year': 2013, 'color': 'White', 'vin': 'greg34'},
            {'brand': 'Ford', 'year': 2000, 'color': 'Black', 'vin': 'h54hw5'},
            {'brand': 'Fiat', 'year': 2013, 'color': 'Red', 'vin': '245t2s'}
        ];
         
        $('#tbl ').puidatatable({
        	
        	 lazy: true,
            caption: 'Editable Cells',
            editMode: 'cell',
            paginator: {
                rows: 10,
                totalRecords: totalArticles ,
            },
            columns: [
                {field: 'name', headerText: 'Vin', editor: 'input'},
                {field: 'vorname', headerText: 'Brand', editor: 'input'},
                {field: 'a', headerText: 'Year', editor: 'input'},
                {field: 'b', headerText: 'Color', editor: 'input'}
            ],
          datasource: function(callback) {
        	  
          $.ajax({
      		data: '{"command":"on"}',
          
              type: "POST",
              url: 'employee',
              dataType: "json",
              context: this,
              success: function(response) {
                  callback.call(this, response);
              }
          });
      },
      cellEdit:  function(event, ui) {
      	  if(ui.oldValue!=ui.newValue)
          	  SendAjaxJsonRequest();
          	  console.log(event+"succes ");
                $('#default').puigrowl('show', [{severity: 'info', summary: 'Cell Edit', detail: 'Old Value: ' + ui.oldValue + ', New Value: ' + ui.newValue + ' for ' + ui.field}]);
            }
        });
       var mein= 
        function(event, ui) {
      	  if(ui.oldValue!=ui.newValue)
      	  SendAjaxJsonRequest();
      	  console.log(event+"succes ");
            $('#default').puigrowl('show', [{severity: 'info', summary: 'Cell Edit', detail: 'Old Value: ' + ui.oldValue + ', New Value: ' + ui.newValue + ' for ' + ui.field}]);
        }

        $('#default').puigrowl();
        function daten(){
        	 
        	$.ajax({
        		

                type: "GET",
                url: 'save',
                dataType: "json",
                context: this,
              
            }).done(function(msg) {
            	console.log("dome "+msg);
                
            });
        } 
            
       
});
         