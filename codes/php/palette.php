<?php

$i=254/($_GET['div']+0.01);

for ($r=0;$r<255;$r+=$i) {
    for ($g=0;$g<255;$g+=$i) {
        for ($b=0;$b<255;$b+=$i) {
            echo 
               intval($b).','.
               intval($g).','.
               intval($r).'<br />';
        }
    }
}
