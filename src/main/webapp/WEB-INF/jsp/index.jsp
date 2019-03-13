<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>PAR FULFILLMENT</title>
  <!-- Font Awesome -->
  <link rel="stylesheet" href="static/css/font-awesome.min.css">
  <!-- Bootstrap core CSS -->
  <link href="static/css/bootstrap.min.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <!-- <link href="static/css/mdb.min.css" rel="stylesheet"> -->
  <!-- DataTable css -->
  <link href="static/css/datatables.min.css" rel="stylesheet">
  <!-- Your custom styles (optional) -->
  <link href="static/css/style.css" rel="stylesheet">
</head>

<body>

    <div class="wrapper fixed-sidebar">
        <nav class="navbar navbar-expand fixed-top top-header">
          <div class="container-fluid">
            <div class="navbar-header"><a class="navbar-brand" href="index.html"></a> </div>
            <!-- <div class="page-title"><span>PAR FULFILLMENT</span></div> -->
            <div class="right-navbar">
                <ul class="nav navbar-nav float-right icons-nav">
                    <li class="nav-item"><a class="nav-link toggle-right-sidebar" href="#"><img src="static/img/logout.png" alt="Logout"></a></li>
                </ul>
                <ul class="nav navbar-nav float-right user-nav">
                    <li class="nav-item">
                      <a class="nav-link" href="#">
                        <!-- <img src="static/img/avatar.png" alt="Avatar">
                        <span class="user-name">Túpac Amaru</span> -->

                        <span class="user-avatar user-avatar-md"><img src="static/img/avatar.png" alt="Avatar"></span>
                        <span class="user-summary" style="display: inline-grid;vertical-align: middle;">
                          <span  style="line-height: normal;">Welcome</span>
                          <span class="user-name">Gautam Karandikar</span>
                        </span>
                      </a>
                    </li>
              </ul>
            </div>
          </div>
        </nav>
        <div class="left-sidebar">
          <div class="left-sidebar-wrapper">
            <div class="left-sidebar-spacer">
              <div class="left-sidebar-scroll ps">
                <div class="left-sidebar-content">
                  <ul class="sidebar-elements">
                    <li class="masters active"><a href="index.html"><span>Masters</span></a>
                    </li>
                    <li class="fulfillment"><a href="javascript:void(0);"><span>PAR Fulfillment</span></a>
                    </li>
                    <li class="reports"><a href="javascript:void(0);"><span>Reports</span></a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
            
          </div>
        </div>
        <div class="content">
          <div class="main-content container-fluid">
            <div class="page-title-bar">
                <h3>MASTERS</h3>
            </div>
            <div class="page-section">
                <ul class="nav nav-tabs nav-fill" id="myTab" role="tablist">
                    <li class="nav-item">
                      <a class="nav-link" id="area-product-tab" data-toggle="tab" href="#area-product" role="tab" aria-controls="area-product"
                        aria-selected="false">Area</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="external-staffing-info-tab" data-toggle="tab" href="#external-staffing-info" role="tab" aria-controls="external-staffing-info"
                          aria-selected="false">External Staff</a>
                      </li>
                   
                    <li class="nav-item">
                      <a class="nav-link" id="candidate-role-tab" data-toggle="tab" href="#candidate-role" role="tab" aria-controls="candidate-role"
                        aria-selected="false">PAR Role</a>
                    </li>
                     <li class="nav-item">
                        <a class="nav-link" id="skills-tab" data-toggle="tab" href="#skills" role="tab" aria-controls="skills"
                          aria-selected="false">PAR Skill</a>
                      </li>
                      
                      <li class="nav-item">
                        <a class="nav-link" id="recruiters-tab" data-toggle="tab" href="#recruiters" role="tab" aria-controls="recruiters"
                          aria-selected="false">Recruiter</a>
                      </li>
                      <li class="nav-item">
                      <a class="nav-link active" id="candidate-master-tab" data-toggle="tab" href="#candidate-master" role="tab" aria-controls="candidate-master"
                        aria-selected="true">Candidate</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="pre-screeners-tab" data-toggle="tab" href="#pre-screeners" role="tab" aria-controls="pre-screeners"
                          aria-selected="false">Pre Screener</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" id="user-tab" data-toggle="tab" href="#user" role="tab" aria-controls="user"
                          aria-selected="false">User</a>
                      </li>
                            </ul>
                  <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade" id="area-product" role="tabpanel" aria-labelledby="area-product-tab">
                      <%@include file="areaForm.jsp" %>
                    </div>
                    <div class="tab-pane fade show active" id="candidate-master" role="tabpanel" aria-labelledby="candidate-master-tab"> 
                        <%@include file="candidateForm.jsp" %>             
                    </div>
                    <div class="tab-pane fade" id="candidate-role" role="tabpanel" aria-labelledby="candidate-role-tab">
                       <%@include file="candidateRole.jsp" %>
                    </div>
                    <div class="tab-pane fade" id="external-staffing-info" role="tabpanel" aria-labelledby="external-staffing-info-tab">
                         <%@include file="externalStaffForm.jsp" %>
                    </div>
                    <div class="tab-pane fade" id="pre-screeners" role="tabpanel" aria-labelledby="pre-screeners-tab">
                        <%@include file="preScreener.jsp" %>
                    </div>
                    <div class="tab-pane fade" id="recruiters" role="tabpanel" aria-labelledby="recruiters-tab">
                        <%@include file="recruiterForm.jsp" %>
                    </div>
                    <div class="tab-pane fade" id="skills" role="tabpanel" aria-labelledby="skills-tab">
                       <%@include file="skillForm.jsp" %>
                    </div>
                    <div class="tab-pane fade" id="user" role="tabpanel" aria-labelledby="user-tab">
                      <%@include file="userForm.jsp" %>
                    </div>
                  </div>
            </div>
          </div>
 
        </div>
        
      </div>

  <!-- SCRIPTS -->
  <!-- JQuery -->
  <script type="text/javascript" src="static/js/jquery.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="static/js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <!-- <script type="text/javascript" src="static/js/mdb.min.js"></script> -->
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="static/js/datatables.min.js"></script>
  
  <!-- Your custom scripts (optional) -->
   <!-- <script src="https://cdn.datatables.net/buttons/1.5.4/js/dataTables.buttons.min.js"></script> 
  <script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
  <script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/additional-methods.min.js"></script> -->
  
  <script type="text/javascript" src="static/js/jquery.validate.min.js"></script>
  <script type="text/javascript" src="static/js/additional-methods.min.js"></script>
  <script type="text/javascript" src="static/js/AjaxUtil.js"></script>
  <script type="text/javascript" src="static/js/PARValidator.js"></script>
  <script type="text/javascript" src="static/js/Skill.js"></script>
  <script type="text/javascript" src="static/js/ExternalStaff.js"></script>
  <script type="text/javascript" src="static/js/PreScreener.js"></script>
  <script type="text/javascript" src="static/js/user.js"></script>
  <script type="text/javascript" src="static/js/candidateRole.js"></script>
  <script type="text/javascript" src="static/js/recruiter.js"></script>
  <script type="text/javascript" src="static/js/Area.js"></script>
  <script type="text/javascript" src="static/js/candidate.js"></script>
   
  <script type="text/javascript" src="static/js/jquery-ui.min.js"></script>
  <!-- <script type="text/javascript" src="static/js/jquery.inputmask.bundle.min.js"></script> -->
</body>
</html>