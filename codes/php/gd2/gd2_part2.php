<?php
//=============[ IMAGE HEADERS ]====================================

header("Cache-Control: no-cache, must-revalidate"); // HTTP/1.1
header("Expires: Mon, 26 Jul 1997 05:00:00 GMT"); // Date in the past
header("Content-Type: image/png"); // Date in the past

//=============[ IMAGE CONTENT ]====================================

//$im = imageCreate ( int x_size, int y_size)
$im = imageCreateFromPNG('GoogleNavLogo.png') ;


//imagePNG($im,null,0,PNG_ALL_FILTERS);  //Nombre de Archivo como Parametro #2
imageJPEG($im,null,0); //100%
//imageWBMP($im);
//imageGIF($im);
//imageGD($im);
imageDestroy($im);
//imageGD2($im);

?>