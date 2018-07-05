<?php


session_start();



Class Profile_Controller {
	
public Function AuthenticateUser() {

	 if (isset($_SESSION['UserLogged'])) {
     

   
      include("Index_Logged_In.php");
      
include ("Profile_Model.php");
$Model = new Profile_Model();
$Model->generateUserData();





	 }

	 else {

echo("You do not have Permission to View this page");




	 }




}




}


$controller = new Profile_Controller();
$controller->AuthenticateUser();


?>