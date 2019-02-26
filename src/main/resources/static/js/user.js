$(document).ready(function(){
	
	AjaxUtil.utils.sendGetRequest('/parmanagement/par/users', populateUserInfo, userLoadFailure);
AjaxUtil.utils.sendGetRequest('/parmanagement/par/users/roles', populateRoleInfo, roleLoadFailure);
	
	$('#userStatusDiv').hide();
	var table=null;
	
    $("#addNewUserBtn").on("click", function(event){
     	$('#userModal').modal('show'); 
    });
    
	function populateUserInfo(response){
		table = $('#tblUsers').DataTable(
				{
					autoWidth: false,
										
					columns: [
     						{ data: 'userId' },
     						{ data: 'firstName' },
     						{ data: 'lastName' },
     						{ data: 'userName' },
     						{ data: 'password' },
     						{ data: 'role.roleName' },
     						{ data: 'phone' },
     						{ data: 'email' },
     						{ data: 'userActive' },
						{
							data:null,
							render: function (data, type, row){
                                return '<button class="btnUserDelete btn btn-sm deleteUserRow"><img src="static/img/delete.png" alt="Delete"></button>  <button class="btnViewUser btn btn-sm editUserRow" data-toggle="modal" data-target="#userModal" data-userid="' + data.userId + '"data-firstname="' + data.firstName + '"data-lastname="' + data.lastName + '"data-username="' + data.userName + '"data-password="' + data.password + '"data-roleid="' + data.role.roleId + '"data-phone="' + data.phone + '"data-email="' + data.email + '"data-useractive="' + data.userActive + '"><img src="static/img/edit.png" alt="Edit"></button>';
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
			            {
			                "targets": [ 8 ],
			                "visible": false,
			                "searchable": false
			            }
			        ],
			        rowId: 'userId',
			        order: [[0,'desc']]
                }		
		);
		table.clear().rows.add(response).draw();
		$("#tblUsers tbody").on('click', '.btnUserDelete', function () {
			var user = table.row($(this).closest('tr')).data();
			
		    $('#userDeleteConfirmModal').modal({ backdrop: 'static', keyboard: false })
	        .on('click', '#user-delete-btn', function(){
				var deleteData={};
				deleteData['userId']=user.userId;
				deleteData['firstName']=user.firstName;
				deleteData['lastName']=user.lastName;
				deleteData['phone']=user.phone;
				deleteData['userName']=user.userName;
				AjaxUtil.utils.sendDeleteRequest('/parmanagement/par/users/'+user.userId, userDeleteSuccess(deleteData,'deleted','statusMessage'), userDeleteFailure(user.userName));
				$('#userDeleteConfirmModal').modal('hide');
	        });
		    
		});
		
		$("#tblUser tbody").on('click', '.btnViewUser', function () {
			var user = table.row($(this).closest('tr')).data();
			var rowIndex = $(this).closest('tr').index();
		     $("#rowIndex").val(rowIndex);
		});
	}
	
	function userLoadFailure(xhr, error){
		if(xhr.status!=404){
			var reponseBody = JSON.parse(xhr.responseText);
			$('#userStatusDiv').removeClass("alert alert-success");
			$('#userStatusDiv').addClass("alert alert-warning");
			$('#userStatusMessage').html(reponseBody['message']);
			$('#userStatusDiv').show();
		}else{
			$('#userStatusDiv').hide();
		}
	}
	function roleLoadFailure(xhr, error){
		if(xhr.status!=404){
			var reponseBody = JSON.parse(xhr.responseText);
			$('#userStatusDiv').removeClass("alert alert-success");
			$('#userStatusDiv').addClass("alert alert-warning");
			$('#userStatusMessage').html(reponseBody['message']);
			$('#userStatusDiv').show();
		}else{
			$('#userStatusDiv').hide();
		}
	}
	
    $("[data-hide]").on("click", function(){
        $(this).closest("." + $(this).attr("data-hide")).hide();
    });
	
	var userDeleteFailure = function(userName) {
		return function(xhr, error){
			$('#userStatusDiv').removeClass("alert alert-success");
			$('#userStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#userStatusMessage').html('Unable to delete '+ userName);				
			}
			else{
				
				$('#userStatusMessage').html(reponseBody['message']);
			}	
			$('#userStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};
	
	function populateRoleInfo (response){
		
		 $.each(response, function(i, role) {
	            $('#userRoleSelect').append($('<option></option>').text(role.roleName).attr('value', role.roleId));
	        });
	};

	var userUpdateFailure = function(userName) {
		return function(xhr, error){
			$('#useMmodalStatusDiv').removeClass("alert alert-success");
			$('#useMmodalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#userModalStatusMessage').html('Unable to update '+ userName);				
			}
			else{
				$('#userModalStatusMessage').html(reponseBody['message']);
			}	
			$('#modalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};

	var userAddFailure = function(userName) {
		return function(xhr, error){
			$('#useMmodalStatusDiv').removeClass("alert alert-success");
			$('#useMmodalStatusDiv').addClass("alert alert-danger");
			var reponseBody = JSON.parse(xhr.responseText);
			if (typeof reponseBody['message'] == undefined || reponseBody['message'] == null) {
				$('#userModalStatusMessage').html('Unable to create ' + userName);				
			}
			else{
				$('#userModalStatusMessage').html(reponseBody['message']);
			}	
			$('#useMmodalStatusDiv').show();
			console.log("Error Code :"+ xhr.status);
			console.log(error);
		};
	};
	
	var userDeleteSuccess = function(deleteData,action,divElement) {
		return function(response) {
			table.row('#'+deleteData['userId']).remove().draw();
			$('#userStatusDiv').removeClass("alert alert-danger");
			$('#userStatusDiv').addClass("alert alert-success");
			$('#userStatusMessage').html(deleteData['userName'] + " has been successfully deleted!!");
			$('#userStatusDiv').show();
		};
	};
	
	var userUpdateSuccess = function(newData,action,divElement) {
		return function(response) {
			//var rowIndex = $("#rowIndex").val();
			table.row('#'+newData['userId']).data(response).draw();
			$('#useMmodalStatusDiv').removeClass("alert alert-danger");
			$('#useMmodalStatusDiv').addClass("alert alert-success");
			$('#userModalStatusMessage').html("User has been successfully updated!!");
			$('#useMmodalStatusDiv').show();
		};
	};
	
	var userAddSuccess = function() {
		return function(response) {
			table.row.add(response).draw( false );
			$('#useMmodalStatusDiv').removeClass("alert alert-danger");
			$('#useMmodalStatusDiv').addClass("alert alert-success");
			$('#userModalStatusMessage').html("New User has been created successfully!!");
			$('#useMmodalStatusDiv').show();
		};
	};
	
	$('#userModal').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget); // Button that triggered the modal
	  var userId = button.data('userid');
	  var firstName =  button.data('firstname');
	  var lastName =  button.data('lastname');
	  var userName =  button.data('username');
	  var password =  button.data('password');
	  var email =  button.data('email');
	  var phone =  button.data('phone');
	  var roleId =  button.data('roleid');
	  var userActive = button.data('useractive');
	  $('#useMmodalStatusDiv').hide();
	  $('#firstName').val(firstName);
	  $('#lastName').val(lastName);
	  $('#userName').val(userName);
	 // $('#password').val(password);
	  $("#userRoleSelect").val(roleId);
	  $("#email").val(email);
	  $("#phone").val(phone);
	  if ((typeof userId == undefined || userId == null)) {
		  $('#userName').prop('disabled',false);
	  }else{
		  $('#userName').prop('disabled',true);
	  }

	  
	  $("#userModal").off('click', '#saveUserButton');
	  
	  jQuery.validator.addMethod("lettersonlys", function(value, element) {
		  return this.optional(element) || /^[a-zA-Z\s]+$/.test(value);
		}, "Name field allows alphabets and a space only");
	  
	  jQuery.validator.addMethod("userName", function(value, element) {
		  return this.optional(element) || /^[a-zA-Z0-9]+$/.test(value);
		}, "UserName field allows alphanumeric  only");
	  
	  $("#userModal").on('click', '#saveUserButton', function () {
		  $('#useMmodalStatusDiv').hide();
		  $('#userForm').validate({
			    rules : {
			    	firstName : {  lettersonlys:true,required: true },
		  			lastName : {  lettersonlys:true,required: true },
		  			userName : {  minlength: 5,maxlength: 10,userName:true, required: true },
		  			password : {  minlength: 5,maxlength: 10,required: true },
		  			email : {  email: true,required: true},
		  			phone : { required: true }
			    },
			    messages: {
			    	firstName:{
			    		required:"First Name can not be empty and allows only letters and space"
			        },
			    firstName:{
		    		required:"Last Name can not be empty and allows only letters and space"
		        },
			    userName:{
		    		required:"User Name can not be empty",
		    		minlength:"User Name is minimum of 5 characters length ",
		    		maxlength:"User Name is maximum of 10 characters length "
		        },
			    password:{
		    		required:"password can not be empty",
		    		minlength:"password is minimum of 5 characters length ",
		    		maxlength:"password is maximum of 10 characters length "
		        },
			    email:{
		    		required:"email can not be empty"
		        },
			    phone:{
		    		required:"phone number can not be empty"
		        },
			    },
			    errorElement: PARValidationUtil.utils.validationProperties.errorElement,
			    errorPlacement: PARValidationUtil.utils.validationProperties.errorPlacement,
			    success: PARValidationUtil.utils.validationProperties.success,
			    highlight: PARValidationUtil.utils.validationProperties.highlight,
			    unhighlight: PARValidationUtil.utils.validationProperties.unhighlight
		  });
		  
		  if(!$('#userForm').valid())
			  return;
		  if (typeof userId == undefined || userId == null) {
			  var requestBody={};
			  requestBody["firstName"]=$('#firstName').val();
			  requestBody["lastName"]=$('#lastName').val();
			  requestBody["userName"]=$('#userName').val();
			  requestBody["password"]=$('#password').val();
			  requestBody['role']={};
			  requestBody['role']['roleId']=$('#userRoleSelect').val();
			  requestBody["email"]=$('#email').val();
			  requestBody["phone"]=$('#phone').val();
			  AjaxUtil.utils.sendPostRequest('/parmanagement/par/users/',userAddSuccess(), userAddFailure(userName),requestBody);			   
		  }
		  else{
			  var requestBody={};
			  requestBody["userId"]=userId.toString();
			  requestBody["firstName"]=$('#firstName').val();
			  requestBody["lastName"]=$('#lastName').val();
			  requestBody["userName"]=$('#userName').val();
			  requestBody["password"]=$('#password').val();
			  requestBody['role']={};
			  requestBody['role']['roleId']=$('#userRoleSelect').val();
			  requestBody["email"]=$('#email').val();
			  requestBody["phoe"]=$('#phone').val();
			  $('#userName').prop('disabled',true);
			  var newData={};
			  newData['userId'] = userId.toString();
			  newData['userName'] = userName;
			  newData['firstName'] = $('#firstName').val();
			  newData['lastName'] = $('#lastName').val();
			  newData['password'] = $('#password').val();
			  newData['role']={};
			  newData['role']['roleId']=$('#userRoleSelect').val();
			  newData['role']['roleName']=$('#userRoleSelect :selected').text();
			  newData['email'] = $('#email').val();
			  newData['phone'] = $('#phone').val();
			  newData['userActive'] = userActive;
			  AjaxUtil.utils.sendPutRequest('/parmanagement/par/users/',userUpdateSuccess(newData,'updated','statusModalMessage'), userUpdateFailure(userName),requestBody);			  
		  }
		});
	});
});