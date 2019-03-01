    <div class="alert alert-error collapse" role="alert" id="candRoleStatusDiv">
	  <span id="candRoleStatusMessage">
	  	<!-- <p ></p> -->
	  </span>
	   <button type="button" class="close" data-hide="alert">&times;</button>
</div>
	<button type="button" class="btn btn-sm btn-primary" id="addNewCandRoleBtn">Add New Role</button><p ></p>
	<table id="tblCandRoles"
		class="table table-striped table-bordered dataTable" style="width: 100%;">
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
   
	<div class="modal fade" id="candRoleDeleteConfirmModal" tabindex="-1" role="dialog" aria-labelledby="candidateDeleteConfirmLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg"  role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="candidateDeleteConfirmLabel">Delete Confirmation</h5>
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            			<span aria-hidden="true">&times;</span>
          			</button>
	            </div>
	            <div class="modal-body">
	                <p>Are you sure you, want to delete?</p>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-primary" id="candRoledelete-btn">Delete</button>
	                <button type="button" class="btn btn-secondary cancel" data-dismiss="modal">Close</button>
	            </div>
	        </div>
	    </div>
	</div>
                   
  <br><br>

	<div class="modal fade" id="candRoleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title text-left" id="exampleModalLongTitle">Add/Update Role</h3>
	      </div>
	      <div class="modal-body">
	      <p></p>
		  <div class="collapse" role="alert" id="candRoleModalStatusDiv">
			  <span id="candRoleModalStatusMessage"></span>
			  <button type="button" class="close" data-hide="alert">&times;</button>
		  </div>
		  <form class="form-horizontal"  role="form" id="candRoleForm">
		    <div class="form-group">
		    	<input type="hidden" id="rowIndex" name="rowIndex" value="">
		      <label class="control-label col-sm-3" for="roleName">Role Name:</label>
		      <div class="col-sm-6">
		        <input type="text" class="form-control" id="roleName" placeholder="Enter Role Name" name="roleName">
		      </div>
		      <div class="col-sm-3"></div>
		    </div>
		    <br>    
		  </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary cancel" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary save" id="saveCandRoleButton">Save</button>
	      </div>
	    </div>
	  </div>
 </div>