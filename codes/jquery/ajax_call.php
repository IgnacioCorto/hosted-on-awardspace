<?php
if(isset($_REQUEST['call1'])) {
	$output = array('value'=>strftime("Call1 = %c"));
	
	echo json_encode($output);
	die();
}

if(isset($_REQUEST['call2'])) {
	echo strftime("Call2 = %c");
	die();
}


?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Untitled Document</title>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.0/jquery.js"></script>
<script type="text/javascript">


function doCall1(){
	jQuery.ajax({
		type: "POST",
		dataType: "json",
		url: "ajax_call.php",
		data: { 'call1': "true" }
	})
	.done(function( msg ) {
		jQuery('span#call1').html(msg.value);
	})
	.fail(function( jqXHR, textStatus ) {
		alert( "Request failed: " + textStatus );
	})
	;
}


function doCall2(){
	jQuery('span#call2').load("ajax_call.php", { 'call2': "true" });
}


function doCall3(){
	alert('en un cine cerca de usted');
}


</script>
</head>
<body>
<a href="#" onclick="doCall1();">Call #1</a>: <span id="call1"></span> <br />
<a href="#" onclick="doCall2();">Call #2</a>: <span id="call2"></span> <br />
<a href="#" onclick="doCall3();">Call #3</a>: <span id="call3"></span> <br />
</body>
</html>