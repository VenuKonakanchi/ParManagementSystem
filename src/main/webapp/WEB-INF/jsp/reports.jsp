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
	  
    $('#reportsTable').DataTable( {
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
  
  
  function showResults(){
	 document.getElementById("reportsDiv").style.display="block";
  }
  function hideResults(){
	 document.getElementById("reportsDiv").style.display="none";
  }
  </script>
</head>
<body onload="hideResults();">
<%@include file="header.jsp" %>
<div class="container" >
  <h3>Reports</h3>
  <form class="form-horizontal" action="">
  
  <br>
    
        <div class="form-group">
     		 <label class="control-label col-sm-2" for="candidateSkillset">PAR Start Date:</label>
		      <div class="col-sm-3">          
		       			<input type="date" class="form-control" >
		      </div>
		      <div class="form-group">
			      <label class="control-label col-sm-2" for="candidateExperience">PAR End Date:</label>
			      <div class="col-sm-3">          
			        <input type="date" class="form-control" >
			      </div>
		    </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="button" class="btn btn-primary" onclick="showResults();">Search</button>
      </div>
    </div>
    
    <br>
    
    <div id="reportsDiv">
    <div style="text-align: right;padding-right: 15px;">
           		<a id="excelBtn" href="#"  style="cursor: pointer;"><img src="static/app/images/excel.gif" title="Export To Excel" alt="Export To Excel"></a>
           	</div>
<table id="reportsTable" class="display" style="width:100%;">
        <thead>
            <tr>
                <th></th>
                <th>PAR No</th>
                <th>Date Received</th>
                <th>ES Name</th>
                <th>Role</th>
                <th>Skillset</th>
                <th>Area</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
                                                <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
                                    <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
                                    <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>
            <tr>
                <td></td>
                <td>PAR12345</td>
                <td>01-01-2019</td>
                <td>Bala Kumar</td>
                <td>Developer</td>
                <td>Java</td>
                <td>GFS</td>
            </tr>            
        </tbody>
    </table>
       </div>           
  </form>
</div>

</body>
</html>
