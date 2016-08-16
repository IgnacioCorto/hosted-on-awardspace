<?php
// Insert the NuSOAP code
require_once('../../nusoap.php');   

$client = new nusoap_client('http://www.w3schools.com/webservices/tempconvert.asmx?WSDL');  
$message = array('Celsius' => 10);
$result = $client->call('CelsiusToFahrenheit',array('message' => $message));
echo '<pre>',var_dump($result),'</pre>';


?>