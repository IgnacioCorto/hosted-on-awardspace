<?php

// Insert the NuSOAP code
require_once('../../nusoap.php');   
 // Create an instance of the server
$server = new nusoap_server;            
// This states the method which can be accessed.
$server->register(                     
    'hello'                             
);

// This is the method
function hello($input) {
    $output_string = 'Hello ' . $input['firstname'] . 
                '. You are ' . $input['age'] . ' years old.';
    
    if ( $input['age'] >= 18 ) { $allow = 1; }

    $output = array(
                'output_string' => $output_string,
                'allow' => $allow
                );

    return new soapval('return', 'HelloInfo', $output, false, 'urn:AnyURN');
}

// This returns the result
$server->service($HTTP_RAW_POST_DATA);  
?>
