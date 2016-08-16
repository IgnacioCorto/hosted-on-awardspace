<?php
include("cache.start.php");
$q = file_get_contents("http://api.twitter.com/1/statuses/user_timeline.json?include_entities=true&include_rts=true&screen_name=" . $_GET["q"] . "&count=3");
echo $q;
include("cache.end.php");
?>
