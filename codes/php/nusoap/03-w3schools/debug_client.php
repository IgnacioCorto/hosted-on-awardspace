<?php
// Insert the NuSOAP code
require_once('../../nusoap.php');   

// This is location of the remote service
$client = new nusoap_client('http://www.w3schools.com/webservices/tempconvert.asmx?WSDL',true);  
//$client = new nusoap_client('http://www.w3schools.com/webservices/tempconvert.asmx');  


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

$message = array('Celsius' => 10);
//$result = $client->call('CelsiusToFahrenheit',array('message' => $message));

$result = $client->call(
    'CelsiusToFahrenheit',                     // method name
    array('Celsius' => '10'),    // input parameters
    'http://tempuri.org/',            // namespace
    'http://tempuri.org/CelsiusToFahrenheit'       // SOAPAction
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
	
	###############################
	### WORKING WITH THE OUTPUT ###
	###############################

	echo '<pre>',var_dump($result),'</pre>';

        // If everything is OK display the result
	print $result['output_string'] . ' ';
	if ( $result['allow'] == 1 ) { 
		print "You may continue..."; 
	} else { 
		print "You are too young!"; 
	} 
    }
}

// Display the request and response
echo '<h2>Request</h2>';
echo '<pre>' . htmlspecialchars($client->request, ENT_QUOTES) . '</pre>';
echo '<h2>Response</h2>';
echo '<pre>' . htmlspecialchars($client->response, ENT_QUOTES) . '</pre>';


?>