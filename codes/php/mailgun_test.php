<?php

# === [ DOWNLOAD MAILGUN LIBRARY **PREFERRED** ] ===
#
#   >> https://github.com/mailgun/mailgun-php
#  and search for "Library Download" link;
#  as of 2014-03-06, the link was:
#   >> https://9f67cbbd1116d8afb399-7760483f5d1e5f28c2d253278a2a5045.ssl.cf2.rackcdn.com/mailgun-php-1.7.zip
#
#
# === [ MANUAL INSTALLATION OF MAILGUN LIBRARY ] ===
#
# curl -sS https://getcomposer.org/installer | /Applications/MAMP/bin/php/php5.3.6/bin/php
# /Applications/MAMP/bin/php/php5.3.6/bin/php composer.phar require mailgun/mailgun-php:~1.7
#
# curl -sS https://getcomposer.org/installer | php
# php composer.phar require mailgun/mailgun-php:~1.7
#


require 'vendor/autoload.php';
use Mailgun\Mailgun;

$mgClient = new Mailgun('key-abcdefghijklmnopqrstuvwxyz012345');
$domain = "sandbox00000.mailgun.org";

# SEND EMAIL
# http://documentation.mailgun.com/api-sending.html#examples
$result = $mgClient->sendMessage("$domain",
                  array('from'    => 'Ignacio From <dummyfrom@dummydomain.com>',
                        'to'      => 'Ignacio To <dummyto@dummydomain.com>',
                        'subject' => 'mailgun #2',
                        'text'    => 'otro mensaje de mailgun!!'));
						
header('Content-Type: application/json'); 
echo json_encode($result);	