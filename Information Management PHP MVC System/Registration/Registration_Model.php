<?php 

require_once('Registration_Controller.php');



class Registration_Model {





public function insertUser($usernameeh,$passwordeh){

$usernameDB = "s4908683";
  $passwordDB = "Monday22";
  $host = "127.0.0.1";
  $db = $usernameDB;
  $connection = mysqli_connect($host, $usernameDB, $passwordDB, $db);

 
$queryy = "SELECT * FROM Users  WHERE Username = '$usernameeh'";
echo $queryy;
        $resultt = mysqli_query($connection, $queryy);
if (mysqli_num_rows($resultt) >0) {

    	echo " user already exists";



     


    }  else  {
    	$query = "INSERT into Users (Username, Password) VALUES ('" . $usernameeh . "', '" . $passwordeh . "'); ";


  	$result = mysqli_query($connnection, $query);
    
  	echo $query;

  	if (mysqli_query($connection, $query))
        {
        echo "New record created successfully";

        
    	return true;
         
                 } 
    }  





}







}





?>