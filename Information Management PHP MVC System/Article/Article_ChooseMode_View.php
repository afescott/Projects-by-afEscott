<DOCTYPE html/>


<html>



<FORM ACTION='Article_Controller.php' METHOD='POST' > 



<h1> Please Select the Poker Game you wish to Create an Article About </h1>


<br>

<select name="pokerGameMode" size="20">
  <option value="Texas-Holdem">Texas Holdem</option>
  <option value="Omaha-Holdem">Omaha Hold-em</option>

</select> <br>





<button class="chooseMode" style="size: 50pt"  />
	ChooseMode	</button>






</FORM>



</html>




<?php
session_start();

$_SESSION['varname'] = $_POST["pokerGameMode"];;




?>





