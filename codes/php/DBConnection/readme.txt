(1) The "ntwdblib.dll" goes into one of these three paths:

		a) C:\xampp\apache\bin     ### The Most Important One ###
		b) C:\xampp\php
		c) C:\xampp\php\php4

(2) You must use these "ini_set" to overcome the 4096 Field Data Limit:

		a) ini_set('mssql.textlimit' , '2147483647');
		b) ini_set('mssql.textsize'  , '2147483647');
		
(3) This "ini_set" is to overcome the SQL-Server Time Limit:

		a) ini_set('mssql.timeout' , '0');

(4) Overcoming short-lasting remote connections:
		
		a) ini_set('max_execution_time',0);
		b) ini_set('default_socket_timeout',300);		
		c) ini_set('memory_limit','16M');
		

(5) Script for Testing MS SQL Server Errors:

		ini_set('mssql.textlimit' , '2147483647');      // MS SQL INI
		ini_set('mssql.textsize'  , '2147483647');
		ini_set('mssql.timeout', 0);

		ini_set('max_execution_time',0);                // PHP INI
		ini_set('default_socket_timeout',300);	
		ini_set('memory_limit','16M');

		//echo $select_query. '<br />';
		//$select_query = 'select 1' ;
		mssql_connect(DB_HOST,DB_USER,DB_PASS);         // QUERY EXECUTION
		mssql_select_db(DB_NAME);
		$resultset = mssql_query($select_query);
		$last_msg  = mssql_get_last_message() ;
		$rowsnum   = mssql_num_rows($resultset) ;

		echo "                                          // OUTPUT
		<hr />
		MSSQL last message: {$last_msg} <br />
		Total Rows: {$rowsnum}  <br />
		<hr />";