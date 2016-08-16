<?php
header("Cache-Control: no-cache, must-revalidate"); // HTTP/1.1
header("Expires: Sat, 26 Jul 1997 05:00:00 GMT"); // Date in the past

$output = array();

$output['status'] = 'testing';
$output['time'] = strftime('%c');

if(isset($_GET['callback'])) {
	header('Content-Type: text/javascript');
	
	echo $_GET['callback'].'('.json_encode($output).');';
} else {
	echo '<pre>Normal HTML</pre>';
	echo '<pre>',var_dump($output),'</pre>';
}