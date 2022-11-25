<?php

$conexion = mysqli_connect ('bebvo4jvwsmvw72gyirs-mysql.services.clever-cloud.com', 'u6jm4ymwgy8lvnno', 'pp5Y84AsbBc8rJcEdvDS', 'bebvo4jvwsmvw72gyirs');
if (!$conexion) {
  echo "error en conexion";
}

$id = $_POST['id'];
$query = "DELETE FROM tba_incidente WHERE id = '$id'";
$result = mysqli_query($conexion, $query);

if ($result) {
	echo "Datos eliminados";
}else{
	echo "Error";
}
mysqli_close($conexion);

?>