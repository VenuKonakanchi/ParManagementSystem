<div class="collapse" role="alert" id="userStatusDiv">
	<span id="userStatusMessage"></span>
	<button type="button" class="close" data-hide="alert">&times;</button>
</div>

<div class="modal fade" id="userDeleteConfirmModal" tabindex="-1" role="dialog"
	aria-labelledby="userDeleteconfirmModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="userDeleteconfirmModal">Delete
					Confirmation</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>Are you sure you, want to delete the User?</p>
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
			<div class="modal-header">
				<h3 class="modal-title text-left" id="userModalLongTitle">Add/Update
					User</h3>
			</div>
			<div class="modal-body">
				<p></p>
				<div class="collapse" role="alert" id="userModalStatusDiv">
					<span id="userModalStatusMessage"></span>
					<button type="button" class="close" data-hide="alert">&times;</button>
				</div>
				<form class="form-horizontal" role="form" id="userForm">
					<div class="form-group row">
						<input type="hidden" id="rowIndex" name="rowIndex" value="">
						<label class="control-label col-sm-3" for="firstName">First
							Name :</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="firstName"
								placeholder="Enter User First Name" name="firstName">
						</div>
						<label class="control-label col-sm-3" for="LastName">Last
							Name :</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="lastName"
								placeholder="Enter User Last Name" name="lastName">
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-sm-3" for="userName">User
							Name :</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="userName"
								placeholder="Enter User Name/ User ID" name="userName">
						</div>
						<label class="control-label col-sm-3" for="password">Password
							:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="password"
								placeholder="Enter password" name="password">
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-sm-3" for="userRoleSelect">Select
							User Role :</label>
						<div class="col-sm-3">
							<select  class="form-control" id="userRoleSelect">
							
							</select>
						</div>
					</div>

					<div class="form-group row">
						<label class="control-label col-sm-3" for="email">Email :</label>
						<div class="col-sm-3">
							<input type="email" class="form-control" id="email"
								placeholder="Enter User Email" name="email">
						</div>
						<label class="control-label col-sm-3" for="phone">Phone :</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="phone"
								placeholder="Enter Phone Number" name="phone">
						</div>
					</div>
					<br>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary cancel"
					data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary save"
					id="saveUserButton">Save</button>
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

