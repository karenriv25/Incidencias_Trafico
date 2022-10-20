<?php
require "DataBaseConfig.php";

class DataBase
{
    public $connect;
    public $data;
    private $sql;
    protected $servername;
    protected $username;
    protected $password;
    protected $databasename;

    public function __construct()
    {
        $this->connect = null;
        $this->data = null;
        $this->sql = null;
        $dbc = new DataBaseConfig();
        $this->servername = $dbc->servername;
        $this->username = $dbc->username;
        $this->password = $dbc->password;
        $this->databasename = $dbc->databasename;
    }

    function dbConnect()
    {
        $this->connect = mysqli_connect($this->servername, $this->username, $this->password, $this->databasename);
        return $this->connect;
    }

    function prepareData($data)
    {
        return mysqli_real_escape_string($this->connect, stripslashes(htmlspecialchars($data)));
    }

    function logIn($table, $username, $password)
    {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql = "select * from " . $table . " where Username = '" . $username . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbusername = $row['Username'];
            $dbpassword = $row['Password'];
            if ($dbusername == $username && password_verify($password, $dbpassword)) {
                $login = true;
            } else $login = false;
        } else $login = false;

        return $login;
    }

    function signUp($table, $Nombre, $Apellido, $Celular, $Username, $Password, $CorreElectronico, $CodDistrito)
    //function signUp($table, $Nombre, $Username, $Password, $CorreElectronico,)
    {
        $nombre = $this->prepareData($Nombre);
        $apellido = $this->prepareData($Apellido);
        $celular = $this->prepareData($Celular);
        $username = $this->prepareData($Username);
        $password = $this->prepareData($Password);
        $correElectronico = $this->prepareData($CorreElectronico);
        $codDistrito = $this->prepareData($CodDistrito);
        $password = password_hash($Password, PASSWORD_DEFAULT);
        $this->sql =
            
        "INSERT INTO " . $table . " (Nombre, Apellido, Celular, Username, Password, CorreElectronico, CodDistrito) VALUES ('" . $nombre . "','" . $apellido . "','" . $celular . "','" . $username . "','".$password."','".$correElectronico."','".$codDistrito."')";
        //"INSERT INTO " . $table . " (Nombre, Username, Password, CorreElectronico) VALUES ('" . $nombre . "','" . $username . "','".$password."','".$correElectronico."')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

}

?>
