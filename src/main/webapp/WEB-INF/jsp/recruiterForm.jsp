<div class="alert alert-error collapse" role="alert"
	id="recruiterstatusDiv">
	<span id="recruiterstatusMessage"> <!-- <p ></p> -->
	</span>
	<button type="button" class="close" data-hide="alert">&times;</button>
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

<div class="modal fade" id="confirmrecruiter" tabindex="-1"
	role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
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
				<p id="confirmrecruiterModalBody"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="delete-btn">Delete</button>
				<button type="button" class="btn btn-secondary cancel"
					data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<br>
<br>

<div class="modal fade" id="recruiterModal" tabindex="-1" role="dialog"
	aria-labelledby="recruiterModalTitle" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="modal-title text-left" id="recruiterModalTitle">Add/Update
					Recruiter</h3>
			</div>
			<div class="modal-body">
				<p></p>
				<div class="collapse" role="alert" id="recruitermodalStatusDiv">
					<span id="recruitermodalStatusMessage"></span>
					<button type="button" class="close" data-hide="alert">&times;</button>
				</div>
				<form class="form-horizontal" role="form" id="recruiterForm">
					<div class="form-group">
						<input type="hidden" id="rowIndex" name="rowIndex" value="">
						<label class="control-label col-sm-3" for="recruiterName">Recruiter
							Name:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="recruiterName"
								placeholder="Enter Recruiter Name" name="recruiterName">
						</div>
						<div class="col-sm-3"></div>
					</div>

					<div class="form-group">
						<input type="hidden" id="rowIndex" name="rowIndex" value="">
						<label class="control-label col-sm-3" for="recruiterPhoneNumber">Phone
							Number:</label>
						<div class="col-sm-6">
							<input type="number" class="form-control"
								id="recruiterPhoneNumber"
								placeholder="Enter Recruiter Phone Number"
								name="recruiterPhoneNumber">
						</div>
						<div class="col-sm-3"></div>
					</div>

					<div class="form-group">
						<input type="hidden" id="rowIndex" name="rowIndex" value="">
						<label class="control-label col-sm-3" for="recruiterEmail">Email:</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="recruiterEmail"
								placeholder="Enter Recruiter Email ID" name="recruiterEmail">
						</div>
						<div class="col-sm-3"></div>
					</div>

					<div class="form-group">
						<input type="hidden" id="rowIndex" name="rowIndex" value="">
						<label class="control-label col-sm-3" for="recruiterEmailFlag">Email Notification </label>
						
						<div class="custom-control custom-radio custom-control-inline">
							<input type=radio class="custom-control-input" id="recruiterEmailFlagY" name="recruiterEmailFlag" value="true">
							<label class="custom-control-label" for="recruiterEmailFlagY">Yes</label>
						</div>
						
						<div class="custom-control custom-radio custom-control-inline">
							<input type=radio class="custom-control-input" id="recruiterEmailFlagN" name="recruiterEmailFlag" value ="false">
							<label class="custom-control-label" for="recruiterEmailFlagN">No</label>
						</div>
					</div>
					<div class="col-sm-3"></div>


					<!-- 					<div class="form-group">
						<input type="hidden" id="rowIndex" name="rowIndex" value="">
						<label class="control-label text-left col-sm-3" for="recruiterEmailFlag">Email Notification</label> 
						<div class="col-sm-6">
						
						<select class="input-sm pr-8" id="recruiterEmailFlag" name="recruiterEmailFlag">
							<option value=true> Yes</option>
							<option value= false> No</option>
						</select>
						</div>
					</div> -->

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
</div>