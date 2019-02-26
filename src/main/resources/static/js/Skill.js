$(document).ready(function(){
	
	AjaxUtil.utils.sendGetRequest('/parmanagement/par/skills', populateSkillInfo, skillLoadFailure);
	$('#statusDiv').hide();
	var table=null;
	
    $("#addNewSkillBtn").on("click", function(){
    	$('#skillModal').modal('show'); 
    });
    
	function populateSkillInfo(response){
		table = $('#tblSkills').DataTable(
				{
					autoWidth: false,
					/* dom: 'lBfrtip',
			       buttons: [
			            {
			                text: 'Add New Skill',
			                action: function ( e, dt, node, config ) {
			                	$('#skillModal').modal('show'); 
			                }
			            }
			        ],*/
					
					columns: [
     						{ data: 'skillId' },
						{ data: 'skillName' },
						{ data: 'skillActive' },
						{
							data:null,
							render: function (data, type, row){
                                return '<button class="btnDelete btn btn-sm deleteRow"><img src="static/img/delete.png" alt="Delete"></button>   <button class="btnViewSkill btn btn-sm editRow" data-toggle="modal" data-target="#skillModal" data-skillid="' + data.skillId + '" data-skillname="' + data.skillName + '" data-skillactive="' + data.skillActive + '"><img src="static/img/edit.png" alt="Edit"></button>';
								//return '<button type="button" class="btnDelete btn btn-primary">Delete</button>';
							}
						},
						/*{
							data: null,
							  render: function ( data, type, row ) {
                                  return '<button class="btnViewSkill btn btn-sm editRow" data-toggle="modal" data-target="#skillModal" data-skillid="' + data.skillId + '" data-skillname="' + data.skillName + '" data-skillactive="' + data.skillActive + '"><img src="static/img/edit.png" alt="Edit"></button>';
								  //return '<button type="button" class="btnViewSkill btn btn-primary" data-toggle="modal" data-target="#skillModal" data-skillid="' + data.skillId + '" data-skillname="' + data.skillName + '" data-skillactive="' + data.skillActive + '">Update Skill</button>';
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
			        rowId: 'skillId',
			        order: [[0,'desc']]
                }		
		);
		table.clear().rows.add(response).draw();
		$("#tblSkills tbody").on('click', '.btnDelete', function () {
			var skill = table.row($(this).closest('tr')).data();
			
		    $('#confirm').modal({ backdrop: 'static', keyboard: false })
	        .on('click', '#delete-btn', function(){
				var deleteData={};
				deleteData['skillId']=skill.skillId;
				deleteData['skillName']=skill.skillName;
				AjaxUtil.utils.sendDeleteRequest('/parmanagement/par/skills/'+skill.skillId, skillDeleteSuccess(deleteData,'deleted','statusMessage'), skillDeleteFailure(skill.skillName));
				$('#confirm').modal('hide');
	        });
		    
		});
		
		$("#tblSkills tbody").on('click', '.btnViewSkill', function () {
			var skill = table.row($(this).closest('tr')).data();
			var rowIndex = $(this).closest('tr').index();
		     $("#rowIndex").val(rowIndex);
		});
	}
	
	function skillLoadFailure(xhr, error){
		AjaxUtil.utils.displayError("Unable to load Skills");
		AjaxUtil.utils.ajaxFailureCallback(xhr, error);
	}
	
    $("[data-hide]").on("click", function(){
        $(this).closest("." + $(this).attr("data-hide")).hide();
    });
	
	var skillDeleteFailure = function(skillName) {
		return function(xhr, error){
			$('#statusDiv').removeClass("alert alert-success");
			$('#statusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#statusMessage').html('Unable to delete '+ skillName);				
			}
			else{
				
				$('#statusMessage').html(reponseBody['message']);
			}	
			$('#statusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var skillUpdateFailure = function(skillName) {
		return function(xhr, error){
			$('#modalStatusDiv').removeClass("alert alert-success");
			$('#modalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#modalStatusMessage').html('Unable to update '+ skillName);				
			}
			else{
				$('#modalStatusMessage').html(reponseBody['message']);
			}	
			$('#modalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var skillAddFailure = function(skillName) {
		return function(xhr, error){
			$('#modalStatusDiv').removeClass("alert alert-success");
			$('#modalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#modalStatusMessage').html('Unable to create ' + skillName);				
			}
			else{
				$('#modalStatusMessage').html(reponseBody['message']);
			}	
			$('#modalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};
	
	var skillDeleteSuccess = function(deleteData,action,divElement) {
		return function(response) {
			table.row('#'+deleteData['skillId']).remove().draw();
			$('#statusDiv').removeClass("alert alert-danger");
			$('#statusDiv').addClass("alert alert-success");
			$('#statusMessage').html(deleteData['skillName'] + " has been successfully deleted!!");
			$('#statusDiv').show();
		};
	};
	
	var skillUpdateSuccess = function(newData,action,divElement) {
		return function(response) {
			//var rowIndex = $("#rowIndex").val();
			table.row('#'+newData['skillId']).data(newData).draw();
			$('#modalStatusDiv').removeClass("alert alert-danger");
			$('#modalStatusDiv').addClass("alert alert-success");
			$('#modalStatusMessage').html("Skill name has been successfully updated!!");
			$('#modalStatusDiv').show();
		};
	};
	
	var skillAddSuccess = function() {
		return function(response) {
			table.row.add(response).draw( false );
			$('#modalStatusDiv').removeClass("alert alert-danger");
			$('#modalStatusDiv').addClass("alert alert-success");
			$('#modalStatusMessage').html("New Skill has been created successfully!!");
			$('#modalStatusDiv').show();
		};
	};
	
	$('#skillModal').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget); // Button that triggered the modal
	  var skillId = button.data('skillid');
	  var skillName =  button.data('skillname');
	  var skillActive = button.data('skillactive');
	  $('#modalStatusDiv').hide();
	  $('#skillName').val(skillName);
	  

	  
	  $("#skillModal").off('click', '#saveSkillButton');
	  
	  $("#skillModal").on('click', '#saveSkillButton', function () {
		  $('#modalStatusDiv').hide();
		  $('#skillForm').validate({
			    rules : {
			        skillName : {  required: true }
			    },
			    messages: {
			        skillName:{
			        	required:"Skill name can not be empty"
			        }
			    },
			    errorElement: PARValidationUtil.utils.validationProperties.errorElement,
			    errorPlacement: PARValidationUtil.utils.validationProperties.errorPlacement,
			    success: PARValidationUtil.utils.validationProperties.success,
			    highlight: PARValidationUtil.utils.validationProperties.highlight,
			    unhighlight: PARValidationUtil.utils.validationProperties.unhighlight
		  });
		  
		  if(!$('#skillForm').valid())
			  return;
		  if (typeof skillId == undefined || skillId == null) {
			  var requestBody={};
			  requestBody["skillName"]=$('#skillName').val();	  
			  AjaxUtil.utils.sendPostRequest('/parmanagement/par/skills/',skillAddSuccess(), skillAddFailure(skillName),requestBody);			   
		  }
		  else{
			  var requestBody={};
			  requestBody["skillId"]=skillId.toString();
			  requestBody["skillName"]=$('#skillName').val();
			  
			  var newData={};
			  newData['skillId'] = skillId.toString();
			  newData['skillActive'] = skillActive;
			  newData['skillName'] = $('#skillName').val();
			  AjaxUtil.utils.sendPutRequest('/parmanagement/par/skills/',skillUpdateSuccess(newData,'updated','statusModalMessage'), skillUpdateFailure(skillName),requestBody);			  
		  }
		});
	});
});