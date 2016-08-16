<?php
include 'constants.php';
session_start();

echo '<pre>';

$consumer_key    = CUSTOMER_KEY;
$consumer_secret = CUSTOMER_SECRET;

$timestamp = time();
$nonce = uniqid('db_',true);

echo "<h4>TimeStamp: $timestamp</h4>";
echo "<h4>Nonce: $nonce</h4>";

$fp = fsockopen("ssl://api.dropbox.com", 443, $errno, $errstr, 30);
if (!$fp) {
    echo "$errstr ($errno)<br />\n";
} else {
    $out = "GET /0/oauth/access_token HTTP/1.1\r\n";
    $out .= "Host: api.dropbox.com\r\n";
	
    $out .= "Authorization: OAuth "
    ."    oauth_callback=\"$callback\", "
    ."    oauth_consumer_key=\"$consumer_key\", "
    ."    oauth_nonce=\"$nonce\", "
    ."    oauth_signature=\"sPSVmqN%2FXu9k0wlZxF0PqPZwYGo%3D\", "
    ."    oauth_signature_method=\"HMAC-SHA1\", "
    ."    oauth_timestamp=\"$timestamp\", "
    ."    oauth_token=\"{$_SESSION['oauth_token']}\", "
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

$oauth_token = $matches[2];
$oauth_token_secret = $matches[1];



### AHORA USAR EL ACCOUNT INFO ###
echo "<h3>Ahora buscando el Acount Info</h3>";

$timestamp = time();
$nonce = uniqid('db_',true);

$long_signature = "GET&https%3A%2F%2Fapi.dropbox.com%2F0%2Faccount%2Finfo&oauth_callback%3D%26oauth_consumer_key%3D$consumer_key%26oauth_nonce%3D$nonce%26oauth_signature_method%3DHMAC-SHA1%26oauth_timestamp%3D$timestamp%26oauth_token%3D$oauth_token%26oauth_version%3D1.0";

$hash_key = $consumer_secret.'&'.$oauth_token_secret;

$base64encode = base64_encode( hash_hmac("sha1", $long_signature, $hash_key, true) );

echo "<h4>$base64encode</h4>";

$fp = fsockopen("ssl://api.dropbox.com", 443, $errno, $errstr, 30);
if (!$fp) {
    echo "$errstr ($errno)<br />\n";
} else {
    $out = "GET /0/account/info HTTP/1.1\r\n";
    $out .= "Host: api.dropbox.com\r\n";
	
    $out .= "Authorization: OAuth "
    ."    oauth_callback=\"$callback\", "
    ."    oauth_consumer_key=\"$consumer_key\", "
    ."    oauth_nonce=\"$nonce\", "
    ."    oauth_signature=\"$base64encode\", "
    ."    oauth_signature_method=\"HMAC-SHA1\", "
    ."    oauth_timestamp=\"$timestamp\", "
    ."    oauth_token=\"$oauth_token\", " //     {$_SESSION['oauth_token']}
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

echo '<br />', $long_signature, '<br />', 'done';



### AHORA USAR EL FILE POST (3) ###

echo "<h3>Ahora subiendo el nuevo archivo</h3>";

$timestamp = time();
$nonce = uniqid('db_',true);

$long_signature = "POST&https%3A%2F%2Fapi-content.dropbox.com%2F0%2Ffiles%2Fdropbox%2F&file%3Dmyapp.txt%26oauth_callback%3D%26oauth_consumer_key%3D$consumer_key%26oauth_nonce%3D$nonce%26oauth_signature_method%3DHMAC-SHA1%26oauth_timestamp%3D$timestamp%26oauth_token%3D$oauth_token%26oauth_version%3D1.0";

$hash_key = $consumer_secret.'&'.$oauth_token_secret;

$base64encode = base64_encode(hash_hmac("sha1", $long_signature, $hash_key, true));

echo "<h4>$base64encode</h4>";
#https://api-content.dropbox.com/<version>/files/dropbox/

$fp = fsockopen("ssl://api-content.dropbox.com", 443, $errno, $errstr, 30);
if (!$fp) {
    echo "$errstr ($errno)<br />\n";
} else {
    $out = "POST /0/files/dropbox/?file=myapp.txt HTTP/1.1\r\n";
    $out .= "Host: api-content.dropbox.com\r\n";
	
    $out .= "Authorization: OAuth "
    ."    oauth_callback=\"$callback\", "
    ."    oauth_consumer_key=\"$consumer_key\", "
    ."    oauth_nonce=\"$nonce\", "
    ."    oauth_signature=\"$base64encode\", "
    ."    oauth_signature_method=\"HMAC-SHA1\", "
    ."    oauth_timestamp=\"$timestamp\", "
    ."    oauth_token=\"$oauth_token\", " //     {$_SESSION['oauth_token']}
    ."    oauth_version=\"1.0\" \r\n";

    $out .= "Content-Type: multipart/form-data; boundary=AaB03x\r\n";

		#TO CALCULATE CONTENT LENGTH
		#$out .= "\r\n";
		$out2 = "--AaB03x\r\n";
		$out2 .= "Content-Disposition: form-data; name=\"file\"; filename=\"myapp.txt\"\r\n";
		$out2 .= "Content-Type: text/plain\r\n";
		$out2 .= "\r\n";
		$out2 .= "The Wise" ."\r\n";
		$out2 .= "--AaB03x--\r\n";
	
    $out .= "Content-Length: ".strlen($out2)."\r\n";
    $out .= "Connection: Close\r\n\r\n";
    $out .= $out2;
	
	#echo "<strong>$out</strong>";
	
    fwrite($fp, $out);

	$out_request_token = '';
    while (!feof($fp)) {
        $out_request_token .= fgets($fp, 128);
    }
    fclose($fp);
	echo $out_request_token;
}

echo '<br />', $long_signature, '<br />', 'done';




### AHORA USAR EL FILE GET (4) ###
echo "<h3>Ahora leyendo el archivo</h3>";

$timestamp = time();
$nonce = uniqid('db_',true);

$long_signature = "GET&https%3A%2F%2Fapi-content.dropbox.com%2F0%2Ffiles%2Fdropbox%2Fmyapp.txt&oauth_callback%3D%26oauth_consumer_key%3D$consumer_key%26oauth_nonce%3D$nonce%26oauth_signature_method%3DHMAC-SHA1%26oauth_timestamp%3D$timestamp%26oauth_token%3D$oauth_token%26oauth_version%3D1.0";

$hash_key = $consumer_secret.'&'.$oauth_token_secret;

$base64encode = base64_encode(hash_hmac("sha1", $long_signature, $hash_key, true));

echo "<h4>$base64encode</h4>";
#https://api-content.dropbox.com/<version>/files/dropbox/

$fp = fsockopen("ssl://api-content.dropbox.com", 443, $errno, $errstr, 30);
if (!$fp) {
    echo "$errstr ($errno)<br />\n";
} else {
    $out = "GET /0/files/dropbox/myapp.txt HTTP/1.1\r\n";
    $out .= "Host: api-content.dropbox.com\r\n";
	
    $out .= "Authorization: OAuth "
    ."    oauth_callback=\"$callback\", "
    ."    oauth_consumer_key=\"$consumer_key\", "
    ."    oauth_nonce=\"$nonce\", "
    ."    oauth_signature=\"$base64encode\", "
    ."    oauth_signature_method=\"HMAC-SHA1\", "
    ."    oauth_timestamp=\"$timestamp\", "
    ."    oauth_token=\"$oauth_token\", " //     {$_SESSION['oauth_token']}
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

echo '<br />', $long_signature, '<br />', 'done';
