<?php 

session_start();

class Model {

public function insertPost($Article_Name,$Poker_Game_Mode,$Article_Subject,$Article_Description) {

$usernameDB = "s4908683";
  $passwordDB = "Monday22";
  $host = "127.0.0.1";
  $db = $usernameDB;
  $connection = mysqli_connect($host, $usernameDB, $passwordDB, $db);






$query = "INSERT into Article (Article_Name, Article_Game_Type, Article_Subject, Article_Description, Article_DateTime, User_Name) VALUES ('" . $Article_Name . "', '" . $Poker_Game_Mode . "'  , '" . $Article_Subject . "', '" . $Article_Description . "', '" . date("Y/m/d") . "',   '" . $_SESSION['UserLogged'] . "'  ); ";



   

$result = mysqli_query($connnection, $query);
  	

  	if (mysqli_query($connection, $query))
        {
        echo "New record created successfully";

        
    	return true;
         
                 } 






}

}



?>