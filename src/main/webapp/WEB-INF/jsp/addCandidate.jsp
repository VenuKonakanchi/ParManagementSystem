<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <script> 
  $(document).ready(function() {
    $('#example1').DataTable( {
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
  <h3>Add Candidate</h3>
  <form class="form-horizontal" action="/action_page.php">
    <div class="form-group">
      <label class="control-label col-sm-2" for="recruiterName">Candidate Name:</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="recuiterName" placeholder="Enter Candidate name" name="recruiterName">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Recruiter Name:</label>
      <div class="col-sm-4">
	      	<select class="form-control" id="organizationId" name="organizationId" tabindex="28">
				<option value="">Select</option>
				<option value="HTC">HTC Global Services Inc</option>
				<option value="CIBER">CIBER</option>
				<option value="CareTech">CareTech</option>
			</select>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="recruiterPhone">Date Received:</label>
      <div class="col-sm-4">          
        <input type="date" class="form-control" id="recruiterPhone" placeholder="Enter Date Received" name="recruiterPhone">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary">Save</button>
      </div>
    </div>
<table id="example1" class="display" >
        <thead style="background-color: #007fff">
            <tr>
                <th ></th>
                <th>Candidate Name</th>
                <th>Recruiter Name</th>
                <th>Date Received</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td></td>
                <td>Tiger Nixon</td>
                <td>HTC Global Services</td>
                <td>01-01-2019</td>
            </tr>
            <tr>
                <td></td>
                <td>Garrett Winters</td>
                <td>HTC Global Services</td>
                <td>01-01-2019</td>
            </tr>
            <tr>
                <td></td>
                <td>Ashton Cox</td>
                <td>HTC Global Services</td>
                <td>01-01-2019</td>
            </tr>
            <tr>
                <td></td>
                <td>Cedric Kelly</td>
               <td>HTC Global Services</td>
                <td>01-01-2019</td>
            </tr>
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
</html>