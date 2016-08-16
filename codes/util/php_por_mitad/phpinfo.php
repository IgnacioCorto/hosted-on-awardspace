<?php 
echo 'Current PHP version: ' . phpversion();
echo phpversion('tidy');
echo "<br />\n============================<br />\n<pre>";

print_r(get_loaded_extensions());
echo "</pre><br />\n============================<br />\n";

phpinfo(); 
?>