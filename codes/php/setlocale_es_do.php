<a href="http://msdn.microsoft.com/en-us/library/39cwe7zf%28v=vs.90%29.aspx">Language Strings</a><br />
<a href="http://msdn.microsoft.com/en-us/library/cdax410z%28v=vs.90%29.aspx">Country/Region Strings</a><br />
<hr />

<?php

$locales = `locale -a`; # system('locale -a');
#var_dump($locales);
#$array_locales = explode("\n", $locales);  
$array_locales = array('spain', 'SUBLANG_SPANISH_DOMINICAN_REPUBLIC', 'spanish', 'spanish-mexican', 'spanish-modern', 'es_ES', 'es_AR', 'es_BO', 'es_CL', 'es_CO', 'es_CR', 'es_DO', 'es_EC', 'es_SV', 'es_GT', 'es_HN', 'es_MX', 'es_NI', 'es_PA', 'es_PY', 'es_PE', 'es_PR', 'es_UY', 'es_VE', 'sp');


error_reporting(0);

$a_Remaining = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
$a_Formats = array(
  'Day'                 => 'aAdejuw',
  'Week'                => 'UVW',
  'Month'               => 'bBhm',
  'Year'                => 'CgGyY',
  'Time'                => 'HIlMpPrRSTXzZ',
  'Time and Date Stamps'=> 'cDFsx',
  'Miscellaneous'       => 'nt%',
  'Unknown'             => &$a_Remaining
);


foreach($array_locales  as $e){
	setlocale(LC_ALL, trim($e));
	$testing[0] = strtolower(strftime('%A %B %p', strtotime('2011-08-30 23:59:59')));
	$testing[1] = strtolower(date('l F A', strtotime('2011-08-30 23:59:59')));

	$timestamp = strftime('%c', strtotime('2011-08-30 23:59:59'));
	if(true or in_array('martes agosto pm',$testing)){
		echo "<strong>$e:</strong> {$testing[0]}, {$testing[1]} ($timestamp)<br />";
	}

	/*
	echo "<h2>$e</h2>",'<pre>';
	foreach($a_Formats as $s_Group => $s_GroupFormats) {
	  echo $s_Group, PHP_EOL;
	  foreach(range(0, strlen($s_GroupFormats) - 1) as $i_Format) {
		echo
		  "\t{$s_GroupFormats[$i_Format]} : ",
		  (!($s_Output = strftime('%' . $s_GroupFormats[$i_Format]))
			? "\t\t\t[Unknown]"
			: $s_Output),
		  '<br />',
		  PHP_EOL;
		$a_Remaining = str_replace($s_GroupFormats[$i_Format], '', 
	$a_Remaining);
	  }
	}
	echo '</pre>';
	//*/
}




