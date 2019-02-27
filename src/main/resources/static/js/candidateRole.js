$(document).ready(function(){
	
	AjaxUtil.utils.sendGetRequest('/parmanagement/par/parroles', populateRoleInfo, roleLoadFailure);
	$('#candRoleStatusDiv').hide();
	var table=null;
	
	//Add new Role
    $("#addNewRoleBtn").on("click", function(){
    	$('#roleModal').modal('show'); 
    });
    
    //Role Table
	function populateRoleInfo(response){
		table = $('#tblRoles').DataTable(
				{
					autoWidth: false,
					
					columns: [
     						{ data: 'roleId' },
						{ data: 'roleName' },
						{ data: 'roleActive' },
						{
							data:null,
							render: function (data, type, row){
                                return '<button class="btnDelete btn btn-sm deleteRow"><img src="static/img/delete.png" alt="Delete"></button>   <button class="btnViewRole btn btn-sm editRow" data-toggle="modal" data-target="#roleModal" data-roleid="' + data.roleId + '" data-rolename="' + data.roleName + '" data-roleactive="' + data.roleActive + '"><img src="static/img/edit.png" alt="Edit"></button>';
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
			                "targets": [ 2 ],
			                "visible": false,
			                "searchable": false
			            }
			        ],
			        rowId: 'roleId',
			        order: [[0,'desc']]
                }		
		);
		table.clear().rows.add(response).draw();
		$("#tblRoles tbody").on('click', '.btnDelete', function () {
			var role = table.row($(this).closest('tr')).data();
			
		    $('#confirm').modal({ backdrop: 'static', keyboard: false })
	        .on('click', '#delete-btn', function(){
				var deleteData={};
				deleteData['roleId']=role.roleId;
				deleteData['roleName']=role.roleName;
				AjaxUtil.utils.sendDeleteRequest('/parmanagement/par/parroles/'+role.roleId, roleDeleteSuccess(deleteData,'deleted','statusMessage'), roleDeleteFailure(role.roleName));
				$('#confirm').modal('hide');
	        });
		    
		});
		
		$("#tblRoles tbody").on('click', '.btnViewRole', function () {
			var role = table.row($(this).closest('tr')).data();
			var rowIndex = $(this).closest('tr').index();
		     $("#rowIndex").val(rowIndex);
		});
	}
	
	function roleLoadFailure(xhr, error){
		if(xhr.status!=404){
			var reponseBody = JSON.parse(xhr.responseText);
			$('#candRoleStatusDiv').removeClass("alert alert-success");
			$('#candRoleStatusDiv').addClass("alert alert-warning");
			$('#candStatusMessage').html(reponseBody['message']);
			$('#candRoleStatusDiv').show();
		}else{
			$('#candRoleStatusDiv').hide();
		}
	}
	
    $("[data-hide]").on("click", function(){
        $(this).closest("." + $(this).attr("data-hide")).hide();
    });
	
	var roleDeleteFailure = function(roleName) {
		return function(xhr, error){
			$('#candRoleStatusDiv').removeClass("alert alert-success");
			$('#candRoleStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#candStatusMessage').html('Unable to delete '+ roleName);				
			}
			else{
				
				$('#candStatusMessage').html(reponseBody['message']);
			}	
			$('#candRoleStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var roleUpdateFailure = function(roleName) {
		return function(xhr, error){
			$('#candRoleModalStatusDiv').removeClass("alert alert-success");
			$('#candRoleModalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#candRoleModalStatusMessage').html('Unable to update '+ roleName);				
			}
			else{
				$('#candRoleModalStatusMessage').html(reponseBody['message']);
			}	
			$('#candRoleModalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var roleAddFailure = function(roleName) {
		return function(xhr, error){
			$('#candRoleModalStatusDiv').removeClass("alert alert-success");
			$('#candRoleModalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#candRoleModalStatusMessage').html('Unable to create ' + roleName);				
			}
			else{
				$('#candRoleModalStatusMessage').html(reponseBody['message']);
			}	
			$('#candRoleModalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};
	
	var roleDeleteSuccess = function(deleteData,action,divElement) {
		return function(response) {
			table.row('#'+deleteData['roleId']).remove().draw();
			$('#candRoleStatusDiv').removeClass("alert alert-danger");
			$('#candRoleStatusDiv').addClass("alert alert-success");
			$('#candStatusMessage').html(deleteData['roleName'] + " has been successfully deleted!!");
			$('#candRoleStatusDiv').show();
		};
	};
	
	var roleUpdateSuccess = function(newData,action,divElement) {
		return function(response) {
			//var rowIndex = $("#rowIndex").val();
			table.row('#'+newData['roleId']).data(newData).draw();
			$('#candRoleModalStatusDiv').removeClass("alert alert-danger");
			$('#candRoleModalStatusDiv').addClass("alert alert-success");
			$('#candRoleModalStatusMessage').html("Role name has been successfully updated!!");
			$('#candRoleModalStatusDiv').show();
		};
	};
	
	var roleAddSuccess = function() {
		return function(response) {
			table.row.add(response).draw( false );
			$('#candRoleModalStatusDiv').removeClass("alert alert-danger");
			$('#candRoleModalStatusDiv').addClass("alert alert-success");
			$('#candRoleModalStatusMessage').html("New Role has been created successfully!!");
			$('#candRoleModalStatusDiv').show();
		};
	};
	
	$('#roleModal').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget); // Button that triggered the modal
	  var roleId = button.data('roleid');
	  var roleName =  button.data('rolename');
	  var roleActive = button.data('roleactive');
	  $('#candRoleModalStatusDiv').hide();
	  $('#roleName').val(roleName);
	  

	  
	  $("#roleModal").off('click', '#saveRoleButton');
	  
	  $("#roleModal").on('click', '#saveRoleButton', function () {
		  $('#candRoleModalStatusDiv').hide();
		  $('#roleForm').validate({
			    rules : {
			        roleName : {  required: true }
			    },
			    messages: {
			       roleName:{
			        	required:"Role name can not be empty"
			        }
			    },
			    errorElement: PARValidationUtil.utils.validationProperties.errorElement,
			    errorPlacement: PARValidationUtil.utils.validationProperties.errorPlacement,
			    success: PARValidationUtil.utils.validationProperties.success,
			    highlight: PARValidationUtil.utils.validationProperties.highlight,
			    unhighlight: PARValidationUtil.utils.validationProperties.unhighlight
		  });
		  
		  if(!$('#roleForm').valid())
			  return;
		  if (typeof roleId == undefined || roleId == null) {
			  var requestBody={};
			  requestBody["roleName"]=$('#roleName').val();	  
			  AjaxUtil.utils.sendPostRequest('/parmanagement/par/parroles/',roleAddSuccess(),roleAddFailure(roleName),requestBody);			   
		  }
		  else{
			  var requestBody={};
			  requestBody["roleId"]=roleId.toString();
			  requestBody["roleName"]=$('#roleName').val();
			  
			  var newData={};
			  newData['roleId'] = roleId.toString();
			  newData['roleActive'] = roleActive;
			  newData['roleName'] = $('#roleName').val();
			  AjaxUtil.utils.sendPutRequest('/parmanagement/par/parroles/',roleUpdateSuccess(newData,'updated','statusModalMessage'), roleUpdateFailure(roleName),requestBody);			  
		  }
		});
	});
});