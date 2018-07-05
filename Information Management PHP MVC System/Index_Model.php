
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
h2 {
	margin-left: 170px;
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
                
<FORM METHOD="GET" ACTION="Article_Review/Article_Controller.php">

  <nav>
  <ul>
   
<h1> <a name="titleArticle" href="http://student30298.bucomputing.uk/Assignment2/Article_Review/Article_Controller.php?titleArticle=<?php echo $row {'Article_Name'};?>" > <?php echo $row {'Article_Name'}; ?> > </a> </h1 >

    <li> <h2>  Poker Game Type:  <?php echo $row {'Article_Game_Type'}; ?>.                    Subject :  <?php echo $row {'Article_Subject'}; ?>     </h2>
    	<h1> Click the Article to view & rate it </h1>
   
   
  </ul>


</nav>
</li>
</ul>
</nav>
</FORM>



<?php



}


                  
               


?>