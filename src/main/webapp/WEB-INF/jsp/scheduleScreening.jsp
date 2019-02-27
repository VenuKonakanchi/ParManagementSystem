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
	<button type="button" class="btn btn-sm btn-primary" id="addNewPreScreenerBtn">Add New Pre-Screener</button><p ></p>
	<table id="tblPreScreeners"
		class="table table-striped table-bordered dataTable" style="width: 100%;">
		<thead>
			<tr>
				<th>preScreenerId</th>
				<th>PreScreener Name</th>
				<th>preScreener PhoneNumber</th>
				<th>preScreener Active</th>
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
	                <p>Are you sure, you want to delete?</p>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-primary" id="delete-btn">Delete</button>
	                <button type="button" class="btn btn-secondary cancel" data-dismiss="modal">Close</button>
	            </div>
	        </div>
	    </div>
	</div>
                   
  <br><br>

	<div class="modal fade" id="preScreenerModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title text-left" id="exampleModalLongTitle">Add/Update PreScreener</h3>
	      </div>
	      <div class="modal-body">
	      <p></p>
		  <div class="collapse" role="alert" id="modalStatusDiv">
			  <span id="modalStatusMessage"></span>
			  <button type="button" class="close" data-hide="alert">&times;</button>
		  </div>
		  <form class="form-horizontal"  role="form" id="preScreenerForm">
		    <div class="form-group">
		    	<input type="hidden" id="rowIndex" name="rowIndex" value="">
		      <label class="control-label col-sm-3" for="preScreenerName">PreScreener Name:</label>
		      <div class="col-sm-6">
		        <input type="text" class="form-control" id="preScreenerName" placeholder="Enter PreScreener Name" name="preScreenerName">
		      </div>
		      <div class="col-sm-3"></div>
		    </div>
		    <div class="form-group">
		    	<input type="hidden" id="rowIndex" name="rowIndex" value="">
		      <label class="control-label col-sm-3" for="preScreenerPhoneNumber">PreScreener Phone Number:</label>
		      <div class="col-sm-6">
		        <input type="text" class="form-control" id="preScreenerPhoneNumber" placeholder="Enter PreScreener Phone Number" name="preScreenerPhoneNumber">
		      </div>
		      <div class="col-sm-3"></div>
		    </div>
		    <br>    
		  </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary cancel" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary save" id="savePreScreenerButton">Save</button>
	      </div>
	    </div>
	  </div>
 </div>








<!-- ****** Below is the initial screen content ********* 
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <script> 
  $(document).ready(function() {
    $('#example2').DataTable( {
        columnDefs: [ {
            orderable: false,
            className: 'select-checkbox',
            targets:   0
        } ],
        select: {
            style:    'os',
            selector: 'td:first-child'
        },
        order: [[ 1, 'asc' ]]
    } );
} );
  </script>
</head>
<body>
<div class="container" style="width:1100px;">
<table id="example2" class="display" >
        <thead >
            <tr>
                <th></th>
                <th>Candidate Name</th>
                <th>Pre-Screener Name</th>
                <th>Date of Pre-Screening</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td></td>
                <td>Tiger Nixon</td>
                <td>Ramesh Babu</td>
                <td>01-01-2019</td>
            </tr>
            <tr>
                <td></td>
                <td>Garrett Winters</td>
                <td>Kranthi Kumar</td>
                <td>01-01-2019</td>
            </tr>
            <tr>
                <td></td>
                <td>Ashton Cox</td>
                <td>Anish Kumar</td>
                <td>01-01-2019</td>
            </tr>
            <tr>
                <td></td>
                <td>Cedric Kelly</td>
               <td>Prabhakar</td>
                <td>01-01-2019</td>
            </tr>
        </tbody>
    </table>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="button" class="btn btn-primary">Edit</button>
        <button type="button" class="btn btn-primary">Save</button>
      </div>
    </div>               
</div>

</body>
</html>
 -->