<?php

require "connection.php";

$user_name=$_POST["name"];
$user_age=$_POST["age"];


$sql_query="select name from names where name like '$user_name' and age like '$user_age';";

$result=mysqli_query($connect,$sql_query);


if(mysqli_num_rows($result)>0){
echo"An account with a similar name exists";
}else{
$sql_query="insert into names values('$user_name','$user_age');";
}
if(mysqli_query($connect,$sql_query)){
echo"sucess";
}else{
echo"error".mysqli_error($connect);
}

?>