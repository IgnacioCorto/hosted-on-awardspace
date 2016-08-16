<?php
/***************************************************************************
 *                               grupos.php
 *                            -------------------
 *   copyright            : (C) 2008, comuniQue
 *   email                : soporte@comunique.com.do
 *   description          : Archivo que maneja los grupos del website.
 *   author               : Juan Puntiel, Rafael Villavizar, Ignacio Cortorreal
 *   modification         : Oct 4, 2008: Ignacio Cortorreal
 *
 ***************************************************************************/

/***************************************************************************
 *
 *   Este archivo es de uso exclusivo de comuniQue para sus clientes. La
 *   reproducción y/o distribución parcial o total de este archivo sin
 *   ermiso de comuniQue o sus representantes está prohibida.
 *
 ***************************************************************************
 *
 *   This file is for exclusive use of comuniQue to its clients. The
 *   total or parcial reproduction and/or distribution of this file
 *   without permission from comuniQue or its representants is prohibited.
 *
 ***************************************************************************/

//Incluye el archivo de login en esta página por asuntos de seguridad.
@include('login.php');
//Incluye archivo de configuracion
include ('../inc/config.php');
//Incluye archivo de funciones
include_once('inc/functions.php');
//Incluye la clase.
include ('../class/class.productos.php');
include ('../class/class.grupos.php');
include ('../class/class.secciones.php');

//Incluye el lenguaje.
include ('inc/lang/es/lang_grupos.php');

//Define las variables que usaremos a lo largo del archivo.
$action = $_GET['action']; //Esta variable es la acción que ejecutaremos (sacada de la url)
$productos = new Productos(); //Instanciamos la clase productos
$grupos = new Grupos(); //Instanciamos la clase grupos
$secciones = new Secciones(); //Instanciamos la clase productos

$contenido = ""; //Variable del contenido que se desplegara en el template

$base_file = basename(__FILE__);// nombre de este archivo


switch($action) {

/***************************************************************************
 * Este bloque se encarga de agregar un nuevo grupo.
 ***************************************************************************/
	case 'add':
	//La opción del menu queda seleccionada
	$submenu_selected2 = " class='submenu_selected'";
	
	$mensaje = "";
	$id=0;

if($_POST['nombre']){ // si existe data de nombre
	$foto = null;
	$foto2 = null;
	//echo "nombre ". $_FILES['foto']['name'];
	if($_FILES['foto']['name']!=""){//capturando el archivo (foto)
		$foto = $_FILES['foto'];		
	}
	if($_FILES['foto2']['name']!=""){//capturando el archivo (foto)
		$foto2 = $_FILES['foto2'];		
	}
	
	
	
	if($_POST['edit']){// Si es editar
		
		$productos->update_grupos($_POST['edit'], $_POST['id_categorias'], $_POST['id_padres'], $_POST['nombre'], $_POST['nombre_en'], $_POST['descripcion'],  $_POST['descripcion_en'], $foto, $foto2, $_POST['pos']);
		$mensaje = "El grupo <strong>". $_POST['nombre']. "</strong> se ha editado exitosamente";
		$last_group_id = $_POST['edit'] ;

	}
	else{// si es insertar

		$productos->insert_grupos($_POST['id_categorias'], $_POST['id_padres'], $_POST['nombre'], $_POST['nombre_en'], $_POST['descripcion'], $_POST['descripcion_en'], $foto, $foto2, $_POST['pos']);
		$mensaje = "El grupo <strong>". $_POST['nombre']. "</strong> se ha agregado exitosamente";
		$last_group_id = $productos->last_group_id ;
		
	}

	##### PROCESAMIENTO DE SECCIONES ####
		//echo '<pre>SALIDA:<br />',var_dump($_FILES),'</pre>';

	if( isset($_POST['titulo_secciones']) ) {
	
		$comita = '' ;
		foreach($_POST['titulo_secciones'] as $k => $v) {

			$_FILES['foto1_secciones'] = isset($_FILES['foto1_secciones']) ? $_FILES['foto1_secciones'] : null  ;		
			$_FILES['foto2_secciones'] = isset($_FILES['foto2_secciones']) ? $_FILES['foto2_secciones'] : null  ;		
			$_FILES['foto1_secciones_en'] = isset($_FILES['foto1_secciones_en']) ? $_FILES['foto1_secciones_en'] : null  ;		
			$_FILES['foto2_secciones_en'] = isset($_FILES['foto2_secciones_en']) ? $_FILES['foto2_secciones_en'] : null  ;		
		
			if ( $_POST['titulo_secciones'][$k] or $_POST['titulo_secciones_en'][$k] ) {
				if ( $_POST['id_secciones'][$k] ) {
					$secciones->updateSecciones($_POST['id_secciones'][$k], $last_group_id, $_POST['tipo_secciones'][$k], $_POST['titulo_secciones'][$k], $_POST['descripcion_secciones'][$k], $_FILES['foto1_secciones'], $_FILES['foto2_secciones'],$_POST['titulo_secciones_en'][$k], $_POST['descripcion_secciones_en'][$k], $_FILES['foto1_secciones_en'], $_FILES['foto2_secciones_en'], $k);
				} else { 
					$secciones->insertSecciones($last_group_id, $_POST['tipo_secciones'][$k], $_POST['titulo_secciones'][$k], $_POST['descripcion_secciones'][$k], $_FILES['foto1_secciones'], $_FILES['foto2_secciones'],$_POST['titulo_secciones_en'][$k], $_POST['descripcion_secciones_en'][$k], $_FILES['foto1_secciones_en'], $_FILES['foto2_secciones_en'], $k);
				} 
			}
			
			$seccKeepList .= $comita . $secciones->last_secciones_id ;
			$comita = ',' ;
		
		}
		
		$secciones->keepTheseSecciones ( $last_group_id, $seccKeepList );
	
	} else { 

			$secciones->keepTheseSecciones ( $last_group_id, '0' );
	
	}

	##### PROCESAMIENTO DE SECCIONES ####

	// echo '<pre>SALIDA:<br />',var_dump($_POST),'</pre>';
	// header("LOCATION: ". $base_file);//lamando a si mismo, para limpiar la url (parametros)
}

//para eliminar el grupo
if($_GET['idf'] and $_GET['nombre'] and $_GET['archivo']){
	$id = $_GET['idf'];
	$nombre = $_GET['nombre'];
	$archivo = $_GET['archivo'];
	
	if( strpos($nombre,'_secciones')!==false ) {
		$secciones->deleteFoto($id, $nombre, $archivo);	//eliminando
	} else {
		$productos->deleteFoto($id, $nombre, $archivo);	//eliminando
	}
	
}

$titulo = "Agregar Grupos:";

//si existe el id para editar
if($_GET['id']){
	$id = $_GET['id'];
	//$grupo = $productos->getGrupos($id,null, true); //consiguiendo la informacion de este grupo
	$grupo = $productos->getGrupoHijo($id); //consiguiendo la informacion de este grupo
	$cat = $productos->getCategoriasGrupos($id, "grupos");	//consiguiendo la categoria de este grupo
	$titulo = "Editar Grupos:";	
	$mensaje = "Editando a: <strong>". $grupo[0]['nombre_grupos']."</strong>";
}

$categorias = $productos->getAllCategorias();//Todas las categorias
$allGrupo = $productos->getAllGrupos(); //Todos lo grupos
$padres = $productos->getAllGrupos(); //todos lo grupos, padres

/*
Contenido del formulario de la categia, usado para añadir o editar categoria
*/

$idGrupoPadre = $grupo[0]['id_grupos_padres'] ?  $grupo[0]['id_grupos_padres'] : 0 ;

$texto_descripcion = str_replace("\r\n",'',$grupo[0]['descripcion_grupos']);
$texto_descripcion_en = str_replace("\r\n",'',$grupo[0]['descripcion_grupos_en']);

$repeatEditLink = $id ? "&amp;id={$id}" : '' ;


//javasript
$contenido .='
<script type="text/javascript" src="js/generar_secciones.js"></script>


	<script language="javascript">
	function MostrarCampos(lang){
		cotejoEs = document.getElementById("checkEspanol").checked;
		cotejoEn = document.getElementById("checkIngles").checked;
		campoEs = document.getElementById("showEspanol");
		campoEn = document.getElementById("showIngles");
		
		if(lang=="espanol"){
			campoEs.style.display = (cotejoEs)?"":"none";
		}
		else if(lang=="ingles"){
			campoEn.style.display = (cotejoEn)?"":"none";
		}		
	}
	</script>
';
//fin de javascript


$contenido .= <<<Cont

<script type="text/javascript">
function loadGroups(id_categorias, id_grupos) \{
	jQuery('#gruposDisponibles').html('<img src="images/loading.gif" style="height:20px;" />');
	jQuery.get('controls/select_grupos.php', \{ 'idc' : id_categorias , 'idg' : id_grupos } , 
	function(data,text) \{
		jQuery('#gruposDisponibles').html(data);
	});
}

jQuery(function() \{
	loadGroups(  jQuery('#id_categorias').val() , {$idGrupoPadre} );
});
</script >


<form action="{$base_file}?action=add{$repeatEditLink}" method="post" enctype="multipart/form-data">
      <table width="700" border="0" cellspacing="0" cellpadding="5" class="fondoTabla">
        <tr>
          <td colspan="2" align="left"><span class="cabecera">{$titulo}</span></td>
        </tr>
        <tr>
          <td colspan="2" align="left">{$mensaje}</td>
        </tr>
        <tr>
          <td colspan="2" align="left">&nbsp;</td>
        </tr>
		
		<!-- *******************************************************
		****************** Campos que iran en español **************
		*******************************************************  -->
		
		<tr style="background:#ACC04F;"><td colspan="2"><input type="checkbox" name="checkEspanol" id="checkEspanol" onclick="MostrarCampos('espanol');" />{$lang['ver_espanol']}</td></tr>


		<tr><td colspan=2><table id="showEspanol" style="display:none;">
		
        <tr>
          <td align="right"><span class="style4"><strong>{$lang['nombre']}:</strong></span></td>
      <td><label>
        <input type="text" name="nombre" id="nombre" class="NombreWidth" value="{$grupo[0]['nombre_grupos']}" style="width:250px;" />
        </label></td>
    </tr>
        <tr>
          <td align="right"><span class="style4"><strong>{$lang['descripcion']}:</strong></span></td>
          <td class="td_wysiwyg"><label>
	
	<textarea name="descripcion" id="descripcion" cols="45" rows="5">{$texto_descripcion}</textarea>
          </label></td>
    </tr>         
Cont;

 $contenido .= '
		</table></td></tr>
		<!-- *******************************************************
		************ Fin de Campos que iran en español *************
		*******************************************************  -->
				
		<tr style="background:#ACC04F;"><td colspan="2"><input type="checkbox" name="checkIngles" id="checkIngles" onclick="MostrarCampos(\'ingles\');"  />'. $lang['ver_ingles'].'</td></tr>
		
		<!-- *******************************************************
		****************** Campos que iran en ingles **************
		*******************************************************  -->
		
		<tr><td colspan=2><table id="showIngles" style="display:none;">
		
        <tr>
          <td align="right"><span class="style4"><strong>'. $lang['nombre'].'</strong></span></td>
      <td><label>
        <input type="text" name="nombre_en" id="nombre_en" class="NombreWidth" value="'. $grupo[0]['nombre_grupos_en']. '" style="width:250px;" />
        </label></td>
    </tr>
        <tr>
          <td align="right"><span class="style4"><strong>'. $lang['descripcion']. ':</strong></span></td>
          <td class="td_wysiwyg"><label>

	
	<textarea name="descripcion_en" id="descripcion_en" cols="45" rows="5">'. $texto_descripcion_en. '</textarea>
	 
          </label></td>
    </tr></table></td></tr>
	<!-- *******************************************************
	************ Fin de Campos que iran en ingles *************
	*******************************************************  -->';

$contenido .= <<<Cont

        <tr>
          <td align="right"><strong>{$lang['categoria']}:</strong></td>
      <td><label>
        <select name="id_categorias" id="id_categorias" 
				onchange='loadGroups(this.value, {$idGrupoPadre} )'>         
		 <option value="0">Ninguno</option>
Cont;
//Generando el select de todas las categorias

		if($categorias){	
			$select = "";		
			foreach($categorias as $data){
				if($cat){
					foreach($cat as $c){
						if($data['id_categorias']== $c['id_categorias']){
							$select = "selected=\"selected\"";
							break;
						}
						else{
							$select = "";
						}
					} // fin de c
				}// fin de cat
				
				$contenido .= "<option $select value=\"". $data['id_categorias']."\">". $data['nombre_categorias']. "</option>";
			
			}//fin de data
		}//fin de categorias

//continuando con el formulario

$contenido .= <<<Cont

        </select>         
      </label></td>
    </tr>
        <tr>
          <td align="right"><strong>{$lang['grupo']}:</strong></td>
          <td><label>
		  	<div id="gruposDisponibles">
            <select name="id_padres" id="id_padres">
              <option value='0' selected='selected'>Ninguno</option>
			  
Cont;
//Lista de los grupos padres

			if($padres){			
				foreach($padres as $data){
					if($data['id_grupos']== $grupo[0]['id_grupos_padres']){
						$contenido .= "<option value='". $data['id_grupos']."' selected='selected'>". $data['nombre_grupos']. "</option>";
					}
					else{
						$contenido .= "<option value='". $data['id_grupos']."'>". $data['nombre_grupos']. "</option>";
					}
				}//fin de data
			}//fin de padres

$texto_descripcion = str_replace("\r\n",'',$grupo[0]['descripcion_grupos']);

//continuando con el formulario	
$contenido .= <<<Cont

          </select>
		  </div>
          </label></td>
        </tr>
         <tr>
          <td align="right"><strong>Posicion:</strong></td>
          <td><label>
            <input name="pos" type="text" id="pos" value="{$grupo[0]['pos_grupos']}" size="10" />
          </label></td>
        </tr>
        <tr>
          <td align="right"><strong>Foto Espa&ntilde;ol</strong></td>
          <td>
Cont;

		// si existe foto, poner susu acciones (eliminar o ver)
		if($grupo[0]['foto_grupos']){
			$contenido .= "<a href='../images/grupos/". $grupo[0]['foto_grupos']. "'>Ver</a> 
			<a href='?action=add&id=$id&idf=$id&nombre=foto_grupos&archivo=". $grupo[0]['foto_grupos']. "'> Eliminar </a>";
		}
		else{
				
			$contenido .= '
			<label>
			<input type="file" name="foto" id="foto" />
			</label>';
		}

//continuando con el formulario	
	$contenido .= <<<Cont
    </td>
        </tr>
        <tr>
          <td align="right"><strong>Foto Ingl&eacute;s</strong></td>
          <td>
Cont;

		// si existe foto, poner susu acciones (eliminar o ver)
		if($grupo[0]['foto2_grupos']){
			$contenido .= "<a href='../images/grupos/". $grupo[0]['foto2_grupos']. "'>Ver</a> 
			<a href='?action=add&id={$id}&idf={$id}&nombre=foto2_grupos&archivo=". $grupo[0]['foto2_grupos']. "'> Eliminar </a>";
		}
		else{
				
			$contenido .= '
			<label>
			<input type="file" name="foto2" id="foto2" />
			</label>';
		}

	$contenido .= '
    </td>
        </tr>

        <tr>
		<td colspan="2" style="border:thin solid black;" id="AreaDeSecciones"> Area de Secciones
		<a class="AgregarCampos">[Agregar Campos]</a> <br /> <br />
		
		';


##### AREA DE SECCIONES #####

	$lista_secciones = $secciones->selectSeccionesByGrupo($id) ;

	$ii_sec = 0;

	function componenteFile( $nID, $nCampo, $nRuta, $nArchivo, $nIndice) {
		global $id;
		
		return
			($nArchivo
			?
			"<a href='{$nRuta}{$nArchivo}'>Ver</a> 
			 <a href='?action=add&id={$id}&idf={$nID}&nombre={$nCampo}&archivo={$nArchivo}'
			    onclick='return window.confirm(\"Esta seguro?\")' >Eliminar</a>"
			:
			"<input type='file' name='{$nCampo}[{$nIndice}]' id='{$nCampo}[{$nIndice}]' /> "
			) /* . $nArchivo */ ;
	}


	if($lista_secciones) {
	foreach($lista_secciones as $llave => $dat_sec ) {

	$showSec = $dat_sec ;
	
	if ($showSec) {
		$id_secciones = $showSec['id_secciones'] ; 
		$id_grupos = $showSec['id_grupos'] ; 
		$tipo_secciones = $showSec['tipo_secciones'] ; 
		
		$titulo_secciones = $showSec['titulo_secciones'] ; 
		$descripcion_secciones = $showSec['descripcion_secciones'] ; 
		$foto1_secciones = $showSec['foto1_secciones'] ; 
		$foto2_secciones = $showSec['foto2_secciones'] ; 
		
		$titulo_secciones_en = $showSec['titulo_secciones_en'] ; 
		$descripcion_secciones_en = $showSec['descripcion_secciones_en'] ; 
		$foto1_secciones_en = $showSec['foto1_secciones_en'] ; 
		$foto2_secciones_en = $showSec['foto2_secciones_en'] ; 
	} else {
		$id_secciones = $id_grupos = $tipo_secciones =
		$titulo_secciones = $descripcion_secciones = $foto1_secciones = $foto2_secciones =
		$titulo_secciones_en = $descripcion_secciones_en = $foto1_secciones_en = $foto2_secciones_en = '' ;
		$tipo_secciones = '1' ;
	}
	$sec_opt_a = $tipo_secciones==1 ? ' selected="selected" ' : '' ;
	$sec_opt_b = $tipo_secciones==2 ? ' selected="selected" ' : '' ;
	$sec_opt_c = $tipo_secciones==3 ? ' selected="selected" ' : '' ;
	$sec_opt_d = $tipo_secciones==4 ? ' selected="selected" ' : '' ;


	$seccImgRut = '../images/secciones/' ;
	$fileFoto1SeccionesES = componenteFile( $id_secciones, 'foto1_secciones', $seccImgRut, $foto1_secciones, $ii_sec) ;
	$fileFoto2SeccionesES = componenteFile( $id_secciones, 'foto2_secciones', $seccImgRut, $foto2_secciones, $ii_sec) ;
	$fileFoto1SeccionesEN = componenteFile( $id_secciones, 'foto1_secciones_en', $seccImgRut, $foto1_secciones_en, $ii_sec) ;
	$fileFoto2SeccionesEN = componenteFile( $id_secciones, 'foto2_secciones_en', $seccImgRut, $foto2_secciones_en, $ii_sec) ;

	$contenido .= "
		
		 	  <!-- INICIO SECCIONES -->

<div class='SeccionChavon'>
  <input type='hidden' name='id_secciones[{$ii_sec}]' id='id_secciones' value='{$id_secciones}' />
  Tipo de Sección: 
  <select name='tipo_secciones[{$ii_sec}]' id='tipo_secciones'>
  <option value='1' {$sec_opt_a} >A</option>
  <option value='2' {$sec_opt_b} >B</option>
  <option value='3' {$sec_opt_c} >C</option>
  <option value='4' {$sec_opt_d} >D</option>
  </select> <a href='javascript:void(0);' onclick='eliminarCampos(this);' class='EliminarCampos'>[Eliminar Seccion] </a><br />

<div>
  <label>
  Título Español:
  <input type='text' name='titulo_secciones[{$ii_sec}]' id='titulo_secciones'  value='{$titulo_secciones}' />
  </label>
   <a href='javascript:void(0);' onclick='jQuery(this).parent().next().toggle();'>Ver más</a><br />
</div><div style='display:none;'>
  Descripción:<br />
  <label>
  <textarea name='descripcion_secciones[{$ii_sec}]' id='descripcion_secciones' cols='45' rows='5'>{$descripcion_secciones}</textarea>
  </label>
  <br />
Foto1: 
<label>
{$fileFoto1SeccionesES}
</label>
<br />
Foto2:
<label>
{$fileFoto2SeccionesES}
</label>
<br />
<br />
</div>

<div>
  <label>
  Título Ingles:
  <input type='text' name='titulo_secciones_en[{$ii_sec}]' id='titulo_secciones_en' value='{$titulo_secciones_en}'  />
  </label>
   <a href='javascript:void(0);' onclick='jQuery(this).parent().next().toggle();'>Ver más</a><br />
</div><div style='display:none;'>
  Descripción:<br />
  <label>
  <textarea name='descripcion_secciones_en[{$ii_sec}]' id='descripcion_secciones_en' cols='45' rows='5'>{$descripcion_secciones_en}</textarea>
  </label>
  <br />
Foto1: 
<label>
{$fileFoto1SeccionesEN}
</label>
<br />
Foto2:
<label>
{$fileFoto2SeccionesEN}
</label>
<br />
<br />
</div>

<br />
<br />
</div>

		  ";

	$ii_sec++;

} // end foreach

} // end if 

##### AREA DE SECCIONES #####


//continuando con el formulario	

	$contenido .= "

		
		</td>  <!-- FINAL SECCIONES -->
        </tr>

	<script type='text/javascript'>nextSecc = {$ii_sec} ;</script>
        <tr>
          <td>&nbsp;</td>
		  <td><label>
      ";
	  
	  // si estoy editando, enviar el id por un hidden con el nombre edit
	  if($_GET['id']){
	  		$contenido .= "<input type='hidden' name='edit' value='". $_GET['id']."' />";
	  } 
	  
	 $contenido .='  
        <input type="submit" name="insertar" id="insertar" value="Insertar" />
        </label></td>
    </tr>
      </table>
</form>';
		
	break;

/***************************************************************************
 * Este bloque se encarga de borrar un grupo.
 ***************************************************************************/
 	case 'delete':
	
		$productos->delete($_GET['id'], "grupos");
		// header("LOCATION: ". $base_file);
	
 	break;

/***************************************************************************
 * Este bloque se encarga de enlistar todos los grupos existentes.
 ***************************************************************************/
	default:

$listaCat = $grupos->getCategoriasListaGrupos();


	//La opción del menu queda seleccionada
	$submenu_selected1 = " class='submenu_selected'";

// consiguiendo todos los grupos para realizar todas las opperaciones (ver, editar y eliminar)

$allGrupo = $productos->getAllGrupos();
 
if($allGrupo){
 
	$contenido .= "<table cellspacing=\"0\" cellpadding=\"0\" width='100%'>";	

function ListarGrupos($allGrupo, $padding=5) {
	global $contenido, $productos;

		foreach($allGrupo as $data){//desplegando los grupos
			if($data['foto_grupos']){ //si tiene foto
				$foto = "<a href='../images/grupos/". $data['foto_grupos']. "'>Ver Foto</a>";
			}
			else{
				$foto = "Sin Foto";
			}

			$newdesc = cuttext($data['descripcion_grupos'], 150);

			$contenido .= "
			<tr>
				<td style='border-bottom:#ACC04F 1px dashed; padding-top:2px; background:#efefef; font-weight:bold; font-size:13px; padding-left:{$padding}px;' colspan='2'>". $data['nombre_grupos'] ."</td>
				<td style='border-bottom:#ACC04F 1px dashed; padding-top:2px; text-align:right; background:#efefef;'><a href='grupos.php?action=delete&amp;id=". $data['id_grupos']."'><img src='images/delete.png' alt='" . $lang['eliminar'] . "' onclick=\"return confirm('" . $lang['confirmar_eliminar'] . "');\" /></a> <a href='?action=add&amp;id=". $data['id_grupos']."'><img src='images/edit.png' alt='" . $lang['editar'] . "' /></a></td>
			</tr>
			<tr>
				<td style='border-bottom:#ACC04F 1px dashed; width:260px; padding-left:{$padding}px;'>
					<table border='0' cellpadding='0' cellspacing='0'>
						<tr>
							<td style='height:40px;'><strong>Categoria:</strong> ". $productos->getNombresCategoriasGrupos($data['id_grupos'], "categorias"). "</td>
						</tr>
						<tr>
							<td style='height:40px;'><strong>Grupo:</strong> ". $productos->getNombreGrupos($data['id_grupos_padres']). "</td>
						</tr>
					</table>
				</td>
				<td style='border-bottom:#ACC04F 1px dashed; width;350px;'>". $newdesc . "</td>
				<td style='border-bottom:#ACC04F 1px dashed; width:80px; text-align:right;'>". $foto. "</td>
			</tr>";
		}

		if($data['sub']) {
			ListarGrupos($data['sub'], $padding+25) ;
		}

} 



$listaCat = $grupos->getCategoriasListaGrupos();
if($listaCat) {
	foreach($listaCat as $data) {
		$contenido .= "<tr>
				<td style='border-bottom:#393939 1px dashed; padding-top:2px; background:#ACC04F; font-weight:bold; font-size:13px; padding-left:{$padding}px;' colspan='3'><a href='?mostrar={$data['id_categorias']}' style='text-decoration:none; font-size:13px; color:#393939;'> {$data['nombre_categorias']}</a>
						</td></tr>";
		if( isset($_GET['mostrar']) and $data['id_categorias']==$_GET['mostrar'] ) {
			ListarGrupos( $grupos->getRecursionGrupos($_GET['mostrar']) ) ;
		}
	}
}



	  
	  $contenido .= "</table>";
	  
}
else{	
	$contenido .= "No existe ningun grupo";
}

	break;
}// fin de grupo

//menu de panel derecho
$menu_izquierda = "
<li{$submenu_selected1}><a href='{$base_file}'>" . $lang['lista_grupos'] . "</a></li>
<li{$submenu_selected2}><a href='{$base_file}?action=add'>" . $lang['nuevo_grupo'] . "</a></li>";

//Incluiremos el template que mostrará toda la vista.
include('inc/template.php');

?>