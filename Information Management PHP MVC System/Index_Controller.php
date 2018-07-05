<?php


session_start();



Class Index_Controller {
	
public Function DetermineLogged() {
if (isset($_POST['logoutBtn'])){

	session_destroy();
}
	 if (isset($_SESSION['UserLogged'])) {
     

   
      include("Index_Logged_In.php");
      
include ("Index_Model.php");




	 }

	 else {

include("index.php");
include ("Index_Model.php");




	 }


}



}










$controller = new Index_Controller();
$controller->DetermineLogged();













?>