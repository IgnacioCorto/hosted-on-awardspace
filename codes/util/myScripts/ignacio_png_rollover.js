<!--

/*
	Write this code wherever you need a PNG rollover:
	
			<script type="text/javascript"><!--
			openPNG('images/picture_normal.png','images/picture_rollover.png',' class="nav_btn" width="90" ');
			//--></script>
*/

function openPNG(imagen,roll_over,atributes) {
  salida_estandar = "";
  salida_rollover = "";

		versionIE = parseFloat 
								( navigator.userAgent.split('MSIE')[1] );
	
		if ( versionIE < 7 ) { 
  
			if(roll_over) {
				salida_rollover = 						
				' onmouseover="this.filters(0).src= \''+roll_over+'\' ;"' + 
				' onmouseout="this.filters(0).src= \''+imagen+'\' ;"' ; 
			}

			salida_estandar = 						
			'<img ' +
			' src="images/spacer_transparent.gif" ' +
			' style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=\'' + imagen + '\', sizingMethod=\'image\');" ' +
			salida_rollover +
			' ' + atributes + ' alt="" border="0" />';
			
		} else {
			if(roll_over) {
				salida_rollover = 						
				' onmouseover="this.src=\'' + roll_over + '\';" ' + 
				' onmouseout="this.src=\'' + imagen + '\';" ';
			}

			salida_estandar = 						
			'<img ' +
			' src="' + imagen + '" ' +
			salida_rollover +
			' ' + atributes + ' alt="" border="0" />';
		}

			document.write(salida_estandar);

	
}
//-->