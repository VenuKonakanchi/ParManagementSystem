<div class="collapse" role="alert" id="parMasterStatusDiv">
  <span id="parMasterStatusMessage"></span>
  <button type="button" class="close" data-hide="alert">&times;</button>
 </div>
		  
  
	<button type="button" class="btn btn-sm btn-primary" id="addNewParMasterBtn">Add/Get Par Master</button><p ></p>
	<table id="tblParMasters"
		class="table table-striped table-bordered dataTable" style="width: 100%;">
		<thead>
			<tr>
				
				<th>ParNumber</th>
				<th>ParReceivedDate</th>
				<th>Skill</th>
				<th>ExternalStaff</th>
				<th>ParRole</th>
				<th>Area</th>
				<th>ParDescriptionText</th>
				<th>ParStatus</th>
				
			</tr>
		</thead>
	</table>
   
	<div class="modal fade" id="parMasterconfirm" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg"  role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="confirmModalLabel">Delete Confirmation</h5>
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            			<span aria-hidden="true">&times;</span>
          			</button>
	            </div>
	            <div class="modal-body">
	                <p>Are you sure, you want to delete?</p>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-primary" id="parMasterDelete-btn">Delete</button>
	                <button type="button" class="btn btn-secondary cancel" data-dismiss="modal">Close</button>
	            </div>
	        </div>
	    </div>
	</div>
                   
  <br><br>

	<div class="modal fade" id="parMasterModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title text-left" id="exampleModalLongTitle">Add/Update Par Master</h3>
	      </div>
	      <div class="modal-body">
	      <p></p>
		  <div class="collapse" role="alert" id="ParMasterModalStatusDiv">
			  <span id="parMasterModalStatusMessage"></span>
			  <button type="button" class="close" data-hide="alert">&times;</button>
		  </div>
		  <form class="form-horizontal"  role="form" id="parMasterForm">
		    
		     <div class="form-group">
		   		<input type="hidden" id="rowIndex" name="rowIndex" value="">
		      <label class="control-label col-sm-3" for="parNumber">Par Number:</label>
		      <div class="col-sm-6">
		        <input type="text" class="form-control" id="parNumber" placeholder=" " name="parNumber">
		      </div>
		      <div class="col-sm-3"></div>
		    </div>
		    
		    <div class="form-group">
		   		<input type="hidden" id="rowIndex" name="rowIndex" value="">
		      <label class="control-label col-sm-3" for="externalStaff">External Staff:</label>
		      <div class="col-sm-6">
		        <input type="text" class="form-control" id="externalStaff" placeholder=" " name="externalStaff">
		      </div>
		      <div class="col-sm-3"></div>
		    </div>
		    
		    <div class="form-group">
		    	<input type="hidden" id="rowIndex" name="rowIndex" value="">
		      <label class="control-label col-sm-6" for="parReceivedDate">Par Received Date:</label>
		      <div class="col-sm-6">
		        <input type="text" class="form-control" id="parReceivedDate" placeholder=" " name="parReceivedDate">
		      </div>
		      <div class="col-sm-3"></div>
		    </div>
		    
		    <div class="form-group">
		    	<input type="hidden" id="rowIndex" name="rowIndex" value="">
		      <label class="control-label col-sm-6" for="parStatus">Par Status:</label>
		      <div class="col-sm-6">
		        <input type="text" class="form-control" id="parStatus" placeholder=" " name="parStatus">
		      </div>
		      <div class="col-sm-3"></div>
		    </div>
		    
		    <div class="form-group">
		    	<input type="hidden" id="rowIndex" name="rowIndex" value="">
		      <label class="control-label col-sm-6" for="area">Par Area:</label>
		      <div class="col-sm-6">
		        <input type="text" class="form-control" id="area" placeholder=" " name="area">
		      </div>
		      <div class="col-sm-3"></div>
		    </div>
		    
		    <div class="form-group">
		    	<input type="hidden" id="rowIndex" name="rowIndex" value="">
		      <label class="control-label col-sm-6" for="parRole">Par Role:</label>
		      <div class="col-sm-6">
		        <input type="text" class="form-control" id="parRole" placeholder=" " name="parRole">
		      </div>
		      <div class="col-sm-3"></div>
		    </div>
		    
		    <div class="form-group">
		    	<input type="hidden" id="rowIndex" name="rowIndex" value="">
		      <label class="control-label col-sm-6" for="skill">Skill:</label>
		      <div class="col-sm-6">
		        <input type="text" class="form-control" id="skill" placeholder=" " name="skill">
		      </div>
		      <div class="col-sm-3"></div>
		    </div>
		    
		    <div class="form-group">
		    	<input type="hidden" id="rowIndex" name="rowIndex" value="">
		      <label class="control-label col-sm-6" for="parDescriptionText">parDescriptionText:</label>
		      <div class="col-sm-6">
		        <input type="text" class="form-control" id="parDescriptionText" placeholder=" " name="parDescriptionText">
		      </div>
		      <div class="col-sm-3"></div>
		    </div>
		    
		    <br>    
		  </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary cancel" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary save" id="saveParMasterButton">Save</button>
	      </div>
	    </div>
	  </div>
 </div>
