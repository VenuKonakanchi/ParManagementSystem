$(document).ready(function(){
	
	AjaxUtil.utils.sendGetRequest('/parmanagement/par/externalstaff', populateExternalStaffInfo, skillLoadFailure);
	$('#statusDiv').hide();
	var table=null;
	
    $("#addNewExtStaffBtn").on("click", function(){
    	$('#extStaffModal').modal('show'); 
    });
    
	function populateExternalStaffInfo(response){
		table = $('#tblExtStaffs').DataTable(
				{
					autoWidth: false,
							
					columns: [
     						{ data: 'extStaffId' },
     						{ data: 'extStaffName' },
     						{ data: 'extStaffArea'}
     						{ data: 'extStaffActive' },
     						{
							data:null,
							render: function (data, type, row){
                                return '<button class="btnDelete btn btn-sm deleteRow"><img src="static/img/delete.png" alt="Delete"></button>   <button class="btnViewExtStaff btn btn-sm editRow" data-toggle="modal" data-target="#extStaffModal" data-extStaffId="' + data.extStaffId + '" data-extStaffName="' + data.extStaffName + '" data-extStaffArea="' + data.extStaffArea+ '" data-skillactive="' + data.skillActive + '"><img src="static/img/edit.png" alt="Edit"></button>';
								//return '<button type="button" class="btnDelete btn btn-primary">Delete</button>';
							}
						},
						/*{
							data: null,
							  render: function ( data, type, row ) {
                                  return '<button class="btnViewExtStaff btn btn-sm editRow" data-toggle="modal" data-target="#skillModal" data-skillid="' + data.skillId + '" data-skillname="' + data.skillName + '" data-skillactive="' + data.skillActive + '"><img src="static/img/edit.png" alt="Edit"></button>';
								  //return '<button type="button" class="btnViewExtStaff btn btn-primary" data-toggle="modal" data-target="#skillModal" data-skillid="' + data.skillId + '" data-skillname="' + data.skillName + '" data-skillactive="' + data.skillActive + '">Update Skill</button>';
							  }
						}*/
					],
			        columnDefs: [
			            {
			                "targets": [ 0 ],
			                "visible": false,
			                "searchable": false
			            },
			            {
			                "targets": [ 2 ],
			                "visible": false,
			                "searchable": false
			            }
			        ],
			        rowId: 'extStaffId',
			        order: [[0,'desc']]
                }		
		);
		table.clear().rows.add(response).draw();
		$("#tblExtStaffs tbody").on('click', '.btnDelete', function () {
			var extStaff = table.row($(this).closest('tr')).data();
			
		    $('#confirm').modal({ backdrop: 'static', keyboard: false })
	        .on('click', '#delete-btn', function(){
				var deleteData={};
				deleteData['extStaffId']=extStaff.extStaffId;
				deleteData['extStaffName']=extStaff.extStaffName;
				AjaxUtil.utils.sendDeleteRequest('/parmanagement/par/externalstaffs/'+extStaff.extStaffId, extStaffDeleteSuccess(deleteData,'deleted','statusMessage'), extStaffDeleteFailure(extStaff.extStaffName));
				$('#confirm').modal('hide');
	        });
		    
		});
		
		$("#tblExtStaffs tbody").on('click', '.btnViewExtStaff', function () {
			var extStaff = table.row($(this).closest('tr')).data();
			var rowIndex = $(this).closest('tr').index();
		     $("#rowIndex").val(rowIndex);
		});
	}
	
	function skillLoadFailure(xhr, error){
		AjaxUtil.utils.displayError("Unable to load External Staff");
		AjaxUtil.utils.ajaxFailureCallback(xhr, error);
	}
	
    $("[data-hide]").on("click", function(){
        $(this).closest("." + $(this).attr("data-hide")).hide();
    });
	
	var extStaffDeleteFailure = function(extStaffName) {
		return function(xhr, error){
			$('#statusDiv').removeClass("alert alert-success");
			$('#statusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#statusMessage').html('Unable to delete '+ extStaffName);				
			}
			else{
				
				$('#statusMessage').html(reponseBody['message']);
			}	
			$('#statusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var extStaffUpdateFailure = function(extStaffName) {
		return function(xhr, error){
			$('#modalStatusDiv').removeClass("alert alert-success");
			$('#modalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#modalStatusMessage').html('Unable to update '+ extStaffName);				
			}
			else{
				$('#modalStatusMessage').html(reponseBody['message']);
			}	
			$('#modalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var extStaffAddFailure = function(extStaffName) {
		return function(xhr, error){
			$('#modalStatusDiv').removeClass("alert alert-success");
			$('#modalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#modalStatusMessage').html('Unable to create ' + extStaffName);				
			}
			else{
				$('#modalStatusMessage').html(reponseBody['message']);
			}	
			$('#modalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};
	
	var extStaffDeleteSuccess = function(deleteData,action,divElement) {
		return function(response) {
			table.row('#'+deleteData['extStaffId']).remove().draw();
			$('#statusDiv').removeClass("alert alert-danger");
			$('#statusDiv').addClass("alert alert-success");
			$('#statusMessage').html(deleteData['extStaffName'] + " has been successfully deleted!!");
			$('#statusDiv').show();
		};	
	};
	
	var extStaffUpdateSuccess = function(newData,action,divElement) {
		return function(response) {
			//var rowIndex = $("#rowIndex").val();
			table.row('#'+newData['skillId']).data(newData).draw();
			$('#modalStatusDiv').removeClass("alert alert-danger");
			$('#modalStatusDiv').addClass("alert alert-success");
			$('#modalStatusMessage').html("Exteral Staff has been successfully updated!!");
			$('#modalStatusDiv').show();
		};
	};
	
	var extStaffAddSuccess = function() {
		return function(response) {
			table.row.add(response).draw( false );
			$('#modalStatusDiv').removeClass("alert alert-danger");
			$('#modalStatusDiv').addClass("alert alert-success");
			$('#modalStatusMessage').html("New External Staff has been created successfully!!");
			$('#modalStatusDiv').show();
		};
	};
	
	$('#extStaffModal').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget); // Button that triggered the modal
	  var extStaffId = button.data('extStaffId');
	  var extStaffName =  button.data('extStaffName');
	  var extStaffArea =  button.data('extStaffArea');
	  var extStaffActive = button.data('extStaffActive');
	  $('#modalStatusDiv').hide();
	  $('#extStaffName').val(extStaffName);
	  
	  $("#extStaffModal").off('click', '#saveExtStaffButton');
	  
	  $("#extStaffModal").on('click', '#saveExtStaffButton', function () {
		  $('#modalStatusDiv').hide();
		  $('#extStaffForm').validate({
			    rules : {
			    	extStaffName : {  required: true }
			    },
			    messages: {
			    	extStaffName:{
			        	required:"External Staff name can not be empty"
			        }
			    },
			    errorElement: PARValidationUtil.utils.validationProperties.errorElement,
			    errorPlacement: PARValidationUtil.utils.validationProperties.errorPlacement,
			    success: PARValidationUtil.utils.validationProperties.success,
			    highlight: PARValidationUtil.utils.validationProperties.highlight,
			    unhighlight: PARValidationUtil.utils.validationProperties.unhighlight
		  });
		  
		  if(!$('#extStaffForm').valid())
			  return;
		  if (typeof extStaffId == undefined || extStaffId == null) {
			  var requestBody={};
			  requestBody["extStaffName"]=$('#extStaffName').val();	  
			  AjaxUtil.utils.sendPostRequest('/parmanagement/par/externalstaffs/',extStaffAddSuccess(), extStaffAddFailure(extStaffName),requestBody);			   
		  }
		  else{
			  var requestBody={};
			  requestBody["extStaffId"]=extStaffId.toString();
			  requestBody["extStaffName"]=$('#extStaffName').val();
			  
			  var newData={};
			  newData['extStaffId'] = extStaffId.toString();
			  newData['extStaffActive'] = extStaffActive;
			  newData['extStaffName'] = $('#extStaffName').val();
			  AjaxUtil.utils.sendPutRequest('/parmanagement/par/externalstaffs/',extStaffUpdateSuccess(newData,'updated','statusModalMessage'), extStaffUpdateFailure(extStaffName),requestBody);			  
		  }
		});
	});
});