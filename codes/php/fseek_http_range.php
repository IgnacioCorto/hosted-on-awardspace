<?php 
/*
http://stackoverflow.com/a/17552548
http://stackoverflow.com/questions/17114827/php-fseek-for-large-file-2gb
*/


$start = floatval(5);
$len   = floatval(4);
$url   = 'http://luis3ignacio.awardspace.com';

// set up the http byte range headers
$opts = array('http'=>array('method'=>'GET','header'=>"Range: bytes=$start-".($start+$len-1)));
$context = stream_context_create($opts);
// bytes ranges header

print_r($opts);

// change the URL below to the URL of your file. DO NOT change it to a file path.
// you MUST use a http:// URL for your file for a http request to work
// this will output the results

$result = file_get_contents($url, false, $context);
echo '<hr ><pre>', htmlentities($result), '</pre><hr >';

// status of your request
// if this is empty, means http request didnt fire. 

print_r($http_response_header);

// Check your file URL and verify by going directly to your file URL from a web 
// browser. If http response shows errors i.e. code > 400 check you are sending the
// correct Range headers bytes. For eg - if you give a start Range which exceeds the
// current file size, it will give 406. 

// NOTE  - The current file size is also returned back in the http response header
// Content-Range: bytes 355902253-355903252/355904253, the last number is the file size
