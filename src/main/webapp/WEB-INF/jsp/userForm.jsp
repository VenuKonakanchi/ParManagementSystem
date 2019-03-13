<div class="collapse" role="alert" id="userStatusDiv">
	<span id="userStatusMessage"></span>
	<button type="button" class="close" data-hide="alert">&times;</button>
</div>

<div class="modal fade" id="userDeleteConfirmModal" tabindex="-1" role="dialog"
	aria-labelledby="userDeleteconfirmModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="userDeleteconfirmModal">Delete User
					Confirmation</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p id="userDeleteconfirmModalBody"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="user-delete-btn">Delete</button>
				<button type="button" class="btn btn-secondary cancel"
					data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="userModal" tabindex="-1" role="dialog"
	aria-labelledby="userModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="collapse" role="alert" id="userModalStatusDiv">
					<span id="userModalStatusMessage"></span>
					<button type="button" class="close" data-hide="alert">&times;</button>
				</div>
				<div class="card modal-card">
				  <div class="card-header modal-card-header">
				    <h5 class="text-left" id="userModalLongTitle">Add/Update User</h5>
				  </div>
				  <div class="card-body">
					<form class="form-horizontal" role="form" id="userForm">
					<input type="hidden" id="rowIndex" name="rowIndex" value="">
						<div class="form-group row">
							<label class="control-label col-sm-3 text-right font-weight-bold" for="firstName">First
							Name :</label>
							<div class="col-sm-6 input-group  modal-form-input-group">
								<div class="input-group input-group-prepend">
		    						<span class="input-group-text modal-form-field-prepend-span" id="firstName-addon"><i class="fa fa-pencil"></i></span>
		    						<input type="text" class="form-control modal-form-input" id="firstName"	placeholder="Enter First Name" name="firstName" aria-describedby="firstName-addon">
								</div>
							</div>
							<div class="col-sm-3">
							</div>
						</div>
						<div class="form-group row">
							<label class="control-label col-sm-3 text-right font-weight-bold" for="lastName">Last
							Name :</label>
							<div class="col-sm-6 input-group  modal-form-input-group">
								<div class="input-group input-group-prepend">
		    						<span class="input-group-text modal-form-field-prepend-span" id="lastName-addon"><i class="fa fa-pencil"></i></span>
		    						<input type="text" class="form-control modal-form-input" id="lastName"	placeholder="Enter Last Name" name="lastName" aria-describedby="lastName-addon">
								</div>
							</div>
							<div class="col-sm-3">
							</div>
						</div>
						
						<div class="form-group row">
							<label class="control-label col-sm-3 text-right font-weight-bold" for="userName">User
							Name :</label>
							<div class="col-sm-6 input-group  modal-form-input-group">
								<div class="input-group input-group-prepend">
		    						<span class="input-group-text modal-form-field-prepend-span" id="userName-addon"><i class="fa fa-user"></i></span>
		    						<input type="text" class="form-control modal-form-input" id="userName"	placeholder="Enter User Name (Login ID)" name="userName" aria-describedby="userName-addon">
								</div>
							</div>
							<div class="col-sm-3">
							</div>
						</div>
						<div class="form-group row">
							<label class="control-label col-sm-3 text-right font-weight-bold" for="password">Password :</label>
							<div class="col-sm-6 input-group  modal-form-input-group">
								<div class="input-group input-group-prepend">
		    						<span class="input-group-text modal-form-field-prepend-span" id="password-addon"><i class="fa fa-lock"></i></span>
		    						<input type="text" class="form-control modal-form-input" id="password"	placeholder="Enter Password" name="password" aria-describedby="password-addon">
								</div>
							</div>
							<div class="col-sm-3">
							</div>
						</div>
						<div class="form-group row">
							<label class="control-label col-sm-3 text-right font-weight-bold" for="userRoleSelect">Select
							User Role :</label>
							<div class="col-sm-6  input-group">
								<div class="input-group input-group-prepend">
									<span class="input-group-text  modal-form-field-prepend-span" id="userRole-addon"><i class="fa fa-gear"></i></span>
								<select  class="form-control modal-form-input" id="userRoleSelect" aria-describedby="userRole-addon" ></select>
								</div>	
							</div>
							<div class="col-sm-3">
							</div>
						</div>
						
						
						<div class="form-group row">
							<label class="control-label col-sm-3 text-right font-weight-bold" for="email">Email : </label>
							<div class="col-sm-6 input-group">
								<div class="input-group input-group-prepend">
									<span class="input-group-text  modal-form-field-prepend-span" id="email-addon"><i class="fa fa-envelope"></i></span>
								<input type="email" class="form-control modal-form-input" id="email"
									placeholder="Enter Email" aria-describedby="email-addon" name="email">
								</div>
							</div>									
							<div class="col-sm-3">
							</div>
						</div>
						
						<div class="form-group row">
							<label class="control-label col-sm-3 text-right font-weight-bold" for="phone"> Phone Number :</label>
							<div class="col-sm-6  input-group">
								<div class="input-group input-group-prepend">
									<span class="input-group-text  modal-form-field-prepend-span" id="phone-addon"><i class="fa fa-phone-square"></i></span>
									<input type="text" class="form-control modal-form-input" id="phone"
											placeholder="Enter Phone Number"  aria-describedby="phone-addon" name="phone">
								</div>
							</div>
							<div class="col-sm-3">
							</div>
						</div>
						
						<!-- <div class="form-group row">
							<label class="control-label col-sm-3 text-right font-weight-bold" for="candidateReceivedDate">Received Date:</label>
							<div class="col-sm-6  input-group">
								<div class="input-group input-group-append">
					                <input id="candidateReceivedDate" type="text" name="candidateReceivedDate" class="modal-form-input-append date-picker form-control modal-form-input-datepicker" readonly="readonly" aria-describedby="candidateReceivedDate-addon"/>
									<span class="input-group-btn">
										<button type="button" class="btn modal-form-field-prepend-btn" data-toggle="datepicker" data-target-name="candidateReceivedDate">
					                		<span class="fa fa-calendar" id="candidateReceivedDate-addon"></span>
					                	</button>
      								</span>
                				</div>	
							</div>
							<div class="col-sm-3">
							</div>
						</div> -->
						<br>
					</form>			  	
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary cancel"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary save"
							id="saveUserButton">Save</button>
					</div>
				  </div>
			</div>
				<p></p>
			</div>
			
		</div>
	</div>
</div>


<button type="button" class="btn btn-sm btn-primary" id="addNewUserBtn">Add
	New User</button>
<p></p>
<table id="tblUsers"
	class="table table-striped table-bordered dataTable"
	style="width: 100%;">
	<thead>
		<tr>
			<th>UserId</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>UserName</th>
			<th>Password</th>
			<th>Role</th>
			<th>Contact Number</th>
			<th>Email</th>
			<th>UserActive</th>
			<th>Actions</th>
		</tr>
	</thead>
</table>

