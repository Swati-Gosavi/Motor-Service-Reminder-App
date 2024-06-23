<!DOCTYPE html>
<head>
<title>Get Vehicle Number For Search Vehicle</title>
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
		
</head>
<body class="dashboard-page">
	<script>
	        var theme = $.cookie('protonTheme') || 'default';
	        $('body').removeClass (function (index, css) {
	            return (css.match (/\btheme-\S+/g) || []).join(' ');
	        });
	        if (theme !== 'default') $('body').addClass(theme);
        </script>
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
				<!-- input-forms -->
				<div class="grids">
					<div class="progressbar-heading grids-heading">
						<h2>Search Vehicle</h2>
					</div>
					<div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
									<h4>View Vehicle Details</h4>
								</div>
								<div class="form-body">
									<form action="searchVehicleForGarage" method="post"> 
										<div class="form-group"> 
											<label for="exampleInputEmail1"> Vehicle Number</label> 
											<input type="text" name="vehicleNo" class="form-control" id="vehicleNo" placeholder="Vehicle Number"> 
										</div> 
										
										
										
										<button type="submit" class="btn btn-default w3ls-button">Submit</button> 
									</form> 
								</div>
							</div>
						</div>
					</div>
				</div>
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
