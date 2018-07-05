


<DOCTYPE html/>
<?php

include_once 'Registration_Controller.php';

?>

<html>

<head>

	 <link rel = "stylesheet"
   type = "text/css"
   href = "Registration_structure.css" />


</head>


<body>
	
<FORM ACTION='Registration_Controller.php' METHOD='POST' >

<div class="wrap-login100">



<div class="wrap-input100 validate-input m-b-16" data-validate="Please enter username">
						<input class="input100" type="text" name="username" placeholder="Username">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Please enter password">
						<input class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100"></span>
					</div>







<div class="wrap-input100 validate-input" data-validate = "Please confirm password">
						<input class="input100" type="password" name="passConfirm" placeholder="Confirm Password">
						<span class="focus-input100"></span>
					</div>



					<div class="container-login-form-btn">
						<button class="login-form-btn"  />
							Sign in 
						</button>
					</div>
</div>




</FORM>



	
</body>


</html>

<?php



$username = $_POST["username"];
$password = $_POST["password"];
$passConfirm = $_POST["passConfirm"];

//<INPUT TYPE = "text" name="sname" VALUE ="searchheredgaga">
//<input type="button" value="Sign in now pls" style="font-weight: bold; " onclick="window.location.href='http://student30298.bucomputing.uk/Assignment2/Registration/Registration_Controller.php' "/>
//</form>


session_start();
$_SESSION['neyyy'];
//user interacts with view, contoller checks credentials are valid and passwords match, model then adds user into the system, view is updated confirming user has successfully registered
if (isset($_POST["login-form-btn"]))
  {
$username = $_POST['username'];
function getUserID(){
	$_SESSION['neyyy'] = $username;
            return $this->userID;
        }

    }

?>