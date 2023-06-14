<%@page import="net.codejava.javaee.brand.fetchingLockingDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.6.0/css/buttons.bootstrap.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.0/js/buttons.bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.0/js/buttons.html5.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.0/js/buttons.print.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.0/js/buttons.colVis.min.js"></script>



    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->

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
    <link rel="stylesheet" type="text/css" href="css/foopicker.css">
  <script type="text/javascript" src="js/foopicker.js"></script>
    
   
   

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
             <div class="container-fluid">
        <center class="mainHeader">
		
        <h2>
        	<a href="newfiscalcalendar">Add New Entry</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="listfiscalcalendar">List Date</a>
        	
        </h2>
	</center>
    <div class="mainHeader" align="center" style="overflow:scroll;">
		<c:if test="${FiscalCalendar != null}">
			<form action="updatefiscalcalendar" method="post">
			 <c:set var = "user" scope = "session" value="${fn:toUpperCase(FiscalCalendar.updated_by)}" />
      		
        </c:if>
        <c:if test="${FiscalCalendar == null}">
			<form action="insertfiscalcalendar" method="post">
			 <c:set var = "user" scope = "session" value="${fn:toUpperCase(login.first_name)}" />	
        </c:if>
        
        <table border="1" cellpadding="5"  class="table table-striped table-bordered" style="font-family:sans-serif; font-size:12px;overflow:scroll">
            <caption>
            	<h2 style="font-family:sans-serif;">
            		<c:if test="${FiscalCalendar!= null}">
            			Edit List
            		</c:if>
            		<c:if test="${FiscalCalendar== null}">
            			Add New Entry
            		</c:if>
            	</h2>
            </caption>
        		<%-- <c:if test="${FiscalCalendar!= null}">
        			<input type="text" maxlength="4" type="hidden" name="year" value="<c:out value='${FiscalCalendar.year}'  />"	/> 
        		
        		</c:if>  --%>
        	
           
            <thead>
            <tr>
                <th>Year</th>
                <th>Feb</th>
               	<th>Mar</th>
              	<th>Apr</th>
               	<th>May</th>
               	<th>Jun</th>
               	<th>Jul</th>
               	<th>Aug</th>
               	<th>Sept</th>
                <th>Oct</th>
               	<th>Nov</th>
               	<th>Dec</th>
               	<th>Jan</th>
               	<th>Updated By</th>
               	<th>Updated On</th>
               	<th>Action</th>
               
            </tr>
            </thead>
  	<tbody>			
               <tr>
                    
                <td>
                	<input type="text" name="year" size="45" maxlength="4" value="<c:out value='${FiscalCalendar.year}'  />"  required   />
                			
                </td>
                
                <td>
                	<input type="text"  id="datepicker14" name="feb" size="45" 
                			value="<c:out value='${FiscalCalendar.feb}'  />" readonly  />		
                </td>
           		
           		
                <td>
                	<input id="datepicker2"  type="text" name="mar" size="45"
                			value="<c:out value='${FiscalCalendar.mar}'  />" readonly />
                		
                </td>
            
                <td>
                	<input id="datepicker3"  type="text" name="april" size="45"
                			value="<c:out value='${FiscalCalendar.april}' />" readonly />
                		
                </td>
           		
                <td>
                	<input id="datepicker4"  type="text" name="may" size="45"
                			value="<c:out value='${FiscalCalendar.may}' />" readonly />
                		
                </td>
                <td>
                	<input id="datepicker5"  type="text" name="june" size="45"
                			value="<c:out value='${FiscalCalendar.june}' />" readonly />
                </td>
             <td>
                	<input id="datepicker7"  type="text" name="july" size="45"
                			value="<c:out value='${FiscalCalendar.july}' />" readonly />
                		
                </td>
                
                <td>
                	<input id="datepicker8"  type="text" name="august" size="45"
                			value="<c:out value='${FiscalCalendar.august}' />" readonly />
                		
                </td>
           
                <td>
                	<input id="datepicker9"  type="text" name="september" size="45"
                			value="<c:out value='${FiscalCalendar.september}' />" readonly />
                		
                </td>
           
                <td>
                	<input id="datepicker10"  type="text" name="october" size="45"
                			value="<c:out value='${FiscalCalendar.october}' />" readonly />
                		
                </td>
            
                <td>
                	<input id="datepicker13"  type="text" name="november" size="45"
                			value="<c:out value='${FiscalCalendar.november}' />" readonly />
                		
                </td>
                <td>
                	<input id="datepicker11"  type="text" name="december" size="45"
                			value="<c:out value='${FiscalCalendar.december}' />" readonly />
               </td>
           
                <td>
                	<input id="datepicker12"  type="text" name="january" size="45"
                			value="<c:out value='${FiscalCalendar.january}' />" readonly />
                		
                </td>

           
                <td>
                	<input  type="text" name="updated_by" size="45" style="text-transform:uppercase"
                			value="<c:out value = "${user}"/> "  readonly />
                		
                </td>
               	
           		 <td>
                	<input type="text" name="updated_on" size="45"
                			value='<%= (new java.util.Date()).toLocaleString()%>'  readonly />
                		
                </td>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save"   />
            	</td>
            	</tr>
            	
           
  	
  	 </tbody>
        </table>
       		
        <p style="color: red;font-style:normal;font-weight: bold; font-family: sans-serif;">	<c:out value='${message}' /><p>
        </form>
           </div>
       


    </div>	


  <script>
    var foopicker = new FooPicker({
      id: 'datepicker',
      dateFormat: 'MM/dd/yyyy',
      disable: ['', '', '', '']
    });
    var foopicker2 = new FooPicker({
        id: 'datepicker2',
        dateFormat: 'MM/dd/yyyy',
        disable: ['', '', '', '']
      });
    var foopicker3 = new FooPicker({
        id: 'datepicker3',
        dateFormat: 'MM/dd/yyyy',
        disable: ['', '', '', '']
      });
    var foopicker4 = new FooPicker({
        id: 'datepicker4',
        dateFormat: 'MM/dd/yyyy',
        disable: ['', '', '', '']
      });
    var foopicker5 = new FooPicker({
        id: 'datepicker5',
        dateFormat: 'MM/dd/yyyy',
        disable: ['', '', '', '']
      });
    var foopicker6 = new FooPicker({
        id: 'datepicker6',
        dateFormat: 'MM/dd/yyyy',
        disable: ['', '', '', '']
      });
    var foopicker7 = new FooPicker({
        id: 'datepicker7',
        dateFormat: 'MM/dd/yyyy',
        disable: ['', '', '', '']
      });
    var foopicker8 = new FooPicker({
        id: 'datepicker8',
        dateFormat: 'MM/dd/yyyy',
        disable: ['', '', '', '']
      });
    var foopicker9 = new FooPicker({
        id: 'datepicker9',
        dateFormat: 'MM/dd/yyyy',
        disable: ['', '', '', '']
      });
    var foopicker10 = new FooPicker({
        id: 'datepicker10',
        dateFormat: 'MM/dd/yyyy',
        disable: ['', '', '', '']
      });
    var foopicker11 = new FooPicker({
        id: 'datepicker11',
        dateFormat: 'MM/dd/yyyy',
        disable: ['', '', '', '']
      });
    var foopicker12 = new FooPicker({
        id: 'datepicker12',
        dateFormat: 'MM/dd/yyyy',
        disable: ['', '', '', '']
      });
    var foopicker13 = new FooPicker({
        id: 'datepicker13',
        dateFormat: 'MM/dd/yyyy',
        disable: ['', '', '', '']
      });
    var foopicker14 = new FooPicker({
        id: 'datepicker14',
        dateFormat: 'MM/dd/yyyy',
        disable: ['', '', '', '']
      });
    
  </script>
                <div class="section__content section__content--p30">
                   
                         <div class="table-data__tool-left">
                                        
                                    </div>
                                    
                               
                                <div class="table-responsive table-responsive-data2">
                                
        
              </div>


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
                
    <!-- Jquery JS-->
    
    <!-- Bootstrap JS-->
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
   
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
<script>
   /*  let options = {
        numberPerPage:8, //Cantidad de datos por pagina
        goBar:true, //Barra donde puedes digitar el numero de la pagina al que quiere ir
        pageCounter:true, //Contador de paginas, en cual estas, de cuantas paginas
    };

    let filterOptions = {
        el:'#searchBox' //Caja de texto para filtrar, puede ser una clase o un ID
    };

    paginate.init('.myTable',options,filterOptions); */
    $(document).ready(function() {
        var table = $('#example').DataTable( {
            lengthChange: false,
            buttons: [ 'copy', 'excel', 'pdf', 'colvis' ]
        } );
     
        table.buttons().container()
            .appendTo( '#example_wrapper .col-sm-6:eq(0)' );
    } );
    
    
</script>
<!-- <script type="text/javascript">
 
    $(document).ready(function() {
        $("#resetForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                }      
            },
             
            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                }
            }
        });
 
    });
</script> -->

</body>

</html>
<!-- end document-->
