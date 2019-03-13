$(document).ready(function(){
	
	AjaxUtil.utils.sendGetRequest('/parmanagement/par/parmasters', populateParMasterInfo, parMasterLoadFailure);
	$('#parMasterStatusDiv').hide();
	var table=null;
	
    $("#addNewParMasterBtn").on("click", function(){
    	$('#parMasterModal').modal('show'); 
    });
    
    $('#parMasterModal').on('hidden.bs.modal', function() {
        var parMasterForm = $('#parMasterForm');
        parMasterForm.validate().resetForm();
        parMasterForm.find('.error').removeClass('error');
    });
    
    
	function populateParMasterInfo(response){
		table = $('#tblParMasters').DataTable(
				{
					autoWidth: false,
										
					columns: [
     					{ data: 'parNumber' },
						{ data: 'parReceivedDate' },
						{ data: 'skill' },
						{ data: 'externalStaff' },
						{ data: 'parRole' },
						{ data: 'area' },
						{ data: 'parDescriptionText' },
						{ data: 'parStatus' },
						{
							data:null,
							render: function (data, type, row){
                                return '<button class="btnDelete btn btn-sm deleteRow"><img src="static/img/delete.png" alt="Delete"></button>  <button class="btnViewParMaster btn btn-sm editRow" data-toggle="modal" data-target="#parMasterModal" data-parnumber="' + data.parNumber + '" data-parreceiveddate= " '+ data.parReceivedDate + '" data-skill="' + data.skill + '" data-externalStaff="' + data.externalStaff + '" data-parrole="' + data.parRole + '" data-area="' + data.area + '" data-pardescriptiontext="' + data.parDescriptionText + '" data-parstatus="' + data.parStatus + '"><img src="static/img/edit.png" alt="Edit"></button>';
                               }
						},
					
					],
			        columnDefs: [
			            {
			                "targets": [ 0 ],
			                "visible": false,
			                "searchable": false
			            },
			            {
			                "targets": [ 3 ],
			                "visible": false,
			                "searchable": false
			            }
			        ],
			        rowId: 'parNumber',
			        order: [[0,'desc']]
                }		
		);
		table.clear().rows.add(response).draw();
		$("#tblParMasters tbody").on('click', '.btnDelete', function () {
			var parMaster = table.row($(this).closest('tr')).data();
			
		    $('#parMasterconfirm').modal({ backdrop: 'static', keyboard: false })
	        .on('click', '#parMasterDelete-btn', function(){
				var deleteData={};
				deleteData['parNumber']=parMaster.parNumber;
				deleteData['externalStaff']=parMaster.externalStaff;
				AjaxUtil.utils.sendDeleteRequest('/parmanagement/par/parmasters/'+parMaster.parNumber, parMasterDeleteSuccess(deleteData,'deleted','statusMessage'), parMasterDeleteFailure(parMaster.externalStaff), parMasterDeleteFailure(parMaster.parReceivedDate));
				$('#parMasterconfirm').modal('hide');
	        });
		    
		});
		
		$("#tblParMasters tbody").on('click', '.btnViewParMaster', function () {
			var parMaster = table.row($(this).closest('tr')).data();
			var rowIndex = $(this).closest('tr').index();
		     $("#rowIndex").val(rowIndex);
		});
	}
	
	function parMasterLoadFailure(xhr, error){
		if(xhr.status!=404){
			var reponseBody = JSON.parse(xhr.responseText);
			$('#extStaffStatusDiv').removeClass("alert alert-success");
			$('#extStaffStatusDiv').addClass("alert alert-warning");
			$('#extStaffStatusMessage').html(reponseBody['message']);
			$('#extStaffStatusDiv').show();
		}else{
			$('#extStaffStatusDiv').hide();
		}
	}
	
    $("[data-hide]").on("click", function(){
        $(this).closest("." + $(this).attr("data-hide")).hide();
    });
	
	var parMasterDeleteFailure = function(externalStaff) {
		return function(xhr, error){
			$('#parMasterStatusDiv').removeClass("alert alert-success");
			$('#parMasterStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#parMasterStatusMessage').html('Unable to delete '+ externalStaff);		
				}
			else{
				
				$('#parMasterStatusMessage').html(reponseBody['message']);
			}	
			$('#parMasterStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var parMasterUpdateFailure = function(externalStaff) {
		return function(xhr, error){
			$('#parMasterModalStatusDiv').removeClass("alert alert-success");
			$('#parMasterModalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#parMasterModalStatusMessage').html('Unable to update '+ externalStaff);	
				
			}
			else{
				$('#parMasterModalStatusMessage').html(reponseBody['message']);
			}	
			$('#parMasterModalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var parMasterAddFailure = function(externalStaff) {
		return function(xhr, error){
			$('#parMasterModalStatusDiv').removeClass("alert alert-success");
			$('#parMasterModalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#parMasterModalStatusMessage').html('Unable to create ' + externalStaff);				
			}
			else{
				$('#parMasterModalStatusMessage').html(reponseBody['message']);
			}	
			$('#parMasterModalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};
	
	var parMasterDeleteSuccess = function(deleteData,action,divElement) {
		return function(response) {
			table.row('#'+deleteData['parNumber']).remove().draw();
			$('#parMasterStatusDiv').removeClass("alert alert-danger");
			$('#parMasterStatusDiv').addClass("alert alert-success");
			$('#parMasterStatusMessage').html(deleteData['externalStaff'] + " has been successfully deleted!!");
			$('#parMasterStatusDiv').show();
		};
	};
	
	var parMasterUpdateSuccess = function(newData,action,divElement) {
		return function(response) {
			//var rowIndex = $("#rowIndex").val();
			table.row('#'+newData['parNumber']).data(newData).draw();
			$('#parMasterModalStatusDiv').removeClass("alert alert-danger");
			$('#parMasterModalStatusDiv').addClass("alert alert-success");
			$('#parMasterModalStatusMessage').html("ParNumber has been successfully updated!!");
			$('#parMasterModalStatusDiv').show();
		};
	};
	
	var parMasterAddSuccess = function() {
		return function(response) {
		//	table.row.add(response).draw( false );
			$('#parMasterModalStatusDiv').removeClass("alert alert-danger");
			$('#parMasterModalStatusDiv').addClass("alert alert-success");
			$('#parMasterModalStatusMessage').html("New ParMaster has been created successfully!!");
			$('#parMasterModalStatusDiv').show();
			
			if(!$.fn.dataTable.isDataTable("#tblParmasters")){
				populateParMasterInfo(response);
			}else{
				table.row.add(response).draw(false);
			}
			
		};
	};
	
	$('#parMasterModal').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget); // Button that triggered the modal
	  var parNumber = button.data('parnumber');
	  var externalStaff =  button.data('externalstaff');
	  var parReceivedDate =  button.data('parreceiveddate');
	  var parStatus = button.data('parstatus');
	  var area =  button.data('area');
	  var parRole = button.data('parrole');
	  var skill = button.data('skill');
	  var parDescriptionText = button.data('pardescriptiontext');
	  
	  
	  $('#parMasterModalStatusDiv').hide();
	//  $('#externalStaff').val(externalStaff);
	//  $('#parReceivedDate').val(parreceiveddate);
	  

	  
	  $("#parMasterModal").off('click', '#saveParMasterButton');
	  
	  $("#parMasterModal").on('click', '#saveParMasterButton', function () {
		  $('#parMasterModalStatusDiv').hide();
		  $('#parMasterForm').validate({
			    rules : {
			    	externalStaff : {  required: true },
			    	parReceivedDate : {  required: true }
			    },
			    messages: {
			    	externalStaff:{
			        	required:"externalstaff name can not be empty**"
			        },
			        parReceivedDate:{
			        	required:"Par ReceivedDate can not be empty**"
			    }
			    
			    },
			    
			    errorElement: PARValidationUtil.utils.validationProperties.errorElement,
			    errorPlacement: PARValidationUtil.utils.validationProperties.errorPlacement,
			    success: PARValidationUtil.utils.validationProperties.success,
			    highlight: PARValidationUtil.utils.validationProperties.highlight,
			    unhighlight: PARValidationUtil.utils.validationProperties.unhighlight
		  });
		  
		  if(!$('#parMasterForm').valid())
			  return;
		  if (typeof parNumber == undefined || parNumber == null) {
			  var requestBody={};
			  requestBody["externalStaff"]=$('#externalStaff').val();
			  requestBody["parReceivedDate"]=$('#parReceivedDate').val();
			  AjaxUtil.utils.sendPostRequest('/parmanagement/par/parmasters/',parMasterAddSuccess(), parMasterAddFailure(externalStaff),requestBody);			   
		  }
		  else{
			  var requestBody={};
			  requestBody["parNumber"]=parNumber.toString();
			  requestBody["externalStaff"]=$('#externalStaff').val();
			  requestBody["parReceivedDate"]=$('#parReceivedDate').val();
			  
			  var newData={};
			  newData['parNumber'] = parNumber.toString();
			//  newData['preScreenerActive'] = preScreenerActive;
			  newData['externalStaff'] = $('#externalStaff').val();
			  newData['parReceivedDate'] = $('#parReceivedDate').val();
			  AjaxUtil.utils.sendPutRequest('/parmanagement/par/parmasters/',parMasterUpdateSuccess(newData,'updated','statusModalMessage'), parMasterUpdateFailure(externalStaff),requestBody);			  
		  }
		});
	});
});