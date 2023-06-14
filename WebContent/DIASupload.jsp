<%@page import="net.codejava.javaee.brand.fetchingLockingDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fz" %>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">
	<% fetchingLockingDate fld=new fetchingLockingDate(); %>
	<% String lockingDate= fld.LockingDate2(); %>
    <!-- Title Page-->
    <title>Supplier Planning Tool</title>

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
    <div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <header class="header-mobile d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                        <a class="logo" href="index.html">
                            <img src="images/icon/logo.png" alt="" />
                        </a>
                        <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
            </div>
            <nav class="navbar-mobile">
                <div class="container-fluid">
                    <ul class="navbar-mobile__list list-unstyled">
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-tachometer-alt"></i>Dashboard</a>
                            <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                                <li>
                                    <a href="index.html">Dashboard 1</a>
                                </li>
                                <li>
                                    <a href="index2.html">Dashboard 2</a>
                                </li>
                                <li>
                                    <a href="index3.html">Dashboard 3</a>
                                </li>
                                <li>
                                    <a href="index4.html">Dashboard 4</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="chart.html">
                                <i class="fas fa-chart-bar"></i>Charts</a>
                        </li>
                        <li>
                            <a href="table.html">
                                <i class="fas fa-table"></i>Tables</a>
                        </li>
                        <li>
                            <a href="form.html">
                                <i class="far fa-check-square"></i>Forms</a>
                        </li>
                        <li>
                            <a href="calendar_app-website-usage.html">
                                <i class="fas fa-calendar-alt"></i>Calendar</a>
                        </li>
                        <li>
                            <a href="map.html">
                                <i class="fas fa-map-marker-alt"></i>Maps</a>
                        </li>
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-copy"></i>Pages</a>
                            <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                                <li>
                                    <a href="login.html">Login</a>
                                </li>
                                <li>
                                    <a href="register.html">Register</a>
                                </li>
                                <li>
                                    <a href="forget-pass.html">Forget Password</a>
                                </li>
                            </ul>
                        </li>
                        
                    </ul>
                </div>
            </nav>
        </header>
        <!-- END HEADER MOBILE-->

        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
                <a class="logo" href="index.html">
                            <Label>Supplier Planning Tool</label>
                        </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                        
                
                        <li class="has-sub">
                        <a class="js-arrow" href="#">
                                <i class="fas fa-desktop"></i>Administrator</a>
                                <ul class="list-unstyled navbar__sub-list js-sub-list">
                                	<li><a href="controllist">Control Office</a></li>
								    	<li><a href="countrylist">Country Management</a></li>
								    	<li><a href="listmdselist">MDSE Heirarchy Management</a></li>
								    	<li><a href="lockingdateList">Locking Date Management</a></li>
								    	<li><a href="listfiscalcalendar">Fiscal Calendar</a></li>
								        <li><a href="list">Brand Management</a></li>
								        <li><a href="listCategory">Category Management</a></li>
								        <li><a href="supplierList">Supplier Management</a></li>
								        <li><a href="listuser">User Management</a></li>
								         </ul>
                        </li>
                       
                       <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-desktop"></i>Upload</a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                                <li><a href="UploadServletDIAS">DIAS Upload</a></li>
    							<li><a href="Welcome.jsp">FDP Upload</a></li>
    							
                            </ul>
                            
                        </li>
                         <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-desktop"></i>Reporting</a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                               
    							<li><a href="reproting">Reporting</a></li>
                            </ul>
                            
                        </li>
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-desktop"></i>User Setting</a>
                                 <ul class="list-unstyled navbar__sub-list js-sub-list">
                        			<li><a href="UserSettingForm.jsp">Password Reset</a></li>
                        			 </ul>
    					</li>
                   </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            <!-- HEADER DESKTOP-->
            <header class="header-desktop">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap">
                            <form class="form-header" action="" method="POST">
                                
                               
                                   
                            </form>
                            <div class="header-button">
                                <div class="noti-wrap">
                                   
                                   
                                    <div class="noti__item js-item-menu">
                                       
                                       
                                    </div>
                                </div>
                                <div class="account-wrap">
                                    <div class="account-item clearfix js-item-menu">
                                        <div class="image">
                                            <img src="images/icon/logo-mini.png"  alt ="JCP"/>
                                        </div>
                                        <div class="content">
                                            <a class="js-acc-btn" href="#"><c:out value="${fn:toUpperCase(login.first_name)}" /></a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">
                                            <div class="info clearfix">
                                                <div class="image">
                                                    <img src="images/icon/logo-mini.png"  alt ="JCP"/>
                                                </div>
                                                <div class="content">
                                                    <h5 class="name">
                                                        <a href="#"><c:out value="${fn:toUpperCase(login.first_name)}" /></a>
                                                    </h5>
                                                    
                                                </div>
                                            </div>
                                           
                                            <div class="account-dropdown__footer">
                                                <a href="logout">
                                                    <i class="zmdi zmdi-power"></i>Logout</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!-- END HEADER DESKTOP-->

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        
                         <div class="table-data__tool-left">
                                        
                                    </div>
                                    
                                </div>
                                <div class="table-responsive table-responsive-data2">
                                      <center>
        
        <form action="UploadServletDIAS" method="post" enctype="multipart/form-data">
            <table width="400px" align="center" border=2>
                <tr>
                    <td align="center" colspan="2">Form Details</td>
                </tr>
                <tr>
                    <td>First Name </td>
                    <td>
                        <input style="width:100%" type="text" required="" name="firstname"  value="<c:out value="${fn:toUpperCase(login.first_name)}" />" readonly >
                    </td>
                </tr>
                <tr>
                    <td>Last Name </td>
                    <td>
                        <input style="width:100%" type="text" required="" name="lastname" value="<c:out value="${fn:toUpperCase(login.last_name)}" />" readonly>
                    </td>
                </tr>
                <tr>
                    <td>File Type </td>
                    <td>
                        <input style="width:100%" type="text" required="" name="DIAS" value="DIAS" readonly>
                    </td>
                </tr>
<!--                 <tr>
                <th>Status: </th>
                	<td>
                		<select   style="font-family:sans-serif;" name="month" id="month">
        					<option name="feburary" value="feb">feb</option>
       						<option  name="march" value="mar">mar</option>
       						<option  name="april" value="apr">apr</option>
       						<option  name="may" value="may">may</option>
       						<option  name="jun" value="jun">jun</option>
       						<option  name="july" value="jul">jul</option>
       						<option  name="august" value="aug">aug</option>
       						<option  name="september" value="sep">sep</option>
       						<option  name="october" value="oct">oct</option>
       						<option  name="november" value="nov">nov</option>
       						<option  name="december" value="dec">dec</option>
       						<option  name="january" value="jan">jan</option>
       						
        
    					</select>
                	</td>
            </tr> -->
                <tr>
                    <td>Locking Date </td>
                    <td>
                        <input style="width:100%" type="text"  name="lockingDate" value="<%=lockingDate %>"  readonly>
                    </td>
                </tr>
                <tr>
                    <td>Select File </td>
                    <td>
                    <% if(fld.lockingDateChecker())
                    { %>
                        <input  style="width:100%" type="file"  name="file" required>
                  <% }
                      else{ %>
                     	 <input style="width:100%" type="text" required="" name="file" value="Please check the locking date" readonly>
                     	 <%} %>
                    </td>
                    
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table>

        </form>
        <br><a href ="file-listDIAS.jsp">View List</a>
    </center>
	 <p style="color: red;font-style:normal;font-weight: bold; font-family: sans-serif;">	<c:out value='${message}' /><p>
              </div>

    
<script>
    $(document).ready(function() {
        var table = $('#example').DataTable( {
            lengthChange: false,
            buttons: [ 'copy', 'excel', 'pdf', 'colvis' ]
        } );
     
        table.buttons().container()
            .appendTo( '#example_wrapper .col-sm-6:eq(0)' );
    } );
    	
</script>
<script type="text/javascript">
function confirm_click()
{
	return confirm("Are you sure ?");
}


</script>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</script>
                                </div>
                                <!-- END DATA TABLE -->
                            </div>
                        </div>
                        <div class="row m-t-30">
                            <div class="col-md-12">
                               
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="copyright">
                                    <p>Copyright © 2019 JCPENNEY. All rights reserved. visit <a href="http://www.jcpenney.com">JCPENNEY</a>.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="vendor/slick/slick.min.js">
    </script>
    <script src="vendor/wow/wow.min.js"></script>
    <script src="vendor/animsition/animsition.min.js"></script>
    <script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="vendor/circle-progress/circle-progress.min.js"></script>
    <script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="vendor/select2/select2.min.js">
    </script>

    <!-- Main JS-->
    <script src="js/main.js"></script>

</body>

</html>
<!-- end document-->
