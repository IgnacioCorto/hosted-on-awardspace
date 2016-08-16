<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<script type="text/javascript" src="js_frmwrks/jquery-1.2.6.min.js"><!-- --></script>
<script type="text/javascript">

function agregarCampos(cantidad) {
	if(cantidad>0) 
	for(i=0;i<cantidad;i++) {
		$('#ExtraFields').append('' 
			+ '<div>'
			+ '<a class="EliminarCampos">Eliminar</a>'
			+ '<input type="text" name="txtCampos[]" />'
			+ '<input type="checkbox" name="chkCampos[]" value="asdf" />'
			+ '</div>'
		);
		$('.EliminarCampos')
			.attr('href','javascript:void(0);')
			.bind('click',function(){
				$(this).parent().remove();
			});
	}
}

$(function(){
	$('#AgregarCampos')
		.attr('href','javascript:void(0);')
		.bind('click',function(){
			agregarCampos(1);
		});
	agregarCampos(1);
});

</script>
</head>

<body>
<?php
echo '<pre>SALIDA:<br />',var_dump($_POST),'</pre>';
?>
<hr />

<form method="post">
<a id="AgregarCampos">Agregar Campos</a>
<div id="ExtraFields"><!-- --></div>
<input name="Enviar" type="submit" value="Enviar" />
</form>

</body>
</html>
