<?php
/*
CREATE TABLE IF NOT EXISTS `race_condition` (
  `entero` int(11) NOT NULL
) 
*/
define('DB_HOST','localhost');
define('DB_USER','root');
define('DB_PASS','');
define('DB_NAME','ignacio');
?>


<form method="post">
<input type="submit" name="ejecutar" value="Limpiar" />
<input type="submit" name="ejecutar" value="Insertar" />
<input type="submit" name="ejecutar" value="Mostrar" />
<input type="submit" name="ejecutar" value="Repetidos" />
<br />
<input type="submit" name="ejecutar" value="Lock Lectura" />
<input type="submit" name="ejecutar" value="Lock Escritura" />
</form>

<?php

if(isset($_POST['ejecutar'])){
	mysql_connect(DB_HOST, DB_USER, DB_PASS) or
		die("Could not connect: " . mysql_error());
	mysql_select_db(DB_NAME);

	switch($_POST['ejecutar']){
		case 'Limpiar':
			$result = mysql_query("TRUNCATE TABLE race_condition") or
				die("Could not connect: " . mysql_error());
			break;
		case 'Lock Lectura':
			echo 'Lock Lectura...';
			$result = mysql_query("LOCK TABLE race_condition READ") or
				die("Could not connect: " . mysql_error());
			// $result = mysql_query("INSERT INTO race_condition VALUES (1)") or
				// die("Could not connect: " . mysql_error());
				sleep(10);
			break;
		case 'Lock Escritura':
			echo 'Lock Escritura...';
			$result = mysql_query("LOCK TABLE race_condition WRITE") or
				die("Could not connect: " . mysql_error());
				sleep(10);
			break;
		case 'Insertar':
			$entero=0;
			echo 'Insertando: ';
			for($i=0;$i<500;$i++){
				//TRAYENDO DATO
				$result = mysql_query("SELECT max(entero) as entero FROM race_condition;") or
					die("Could not connect: " . mysql_error());
				while ($row = mysql_fetch_array($result, MYSQL_ASSOC)) {
					$entero = $row["entero"];
				}
				mysql_free_result($result);
				
				$entero = $entero + 1;
				
				//INSERTANDO
				echo "$entero, ";
				$query1 = "INSERT INTO race_condition(entero) VALUES ($entero);";
				$query2 = "INSERT INTO race_condition(entero) (SELECT max(entero)+1 FROM race_condition LIMIT 1);";
				$query3 = "INSERT INTO race_condition(entero) (SELECT entero FROM race_condition WHERE entero=999999);";
				$result = mysql_query($query1) or
					die("Could not connect: " . mysql_error());
			}
			break;
		case 'Mostrar':
			$result = mysql_query("SELECT * FROM race_condition") or
				die("Could not connect: " . mysql_error());

			echo 'Mostrando: ';

			while ($row = mysql_fetch_array($result, MYSQL_ASSOC)) {
				printf("%s, ", $row["entero"]);
			}
			mysql_free_result($result);
			break;
		case 'Repetidos':
			$result = mysql_query("SELECT count(entero) as conteo, entero FROM race_condition group by entero having conteo>1 order by conteo desc, entero desc #limit 20") or
				die("Could not connect: " . mysql_error());

			printf('Repeticiones: <b>%s</b> <br />', mysql_num_rows($result));

			while ($row = mysql_fetch_array($result, MYSQL_ASSOC)) {
				printf("%s: %s <br />", $row["entero"], $row['conteo']);
			}
			mysql_free_result($result);
			break;
	}
}




?> 
