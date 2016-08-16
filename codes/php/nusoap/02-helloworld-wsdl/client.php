<?php
// Insert the NuSOAP code
require_once('../../nusoap.php');   

// This is location of the remote service
$app_name = dirname($_SERVER['PHP_SELF']);
$wsdl_url ="http://{$_SERVER['HTTP_HOST']}{$app_name}/server.php?wsdl";
//echo $wsdl_url;
$client = new nusoap_client($wsdl_url);  


// Check for any errors from the remote service
$err = $client->getError();
if ($err) {
    echo '<p><b>Error: ' . $err . '</b></p>';
}

##########################
### CALLING THE METHOD ###
##########################

// Call the SOAP method on the remote service
$person = array('firstname' => 'Fred', 'age' => 22);
$result = $client->call('hello',array('message' => $person));


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
	
	###############################
	### WORKING WITH THE OUTPUT ###
	###############################
	
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