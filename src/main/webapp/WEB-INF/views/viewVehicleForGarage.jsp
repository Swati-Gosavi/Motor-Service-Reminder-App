
<!DOCTYPE html>
<%@page import="com.swati.entities.Vehicle"%>
<%@page import="com.swati.entities.Garage"%>
<%@page import="java.util.List"%>
<head>
<title>View Vehicle For Garage</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Colored Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="./resources/css/bootstrap.css">
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="./resources/css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="./resources/css/font.css" type="text/css"/>
<link href="./resources/css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<script src="./resources/js/jquery2.0.3.min.js"></script>
<script src="./resources/js/modernizr.js"></script>
<script src="./resources/js/jquery.cookie.js"></script>
<script src="./resources/js/screenfull.js"></script>
<script>
	$(function () {
		$('#supported').text('Supported/allowed: ' + !!screenfull.enabled);

		if (!screenfull.enabled) {
			return false;
		}

		$('#toggle').click(function () {
			screenfull.toggle($('#container')[0]);
		});	
	});
</script>
<!-- tables -->
<link rel="stylesheet" type="text/css" href="./resources/css/table-style.css" />
<link rel="stylesheet" type="text/css" href="./resources/css/basictable.css" />
<script type="text/javascript" src="./resources/js/jquery.basictable.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
      $('#table').basictable();

      $('#table-breakpoint').basictable({
        breakpoint: 768
      });

      $('#table-swap-axis').basictable({
        swapAxis: true
      });

      $('#table-force-off').basictable({
        forceResponsive: false
      });

      $('#table-no-resize').basictable({
        noResize: true
      });

      $('#table-two-axis').basictable();

      $('#table-max-height').basictable({
        tableWrapper: true
      });
    });
</script>
<style>
   
    .logo h1 a {
        display: flex;
        align-items: center;
    }
    .logo h1 img {
        margin-right: 10px;
        height: 40px; /* Adjust as needed */
    }
</style>
<!-- //tables -->
</head>
<body class="dashboard-page">

	<nav class="main-menu">
		<ul>
			<li>
				<a href="garageHomePage">
					<i class="fa fa-home nav_icon"></i>
					<span class="nav-text">
					Dashboard
					</span>
				</a>
			</li>
			<li class="has-subnav">
				<a href="getVehicleNoForSearchVehicle">
					<i class="fa fa-list-ul" aria-hidden="true"></i>
					<span class="nav-text">Search Vehicle</span>
					
				</a>
				
			</li>
			<li class="has-subnav">
				<a href="addWorkLog">
				<i class="fa fa-check-square-o nav_icon"></i>
				<span class="nav-text">
				Add Work Log
				</span>
				
				</a>
				
			</li>
			
			
			<li>
				<a href="getVehicleNoForSearchWorkLog">
					<i class="icon-table nav-icon"></i>
					<span class="nav-text">
				    Search Vehicle Work Log
					</span>
				</a>
			</li>
			
			<li>
				<a href="viewNearbyExpiryWorkLogForGarage">
					<i class="fa fa-bar-chart nav_icon"></i>
					<span class="nav-text">
						View nearBy(1 month) expiry work logs
					</span>
				</a>
			</li>
			
			<li>
				<a href="viewExpiredWorkLog">
					<i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
					<span class="nav-text">
					View Expired Work Logs
					</span>
				</a>
			</li>
			
			
			
			
			
			
		</ul>
		<ul class="logout">
			<li>
			<a href="garageLoginPage">
			<i class="icon-off nav-icon"></i>
			<span class="nav-text">
			Logout
			</span>
			</a>
			</li>
		</ul>
	</nav>
	<section class="wrapper scrollable">
		
		<section class="title-bar">
			<div class="logo">
				<h1><a href="index.html"><img src="./resources/images/logo.png" alt="" />MotorMate</a></h1>
			</div>
			
			
			<div class="header-right">
				<div class="profile_details_left">
					<div class="header-right-left">
						<!--notifications of menu start -->
						
					</div>	
					<div class="profile_details">		
						<ul>
							<li class="dropdown profile_details_drop">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
									<div class="profile_img">	
										<span class="prfil-img"><i class="fa fa-user" aria-hidden="true"></i></span> 
										<div class="clearfix"></div>	
									</div>	
								</a>
								<ul class="dropdown-menu drp-mnu">
									
									<li> <a href="garageLoginPage"><i class="fa fa-sign-out"></i> Logout</a> </li>
								</ul>
							</li>
						</ul>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="clearfix"> </div>
		</section>
		<div class="main-grid">
			<div class="agile-grids">	
				<!-- tables -->
				
				<div class="table-heading">
					<h2>Garage Table</h2>
				</div>
				<div class="agile-tables">
					<div class="w3l-table-info">
					  <h3>Garage Details</h3>
					    <table id="table">
						<thead>
						  <tr>
							<th>Vehicle Number</th>
							<th>Chassis Number</th>
							<th>Vehicle Name</th>
							<th>Owner Name</th>
							<th>Contact Number</th>
							<th>Address</th>
							<th>Email</th>
						    <th>Action</th> 
						  </tr>
						</thead>
						<tbody>
            <%
                  Vehicle vehicle = (Vehicle)request.getAttribute("vehicle");
    
            %>
            <tr>
                <th scope="row"><%=vehicle.getVehicleNo() %></th>
                <td><%=vehicle.getChassisNo() %></td>
                <td><%=vehicle.getName() %></td>
                <td><%=vehicle.getOwnerName() %></td>
                <td><%=vehicle.getContact() %></td>
                <td><%=vehicle.getAddress() %></td>
                <td><%=vehicle.getEmail() %></td>
                
                <td><a href="deleteVehicleForGarage/<%=vehicle.getVehicleNo()%>">Delete</a></td> 
            </tr>
            
            <!-- Add more rows for additional accounts as needed -->
        </tbody>
					  </table>
					</div>
				  
			
			</div>
				<!-- //tables -->
			</div>
		</div>
		<!-- footer -->
		<div class="footer" style="margin-top:36%;">
			<p>© 2024. All Rights Reserved . Design by <a href="http://w3layouts.com/">Swati Gosavi</a></p>
		</div>
		<!-- //footer -->
	</section>
	<script src="./resources/js/bootstrap.js"></script>
	<script src="./resources/js/proton.js"></script>
</body>
</html>
