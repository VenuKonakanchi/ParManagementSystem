<div class="collapse" role="alert" id="statusSkillDiv">
  <span id="statusSkillMessage"></span>
  <button type="button" class="close" data-hide="alert">&times;</button>
 </div> 
		
	<button type="button" class="btn btn-sm btn-primary" id="addNewSkillBtn">Add New Skill</button><p ></p>
	<table id="tblSkills"
		class="table table-striped table-bordered dataTable" style="width: 100%;">
		<thead>
			<tr>
				<th>skillId</th>
				<th>Skill Name</th>
				<th>skillActive</th>
				<th>Actions</th>
				<!-- <th></th> -->
			</tr>
		</thead>
	</table>
   
	<div class="modal fade" id="confirmSkillDeleteModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg"  role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="confirmModalLabel">Delete Confirmation</h5>
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            			<span aria-hidden="true">&times;</span>
          			</button>
	            </div>
	            <div class="modal-body">
	                <p id="confirmSkillDeleteModalBody"></p>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-primary" id="delete-btn">Delete</button>
	                <button type="button" class="btn btn-secondary cancel" data-dismiss="modal">Close</button>
	            </div>
	        </div>
	    </div>
	</div>
                   
  <br><br>
<div class="modal fade" id="skillModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="collapse" role="alert" id="modalStatusSkillDiv">
					<span id="modalStatusSkillMessage"></span>
					<button type="button" class="close" data-hide="alert">&times;</button>
				</div>
				<div class="card modal-card">
					<div class="card-header modal-card-header">
						<h5 class="text-left" id="skillModalTitle">Add/Update Skill</h5>
					</div>
					<div class="card-body">
						<form class="form-horizontal" role="form" id="skillForm">
							<input type="hidden" id="rowIndex" name="rowIndex" value="">
							<div class="form-group row">
								<label
									class="control-label col-sm-3 text-right font-weight-bold"
									for="skillName">Skill Name:</label>
								<div class="col-sm-6 input-group  modal-form-input-group">
									<div class="input-group input-group-prepend">
										<span class="input-group-text modal-form-field-prepend-span"
											id="name-addon"><i class="fa fa-pencil"></i></span> <input
											type="text" class="form-control modal-form-input"
											id="skillName" placeholder="Enter Skill Name" name="skillName"
											aria-describedby="name-addon">
									</div>
								</div>
								<div class="col-sm-3"></div>
							</div>

							<br>
						</form>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary cancel"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary save"
								id="saveSkillButton">Save</button>
						</div>
					</div>
				</div>
				<p></p>
			</div>
		</div>
	</div>
</div>
	