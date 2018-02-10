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

$(function() {
       
//        $('#tbl').puidatatable({
//            caption: 'Remote Restful Webservice - Eager',
//            editMode: 'cell',
//            paginator: {
//                rows: 10
//            },
//  
//            columns: [
//                {field: 'name', headerText: 'Name'},
//                {field: 'vorname', headerText: 'Vorname'},
//                {field: 'a', headerText: 'a-überschrift'},
//                {field: 'b', headerText: 'b'}
//            ],
//            datasource: function(callback) {
//                $.ajax({
//                    type: "GET",
//                    url: 'employee',
//                    dataType: "json",
//                    context: this,
//                    success: function(response) {
//                        callback.call(this, response);
//                    }
//                });
//            },
//            cellEdit: function(event, ui) {
////            	$.ajax({
////                    type: "GET",
////                    url: 'save',
////                    dataType: "json",
////                    context: this,
////                    success: function(response) {
////                    	console.log("sdf");
//////                        callback.call(this, response);
////                    }
////                });
////                 $('#messages').puigrowl('show', [{severity: 'info', summary: 'Cell Edit', detail: 'Old Value: ' + ui.oldValue + ', New Value: ' + ui.newValue + ' for ' + ui.field}]);
//            }
//        });
 
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
            caption: 'Editable Cells',
            editMode: 'cell',
          paginator: {
          rows: 10
      },
            columns: [
                {field: 'name', headerText: 'Vin', editor: 'input'},
                {field: 'vorname', headerText: 'Brand', editor: 'input'},
                {field: 'a', headerText: 'Year', editor: 'input'},
                {field: 'b', headerText: 'Color', editor: 'input'}
            ],
          datasource: function(callback) {
          $.ajax({
              type: "GET",
              url: 'employee',
              dataType: "json",
              context: this,
              success: function(response) {
                  callback.call(this, response);
              }
          });
      },
            cellEdit: t
            	
//            	function(event, ui) {
//            	t();
////                $('#messages').puigrowl('show', [{severity: 'info', summary: 'Cell Edit', detail: 'Old Value: ' + ui.oldValue + ', New Value: ' + ui.newValue + ' for ' + ui.field}]);
//            }
        });
        var t=$.ajax({
            type: "GET",
            url: 'save',
            dataType: "json",
            context: this,
            success: function(response) {
            	console.log("succes "+response);
                 
            },
            done:function(msg) {
            	console.log("dome "+msg);
                 
            }
        });
});
         