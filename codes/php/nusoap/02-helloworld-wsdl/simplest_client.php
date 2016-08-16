<?php
// Insert the NuSOAP code
require_once('../../nusoap.php');   

#######################################
### CONSTRUCT URL AND CREATE CLIENT ###
#######################################

$app_name = dirname($_SERVER['PHP_SELF']);
$wsdl_url ="http://{$_SERVER['HTTP_HOST']}{$app_name}/server.php?wsdl";
//echo $wsdl_url;
$client = new nusoap_client($wsdl_url);  


##########################
### CALLING THE METHOD ###
##########################

$person = array('firstname' => 'Fred', 'age' => 22);
$result = $client->call('hello',array('message' => $person));


###############################
### WORKING WITH THE OUTPUT ###
###############################

print $result['output_string'] . ' ';
if ( $result['allow'] == 1 ) { 
	print "You may continue..."; 
} else { 
	print "You are too young!"; 
} 

?>