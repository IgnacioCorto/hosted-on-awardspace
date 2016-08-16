<?php 
/***************************************************************************
 *                               class.editor.php
 *                            -------------------
 *   copyright            : (C) 2008, comuniQue
 *   email                : soporte@comunique.com.do
 *   description          : Clase del módulo "Editor de Contenido"
 *   author               : Rafael Villavizar
 *
 ***************************************************************************/

/***************************************************************************
 *
 *   Este archivo es de uso exclusivo de comuniQue para sus clientes. La
 *   reproducción y/o distribución parcial o total de este archivo sin
 *   permiso de comuniQue o sus representantes está prohibida.
 *
 ***************************************************************************
 *
 *   This file is for exclusive use of comuniQue to its clients. The
 *   total or parcial reproduction and/or distribution of this file
 *   without permission from comuniQue or its representants is prohibited.
 *
 ***************************************************************************/

// Realizamos la conexión con la base de datos 
require_once('inc/cConnection.php');

// Nombre de la clase
class Editor{ 
	
	// Variable para la paginación
	var $items_per_page;
	
	// Constructor de la clase, este inicializa la conexion a la base de datos
	function Editor(){				
		$this->conn = new cConnection(PHP_DB,PHP_DB_IP,PHP_DB_USER,PHP_DB_PASS); // estableciendo la conexion*/
	}
	
	/*******************************************************************************************************
						Todas las funciones para inserción de registro del módulo (INSERT)
	*******************************************************************************************************/
	
	// Para insertar módulo
	function insert_editor($nombre, $categoria, $grupo, $descripcion, $posicion, $estado, $foto1, $foto2, $foto3, $foto4, $foto5, $foto6, $foto7, $foto8, $foto9, $foto10, $foto11, $foto12, $foto13, $foto14, $foto15, $foto16, $url_video){		
		
		//Query		
		$insert = "INSERT INTO editor (nombre, categoria, grupos, descripcion, posicion, estado, url_video) VALUES ('$nombre', '$categoria', '$grupo', '$descripcion', '$posicion', '$estado' , '$url_video' ) ";			
				
		$id = $this->conn->insert($insert);		
		$path = "../images/editor/";
		$insert2 .= "UPDATE editor SET";
		$status = false;
		
		//si existe fotos, la sube y la inserta a la base de datos, else no hara nada
		if($foto1) { 
			$extension = explode("/", $foto1['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_1.". $ext;		
			$this->upload($foto1, $path, $fotou);			
			$insert2 .= " foto1 = '$fotou',"; 	
			$status = true;			
		}	
		if($foto2) { 
			$extension = explode("/", $foto2['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_2.". $ext;			
			$this->upload($foto2, $path, $fotou);			
			$insert2 .= " foto2= '$fotou',"; 
			$status = true;					
		}
		if($foto3) { 
			$extension = explode("/", $foto3['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_3.". $ext;				
			$this->upload($foto3, $path, $fotou);			
			$insert2 .= " foto3 = '$fotou',"; 	
			$status = true;				
		}
		if($foto4) { 
			$extension = explode("/", $foto4['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_4.". $ext;			
			$this->upload($foto4, $path, $fotou);			
			$insert2 .= " foto4 = '$fotou',"; 
			$status = true;					
		}
		if($foto5) { 
			$extension = explode("/", $foto5['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_5.". $ext;			
			$this->upload($foto5, $path, $fotou);			
			$insert2 .= " foto5 = '$fotou',"; 
			$status = true;					
		}	

        // INICIO MULTIMEDIA
        
		if($foto6) { 
			$extension = explode("/", $foto6['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_6.". $ext;			
			$this->upload($foto6, $path, $fotou);			
			$insert2 .= " foto6 = '$fotou',"; 
			$status = true;					
		}	
        
		if($foto7) { 
			$extension = explode("/", $foto7['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_7.". $ext;			
			$this->upload($foto7, $path, $fotou);			
			$insert2 .= " foto7 = '$fotou',"; 
			$status = true;					
		}	
        
		if($foto8) { 
			$extension = explode("/", $foto8['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_8.". $ext;			
			$this->upload($foto8, $path, $fotou);			
			$insert2 .= " foto8 = '$fotou',"; 
			$status = true;					
		}	
        
		if($foto9) { 
			$extension = explode("/", $foto9['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_9.". $ext;			
			$this->upload($foto9, $path, $fotou);			
			$insert2 .= " foto9 = '$fotou',"; 
			$status = true;					
		}	
        
		if($foto10) { 
			$extension = explode("/", $foto10['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_10.". $ext;			
			$this->upload($foto10, $path, $fotou);			
			$insert2 .= " foto10 = '$fotou',"; 
			$status = true;					
		}	

		if($foto11) { 
			$extension = explode("/", $foto11['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_11.". $ext;			
			$this->upload($foto11, $path, $fotou);			
			$insert2 .= " foto11 = '$fotou',"; 
			$status = true;					
		}	
        
		if($foto12) { 
			$extension = explode("/", $foto12['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_12.". $ext;			
			$this->upload($foto11, $path, $fotou);			
			$insert2 .= " foto12 = '$fotou',"; 
			$status = true;					
		}	
        
		if($foto13) { 
			$extension = explode("/", $foto13['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_13.". $ext;			
			$this->upload($foto13, $path, $fotou);			
			$insert2 .= " foto13 = '$fotou',"; 
			$status = true;					
		}	
        
		if($foto14) { 
			$extension = explode("/", $foto14['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_14.". $ext;			
			$this->upload($foto14, $path, $fotou);			
			$insert2 .= " foto14 = '$fotou',"; 
			$status = true;					
		}	
        
		if($foto15) { 
			$extension = explode("/", $foto15['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_15.". $ext;			
			$this->upload($foto15, $path, $fotou);			
			$insert2 .= " foto15 = '$fotou',"; 
			$status = true;					
		}	
		
		if($foto16) { 
			$extension = explode("/", $foto16['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_16.". $ext;			
			$this->upload($foto16, $path, $fotou);			
			$insert2 .= " foto16 = '$fotou',"; 
			$status = true;					
		}	
        
        // FINAL  MULTIMEDIA

		$insert2 = substr ($insert2, 0, -1);
		$insert2 .= " WHERE id_editor = $id";
		// si existe la foto o la subio, ejecuta el query		
		if($status){
			$this->conn->runQuery($insert2);	
		}
		return $id;
		
	}

	/*******************************************************************************************************
						Funciones para editar el objeto del módulo (UPDATE)
	*******************************************************************************************************/
	
	// Para actualizar un modulo
	function update_editor($id_editor, $nombre, $categoria, $grupo, $descripcion, $posicion, $estado, $foto1, $foto2, $foto3, $foto4, $foto5, $foto6, $foto7, $foto8, $foto9, $foto10, $foto11, $foto12, $foto13, $foto14, $foto15, $foto16){	

		// Query
		$update = "UPDATE editor SET nombre = '$nombre', categoria = '$categoria', grupos = '$grupo', descripcion = '$descripcion', posicion = '$posicion', estado = '$estado' WHERE id_editor = $id_editor";		
		$this->conn->runQuery($update);
		
		$path = "../images/editor/";
		$insert2 .= "UPDATE editor SET";
		$id = $id_editor;

		$estado = false;
		
		if($foto1) { 
			$extension = explode("/", $foto1['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_1.". $ext;			
			$this->upload($foto1, $path, $fotou);			
			$insert2 .= " foto1 = '$fotou',"; 	
			$estado = true;			
		}	
		if($foto2) { 
			$extension = explode("/", $foto2['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_2.". $ext;		
			$this->upload($foto2, $path, $fotou);			
			$insert2 .= " foto2 = '$fotou',";
			$estado = true;	 				
		}
		if($foto3) { 
			$extension = explode("/", $foto3['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_3.". $ext;		
			$this->upload($foto3, $path, $fotou);			
			$insert2 .= " foto3 = '$fotou',"; 	
			$estado = true;				
		}
		if($foto4) { 
			$extension = explode("/", $foto4['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_4.". $ext;	
			$this->upload($foto4, $path, $fotou);			
			$insert2 .= " foto4 = '$fotou',"; 	
			$estado = true;				
		}
		if($foto5) { 
			$extension = explode("/", $foto5['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_5.". $ext;	
			$this->upload($foto5, $path, $fotou);			
			$insert2 .= " foto5 = '$fotou',"; 	
			$estado = true;				
		}

        // INICIO MULTIMEDIA
        
		if($foto6) { 
			$extension = explode("/", $foto6['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_6.". $ext;			
			$this->upload($foto6, $path, $fotou);			
			$insert2 .= " foto6 = '$fotou',"; 
			$estado = true;					
		}	
        
		if($foto7) { 
			$extension = explode("/", $foto7['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_7.". $ext;			
			$this->upload($foto7, $path, $fotou);			
			$insert2 .= " foto7 = '$fotou',"; 
			$estado = true;					
		}	
        
		if($foto8) { 
			$extension = explode("/", $foto8['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_8.". $ext;			
			$this->upload($foto8, $path, $fotou);			
			$insert2 .= " foto8 = '$fotou',"; 
			$estado = true;					
		}	
        
		if($foto9) { 
			$extension = explode("/", $foto9['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_9.". $ext;			
			$this->upload($foto9, $path, $fotou);			
			$insert2 .= " foto9 = '$fotou',"; 
			$estado = true;					
		}	
        
		if($foto10) { 
			$extension = explode("/", $foto10['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_10.". $ext;			
			$this->upload($foto10, $path, $fotou);			
			$insert2 .= " foto10 = '$fotou',"; 
			$estado = true;					
		}	
		
		if($foto11) { 
			$extension = explode("/", $foto11['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_11.". $ext;			
			$this->upload($foto11, $path, $fotou);			
			$insert2 .= " foto11 = '$fotou',"; 
			$estado = true;					
		}	
        
		if($foto12) { 
			$extension = explode("/", $foto12['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_12.". $ext;			
			$this->upload($foto12, $path, $fotou);			
			$insert2 .= " foto12 = '$fotou',"; 
			$estado = true;					
		}	
        
		if($foto13) { 
			$extension = explode("/", $foto13['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_13.". $ext;			
			$this->upload($foto13, $path, $fotou);			
			$insert2 .= " foto13 = '$fotou',"; 
			$estado = true;					
		}	
        
		if($foto14) { 
			$extension = explode("/", $foto14['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_14.". $ext;			
			$this->upload($foto14, $path, $fotou);			
			$insert2 .= " foto14 = '$fotou',"; 
			$estado = true;					
		}	
        
		if($foto15) { 
			$extension = explode("/", $foto15['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_15.". $ext;			
			$this->upload($foto15, $path, $fotou);			
			$insert2 .= " foto15 = '$fotou',"; 
			$estado = true;					
		}	
		
		if($foto16) { 
			$extension = explode("/", $foto16['type']);
			$ext = $extension[1];
			
			$fotou = $id. "_16.". $ext;			
			$this->upload($foto16, $path, $fotou);			
			$insert2 .= " foto16 = '$fotou',"; 
			$estado = true;					
		}	
        
        // FINAL  MULTIMEDIA

		$insert2 = substr ($insert2, 0, -1);
		$insert2 .= " WHERE id_editor = $id";
		
		if($estado){
		    //echo "    insert 2: ". $insert2;
			$this->conn->runQuery($insert2);	
		}
		
		//Lugar donde se redireccionará después de que se actualice
		
		header("LOCATION: editor.php");
		
	}
		
	/*******************************************************************************************************
						Todas las funciones para extraer o conseguir objetos del módulo (GET)
	*******************************************************************************************************/
	
	// Para conseguir un objeto del módulo
	function getEditor($id_editor){
	 	
		// Query
		$query = "SELECT * FROM  editor WHERE id_editor = $id_editor";
			
		$this->conn->runQuery($query);
		$data = $this->conn->getArray();
		
		return $data;
	}
	
	// para conseguir todos los objetos del módulo
	function getAllEditor(){
	 	
		// Query
		$query = "SELECT * FROM  editor";
			
		$this->conn->runQuery($query);
		$data = $this->conn->getArray();		
		
		return $data;
	}
	
	function getAllEditorByCategoria($id_categoria=0){
	 	
		// Query
		//$query = "SELECT * FROM editor as e INNER JOIN categorias as c ON c.id ";
		
		$query = "SELECT * FROM editor as e
					INNER JOIN categorias as c 
					ON e.categoria = c.id_categorias
					WHERE e.categoria = {$id_categoria} ";
		
			
		$this->conn->runQuery($query);
		$data = $this->conn->getArray();		
		
		return $data;
	}
	
	function getAllEditorByEventos($id_categoria=0){
	 	
		// Query
		//$query = "SELECT * FROM editor as e INNER JOIN categorias as c ON c.id ";
		
		$query = "SELECT * FROM editor as e
					INNER JOIN categorias as c 
					ON e.categoria = c.id_categorias
					WHERE e.categoria = {$id_categoria} 
					ORDER BY id_editor
					DESC";
		
			
		$this->conn->runQuery($query);
		$data = $this->conn->getArray();		
		
		return $data;
	}
	
	function getAllEditorByGrupo($id_grupo){
	 	
		// Query
		//$query = "SELECT * FROM  editor";
		$query = "SELECT * FROM editor as e
					INNER JOIN grupos as g 
					  ON e.grupos = g.id_grupos
					WHERE e.grupos = {$id_grupo}";

			
		$this->conn->runQuery($query);
		$data = $this->conn->getArray();		
		
		return $data;
	}
	
	
	// Cuenta la cantidad de objetos que existen.
	function countAllEditor(){
	
		// Query
		$this->conn->runQuery("SELECT * FROM editor");
		
		return $this->conn->recCount();
	}
	
	// Obtiene todas las secciones que no dependen de grupos ni de cateegorías.
	function getEditorPadre(){
	
		// Query
		$query = "SELECT * FROM editor WHERE categoria = '0' AND grupos = '0'";

		$this->conn->runQuery($query);
		$data = $this->conn->getArray();		
		
		return $data;
	}
	/*******************************************************************************************************
						funcion para subir un archivo al servidor (UPLOAD FILE)
	*******************************************************************************************************/
	// arreglo es el archivo, path es la ruta y nombre es el nombre del archivo
	function upload($arreglo, $path, $nombre){  	
						
			@unlink($path.$nombre);
			//echo $path.$id;
			if(move_uploaded_file($arreglo['tmp_name'], $path.$nombre)){					
			}
			else{
				echo 'Se produjo un error, trate de nuevo.';
			}
	} // fin de upload
	
	/*******************************************************************************************************
						Eliminar un determinado registro. (DELETE)
	*******************************************************************************************************/
	function deleteEditor($id){
	
		// Query	
		$query = "DELETE FROM editor WHERE id_editor = $id";
		$this->conn->runQuery($query);		
	}
	
	/*******************************************************************************************************
						Eliminar un determinado archivo. (DELETE)
	*******************************************************************************************************/
	function deleteFoto($id, $nombre, $archivo){
		
		$path = "images/editor/". $archivo;
		$update = "UPDATE editor SET $nombre = NULL WHERE id_editor = $id";			
		
		@unlink($path);	
			
		$this->conn->runQuery($update);			
		 
	}
	
	/*******************************************************************************************************
						Consigue la lista de todas las categorías existentes.
	*******************************************************************************************************/
	function getAllCategorias(){				
		
		//Query		
		$query = "SELECT * FROM categorias";
		$this->conn->runQuery($query);
		$data = $this->conn->getArray();
		return $data;
	}
	
	/*******************************************************************************************************
						Consigue la lista de todos los grupos existentes.
	*******************************************************************************************************/
	function getAllGrupos(){				
		
		//Query		
		$query = "SELECT * FROM grupos";
		$this->conn->runQuery($query);
		$data = $this->conn->getArray();
		return $data;
	}
}
?>