 <?php
/*require "DataBaseConfig.php"

  function insertar($direccion, $distrito, $descripcion)
    {
        $direccion = $this->prepareData($Direccion);
        $distrito = $this->prepareData($Distrito);
        $descripcion  = $this->prepareData($Descripcion);
        $this->sql =
            
        "INSERT INTO " . $table . " (Direccion, Distrito, Descripcion,) VALUES ('" . $direccion . "','" . $distrito . "','" . $descripcion . "','".")";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    } */

$conexion = mysqli_connect('bebvo4jvwsmvw72gyirs-mysql.services.clever-cloud.com', 'u6jm4ymwgy8lvnno', 'pp5Y84AsbBc8rJcEdvDS', 'bebvo4jvwsmvw72gyirs');
if (!$conexion) {
  echo "error en conexion";
}

$direccion = $_POST['Direccion'];
$distrito = $_POST['Distrito'];
$descripcion = $_POST['Descripcion'];

//codigo sql

$query = "INSERT INTO tba_incidente(Direccion, Distrito, Descripcion) VALUES ('$direccion', '$distrito', '$descripcion')";
$resultado = mysqli_query($conexion, $query);

if($resultado){
  echo "datos insertados";
}
else
{
  echo "datos erroneos";
}

?>
