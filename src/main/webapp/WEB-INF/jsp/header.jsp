<input type="hidden" id="contextPath" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-inverse navbar-light bg-light">
<!--    <a class="navbar-brand" href="#" style="margin-top:-0.6em;">
    <img src="static/app/images/PAR_HTC_LOGO.png" width="40" height="40" class="d-inline-block align-top" alt="">
  </a> --> 
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#" style="color:#007fff">PAR <I>FULFILLMENT</I></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active" style="font-weight: bold;"><a href="">Home</a></li>
      <li class="dropdown" ><a class="dropdown-toggle" data-toggle="dropdown" href="#">Masters<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="areaForm">Area</a></li>
          <li><a href="candidateMaster">Candidate Master</a></li>
          <li><a href="candidateRole"> Role Information</a></li>
          <li><a href="externalStaffingInfoForm">External Staffing Info</a></li>
          <li><a href="preScreener">Pre-Screener(s)</a></li>
          <li><a href="recruiterForm">Recruiter(s)</a></li>
          <li><a href="skillForm">Skills</a></li>
          <li><a href="userForm">User</a></li>
        </ul>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">PAR Fulfillment<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="parForm">PAR Form</a></li>
          <li><a href="intentToFill">Intent to Fill</a></li>
          <li><a href="parProcess">PAR Process</a></li>
        </ul>
      </li>
      <li><a href="reports">Reports</a></li>
    </ul>
        <ul class="nav navbar-nav navbar-right">
      <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
    </ul>
  </div>
</nav>
