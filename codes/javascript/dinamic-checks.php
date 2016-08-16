<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> <!--iso-8859-1 -->
<title>Blank Page</title>
<script type="text/javascript" src="js/jquery-1.2.1.min.js"></script>
<script type="text/javascript">

indExtFlds = <?php

//START OF  "indExtFlds"
//When you bring Data from DataBases
//this variable tells to the javascript
//which will be the next ID for the fields
//generated when a user clicks on
//"Agregar Campos"

echo isset($_POST['txtCampos'])
    ? $indExtFlds = count($_POST['txtCampos'])
    : 0 ;
?> ;

datos = {uno:1,dos:2,tres:3} ;

function generarComponentes(datos) {
    datos.chk1 = datos.chk1 ? ' checked="checked" ' : '' ;
    $('#ExtraFields').append('' 
        + '<div>'
        + '<a href="javascript:void(0);" onclick="eliminarCampos(this);">Eliminar</a>'
        + '<input type="text" name="txtCampos['+datos.id+']" value="'+datos.texto+'" />'
        + '<input type="checkbox" name="chkCampos['+datos.id+']"  '+datos.chk1+' />'
        + '</div>'
    );
}

function agregarCampos(cantidad) {
	if(cantidad>0) 
	for(i=0;i<cantidad;i++) {
        datos = {id:indExtFlds,texto:'',chk1:false} ;
        generarComponentes(datos) ;
        indExtFlds ++ ;
	}
}

function eliminarCampos(obj) {
    $(obj).parent().remove();
}

$(function(){
	$('#AgregarCampos')
		.attr('href','javascript:void(0);')
		.bind('click',function(){
			agregarCampos(1);
		});
	//if(indExtFlds==0) agregarCampos(1);
});

</script>
</head>

<body>
<?php
echo '<b>SALIDA:</b><br />','<pre>',var_dump($_POST),'</pre>';
?>
<hr />

<form method="post">
<a href="javascript:void(0);" onclick="agregarCampos(1);">Agregar Campos</a>
<div id="ExtraFields"><!-- --></div>
<?php

//TOTAL DATA GENERATOR
//A counter for the records brought by a DataBase.
//e.g.: If you bring 4 records, the components will be
//enumerated 0...3. REMEMBER: In this example,
//JS  "indExtFlds"  value (At top of file) should be "4"
$fldInd = 0 ;

if( isset($_POST['txtCampos']) ) {
    echo '
    <script type="text/javascript">
    $(function(){
    ';
    foreach($_POST['txtCampos'] as $ind => $data) {
        $checked = isset($_POST['chkCampos'][$ind])
            ? 'true' : 'false' ;
        
        echo "
        datos = { id:{$fldInd}, texto:'{$data}', chk1:{$checked} };
        generarComponentes( datos );
        " ;
        
        $fldInd++;
    }
    echo '
    });
    </script>
    ';

}
?>
<input name="Enviar" type="submit" value="Enviar" />
</form>

</body>
</html>
