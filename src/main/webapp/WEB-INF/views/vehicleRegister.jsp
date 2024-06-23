<!-- A Design by Swati Gosavi
Author: Swati Gosavi
-->

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Vehicle Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Colored Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free web designs for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> 
        addEventListener("load", function() { 
            setTimeout(hideURLbar, 0); 
        }, false); 
        function hideURLbar(){ 
            window.scrollTo(0,1); 
        } 
    </script>
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
</head>
<body class="signup-body">
    <div class="agile-signup">    
        <div class="content2">
            <div class="grids-heading gallery-heading signup-heading">
                <h2>Vehicle Registration</h2>
            </div>
            <form action="afterVehicleRegistration" method="post">
                <input type="text" name="vehicleNo" placeholder="Vehicle Number" required>
                <input type="text" name="chassisNo" placeholder="Chassis Number" required>
                 <input type="text" name="name" placeholder="Vehicle Name" required>
                <input type="text" name="ownerName" placeholder="Owner Name" required>
                <input type="tel" name="contact" placeholder="Contact Number" required>
                <input type="text" name="address" placeholder="Address" required>
                <input type="email" name="email" placeholder="Email" required>
                <input type="password" name="password" placeholder="Password" required>
                <input type="submit" class="register" value="Register">
            </form>
            <div class="garage-vehicle-buttons">
                <a href="adminLoginPage" class="btn btn-outline-primary ml-2">Admin Login</a>
                <a href="garageLoginPage" class="btn btn-outline-primary">Garage Login</a>
            </div>
            <p class="register-message">Already registered? <a href="/MotorServiceReminderApp/">Login here</a></p>
        </div>
        <!-- footer -->
        <div class="copyright">
            <p>© 2024. All Rights Reserved . Design by <a href="http://w3layouts.com/">Swati Gosavi</a></p>
        </div>
        <!-- //footer -->
    </div>
    <script src="./resources/js/proton.js"></script>
</body>
</html>
