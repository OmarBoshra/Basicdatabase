<?php

require "connection.php";

$user_name=$_POST["name"];
$user_age=$_POST["age"];

$sql_query="select name from names where name like '$user_name' and age like '$user_age';";

$result=mysqli_query($connect,$sql_query);

if(mysqli_num_rows($result)>0){

$firstrow = mysqli_fetch_assoc($result);
$name = $firstrow["name"];

echo "Hello Welcome".$name;

}else{
echo "no info available";
}


?>