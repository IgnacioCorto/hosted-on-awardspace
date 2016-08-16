<?php

$archivos = array(
    'hola.txt',
    'hello.txt',
    'bonjour.txt',
    'konnichi.txt',
    );

$filename = "prueba01.zip";



$zip = new ZipArchive();

if ($zip->open($filename, ZIPARCHIVE::CREATE)!==TRUE) {
    exit("cannot open <$filename>\n");
}

foreach($archivos as $oneFile) {
    $zip->addFile( $oneFile , basename($oneFile) );
}

echo "numfiles: " . $zip->numFiles . "\n";
echo "status:" . $zip->status . "\n";
$zip->close();

?> 