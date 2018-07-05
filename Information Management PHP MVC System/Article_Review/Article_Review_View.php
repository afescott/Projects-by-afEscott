
<style>
div.container {
    width: 100%;
    border: 1px ;
}

 footer {
    padding: 1em;
    color: white;
    background-color: black;
    clear: left;
    text-align: center;
}
.Atitle{
	margin-left: 170px;
	font: verdana;
}

.slider {
    margin-left: 0px;
}

article {
    margin-left: 170px;
    border-left: 1px;
    padding: 1em;
    overflow: hidden;
}

</style>

<?php
session_start();
//Class Index_Model {


//public function generateArticles() {
include  ("Index_Logged_In.php");
$username = "s4908683";
                $password = "Monday22";
                $host = "127.0.0.1";
                $db = $username;
                $connection = mysqli_connect($host, $username, $password, $db);



          $articleName = $_GET{'titleArticle'};
echo $articleName;
                $queryGenerate = "SELECT * FROM Article WHERE Article_Name =  '" . $articleName . "' ";
                echo $queryGenerate;
                $result = mysqli_query($connection, $queryGenerate);


echo $queryGenerate;
while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
                  {


  ?>                	
                
<FORM METHOD="POST" ACTION="Article_Controller.php">

  <nav>
  <ul>
    <li class="atitle" name ="title_article" ><h1> <?php echo $row {'Article_Name'}; ?> By User1231314 
    <br>

               </h1 >


    <br> </li>

    <li> <h3> <?php echo $row {'Article_Game_Type'}; ?> : <?php echo $row {'Article_Subject'}; ?>     </h3>
<br>
      <li class="timeUploaded" name ="timeUploaded" ><h4>   Time Uploaded : <?php echo $row {'Article_DateTime'}; ?>.       </h4 >
   
   
  </ul>


</nav>






<article>
	
  <p><?php echo $row {'Article_Description'}; ?></p>
  <hr>
</article>

<footer><p>Review This Article!</p>
  <input type="range" name="rating" min="1" max="5" >
  <button class="submitPost" style="size: 50pt" name="submitPost" />
	Submit Review</button></footer>

</FORM>
<?php


                  
                }


if (isset($_POST['submitPost'])) {

 if (isset($_SESSION['UserLogged'])) {



     $usernameDB = "s4908683";
  $passwordDB = "Monday22";
  $host = "127.0.0.1";
  $db = $usernameDB;
  $connection = mysqli_connect($host, $usernameDB, $passwordDB, $db);

$user = $_SESSION['UserLogged'];

  $rating = $_POST['rating'];
$articleName = $_GET['titleArticle'];

$ratingQuery = "INSERT into Article (Article_Review) VALUES ('" . $rating . "'); ";
echo $ratingQuery;
if (mysqli_query($connection, $ratingQuery))
        {
        echo "New record created successfully";

        
    	return true;
         
                 } 


 }



}







//}



//}








?>