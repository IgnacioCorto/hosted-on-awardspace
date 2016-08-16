<?php
error_reporting(-1);

function hmac_sha1($key, $data)
{
    // Adjust key to exactly 64 bytes
    if (strlen($key) > 64) {
        $key = str_pad(sha1($key, true), 64, chr(0));
    }
    if (strlen($key) < 64) {
        $key = str_pad($key, 64, chr(0));
    }

    // Outter and Inner pad
    $opad = str_repeat(chr(0x5C), 64);
    $ipad = str_repeat(chr(0x36), 64);

    // Xor key with opad & ipad
    for ($i = 0; $i < strlen($key); $i++) {
        $opad[$i] = $opad[$i] ^ $key[$i];
        $ipad[$i] = $ipad[$i] ^ $key[$i];
    }

    return sha1($opad.sha1($ipad.$data, true));
}


$fp = fsockopen("api.twitter.com", 80, $errno, $errstr, 5);
if (!$fp) {
    echo "$errstr ($errno)<br />\n";
} else {

	$message1 = 
		"POST /oauth/request_token HTTP/1.1\r\n"
		."User-Agent: themattharris' HTTP Client\r\n"
		."Host: api.twitter.com\r\n"
		."Accept: */*\r\n"
		."Authorization: "
			."OAuth oauth_callback=\"http%3A%2F%2Flocalhost%2Fsign-in-with-twitter%2F\", "
				."oauth_consumer_key=\"cChZNFj6T5R0TigYB9yd1w\", "
				."oauth_nonce=\"ea9ec8429b68d6b77cd5600adbbb0456\", "
				."oauth_signature=\"F1Li3tvehgcraF8DMJ7OyxO4w9Y%3D\", "
				."oauth_signature_method=\"HMAC-SHA1\", "
				."oauth_timestamp=\"1318467427\", "
				."oauth_version=\"1.0\" \r\n"
				."\r\n"
				."\r\n";

	$message2 = 
		"POST /1/statuses/update.json?include_entities=true HTTP/1.1\r\n"
		."Accept: */*\r\n"
		."Connection: close\r\n"
		."User-Agent: OAuth gem v0.4.4\r\n"
		."Content-Type: application/x-www-form-urlencoded\r\n"
		."Content-Length: 76\r\n"
		."Host: api.twitter.com\r\n"
		."\r\n"
		."status=Hello%20Ladies%20%2b%20Gentlemen%2c%20a%20signed%20OAuth%20request%21\r\n";				
	

	/*
	 * THIS IS HOW THEY EXPECT TWITTER TO WORK
	 */
	
	/*
	$http_method = 'POST';
	$base_url = 'https://api.twitter.com/1/statuses/update.json';
	$status = 'hello world everybody';
	$include_entities = true;
	$oauth_consumer_key = 'Tpg1K0aW5PFhdGF1k5q1w';
	$oauth_consumer_secret = 'R8cxtkwfUQZ3JL2bk0bhTKVbDV7PQ7qoov9VfT5HH4';
	$oauth_nonce = base64_encode(microtime(true));
	$oauth_signature_method = 'HMAC-SHA1';
	$oauth_timestamp = time();
	$oauth_token = 'XXXoXXXoXXXoXXX';
	$oauth_version = '1.0';
	*/
	
	$http_method = 'POST';
	$base_url = 'https://api.twitter.com/1/statuses/update.json';
	$status = 'Hello Ladies + Gentlemen, a signed OAuth request!';
	$include_entities = 'true';
	$oauth_consumer_key = 'xvz1evFS4wEEPTGEFPHBog';
	$oauth_consumer_secret = 'kAcSOqF21Fu85e7zjz7ZN2U4ZRhfV3WpwPAoE3Z7kBw';
	$oauth_nonce = 'kYjzVBB8Y0ZFabxSWbWovY3uYSQ2pTgmZeNu2VS4cg';
	$oauth_signature_method = 'HMAC-SHA1';
	$oauth_timestamp = '1318622958';
	$oauth_token = '370773112-GmHxMAgYyLbNEtIKZeRNFsMKPR9EyMZeS9weJAEb';
	$oauth_token_secret = 'LswwdoUaIvS8ltyTt5jkRh4J50vUPVVHtR2YPi5kE';
	$oauth_version = '1.0';
	
	
	$parameter_string =
		"include_entities=true"
		."&oauth_consumer_key=".$oauth_consumer_key
		."&oauth_nonce=".$oauth_nonce
		."&oauth_signature_method=".$oauth_signature_method
		."&oauth_timestamp=".$oauth_timestamp
		."&oauth_token=".$oauth_token
		."&oauth_version=".$oauth_version
		."&status=".rawurlencode($status)
		;

	$signature_base_string =
		$http_method
		."&".rawurlencode($base_url)
		."&".rawurlencode($parameter_string)
		;

	$signing_key = 
		$oauth_consumer_secret
		."&".$oauth_token_secret
		;
		
	$oauth_signature = base64_encode(hash_hmac('sha1',$signature_base_string,$signing_key,true));


	echo '<div style="whites-pace:nowrap; width:10000px;">';
	echo $signature_base_string,'<br />';
	echo 'POST&https%3A%2F%2Fapi.twitter.com%2F1%2Fstatuses%2Fupdate.json&include_entities%3Dtrue%26oauth_consumer_key%3Dxvz1evFS4wEEPTGEFPHBog%26oauth_nonce%3DkYjzVBB8Y0ZFabxSWbWovY3uYSQ2pTgmZeNu2VS4cg%26oauth_signature_method%3DHMAC-SHA1%26oauth_timestamp%3D1318622958%26oauth_token%3D370773112-GmHxMAgYyLbNEtIKZeRNFsMKPR9EyMZeS9weJAEb%26oauth_version%3D1.0%26status%3DHello%2520Ladies%2520%252B%2520Gentlemen%252C%2520a%2520signed%2520OAuth%2520request%2521<br />';
	echo '<br />';
	echo $signing_key,'<br />';
	echo 'kAcSOqF21Fu85e7zjz7ZN2U4ZRhfV3WpwPAoE3Z7kBw&LswwdoUaIvS8ltyTt5jkRh4J50vUPVVHtR2YPi5kE<br />';
	echo '<br />';
	echo $oauth_signature,'<br />';
	echo 'tnnArxj06cWHq44gCs1OSKk/jLY=<br />';
	echo '<br />';
	echo '</div>';



		
	$message3 = 
		"POST /1/statuses/update.json?include_entities=true HTTP/1.1\r\n"
		."Accept: */*\r\n"
		."Connection: close\r\n"
		."User-Agent: OAuth gem v0.4.4\r\n"
		."Content-Type: application/x-www-form-urlencoded\r\n"
		."Authorization: "
			."OAuth oauth_consumer_key=\"".$oauth_consumer_key."\", "
				."oauth_nonce=\"".$oauth_nonce."\", "
				."oauth_signature=\"tnnArxj06cWHq44gCs1OSKk%2FjLY%3D\", "
				."oauth_signature_method=\"".$oauth_signature_method."\", "
				."oauth_timestamp=\"".time()."\", "
				."oauth_token=\"370773112-GmHxMAgYyLbNEtIKZeRNFsMKPR9EyMZeS9weJAEb\", "
				."oauth_version=\"".$oauth_version."\"\r\n"
		."Content-Length: 76\r\n"
		."Host: api.twitter.com\r\n"
		."\r\n"
		."status=Hello%20Ladies%20%2b%20Gentlemen%2c%20a%20signed%20OAuth%20request%21";


				
    fwrite($fp, $message3);
	echo '<pre>'.$message.'<br /><br />';
    while (!feof($fp)) {
        echo fgets($fp, 128);
    }
	echo '</pre>';
    fclose($fp);
}