$(document).ready(function(){
	
	AjaxUtil.utils.sendGetRequest('/parmanagement/par/recruiters', populateRecruiterInfo, recruiterLoadFailure);
	$('#recruiterstatusDiv').hide();
	var table=null;
	
	//Add new Recruiter
    $("#addNewRecruiterBtn").on("click", function(){
    	$('#recruiterModal').modal('show'); 
    });
    
    //Recruiter Table
	function populateRecruiterInfo(response){
		table = $('#tblRecruiters').DataTable(
				{
					autoWidth: false,
					
					columns: [
     					{ data: 'recruiterId' },
						{ data: 'recruiterName' },
						{ data: 'recruiterPhoneNumber' },
 						{ data: 'recruiterEmail' },
						{ data: 'recruiterEmailFlag' },
						{ data: 'recruiterActive' },
						{
							data:null,
							render: function (data, type, row){
                                return '<button class="btnDelete btn btn-sm deleteRow"><img src="static/img/delete.png" alt="Delete"></button> <button class="btnViewRecruiter btn btn-sm editRow" data-toggle="modal" data-target="#recruiterModal" data-recruiterid="' + data.recruiterId + '"  data-recruitername="' + data.recruiterName + '" data-recruiterphonenumber="' + data.recruiterPhoneNumber + '" data-recruiteremail="' + data.recruiterEmail + '" data-recruiteremailflag="' + data.recruiterEmailFlag + '" data-recruiteractive="' + data.recruiterActive + '"><img src="static/img/edit.png" alt="Edit"></button>';
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
			                "visible": true,
			                "searchable": true,
			                "render": function (data, type, row){
			                	if( data === true) 
			                		return "Yes";
			                	else 
			                		return "No";
			                }
			            },
			            {
			                "targets": [ 5 ],
			                "visible": false,
			                "searchable": false
			            }
			        ],
			        rowId: 'recruiterId',
			        order: [[0,'desc']]
                }		
		);
		table.clear().rows.add(response).draw();
		$("#tblRecruiters tbody").on('click', '.btnDelete', function () {
			var recruiter = table.row($(this).closest('tr')).data();
			
		    $('#confirmrecruiter').modal({ backdrop: 'static', keyboard: false })
	        .on('click', '#delete-btn', function(){
				var deleteData={};
				deleteData['recruiterId']=recruiter.recruiterId;
				deleteData['recruiterName']=recruiter.recruiterName;
				deleteData['recruiterPhoneNumber']=recruiter.recruiterPhoneNumber;
				deleteData['recruiterEmail']=recruiter.recruiterEmail;
				deleteData['recruiterEmailFlag']=recruiter.recruiterEmailFlag;
				AjaxUtil.utils.sendDeleteRequest('/parmanagement/par/recruiters/'+recruiter.recruiterId, recruiterDeleteSuccess(deleteData,'deleted','recruiterstatusMessage'), recruiterDeleteFailure(recruiter.recruiterName));
				$('#confirmrecruiter').modal('hide');
	        });
		    
		});
		
		$("#tblRecruiters tbody").on('click', '.btnViewRecruiter', function () {
			var recruiter = table.row($(this).closest('tr')).data();
			var rowIndex = $(this).closest('tr').index();
		     $("#rowIndex").val(rowIndex);
		});
	}
	
	function recruiterLoadFailure (xhr, error){
		
		if(xhr.status!=404){
			var reponseBody = JSON.parse(xhr.responseText);
			$('#recruiterstatusDiv').removeClass("alert alert-success");
			$('#recruiterstatusDiv').addClass("alert alert-warning");
			$('#recruiterstatusMessage').html(reponseBody['message']);
			$('#recruiterstatusDiv').show();
		}else{
			$('#recruiterstatusDiv').hide();
		}
	}
	
    $("[data-hide]").on("click", function(){
        $(this).closest("." + $(this).attr("data-hide")).hide();
    });
	
	var recruiterDeleteFailure = function(recruiterName) {
		return function(xhr, error){
			$('#recruiterstatusDiv').removeClass("alert alert-success");
			$('#recruiterstatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#recruiterstatusMessage').html('Unable to delete '+ recruiterName);				
			}
			else{
				
				$('#recruiterstatusMessage').html(reponseBody['message']);
			}	
			$('#recruiterstatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var recruiterUpdateFailure = function(recruiterName) {
		return function(xhr, error){
			$('#recruitermodalStatusDiv').removeClass("alert alert-success");
			$('#recruitermodalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#recruitermodalStatusMessage').html('Unable to update '+ recruiterName);				
			}
			else{
				$('#recruitermodalStatusMessage').html(reponseBody['message']);
			}	
			$('#recruitermodalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var recruiterAddFailure = function(recruiterName) {
		return function(xhr, error){
			$('#recruitermodalStatusDiv').removeClass("alert alert-success");
			$('#recruitermodalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#recruitermodalStatusMessage').html('Unable to create ' + recruiterName);				
			}
			else{
				$('#recruitermodalStatusMessage').html(reponseBody['message']);
			}	
			$('#recruitermodalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};
	
	var recruiterDeleteSuccess = function(deleteData,action,divElement) {
		return function(response) {
			table.row('#'+deleteData['recruiterId']).remove().draw();
			$('#recruiterstatusDiv').removeClass("alert alert-danger");
			$('#recruiterstatusDiv').addClass("alert alert-success");
			$('#recruiterstatusMessage').html(deleteData['recruiterName'] + " has been deleted successfully !!");
			$('#recruiterstatusDiv').show();
		};
	};
	
	var recruiterUpdateSuccess = function(newData,action,divElement) {
		return function(response) {
			//var rowIndex = $("#rowIndex").val();
			table.row('#'+newData['recruiterId']).data(newData).draw();
			$('#recruitermodalStatusDiv').removeClass("alert alert-danger");
			$('#recruitermodalStatusDiv').addClass("alert alert-success");
			$('#recruitermodalStatusMessage').html("Recruiter info has been updated successfully !!");
			$('#recruitermodalStatusDiv').show();
		};
	};
	
	var recruiterAddSuccess = function() {
		return function(response) {
		//	table.row.add(response).draw( false );
			$('#recruitermodalStatusDiv').removeClass("alert alert-danger");
			$('#recruitermodalStatusDiv').addClass("alert alert-success");
			$('#recruitermodalStatusMessage').html("New Recruiter has been created successfully!!");
			$('#recruitermodalStatusDiv').show();
			
			if(!$.fn.dataTable.isDataTable("#tblRecruiters")){
				populateRecruiterInfo(response);
			}else{
				table.row.add(response).draw(false);
			}
		};
	};
	
	$('#recruiterModal').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget); // Button that triggered the modal
	  var recruiterId = button.data('recruiterid');
	  var recruiterName =  button.data('recruitername');
	  var recruiterPhoneNumber = button.data('recruiterphonenumber');
	  var recruiterEmail = button.data('recruiteremail');
	  var recruiterEmailFlag =  button.data('recruiteremailflag');
	  var recruiterActive = button.data('recruiteractive');
	  $('#recruitermodalStatusDiv').hide();
	  $('#recruiterName').val(recruiterName);
	  $('#recruiterPhoneNumber').val(recruiterPhoneNumber);
	  $('#recruiterEmail').val(recruiterEmail);
	  $('#recruiterEmailFlag :selected').val(recruiterEmailFlag);
	  

	  
	  $("#recruiterModal").off('click', '#saveRecruiterButton');
	  
	  $("#recruiterModal").on('click', '#saveRecruiterButton', function () {
		  $('#recruitermodalStatusDiv').hide();
		  $('#recruiterForm').validate({
			    rules : {
			    	recruiterName : {  required: true },
			    	recruiterPhoneNumber : {  required: true },
			    	recruiterEmail : {  required: true },
			        
			    },
			    messages: {
			    	recruiterName:{required:"Recruiter name can not be empty"},
			    	recruiterPhoneNumber:{required:"Recruiter Phone Number can not be empty"},
			    	recruiterEmail:{required:"Recruiter Email can not be empty"},
			       
			    },
			    errorElement: PARValidationUtil.utils.validationProperties.errorElement,
			    errorPlacement: PARValidationUtil.utils.validationProperties.errorPlacement,
			    success: PARValidationUtil.utils.validationProperties.success,
			    highlight: PARValidationUtil.utils.validationProperties.highlight,
			    unhighlight: PARValidationUtil.utils.validationProperties.unhighlight
		  });
		  
		  if(!$('#recruiterForm').valid())
			  return;
		  if (typeof recruiterId == undefined || recruiterId == null) {
			  var requestBody={};
			  requestBody["recruiterName"]=$('#recruiterName').val();	
			  requestBody["recruiterPhoneNumber"]=$('#recruiterPhoneNumber').val();
			  requestBody["recruiterEmail"]=$('#recruiterEmail').val();
			  requestBody["recruiterEmailFlag"]=$('input[name=recruiterEmailFlag]:checked').val();
			  AjaxUtil.utils.sendPostRequest('/parmanagement/par/recruiters/',recruiterAddSuccess(),recruiterAddFailure(recruiterName),requestBody);			   
		  }
		  else{
			  var requestBody={};
			  requestBody["recruiterId"]=recruiterId.toString();
			  requestBody["recruiterName"]=$('#recruiterName').val();	
			  requestBody["recruiterPhoneNumber"]=$('#recruiterPhoneNumber').val();
			  requestBody["recruiterEmail"]=$('#recruiterEmail').val();
			  requestBody["recruiterEmailFlag"]=($('input[name=recruiterEmailFlag]:checked').val()=='true');
			  
			  var newData={};
			  
			  newData = requestBody;

			  newData['recruiterActive'] = recruiterActive;
			  
			  AjaxUtil.utils.sendPutRequest('/parmanagement/par/recruiters/',recruiterUpdateSuccess(newData,'updated','recruitermodalStatusMessage'), recruiterUpdateFailure(recruiterName),requestBody);			  
		  }
		});
	});
});