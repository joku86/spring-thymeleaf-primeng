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
	var x = "Self-Invoking Function";
	let
	d = "df";

	console.log(x + d);
});
$(function() {
	console.log("ddddd");
	// MyFunctions = {
	// Sum: function (x, y)
	// {
	// return x + y;
	// },
	// Sub: function (x, y)
	// {
	// return x - y;
	// },
	// Div: function (x, y)
	// {
	// return x / y;
	// },
	// Mul: function (x, y)
	// {
	// return x * y;
	// }
	// }
	// var a = 20;
	// var b = 10;
	// alert("Value is 20 and 10 \n" + "Sum of Both value is is= " +
	// MyFunctions.Sum(a, b) + "\n Subtraction of Both value is is= " +
	// MyFunctions.Sub(a, b) + "\n Multiplication of Both value is is= " +
	// MyFunctions.Mul(a, b) + "\n Divison of Both value is is= " +
	// MyFunctions.Div(a, b))
 
	$('#default').puigrowl();
	$('#tbl ').puidatatable(
			{

				lazy : true,
				caption : 'Editable Cells',
				editMode : 'cell',
				paginator : {
					rows : 10,
					totalRecords : totalArticles,
				},
				columns : [ {
					field : 'name',
					headerText : 'Vin',
					editor : 'input'
				}, {
					field : 'vorname',
					headerText : 'Brand',
					editor : 'input'
				}, {
					field : 'birthday',
					headerText : 'Year',
					editor : 'input'
				}, {
					field : 'id',
					headerText : 'Color',
					editor : 'input'
				} ],
				datasource : function(callback) {

					$.ajax({
						data : '{"command":"on"}',

						type : "POST",
						url : 'employee',
						dataType : "json",
						context : this,
						success : function(response) {
							callback.call(this, response);
						}
					});
				},
				cellEdit : function(event, ui) {
					event.preventDefault();
					event.stopPropagation();
					if (ui.oldValue != ui.newValue) {
						ui.data[ui.field]=ui.newValue;
						SendAjaxJsonRequest(event, ui.data,function(result){
			            	console.log("fehler "+result);
			            	ui.data[ui.field]=ui.oldValue;
			            	return false;
			            });
						console.log("gesendet " + ui);
						$('#default').puigrowl(
								'show',
								[ {
									severity : 'info',
									summary : 'Cell Edit',
									detail : 'Old Value: ' + ui.oldValue
											+ ', New Value: ' + ui.newValue
											+ ' for ' + ui.field
								} ]);

					}
					
				}
			});
 

	 
});
