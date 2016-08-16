<?php
    
/**
*
* un experimiento para conseguir organizar un menu sin recursividad.
* creo que la solucion puede ser "Variable variables"
* Esto esta pendiente de ser terminado
*
*/
    
    
    $ejemplo = array (
        array('parent'=>'a','id'=>'b'),
        array('parent'=>'0','id'=>'a'),
        array('parent'=>'b','id'=>'c'),
        array('parent'=>'d','id'=>'e'),
        array('parent'=>'0','id'=>'d'),
        array('parent'=>'e','id'=>'f'),
    );
        
    
    $real_tree = array();
    $temp_tree = array();
    
    foreach($ejemplo as $elemento) {
        $px_id = $elemento['parent'] ;
        $ex_id = $elemento['id'] ;
        echo "<div>{$px_id} -> {$ex_id}</div>" ;
        
        //$ex_list[$px_id]['n'] = $px_id ;
        //$ex_list[$px_id]['*'][$ex_id]['n'] = $ex_id ;



        // si hay referencia del padre...
        
        if( isset($refs[$px_id]) ) {

            if(!isset($refs[$ex_id])) {   // si no existe referencia del hijo, crealo
                
                $refs[$px_id]['*'][$ex_id]['n'] = $ex_id ;
                $refs[$ex_id] = $refs[$px_id]['*'][$ex_id]['n'] ;
                
            }

            $refs[$px_id]['*'][$ex_id] = $ex_list[$ex_id] ; //crea hijo en padre

        } else {
            
            $real_tree[$px_id]['n'] = $px_id ;  //crea padre
            
            $refs[$px_id] =  &$real_tree[$px_id] ; //guarda referencia padre
        }

        
        // si hay referencia del hijo...

        if( isset($refs[$ex_id]) ) {

            if(!isset($ex_list[$px_id]))   // si no existe el padre, crealo
                $ex_list[$px_id]['n'] = $px_id ; 
                
            $ex_list[$px_id]['*'][$ex_id] = $refs[$ex_id] ;  //crea hijo en padre

        } else {

            $real_tree[$px_id]['*'][$ex_id]['n'] = $ex_id ;  //crea hijo en padre

            $refs[$ex_id] = &$real_tree[$px_id]['*'][$ex_id] ; //guarda referencia hijo
        }
        
    }
    
    
    echo '$ejemplo='.count($ejemplo)."<br />";


echo '<pre style="position:relative; z-index:255; color:black; background:white;"><b>',
     urldecode('%24refs') , ':</b>',
     var_dump($refs), '</pre>'; ;



/////////////////////////// UNCLEANED ARRAY ////////////////////////////////////

    //foreach($ejemplo as $elemento) {
    //    $px_id = $elemento['parent'] ;
    //    $ex_id = $elemento['id'] ;
    //    echo "<div>{$px_id} -> {$ex_id}</div>" ;
    //    
    //    //$ex_list[$px_id]['n'] = $px_id ;
    //    //$ex_list[$px_id]['*'][$ex_id]['n'] = $ex_id ;
    //
    //
    //
    //    // si hay referencia del padre...
    //    
    //    if( isset($refs[$px_id]) ) {
    //
    //        if(!isset($ex_list[$ex_id]))   // si no existe el hijo, crealo
    //            $ex_list[$ex_id]['n'] = $ex_id ; 
    //
    //        $refs[$px_id]['*'][$ex_id] = $ex_list[$ex_id] ; //crea hijo en padre
    //
    //    } else {
    //        
    //        $ex_list[$px_id]['n'] = $px_id ;  //crea padre
    //        
    //        $refs[$px_id] =  &$ex_list[$px_id] ; //guarda referencia padre
    //    }
    //
    //    
    //    // si hay referencia del hijo...
    //
    //    if( isset($refs[$ex_id]) ) {
    //
    //        if(!isset($ex_list[$px_id]))   // si no existe el padre, crealo
    //            $ex_list[$px_id]['n'] = $px_id ; 
    //            
    //        $ex_list[$px_id]['*'][$ex_id] = $refs[$ex_id] ;  //crea hijo en padre
    //
    //    } else {
    //
    //        $ex_list[$px_id]['*'][$ex_id]['n'] = $ex_id ;  //crea hijo en padre
    //
    //        $refs[$ex_id] = &$ex_list[$px_id]['*'][$ex_id] ; //guarda referencia hijo
    //    }
    //    
    //}
    //




/////////////////////////// PREVIOUS PROGRAM ////////////////////////////////////

    /*

    $result = $sections->get();


    $elements = array();
    $refs = array();
    foreach($result as $anElement) {
        $section_name1 =  $anElement['label'] ;
        $section_id1 =  $anElement['SectionID'] ;
        $parent_id1 =  $anElement['ParentID'] ;

        $elements[$section_id1]['name'] = $section_name1 ;
        $elements[$parent_id1]['childs'][$section_id1] =  &$elements[$section_id1] ;


        if( isset($refs[$section_id1]) ) {
            // pass 
        } else {
            $refs[$section_id1] = 1 ;//&$elements[$section_id1] ;
        }

        if( isset($refs[$parent_id1]) ) {
            // pass
        } else {
            $refs[$parent_id1] = 1;//&$elements[$parent_id1] ;
        }

    }
    
    

    echo "ii_1=".$ii_b."<br />";
    echo "results=".count($result)."<br />";
    echo "elements=".count($elements)."<br />";
    echo "refs=".count($refs)."<br />";
    

    echo '<pre style="position:relative; z-index:255; color:black; background:white;"><b>',
         urldecode('%24result') , ':</b>',
         var_dump($refs), '</pre>'; ;    
    
    */
    
    
    
    
?>