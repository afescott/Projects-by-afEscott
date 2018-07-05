<?php



include("Login_View.php");

session_start();




Class controller {


public function verifyUser () {


$_SESSION['UserOption'];

$username1 = $_POST["username1"];
$password1 = $_POST["password1"];


if (empty($username1) || (empty($password1)))

    {

echo "Please ensure both Text boxes have values";

    }

    else {
require_once("Login_Model.php");
$Login_Model = new Login_Model();

	if (!$Login_Model -> Login_User($username1,$password1)) {
echo "Your Credentials do not match our data stored on our database, please try again";


} else {
echo "You're logged in, Welcome! " . $username1;
  $_SESSION['UserLogged'] = $username1;
        
if (isset($_POST["Remember"]))
{
$cookieName = "cookieRemember";
        $cookieValue = $username1;
        $expiry = time() + 3600 * 24;
        
        setcookie($cookieName, $cookieValue, $expiry);
$_SESSION['UserLogged'] = $username1;

header("Location: http://student30298.bucomputing.uk/Assignment2/Index_Controller.php");



} else
{

$_SESSION['UserOption'] = $_SESSION['UserNotRemembered'];


}

}



    }


}
}


$controller = new controller();
$controller->verifyUser();











              

             
           


?>