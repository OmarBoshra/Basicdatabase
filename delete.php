<?php

require "connection.php";

$user_name=$_POST["name"];
$user_age=$_POST["age"];

$sql_query="delete from names where name like '$user_name' and age like'$user_age';";

if(mysqli_query($connect,$sql_query)){

echo "delete success";
}else{
echo "unsucessful delete";
}

?>
