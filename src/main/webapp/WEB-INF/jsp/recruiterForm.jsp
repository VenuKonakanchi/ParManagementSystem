<div class="collapse" role="alert" id="recruiterstatusDiv">
	<span id="recruiterstatusMessage"></span>
	<button type="button" class="close" data-hide="alert">&times;</button>
</div>

<div class="modal fade" id="confirmDeleteRecruiter" tabindex="-1"
	role="dialog" aria-labelledby="confirmDeleteModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="confirmModalLabel">Delete
					Confirmation</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p id="confirmDeleteRecruiterModalBody"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary"
					id="recruiter-delete-btn">Delete</button>
				<button type="button" class="btn btn-secondary cancel"
					data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>


<div class="modal fade" id="recruiterModal" tabindex="-1" role="dialog"
	aria-labelledby="recruiterModalTitle" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="collapse" role="alert" id="recruitermodalStatusDiv">
					<span id="recruitermodalStatusMessage"></span>
					<button type="button" class="close" data-hide="alert">&times;</button>
				</div>
				<div class="card modal-card">
					<div class="card-header modal-card-header">
						<h5 class="text-left" id="recruiterModalTitle">Add/Update
							Recruiter</h5>
					</div>
					<div class="card-body">
						<form class="form-horizontal" role="form" id="recruiterForm">
							<div class="form-group row">
								<label
									class="control-label col-sm-3 text-right font-weight-bold"
									for="recruiterName">Name :</label>
								<div class="col-sm-6 input-group  modal-form-input-group">
									<div class="input-group input-group-prepend">
										<span class="input-group-text modal-form-field-prepend-span"
											id="name-addon"><i class="fa fa-pencil"></i></span> <input
											type="text" class="form-control modal-form-input"
											id="recruiterName" placeholder="Enter Recruiter Name"
											name="recruiterName" aria-describedby="name-addon">
									</div>
								</div>
								<div class="col-sm-3"></div>
							</div>

							<div class="form-group row">
								<label
									class="control-label col-sm-3 text-right font-weight-bold"
									for="recruiterPhoneNumber"> Phone Number :</label>
								<div class="col-sm-6  input-group">
									<div class="input-group input-group-prepend">
										<span class="input-group-text  modal-form-field-prepend-span"
											id="phone-addon"><i class="fa fa-phone-square"></i></span> <input
											type="text" class="form-control modal-form-input"
											id="recruiterPhoneNumber" placeholder="Enter Phone Number"
											aria-describedby="phone-addon" name="recruiterPhoneNumber">
									</div>
								</div>
								<div class="col-sm-3"></div>
							</div>

							<div class="form-group row">
								<label
									class="control-label col-sm-3 text-right font-weight-bold"
									for="recruiterEmail">Email : </label>
								<div class="col-sm-6 input-group">
									<div class="input-group input-group-prepend">
										<span class="input-group-text  modal-form-field-prepend-span"
											id="email-addon"><i class="fa fa-envelope"></i></span> <input
											type="email" class="form-control modal-form-input"
											id="recruiterEmail" placeholder="Enter Email"
											aria-describedby="email-addon" name="recruiterEmail">
									</div>
								</div>
								<div class="col-sm-3"></div>
							</div>

							<div class="form-group row">
								<label
									class="control-label col-sm-3 text-right font-weight-bold"
									for="recruiterEmailFlag">Email Notifications :</label>
									
								<div class="col-sm-6 input-group"> 
									<div class="custom-control custom-radio custom-control-inline">
									<input type=radio class="custom-control-input"
										id = "recruiterEmailFlagY" name="recruiterEmailFlag"
										value="true" checked> <label class="custom-control-label"
										for="recruiterEmailFlagY">Yes</label>
									</div>

									<div class="custom-control custom-radio custom-control-inline">
										<input type=radio class="custom-control-input"
											id = "recruiterEmailFlagN" name="recruiterEmailFlag"
											value="false"> <label class="custom-control-label"
											for="recruiterEmailFlagN">No</label>
									</div>
								</div>
								<div class="col-sm-3"></div>
							 </div>
							
					
					<br>
					</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary cancel"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary save"
							id="saveRecruiterButton">Save</button>
					</div>
				</div>
			</div>
			<p></p>
		</div>

	</div>
</div>



<button type="button" class="btn btn-sm btn-primary"
	id="addNewRecruiterBtn">Add New Recruiter</button>
<p></p>
<table id="tblRecruiters"
	class="table table-striped table-bordered dataTable"
	style="width: 100%;">
	<thead>
		<tr>
			<th>recruiterId</th>
			<th>Recruiter Name</th>
			<th>Phone Number</th>
			<th>Email ID</th>
			<th>Email Notification</th>
			<th>recruiterActive</th>
			<th>Actions</th>
			<!-- <th></th> -->
		</tr>
	</thead>
</table>

