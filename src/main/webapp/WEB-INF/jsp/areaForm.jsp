<div class="collapse" role="alert" id="statusDiv">
  <span id="statusMessage"></span>
  <button type="button" class="close" data-hide="alert">&times;</button>
 </div>
		  
  <div class="alert alert-error collapse" role="alert" id="statusDiv">
	  <span id="statusMessage">
	  	<!-- <p ></p> -->
	  </span>
	   <button type="button" class="close" data-hide="alert">&times;</button>
</div>
	<button type="button" class="btn btn-sm btn-primary" id="addNewAreaBtn">Add New Area</button><p ></p>
	<table id="tblAreas"
		class="table table-striped table-bordered dataTable" style="width: 100%;">
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
   
	<div class="modal fade" id="confirm" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg"  role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="confirmModalLabel">Delete Confirmation</h5>
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            			<span aria-hidden="true">&times;</span>
          			</button>
	            </div>
	            <div class="modal-body">
	                <p>Are you sure you, want to delete?</p>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-primary" id="delete-btn">Delete</button>
	                <button type="button" class="btn btn-secondary cancel" data-dismiss="modal">Close</button>
	            </div>
	        </div>
	    </div>
	</div>
                   
  <br><br>

	<div class="modal fade" id="areaModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title text-left" id="exampleModalLongTitle">Add/Update Area</h3>
	      </div>
	      <div class="modal-body">
	      <p></p>
		  <div class="collapse" role="alert" id="modalStatusDiv">
			  <span id="modalStatusMessage"></span>
			  <button type="button" class="close" data-hide="alert">&times;</button>
		  </div>
		  <form class="form-horizontal"  role="form" id="areaForm">
		    <div class="form-group">
		    	<input type="hidden" id="rowIndex" name="rowIndex" value="">
		      <label class="control-label col-sm-3" for="areaName">Area Name:</label>
		      <div class="col-sm-6">
		        <input type="text" class="form-control" id="areaName" placeholder="Enter Area Name" name="areaName">
		      </div>
		      <div class="col-sm-3"></div>
		    </div>
		    <br>    
		  </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary cancel" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary save" id="saveAreaButton">Save</button>
	      </div>
	    </div>
	  </div>
 </div>