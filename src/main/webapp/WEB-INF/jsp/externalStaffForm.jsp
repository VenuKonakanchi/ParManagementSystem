<div class="collapse" role="alert" id="extStaffStatusDiv">
  <span id="extStaffStatusMessage"></span>
  <button type="button" class="close" data-hide="alert">&times;</button>
 </div>
<!--   <div class="alert alert-error collapse" role="alert" id="statusDiv">
	  <span id="statusMessage">
	  	<p ></p>
	  </span>
	   <button type="button" class="close" data-hide="alert">&times;</button>
</div> -->
	<button type="button" class="btn btn-sm btn-primary" id="addNewExtStaffBtn">Add External Staff</button><p ></p>
	<table id="tblExtStaffs"
		class="table table-striped table-bordered dataTable" 
		style="width: 100%;">
		<thead>
			<tr>
				<th>External Staff Id</th>
				<th>External Staff Name</th>
				<th>External Staff Area</th>
				<th>External Staff Active</th>
				<th>Actions</th>
			</tr>
		</thead>
	</table>

	<div class="modal fade" id="extStaffDeleteConfirm" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg"  role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="confirmModalLabel">Delete Confirmation</h5>
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            			<span aria-hidden="true">&times;</span>
          			</button>
	            </div>
	            <div class="modal-body">
	                <p id="extStaffDeleteConfirmModalBody"></p>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-primary" id="ext-staff-delete-btn">Delete</button>
	                <button type="button" class="btn btn-secondary cancel" data-dismiss="modal">Cancel</button>
	            </div>
	        </div>
	    </div>
	</div>
                   
  <br><br>

	<div class="modal fade" id="extStaffModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title text-left" id="extStaffModalTitle">Add/Update External Staff</h3>
	      </div>
	      <div class="modal-body">
	      <p></p>
		  <div class="collapse" role="alert" id="extStaffModalStatusDiv">
			  <span id="extStaffModalStatusMessage"></span>
			  <button type="button" class="close" data-hide="alert">&times;</button>
		  </div>
		  <form class="form-horizontal"  role="form" id="extStaffForm">
		    <div class="form-group row">
		    	<input type="hidden" id="rowIndex" name="rowIndex" value="">
		      	<label class="control-label col-sm-3" for="extStaffName">External Staff Name:</label>
		      	<div class="col-sm-6">
		       		 <input type="text" class="form-control" id="extStaffName" placeholder=" " name="extStaffName">
		     	</div>
		     	
		     	</div>
		     	
		     	<div class="form-group row">
		        <label class="control-label col-sm-3" for="extStaffAreaSelect">Select Area :</label>
						<div class="col-sm-6">
							<select  class="form-control" id="extStaffAreaSelect" name="extStaffAreaSelect">
							
							</select>
						</div>
				</div>
		   
		    <br>    
		  </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary cancel" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary save" id="saveExtStaffButton">Save</button>
          </div>
      </div>
    </div>
 </div>
 
 