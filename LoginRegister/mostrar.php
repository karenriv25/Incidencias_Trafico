<?php

$conexion = mysqli_connect ('bebvo4jvwsmvw72gyirs-mysql.services.clever-cloud.com', 'u6jm4ymwgy8lvnno', 'pp5Y84AsbBc8rJcEdvDS', 'bebvo4jvwsmvw72gyirs');
if (!$conexion) {
  echo "error en conexion";
}

$result = array();
$result ['datos'] = array();
$query = "SELECT *FROM tba_incidente";
$responce = mysqli_query($conexion,$query);


while ($row = mysqli_fetch_array($responce)) {
  $index ['id'] =$row ['0'];
  $index ['Direccion'] =$row ['1'];
  $index ['Distrito'] =$row ['2'];
  $index ['Descripcion'] =$row ['3'];

  array_push($result ['datos'], $index);
}

$result["exito"]="1";
echo json_encode($result);

?>
