<div class="collapse" role="alert" id="candRoleStatusDiv">
	<span id="candRoleStatusMessage"></span>
	<button type="button" class="close" data-hide="alert">&times;</button>
</div>

<div class="modal fade" id="candRoleDeleteConfirmModal" tabindex="-1" role="dialog"
	aria-labelledby="candidateDeleteConfirmLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="candidateDeleteConfirmLabel">Delete	Confirmation</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p id="candRoleDeleteConfirmModalBody"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="candRoledelete-btn">Delete</button>
				<button type="button" class="btn btn-secondary cancel"
					data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>


<div class="modal fade" id="candRoleModal" tabindex="-1" role="dialog"
	aria-labelledby="candidateRoleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="collapse" role="alert" id="candRoleModalStatusDiv">
					<span id="candRoleModalStatusMessage"></span>
					<button type="button" class="close" data-hide="alert">&times;</button>
				</div>
				<div class="card modal-card">
				  <div class="card-header modal-card-header">
				    <h5 class="text-left" id="candRoleModalTitle">Add/Update Candidate</h5>
				  </div>
				  <div class="card-body">
					<form class="form-horizontal" role="form" id="candRoleForm">
						<div class="form-group row">
							<label class="control-label col-sm-3 text-right font-weight-bold" for="roleName">Name :</label>
							<div class="col-sm-6 input-group  modal-form-input-group">
								<div class="input-group input-group-prepend">
		    						<span class="input-group-text modal-form-field-prepend-span" id="name-addon"><i class="fa fa-pencil"></i></span>
		    						<input type="text" class="form-control modal-form-input" id="roleName"	placeholder="Enter PAR Role" name="roleName" aria-describedby="name-addon">
								</div>
							</div>
							<div class="col-sm-3">
							</div>
						</div>
						
						<br>
					</form>			  	
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary cancel"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary save"
							id="saveCandRoleButton">Save</button>
					</div>
				  </div>
			</div>
				<p></p>
			</div>
			
		</div>
	</div>
</div>


<button type="button" class="btn btn-sm btn-primary" id="addNewCandRoleBtn">Add New PAR Role</button>
<p></p>
<table id="tblCandRoles"
	class="table table-striped table-bordered dataTable"
	style="width: 100%;">
	<thead>
		<tr>
				<th>roleId</th>
				<th>Role Name</th>
				<th>roleActive</th>
				<th>Actions</th>
				<!-- <th></th> -->
			</tr>
	</thead>
</table>

