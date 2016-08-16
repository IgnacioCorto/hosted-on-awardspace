<?PHP

//include("config.php");

	class cConnection
	{
        var $con;
		var $db;		
		var $result;		
		var $quer;
		var $rCount;
		var $EOF;

        function cConnection($db, $hostName, $userName,$password)
	    {
  			$this->con = mysql_connect($hostName, $userName, $password) or 
			die("Could not connect: " . mysql_error() );

			$this->db =$db;
		    mysql_select_db($this->db, $this->con) or 
			die("Could not select database: " . mysql_error());   		    
		}
		function _cConnection(){
			mysql_close($this->con);
		}
		function begin() {
	   mysql_query("BEGIN", $this->con);
	  }
	  	function rollback() {
	  	mysql_query("ROLLBACK", $this->con);
	  }	 
	  	function commit() {
	  	mysql_query("COMMIT", $this->con);
	  }	  			 
		function runQuery($query)
		{
			$this -> EOF=false;
			$this->rCount = 0;

			$this->quer = $query;
			$this->result = mysql_query($query, $this->con) or 
			die("Could NOT run Query: " . mysql_error()."<br><i>$query</i><br>");


		}
        function insert($command) 
       {
		$this->EOF = false;
		$this->rCount = 0;
		$this->quer = $command;
		mysql_query($command,$this->con) or 
        die("Could NOT complete insert statement " . 
        mysql_error( )."<br><i>$command</i><br>");
        return mysql_insert_id( );
       }
		function moveNext()
		{

			$this->rCount++;
			if($this->rCount > mysql_num_rows($this->result) || mysql_num_rows($this->result)==0)
       		        {
				$this->EOF = true;
			} 
			else 
			
			{
				$this->EOF = false;

			}

			return mysql_fetch_array($this->result);			
		}
		function moveFirst()
		{
			$this->result = mysql_query($this->quer, $this->con) or 
			die("Go Back!");

			return mysql_fetch_array($this->result);
		}
		function moveLast()
		{
			while($dump = mysql_fetch_array($this->result))
			{
				$out = $dump;
			}

			return $out;
		}
		function close()
		{
			mysql_close($this->con);
		}
		function recCount()
		{
			return mysql_num_rows($this->result);
		}
		function getArray()
		{
			while ( $array = mysql_fetch_array($this->result) )
			{
				$arrFinal[] = $array;
			}				
			return $arrFinal;
		}
		function getFirst()	{
			$array = mysql_fetch_array($this->result);
			return $array;
		}
		
		function orden($orden)
		{	
		    $Oquery = "SELECT idmarcas AS id,nombre, orden FROM marcas WHERE estado = 1 AND orden = ".$orden;
			$ordenacion = mysql_query($Oquery, $this->con);
			return mysql_fetch_assoc($ordenacion);
			
		}

	}
?>
