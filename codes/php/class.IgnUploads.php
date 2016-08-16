<?php
class IgnUploads {
	
	//Sube la foto y retorna el nombre nuevo
	// ** NOTA: "keyId" se usa para pasar el indice
	//			 si es una matriz de controles
	function upload( $control_name , $path , $keyId = null ) {
		
		if( $keyId===null ) {
			$tmp_name = $_FILES[$control_name]['tmp_name'] ;
			$old_filename = $_FILES[$control_name]['name'] ;
		} else {
			$tmp_name = $_FILES[$control_name]['tmp_name'][$keyId] ;
			$old_filename = $_FILES[$control_name]['name'][$keyId] ;
		}


		$name_parts = explode('.',$old_filename);
		$real_extension = strtolower( $name_parts[ count($name_parts)-1 ] );
		
		if( in_array( $real_extension , 
		array('jpg','gif','png','bmp') ) ) {
			$db_path = $path.'/'.uniqid().'.'.$real_extension ;
			$host_path =  dirname(__FILE__).'/../'.$db_path ;
			move_uploaded_file($tmp_name, $host_path);
			return $db_path ;
		} else {
			return null ;
		}
		
	}

}
?>