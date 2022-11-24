<?php

$conexion = mysqli_connect ('localhost', 'root', '', 'apptraffic');
if (!$conexion) {
  echo "error en conexion";
}

$id = $_POST['id'];
$query = "DELETE FROM incidente WHERE id = '$id'";
$result = mysqli_query($conexion, $query);

if ($result) {
	echo "Datos eliminados";
}else{
	echo "Error";
}
mysql_close($conexion);

?>