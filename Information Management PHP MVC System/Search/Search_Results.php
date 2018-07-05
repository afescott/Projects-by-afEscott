<?php 


class search {
public function search() {

if (isset($_POST['searchBtn'])) {

?>
<h1> Here are the search results for the requested query </h1>
<?php

$username = "s4908683";
                $password = "Monday22";
                $host = "127.0.0.1";
                $db = $username;
                $connection = mysqli_connect($host, $username, $password, $db);
                include ("Index_Logged_In.php");
$searchValue = $_POST['searchText'];


                $querySearch = "SELECT * FROM Article WHERE Article_Name LIKE  '%" . $searchValue . "%'";


                $result = mysqli_query($connection, $querySearch);





while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
                  { 


?>


                    <FORM METHOD="POST" ACTION="Index_Logged_In.php">

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




}

}


}


$searchView = new search();
$searchView->search();

?>