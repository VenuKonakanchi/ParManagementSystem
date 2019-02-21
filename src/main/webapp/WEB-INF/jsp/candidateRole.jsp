<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/select/1.2.7/css/select.dataTables.min.css">
<link rel="stylesheet" href="static/app/css/par.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/select/1.2.7/js/dataTables.select.min.js"></script>
<script>
	$(document).ready(function() {
		$('#example').DataTable({
			columnDefs : [ {
				orderable : false,
				className : 'select-checkbox',
				targets : 0
			} ],
			select : {
				style : 'os',
				selector : 'td:first-child'
			},
			order : [ [ 1, 'asc' ] ]
		});
	});
</script>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<h3>Role Information</h3>
		<form class="form-horizontal" action="/action_page.php">
			<!--     <div class="form-group">
      <label class="control-label col-sm-2" for="candidateName"> Name:</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="candidateName" placeholder="Enter Candidate Name" name="candidateName">
      </div>
    </div> -->
			<div class="form-group">
				<label class="control-label col-sm-2" for="role">Add New
					Role:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="role"
						placeholder="Enter Role name " name="role">
				</div>
			</div>
			<!-- <div class="form-group">
      <label class="control-label col-sm-2" for="experience"> Experience:</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="experie	nce" placeholder="Enter no.of years of Experience" name="">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="candidatePhone">Phone:</label>
      <div class="col-sm-4">          
        <input type="tel" class="form-control" id="candidatePhone" placeholder="Enter Contact Number" name="candidatePhone">
      </div>
    </div> -->
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Save</button>
				</div>
			</div>
			<table id="example" class="display" style="width: 60%">
				<thead>
					<tr>
						<th>Action</th>
						<!--                 <th>Candidate Name: </th> -->
						<th>Roles Available</th>
						<!--                 <th>Years of Experience:</th>
                <th>Phone No:</th> -->
					</tr>
				</thead>
				<tbody>
					<tr>
						<td></td>
						<!--                <td>Satyam</td> -->
						<td>Sr. Java Developer</td>
						<!--                 <td>10 years</td>
                <td>309.100.3333</td> -->
					</tr>
					<tr>
						<td></td>
						<!--                 <td>C Johnson</td> -->
						<td>Manager</td>
						<!-- 				<td>15 years</td>
                <td>309.300.8989</td> -->
					</tr>
					<tr>
						<td></td>
						<!--                 <td>Prakash</td> -->
						<td>Lead Consultant</td>
						<!-- 				<td>11 years</td>
                <td>309.309.1212</td> -->
					</tr>
					<tr>
						<td></td>
						<!--                 <td>Tom Kelly</td> -->
						<td>Java Developer</td>
						<!--                 <td>5 years</td>
                <td>309.222.3699</td> -->
					</tr>
					<tr>
						<td></td>
						<!--                 <td>Kumar Reddy</td> -->
						<td>Sr. Java Developer</td>
						<!--                 <td>11 years</td>
                <td>309.309.2244</td> -->
					</tr>
					<tr>
						<td></td>
						<!--                 <td>Amith Kumar</td> -->
						<td>DB Admin</td>
						<!--                 <td>12 years</td>
                <td>309.123.4333</td> -->
					</tr>
					<tr>
						<td></td>
						<!--                 <td>Steve Johnson</td> -->
						<td>Automation Testing</td>
						<!--                 <td>6 years</td>
                <td>309.123.6765</td> -->
					</tr>
					<tr>
						<td></td>
						<!--                 <td>Grubic Ralley</td> -->
						<td>ETL Developer</td>
						<!--                 <td>5 years</td>
                <td>248.700.7894</td> -->
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
