<?php

$valid_user = isset($_COOKIE['IgnacioDebugCookie']) 
	&& $_COOKIE['IgnacioDebugCookie']=='clipboard' ;


$filename = 'clipboard.txt';


if($valid_user and isset($_POST['clipboard_text'])){

	$clipboard_text = stripslashes($_POST['clipboard_text']) ;

    $fp = fopen($filename,'wt');
    fwrite( $fp, $clipboard_text );
    fclose($fp);

} else {

	$fp = fopen($filename,'rt');
	$clipboard_text = fread($fp,filesize($filename)) ;
	fclose($fp);

}





if( $valid_user ){
?>

<form method="post">
<input type="submit" />
<br />
<textarea name="clipboard_text" rows="25" cols="80"><?=$clipboard_text?></textarea>
<br />
<input type="submit" />
</form>


<?php } else { ?>

<pre style="white-space:pre-wrap; width:642px; border:1px solid black; padding:10px;">
<?php echo htmlspecialchars($clipboard_text)?>
</pre>

<?php } ?>


