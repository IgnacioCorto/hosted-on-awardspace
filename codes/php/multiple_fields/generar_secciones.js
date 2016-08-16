// JavaScript Document

nextSecc = 0 ;

function eliminarCampos(obj){
	if( window.confirm('Seguro desea borrar seccion?') )
	jQuery(obj).parent().remove();
	}



function agregarCampos(cantidad) {
	if(cantidad>0) 
	for(i=0;i<cantidad;i++) {
		jQuery('#AreaDeSecciones').append("   \
 \
<div class='SeccionChavon'>  \
  <input type='hidden' name='id_secciones["+nextSecc+"]' id='id_secciones' />  \
  Tipo de Secci&oacute;n:   \
  <select name='tipo_secciones["+nextSecc+"]' id='tipo_secciones'>  \
  <option value='1'  >A</option>  \
  \
  <option value='2'  >B</option>  \
  <option value='3'  >C</option>  \
  <option value='4'  >D</option>  \
  </select>  <a href='javascript:void(0);' class='EliminarCampos'>[Eliminar Seccion]</a><br />  \
  \
<div>  \
  <label>  \
  T&iacute;tulo Espa&ntilde;ol:  \
  <input type='text' name='titulo_secciones["+nextSecc+"]' id='titulo_secciones' />  \
  \
  </label>  \
   <a href='javascript:void(0);' onclick='jQuery(this).parent().next().toggle();'>Ver m&aacute;s</a><br />  \
</div><div style='display:none;'>  \
  Descripci&oacute;n:<br />  \
  <label>  \
  <textarea name='descripcion_secciones["+nextSecc+"]' id='descripcion_secciones' cols='45' rows='5'></textarea>  \
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
  Descripci&oacute;n:<br />  \
  <label>  \
  <textarea name='descripcion_secciones_en["+nextSecc+"]' id='descripcion_secciones_en' cols='45' rows='5'></textarea>  \
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
<br />  \
</div>  \
  \
<br />  \
<br />  \
</div>  \
").find('.EliminarCampos:last').bind('click', function(){
		eliminarCampos(this);
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
});






