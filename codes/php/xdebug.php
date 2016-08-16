<?php

error_reporting(E_ALL);
xdebug_start_code_coverage();

## Include con Muchos Includes ##
include_once "include_largo.php";

foreach( xdebug_get_code_coverage() as $k=>$v ) {
    echo "<b>{$k}</b><br />" ;   
}

?>