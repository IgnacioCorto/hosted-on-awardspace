<?php

if($_GET['area_de']!='debugging') die('Invalid User');
			 
$api_user = 'MUMBLE_MUMBLE_MUMBLE_MUMBLE_MUMBLE';
$api_pass = time();
$api_url_clients = 'http://api.createsend.com/api/v3/clients.json';

$api_client_id = 'MUMBLE_MUMBLE_MUMBLE_MUMBLE_MUMBLE';
$api_url_lists = 'http://api.createsend.com/api/v3/clients/'.$api_client_id.'/lists.json';

$api_list_id = 'MUMBLE_MUMBLE_MUMBLE_MUMBLE_MUMBLE';
$api_url_list_api = 'http://api.createsend.com/api/v3/lists/'.$api_list_id.'.json';


$api_url_add_subscriber = 'http://api.createsend.com/api/v3/subscribers/'.$api_list_id.'.json';

$api_subscriber_data = '
{
  "EmailAddress": "'.uniqid().'@dummy-email.com.do",
  "Name": "Dummie",
  "CustomFields": [
    {
      "Key": "contacto",
      "Value": "sms, 8092252224"
    }
  ],
  "Resubscribe": true
}
';

/*
echo '<hr />';  # ---------------------- LIST OF CLIENTS ------------------------------


$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $api_url_clients);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_BINARYTRANSFER, true);
curl_setopt($ch, CURLOPT_USERPWD, $api_user.':'.$api_pass);
curl_setopt($ch, CURLOPT_HTTPAUTH, CURLAUTH_BASIC);

$output = curl_exec($ch);
$info = curl_getinfo($ch);
curl_close($ch);

echo '<pre>', var_dump($info), '</pre>';
echo '<pre>', var_dump($output), '</pre>';

$json_clients = json_decode($output);

echo '<pre>', var_dump($json_clients[0]->Name), ', ', var_dump($json_clients[1]->Name), ', ', '</pre>';

echo '<hr />';  # ---------------------- LIST OF LISTS ------------------------------


$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $api_url_lists);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_BINARYTRANSFER, true);
curl_setopt($ch, CURLOPT_USERPWD, $api_user.':'.$api_pass);
curl_setopt($ch, CURLOPT_HTTPAUTH, CURLAUTH_BASIC);

$output = curl_exec($ch);
$info = curl_getinfo($ch);
curl_close($ch);

echo '<pre>', var_dump($info), '</pre>';
echo '<pre>', var_dump($output), '</pre>';


echo '<hr />';  # ---------------------- LIST DETAILS ------------------------------


$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $api_url_list_api);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_BINARYTRANSFER, true);
curl_setopt($ch, CURLOPT_USERPWD, $api_user.':'.$api_pass);
curl_setopt($ch, CURLOPT_HTTPAUTH, CURLAUTH_BASIC);

$output = curl_exec($ch);
$info = curl_getinfo($ch);
curl_close($ch);

echo '<pre>', var_dump($info), '</pre>';
echo '<pre>', var_dump($output), '</pre>';

*/

echo '<hr />';  # ---------------------- ADD SUBSCRIBER ------------------------------


$ch = curl_init();
curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'GET');         // GET POST  PUT DELETE etc.
curl_setopt($ch, CURLOPT_URL, $api_url_add_subscriber);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_BINARYTRANSFER, true);
curl_setopt($ch, CURLOPT_USERPWD, $api_user.':'.$api_pass);
curl_setopt($ch, CURLOPT_HTTPAUTH, CURLAUTH_BASIC);

curl_setopt($ch, CURLOPT_HEADER, 1); 
curl_setopt($ch, CURLOPT_TIMEOUT, 40); // times out after 4s 

/*
curl_setopt($ch, CURLOPT_HTTPHEADER, Array("Content-Type: text/json")); 
curl_setopt($ch, CURLOPT_POSTFIELDS, $api_subscriber_data); // add POST fields 
curl_setopt($ch, CURLOPT_POST, 1); 
*/


$output = curl_exec($ch);
$info = curl_getinfo($ch);
curl_close($ch);

echo '<pre>', var_dump($info), '</pre>';
echo '<pre>', var_dump($output), '</pre>';

die('<div>FINALIZADO</div>');





