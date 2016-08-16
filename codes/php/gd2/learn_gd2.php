<?php
if(isset($_GET['imagen'])) {
//=============[ IMAGE HEADERS ]====================================
	
header("Cache-Control: no-cache, must-revalidate"); // HTTP/1.1
header("Expires: Mon, 26 Jul 1997 05:00:00 GMT"); // Date in the past
header("Content-Type: image/png"); // Date in the past

//=============[ IMAGE CONTENT ]====================================

//$im = imageCreate ( int x_size, int y_size)
$im = imageCreateTrueColor ( 400 , 60 ) ;


//B/W Colors
$black = imageColorAllocate($im,0,0,0);
$gray = imageColorAllocate($im,128,128,128);
$white = imageColorAllocate($im,255,255,255);

//RGB Colors
$red = imageColorAllocate($im,255,0,0);
$green = imageColorAllocate($im,0,255,0);
$blue = imageColorAllocate($im,0,0,255);

//CMYK Colors
$cyan = imageColorAllocate($im,0,255,255);
$magenta = imageColorAllocate($im,255,0,255);
$yellow = imageColorAllocate($im,255,255,0);

//Image Editing

imageFill($im,50,50,$blue);

imageSetPixel($im,10,10,$yellow);
imageSetPixel($im,15,15,$yellow);
imageSetPixel($im,20,10,$yellow);
imageLine($im,10,20,20,20, $yellow);

imageRectangle($im,30,10,40,20, $yellow);
imageFilledRectangle($im,50,10,60,20, $yellow);

$boxEmpty = array(70,20,75,10,80,20);
imagePolygon($im,$boxEmpty,3,$yellow);
$boxFilled = array(90,10,95,20,100,10);
imageFilledPolygon($im,$boxFilled,3,$yellow);

imageEllipse($im,115,15,10,10, $yellow);
imageFilledEllipse($im,135,15,10,10, $yellow);

imageArc($im,160,20,20,20,180,270, $yellow);
imageFilledArc($im,180,20,20,20,180,270, $yellow,IMG_ARC_CHORD|IMG_ARC_NOFILL);
imageFilledArc($im,200,20,20,20,180,270, $yellow,IMG_ARC_PIE);
imageFilledArc($im,220,20,20,20,180,270, $yellow,IMG_ARC_CHORD);
imageFilledArc($im,240,20,20,20,180,270, $yellow,IMG_ARC_EDGED|IMG_ARC_NOFILL);
imageFilledArc($im,260,20,20,20,180,270, $yellow,IMG_ARC_CHORD|IMG_ARC_EDGED|IMG_ARC_NOFILL);

imageFilledArc($im,280,20,20,20,180,270, $yellow,IMG_ARC_EDGED|IMG_ARC_NOFILL);
imageFill($im,278,18, $green);

imageFilledArc($im,300,20,20,20,180,270, $yellow,IMG_ARC_CHORD|IMG_ARC_EDGED|IMG_ARC_NOFILL);
imageFillToBorder($im,298,18, $yellow, $magenta);

imageString($im,3, 10,28, 'I will be Rich, Millionaire, and Powerfull',$yellow);

//imageAntiAlias($im,true);
//$fontFile = 'C:\WINDOWS\Fonts\roccb___.ttf';
$fontFile = './arialbd.ttf';
$angle = 0 ;
$message = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
$size = 12 ;
//imageTTFText($im,$size,$angle,10,55,$yellow,$fontFile,$message);

//This Works Well With GIF Output:
//$transparent = imageColorTransparent($im,$blue);

//Image Outputing & Destroying

//imagePNG($im,null,0,PNG_ALL_FILTERS);  //Nombre de Archivo como Parametro #2
imagePNG($im);  //Nombre de Archivo como Parametro #2
//imageJPEG($im);
//imageWBMP($im);
//imageGIF($im);
//imageGD($im);
//imageGD2($im);
imageDestroy($im);

} else { 
//=============[ HTML CONTENT ]====================================
?>
<style>body{background:green;}</style>
<h2>GD2 Image:</h2>	
<b>Pending:</b> Clock <br />
<img src="?imagen" /> <br />
<img src="gd2_part2.php" /> <br />

<?php 


echo '<pre><b>===[ getImageSize ]===</b><br />',var_dump(getImageSize('GoogleNavLogo.png')),'</pre>';

echo '<b>===[ Supported Formats ]===</b><br />';
if (imagetypes() & IMG_GIF) echo "GIF Support is enabled<br />";
if (imagetypes() & IMG_JPG) echo "JPEG Support is enabled<br />";
if (imagetypes() & IMG_PNG) echo "PNG Support is enabled<br />";
if (imagetypes() & IMG_WBMP) echo "WBMP Support is enabled<br />";

echo '<pre><b>===[ GD Info ]===</b><br />',var_dump(gd_info()),'</pre>';

} ?>