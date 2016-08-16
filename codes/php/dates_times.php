<a href="/codes/?f=././/php//dates_times.php">[Code]</a><hr />

<?php
#URL:   http://luis3ignacio.awardspace.com/codes/php/dates_times.php

setlocale(LC_ALL, "esn", "spanish-modern", 'es', 'es_DO', 'sp', 'es_ES');
if(function_exists('date_default_timezone_set'))
	date_default_timezone_set('America/Santo_Domingo');   

/* CONDICIONAL DEL TIEMPO */
# $current_time = time(); strftime("%Y-%m-%d %H:%M:%S");# , mktime(19,30,00,9,19,2013));
echo '<!-- ';
if(time()<=mktime(23,59,59,12,31,2012)){
	echo ' no ha pasado ';
} else {
	echo ' ya paso ';
}
echo ' -->';


/* SPANISH INPUT DATE */
$a=explode('/','31/12/1999');
$d_dts =strftime("%Y-%m-%d", mktime(0,0,0,$a[1],$a[0],$a[2]) );

$english   = strftime("%Y-%m-%d %H:%M:%S");
$dominican = strftime("%d/%m/%Y %I:%M:%S %p (%P)");
$verbose   = strftime("%A, %B %d, %Y - %I:%M:%S %p");
$month     = strftime("%b %B", mktime(0,0,0,9,0,0));
$weekday   = strftime("%j, %a %A %w (%u)");
$week      = strftime("%U %W (%V)");
$ts        = strftime("%y, %c (%s)");
$ts_z      = strftime("%Y%m%dT%H%M%SZ");

echo <<<EOT
<h3>Date & Time:</h3>
<b>Exploded: $d_dts</b> <br />
English:     $english <br />
Dominican:   $dominican <br />
Verbose:     $verbose <br />
Month:       $month <br />
WeekDay:     $weekday -- <i>Days</i> <br />
Week:        $week  -- <i>Sun, Mon, ISO</i> <br />
TimeStamp:   $ts -- <i>Year, Local, Epoch</i> <br />
ISO UTC:   $ts_z <br />
EOT;
