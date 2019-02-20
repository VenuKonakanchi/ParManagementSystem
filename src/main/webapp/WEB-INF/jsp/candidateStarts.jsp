<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <script> 
  $(document).ready(function() {
    $('#example400').DataTable( {
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
<table id="example400" class="display" >
        <thead >
            <tr>
                <th></th>
                <th>Candidate Name</th>
                <th>Actual Start Date</th>
                <th>Started (Y/N)</th>
                <th>Start Date</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td></td>
                <td>Tiger Nixon</td>
				<td>01-01-2019</td>
				<td>Y</td>
				<td>01-01-2019</td>
            </tr>
            <tr>
                <td></td>
                <td>Garrett Winters</td>
				<td>01-01-2019</td>
				<td>Y</td>
				<td>01-01-2019</td>
            </tr>
            <tr>
                <td></td>
                <td>Ashton Cox</td>
				<td>01-01-2019</td>
				<td>Y</td>
				<td>01-01-2019</td>
            </tr>
            <tr>
                <td></td>
                <td>Cedric Kelly</td>
				<td>01-01-2019</td>
				<td>Y</td>
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
