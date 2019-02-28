$(document).ready(function(){
	
	AjaxUtil.utils.sendGetRequest('/parmanagement/par/Areas', populateAreaInfo, areaLoadFailure);
	$('#areaStatusDiv').hide();
	var table=null;
	
    $("#addNewAreaBtn").on("click", function(){
    	$('#areaModal').modal('show'); 
    });
    
	function populateAreaInfo(response){
		table = $('#tblAreas').DataTable(
				{
					autoWidth: false,
					/* dom: 'lBfrtip',
			       buttons: [
			            {
			                text: 'Add New Area',
			                action: function ( e, dt, node, config ) {
			                	$('#areaModal').modal('show'); 
			                }
			            }
			        ],*/
					
					columns: [
     					{ data: 'areaId' },
						{ data: 'areaName' },
						{ data: 'areaActive' },
						{
							data:null,
							render: function (data, type, row){
                                return '<button class="btnDelete btn btn-sm deleteRow"><img src="static/img/delete.png" alt="Delete"></button>   <button class="btnViewArea btn btn-sm editRow" data-toggle="modal" data-target="#areaModal" data-areaid="' + data.areaId + '" data-areaname="' + data.areaName + '" data-areaactive="' + data.areaActive + '"><img src="static/img/edit.png" alt="Edit"></button>';
								//return '<button type="button" class="btnDelete btn btn-primary">Delete</button>';
							}
						},
						/*{
							data: null,
							  render: function ( data, type, row ) {
                                  return '<button class="btnViewArea btn btn-sm editRow" data-toggle="modal" data-target="#areaModal" data-areaid="' + data.areaId + '" data-areaname="' + data.areaName + '" data-areaactive="' + data.areaActive + '"><img src="static/img/edit.png" alt="Edit"></button>';
								  //return '<button type="button" class="btnViewArea btn btn-primary" data-toggle="modal" data-target="#areaModal" data-areaid="' + data.areaId + '" data-areaname="' + data.areaName + '" data-areaactive="' + data.areaActive + '">Update Area</button>';
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
			        rowId: 'areaId',
			        order: [[0,'desc']]
                }		
		);
		table.clear().rows.add(response).draw();
		$("#tblAreas tbody").on('click', '.btnDelete', function () {
			var area = table.row($(this).closest('tr')).data();
			
		    $('#areaDeleteconfirmModal').modal({ backdrop: 'static', keyboard: false })
	        .on('click', '#areaDelete-btn', function(){
				var deleteData={};
				deleteData['areaId']=area.areaId;
				deleteData['areaName']=area.areaName;
				AjaxUtil.utils.sendDeleteRequest('/parmanagement/par/Areas/'+area.areaId, areaDeleteSuccess(deleteData,'deleted','statusMessage'), areaDeleteFailure(area.areaName));
				$('#areaDeleteconfirmModal').modal('hide');
	        });
		    
		});
		
		$("#tblAreas tbody").on('click', '.btnViewArea', function () {
			var area = table.row($(this).closest('tr')).data();
			var rowIndex = $(this).closest('tr').index();
		     $("#rowIndex").val(rowIndex);
		});
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
	
	var areaDeleteFailure = function(areaName) {
		return function(xhr, error){
			$('#areaStatusDiv').removeClass("alert alert-success");
			$('#areaStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#areaStatusMessage').html('Unable to delete '+ areaName);				
			}
			else{
				
				$('#areaStatusMessage').html(reponseBody['message']);
			}	
			$('#areaStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var areaUpdateFailure = function(areaName) {
		return function(xhr, error){
			$('#areaModalStatusDiv').removeClass("alert alert-success");
			$('#areaModalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#areaModalStatusMessage').html('Unable to update '+ areaName);				
			}
			else{
				$('#areaModalStatusMessage').html(reponseBody['message']);
			}	
			$('#areaModalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var areaAddFailure = function(areaName) {
		return function(xhr, error){
			$('#areaModalStatusDiv').removeClass("alert alert-success");
			$('#areaModalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#areaModalStatusMessage').html('Unable to create ' + areaName);				
			}
			else{
				$('#areaModalStatusMessage').html(reponseBody['message']);
			}	
			$('#areaModalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};
	
	var areaDeleteSuccess = function(deleteData,action,divElement) {
		return function(response) {
			table.row('#'+deleteData['areaId']).remove().draw();
			$('#areaStatusDiv').removeClass("alert alert-danger");
			$('#areaStatusDiv').addClass("alert alert-success");
			$('#areaStatusMessage').html(deleteData['areaName'] + " has been successfully deleted!!");
			$('#areaStatusDiv').show();
		};
	};
	
	var areaUpdateSuccess = function(newData,action,divElement) {
		return function(response) {
			//var rowIndex = $("#rowIndex").val();
			table.row('#'+newData['areaId']).data(newData).draw();
			$('#areaModalStatusDiv').removeClass("alert alert-danger");
			$('#areaModalStatusDiv').addClass("alert alert-success");
			$('#areaModalStatusMessage').html("Area name has been successfully updated!!");
			$('#areaModalStatusDiv').show();
		};
	};
	
	var areaAddSuccess = function() {
		return function(response) {
			table.row.add(response).draw( false );
			$('#areaModalStatusDiv').removeClass("alert alert-danger");
			$('#areaModalStatusDiv').addClass("alert alert-success");
			$('#areaModalStatusMessage').html("New Area has been created successfully!!");
			$('#areaModalStatusDiv').show();
		};
	};
	
	$('#areaModal').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget); // Button that triggered the modal
	  var areaId = button.data('areaid');
	  var areaName =  button.data('areaname');
	  var areaActive = button.data('areaactive');
	  $('#areaModalStatusDiv').hide();
	  $('#areaName').val(areaName);
	  

	  
	  $("#areaModal").off('click', '#saveAreaButton');
	  
	  $("#areaModal").on('click', '#saveAreaButton', function () {
		  $('#areaModalStatusDiv').hide();
		  $('#areaForm').validate({
			    rules : {
			        areaName : {  required: true }
			    },
			    messages: {
			        areaName:{
			        	required:"Area name can not be empty"
			        }
			    },
			    errorElement: PARValidationUtil.utils.validationProperties.errorElement,
			    errorPlacement: PARValidationUtil.utils.validationProperties.errorPlacement,
			    success: PARValidationUtil.utils.validationProperties.success,
			    highlight: PARValidationUtil.utils.validationProperties.highlight,
			    unhighlight: PARValidationUtil.utils.validationProperties.unhighlight
		  });
		  
		  if(!$('#areaForm').valid())
			  return;
		  if (typeof areaId == undefined || areaId == null) {
			  var requestBody={};
			  requestBody["areaName"]=$('#areaName').val();	  
			  AjaxUtil.utils.sendPostRequest('/parmanagement/par/Areas/',areaAddSuccess(), areaAddFailure(areaName),requestBody);			   
		  }
		  else{
			  var requestBody={};
			  requestBody["areaId"]=areaId.toString();
			  requestBody["areaName"]=$('#areaName').val();
			  
			  var newData={};
			  newData['areaId'] = areaId.toString();
			  newData['areaActive'] = areaActive;
			  newData['areaName'] = $('#areaName').val();
			  AjaxUtil.utils.sendPutRequest('/parmanagement/par/Areas/',areaUpdateSuccess(newData,'updated','statusModalMessage'), areaUpdateFailure(areaName),requestBody);			  
		  }
		});
	});
});