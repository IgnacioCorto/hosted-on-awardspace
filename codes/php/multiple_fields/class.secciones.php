<?php 
//include('../inc/config.php');
require_once('inc/cConnection.php');

class Secciones{ // nombre de la clase
	
	var $items_per_page;
	var $last_secciones_id;
	
	/*
		Constructor de la clase, este, inicializa la conexion a la base de datos
	*/
	function Secciones(){		
		//$this->conn = new cConnection(PHP_DB,PHP_DB_IP,PHP_DB_USER,PHP_DB_PASS); // estableciendo la conexion*/
		$this->conn = new cConnection(PHP_DB,PHP_DB_IP,PHP_DB_USER,PHP_DB_PASS); // estableciendo la conexion*/
	}
	
	/*******************************************************************************************************
	                          funciones para insertar
	*******************************************************************************************************/
	
		
	// funcion para insertar categorias
	function insertSecciones($id_grupos, $tipo_secciones, 
		$titulo_secciones, $descripcion_secciones, $foto1_secciones, $foto2_secciones,
		$titulo_secciones_en, $descripcion_secciones_en, $foto1_secciones_en, $foto2_secciones_en,
		$key) {	
							
		$insert = "INSERT INTO secciones SET
		 	id_grupos = '{$id_grupos}', tipo_secciones = '{$tipo_secciones}',
		 	titulo_secciones = '{$titulo_secciones}',
		 	descripcion_secciones = '{$descripcion_secciones}',
		 	titulo_secciones_en = '{$titulo_secciones_en}',
		 	descripcion_secciones_en = '{$descripcion_secciones_en}'
			";	
		
		$id = $this->conn->insert($insert) ;	//tomando el id del ultimo registro	
		$this->last_secciones_id = $id ;
		$path = "../images/secciones/" ;

		
		// subiendo e insertando la imagen [es]	
		if($foto1_secciones['type'][$key]) { 			
			$extension = explode("/", $foto1_secciones['type'][$key]);
			$ext = $extension[1];
			$fotou = $id. "_1.". $ext;
			$this->upload($foto1_secciones, $path, $fotou, $key);			
			$insert2 = "UPDATE secciones SET foto1_secciones = '$fotou' WHERE id_secciones = $id"; 
			$this->conn->runQuery($insert2);		
		}	

		// subiendo e insertando la imagen 	[es]
		if($foto2_secciones['type'][$key]) { 			
			$extension = explode("/", $foto2_secciones['type'][$key]);
			$ext = $extension[1];
			$fotou = $id. "_2.". $ext;
			$this->upload($foto2_secciones, $path, $fotou, $key);			
			$insert2 = "UPDATE secciones SET foto2_secciones = '$fotou' WHERE id_secciones = $id"; 
			$this->conn->runQuery($insert2);		
		}	


		// subiendo e insertando la imagen 	[en]
		if($foto1_secciones_en['type'][$key]) { 			
			$extension = explode("/", $foto1_secciones_en['type'][$key]);
			$ext = $extension[1];
			$fotou = $id. "_1_en.". $ext;
			$this->upload($foto1_secciones_en, $path, $fotou, $key);			
			$insert2 = "UPDATE secciones SET foto1_secciones_en = '$fotou' WHERE id_secciones = $id"; 
			$this->conn->runQuery($insert2);		
		}	

		// subiendo e insertando la imagen 	[en]
		if($foto2_secciones_en['type'][$key]) { 			
			$extension = explode("/", $foto2_secciones_en['type'][$key]);
			$ext = $extension[1];
			$fotou = $id. "_2_en.". $ext;
			$this->upload($foto2_secciones_en, $path, $fotou, $key);			
			$insert2 = "UPDATE secciones SET foto2_secciones_en = '$fotou' WHERE id_secciones = $id"; 
			$this->conn->runQuery($insert2);		
		}	
		//fin de subir e insertar imagen	

	} // fin de insertar secciones
	
	
	
	// inicio de update categoria
	function updateSecciones($id_secciones, $id_grupos, $tipo_secciones,
		$titulo_secciones, $descripcion_secciones, $foto1_secciones, $foto2_secciones,
		$titulo_secciones_en, $descripcion_secciones_en, $foto1_secciones_en, $foto2_secciones_en,
		$key) {	
		
		$update = "UPDATE secciones SET
		 	id_grupos = '{$id_grupos}', tipo_secciones = '{$tipo_secciones}',
		 	titulo_secciones = '{$titulo_secciones}',
		 	descripcion_secciones = '{$descripcion_secciones}',
		 	titulo_secciones_en = '{$titulo_secciones_en}',
		 	descripcion_secciones_en = '{$descripcion_secciones_en}'
			WHERE id_secciones = {$id_secciones}
			";	

		$this->conn->runQuery($update);	
		$this->last_secciones_id = $id = $id_secciones;
		$path = "../images/secciones/";					

		// subiendo e insertando la imagen [es]	
		if($foto1_secciones['type'][$key]) { 			
			$extension = explode("/", $foto1_secciones['type'][$key]);
			$ext = $extension[1];
			$fotou = $id. "_1.". $ext;
			$this->upload($foto1_secciones, $path, $fotou, $key);			
			$insert2 = "UPDATE secciones SET foto1_secciones = '$fotou' WHERE id_secciones = $id"; 
			$this->conn->runQuery($insert2);		
		}	

		// subiendo e insertando la imagen 	[es]
		if($foto2_secciones['type'][$key]) { 			
			$extension = explode("/", $foto2_secciones['type'][$key]);
			$ext = $extension[1];
			$fotou = $id. "_2.". $ext;
			$this->upload($foto2_secciones, $path, $fotou, $key);			
			$insert2 = "UPDATE secciones SET foto2_secciones = '$fotou' WHERE id_secciones = $id"; 
			$this->conn->runQuery($insert2);		
		}	


		// subiendo e insertando la imagen 	[en]
		if($foto1_secciones_en['type'][$key]) { 			
			$extension = explode("/", $foto1_secciones_en['type'][$key]);
			$ext = $extension[1];
			$fotou = $id. "_1_en.". $ext;
			$this->upload($foto1_secciones_en, $path, $fotou, $key);			
			$insert2 = "UPDATE secciones SET foto1_secciones_en = '$fotou' WHERE id_secciones = $id"; 
			$this->conn->runQuery($insert2);		
		}	

		// subiendo e insertando la imagen 	[en]
		if($foto2_secciones_en['type'][$key]) { 			
			$extension = explode("/", $foto2_secciones_en['type'][$key]);
			$ext = $extension[1];
			$fotou = $id. "_2_en.". $ext;
			$this->upload($foto2_secciones_en, $path, $fotou, $key);			
			$insert2 = "UPDATE secciones SET foto2_secciones_en = '$fotou' WHERE id_secciones = $id"; 
			$this->conn->runQuery($insert2);		
		}	
		//fin de subir e insertar imagen	
				
	} // fin de update secciones
	
	

	function selectSecciones($id_secciones=0) {
		$id_secciones = $id_secciones ? $id_secciones : 0 ;	
		$query = "SELECT * FROM secciones WHERE id_secciones = {$id_secciones}";
		$this->conn->runQuery($query);
		$secciones = $this->conn->getArray();
		return $secciones;
	}


	function selectSeccionesByGrupo($id_grupos=0) {	
		$id_grupos = $id_grupos ? $id_grupos : 0 ;	
		$query = "SELECT * FROM secciones WHERE id_grupos = {$id_grupos} ORDER BY id_secciones ";
		$this->conn->runQuery($query);
		$secciones = $this->conn->getArray();
		return $secciones;
	}


	function keepTheseSecciones($id_grupos=0,$listaSecciones) {	
		if($id_grupos) {
			$query = "DELETE FROM secciones WHERE id_grupos = {$id_grupos} and id_secciones not in($listaSecciones)";
			$this->conn->runQuery($query);
		}
	}


		
	/*************************************
	*** fin de todos lo get o conseguir***
	**************************************/
	
	// funcion para subir un archivo al servidor
		// arreglo el el archivo, path es la ruta y id el el nombre del archivo
	function upload($arreglo, $path, $id, $key){  	
						
			@unlink($path.$id);
			//echo $path.$id;
			if(move_uploaded_file($arreglo['tmp_name'][$key], $path.$id)){					
			}
			else{
				echo 'Se produjo un error, trate de nuevo.';
			}
	} // fin de upload
			
	/***********************************************
		Elimina un determinado registro
		primer parametro: el id
		segundo parametro: nombre de la tabla
	***********************************************/
	
	function delete($id){
		$query = "DELETE FROM secciones WHERE id_secciones = $id";
		$this->conn->runQuery($query);		
	}// fin de eliminar registro
				
	function deleteFoto($id, $nombre_campo, $archivo){
		$path = "images/secciones/". $archivo;
		$update = "UPDATE secciones SET {$nombre_campo} = NULL WHERE id_secciones = $id";			
		@unlink($path);	
		$this->conn->runQuery($update);			
	}	
	
}
?>