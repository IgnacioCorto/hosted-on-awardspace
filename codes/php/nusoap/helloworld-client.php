<?php
// Insert the NuSOAP code
require_once('../lib/nusoap.php');   
// This is location of the remote service
$client = new nusoap_client('http://192.168.45.172/ignacio/nusoap/www.oclipa.com/helloworld-server.php');  

// Check for any errors from the remote service
$err = $client->getError();
if ($err) {
    echo '<p><b>Error: ' . $err . '</b></p>';
}

// Call the SOAP method on the remote service
$person = array('firstname' => 'Ignacio', 'age' => 26 );
$result = $client->call(
    'hello',                    // method name
    array('message' => new soapval('id','Person',$person,false,'urn:AnyURN'))
);

// Check for any faults reported by the remote service
if ($client->fault) {
    echo '<p><b>Fault: ';
    print_r($result);
    echo '</b></p>';
} else {
    // Check for any errors from the remote service
    $err = $client->getError();
    if ($err) {
    	echo '<p><b>Error: ' . $err . '</b></p>';
    } else {
        // If everything is OK display the result
	print $result['output_string'] . ' ';
	if ( $result['allow'] == 1 ) { 
		print "You may continue..."; 
	} else { 
		print "You are too young!"; 
	} 
    }
}


?>

