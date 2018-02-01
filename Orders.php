<!DOCTYPE html>
<html>
<head>
  <title>Bookstore inventory management</title>
</head>
<body>

<form class="Order-form" action="Orders.php" method="POST">


<?php
session_start();

if (isset($_SESSION['admin']))
  {
?>
  <input style="margin-left: 3%" type="text" name = "orderID"  size="20"    />
  <input  type="submit" class="button" name="buttonSearch" value="Search here" style="margin-left: 0%" >

  <?php
  $username = "s4908683";
  $password = "Monday22";
  $host = "127.0.0.1";
  $db = $username;
  $connection = mysqli_connect($host, $username, $password, $db);
  if (mysqli_connect_error())
    {
    echo "Unable to connect to MYSQL: " . mysqli_connect_error();
    }
    else
    {
    echo "<p>connected to server ";

    // add, edit, update tables here

    $query = "SELECT * FROM Order_Table;";
    $result = mysqli_query($connection, $query);
?>
<table width="1100" border="1" cellpadding="1" cellspacing="1"> 
<tr> 
  <TH>OrderID</TH>
  <TH>ProductID </TH>
  <TH>Email </TH>
  <TH>OrderQuantity </TH>

</tr>

<?php
    while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
      {
?>
    <tr>

  
  <td> <?php
      echo $row
        {
        'OrderID'}; ?> </td>
  <td> <?php
        echo $row
          {
          'ProductID'}; ?> </td>
  <td> <?php
          echo $row
            {
            'Email_Address'}; ?> </td>
  <td> <?php
            echo $row
              {
              'Order_Quantity'}; ?> </td>

 
</tr>
<?php
              }

            // after all work complete disconnect from server

            }
          }
          else
          {
?>
  <h1>You are not permitted to access this address, Sorry</h1>
  <?php
          }

?>










<?php
        if (isset($_POST['buttonSearch']))
          {
          $username = "s4908683";
          $password = "Monday22";
          $host = "127.0.0.1";
          $db = $username;
          $connection = mysqli_connect($host, $username, $password, $db);
          $orderID = $_POST["orderID"];
          $querySearch = "SELECT * FROM Order_Table WHERE OrderID =  " . $orderID . ";";
          $result = mysqli_query($connection, $querySearch);
?>
<table width="1100" border="1" cellpadding="1" cellspacing="1">
  <br />
  <br />
  <br />
<tr> 
  <TH>Order ID </TH>
  <TH>Product ID</TH>
  <TH>Email Address </TH>
  <TH>Product Quantity </TH>

</tr>
<?php
          while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
            {
?>

    <tr>

  
  <td> <?php
            echo $row
              {
              'OrderID'}; ?> </td>
  <td> <?php
              echo $row
                {
                'ProductID'}; ?> </td>
  <td> <?php
                echo $row
                  {
                  'Email_Address'}; ?> </td>
  <td> <?php
                  echo $row
                    {
                    'Order_Quantity'}; ?> </td>
</tr>
<?php
                    }
                  }

?>

















</body>
</html>