<?php

/*
Shortcut Command:
D:\ignacio\apps\xampp\php\php.exe "D:\ignacio\apps\xampp\htdocs\ignacio_test\php_prompt.php"
*/

$fp = fopen("php://stdin", "r");
$in = '';
while($in != "quit") {
    echo "php> ";
    $in=trim(fgets($fp));
    eval ($in);
    echo "\n";
    }
   