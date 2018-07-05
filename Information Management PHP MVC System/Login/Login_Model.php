


<?php


class Login_Model {
	

	public Function Login_User ($username, $password) {
	
$usernameDB = "s4908683";
$passwordDB = "Monday22";
$host = "127.0.0.1";
$db = $usernameDB;
$connection = mysqli_connect($host, $usernameDB, $passwordDB, $db);

$query = "SELECT UserID , Username, Password " . "FROM Users " . "WHERE Username = '" . $username . "' AND Password = '" . $password . "' LIMIT 0, 1";


$result = mysqli_query($connection,$query);



if ($r = mysqli_fetch_array($result))
{
    
    return true;

}   else {

	
	return false;
}





}



}


?>