<?php

$db_name = "humans";
$mysql_username = "root";
$mysql_userpass = "";
$server_name = "localhost";

$connect = mysqli_connect($server_name,$mysql_username,$mysql_userpass,$db_name);

if(!$connect)
{

//echo "Connection Error..".mysqli_connect_error();

}

else
{

//echo "<h3>Database connection Success..</h3>";

}

?>