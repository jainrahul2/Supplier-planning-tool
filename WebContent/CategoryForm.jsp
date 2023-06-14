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
                <center>
		
        <h2>
        	<a href="newcat">Add New Category</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="listCategory">List All Category</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${CategoryList != null}">
			<form action="updatecat"  method="post">
			
        </c:if>
        <c:if test="${CategoryList == null}">
			<form action="insertcat" method="post">
				
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${CategoryList != null}">
            			Edit List
            		</c:if>
            		<c:if test="${CategoryList == null}">
            			Add New Category
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${CategoryList != null}">
        			<input type="hidden" name="category_number" style="text-transform:uppercase" value="<c:out value='${CategoryList.category_number}'  />"	/> 
        		
        		</c:if>  
        		
        		<tr>
                <th>ID: </th>
                <td>
                	<input type="text" name="category_number" size="45" style="text-transform:uppercase"
                			value="<c:out value='${CategoryList.category_number}' />" readonly />
                		
                </td>
            </tr>
                      
            <tr>
                <th>Major Category: </th>
                <td>
       				<select style="font-family:sans-serif;text-transform:uppercase" name="major_category" value="<%=request.getParameter("major_category")%>" >
        				<option  value="CHILDRENS">CHILDRENS</option>
					    <option value="FOOTWEAR AND HANDBAGS">FOOTWEAR AND HANDBAGS</option>
					        <option value="FOOTWEAR AND HANDBAGS">FOOTWEAR AND HANDBAGS</option>
					        <option value="HARD HOME">HARD HOME</option>
					        <option value="INT APP/FINE JEWELRY-ACCESS/WOMENS SWIM">INT APP/FINE JEWELRY-ACCESS/WOMENS SWIM</option>
					        <option value="MENS CAREER/ALL DIVISION OUTERWEAR/SWIM">MENS CAREER/ALL DIVISION OUTERWEAR/SWIM</option>
					        <option value="MENS CASUAL">MENS CASUAL</option>
					        <option value="OPEN">OPEN</option>
					        <option value="SOFT HOME">SOFT HOME</option>
					        <option value="WOMEN CAREER">WOMEN CAREER</option>
					        <option value="WOMEN CASUAL">WOMEN CASUAL</option>
					        
        
    				</select>			
                </td>
            </tr>
            <tr>
                <th>Sourcing Category: </th>
  				<td>
       				<select style="font-family:sans-serif;text-transform:uppercase" name="sourcing_category"  value="<%=request.getParameter("sourcing_category")%>" >
        				<option  value="ACCESSORIES">ACCESSORIES</option>
					    <option value="BATH">BATH</option>
					    <option value="BED">BED</option>
					    <option value="BOYS OUTWEAR">BOYS OUTWEAR</option>
					    <option value="BOYS SWIMWEAR">BOYS SWIMWEAR</option>
				        <option value="BRAS">BRAS</option>
				        <option value="CHILDREN FOOTWEAR">CHILDREN FOOTWEAR</option>
				        <option value="COLD WEATHER">COLD WEATHER</option>
				        <option value="DEC ACCESORIES">DEC ACCESORIES</option>
				        <option value="DEC PILLOWS & RUGS">DEC PILLOWS & RUGS</option>					        
				        <option value="DECOR">DECOR</option>
				        <option value="FOOTWEAR">FOOTWEAR</option>
					    <option value="FURNITURE">FURNITURE</option>
					    <option value="GIRLS OUTWEAR">GIRLS OUTWEAR</option>
				        <option value="GIRLS SWIMWEAR">GIRLS SWIMWEAR</option>
				        <option value="HANDBAG">HANDBAG</option>
				        <option value="HANGING FOOTWEAR">HANGING FOOTWEAR</option>
				        <option value="HOUSEWARE">HOUSEWARE</option>
				        <option value="JEWELRY">JEWELRY</option>					        
				        <option value="KIDS ACCESSORIES">KIDS ACCESSORIES</option>
					    <option value="KIDS ACTIVE KNITS">KIDS ACTIVE KNITS</option>
				        <option value="KIDS ACTIVE WOVENS">KIDS ACTIVE WOVENS</option>					        
				        <option value="KIDS BASICS">KIDS BASICS</option>
					    <option value="KIDS DENIM">KIDS DENIM</option>
				        <option value="KIDS KNIT">KIDS KNIT</option>					        
				        <option value="KIDS PLAYWEAR">KIDS PLAYWEAR</option>
					    <option value="KIDS SWEATER">KIDS SWEATER</option>
				        <option value="KIDS WOVENS">KIDS WOVENS</option>					        
				        <option value="LUGGAGE">LUGGAGE</option>
					    <option value="MENS ACCESSORIES">MENS ACCESSORIES</option>
				        <option value="MENS ACTIVE WEAR">MENS ACTIVE WEAR</option>
					    <option value="MENS CASUAL BOTTOMS">MENS CASUAL BOTTOMS</option>
					    <option value="MENS DENIM BOTTOMS">MENS DENIM BOTTOMS</option>
					    <option value="MENS OUTERWEAR">MENS OUTERWEAR</option>
					    <option value="MENS KNITS">MENS KNITS</option>
					    <option value="MENS DRESS SHIRTS">MENS DRESS SHIRTS</option>
					    <option value="MENS FOOTWEAR">MENS FOOTWEAR</option>
					    <option value="MENS HOSIERY">MENS HOSIERY</option>
					    <option value="MENS SLEEPWEAR">MENS SLEEPWEAR</option>
					    <option value="MENS SWIM">MENS SWIM</option>
					    <option value="PERSONAL CARE">PERSONAL CARE</option>
					    <option value="PET CARE">PET CARE</option>
					    <option value="PANTIES">PANTIES</option>
					    <option value="MENS TAILORED CLOTHING">MENS TAILORED CLOTHING</option>
					    <option value="MENS UNDERWEAR">MENS UNDERWEAR</option>
					    <option value="MENS WOVEN TOPS">MENS WOVEN TOPS</option>
					    <option value="MENS WOVEN ACTIVEWEAR">MENS WOVEN ACTIVEWEAR</option>
					    <option value="OPEN">OPEN</option>
					    <option value="MENS ACCESSORIES">MENS ACCESSORIES</option>
					   
					    <option value="PET CARE">PET CARE</option>
					    <option value="PANTIES">PANTIES</option>
					    <option value="MENS TAILORED CLOTHING">MENS TAILORED CLOTHING</option>
					    <option value="MENS UNDERWEAR">MENS UNDERWEAR</option>
					    <option value="MENS WOVEN TOPS">MENS WOVEN TOPS</option>
					    <option value="MENS WOVEN ACTIVEWEAR">MENS WOVEN ACTIVEWEAR</option>
					    <option value="OPEN">OPEN</option>
					    <option value="TOYS">TOYS</option>
					    <option value="SEASONAL">SEASONAL</option>
					    <option value="SHAPEWEAR">SHAPEWEAR</option>
					    <option value="WOMEN ACCESORIES">WOMEN ACCESORIES</option>
					    <option value="WINDOWS">WOMENS</option>
					    <option value="WOMEN BOTTOMS">WOMEN BOTTOMS</option>
					    <option value="WOMENS CASUAL BOTTOMS">WOMENS CASUAL BOTTOMS</option>
					    <option value="WOMENS DENIM BOTTOMS">WOMENS DENIM BOTTOMS</option>
					    <option value="WOMENS ACTIVEWEAR">WOMENS ACTIVEWEAR</option>
					    <option value="WOMENS FOOTWEAR">WOMENS FOOTWEAR</option>
					    <option value="WOMENS HOSIERY">WOMENS HOSIERY</option>
					    <option value="WOMENS ACTIVEWEAR">WOMENS ACTIVEWEAR</option>
					    <option value="WOMENS KNITS">WOMENS KNITS</option>
					    <option value="WOMENS SLEEPWEAR">WOMENS SLEEPWEAR</option>
					    <option value="WOMENS OUTERWEAR">WOMENS OUTERWEAR</option>
					    <option value="WOMENS SWIMWEAR">WOMENS SWIMWEAR</option>
					    <option value="WOMENS WOVEN ACTIVEWEAR">WOMENS WOVEN ACTIVEWEAR </option>
					    <option value="WOMENS FOOTWEAR">WOMENS FOOTWEAR</option>
					    <option value="WOMENS SLEEPWEAR">WOMENS SLEEPWEAR</option>
					    <option value="WOMENS DRESSES">WOMENS DRESSES</option>
					    <option value="WOMENS KNIT DRESSES">WOMENS KNIT DRESSES</option>
					    <option value="WOMENS RELATED SEPARATES">WOMENS RELATED SEPARATES</option>
					    <option value="WOMENS SWEATER DRESSES">WOMENS SWEATER DRESSES</option>
					    <option value="WOMENS SWEATERS">WOMENS SWEATERS</option>
					    <option value="WOMENS WOVEN DRESSES">WOMENS WOVEN DRESSES</option>
					    <option value="WOMENS WOVEN TOPS">WOMENS WOVEN TOPS</option>
					    
        
    				</select>			
                </td>
			 </tr>
             <tr>
                <th>Sourcing Sub Category: </th>
          
                <td>
       				<select style="font-family:sans-serif;text-transform:uppercase" name="sourcing_sub_category"  value="<%=request.getParameter("sourcing_sub_category")%>" >
        				<option value="FOOTWEAR">FOOTWEAR</option>
        				<option  value="ACCESSORIES">ACCESSORIES</option>
        				<option value="HANDBAG">HANDBAG</option>
        				<option value="SEASONAL">SEASONAL</option>
					    <option value="BATH">BATH</option>
					    <option value="DEC ACCESORIES">DEC ACCESORIES</option>
					    <option value="BRAS">BRAS</option>
					    <option value="PERSONAL CARE">PERSONAL CARE</option>
					    <option value="COLD WEATHER">COLD WEATHER</option>
					    <option value="PANTIES">PANTIES</option>
					    <option value="OPEN">OPEN</option>
					    <option value="TOYS">TOYS</option>
					    <option value="SHAPEWEAR">SHAPEWEAR</option>
					    <option value="WOMENS WOVEN DRESSES">WOMENS WOVEN DRESSES</option>
					    <option value="WOMENS ACTIVEWEAR">WOMENS ACTIVEWEAR</option>
					    <option value="PANTIES">PANTIES</option> 
					    <option value="WOMEN BOTTOMS">WOMEN BOTTOMS</option>
					    <option value="WOMENS ACTIVEWEAR">WOMENS ACTIVEWEAR</option>
					    <option value="BED">BED</option>
					    <option value="BOYS">BOYS</option>
					    <option value="GIRLS">GIRLS</option>
					     <option value="UNISEX">UNISEX</option>
					     <option value="SWIM">SWIM</option>
					     <option value="RUGS">RUGS</option>
					     <option value="BATH RUGS">BATH RUGS</option>
					     <option value="PET CARE">PET CARE</option>
					     <option value="WALLET">WALLET</option>
					   	<option value="JEWELRY">JEWELRY</option>	
					    <option value="BOOTS">BOOTS</option>
				        <option value="ATHLETIC FOOTWEAR">ATHLETIC FOOTWEAR</option>
				        <option value="SANDALS">SANDALS</option>
				        <option value="HANDBAGS">HANDBAGS</option>					        
				        <option value="TOWELS">TOWELS</option>
					    <option value="UNDERWEAR">UNDERWEAR</option>
					    
					    
					    
					    <option value="GIRLS OUTWEAR">GIRLS OUTWEAR</option>
				        <option value="GIRLS SWIMWEAR">GIRLS SWIMWEAR</option>
				        
				        <option value="HANGING FOOTWEAR">HANGING FOOTWEAR</option>
				        <option value="HOUSEWARE">HOUSEWARE</option>
				        				        
				        <option value="KIDS ACCESSORIES">KIDS ACCESSORIES</option>
					    <option value="KIDS ACTIVE KNITS">KIDS ACTIVE KNITS</option>
				        <option value="KIDS ACTIVE WOVENS">KIDS ACTIVE WOVENS</option>					        
				        <option value="KIDS BASICS">KIDS BASICS</option>
					    <option value="KIDS DENIM">KIDS DENIM</option>
				        <option value="KIDS KNIT">KIDS KNIT</option>					        
				        <option value="KIDS PLAYWEAR">KIDS PLAYWEAR</option>
					    <option value="KIDS SWEATER">KIDS SWEATER</option>
				        <option value="KIDS WOVENS">KIDS WOVENS</option>					        
				        <option value="LUGGAGE">LUGGAGE</option>
					    <option value="MENS ACCESSORIES">MENS ACCESSORIES</option>
				        <option value="MENS ACTIVE WEAR">MENS ACTIVE WEAR</option>
					    <option value="MENS CASUAL BOTTOMS">MENS CASUAL BOTTOMS</option>
					    <option value="MENS DENIM BOTTOMS">MENS DENIM BOTTOMS</option>
					    <option value="MENS OUTERWEAR">MENS OUTERWEAR</option>
					    <option value="MENS KNITS">MENS KNITS</option>
					    <option value="MENS DRESS SHIRTS">MENS DRESS SHIRTS</option>
					    <option value="MENS FOOTWEAR">MENS FOOTWEAR</option>
					    <option value="MENS HOSIERY">MENS HOSIERY</option>
					    <option value="MENS SLEEPWEAR">MENS SLEEPWEAR</option>
					    <option value="MENS SWIM">MENS SWIM</option>
					    <option value="WOVEN TOPS">WOVEN TOPS</option>
					    <option value="WOVEN ACTIVEWEAR">WOVEN ACTIVEWEAR </option>
					    <option value="WOVEN BOTTOM">WOVEN BOTTOM </option>
					    <option value="PET CARE">PET CARE</option>
					    <option value="OPEN">OPEN</option>
					    <option value="SHEETS">SHEETS</option>
					    <option value="SLEEPWEARS">SLEEPWEARS</option>
					    <option value="CASUAL FOOTWEAR">CASUAL FOOTWEAR</option>
					    <option value="DRESS FOOTWEAR">DRESS FOOTWEAR</option>
					    <option value="DRESS/CASUAL FOOTWEAR">DRESS/CASUAL FOOTWEAR</option>
					    <option value="LIGHTING">LIGHTING</option>
					    <option value="DEC PILLOWS">DEC PILLOWS</option>
					    <option value="DEC RUGS">DEC RUGS</option>
					    <option value="OUTDOOR">OUTDOOR</option>
					    <option value="ACCENT FURNITURE">ACCENT FURNITURE</option>
					    <option value="BEDROOM FURNITURE">BEDROOM FURNITURE</option>
					    <option value="DINING FURNITURE">DINING FURNITURE</option>
					    <option value="UPHOLSTERY FURNITURE">UPHOLSTERY FURNITURE</option>
					    <option value="BAKEWARE">BAKEWARE</option>
					    <option value="BEVERAGEWARE">BEVERAGEWARE</option>
					    <option value="COOKINGWARE">COOKINGWARE</option>
					    <option value="FLATWARE">COOKINGWARE</option>
					    <option value="CUTLERY">CUTLERY</option>
					    <option value="FOODPREP">CUTLERY</option>
					    <option value="SMALL ELECTRICS">SMALL ELECTRICS</option>
					   	<option value="TABLE LINENS">TABLE LINENS</option>
					    <option value="HOSIERY">HOSIERY</option>
					    <option value="KNIT">KNIT</option>
					    <option value="DENIM BOTTOMS">DENIM BOTTOMS</option>
					   <option value="DRESS SHIRT">DRESS SHIRT</option>
					    <option value="SPORTS SHIRT">SPORTS SHIRT</option>
					   <option value="SLEEPWEAR">WOMENS SLEEPWEAR</option>
					    <option value="OUTERWEAR">OUTERWEAR</option>
					    <option value="SWIMWEAR">SWIMWEAR</option>
					    <option value="SWEATERS">SWEATERS</option>
					   <option value="WHITE GOODS">WHITE GOODS</option>
					    <option value="HARD WINDOW">HARD WINDOW</option>
					    <option value="SOFT WINDOW">SOFT WINDOW</option>
					    <option value="HANGING FOOTWEAR">HANGING FOOTWEAR</option>
					    <option value="TAILORED CLOTHING">TAILORED CLOTHING</option>
					    <option value="RELATED SEPARATES">RELATED SEPARATES</option>
				</select>			
                </td>
            </tr>
            <tr>
                <th>Classification: </th>
               
                
                <td>
       				<select style="font-family:sans-serif;text-transform:uppercase" name="classification"  value="<%=request.getParameter("classification")%>" >
        				
        				<option value="10 PC. COMFORTER SET">10 PC. COMFORTER SET</option>
					    <option value="10 PC. DUVET SET">10 PC. DUVET SET</option>
					    <option value="3 PC. COMFORTER SET">3 PC. COMFORTER SET</option>
					    <option value="3 PC. DUVET SET">3 PC. DUVET SET</option>
					    <option value="4 PC. COMFORTER SET">4 PC. COMFORTER SET</option>
					    <option value="4 PC. DUVET SET">4 PC. DUVET SET</option>
					    <option value="5 PC. COMFORTER SET">5 PC. COMFORTER SET</option>
					    <option value="5 PC. DUVET SET">5 PC. DUVET SET</option>
					    <option value="7 PC. COMFORTER SET">7 PC. COMFORTER SET</option>
					    <option value="7 PC. DUVET SET">7 PC. DUVET SET</option>
					    <option value="8 PC. COMFORTER SET">8 PC. COMFORTER SET</option>
					    <option value="6 PC SETS">6 PC SETS</option>
        				<option value="BOYS">BOYS</option>
        				<option  value="GIRLS">GIRLS</option>
        				<option value="MEN">MEN</option>
        				<option value="WOMEN">WOMEN</option>
					    <option value="UNISEX">UNISEX</option>
					    <option value="TOP">TOP</option>
					    <option value="BOTTOM">BOTTOM</option>
					    <option value="ACCESSORIES">ACCESSORIES</option>
					    <option value="ACTIVEWEAR">WOMENS ACTIVEWEAR</option>
					    <option value="SWIMWEAR">SWIM</option>
					    <option value="BED">BED</option>
					    <option value="SINGLES">SINGLES</option>
					    <option value="SINGLE">SINGLE</option>
					   <option value="SKIRT">SKIRT</option>
					    <option value="CHILDREN">CHILDREN</option>
					   <option value="APRON">APRON</option>
					    <option value="COLD WEATHER">COLD WEATHER</option>
					    <option value="ARMOIRE BOTTOMS">ARMOIRE</option>
					    <option value="OPEN">OPEN</option>
					    <option value="TOYS">TOYS</option>
					    <option value="RUGS">RUGS</option>
					    <option value="SHAPEWEAR">SHAPEWEAR</option>
					    <option value="WOMENS WOVEN DRESSES">WOMENS WOVEN DRESSES</option>
					    <option value="WALLET">WALLET</option>
					   	<option value="JEWELRY">JEWELRY</option>	
					    <option value="BOOTS">BOOTS</option>
				        <option value="ATHLETIC FOOTWEAR">ATHLETIC FOOTWEAR</option>
				        <option value="SANDALS">SANDALS</option>
				        <option value="HANDBAGS">HANDBAGS</option>					        
				        <option value="TOWELS">TOWELS</option>
					    <option value="UNDERWEAR">UNDERWEAR</option>
					    <option value="PANTIES">PANTIES</option> 
					    <option value="ROMPERS">ROMPERS</option>
					    <option value="ROBES">ROBES</option>
					    <option value="PET CARE">PET CARE</option>
					    <option value="WOVENS">WOVENS</option>					        
				        <option value="LUGGAGE">LUGGAGE</option>
					    <option value="OPEN">OPEN</option>
					    <option value="SHEETS">SHEETS</option>
					    <option value="OUTWEAR">GIRLS OUTWEAR</option>
				        <option value="SWIMWEAR">GIRLS SWIMWEAR</option>
				         <option value="FOOTWEAR">HANGING FOOTWEAR</option>
				        <option value="HOUSEWARE">HOUSEWARE</option>
				        <option value="GIFTS & ACCESSORIES">GIFTS & ACCESSORIES</option>
					    <option value="FLEECE">FLEECE</option>
				        <option value="DRESSES">DRESSES</option>					        
				        <option value="BAR STOOL">BAR STOOL</option>
					    <option value="BAGPACK">BAGPACK</option>
				        <option value="CHAIR">CHAIR PAD</option>					        
				        <option value="CHAIR PAD">CHAIR PAD</option>
					    <option value="SYNTHETIC">SYNTHETIC</option>
				        <option value="HOSIERY">HOSIERY</option>
					    <option value="LEATHER">LEATHER</option>
				        <option value="COTTON">COTTON</option>
					    <option value="FINE">FINE</option>
					    <option value="PACKS">PACKS</option>
					    <option value="SCARVES">SCARVES</option>
					    <option value="GLOVES">GLOVES</option>
					    <option value="STOCKINGS & SKIRTS">STOCKINGS & SKIRTS</option>
					    <option value="ORNAMENTS">ORNAMENTS</option>
					    
					    <option value="WOOL">WOOL</option>
					    <option value="SETS">SETS</option>
					    <option value="LONG SLEEVES">LONG SLEEVES</option>
					    <option value="SHORT SLEEVES">SHORT SLEEVES</option>
					    <option value="WRAPS & COVERUPS">WRAPS & COVERUPS</option>
					    <option value="PET CARE">PET CARE</option>
					    <option value="LIGHTING">LIGHTING</option>
					    <option value="DEC PILLOWS">DEC PILLOWS</option>
					    <option value="DEC RUGS">DEC RUGS</option>
					    <option value="SLEEPWEARS">SLEEPWEARS</option>
					    <option value="WASH">WASH</option>
					    <option value="TUBS">TUBS</option>
					    <option value="DRESS/CASUAL FOOTWEAR">DRESS/CASUAL FOOTWEAR</option>
					    
					    <option value="HEATED MATRESS PAD">HEATED MATRESS PAD</option>
					    <option value="FANNEL SHEET">FANNEL SHEET</option>
					    <option value="COMFORTORS">COMFORTORS</option>
					    <option value="JUVENILE">JUVENILE</option>
					    <option value="LINED">LINED</option>
					    <option value="PANEL">PANEL</option>
					    <option value="SHEERS">SHEERS</option>
					    <option value="CAPRY">CAPRY</option>
					    <option value="FLATWARE">COOKINGWARE</option>
					    <option value="CUTLERY">CUTLERY</option>
					   
					    <option value="JACKETS">JACKETS</option>
					   	<option value="GROUP LOT">GROUP LOT</option>
					    <option value="BEECH TOWEL">BEECH TOWEL</option>
					    <option value="KNIT">KNIT</option>
					    <option value="BOTTOMS">DENIM BOTTOMS</option>
					   <option value="THROWS">THROWS</option>
					    <option value="BLANKET">BLANKET</option>
					    <option value="BODY PILLOW COVERS">BODY PILLOW COVERS</option>
					    <option value="HANDS">HANDS</option>
					   <option value="BED COVERS">BED COVERS</option>
					    <option value="BED SKIRT">BED SKIRT</option>
					    <option value="CORE BEDDING">CORE BEDDING</option>
					    <option value="BED SPREAD">BED SPREAD</option>
					    
				</select>			
                </td>
            </tr> 
            <tr>
                <th>Status: </th>
                <td>
                	<select style="font-family:sans-serif;" name="status"  value="<%=request.getParameter("status")%>" >
        <option  value="INACTIVE">INACTIVE</option>
        <option value="ACTIVE">ACTIVE</option>
        
    </select>
                </td>
            </tr> 
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        <p style="color: red;font-style:normal;font-weight: bold; font-family: sans-serif;">	<c:out value='${message}' /><p>
        </form>
    </div>
  </div>
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
<script type="text/javascript">
function confirm_click()
{
	return confirm("Are you sure ?");
}

</script>
</body>

</html>
<!-- end document-->



