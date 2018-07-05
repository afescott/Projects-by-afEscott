<?php

session_start();

if(isset($_COOKIE['cookieRemember'])){
    echo "hellooo";
}

$username = $_POST["username"];
$password = $_POST["password"];
$passConfirm = $_POST["passConfirm"];

//$username = "yolo";
 //$password ="";
//$passConfirm ="asfa";

//function validateLogin() 
//{

if (empty($username) || (empty($password) || (empty($passConfirm))))
    {
$_SESSION['loginEmpty'];
echo "empty boxes";



}    elseif (!($password == $passConfirm )) {
    $_SESSION['passUnConfirmed'];
    echo "don't match";
    
} else {



    echo "safa"; //include model that registers user into DB


    include 'Registration_Model.php';


$regModel = new Registration_Model();
$params = $regModel -> insertUser ($username,$password);

 
}


//}

class Controller {

    public $view;

    public function __construct() {
        $this->view = new Registration_View();
        $view->invoke();
    }

    public function invoke() {
        if (isset($_POST['book'])) {
            // no special book is requested,
            // we'll show a list of all available books
            $username = $this->view->getUserID();
            
            include 'view/booklist.php';
        } else {
            // show the requested book
            $book = $this->view->getBook($_GET['book']);
            include 'view/viewbook.php';
        }
    }

}
?>