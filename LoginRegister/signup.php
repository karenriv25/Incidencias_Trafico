<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['Nombre']) && isset($_POST['Apellido']) && isset($_POST['Celular']) && isset($_POST['Username']) && isset($_POST['Password']) && isset($_POST['CorreElectronico']) && isset($_POST['CodDistrito'])) {

    if ($db->dbConnect()) {
        if ($db->signUp("tba_usuarios", $_POST['Nombre'], $_POST['Apellido'], $_POST['Celular'], $_POST['Username'], $_POST['Password'], $_POST['CorreElectronico'], $_POST['CodDistrito'])) {
            echo "Sign Up Success";
        } else echo "Sign up Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";
/*if (isset($_POST['Nombre']) && isset($_POST['Username']) && isset($_POST['Password']) && isset($_POST['CorreElectronico'])) {

    if ($db->dbConnect()) {
        if ($db->signUp("tba_usuarios", $_POST['Nombre'], $_POST['Username'], $_POST['Password'], $_POST['CorreElectronico'])) {
            echo "Sign Up Success";
        } else echo "Sign up Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";*/
?>
