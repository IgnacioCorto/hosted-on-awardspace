// JavaScript Document

nextSecc = 0 ;

function eliminarCampos(obj){
	if( window.confirm('Seguro desea borrar seccion?') )
	jQuery(obj).parent().remove();
}

function seleccionRadios(e){
	//alert( jQuery(this).attr('name') );
	DatoValue = Number(jQuery(this).attr('value')) ;
	//alert(DatoValue);

	//children('.labelFoto3').html()
	//alert( jQuery(this).parents('.SeccionChavon').size() );
	//alert( jQuery(this).attr('name') );
	//alert( jQuery(this).parents('.SeccionChavon').html() );
	//alert( jQuery(this).parents('.SeccionChavon').find('.labelDescripcion').size() );
	
	if( DatoValue==3 ) {
		jQuery(this).parents('.SeccionChavon').find('.labelDescripcion').hide();
		jQuery(this).parents('.SeccionChavon').find('.labelFoto3').show();
	} else {
		jQuery(this).parents('.SeccionChavon').find('.labelDescripcion').show();
		jQuery(this).parents('.SeccionChavon').find('.labelFoto3').hide();
	}
}

function agregarCampos(cantidad) {
	if(cantidad>0) 
	for(i=0;i<cantidad;i++) {
		jQuery('#AreaDeSecciones').append("   \
 \
<div class='SeccionChavon'>  \
  <input type='hidden' name='id_secciones["+nextSecc+"]' id='id_secciones' />  \
  Tipo de Secci&oacute;n:<br />   \
  	  <div class='tipoSeccion'> \
	  <label><input type='radio' name='tipo_secciones["+nextSecc+"]' value='1' checked='checked'> <img src='images/bloque_a.jpg' class='template' /></label> \
	  <label><input type='radio' name='tipo_secciones["+nextSecc+"]' value='2'> <img src='images/bloque_b.jpg' class='template' /></label> \
	  <label><input type='radio' name='tipo_secciones["+nextSecc+"]' value='3'> <img src='images/bloque_c.jpg' class='template' /></label> \
	  <label><input type='radio' name='tipo_secciones["+nextSecc+"]' value='4'> <img src='images/bloque_d.jpg' class='template' /></label> \
	  </div> \
	  \
	  <br /><a href='javascript:void(0);' class='EliminarCampos'>[Eliminar Seccion]</a><br />  \
  \
<div>  \
  <label>  \
  T&iacute;tulo Espa&ntilde;ol:  \
  <input type='text' name='titulo_secciones["+nextSecc+"]' id='titulo_secciones' />  \
  \
  </label>  \
   <a href='javascript:void(0);' onclick='jQuery(this).parent().next().toggle();'>Ver m&aacute;s</a><br />  \
</div><div style='display:none;'>  \
  <label class='labelDescripcion'>  \
  Descripci&oacute;n:<br />  \
  <textarea name='descripcion_secciones["+nextSecc+"]' id='descripcion_secciones_"+nextSecc+"' cols='45' rows='5'></textarea>  \
  </label>  \
  <br />  \
  \
Foto1:   \
<label>  \
<input type='file' name='foto1_secciones["+nextSecc+"]' id='foto1_secciones'  />  \
</label>  \
<br />  \
Foto2:  \
<label>  \
<input type='file' name='foto2_secciones["+nextSecc+"]' id='foto2_secciones'  />  \
</label>  \
<br />  \
<label class='labelFoto3'>  \
Foto3:  \
<input type='file' name='foto3_secciones["+nextSecc+"]' id='foto3_secciones'  />  \
</label>  \
<br />  \
<br />  \
</div>  \
  \
<div>  \
  <label>  \
  T&iacute;tulo Ingl&eacute;s:  \
  <input type='text' name='titulo_secciones_en["+nextSecc+"]' id='titulo_secciones_en'  />  \
  \
  </label>  \
   <a href='javascript:void(0);' onclick='jQuery(this).parent().next().toggle();'>Ver m&aacute;s</a><br />  \
</div><div style='display:none;'>  \
  <label class='labelDescripcion'>  \
  Descripci&oacute;n:<br />  \
  <textarea name='descripcion_secciones_en["+nextSecc+"]' id='descripcion_secciones_en_"+nextSecc+"' cols='45' rows='5'></textarea>  \
  </label>  \
  <br />  \
  \
Foto1:   \
<label>  \
<input type='file' name='foto1_secciones_en["+nextSecc+"]' id='foto1_secciones_en' />  \
</label>  \
<br />  \
Foto2:  \
<label>  \
<input type='file' name='foto2_secciones_en["+nextSecc+"]' id='foto2_secciones_en' />  \
</label>  \
<br />  \
<label  class='labelFoto3'>  \
Foto3:  \
<input type='file' name='foto3_secciones_en["+nextSecc+"]' id='foto3_secciones_en' />  \
</label>  \
<br />  \
<br />  \
</div>  \
\
  <label>\
  Link Externo:\
  <input type='text' name='link_secciones["+nextSecc+"]' id='link_secciones'  value='' />\
  </label>\
\
<br />  \
<br />  \
</div>  \
").find('.EliminarCampos:last').bind('click', function(){
			eliminarCampos(this);
		});

		jQuery('.SeccionChavon:last .tipoSeccion input:radio').bind('click',seleccionRadios);
		jQuery('.SeccionChavon:last .tipoSeccion input:radio:checked').each(function(i,e){
			jQuery(e).triggerHandler('click');
		});



		tinyMCE.init({
			mode : "exact",
			elements : "descripcion_secciones_"+nextSecc+",descripcion_secciones_en_"+nextSecc+"",
			theme : "advanced"

		});		

	} //end for
		

	nextSecc++;
	
} //end agregarDatos



jQuery(function(){
	jQuery('.AgregarCampos')
		.attr('href','javascript:void(0);')
		.bind('click',function(){
			agregarCampos(1);
		});
	//alert( jQuery('.SeccionChavon .tipoSeccion input:radio:checked').size() );

	jQuery('.SeccionChavon .tipoSeccion input:radio').bind('click',seleccionRadios);
	jQuery('.SeccionChavon .tipoSeccion input:radio:checked').each(function(i,e){
		jQuery(e).triggerHandler('click');
	});
//	jQuery('.SeccionChavon .tipoSeccion input:radio:checked').trigger('click');
	
//	alert( jQuery('.SeccionChavon .tipoSeccion input:radio:first').attr('name') );
//	alert( jQuery('.SeccionChavon .tipoSeccion input:radio').size() );
		
});






