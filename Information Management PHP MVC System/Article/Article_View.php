	


	
<html>

<head>
	<title>Poker </title>
	<link rel="stylesheet" type="text/css" href="http://student30298.bucomputing.uk/Assignment2/css.css">
</head>

<body>
	<nav>
		<ul>
				<h1>Inventory_Management</h1>
				<h2>Welcome</h2>
			<li>
				<a href="http://student30298.bucomputing.uk/Assignment2/Index_Controller.php">Home</a>
			</li>
			<li>
				<a href="http://student30298.bucomputing.uk/Assignment2/Article/Article_View.php">Create new Topic</a>
			</li>
			<li>
				<a href="http://student30298.bucomputing.uk/Assignment2/Profile/Profile_Controller.php">View Existing Topics</a>
			</li>
			<div id= "logout"> 
			<li>
				<a href="http://student30298.bucomputing.uk/Assignment2/Registration/Registration_View.php">Register</a>

			</li>
			</div>
		</ul>
	</nav>
</body>

</html><h1>
   Create a New Topic</h1>
<FORM METHOD="POST" ACTION="Article_Controller.php">
<h2> Select Game Type </h2>


<br>

<select name="pokerGameMode">
  <option value="Texas-Holdem">Texas Holdem</option>
  <option value="Omaha-Holdem">Omaha Hold-em</option>

</select> 
<br>




Post Name:<br> <br> 
<input type="text" name="postName"><br>
Poker Subject: <br>

<select name="pokerSubject">
  <option value="Pre-Flop">Pre-Flop</option>
  <option value="Post-Flop">Post-Flop</option>
  <option value="Bluffing">Bluffing</option>
  <option value="3-Betting">3-Betting</option>
    <option value="Shoving">Shoving</option>
</select> <br>

<h2> Blog Description </h2> <br>

<input type="text" name="postInfo" width="100"; style="font-size: 18pt"; ><br>


<button class="submitPost" style="size: 50pt" name="submitPost" />
	Submit Post	</button>

//link table holders user info and 





</FORM>

<em>&copy; 2018</em>
 </body>
</html>