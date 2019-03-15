$("#external-staffing-info-tab").on("click", function(){
	
	$('#extStaffAreaSelect').find('option').not(':first').remove();
	AjaxUtil.utils.sendGetRequest('/parmanagement/par/externalstaff', populateExternalStaffInfo, extStaffLoadFailure);
	AjaxUtil.utils.sendGetRequest('/parmanagement/par/Areas', populateAreaInfo, areaLoadFailure);
	
	$('#extStaffStatusDiv').hide();
	var table=null;
	
    $("#addNewExtStaffBtn").on("click", function(event){
    	$('#extStaffModal').modal('show'); 
    });
    $('#extStaffModal').on('hidden.bs.modal', function() {
        var extStaffForm = $('#extStaffForm');
        extStaffForm.validate().resetForm();
        extStaffForm.find('.error').removeClass('error');
    });
	function populateExternalStaffInfo(response){
		if(response.length<=0){
			return;
		}
		table = $('#tblExtStaffs').DataTable(
				{
					autoWidth: false,
					retrieve: true,	
					columns: [
     						{ data: 'extStaffId' },
     						{ data: 'extStaffName' },
     						{ data: 'area.areaName'},
     						{ data: 'extStaffActive' },
     					{
							data:null,
							render: function (data, type, row){
                                return '<button class="btnExtStaffDelete btn btn-sm deleteRow"><img src="static/img/delete.png" alt="Delete"></button>   <button class="btnViewExtStaff btn btn-sm editRow" data-toggle="modal" data-target="#extStaffModal" data-extstaffid="' + data.extStaffId + '" data-extstaffname="' + data.extStaffName + '" data-extstaffarea="' + data.area.areaId + '" data-extstaffactive="' + data.extStaffActive + '"><img src="static/img/edit.png" alt="Edit"></button>';
								//return '<button type="button" class="btnDelete btn btn-primary">Delete</button>';
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
			        rowId: 'extStaffId',
			        order: [[0,'desc']]
                }		
		);
		table.clear().rows.add(response).draw();
		$("#tblExtStaffs tbody").on('click', '.btnExtStaffDelete', function () {
			var extStaff = table.row($(this).closest('tr')).data();
			$('#extStaffDeleteConfirmModalBody').html(" Are you sure you, want to delete<strong> "+extStaff.extStaffName+"</strong>?");
			$("#extStaffDeleteConfirm").off('click', '#ext-staff-delete-btn');
			$('#extStaffDeleteConfirm').modal({ backdrop: 'static', keyboard: false })
	        .on('click', '#ext-staff-delete-btn', function(){
				var deleteData={};
				deleteData['extStaffId']=extStaff.extStaffId;
				deleteData['extStaffName']=extStaff.extStaffName;
				AjaxUtil.utils.sendDeleteRequest('/parmanagement/par/externalstaff/'+extStaff.extStaffId, extStaffDeleteSuccess(deleteData,'deleted','statusMessage'), extStaffDeleteFailure(extStaff.extStaffName));
				$('#extStaffDeleteConfirm').modal('hide');
	        });
		    
		});
		
		$("#tblExtStaffs tbody").on('click', '.btnViewExtStaff', function () {
			var extStaff = table.row($(this).closest('tr')).data();
			var rowIndex = $(this).closest('tr').index();
		     $("#rowIndex").val(rowIndex);
		});
		$('#tblExtStaffs').show();
	}
	
	function extStaffLoadFailure(xhr, error){
		if(xhr.status!=404){
			var reponseBody = JSON.parse(xhr.responseText);
			$('#extStaffStatusDiv').removeClass("alert alert-success");
			$('#extStaffStatusDiv').addClass("alert alert-warning");
			$('#extStaffStatusMessage').html(reponseBody['message']);
			$('#extStaffStatusDiv').show();
		}else{
			$('#tblExtStaffs').hide();
			$('#extStaffStatusDiv').hide();
		}
	}
	function areaLoadFailure(xhr, error){
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
	
	var extStaffDeleteFailure = function(extStaffName) {
		return function(xhr, error){
			$('#extStaffStatusDiv').removeClass("alert alert-success");
			$('#extStaffStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#extStaffStatusMessage').html('Unable to delete '+ extStaffName);				
			}
			else{
				
				$('#extStaffStatusMessage').html(reponseBody['message']);
			}	
			$('#extStaffStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};
	
	function populateAreaInfo (response){
		 $.each(response, function(i, area) {
	            $('#extStaffAreaSelect').append($('<option></option>').text(area.areaName).attr('value', area.areaId));
	        });
	};


	var extStaffUpdateFailure = function(extStaffName) {
		return function(xhr, error){
			$('#extStaffModalStatusDiv').removeClass("alert alert-success");
			$('#extStaffModalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#extStaffModalStatusMessage').html('Unable to update '+ extStaffName);				
			}
			else{
				$('#extStaffModalStatusMessage').html(reponseBody['message']);
			}	
			$('#extStaffModalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var extStaffAddFailure = function(extStaffName) {
		return function(xhr, error){
			$('#extStaffModalStatusDiv').removeClass("alert alert-success");
			$('#extStaffModalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#extStaffModalStatusMessage').html('Unable to create ' + extStaffName);				
			}
			else{
				$('#extStaffModalStatusMessage').html(reponseBody['message']);
			}	
			$('#extStaffModalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};
	
	var extStaffDeleteSuccess = function(deleteData,action,divElement) {
		return function(response) {
			table.row('#'+deleteData['extStaffId']).remove().draw();
			$('#extStaffStatusDiv').removeClass("alert alert-danger");
			$('#extStaffStatusDiv').addClass("alert alert-success");
			$('#extStaffStatusMessage').html("<strong> " +deleteData['extStaffName'] + "  </strong> has been deleted successfully !!");
			$('#extStaffStatusDiv').show();
		};	
	};
	
	var extStaffUpdateSuccess = function(newData,action,divElement) {
		return function(response) {
			//var rowIndex = $("#rowIndex").val();
			$('#extStaffModal').modal('hide');
			table.row('#'+newData['extStaffId']).data(newData).draw();
			$('#extStaffStatusDiv').removeClass("alert alert-danger");
			$('#extStaffStatusDiv').addClass("alert alert-success");
			$('#extStaffStatusMessage').html("Exteral Staff<strong> "+ newData['extStaffName']+" </strong>has been updated successfully !!");
			$('#extStaffStatusDiv').show();
		};
	};
	
	var extStaffAddSuccess = function(extStaffName) {
		return function(response) {
		//	table.row.add(response).draw( false );
			$('#extStaffModal').modal('hide');
			$('#extStaffStatusDiv').removeClass("alert alert-danger");
			$('#extStaffStatusDiv').addClass("alert alert-success");
			$('#extStaffStatusMessage').html("New External Staff <strong>"+extStaffName+"</strong> has been created successfully!!");
			$('#extStaffStatusDiv').show();
			
			if((!$.fn.dataTable.isDataTable("#tblExtStaffs"))||(table==null)||(typeof table == undefined)){
				populateExternalStaffInfo([response]);
			}else{
				table.row.add(response).draw(false);
				$('#tblExtStaffs').show();
			}
		};
	};
	
	$('#extStaffModal').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget); // Button that triggered the modal
	  var extStaffId = button.data('extstaffid');
	  var extStaffName =  button.data('extstaffname');
	  var extStaffAreaId =  button.data('extstaffarea');
	  var extStaffActive = button.data('extstaffactive');
	  $('#extStaffModalStatusDiv').hide();
	  $('#extStaffName').val(extStaffName);
	  $('#extStaffAreaSelect').val(extStaffAreaId);
	  if ((typeof extStaffId == undefined || extStaffId == null)) {
		  $('#extStaffId').prop('disabled',false);
		  $('#extStaffModalTitle').text("Add External Staff");
	  }else{
		  $('#extStaffId').prop('disabled',true);
		  $('#extStaffModalTitle').text("Update External Staff");
	  }
	  
	  jQuery.validator.addMethod("lettersonlys", function(value, element) {
		  return this.optional(element) || /^[a-zA-Z\s]+$/.test(value);
		}, "Name field allows alphabets and a space only");
	  
	  $("#extStaffModal").off('click', '#saveExtStaffButton');
	  
	  $("#extStaffModal").on('click', '#saveExtStaffButton', function () {
		  $('#extStaffModalStatusDiv').hide();
		  $('#extStaffForm').validate({
			    rules : {
			    	extStaffName : {  lettersonlys:true,required: true, rangelength:[3,50] },
			    	extStaffAreaSelect : {  required: true }
			    },
			    messages: {
			    	extStaffName:{
			        	required:"External Staff name can not be empty",
			        	rangelength: "Minimum 3 and Maximum 50 Characters"
			        },
			        extStaffAreaSelect:{
			    		required:"Area can not be empty"
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
			  requestBody["area"]={};
			  requestBody['area']['areaId']=$('#extStaffAreaSelect').val();
			  AjaxUtil.utils.sendPostRequest('/parmanagement/par/externalstaff/',extStaffAddSuccess(requestBody["extStaffName"]), extStaffAddFailure(extStaffName),requestBody);			   
		  }
		  else{
			  var requestBody={};
			  requestBody["extStaffId"]=extStaffId.toString();
			  requestBody["extStaffName"]=$('#extStaffName').val();
			  requestBody["area"]={};
			  requestBody['area']['areaId']=$('#extStaffAreaSelect').val();
			 // $('#extStaffName').prop('disabled',true);
			  var newData={};
			  newData['extStaffId'] = extStaffId.toString();
			  newData['extStaffName'] = $('#extStaffName').val();
			  newData['area']={};
			  newData['area']['areaId']=$('#extStaffAreaSelect').val();
			  newData['area']['areaName']=$('#extStaffAreaSelect :selected').text();
			  newData['extStaffActive'] = extStaffActive;
			  AjaxUtil.utils.sendPutRequest('/parmanagement/par/externalstaff/',extStaffUpdateSuccess(newData,'updated','statusModalMessage'), extStaffUpdateFailure(extStaffName),requestBody);			  
		  }
		});
	});
});