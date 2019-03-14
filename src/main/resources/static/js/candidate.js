$("#candidate-master-tab").on("click", function(){
	
	$('[data-toggle=datepicker]').each(function() {
		  var target = $(this).data('target-name');
		  var t = $('input[name=' + target + ']');
		  t.datepicker({
			     dateFormat: 'yy-mm-dd',
			     changeMonth: true,
			     changeYear: true
		  }).focus(function () {
			    $(".ui-datepicker-next").hide();
			    $(".ui-datepicker-prev").hide();
			});
		  
		  $(this).on("click", function() {
		    t.datepicker("show");
		  });
		});
	$('#saveCandidateButton').prop('disabled', false);
	AjaxUtil.utils.sendGetRequest('/parmanagement/par/candidates', populateCandidateInfo, candidateLoadFailure);
	AjaxUtil.utils.sendGetRequest('/parmanagement/par/recruiters', populateRecruiterInfo, recruiterLoadFailure);

	
	$('#candidateStatusDiv').hide();
	var table=null;
	
    $("#addNewCandidateBtn").on("click", function(event){
     	$('#candidateModal').modal('show'); 
    });
    $('#candidateModal').on('hidden.bs.modal', function() {
        var candidateForm = $('#candidateForm');
        candidateForm.validate().resetForm();
        candidateForm.find('.error').removeClass('error');
    });
	function populateCandidateInfo(response){
		if($.fn.dataTable.isDataTable("#tblCandidates")){
			return;
		}
		table = $('#tblCandidates').DataTable(
				{
					autoWidth: false,
										
					columns: [
     						{ data: 'candidateId' },
     						{ data: 'candidateName' },
     						{ data: 'candidatePhoneNumber' },
     						{ data: 'candidateEmail' },
     						{ data: 'candidateActive' },
     						{ data: 'recruiter.recruiterName' },
     						{ data: 'candidateReceivedDate' },
     						
						{
							data:null,
							render: function (data, type, row){
                                return '<button class="btnCandidateDelete btn btn-sm deleteCandidateRow"><img src="static/img/delete.png" alt="Delete"></button>  <button class="btnViewCandidate btn btn-sm editCandidateRow" data-toggle="modal" data-target="#candidateModal" data-candidateid="' + data.candidateId + '"data-candidatename="' + data.candidateName + '"data-candidatephonenumber="' + data.candidatePhoneNumber + '"data-candidateemail="' + data.candidateEmail + '"data-candidateactive="' + data.candidateActive + '"data-recruiterid="' + data.recruiter.recruiterId + '"data-candidatereceiveddate="' + data.candidateReceivedDate+'"><img src="static/img/edit.png" alt="Edit"></button>';
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
			                "targets": [ 4 ],
			                "visible": false,
			                "searchable": false
			            },

			        ],
			        rowId: 'candidateId',
			        order: [[0,'desc']]
                }		
		);
		
		table.clear().rows.add(response).draw();
		$("#tblCandidates tbody").on('click', '.btnCandidateDelete', function () {
			var candidate = table.row($(this).closest('tr')).data();
			
			$('#candidateDeleteConfirmModalBody').html("Are you sure you, want to delete the Candidate<strong> "+candidate.candidateName +"</strong> ?");
			$("#candidateDeleteConfirmModal").off('click', '#candidate-delete-btn');
			
		    $('#candidateDeleteConfirmModal').modal({ backdrop: 'static', keyboard: false })
	        .on('click', '#candidate-delete-btn', function(){
				var deleteData={};
				deleteData['candidateId']=candidate.candidateId;
				deleteData['candidateName']=candidate.candidateName;
				deleteData['candidatePhoneNumber']=candidate.candidatePhoneNumber;
				deleteData['candidateEmail']=candidate.candidateEmail;
				deleteData['candidateActive']=candidate.candidateActive;
				deleteData['candidateReceivedDate']=candidate.candidateReceivedDate;
				AjaxUtil.utils.sendDeleteRequest('/parmanagement/par/candidates/'+candidate.candidateId, candidateDeleteSuccess(deleteData,'deleted','candidateStatusMessage'), candidateDeleteFailure(candidate.candidateName));
				$('#candidateDeleteConfirmModal').modal('hide');
	        });
		    
		});
		
		$("#tblCandidates tbody").on('click', '.btnViewCandidate', function () {
			var candidate = table.row($(this).closest('tr')).data();
			var rowIndex = $(this).closest('tr').index();
		     $("#rowIndex").val(rowIndex);
		});
	}
	
	function candidateLoadFailure(xhr, error){
		if(xhr.status!=404){
			var reponseBody = JSON.parse(xhr.responseText);
			$('#candidateStatusDiv').removeClass("alert alert-success");
			$('#candidateStatusDiv').addClass("alert alert-warning");
			$('#candidateStatusMessage').html(reponseBody['message']);
			$('#candidateStatusDiv').show();
		}else{
			$('#candidateStatusDiv').hide();
		}
	}
	function recruiterLoadFailure(xhr, error){
		//$('#candidateRecruiterSelect').append($('<option></option>').text('Select Recruiter').attr('value', ''));
		if(xhr.status!=404){
			var reponseBody = JSON.parse(xhr.responseText);
			$('#candidateStatusDiv').removeClass("alert alert-success");
			$('#candidateStatusDiv').addClass("alert alert-warning");
			$('#candidateStatusMessage').html(reponseBody['message']);
			$('#candidateStatusDiv').show();
		}else if(xhr.status==404){
			$('#candidateStatusDiv').removeClass("alert alert-success");
			$('#candidateStatusDiv').addClass("alert alert-warning");
			$('#candidateStatusMessage').html('No Recruiters found!! Please add a recrutier first and then add candidate.');
			$('#candidateStatusDiv').show();
		}else{
			$('#candidateStatusDiv').hide();
		}
	}
	
    $("[data-hide]").on("click", function(){
        $(this).closest("." + $(this).attr("data-hide")).hide();
    });
	
	var candidateDeleteFailure = function(candidateName) {
		return function(xhr, error){
			$('#candidateStatusDiv').removeClass("alert alert-success");
			$('#candidateStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#candidateStatusMessage').html('Unable to delete '+ candidateName);				
			}
			else{
				
				$('#candidateStatusMessage').html(reponseBody['message']);
			}	
			$('#candidateStatusDiv').show();
		};
	};
	
	function populateRecruiterInfo (response){
		 $.each(response, function(i, recruiter) {
	            $('#candidateRecruiterSelect').append($('<option></option>').text(recruiter.recruiterName).attr('value', recruiter.recruiterId));
	        });
	};

	var candidateUpdateFailure = function(candidateName) {
		return function(xhr, error){
			$('#candidateModalStatusDiv').removeClass("alert alert-success");
			$('#candidateModalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#candidateModalStatusMessage').html('Unable to update '+ candidateName);				
			}
			else{
				$('#candidateModalStatusMessage').html(reponseBody['message']);
			}	
			$('#candidateModalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var candidateAddFailure = function(candidateName) {
		return function(xhr, error){
			$('#candidateModalStatusDiv').removeClass("alert alert-success");
			$('#candidateModalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#candidateModalStatusMessage').html('Unable to create ' + candidateName);				
			}
			else{
				$('#candidateModalStatusMessage').html(reponseBody['message']);
			}	
			$('#candidateModalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};
	
	var candidateDeleteSuccess = function(deleteData,action,divElement) {
		return function(response) {
			table.row('#'+deleteData['candidateId']).remove().draw();
			$('#candidateStatusDiv').removeClass("alert alert-danger");
			$('#candidateStatusDiv').addClass("alert alert-success");
			$('#candidateStatusMessage').html("<strong> " +deleteData['candidateName'] + " </strong> has been deleted successfully!!");
			$('#candidateStatusDiv').show();
		};
	};
	
	var candidateUpdateSuccess = function(newData,action,divElement) {
		return function(response) {
			$('#candidateModal').modal('hide');
			table.row('#'+newData['candidateId']).data(response).draw();
			$('#candidateStatusDiv').removeClass("alert alert-danger");
			$('#candidateStatusDiv').addClass("alert alert-success");
			$('#candidateStatusMessage').html("Candidate<strong> "+newData['candidateName']+" </strong>has been updated successfully !!");
			$('#candidateStatusDiv').show();
		};
	};
	
	var candidateAddSuccess = function(candidateName) {
		return function(response) {
			$('#candidateModal').modal('hide');
			$('#candidateStatusDiv').removeClass("alert alert-danger");
			$('#candidateStatusDiv').addClass("alert alert-success");
			$('#candidateStatusMessage').html("New Candidate<strong> "+candidateName+" </strong>has been created successfully!!");
			$('#candidateStatusDiv').show();
			
			if(!$.fn.dataTable.isDataTable("#tblCandidates")){
				populateCandidateInfo(response);
			}else{
				table.row.add(response).draw(false);
			}
			
		};
	};
	
	$('#candidateModal').on('show.bs.modal', function (event) {
	  $('#saveCandidateButton').prop('disabled', false);
	  
	  var button = $(event.relatedTarget); // Button that triggered the modal
	  var candidateId = button.data('candidateid');
	  var candidateName =  button.data('candidatename');
	  var candidatePhoneNumber =  button.data('candidatephonenumber');
	  var candidateEmail =  button.data('candidateemail');
	  var candidateActive =  button.data('candidateactive');
	  var candidateReceivedDate=button.data('candidatereceiveddate');
	  var recruiterId =  button.data('recruiterid');
	  
	  $('#candidateModalStatusDiv').hide();
	  $('#candidateName').val(candidateName);
	  $('#candidatePhoneNumber').val(candidatePhoneNumber);
	  $('#candidateEmail').val(candidateEmail);

	  if ((typeof recruiterId == undefined || recruiterId == null)) {
		  //Do Nothing
	  }else{
		  $("#candidateRecruiterSelect").val(recruiterId);
	  }
	  
	  $("#candidateReceivedDate").val(candidateReceivedDate);

	  if ((typeof candidateId == undefined || candidateId == null)) {
		  $('#candidateModalLongTitle').text("Add Candidate");
	  }else{
		  $('#candidateModalLongTitle').text("Update Candidate");
	  }

	  
	  $("#candidateModal").off('click', '#saveCandidateButton');
	  
	  jQuery.validator.addMethod("lettersonlys", function(value, element) {
		  return this.optional(element) || /^[a-zA-Z\s]+$/.test(value);
		}, "Name field allows alphabets and a space only");
	  
	  jQuery.validator.addMethod("htcemail", function(value, element) {
		  email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
		  return this.optional(element) || email_regex.test(value);
		}, "Enter valid email");
	  
	  
	  $("#candidateModal").on('click', '#saveCandidateButton', function () {
		  $('#candidateModalStatusDiv').hide();
		  $('#candidateForm').validate({
			    rules : {
			    	candidateName : {  lettersonlys:true,required: true, rangelength:[3,50] },
		  			candidateEmail : {  htcemail: true, email: true,required: true},
		  			candidatePhoneNumber : { required: true, phoneUS: true },
		  			candidateRecruiterSelect: {required: true},
		  			candidateReceivedDate:{required: true}
			    },
			    messages: {
			    	candidateName:{
			    		required:"Candidate Name can not be empty and it can contain only letters",
			    		rangelength: "Minimum 3 and Maximum 50 Characters"
			        },
			        candidateEmail:{
			    		required:"E-mail can not be empty"
			        },
			        candidatePhoneNumber:{
			    		required:"Phone number can not be empty"
			        },
			        candidateRecruiterSelect:{
			    		required:"Please select a Recruiter"
			        },
			        candidateReceivedDate:{
			        	required:"Received date can not be empty"
			        }
				},
			    errorElement: PARValidationUtil.utils.validationProperties.errorElement,
			    errorPlacement: PARValidationUtil.utils.validationProperties.errorPlacement,
			    success: PARValidationUtil.utils.validationProperties.success,
			    highlight: PARValidationUtil.utils.validationProperties.highlight,
			    unhighlight: PARValidationUtil.utils.validationProperties.unhighlight
		  });
		  
		  
		  if(!$('#candidateForm').valid())
			  return;
		  $('#saveCandidateButton').prop('disabled', true);
		  if (typeof candidateId == undefined || candidateId == null) {
			  var requestBody={};
			  requestBody["candidateName"]=$('#candidateName').val();
			  requestBody["candidatePhoneNumber"]=$('#candidatePhoneNumber').val();
			  requestBody["candidateEmail"]=$('#candidateEmail').val();
			  requestBody["candidateReceivedDate"]=$('#candidateReceivedDate').val();

			  requestBody['recruiter']={};
			  requestBody['recruiter']['recruiterId']=$('#candidateRecruiterSelect').val();

			  AjaxUtil.utils.sendPostRequest('/parmanagement/par/candidates/',candidateAddSuccess(requestBody["candidateName"]), candidateAddFailure(candidateName),requestBody);
			  $('#saveCandidateButton').prop('disabled', false);
		  }
		  else{
			  var requestBody={};
			  requestBody["candidateId"]=candidateId.toString();
			  requestBody["candidateName"]=$('#candidateName').val();
			  requestBody["candidatePhoneNumber"]=$('#candidatePhoneNumber').val();
			  requestBody["candidateEmail"]=$('#candidateEmail').val();
			  requestBody["candidateReceivedDate"]=$('#candidateReceivedDate').val();
			  requestBody['candidateActive'] = candidateActive;
			  requestBody['recruiter']={};
			  requestBody['recruiter']['recruiterId']=$('#candidateRecruiterSelect').val();
			  
			  var newData={};
			  newData['candidateId'] = candidateId.toString();
			  newData['candidateName'] = $('#candidateName').val();
			  newData['candidatePhoneNumber'] = $('#candidatePhoneNumber').val();
			  newData['candidateEmail'] = $('#candidateEmail').val();
			  newData['candidateReceivedDate'] = $('#candidateReceivedDate').val();
			  newData['candidateActive'] = candidateActive;
			  newData['recruiter']={};
			  newData['recruiter']['recruiterId']=$('#candidateRecruiterSelect').val();
			  newData['recruiter']['recruiterName']=$('#candidateRecruiterSelect :selected').text();
			  AjaxUtil.utils.sendPutRequest('/parmanagement/par/candidates/',candidateUpdateSuccess(newData,'updated','candidateModalStatusMessage'), candidateUpdateFailure(candidateName),requestBody);
			  $('#saveCandidateButton').prop('disabled', false);
		  }
		});
	});
});