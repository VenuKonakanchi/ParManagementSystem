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
<!-- <script type="text/javascript" src="static/framework/js/area.js"></script> --> 
  
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
  <h3>Add Area</h3><br>
  <form class="form-horizontal" action="/action_page.php">
    <div class="form-group">
      <label class="control-label col-sm-2" for="areaId">AreaID:</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="areaIdtxt" placeholder="Enter area id" name="areaid">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="areaName">AreaName:</label>
      <div class="col-sm-4">
        <input type="email" class="form-control" id="areaNametxt" placeholder="Enter area name" name="areaName">
      </div>
    </div>

    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary">Save</button>
        <button type="submit" id="areaRetrievebtn" class="btn btn-primary">Retrieve</button>
      </div>
    </div>
    <br><br>
    
<table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th></th>
                <th>AreaID</th>
                <th>Area</th>
            </tr>
        </thead>
         <tbody>
            <tr>
                <td></td>
                <td>0001</td>
                <td>Property and Casualty</td>
            </tr>
            <tr>
                <td></td>
				 <td>0002</td>
                <td>General Financial Services</td>

            </tr>
            <tr>
                <td></td>
                <td>0003</td>
                <td>Data Information Strategy</td>
            </tr>
            <tr>
                <td></td>
                <td>0002</td>
                <td>Customer Communication</td>
            </tr>
        </tbody>
        
    </table>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="button" class="btn btn-default">Edit</button>
        <button type="button" class="btn btn-default">Delete</button>
      </div>
    </div>               
  </form>
</div>


<!--  data table -->
<div id="areadiv">
            <div id="demo_jui">
                <table id="areatab" class="display">
                    <thead>
                        <tr>
                            <th>areaId</th>
                            <th>areaName</th>
                        </tr>
                    </thead>
 
                </table>
         </div>
</div> 

</body>
</html>
