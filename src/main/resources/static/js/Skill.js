$("#skills-tab").on("click", function(){
	AjaxUtil.utils.sendGetRequest('/parmanagement/par/skills', populateSkillInfo, skillLoadFailure);
	$('#statusSkillDiv').hide();
	var table=null; 
	
    $("#addNewSkillBtn").on("click", function(){
    	$('#skillModal').modal('show'); 
    });
    $('#skillModal').on('hidden.bs.modal', function() {
        var skillForm = $('#skillForm');
        skillForm.validate().resetForm();
        skillForm.find('.error').removeClass('error');
    });
	function populateSkillInfo(response){
		if(response.length<=0){
			return;
		}
		table = $('#tblSkills').DataTable(
				{
					autoWidth: false,
					retrieve: true,
					columns: [
     						{ data: 'skillId' },
						{ data: 'skillName' },
						{ data: 'skillActive' },
						{
							data:null,
							render: function (data, type, row){
                                return '<button class="btnDeleteSkill btn btn-sm deleteRow"><img src="static/img/delete.png" alt="Delete"></button>   <button class="btnViewSkill btn btn-sm editRow" data-toggle="modal" data-target="#skillModal" data-skillid="' + data.skillId + '" data-skillname="' + data.skillName + '" data-skillactive="' + data.skillActive + '"><img src="static/img/edit.png" alt="Edit"></button>';
							}
						}
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
		$("#tblSkills tbody").on('click', '.btnDeleteSkill', function () {
			var skill = table.row($(this).closest('tr')).data();
			
			$('#confirmSkillDeleteModalBody').html("Are you sure you, want to delete<strong> "+skill.skillName+" </strong>?");
			$("#confirmSkillDeleteModal").off('click', '#skill-delete-btn');
		    $('#confirmSkillDeleteModal').modal({ backdrop: 'static', keyboard: false })
	        .on('click', '#skill-delete-btn', function(){
				var deleteData={};
				deleteData['skillId']=skill.skillId;
				deleteData['skillName']=skill.skillName;
				AjaxUtil.utils.sendDeleteRequest('/parmanagement/par/skills/'+skill.skillId, skillDeleteSuccess(deleteData,'deleted','statusSkillMessage'), skillDeleteFailure(skill.skillName));
				$('#confirmSkillDeleteModal').modal('hide');
	        });
		    
		});
		
		$("#tblSkills tbody").on('click', '.btnViewSkill', function () {
			var skill = table.row($(this).closest('tr')).data();
			var rowIndex = $(this).closest('tr').index();
		     $("#rowIndex").val(rowIndex);
		});
		$('#tblSkills').show();
	}
	
	function skillLoadFailure(xhr, error){
		if(xhr.status!=404){
			var reponseBody = JSON.parse(xhr.responseText);
			$('#statusSkillDiv').removeClass("alert alert-success");
			$('#statusSkillDiv').addClass("alert alert-warning");
			$('#statusSkillMessage').html(reponseBody['message']);
			$('#statusSkillDiv').show();
		}else{
			$('#tblSkills').hide();
			$('#statusSkillDiv').hide();
		}
	}
	
    $("[data-hide]").on("click", function(){
        $(this).closest("." + $(this).attr("data-hide")).hide();
    });
	
	var skillDeleteFailure = function(skillName) {
		return function(xhr, error){
			$('#statusSkillDiv').removeClass("alert alert-success");
			$('#statusSkillDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#statusSkillMessage').html('Unable to delete '+ skillName);				
			}
			else{
				
				$('#statusSkillMessage').html(reponseBody['message']);
			}	
			$('#statusSkillDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};
	
	var skillUpdateFailure = function(skillName) {
		return function(xhr, error){
			$('#modalStatusSkillDiv').removeClass("alert alert-success");
			$('#modalStatusSkillDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#modalStatusSkillMessage').html('Unable to update '+ skillName);				
			}
			else{
				$('#modalStatusSkillMessage').html(reponseBody['message']);
			}	
			$('#modalStatusSkillDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var skillAddFailure = function(skillName) {
		return function(xhr, error){
			$('#modalStatusSkillDiv').removeClass("alert alert-success");
			$('#modalStatusSkillDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#modalStatusSkillMessage').html('Unable to create ' + skillName);				
			}
			else{
				$('#modalStatusSkillMessage').html(reponseBody['message']);
			}	
			$('#modalStatusSkillDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};
	
	var skillDeleteSuccess = function(deleteData,action,divElement) {
		return function(response) {
			table.row('#'+deleteData['skillId']).remove().draw();
			$('#statusSkillDiv').removeClass("alert alert-danger");
			$('#statusSkillDiv').addClass("alert alert-success");
			$('#statusSkillMessage').html("<strong> " +deleteData['skillName'] + " </strong> has been deleted successfully !!");
			$('#statusSkillDiv').show();
		};
	};
	
	var skillUpdateSuccess = function(newData,action,divElement) {
		return function(response) {
			//var rowIndex = $("#rowIndex").val();
			$('#skillModal').modal('hide');
			table.row('#'+newData['skillId']).data(newData).draw();
			$('#statusSkillDiv').removeClass("alert alert-danger");
			$('#statusSkillDiv').addClass("alert alert-success");
			$('#statusSkillMessage').html("Skill name<strong> "+ newData['skillName']+" </strong>  has been updated successfully !!");
			$('#statusSkillDiv').show();
		};
	};
	
	var skillAddSuccess = function(skillName) {
		return function(response) {
			$('#skillModal').modal('hide');
			$('#statusSkillDiv').removeClass("alert alert-danger");
			$('#statusSkillDiv').addClass("alert alert-success");
			$('#statusSkillMessage').html("New Skill<strong> "+skillName+" </strong> has been created successfully!!");
			$('#statusSkillDiv').show();
			if(!$.fn.dataTable.isDataTable("#tblSkills")){
				populateSkillInfo([response]);
			}else{
				table.row.add(response).draw(false);
			}
		};
	};
	
	$('#skillModal').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget); // Button that triggered the modal
	  var skillId = button.data('skillid');
	  var skillName =  button.data('skillname');
	  var skillActive = button.data('skillactive');
	  $('#modalStatusSkillDiv').hide();
	  $('#skillName').val(skillName);
	  if (typeof skillId == undefined || skillId == null) {
		  $('#skillModalTitle').text("Add Skill");
	  }else{
		  $('#skillModalTitle').text("Update Skill");
	  }

	  
	  $("#skillModal").off('click', '#saveSkillButton');
	  
	  $("#skillModal").on('click', '#saveSkillButton', function () {
		  $('#modalStatusSkillDiv').hide();
		  $('#skillForm').validate({
			    rules : {
			        skillName : {  required: true ,  rangelength:[3,50] }
			    },
			    messages: {
			        skillName:{
			        	required:"Skill name can not be empty",
			        	rangelength: "Minimum 3 and Maximum 50 Characters"
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
			  AjaxUtil.utils.sendPostRequest('/parmanagement/par/skills/',skillAddSuccess(requestBody["skillName"]), skillAddFailure(skillName),requestBody);			   
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