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
			<div class="modal-header">
				<h3 class="modal-title text-left" id="candidateModalLongTitle">Add/Update Candidate</h3>
			</div>
			<div class="modal-body">
				<p></p>
				<div class="collapse" role="alert" id="candidateModalStatusDiv">
					<span id="candidateModalStatusMessage"></span>
					<button type="button" class="close" data-hide="alert">&times;</button>
				</div>
				<form class="form-horizontal" role="form" id="candidateForm">
						<div class="form-group row">
						<input type="hidden" id="rowIndex" name="rowIndex" value="">
						<label class="control-label col-sm-2" for="candidateName">Name :</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="candidateName"	placeholder="Enter Candidate Name" name="candidateName">
						</div>
						<label class="control-label col-sm-3" for="candidatePhoneNumber"> Phone Number :</label>
						<div class="col-sm-3">
						<input type="text" class="form-control" id="candidatePhoneNumber"
								placeholder="Enter Phone Number" name="candidatePhoneNumber">
						</div>
						</div>
						
<!-- 					<div class="form-group row">
						<label class="control-label col-sm-3" for="candidatePhoneNumber"> Candidate Phone Number :</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="candidatePhoneNumber"
								placeholder="Enter Phone Number" name="candidatePhoneNumber">
						</div>
						<div class="col-sm-6"></div>
					</div> -->
					
					
					<div class="form-group row">
						<label class="control-label col-sm-2" for="candidateEmail">Email : </label>
						<div class="col-sm-4">
							<input type="email" class="form-control" id="candidateEmail"
								placeholder="Enter Email" name="candidateEmail">
						</div>
						<label class="control-label col-sm-2" for="candidateSkillSelect">Primary Skill :</label>
						<div class="col-sm-4">
							<select  class="form-control" id="candidateSkillSelect"></select>
						</div>
					</div>
<!-- 					<div class="form-group row">
						<label class="control-label col-sm-3" for="candidateSkillSelect">Select	Candidate Primary Skill :</label>
						<div class="col-sm-3">
							<select  class="form-control" id="candidateSkillSelect"></select>
						</div>
						<div class="col-sm-6"></div>
					</div> -->
					<br>
				</form>
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary cancel"
					data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary save"
					id="saveCandidateButton">Save</button>
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
			<th>Candidate Phone Number</th>
			<th>Candidate Email</th>
			<th>Candidate Active</th>
			<th>Skill</th>
			<th>Actions</th>
		</tr>
	</thead>
</table>

