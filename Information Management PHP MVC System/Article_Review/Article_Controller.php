



<?php


ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);


session_start();
Class Controller_Review {
	
public function insertRating() {



if (isset($_SESSION['UserLogged'])) {


include ("Article_Review_View.php");


} else {
	echo "You Must be Logged in to View this page";


}



}





}


$controller = new Controller_Review();
$controller->insertRating();





?>