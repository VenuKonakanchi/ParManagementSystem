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
  <h3>Add User</h3><br>
  <form class="form-horizontal" action="/action_page.php">
    <div class="form-group">
     		 <label class="control-label col-sm-2" for="candidateSkillset">User Name:</label>
		      <div class="col-sm-4">          
        			<input type="text" class="form-control" id="customerId" name="customerId"  value="" placeholder="Enter User Name">
		      </div>
		      <div class="form-group">
			      <label class="control-label col-sm-2" for="candidateExperience">User Id:</label>
			      <div class="col-sm-3">          
			        <input type="text" class="form-control" id="candidateExperience" placeholder="Enter User Id" name="candidateExperience">
			        <span id="candidateExperiencemsg"></span>
			      </div>
		    </div>
    </div>
    <div class="form-group">
     		 <label class="control-label col-sm-2" for="candidateSkillset">Role:</label>
		      <div class="col-sm-4">          
		       			<select class="form-control" id="candidateSkillset"
						name="candidateSkillset">
						<option value="0">Select Role</option>
						<option value="1">Admin</option>
						<option value="2">User</option>
						<option value="4">Data Entry</option>
					</select>
					<span id="candidateSkillsetmsg"></span>
		      </div>
		      <div class="form-group">
			      <label class="control-label col-sm-2" for="candidateExperience">Contact Number	:</label>
			      <div class="col-sm-3">          
			        <input type="tel" class="form-control" id="candidateExperience" placeholder="Contact Number" name="candidateExperience">
			        <span id="candidateExperiencemsg"></span>
			      </div>
		    </div>
    </div>
    
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary">Save</button>
      </div>
    </div>
          <br>    
  </form>


<table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th></th>
               
 <th>User Name</th> 
  <th>User Id</th> 
   <th>Contact Number</th> 
    <th>Role</th>    
                
            </tr>
        </thead>
        <tbody>
            <tr>
                <td></td>
                               <td>Gautam Karandikar</td>
                <td>Gautam.K</td>
                <td>3091234567</td>
                <td>Manager</td>
            </tr>
            <tr>
                <td></td>
                                <td>Gautam Karandikar</td>
                <td>Gautam.K</td>
                <td>3091234567</td>
                <td>Manager</td>
            </tr>
            <tr>
                <td></td>
                                <td>Gautam Karandikar</td>
                <td>Gautam.K</td>
                <td>3091234567</td>
                <td>Manager</td>
            </tr>
            <tr>
                <td></td>
                                <td>Gautam Karandikar</td>
                <td>Gautam.K</td>
                <td>3091234567</td>
                <td>Manager</td>
            </tr>

        </tbody>
    </table>
   
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="button" class="btn btn-primary">Edit</button>
        <button type="button" class="btn btn-primary">Delete</button>
      </div>
    </div> 
                   
  <br><br>
     </div>

</body>
</html>

