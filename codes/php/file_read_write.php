<?php

function read_txt($filename) {
	$fp = fopen($filename,'rt');
	$size = filesize($filename) ;
	if($size && $size>0) $string = fread($fp,$size) ;
	fclose($fp);
	return $string;
}

function write_txt($filename, $string) {
	$fp = fopen($filename,'wt');
	fwrite( $fp,$string );
	fclose($fp);
}
