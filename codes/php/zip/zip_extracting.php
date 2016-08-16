<pre>
<?php
$zip = new ZipArchive;
if ($zip->open('prueba01.zip') === TRUE) {
    $zip->extractTo('./fld/');
    $zip->close();
    echo 'ok';
} else {
    echo 'failed';
}
?>
</pre>