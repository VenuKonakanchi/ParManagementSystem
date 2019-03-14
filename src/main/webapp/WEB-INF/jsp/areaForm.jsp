<div class="collapse" role="alert" id="areaStatusDiv">
	<span id="areaStatusMessage"></span>
	<button type="button" class="close" data-hide="alert">&times;</button>
</div>


<button type="button" class="btn btn-sm btn-primary" id="addNewAreaBtn">Add
	New Area</button>
<p></p>
<table id="tblAreas"
	class="table table-striped table-bordered dataTable"
	style="width: 100%;">
	<thead>
		<tr>
			<th>areaId</th>
			<th>Area Name</th>
			<th>areaActive</th>
			<th>Actions</th>
			<!-- <th></th> -->
		</tr>
	</thead>
</table>


<div class="modal fade" id="areaDeleteconfirmModal" tabindex="-1"
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
				<p id="areaDeleteconfirmModalBody">Are you sure you, want to
					delete?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="areaDelete-btn">Delete</button>
				<button type="button" class="btn btn-secondary cancel"
					data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<br>
<br>


<div class="modal fade" id="areaModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="collapse" role="alert" id="areaModalStatusDiv">
					<span id="areaModalStatusMessage"></span>
					<button type="button" class="close" data-hide="alert">&times;</button>
				</div>
				<div class="card modal-card">
					<div class="card-header modal-card-header">
						<h5 class="text-left" id="areaModalTitle">Add/Update Area</h5>
					</div>
					<div class="card-body">
						<form class="form-horizontal" role="form" id="areaForm">
							<input type="hidden" id="rowIndex" name="rowIndex" value="">
							<div class="form-group row">
								<label
									class="control-label col-sm-3 text-right font-weight-bold"
									for="areaName">Area Name:</label>
								<div class="col-sm-6 input-group  modal-form-input-group">
									<div class="input-group input-group-prepend">
										<span class="input-group-text modal-form-field-prepend-span"
											id="name-addon"><i class="fa fa-pencil"></i></span> <input
											type="text" class="form-control modal-form-input"
											id="areaName" placeholder="Enter Area Name" name="areaName"
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
								id="saveAreaButton">Save</button>
						</div>
					</div>
				</div>
				<p></p>
			</div>
		</div>
	</div>
</div>