<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>PAR Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/select/1.2.7/css/select.dataTables.min.css">
  
  
  
  
  
    <link rel="stylesheet" href="static/framework/css/jquery-ui.css">
  <link rel="stylesheet" href="static/app/css/style.css">
   <link rel="stylesheet" href="static/app/css/par.css">
  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/select/1.2.7/js/dataTables.select.min.js"></script>
  
  
  
 
  <script src="static/framework/js/jquery-ui.js"></script>
  <script>
  
  $(document).ready(function() {
	  $( "#tabs" ).tabs();
	    
	} );
  </script>
  <style>
  .ui-widget-header{
  	 border: none;
  	 background: none;
  }
  .ui-widget.ui-widget-content {
     border: none;
}
.ui-widget-content {
    border: none; 
}
  </style>
</head>
<body>
<%@include file="header.jsp" %>

<div class="container" >
	<h3 align="center">PAR Details</h3>
  <form class="form-horizontal" action="/action_page.php">
  
  <br>
    
        <div class="form-group">
     		 <label class="control-label col-sm-2" for="candidateSkillset">PAR No:</label>
		      <div class="col-sm-4">          
        			<input type="text" class="form-control" id="customerId" name="customerId"  value="" >
		      </div>
		      <div class="form-group">
			      <label class="control-label col-sm-2" for="candidateExperience">Date PAR Received:</label>
			      <div class="col-sm-3">          
			        <input type="date" class="form-control" readonly="readonly" id="candidateExperience" placeholder="Enter Date When PAR Received" name="candidateExperience">
			        <span id="candidateExperiencemsg"></span>
			      </div>
		    </div>
    </div>
    <div class="form-group">
     		 <label class="control-label col-sm-2" for="candidateSkillset">Skill:</label>
		      <div class="col-sm-4">          
		       			<select class="form-control" id="candidateSkillset" readonly="readonly"
						name="candidateSkillset">
						<option value="0">Select Skill</option>
						<option value="1">Java</option>
						<option value="2">DBA</option>
						<option value="4">DEVOPS</option>
						<option value="5">Mainframe</option>
					</select>
					<span id="candidateSkillsetmsg"></span>
		      </div>
		      <div class="form-group">
			      <label class="control-label col-sm-2" for="candidateExperience">ES Name:</label>
			      <div class="col-sm-3">          
			        <input type="number" readonly="readonly" class="form-control" id="candidateExperience" placeholder="Enter ES Name" name="candidateExperience">
			        <span id="candidateExperiencemsg"></span>
			      </div>
		    </div>
    </div>
    <div class="form-group">
     		 <label class="control-label col-sm-2" for="candidateSkillset">Role:</label>
		      <div class="col-sm-4">          
		       			<select class="form-control" id="candidateSkillset" readonly="readonly"
						name="candidateSkillset">
						<option value="0">Select Role</option>
						<option value="1">Java</option>
						<option value="2">DBA</option>
						<option value="4">DEVOPS</option>
						<option value="5">Mainframe</option>
					</select>
					<span id="candidateSkillsetmsg"></span>
		      </div>
		      <div class="form-group">
			      <label class="control-label col-sm-2" for="candidateExperience">Area / Product:</label>
			      <div class="col-sm-3">          
			        <select class="form-control" id="candidateSkillset" readonly="readonly"
						name="candidateSkillset">
						<option value="0">Select Area</option>
						<option value="1">Java</option>
						<option value="2">DBA</option>
						<option value="4">DEVOPS</option>
						<option value="5">Mainframe</option>
					</select>
			      </div>
		    </div>
    </div>
    <div class="form-group">
     		 <label class="control-label col-sm-2" for="candidateSkillset">PAR Description:</label>
		      <div class="col-sm-4">          
		       			<textarea rows="4" cols="48" disabled="disabled">PAR description should go here.....</textarea>
		      </div>
		      <div class="form-group">
			      <label class="control-label col-sm-2" for="candidateExperience">Active PAR (Y/N):</label>
			      <div class="col-sm-3">          
			        <input type="checkbox" class="custom-control-input" id="defaultUnchecked" disabled="disabled" checked="checked">
			      </div>
		    </div>
    </div>
    
    
    
   


  </form>

	


  


		
		
<div id="tabs" style="">
  <ul>
    <li><a href="#tabs-1">Add Candidate</a></li>
    <li><a href="#tabs-2">Schedule Screening</a></li>
    <li><a href="#tabs-3">Screening Result</a></li>
	<li><a href="#tabs-4">Submit Candidate</a></li>
	<li><a href="#tabs-5">Offer Received</a></li>
    <li><a href="#tabs-6">Setup submitted</a></li>
    <li><a href="#tabs-7">Candidate Starts</a></li>

  </ul>
  <div id="tabs-1" style="border:1px solid black;">
    <%@include file="addCandidate.jsp" %>
  </div>
  <div id="tabs-2" style="border:1px solid black;">
    <%@include file="scheduleScreening.jsp" %>
  </div>
  <div id="tabs-3" style="border:1px solid black;">
   <%@include file="screeningResults.jsp" %>
  </div>
  <div id="tabs-4" style="border:1px solid black;">
   <%@include file="submitCandidate.jsp" %>
  </div>
  <div id="tabs-5" style="border:1px solid black;">
   <%@include file="offerReceived.jsp" %>
  </div>
  <div id="tabs-6" style="border:1px solid black;">
   <%@include file="setupSubmitted.jsp" %>
  </div>
  <div id="tabs-7" style="border:1px solid black;">
   <%@include file="candidateStarts.jsp" %>
  </div>
</div>
 
 
 
 
 
 
 </div>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 <div class="container" >
  
</div>
</body>
</html>