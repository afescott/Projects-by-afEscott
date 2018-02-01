<!DOCTYPE html>
<html>
<head>
  <title>
    Login page
  </title>
</head>
<body>

<div class="login-page">
  
    <form class="login-page" action="Homepage.php" method="POST">
      Username:<br />
       <input type="text" name = "username" placeholder="username" size="45"   id ="text1" style="font-weight: bold;" />
       <br />
       Password:<br />
      <input type="password" name = "password" placeholder="password" id = "text2" style="font-weight: bold;"/>
      <br /> 
   <input  type="submit" class="button" name="buttonLogin" value="Login" size="50" style="font-weight: bold;">

<input type="button" value="Proceed as guest" style="font-weight: bold; " onclick="window.location.href='http://student30298.bucomputing.uk/Assignment/Product_page.php'
  "/>
   
  <input type="button" value="Register" style="font-weight: bold; " onclick="window.location.href='http://student30298.bucomputing.uk/Assignment/Registration.php'
  "/>
  <br /> 
  <label> Remember Me </label>
  <input type="checkbox" name="rememberMe" value="yes" checked style="font-weight: bold;" >
  


  
    

   
 



    </form>


    <?php
session_start();
$_SESSION['Guest'];
$username = "s4908683";
$password = "Monday22";
$host = "127.0.0.1";
$db = $username;
$connection = mysqli_connect($host, $username, $password, $db);

if (isset($_COOKIE["cookieRemember"]))
  {
  $user = $_COOKIE['cookieRemember'];
  echo "You are already Logged in as " . $user . " click here to be redirected";
  $queryRemember = "SELECT UserID , Username, Password, Admin " . "FROM Login " . "WHERE Username = '" . $user . "' ";
?>
  <form>
    <br />
  <input  type="button" name="buttonRemember" style="font-weight: bold;" value="Welcome Back, click here to be redirected" size="50" onclick="window.location.href='http://student30298.bucomputing.uk/Assignment/'"/>
</form>
<?php
  }




if ((!empty($_SESSION['login'])) && ($_SESSION['login'] == true))
  { // If user is already logged in
?>
  <script type="text/javascript">
    alert ( "You are already logged in, redirecting you to index now");
  </script>

  <?php
  }

if (mysqli_connect_error())
  {
  echo "Unable to connect to MYSQL: " . mysqli_connect_error();
  }
  else
  {
  echo "<p>connected to server ";
  }

if (isset($_POST["buttonLogin"]))
  {
  if (!empty($_POST['username']) && (!empty($_POST['password'])))
    {
    $userLogin = $_POST["username"];
    $password = $_POST["password"];
    $query = "SELECT UserID , Username, Password, Admin " . "FROM Login " . "WHERE Username = '" . $userLogin . "' AND Password = '" . $password . "' LIMIT 0, 1";
    $result = mysqli_query($connection, $query);
    $row = mysqli_fetch_array($result, MYSQLI_ASSOC);
    if ($row['Username'] == $userLogin && $row['Password'] == $password)
      {
   
      if ((isset($_POST["rememberMe"])) && ($_POST["rememberMe"] == "yes"))
        {
        $name = "cookieRemember";
        $cookieValue = $userLogin;
        $expiry = time() + 3600 * 24;
        $_SESSION["Login"] = true;
        setcookie($name, $cookieValue, $expiry);
        }

      if ($row
        {
        'Admin'} == 1)
          {
          $_SESSION['admin'] = $row['Username'];
          }
          else
          {
          $_SESSION['admin'] = NULL;
          }

        if ($row['Admin'] == 0)
          {
          $_SESSION['user'] = $row['Username'];
          }

        if ($row['Admin'] == NULL)
          {
          $_SESSION['Guest'] = "Guest";
          }
        }
        else
        {
        echo "<h1> User not found, please try again or register</h1>";
        session_destroy();
        }
      }
    }

?>





</div>
</body>
</html>

