<?php
define('DBHOST','db_host'); // localhost
define('DBNAME','db_name'); // database
define('DBUSER','db_user'); // username
define('DBPASS','db_pass'); // password

### CONNECTION ###
try {
	$dbh = new PDO('mysql:host='.DBHOST.';dbname='.DBNAME.';charset=utf8', DBUSER, DBPASS, array(PDO::ATTR_PERSISTENT => true));
	#$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	#foreach($dbh->query('SELECT * from gjul12_inscripciones') as $row) print_r($row);
} catch (PDOException $e) {
	print "Error!: " . $e->getMessage() . "<br/>";
	die();
}

### INSERTION ###
try {
	$stmt = $dbh->prepare("INSERT INTO db_table (email, nombre) 
						   VALUES 
						   (:email, :nombre) ");
	$stmt->execute(array('email'=>'a@a.a', 'nombre'=>'abc xyz'));
	$err_stmt = $stmt->errorInfo();
	
	if($err_stmt[0]=='00000'){
		### INSERT SUCCESS ###;
	}
} catch (PDOException $e) {
	print "Error!: " . $e->getMessage() . "<br/>";
	die();
}

### SELECTION ###
try {
	$stmt = $dbh->prepare("SELECT * FROM db_table WHERE email = :email AND nombre = :nombre");
	$stmt->execute(array('email'=>'a@a.a', 'nombre'=>'abc xyz'));
	
	$result = $stmt->fetchObject();
	 // ->fetchAll();  //  PDO::FETCH_OBJ, PDO::FETCH_ASSOC, PDO::FETCH_NUM
	
	if($stmt->rowCount()>=1){
		printf("%s %s<br />", $result->email, $result->nombre);
	}
} catch (PDOException $e) {
	print "Error!: " . $e->getMessage() . "<br/>";
	die();
}
