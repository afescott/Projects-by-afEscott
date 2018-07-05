<?php

session_start();
Class Profile_Model {

public function generateUserData() {

$username = "s4908683";
                $password = "Monday22";
                $host = "127.0.0.1";
                $db = $username;
                $connection = mysqli_connect($host, $username, $password, $db);


ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);

                $queryDisplay = "SELECT * FROM Article WHERE User_Name = '" . $_SESSION['UserLogged'] . "';";

               



                 $result = mysqli_query($connection, $queryDisplay);





while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
                  {


  ?>                	
                
<FORM METHOD="GET" ACTION="Article_Review/Article_Controller.php">

  <nav>
  <ul>
   
<h1> <a name="titleArticle" href="http://student30298.bucomputing.uk/Assignment2/Article_Review/Article_Controller.php?titleArticle=<?php echo $row {'Article_Name'};?>" > <?php echo $row {'Article_Name'}; ?> > </a> </h1 >




    <li> <h2>  Poker Game Type:  <?php echo $row {'Article_Game_Type'}; ?>.   
                     Subject :  <?php echo $row {'Article_Subject'}; ?>     </h2>
    	<h3>  Time Uploaded : <?php echo $row {'Article_DateTime'};?> </h3>

    	
   <h3>  Average Rating for this Blog <?php echo $row {'Article_Review'};?> </h3>
   
  </ul>


</nav>
</li>
</ul>
</nav>
</FORM>



<?php



}

}
}






?>