<?php


session_start();

include("Article_View.php");


//error_reporting(E_ALL);
  //  ini_set('display_errors', 1);

class Controller  {
	



public function verifyInfo() {



$pokerGameMode = $_POST["pokerGameMode"];;

$postTitle = $_POST["postName"];
$postSubject = $_POST["pokerSubject"];
$postInfo = $_POST["postInfo"];











//if (empty($postSubject) || (empty($postInfo) || (empty($postTitle))))
    //{
//empty
    //	echo "empty";
   // } else {


include("Article_Model.php");
$Article_Model = new Model();
$Article_Model -> insertPost ($postTitle,$pokerGameMode, $postSubject,$postInfo);




//open model


   // }




}






}






$controller = new Controller();
if (isset($_POST["submitPost"])){
	if (isset($_SESSION['UserLogged'])) {


	$controller->verifyInfo();
}


else {

?>
<h1> You Must be logged in to post using this website </h1>
<?php

}


}


//if (isset($_COOKIE['cookieRemember'])) {
//echo "cookieOnine";



//} else {
	//echo "noooo";
//}





?>