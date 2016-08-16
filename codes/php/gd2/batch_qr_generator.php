<?php

include "../lib/phpqrcode/qrlib.php";    

$mensaje = 'http://luis3ignacio.awardspace.com/testing/';
$uuid='0001';


for($j=1;$j<=5;$j++){
	$uuid = sprintf("%04d",$j);
	$errorCorrectionLevel = 'L';  #'L','M','Q','H'
	$matrixPointSize = 10;
	$marginPointSize = 3;
	
	$filename = './imglist/qr_uuid_'.$uuid.'.png';
	
	QRcode::png($mensaje.$uuid, $filename, $errorCorrectionLevel, $matrixPointSize, $marginPointSize);   
	
	$percent = 1;
	
	// Content type
	#header('Content-Type: image/png');
	
	// Get new sizes
	list($width, $height) = getimagesize($filename);
	$newwidth = $width * $percent;
	$newheight = $height * $percent;
	
	// Load
	$thumb = imagecreatetruecolor($newwidth, $newheight*1.25);
	$source = imagecreatefrompng($filename);
	
	$white = imagecolorallocate($thumb, 255, 255, 255);
	imagefill($thumb, 0, 0, $white);
	
	// Resize
	imagecopyresized($thumb, $source, 0, 0, 0, 0, $newwidth, $newheight, $width, $height);


	//TEXT PART
	$text = $uuid;
	$font = 'my-font-path.ttf';
	$color = imagecolorallocate($thumb, 0, 0, 0);
	$font_size = 90;
	$maxwidth = 110;

	$words = explode(" ",$text);
	$wnum = count($words);
	$line = '';
	$text='';
	for($i=0; $i<$wnum; $i++){
	  $line .= $words[$i];
	  $dimensions = imagettfbbox($font_size, 0, $font, $line);
	  $lineWidth = $dimensions[2] - $dimensions[0];
	  if ($lineWidth > $maxwidth) {
		$text.=($text != '' ? '|'.$words[$i].' ' : $words[$i].' ');
		$line = $words[$i].' ';
	  }
	  else {
		$text.=$words[$i].' ';
		$line.=' ';
	  }
	}


	foreach(explode('|',$text) as $i=>$e) {
		imagettftext($thumb, $font_size, 0, 35, $newheight+85+(($font_size+5)*$i), $color, $font, $e);
	}

	// Output
	imagepng($thumb,'./imglist/qr_uuid_'.$uuid.'.png',9);
	
	imagedestroy($thumb);
	imagedestroy($source);
	
	printf("QR-Code %s creado. \n",$uuid); 
}
	