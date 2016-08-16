<?php
/*
 * 
 * Clase para la conexion y querys de la base de datos 
 * 
 */

class DBConnection{  
  

  var $dbhost = 'localhost';
  var $dbuser = 'root';
  var $dbpass = '';
  var $dbname = 'demo';
  var $dbconnection = null;                                  
  var $dbtype = 'mysql';

  
  function DBConnection(){
  	$this->open();
  }
  
  function setDBParams($host,$user,$pass,$name,$type){
    $this->setDBHost($host);
    $this->setDBUser($user);
    $this->setDBPass($pass);
    $this->setDBName($name);
    $this->setDBType($type);
    $this->close();
  }


  function setDBHost($host) { $this->dbhost = $host; $this->close(); }
  function setDBUser($user) { $this->dbuser = $user; $this->close(); }
  function setDBPass($pass) { $this->dbpass = $pass; $this->close(); }
  function setDBName($name) { $this->dbname = $name; $this->close(); }
  function setDBType($type) { $this->dbtype = $type; $this->close(); }
  function close()
  {
    if(null != $this->dbconnection)
    {
      switch($this->dbtype)
      {
      case 'mysql':
        @mysql_close($this->dbconnection);
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
  function getConnection(){
    $this->close();
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
  
  //core function to create a connection using the class
  function getDBConnection($host,$user,$pass,$name,$type)
  {
	  $DBConnectionObj = new DBConnection;
	  $DBConnectionObj->setDBParams($host,$user,$pass,$name,$type);
	  $DBConnectionObj->open();
	  return $DBConnectionObj;
  }
    
 
  function getQueryResult($query)
  {
    $link = $this->getConnection();
    switch($this->dbtype)
    {
      case 'mysql':   
        $result = mysql_query($query,$link)or die(mysql_error());
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
		if (0 < mysql_num_rows($result) ) {
			$row = mysql_fetch_row($result);
			$value = $row[0];
		}
		else
			$value = null;
		break;
	  case 'mssql':
  		if (0 < mssql_num_rows($result) ) {
			$row = mssql_fetch_row($result);
			$value = $row[0];
		}
		else
			$value = null;
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
	$this->close();
    $result = $this->getQueryResult($query);
    //echo $query;
    //echo mysql_num_rows($result);
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
    if($result){
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
    }
    return $value; 
  }
  
  function insert($command){		
		mysql_query($command,$this->dbconnection) or 
		die("Could NOT complete insert statement " . 
		mysql_error( )."<br><i>$command</i><br>");
		return mysql_insert_id( );
   }
   
   function update($command){
		mysql_query($command,$this->dbconnection) or 
		die("Could NOT complete update statement " . 
		mysql_error( )."<br><i>$command</i><br>");
		return mysql_affected_rows();
   }
   
   function delete($command){
		mysql_query($command,$this->dbconnection) or 
		die("Could NOT complete delete statement " . 
		mysql_error( )."<br><i>$command</i><br>");
		return mysql_affected_rows();
   }
	   
}
?>
