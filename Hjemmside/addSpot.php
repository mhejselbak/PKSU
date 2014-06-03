<?php
require("phpsqlajax_dbinfo.php");

$con=mysql_connect ('mysql12.gigahost.dk', $username, $password);
if (!$con) {  die('Not connected : ' . mysql_error());}

// Set the active MySQL database

$db_selected = mysql_select_db($database, $con);
if (!$db_selected) {
  die ('Can\'t use db : ' . mysql_error());
}

// escape variables for security
$name = $_POST['name'];
$address = $_POST['address'];
$type = $_POST['type'];
$url =  $_POST['url'];

// Insert data into mysql 
$sql="INSERT INTO markers (name, address, type, picture)
VALUES ('$name', '$address', '$type', '$url')";
$result=mysql_query($sql);

// if successfully insert data into database, displays message "Successful". 
if($result){
echo "Successful";
echo "<BR>";
echo "<a href=''>Back to main page</a>";
}

else {
echo "ERROR";
}
?> 

<?php 
// close connection 
mysql_close();




?>