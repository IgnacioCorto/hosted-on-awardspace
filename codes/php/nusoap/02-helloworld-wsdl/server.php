<?php
// Insert the NuSOAP code
require_once('../../nusoap.php');   
// Create an instance of the server
$server = new soap_server;
            
// Initialize WSDL support
$server->configureWSDL('helloworldwsdl', 'urn:helloworldwsdl');

// Put the WSDL schema types in the namespace with the tns prefix
$server->wsdl->schemaTargetNamespace = 'urn:helloworldwsdl';

// Register the data structures used by the service
$server->wsdl->addComplexType(
    'Person',
    'complexType',
    'struct',
    'all',
    '',
    array(
        'firstname' => array('name' => 'firstname', 
	                     'type' => 'xsd:string'),
        'age' => array('name' => 'age', 'type' => 'xsd:int'),
    )
);
$server->wsdl->addComplexType(
    'AgeConfirmReply',
    'complexType',
    'struct',
    'all',
    '',
    array(
        'output_string' => array('name' => 'output_string', 
	                         'type' => 'xsd:string'),
        'allow' => array('name' => 'allow', 'type' => 'xsd:boolean')
    )
);
// Register the method to expose
$server->register('hello',                    // method name
    array('person' => 'tns:Person'),          // input parameters
    array('return' => 'tns:AgeConfirmReply'), // output parameters
    'urn:helloworldwsdl',                          // namespace
    'urn:helloworldwsdl#hello',                    // soapaction
    'rpc',                                    // style
    'encoded',                                // use
    'Confirm the enquirer is over 18'         // documentation
);

// This is the method
function hello($input) {
    $output_string = 'Hello ' . $input['firstname'] . 
                '. You are ' . $input['age'] . ' years old.';
    
    if ( $input['age'] >= 18 ) { $allow = 1; }

    return array(
                'output_string' => $output_string,
                'allow' => $allow
                );
}

// This returns the result
$server->service($HTTP_RAW_POST_DATA);  
?>