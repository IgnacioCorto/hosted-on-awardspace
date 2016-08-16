<?php
// Insert the NuSOAP code
require_once('../../nusoap.php');

// Create an instance of the server
$server = new soap_server;
// This states the method which can be accessed.
$server->register(
    'checkdelivery'                  // method name
);

// This is the method
function checkdelivery($package) {

	$item = $package['item'];	
	$quantity = $package['quantity'];	
	$to = $package['to'];	
	$from = $package['from'];	

// Based on the location of the delivery address and 
// the warehouse the courier can decide if they can 
// make the delivery.  If yes, they could then let the 
// warehouse know the cost and delivery date.

	$accepted = 1;

	if ( $accepted )
	{
		$cost = 10;
		$date = '12-05-2004';

		$output = array(
					'accepted' => $accepted,
					'cost' => $cost,
					'date' => $date
					);
	} else {
		$output = array(
					'accepted' => $accepted,
					'cost' => 0,
					'date' => 'null'
					);
	}

    return new soapval('return', 'DeliveryDetail', $output, false, 'urn:MyURN');
}

// This returns the result
$server->service($HTTP_RAW_POST_DATA);
?>