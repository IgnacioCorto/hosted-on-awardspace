<?php

// Connecting, selecting database
$link = mysql_connect(DB_HOST, DB_USER, DB_PASS)
    or die('Could not connect: ' . mysql_error());
echo 'Connected successfully';

mysql_select_db(DB_NAME) or die('Could not select database');


// Performing SQL query
$query = " SELECT * FROM table ;";

$result = mysql_query($query) or die('Query failed: ' . mysql_error());


// Printing results in HTML
echo "
<link rel='stylesheet' type='text/css' href='/css/reports.css'>
<table class='reporttable' style='border-collapse: collapse;' rules='all' border='1' cellspacing='0'>
<tbody>
";

$firstRecord = $zebra_flag = true ;

while ($line = mysql_fetch_array($result, MYSQL_ASSOC)) {

	// Header Row
    if($firstRecord) {
		echo "\t<tr>\n";
		foreach ($line as $k=>$v) {
			echo "\t\t<th class='th-report'>$k</th>\n";
		}
		echo "\t</tr>\n";
		$firstRecord = false ;
	}

	// Data Rows
	$zebra_flag = !$zebra_flag ;
	$zebra_class = $zebra_flag ? ' class="col-alt" ' : ' class="col" ' ;

    echo "\t<tr>\n";
    foreach ($line as $col_value) {
        echo "\t\t<td align='center' {$zebra_class}>$col_value</td>\n";
    }
    echo "\t</tr>\n";
}
echo "
<tbody>
</table>

";


// Free resultset
mysql_free_result($result);

// Closing connection
mysql_close($link);



?>
  

  