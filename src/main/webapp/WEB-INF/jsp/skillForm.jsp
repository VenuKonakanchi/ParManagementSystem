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
  <h3>Skill Information</h3><br>
  <form class="form-horizontal" action="/action_page.php">
    <!-- <div class="form-group">
      <label class="control-label col-sm-2" for="skillId">Skill Id:</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="skillId" placeholder="Enter Skill ID" name="skillId">
      </div>
    </div> -->
    <div class="form-group">
      <label class="control-label col-sm-2" for="skillName">Skill Name:</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="skillName" placeholder="Enter Skill Name" name="skillName">
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
                <th>Skill Name</th>                
            </tr>
        </thead>
        <tbody>
            <tr>
                <td></td>
                <td>Mainframe</td>
            </tr>
            <tr>
                <td></td>
                <td>Java</td>
            </tr>
            <tr>
                <td></td>
                <td>Dot Net</td>
            </tr>
            <tr>
                <td></td>
                <td>Inforamatica</td>
            </tr>
            <tr>
                <td></td>
                <td>Hadoop</td>
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
