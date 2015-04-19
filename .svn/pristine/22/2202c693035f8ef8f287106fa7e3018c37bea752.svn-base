<?php
	$con = mysqli_connect("localhost","my_user","my_password","my_db");
	if (mysqli_connect_errno()) {
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}

	$con->query("INSERT INTO comments (username, content, written) 
	VALUES('".$_POST["username"]."', '".$_POST["content"]."', '".$_POST["written"]."')");

	$con->close();
?>