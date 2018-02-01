<<!DOCTYPE html>
<html>
<head>
  <title>"Welcome to the product management screen"</title>
</head>
<body>

  


<?php
session_start();
$username = "s4908683";
$password = "Monday22";
$host = "127.0.0.1";
$db = $username;
$connection = mysqli_connect($host, $username, $password, $db);

if (isset($_POST['addItem']))
  {
  $productID = $_POST["productID"];
  $product_name = $_POST["productName"];
  $product_Manufacturer = $_POST["productType"];
  $product_type = $_POST["productManufacturer"];
  $Product_Description = $_POST["productDescription"];
  $query = "INSERT INTO Inventory_Management (ProductID, Product_Name, Product_Type, Product_Manufacturer, Product_Description) 
       VALUES (" . $productID . ", '" . $product_name . "', '" . $product_type . "', '" . $product_Manufacturer . "', '" . $Product_Description . "'); ";
  $result = mysqli_query($connection, $query);
  if (mysqli_query($connection, $query))
    {
    echo "New record created successfully";
    }
    
  }






    if (isset($_POST['updateItem']))
  {
  $username = "s4908683";
  $password = "Monday22";
  $host = "127.0.0.1";
  $db = $username;
  $connection = mysqli_connect($host, $username, $password, $db);
  $productID = $_POST["productID"];
  $product_name = $_POST["productName"];
  $product_Manufacturer = $_POST["productType"];
  $product_type = $_POST["productManufacturer"];
  $Product_Description = $_POST["productDescription"];
  $query = "UPDATE Inventory_Management SET ProductID = " . $productID . ",  Product_Name = '" . $product_name . "',   Product_Type = '" . $product_type . "',   Product_Manufacturer = '" . $product_Manufacturer . "',   Product_Description = '" . $Product_Description . "' WHERE ProductID= " . $productID . ";";
  
  $result = mysqli_query($connection, $query);

  }

if (isset($_POST['deleteitem']))
  {
  $username = "s4908683";
  $password = "Monday22";
  $host = "127.0.0.1";
  $db = $username;
  $connection = mysqli_connect($host, $username, $password, $db);
  $productID = $_POST["productID"];
  $product_name = $_POST["productName"];
  $product_Manufacturer = $_POST["productType"];
  $product_type = $_POST["productManufacturer"];
  $Product_Description = $_POST["productDescription"];
  $query = "DELETE FROM Inventory_Management WHERE ProductID =" . $productID;
  if ($result = mysqli_query($connection, $query))
    {
    echo "Product deleted";
    }
    else
    {
    echo "Please try again";
    }
    

    
    }



if ( isset($_SESSION['admin']) ) 
{
  echo "Welcome Admin";
  ?>
  <h2> Manage Products here </h2>
  <form class="login-form" action="Product_page.php" method="POST">
    <label style="margin-left: 0%"  >     Product ID </label>
<label style="margin-left: 13%"  >     Product Name </label>
<label style="margin-left: 8%"  >     Product Type </label>
<label style="margin-left: 8%"  >     Product Manufacturer</label>
<label style="margin-left: 8%"  >     Product Description </label>
  <br>
  <input style="margin-left: 0%" type="text" name = "productID" placeholder="username" size="20"    />
<input  type="submit" class="button" name="deleteitem" value="Delete Item" style="margin-left: 0%" >

  <input style="margin-left: 3%" type="text" name = "productName"  size="20"    />
  <input style="margin-left: 3%" type="text" name = "productType" size="20"    />
  <input style="margin-left: 8%" type="text" name = "productManufacturer"  size="20"    />
  <input  style="margin-left: 10%" type="text" name = "productDescription"  size="20"    />
  <br> <br>
  <input  type="submit" class="button" name="addItem" value="Insert Item" style="margin-left: 0%" >
  <input  type="submit" class="button" name="updateItem" value="Update Item" style="margin-left: 0%" >

<br>
<br>
<br>





    <?php
} 


if (isset($_SESSION['user']) || (isset($_SESSION['admin']))) {
  
?>
<h2> Submit Orders for acceptance here:</h2>
<br>
<br>
<form class="login-form" action="Product_page.php" method="POST">
 <input style="margin-left: 3%" type="text" name = "orderProductID" placeholder="ProductID" size="20"    />
  <input style="margin-left: 3%" type="text" name = "orderProductQuantity" placeholder="Product Quantity" size="20"    />
  <input style="margin-left: 3%" type="text" name = "orderEmailAddress" placeholder="Email Address" size="20"    />
<input  type="submit" class="button" name="orderSubmit" value="Submit Order" style="margin-left: 0%" >

  <br>
  <br>
  <?php



if (isset($_POST['orderSubmit'])) {
?>
<form class="login-form" action="Product_page.php" method="POST">

</form>
<?php
$username = "s4908683";
$password = "Monday22";
$host = "127.0.0.1";
$db = $username;
$connection = mysqli_connect($host, $username, $password, $db);


  $orderProductID = $_POST["orderProductID"];
  $orderProductQuantity = $_POST["orderProductQuantity"];
    $orderEmailAddress = $_POST["orderEmailAddress"];
  

   $query =  "INSERT into Order_Table (ProductID, Email_Address, Order_Quantity) VALUES ( ". $orderProductID . ", '" . $orderEmailAddress .  "', ". $orderProductQuantity ."); ";

   $queryResult = "SELECT * FROM Inventory_Management WHERE ProductID = '" . $orderProductID . "' ";


$result = mysqli_query($connection, $queryResult);

$found = mysqli_num_rows($result);
$row = mysqli_fetch_array($result,
MYSQLI_ASSOC);
$stockCheck = $row['Stock_Quantity']- $orderProductQuantity;

echo $stockCheck;

if ($found>0)
{
  if ($stockCheck >= 0 ){
    echo "Positive";
    if (mysqli_query($connection, $query)) 
     {
    echo "New record created successfully";

 $queryUpdateStock = "UPDATE Inventory_Management SET Stock_Quantity = " . $stockCheck .  " WHERE ProductID= " . $orderProductID . ";";
 
$result=mysqli_query($connection,$queryUpdateStock);
    
     } else
     {
  
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  
     }

  }
  else if ($stockCheck < 0) {
  echo "Your order is too high to be complete, please select a lower amount of quantity";
  }
}



}
}






if (mysqli_connect_error()) {
echo "Unable to connect to MYSQL: " . mysqli_connect_error();
}
else
{
  
  
$query = "SELECT * FROM Inventory_Management;";
$result=mysqli_query($connection,$query);
?>
<html>
<head>
  <title>Bookstore inventory management</title>
</head>
<body>

 

<table width="1100" border="1" cellpadding="1" cellspacing="1"> 
<tr> 
  <TH>Product ID</TH>
  <TH>Product Name </TH>
  <TH>Product Type </TH>
  <TH>Product Manufacturer </TH>
<TH>Product Description</TH>
<TH>Stock_Quantity</TH>
</tr>

<?php  





while ($row = mysqli_fetch_array($result,
MYSQLI_ASSOC))
{
    ?>
    <tr>

  
  <td> <?php echo  $row{'ProductID'}; ?> </td>
  <td> <?php echo  $row{'Product_Name'}; ?> </td>
  <td> <?php echo $row{'Product_Type'}; ?> </td>
  <td> <?php echo $row{'Product_Manufacturer'};?> </td>
  <td> <?php echo $row{'Product_Description'}; ?> </td>
<? 
  if isset($_SESSION['admin']){
    ?>
      <td> <?php echo $row{'Stock_Quantity'};?> </td>



</tr>
<?php
    
}
  
}
 



 ?>
 



<form class="login-form" action="Product_page.php" method="POST">


  <br>
<label> Search Here for a product: </label>
  <input type="text" name = "searchBox" size="30">
<input  type="submit" class="button" name="insert" value="Search" style="margin-left: 0%" >
<br> <br>

</form>

<?php

    if (isset($_POST['insert']))
                {
                insert();
                }

              function insert()
                {
                $username = "s4908683";
                $password = "Monday22";
                $host = "127.0.0.1";
                $db = $username;
                $connection = mysqli_connect($host, $username, $password, $db);
                $product_name = $_POST["searchBox"];
                $querySearch = "SELECT * FROM Inventory_Management WHERE Product_Name LIKE  '%" . $product_name . "%'";
                $result = mysqli_query($connection, $querySearch);
?>
<table width="1100" border="1" cellpadding="1" cellspacing="1">
  <br />
  <br />
  <br />
<tr> 
  <TH>Product ID </TH>
  <TH>Product Name </TH>
  <TH>Product Type </TH>
  <TH>Product Manufacturer </TH>
<TH>Product Description</TH>
<TH>Stock_Quantity</TH>
</tr>
<?php
                while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
                  {
?>

    <tr>

  
  <td> <?php
                  echo $row
                    {
                    'ProductID'}; ?> </td>
  <td> <?php
                    echo $row
                      {
                      'Product_Name'}; ?> </td>
  <td> <?php
                      echo $row
                        {
                        'Product_Type'}; ?> </td>
  <td> <?php
                        echo $row
                          {
                          'Product_Manufacturer'}; ?> </td>
  <td> <?php
                          echo $row
                            {
                            'Product_Description'}; ?> </td>
  <td> <?php
                            echo $row
                              {
                              'Stock_Quantity'}; ?> </td>
</tr>
<?php
                              }
                            }

?>












</body>
</html>