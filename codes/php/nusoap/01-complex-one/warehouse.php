<?php
// Insert the NuSOAP code
require_once('../../nusoap.php');

$warehouse = "BN1 1AA";

// Create an instance of the server
$server = new soap_server;
// This states the method which can be accessed.
$server->register(
    'checkstock'                            // method name
);

// This is the method
function checkstock($order) {

// The warehouse can check to see whether it has the required 
// number of the items in stock. If yes, it then queries a 
// courier to see if they can deliver.

	$instock = 1;

	if ( $instock )
	{

                // This is location of the remote service
                $app_name = dirname($_SERVER['PHP_SELF']);
                $wsdl_url ="http://{$_SERVER['HTTP_HOST']}{$app_name}/courier.php";
                //echo $wsdl_url;
                $client = new nusoap_client($wsdl_url);  


                // Call the SOAP method on the remote service
		$package = array('item' => $order['item'],
		                 'quantity' => $order['quantity'],
				 'to' => $order['to'],
				 'from' => $warehouse);
		$result = $client->call(
			'checkdelivery',                    // method name
			array('package' => new soapval('package',
			                               'Package',
						       $package,
						       false,
						       'urn:MyURN'))   
		);

		$accepted = $result['accepted'];

		if ( $accepted )
		{
			$cost = $result['cost'];
			$date = $result['date'];

			$details = '<p>Warehouse: <blockquote>
			           "Yes, we currently have ' . 
			           $order['quantity'] .
			           ' of item ' . 
				   $order['item'] . 
				   ' in stock.  ' .
			           'The courier can deliver them to ' . 
				   $order['to'] .
			           ' on the ' . 
				   $date .
			           '.  The delivery cost will be £' . 
				   $cost . 
				   '."</blockquote></p>';
		} else {
			$details = 'Delivery Not Possible - Sorry!';
		}
	} else {
		$details = 'Item Out of Stock - Sorry!';
	}
    
    $retval = array(
                'details' => $details,
                );

    return new soapval('return', 'DeliveryDetail', $retval, false, 'urn:MyURN');
}

// This returns the result
$server->service($HTTP_RAW_POST_DATA);
?>