$("#pre-screeners-tab").on("click", function(){
	
	AjaxUtil.utils.sendGetRequest('/parmanagement/par/preScreeners', populatePreScreenerInfo, preScreenerLoadFailure);
	$('#preScreenerStatusDiv').hide();
	var table=null;
	
    $("#addNewPreScreenerBtn").on("click", function(){
    	$('#preScreenerModal').modal('show'); 
    });
    
    $('#preScreenerModal').on('hidden.bs.modal', function() {
        var preScreenerForm = $('#preScreenerForm');
        preScreenerForm.validate().resetForm();
        preScreenerForm.find('.error').removeClass('error');
    });
    
	function populatePreScreenerInfo(response){
		if(response.length<=0){
			return;
		}
		table = $('#tblPreScreeners').DataTable(
				{
					autoWidth: false,
					retrieve: true,					
					columns: [
     					{ data: 'preScreenerId' },
						{ data: 'preScreenerName' },
						{ data: 'preScreenerPhoneNumber' },
						{ data: 'preScreenerActive' },
						{
							data:null,
							render: function (data, type, row){
                                return '<button class="btnPrescreenerDelete btn btn-sm deleteRow"><img src="static/img/delete.png" alt="Delete"></button>  <button class="btnViewPreScreener btn btn-sm editRow" data-toggle="modal" data-target="#preScreenerModal" data-prescreenerid="' + data.preScreenerId + '" data-prescreenername=" '+ data.preScreenerName + '" data-prescreenerphonenumber="' + data.preScreenerPhoneNumber + '" data-prescreeneractive="' + data.preScreenerActive + '"><img src="static/img/edit.png" alt="Edit"></button>';
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
			        rowId: 'preScreenerId',
			        order: [[0,'desc']]
                }		
		);
		table.clear().rows.add(response).draw();
		$("#tblPreScreeners tbody").on('click', '.btnPrescreenerDelete', function () {
			var preScreener = table.row($(this).closest('tr')).data();
			 $('#preScreenerconfirmModalBody').html("Are you sure you want to delete <strong> "+preScreener.preScreenerName +"</strong> ?")
			 $("#preScreenerconfirm").off('click', '#preScreenerDelete-btn');
		    $('#preScreenerconfirm').modal({ backdrop: 'static', keyboard: false })
	        .on('click', '#preScreenerDelete-btn', function(){
				var deleteData={};
				deleteData['preScreenerId']=preScreener.preScreenerId;
				deleteData['preScreenerName']=preScreener.preScreenerName;
				AjaxUtil.utils.sendDeleteRequest('/parmanagement/par/preScreeners/'+preScreener.preScreenerId, preScreenerDeleteSuccess(deleteData,'deleted','statusMessage'), preScreenerDeleteFailure(preScreener.preScreenerName), preScreenerDeleteFailure(preScreener.preScreenerPhoneNumber));
				$('#preScreenerconfirm').modal('hide');
	        });
		    
		});
		
		$("#tblPreScreeners tbody").on('click', '.btnViewPreScreener', function () {
			var preScreener = table.row($(this).closest('tr')).data();
			var rowIndex = $(this).closest('tr').index();
		     $("#rowIndex").val(rowIndex);
		});
		$('#tblPreScreeners').show();
	}
	
	function preScreenerLoadFailure(xhr, error){
		if(xhr.status!=404){
			var reponseBody = JSON.parse(xhr.responseText);
			$('#preScreenerStatusDiv').removeClass("alert alert-success");
			$('#preScreenerStatusDiv').addClass("alert alert-warning");
			$('#preScreenerStatusMessage').html(reponseBody['message']);
			$('#statusSkillDiv').show();
		}else{
			$('#tblPreScreeners').hide();
			$('#preScreenerStatusDiv').hide();
		}
	}
	
	$("[data-hide]").on("click", function(){
        $(this).closest("." + $(this).attr("data-hide")).hide();
    });
	
	var preScreenerDeleteFailure = function(preScreenerName) {
		return function(xhr, error){
			$('#preScreenerStatusDiv').removeClass("alert alert-success");
			$('#preScreenerStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#preScreenerStatusMessage').html('Unable to delete '+ preScreenerName);		
				}
			else{
				
				$('#preScreenerStatusMessage').html(reponseBody['message']);
			}	
			$('#preScreenerStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var preScreenerUpdateFailure = function(preScreenerName) {
		return function(xhr, error){
			$('#preScreenerModalStatusDiv').removeClass("alert alert-success");
			$('#preScreenerModalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#preScreenerModalStatusMessage').html('Unable to update '+ preScreenerName);	
				
			}
			else{
				$('#preScreenerModalStatusMessage').html(reponseBody['message']);
			}	
			$('#preScreenerModalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var preScreenerAddFailure = function(preScreenerName) {
		return function(xhr, error){
			$('#preScreenerModalStatusDiv').removeClass("alert alert-success");
			$('#preScreenerModalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#preScreenerModalStatusMessage').html('Unable to create ' + preScreenerName);				
			}
			else{
				$('#preScreenerModalStatusMessage').html(reponseBody['message']);
			}	
			$('#preScreenerModalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};
	
	var preScreenerDeleteSuccess = function(deleteData,action,divElement) {
		return function(response) {
			table.row('#'+deleteData['preScreenerId']).remove().draw();
			$('#preScreenerStatusDiv').removeClass("alert alert-danger");
			$('#preScreenerStatusDiv').addClass("alert alert-success");
			$('#preScreenerStatusMessage').html("<strong> " +deleteData['preScreenerName'] + " </strong> has been deleted successfully !!");
			$('#preScreenerStatusDiv').show();
		};
	};
	
	var preScreenerUpdateSuccess = function(newData,action,divElement) {
		return function(response) {
			//var rowIndex = $("#rowIndex").val();
			$('#preScreenerModal').modal('hide');
			table.row('#'+newData['preScreenerId']).data(newData).draw();
			$('#preScreenerStatusDiv').removeClass("alert alert-danger");
			$('#preScreenerStatusDiv').addClass("alert alert-success");
			$('#preScreenerStatusMessage').html("PreScreener <strong>"+newData['preScreenerName'] +"</strong> has been updated successfully !!");
			$('#preScreenerStatusDiv').show();
		};
	};
	
	var preScreenerAddSuccess = function(preScreenerName) {
		return function(response) {

			$('#preScreenerModal').modal('hide');
			$('#preScreenerStatusDiv').removeClass("alert alert-danger");
			$('#preScreenerStatusDiv').addClass("alert alert-success");
			$('#preScreenerStatusMessage').html("New PreScreener<strong> "+preScreenerName+" </strong> has been created successfully!!");
			$('#preScreenerStatusDiv').show();
			if((!$.fn.dataTable.isDataTable("#tblPreScreeners"))||(table==null)||(typeof table == undefined)){
				populatePreScreenerInfo([response]);
			}else{
				table.row.add(response).draw(false);
				$('#tblPreScreeners').show();
			}
		};
	};
	
	$('#preScreenerModal').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget); // Button that triggered the modal
	  var preScreenerId = button.data('prescreenerid');
	  var preScreenerName =  button.data('prescreenername');
	  var preScreenerPhoneNumber =  button.data('prescreenerphonenumber');
	  var preScreenerActive = button.data('prescreeneractive');
	  $('#preScreenerModalStatusDiv').hide();
	  $('#preScreenerName').val(preScreenerName);
	  $('#preScreenerPhoneNumber').val(preScreenerPhoneNumber);
	  if (typeof preScreenerId == undefined || preScreenerId == null) {
		  $('#preScreenerModalTitle').text("Add PreScreener");
	 }else{
		  $('#preScreenerModalTitle').text("Update PreScreener"); 
	  }
	  
	  jQuery.validator.addMethod("lettersonlys", function(value, element) {
		  return this.optional(element) || /^[a-zA-Z\s]+$/.test(value);
		}, "Name field allows alphabets and a space only");
	  
	  $("#preScreenerModal").off('click', '#savePreScreenerButton');
	  
	  $("#preScreenerModal").on('click', '#savePreScreenerButton', function () {
		  $('#preScreenerModalStatusDiv').hide();
		  $('#preScreenerForm').validate({
			    rules : {
			        preScreenerName : {  lettersonlys:true,required: true, rangelength:[3,50] },
			        preScreenerPhoneNumber : {  required: true, phoneUS: true }
			    },
			    messages: {
			        preScreenerName:{
			        	required:"PreScreener name can not be empty",
			        	rangelength: "Minimum 3 and Maximum 50 Characters"
			        },
			        preScreenerPhoneNumber:{
			        	required:"PreScreener phone number can not be empty"
			    }
			    
			    },
			    
			    errorElement: PARValidationUtil.utils.validationProperties.errorElement,
			    errorPlacement: PARValidationUtil.utils.validationProperties.errorPlacement,
			    success: PARValidationUtil.utils.validationProperties.success,
			    highlight: PARValidationUtil.utils.validationProperties.highlight,
			    unhighlight: PARValidationUtil.utils.validationProperties.unhighlight
		  });
		  
		  if(!$('#preScreenerForm').valid())
			  return;
		  if (typeof preScreenerId == undefined || preScreenerId == null) {
			  var requestBody={};
			  requestBody["preScreenerName"]=$('#preScreenerName').val();
			  requestBody["preScreenerPhoneNumber"]=$('#preScreenerPhoneNumber').val();
			  AjaxUtil.utils.sendPostRequest('/parmanagement/par/preScreeners/',preScreenerAddSuccess(requestBody["preScreenerName"]), preScreenerAddFailure(preScreenerName),requestBody);			   
		  }
		  else{
			  var requestBody={};
			  requestBody["preScreenerId"]=preScreenerId.toString();
			  requestBody["preScreenerName"]=$('#preScreenerName').val();
			  requestBody["preScreenerPhoneNumber"]=$('#preScreenerPhoneNumber').val();
			  requestBody['preScreenerActive'] = preScreenerActive;
			  
			  var newData={};
			  newData['preScreenerId'] = preScreenerId.toString();
			  newData['preScreenerActive'] = preScreenerActive;
			  newData['preScreenerName'] = $('#preScreenerName').val();
			  newData['preScreenerPhoneNumber'] = $('#preScreenerPhoneNumber').val();
			  AjaxUtil.utils.sendPutRequest('/parmanagement/par/preScreeners/',preScreenerUpdateSuccess(newData,'updated','statusModalMessage'), preScreenerUpdateFailure(preScreenerName),requestBody);			  
		  }
		});
	});
});