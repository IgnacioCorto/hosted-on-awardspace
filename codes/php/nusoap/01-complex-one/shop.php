<?php
// Insert the NuSOAP code
require_once('../../nusoap.php');

$item = "FLW947";
$quantity = 22;
$to = "RH15 9UZ";

print "<p>Shop: <blockquote>\"Do you have $quantity of item $item in stock?  
       When can they be delivered to $to and at what cost?\"</blockquote></p>\n";

// The shop can query the warehouse to see if the items are in 
// stock and if/when it can be delivered.


// This is location of the remote service
$app_name = dirname($_SERVER['PHP_SELF']);
$wsdl_url ="http://{$_SERVER['HTTP_HOST']}{$app_name}/warehouse.php";
//echo $wsdl_url;
$client = new nusoap_client($wsdl_url);  


// Call the SOAP method on the remote service
$order = array('item' => $item, 'quantity' => $quantity, 'to' => $to);
$result = $client->call(
    'checkstock',                    // method name
    array('order' => new soapval('orderquery','Order',$order,false,'urn:MyURN'))
);

print $result['details'];
?>