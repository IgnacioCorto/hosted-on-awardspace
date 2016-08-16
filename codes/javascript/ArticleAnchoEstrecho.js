// JavaScript Document

// alert ( jQuery('.Categories .Article').size() ) ;

if( jQuery('.Categories .Article').size() >= 5 ) {

	jQuery('.Categories .Article').each( function(i,e){
		if(i<4) {
			jQuery(e).appendTo( jQuery('.ArticulosAnchos') );
		} else {
			jQuery(e).appendTo( jQuery('.ArticulosEstrechos') );
		}
	} ) ;
	
} 

 else {
	
	jQuery('.Categories .Article').each( function(i,e){
		jQuery(e).appendTo( jQuery('.ArticulosNormales') );
	} ) ;
		
}