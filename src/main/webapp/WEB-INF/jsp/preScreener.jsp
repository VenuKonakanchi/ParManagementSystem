<div class="collapse" role="alert" id="preScreenerStatusDiv">
  <span id="preScreenerStatusMessage"></span>
  <button type="button" class="close" data-hide="alert">&times;</button>
 </div>
		  
  
	<button type="button" class="btn btn-sm btn-primary" id="addNewPreScreenerBtn">Add New Pre-Screener</button><p ></p>
	<table id="tblPreScreeners"
		class="table table-striped table-bordered dataTable" style="width: 100%;">
		<thead>
			<tr>
				<th>Pre-Screener ID</th>
				<th>Pre-Screener Name</th>
				<th>Pre-Screener PhoneNumber</th>
				<th>Pre-Screener Active</th>
				<th>Actions</th>
				<!-- <th></th> -->
			</tr>
		</thead>
	</table>
   
	<div class="modal fade" id="preScreenerconfirm" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg"  role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="confirmModalLabel">Delete Confirmation</h5>
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            			<span aria-hidden="true">&times;</span>
          			</button>
	            </div>
	            <div class="modal-body">
	                <p id="preScreenerconfirmModalBody"></p>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-primary" id="preScreenerDelete-btn">Delete</button>
	                <button type="button" class="btn btn-secondary cancel" data-dismiss="modal">Close</button>
	            </div>
	        </div>
	    </div>
	</div>
                   
  <br><br>

	<div class="modal fade" id="preScreenerModal" tabindex="-1" role="dialog"
	aria-labelledby="preScreenerModalTitle" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="collapse" role="alert" id="preScreenerModalStatusDiv">
					<span id="preScreenerModalStatusMessage"></span>
					<button type="button" class="close" data-hide="alert">&times;</button>
				</div>
				<div class="card modal-card">
					<div class="card-header modal-card-header">
						<h5 class="text-left" id="preScreenerModalTitle">Add/Update
							PreScreener</h5>
					</div>
					<div class="card-body">
						<form class="form-horizontal" role="form" id="preScreenerForm">
							<div class="form-group row">
								<label
									class="control-label col-sm-3 text-right font-weight-bold"
									for="preScreenerName"> Name :</label>
								<div class="col-sm-6 input-group  modal-form-input-group">
									<div class="input-group input-group-prepend">
										<span class="input-group-text modal-form-field-prepend-span"
											id="name-addon"><i class="fa fa-pencil"></i></span> <input
											type="text" class="form-control modal-form-input"
											id="preScreenerName" placeholder="Enter PreScreener Name"
											name="preScreenerName" aria-describedby="name-addon">
									</div>
								</div>
								<div class="col-sm-3"></div>
							</div>

							<div class="form-group row">
								<label
									class="control-label col-sm-3 text-right font-weight-bold"
									for="preScreenerPhoneNumber"> Phone Number :</label>
								<div class="col-sm-6  input-group">
									<div class="input-group input-group-prepend">
										<span class="input-group-text  modal-form-field-prepend-span"
											id="phone-addon"><i class="fa fa-phone-square"></i></span> <input
											type="text" class="form-control modal-form-input"
											id="preScreenerPhoneNumber" placeholder="Enter Phone Number"
											aria-describedby="phone-addon" name="preScreenerPhoneNumber">
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
							id="savePreScreenerButton">Save</button>
					</div>
				</div>
			</div>
			<p></p>
		</div>

	</div>
</div>
