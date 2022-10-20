<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['Username']) && isset($_POST['Password'])) {
    if ($db->dbConnect()) {
        if ($db->logIn("tba_usuarios", $_POST['Username'], $_POST['Password'])) {
            echo "Login Success";
        } else echo "Username or Password wrong";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>
