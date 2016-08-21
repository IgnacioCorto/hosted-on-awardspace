<?php
// SEE:
// http://php.net/curl_setopt
// http://php.net/curl_getinfo

error_reporting(-1);
ini_set('display_errors', 'on');
header('Content-Type: text/plain');

if(isset($_GET['getTime'])) do_dates();
do_curl();


function do_curl (){
	echo "Elemental cURL:" , PHP_EOL , PHP_EOL;

	$url = 'http://'
		 . $_SERVER['HTTP_HOST']
		 . $_SERVER['PHP_SELF']
		 . '?getTime';
	//$url = 'http://peetm.com/blog/?p=55';

	$headers = array(
		'X-DONE-BY: @ignaciocorto',
		'X-URL-VAR: ' . $url,
	);

	$fields = array(
		'getTime' => 'doing dates...',
		'fist_name' => 'ignacio',
		'last_name' => 'de la cruz',
	);

	$options = array(
		CURLOPT_URL => $url,              // URL
		CURLOPT_SSL_VERIFYHOST => FALSE,  // HTTPS
		CURLOPT_SSL_VERIFYPEER => FALSE,  // HTTPS
		CURLOPT_RETURNTRANSFER => 1,      // RETURN DATA (NOT ECHO)
		CURLOPT_VERBOSE => 1,             // 
		CURLOPT_HEADER => 1,              // INCLUDE HEADER IN RETURN
		CURLOPT_HTTPHEADER => $headers,   // HEADERS (ARRAY OF STRINGS)
		CURLOPT_POST => 1, 
		CURLOPT_POSTFIELDS => http_build_query($fields) ,   // POST BODY
	);

	//EXECUTE CURL
	$ch = curl_init();
	curl_setopt_array($ch, $options);
	$result = curl_exec($ch);
	$header_size = curl_getinfo($ch, CURLINFO_HEADER_SIZE);
	curl_close($ch);

	//FORMAT RESULTS
	$re = "/^.*$/im"; 
	$subst = ">>  $0"; 
	 
	$output = preg_replace($re, $subst, $result);
	echo '*** OUTPUT *** '
		, sprintf('(header_size:%s)', $header_size)
		, PHP_EOL,$output;
}
	

function do_dates(){
	setlocale(LC_ALL, "esn", "spanish-modern", 'es', 'es_DO', 'sp', 'es_ES');
	if(function_exists('date_default_timezone_set'))
		date_default_timezone_set('America/Santo_Domingo');   

	$tab = '  ';
	echo "The DateTime is: "
			, PHP_EOL , $tab
			, date("Y-m-d H:i:s A")
			, PHP_EOL , $tab
			, strftime("%Y-%m-%d %M:%M:%S %p") 
			, PHP_EOL , $tab
			, strftime("%c") 
			, PHP_EOL , $tab
			,  time() 
			, PHP_EOL , PHP_EOL;
	var_dump(getallheaders());
	var_dump($_REQUEST);
	exit(0);	
}

/*
URL: http://peetm.com/blog/?p=55

HTTP/1.1 301 Moved Permanently
Date: Sun, 21 Aug 2016 22:17:38 GMT
Server: Apache
Location: http://www.bbc.co.uk/?p=55
Content-Length: 234
Content-Type: text/html; charset=iso-8859-1

<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML 2.0//EN">
<html><head>
<title>301 Moved Permanently</title>
</head><body>
<h1>Moved Permanently</h1>
<p>The document has moved <a href="http://www.bbc.co.uk/?p=55">here</a>.</p>
</body></html>
*/
