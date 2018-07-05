<?php session_start();
?>
<html>

<head>
	<title>Poker </title>
	<link rel="stylesheet" type="text/css" href="http://student30298.bucomputing.uk/Assignment2/css.css">
</head>

<body>
	<nav>
		<ul>
				<h1>Poker Legends - For all that is the Beautiful Game</h1>
				<h2>Welcome</h2>
			<li>
				<a href="hhttp://student30298.bucomputing.uk/Assignment2/Index_Controller.php">Home</a>
			</li>
			<li>
				<a href="http://student30298.bucomputing.uk/Assignment2/Article/Article_Controller.php">Create new Topic</a>
			</li>
			<li>
				<a href="http://student30298.bucomputing.uk/Assignment2/Profile/Profile_Controller.php">View Existing Topics</a>
			</li>
			<div id= "logout"> 
			<li>
<?php echo "Logged in as " .  $_SESSION['UserLogged']; ?>

<FORM METHOD="POST" ACTION="Index_Controller.php">
<button type="submit" name="logoutbtn"  />

			</li>

			</div>

		</ul>

	</nav>

</body>
<FORM METHOD="POST" ACTION="Search/Search_Results.php">


<p > Search Here for Specific Posts </p> <input  type="text" size="50px" name="searchText" >  
<input type="submit" name="searchBtn" value="Search" style="height:250px; width:100px">
</html>
<h1> Latest Releases </h1>.        

<em>&copy; 2018</em>
</FORM>
 </body>
</html>






