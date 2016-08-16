<?php

	### 1st VERSION ###
	
	$c=0;
	$ipp=3;
	$total=count($elements);
	
	echo '<div class="wrap">';
	foreach($elements as $i=>$e) {
		if($c%$ipp==0) echo '<div style="margin:5px; border:1px solid red;">';
		echo "<a href='#'>";
		echo $i,$e;
		echo '</a>';
		if($c%$ipp==$ipp-1 or $total==$c+1) echo '</div>';
		
		$c++;
	}
	echo '</div>';
	

	### 2nd VERSION ###

	$arr_list = range(1,14);
	foreach($arr_list as $i=>$e){
		if($i%4==0 && $i<count($arr_list)-1) echo "<ul>\n";
		echo "<li><a href=\"#\">$e</a></li>\n";
		if($i%4==3 || $i>=count($arr_list)-1) echo "</ul>\n";
    }


    ### SHOW PREV AND NEXT INDEXES ###
    if($prev_index >= 1) echo 'PREV LINK';
    if($next_index <= $total) echo 'NEXT LINK';


?>

