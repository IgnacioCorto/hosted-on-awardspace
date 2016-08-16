<?php
header("Content-Disposition: attachment; filename=\"el_fuerte.xls\""); 
header("Content-Type: application/vnd.ms-excel"); 
header("Cache-Control: no-cache, must-revalidate"); // HTTP/1.1
header("Expires: Sat, 26 Jul 1997 05:00:00 GMT"); // Date in the past
?>

<html>
<head>
<title>Excel File</title>
<style>
.bignum {
	mso-number-format:"#,##0.000";	
}
.sqldate {
	mso-number-format:"yyyy-mm-dd hh:mm:ss";
	/*mso-number-format:"yyyy\\mm\\dd"*/
}
.drdate {
	mso-number-format:"dd/mm/yyyy hh:mm:ss AM/PM";
	/*mso-number-format:"yyyy\\mm\\dd"*/
}
</style>

</head>
<body>

<h2>Prueba 3</h2>

<table>
<tr>
  <td>Ignacio</td>
  <td class="sqldate">27/2/2011 11:59:59 pm</td>
</tr>
<tr>
  <td>'Cortorreal</td>
  <td class="bignum">999999999999</td>
</tr>
<tr>
  <td>Fecha</td>
  <td class="drdate">2010-02-27 23:59:59</td>
</tr>

</table>


</body>
</html>