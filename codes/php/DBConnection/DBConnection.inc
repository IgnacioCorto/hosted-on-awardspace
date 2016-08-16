<?php
/*
 * 
 * Clase para la conexion y querys de la base de datos 
 * 
 */
class DBConnection
{  
  private $dbhost = '127.0.0.1';
  private $dbuser = 'root';  
  private $dbpass = '';
  private $dbname = 'mysql';
  private $dbtype = 'mysql';     ### or mssql 

  private $dbconnection = null;
  
  function setDBParams($host,$user,$pass,$name,$type)
  {
    $this->setDBHost($host);
    $this->setDBUser($user);
    $this->setDBPass($pass);
    $this->setDBName($name);
    $this->setDBType($type);
    $this->close();
  }


  function setDBHost($host) { $this->dbhost = $host; }
  function setDBUser($user) { $this->dbuser = $user; }
  function setDBPass($pass) { $this->dbpass = $pass; }
  function setDBName($name) { $this->dbname = $name; }
  function setDBType($type) { $this->dbtype = $type; }
  function close()
  {
    if(null != $this->dbconnection)
    {
      switch($this->dbtype)
      {
      case 'mysql':
        mysql_close($this->dbconnection);
        break;
      case 'mssql':
        mssql_close($this->dbconnection);
        break;
      }

      $this->dbconnection = null;
    }
  }

 

  /**
   * Metodo para conectar a la base de datos
   *
   * @return connection
   */
  function getConnection()
  { 
    if(null == $this->dbconnection)
      $this->open();

    return $this->dbconnection;
  }

  function open()
  {
    if(null != $this->dbconnection)
      return;

    switch($this->dbtype)
    {
		  case 'mysql':
        $this->dbconnection = mysql_connect($this->dbhost,$this->dbuser,$this->dbpass);
				mysql_select_db($this->dbname);
				break;
      case 'mssql':
        $this->dbconnection = mssql_connect($this->dbhost,$this->dbuser,$this->dbpass);
        mssql_select_db($this->dbname);
        break;
		  default:
        $this->dbconnection = null;
        break;
    }  
  }

  function getQueryResult($query)
  {
    $link = $this->getConnection();
 
    switch($this->dbtype)
    {
      case 'mysql':
        $result = mysql_query($query,$link) or die(mysql_error());
        break;
      case 'mssql':
        $result = mssql_query($query,$link);
        break;
      default:
        $result = null;
        break;     
    }
    #echo $result;

    return $result;
  }

  function getQueryValue($query)
  {
    $result = $this->getQueryResult($query);
    switch($this->dbtype)
    {
      case 'mysql':
        $row = mysql_fetch_row($result);
        $value = $row[0];
        break;
      case 'mssql':
        $row = mssql_fetch_row($result);
        $value = $row[0];
        break;
      default:
        $value = null;
        break;     
    }    
    return $value; 
  }

  function getDSN()
  {
		  # Sample:  mysql://dishtpv_generic:dishtpv 123 $$@mysql.tpv.dishlatino.info/dishtpv
		  $dbtype = $this->dbtype;
		  $dbuser = $this->dbuser;
		  $dbpass = $this->dbpass;
		  $dbhost = $this->dbhost;
		  $dbname = $this->dbname;

		  $dsn_string = "$dbtype://$dbuser:$dbpass@$dbhost/$dbname";

		  return $dsn_string;
  }
  
  function runQuerySelect($query)
  {
    $result = $this->getQueryResult($query);
    $value = array();
    switch($this->dbtype)
    {
      case 'mysql':
        $i =0;
        while($row = mysql_fetch_assoc($result)){
           $value[$i] = $row;
           $i++;
        }       
        break;
      case 'mssql':
        $i =0;
        while($row = mssql_fetch_assoc($result)){
           $value[$i] = $row;
           $i++;
        } 
        break;
      default:
        $value = null;
        break;     
    }    
    return $value; 
  }
  
  function countRow($query)
  {
    $result = $this->getQueryResult($query);
    $value = 0;
    switch($this->dbtype)
    {
      case 'mysql':
        $value = mysql_num_rows($result);      
        break;
      case 'mssql':
        $value = mssql_num_rows($result);
        break;
      default:
        $value = 0;
        break;     
    }    
    return $value; 
  }
}

?>
