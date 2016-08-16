<?php
error_reporting(E_ALL);

include_once('Smarty.class.php');
$main_smarty = new Smarty;

include('config.php');
include(mnminclude.'html1.php');
include(mnminclude.'link.php');
include(mnminclude.'smartyvariables.php');

$ponte = new PDO("mysql:host=localhost;dbname=".EZSQL_DB_NAME, EZSQL_DB_USER, EZSQL_DB_PASSWORD);



$sql = "
SELECT 
user_id, user_twitter_account, user_twitter_id	
FROM `pligg_users`
WHERE user_twitter_id > 0 and trim(user_twitter_account)=''
;";
$sth = $ponte->prepare($sql, array(PDO::ATTR_CURSOR => PDO::CURSOR_FWDONLY));
$sth->execute();
$red = $sth->fetchAll(PDO::FETCH_CLASS);





$sql = "
UPDATE `pligg_users` 
SET user_twitter_account=:user_twitter_account
WHERE user_id=:user_id AND user_twitter_id=:user_twitter_id;
";
$sth_twitter = $ponte->prepare($sql, array(PDO::ATTR_CURSOR => PDO::CURSOR_FWDONLY));


foreach($red as $e) {
	$api_url = 'http://api.twitter.com/1/users/show.json?user_id='.$e->user_twitter_id;
	
	//*
	$ch = curl_init();
	curl_setopt($ch, CURLOPT_URL, $api_url);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
	curl_setopt($ch, CURLOPT_BINARYTRANSFER, true);
	$response = curl_exec($ch);
	$info = curl_getinfo($ch);
	curl_close($ch); //*/	
	
	/*
	$options = array(
	  'http'=>array(
		'method'=>"GET",
		'header'=>"Accept-language: en\r\n" .
				  "Cookie: foo=bar\r\n"
	  )
	);
	$contexto = stream_context_create($opciones);		
	$response = file_get_contents($api_url, false, $contexto); //*/
	
	
	$json = json_decode($response);
	
	
	if($json->screen_name) {
		$params = array(':user_id'=>$e->user_id, ':user_twitter_id'=>$e->user_twitter_id, ':user_twitter_account'=>$json->screen_name);
		#echo var_dump($params), '<br />';
		$sth_twitter->execute($params);
	} else {
		#var_dump($response);
		if(isset($_GET['check'])) die('Limite en el API de Twitter Alcanzado. Favor esperar a que pase esta hora.');
		else break;
	}
}









header("Cache-Control: no-cache, must-revalidate"); // HTTP/1.1
header("Expires: Sat, 26 Jul 1997 05:00:00 GMT"); // Fecha en el pasado

$charset =  'iso-8859-1'   ;#   'ISO-8859-1'   'CP-1252'    "Windows-1252"     'utf-8'

if(isset($_GET['plain'])){
	header('Content-Type: text/plain; charset='.$charset); 
} else {
	header('Content-Type: text/csv; charset='.$charset); 
	header('Content-Disposition: attachment; filename="propuestas_'.strftime('%Y%m%dT%H%M%S').'.csv"');
}


#$sth = $ponte->prepare("SET NAMES latin1;", array(PDO::ATTR_CURSOR => PDO::CURSOR_FWDONLY));
#$sth->execute();

$sql = "
### TITULO, URL, AUTOR, TWITTER, FACEBOOK, CATEGORIA, GRUPO ###
SELECT #''
 # , l.link_status
   l.link_title title
  , l.link_content content
  , l.link_votes votes
  , l.link_comments comments
  , concat('http://pontepatupais.do/pontepatupais/story.php?title=',l.link_title_url) url
  #, l.link_author 
  , u.user_login usuario
  , u.user_names nombre
  , u.user_twitter_account twitter_id
  , u.user_fb facebook_id
  #, l.link_category
  , c.category_name categoria
  #, l.link_group_id 
  , g.group_name grupo

  #, l.link_content propuesta
  #, c.category_name categoria
  # , '######' 
  #, l.* 
FROM `pligg_links` l
LEFT JOIN `pligg_users` u
  ON u.user_id = l.link_author
LEFT JOIN `pligg_categories` c
  ON c.category__auto_id = l.link_category 
LEFT JOIN `pligg_groups` g
  ON g.group_id = l.link_group_id
WHERE l.link_status IN ('published','queued')
ORDER BY VOTES DESC limit 25
";

$sth = $ponte->prepare($sql, array(PDO::ATTR_CURSOR => PDO::CURSOR_FWDONLY));
$sth->execute();
$red = $sth->fetchAll();

#var_dump( mb_get_info ("all"));

$comma = quotify(', ', true);
$crlf = quotify("\r\n", true);
foreach($red as $ri=>$re){
	#if($re['twitter_id']<=0 or trim($re['facebook_id'])=='') continue;
	
	$twitter_url = '';
	$facebook_url = '';
	
	if(trim($re['twitter_id'])!='') {
		$twitter_url = 'https://twitter.com/'.$re['twitter_id'];
	}
	
	if(trim($re['facebook_id'])!='') {
		$facebook_url = 'https://www.facebook.com/profile.php?id='.$re['facebook_id'];
	}
	
	echo 
		quotify($re['title']), $comma,
		#quotify($re['content']), $comma,
		quotify($re['votes']), $comma,
		quotify($re['comments']), $comma,
		quotify($re['url']), $comma,
		quotify($re['usuario']), $comma,
		quotify($re['nombre']), $comma,
		quotify($twitter_url), $comma,
		quotify($facebook_url), $comma,
		quotify($re['categoria']), $comma,
	 	quotify($re['grupo']), $crlf;

	#echo mb_detect_encoding($re['title']), mb_detect_encoding(quotify($re['title'])), $crlf;
	#break;
}

function quotify($text, $only_encode = false){
	global $charset;
	
	if(!$only_encode) {
		$text = str_replace(array('<br />','<br>',"\n","\r"), " ", $text);
		
		if(strpos($text,'"')!==FALSE) {
			$text = str_replace('"','""',$text);
		}
		if(strpos($text,',')!==FALSE or strpos($text,'"')!==FALSE) {
			$text = '"'.$text.'"';
		}
	}

	#$text = iconv("ASCII", $charset, $text);
	#$text = utf8_encode($text);
	  
	#$encoding = mb_detect_encoding($re['title']);
	#$text = mb_convert_encoding($text, $charset);
	
	return $text;
}

