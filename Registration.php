<!DOCTYPE html>
<html>
<head>
  <title>
    Registration page
  </title>
</head>
<body>







  <div class="Registration-page">
    <form class="Registration-page" action="Registration.php" method="POST">

<h1> Register Here below </h1>
Username:<br />
       <input type="text" name = "registerUsername" placeholder="username"  style="font-weight: bold;"  />
       <br />
       Password:<br />
      <input type="password" name = "registerPassword" placeholder="" style="font-weight: bold;"/>
      <br /> 
       Confirm Password:<br />
      <input type="password" name = "registerConfirmPass" placeholder="" style="font-weight: bold;"/>
      <br /> 
      <input type="submit" name = "registerButton" placeholder="Register" style="font-weight: bold;"/>
      <br /> 

</form>

<?php

if (isset($_POST["registerButton"]))
  {
  if (!empty($_POST['registerUsername']) && (!empty($_POST['registerPassword']) && (!empty($_POST['registerConfirmPass']))))
    {
    $regUser = $_POST["registerUsername"];
    $regPass = $_POST["registerPassword"];
    $regConfPass = $_POST["registerConfirmPass"];
    $username = "s4908683";
    $password = "Monday22";
    $host = "127.0.0.1";
    $db = $username;
    $connection = mysqli_connect($host, $username, $password, $db);
    if ($regPass == $regConfPass)
      {
      $query = "INSERT into Login (Username, Password) VALUES (' " . $regUser . "', '" . $regPass . "'); ";
      $result = mysqli_query($conn, $query);
      if (mysqli_query($connection, $query))
        {
        echo "New record created successfully";
?>
    <br />
    <br />
<input type="button" value="Click here to return to the login" style="font-weight: bold;" style="font-weight: bold;"onclick="window.location.href='http://student30298.bucomputing.uk/Assignment/Homepage.php'
  "/>
<?php
        }
      }
      else
      {
      echo "Please make sure both passwords match";
      }
    }
    else
    {
    echo "One of your boxes is empty, please ensure all are filled";
    }
  }

?>





</div>
</body>
</html>

