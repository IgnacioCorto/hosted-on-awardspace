<?php
include 'constants.php';
session_start();

echo '<pre>';

$consumer_key    = CUSTOMER_KEY;
$consumer_secret = CUSTOMER_SECRET;

$http_method = 'GET';
$host = 'https://api.dropbox.com';
$api_method = '/0/oauth/request_token';

$timestamp = time();
$nonce = uniqid('db_',true);
$callback = rawurlencode('http://localhost/ignacio/myoauth/callback.php');


$_SERVER['timestamp'] = $timestamp;

echo "<h4>$timestamp</h4>";
echo "<h4>Nonce: $nonce</h4>";

$fp = fsockopen("ssl://api.dropbox.com", 443, $errno, $errstr, 30);
if (!$fp) {
    echo "$errstr ($errno)<br />\n";
} else {
    $out = "GET /0/oauth/request_token HTTP/1.1\r\n";
    $out .= "Host: api.dropbox.com\r\n";
	
    $out .= "Authorization: OAuth "
    ."    oauth_consumer_key=\"$consumer_key\", "
    ."    oauth_timestamp=\"$timestamp\", "
    ."    oauth_nonce=\"$nonce\", "
    ."    oauth_callback=\"$callback\", "
    ."    oauth_signature_method=\"HMAC-SHA1\", "
    ."    oauth_signature=\"sPSVmqN%2FXu9k0wlZxF0PqPZwYGo%3D\", "
    ."    oauth_version=\"1.0\" \r\n";
	
    $out .= "Connection: Close\r\n\r\n";
    fwrite($fp, $out);

	$out_request_token = '';
    while (!feof($fp)) {
        $out_request_token .= fgets($fp, 128);
    }
    fclose($fp);
	echo $out_request_token;
}
preg_match('/oauth_token_secret=(\w*)&oauth_token=(\w*)/',$out_request_token,$matches);

var_dump($matches);


$_SESSION['oauth_token'] = $matches[2];

$oauth_token = $matches[2];
$oauth_token_secret = $matches[1];



echo "</pre>

<a href='https://www.dropbox.com/0/oauth/authorize?oauth_token={$oauth_token}&oauth_callback=$callback' target='_blank'>Autorizar</a>
";


