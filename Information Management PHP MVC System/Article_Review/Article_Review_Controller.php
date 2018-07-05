
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
	margin-left: 325px;
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

$username = "s4908683";
                $password = "Monday22";
                $host = "127.0.0.1";
                $db = $username;
                $connection = mysqli_connect($host, $username, $password, $db);
          
                $queryGenerate = "SELECT * FROM Article";
                $result = mysqli_query($connection, $queryGenerate);
echo $queryGenerate;
while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
                  {

  ?>                	
                
<FORM METHOD="POST" ACTION="Index_Model.php">

  <nav>
  <ul>
    <li class="atitle" name ="title_article" ><h1> <?php echo $row {'Article_Name'}; ?>.    By User1231314     </h1 >
    <br> </li>

    <li> <h3>  <?php echo $row {'Article_Game_Type'}; ?> : <?php echo $row {'Article_Subject'}; ?>     </h3>
   
   
  </ul>


</nav>






<article>
	
  <p><?php echo $row {'Article_Description'}; ?></p>
  <hr>
</article>

<footer><p>Review This Article!</p>
  <input type="range" name="rating" min="1" max="5" value="50">
  <button class="submitPost" style="size: 50pt" name="submitPost" />
	Submit Review</button></footer>

</FORM>
<?php


                  
                }


if (isset($_POST['submitPost'])) {

 if (isset($_SESSION['UserLogged'])) {
error_reporting(E_ALL);
     ini_set('display_errors', 1); 


     $usernameDB = "s4908683";
  $passwordDB = "Monday22";
  $host = "127.0.0.1";
  $db = $usernameDB;
  $connection = mysqli_connect($host, $usernameDB, $passwordDB, $db);



  $rating = $_POST['rating'];
$articleName = $_POST['title_article'];

$query = "UPDATE Article SET  Article_Rating =" . $rating . " WHERE Article_Name= '" .  $articleName . "';";
echo $query;
if (mysqli_query($connection, $query))
        {
        echo "New record created successfully";

        
    	return true;
         
                 } 


 }



}







//}



//}








?>