<html>

<head>
<title>Ignacio File Browser</title>
</head>

<body>
<pre>
<?php
$dir = "./";
if( isset($_GET['d']) ) {
    $dir .= $_GET['d'] . '/' ;
}

$param_path = realpath($dir) ;
$script_path = realpath('.');

if ( strpos($param_path,$script_path)=== FALSE 
        || $param_path===$script_path ) {
    $isRoot = true ;
    $dir = "./";
} else {
    $isRoot = false ;
}    

// ### PATH DEBUGGING ###    
// var_dump($isRoot);
// echo "Param : $param_path \n";
// echo "Script: $script_path \n";

if( isset($_GET['f']) ) {
    $lnkVolver="<a href='javascript:void(0);' onclick='history.back();'>&laquo Volver al Directorio</a> \n\n";
    echo $lnkVolver ;
    echo addslashes(htmlentities(implode('',file($_GET['f'])))) ;
    echo "\n\n".$lnkVolver ;
} else {

    // Open a known directory, and proceed to read its contents
    $ruta_actual = str_replace($script_path, "", realpath($dir) );
    echo "RUTA: .{$ruta_actual} \n";
    if($dir!='./') echo "<a href='./'>Volver a la Raiz</a> \n";
    echo "\n\n";

    if (is_dir($dir)) {
        // if ($dh = opendir($dir)) {
            // while (($file = readdir($dh)) !== false) {
                // if($file=='.') continue ;
                // if($isRoot && $file=='..') continue ;
                // $tipoArchivo = filetype($dir.$file) ;
                // switch($tipoArchivo){
                    // case 'dir':
                        // echo "[DIR] <a href='?d={$dir}{$file}'>{$file}</a> \n";
                        // break;
                    // case 'file':
                        // echo "[---] <a href='?f={$dir}{$file}'>{$file}</a> \n";
                        // break;
                    // default:
                        // echo "[{$file}] \n";
                        // break;
                // }
            // }
            // closedir($dh);
        // }
        
        $arrFiles = glob($dir.'/*') ;
        sort($arrFiles);
        $dirList = $fileList = '' ;


        foreach ($arrFiles as $filename) {
            $filename_parts = pathinfo($filename) ;
            $filename_basename = $filename_parts['basename'] ;

            $tipoArchivo = filetype($filename) ;
            switch($tipoArchivo){
                case 'dir':
                    $dirList .= "[DIR] <a href='?d={$filename}'>{$filename_basename}</a> \n";
                    break;
                case 'file':
                    $fileList .= "[---] <a href='{$filename}'>{$filename_basename}</a> \n";
                    break;
                default:
                    echo "[{$filename_basename}] \n";
                    break;
            }
        }
        echo $dirList . $fileList ;

    }
}

?>
</pre>
</body>

</html>