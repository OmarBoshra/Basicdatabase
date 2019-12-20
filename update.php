<?php

require "connection.php";

$olduser_name=$_POST["name"];
$user_name=$_POST["nname"];
$user_age = $_POST["nage"];

$sql_query = "update names set name ='$user_name' , age = '$user_age' where name ='$olduser_name';";

if(mysqli_query($connect,$sql_query)){
echo "update success";
}else{
echo "no update";
}


?>
