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
				<th>Pre-Screener ID</th>
				<th>Pre-Screener Name</th>
				<th>Pre-Screener PhoneNumber</th>
				<th>Pre-Screener Active</th>
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





<%--****** Below is the initial screen content ********* 
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/select/1.2.7/css/select.dataTables.min.css">
  <link rel="stylesheet" href="static/app/css/par.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/select/1.2.7/js/dataTables.select.min.js"></script>
  <script> 
  $(document).ready(function() {
    $('#example').DataTable( {
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
<%@include file="header.jsp" %>
<div class="container">
  <h3>Internal Pre-screener Information</h3>

	  <form class="form-horizontal" action="/action_page.php">
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="preScreenerName">Name:</label>
	      <div class="col-sm-4">
	        <input type="text" class="form-control" id="preScreenerName" placeholder="Enter pre-screener name" name="preScreenerName">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="preScreenerEmail">Email:</label>
	      <div class="col-sm-4">
	        <input type="email" class="form-control" id="preScreenerEmail" placeholder="Enter email" name="preScreenerEmail">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="preScreenerPhone">Phone:</label>
	      <div class="col-sm-4">          
	        <input type="tel" class="form-control" id="preScreenerPhone" placeholder="Enter phone no" name="preScreenerPhone">
	      </div>
	    </div>
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-primary" id="submitPrescreenerInfo">Save</button>
	      </div>
	    </div>
		<table id="example" class="display" style="width:100%">
	        <thead>
	            <tr>
	                <th></th>
	                <th>Name Of Pre-Screener</th>
	                <th>Email</th>
	                <th>Contact Number</th>
	            </tr>
	        </thead>
	        <tbody>
	            <tr>
	                <td></td>
	                <td>Tiger Nixon</td>
	                <td>System@gmail.com</td>
	                <td>3091234567</td>
	            </tr>
	            <tr>
	                <td></td>
	                <td>Garrett Winters</td>
	                <td>Accountant@gmail.com</td>
	                <td>3091234567</td>
	            </tr>
	            <tr>
	                <td></td>
	                <td>Ashton Cox</td>
	                <td>Junior@gmail.com</td>
	                <td>3091234567</td>
	            </tr>
	            <tr>
	                <td></td>
	                <td>Cedric Kelly</td>
	                <td>Senior@gmail.com</td>
	                <td>3091234567</td>
	            </tr>
	<!--             <tr>
	                <td></td>
	                <td>Airi Satou</td>
	                <td>Accountant@gmail.com</td>
	                <td>3091234567</td>
	            </tr>
	            <tr>
	                <td></td>
	                <td>Brielle Williamson</td>
	                <td>Integration@gmail.com</td>
	                <td>3091234567</td>
	            </tr>
	            <tr>
	                <td></td>
	                <td>Herrod Chandler</td>
	                <td>Sales@gmail.com</td>
	                <td>3091234567</td>
	            </tr>
	            <tr>
	                <td></td>
	                <td>Rhona Davidson</td>
	                <td>Integration@gmail.com</td>
	                <td>3091234567</td>
	            </tr>
	            <tr>
	                <td></td>
	                <td>Colleen Hurst</td>
	                <td>Javascript@gmail.com</td>
	                <td>3091234567</td>
	            </tr>
	            <tr>
	                <td></td>
	                <td>Sonya Frost</td>
	                <td>Software@gmail.com</td>
	                <td>3091234567</td>
	            </tr>
	            <tr>
	                <td></td>
	                <td>Jena Gaines</td>
	                <td>Flynn@gmail.com</td>
	                <td>3091234567</td>
	            </tr>
	            <tr>
	                <td></td>
	                <td>Quinn Flynn</td>
	                <td>Flynn@gmail.com</td>
	                <td>3091234567</td>
	            </tr> -->
	        </tbody>
	    </table>
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="button" class="btn btn-primary">Edit</button>
	        <button type="button" class="btn btn-primary">Delete</button>
	      </div>
	    </div>               
	  </form>
</div>

</body>
</html> --%>