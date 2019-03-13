<div class="collapse" role="alert" id="candidateStatusDiv">
	<span id="candidateStatusMessage"></span>
	<button type="button" class="close" data-hide="alert">&times;</button>
</div>

<div class="modal fade" id="candidateDeleteConfirmModal" tabindex="-1" role="dialog"
	aria-labelledby="candidateDeleteconfirmModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="candidateDeleteconfirmModalTitle">Delete	Confirmation</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p id="candidateDeleteConfirmModalBody"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="candidate-delete-btn">Delete</button>
				<button type="button" class="btn btn-secondary cancel"
					data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>


<div class="modal fade" id="candidateModal" tabindex="-1" role="dialog"
	aria-labelledby="candidateModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="collapse" role="alert" id="candidateModalStatusDiv">
					<span id="candidateModalStatusMessage"></span>
					<button type="button" class="close" data-hide="alert">&times;</button>
				</div>
				<div class="card modal-card">
				  <div class="card-header modal-card-header">
				    <h5 class="text-left" id="candidateModalLongTitle">Add/Update Candidate</h5>
				  </div>
				  <div class="card-body">
					<form class="form-horizontal" role="form" id="candidateForm">
						<div class="form-group row">
							<label class="control-label col-sm-3 text-right font-weight-bold" for="candidateName">Name :</label>
							<div class="col-sm-6 input-group  modal-form-input-group">
								<div class="input-group input-group-prepend">
		    						<span class="input-group-text modal-form-field-prepend-span" id="name-addon"><i class="fa fa-pencil"></i></span>
		    						<input type="text" class="form-control modal-form-input" id="candidateName"	placeholder="Enter Candidate Name" name="candidateName" aria-describedby="name-addon">
								</div>
							</div>
							<div class="col-sm-3">
							</div>
						</div>
						
						<div class="form-group row">
							<label class="control-label col-sm-3 text-right font-weight-bold" for="candidatePhoneNumber"> Phone Number :</label>
							<div class="col-sm-6  input-group">
								<div class="input-group input-group-prepend">
									<span class="input-group-text  modal-form-field-prepend-span" id="phone-addon"><i class="fa fa-phone-square"></i></span>
									<input type="text" class="form-control modal-form-input" id="candidatePhoneNumber"
											placeholder="Enter Phone Number"  aria-describedby="phone-addon" name="candidatePhoneNumber">
								</div>
							</div>
							<div class="col-sm-3">
							</div>
						</div>
						
						<div class="form-group row">
							<label class="control-label col-sm-3 text-right font-weight-bold" for="candidateEmail">Email : </label>
							<div class="col-sm-6 input-group">
								<div class="input-group input-group-prepend">
									<span class="input-group-text  modal-form-field-prepend-span" id="email-addon"><i class="fa fa-envelope"></i></span>
								<input type="email" class="form-control modal-form-input" id="candidateEmail"
									placeholder="Enter Email" aria-describedby="email-addon" name="candidateEmail">
								</div>
							</div>									
							<div class="col-sm-3">
							</div>
						</div>
	
						<div class="form-group row">
							<label class="control-label col-sm-3 text-right font-weight-bold" for="candidateRecruiterSelect">Recruiter Name :</label>
							<div class="col-sm-6  input-group">
								<div class="input-group input-group-prepend">
								<span class="input-group-text  modal-form-field-prepend-span" id="recruiter-addon"><i class="fa fa-users"></i></span>
								<select  class="form-control modal-form-input" id="candidateRecruiterSelect" aria-describedby="recruiter-addon" name="candidateRecruiterSelect">
									<option value="">Select Recruiter</option>
								</select>
								</div>	
							</div>
							<div class="col-sm-3">
							</div>
						</div>
						<div class="form-group row">
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
						</div>
						<br>
					</form>			  	
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary cancel"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary save"
							id="saveCandidateButton">Save</button>
					</div>
				  </div>
			</div>
				<p></p>
			</div>
			
		</div>
	</div>
</div>


<button type="button" class="btn btn-sm btn-primary" id="addNewCandidateBtn">Add New Candidate</button>
<p></p>
<table id="tblCandidates"
	class="table table-striped table-bordered dataTable"
	style="width: 100%;">
	<thead>
		<tr>
			<th>Candidate ID</th>
			<th>Candidate Name</th>
			<th>Phone Number</th>
			<th>Email</th>
			<th>Candidate Active</th>
			<th>Recruiter Name</th>
			<th>Candidate Received Date</th>
			<th>Actions</th>
		</tr>
	</thead>
</table>

